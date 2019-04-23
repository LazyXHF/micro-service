package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.TenderService;
import com.portjs.base.util.*;
import com.portjs.base.util.Message.MessageUtils;
import com.portjs.base.util.StringUtils.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author gumingyang
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TenderServiceImpl implements TenderService {

    @Autowired
    private TenderApplicationMapper tenderApplicationMapper;
    @Autowired
    private TTodoMapper todoMapper;
    @Autowired
    private TWorkflowstepMapper workflowstepMapper;
    @Autowired
    private TXietongDictionaryMapper dictionaryMapper;
    @Autowired
    private InternalAttachmentMapper attachmentMapper;

    @Override
    public ResponseMessage queryRequests(String requestBody) throws Exception {
        JSONObject jsonObj=JSONObject.parseObject(requestBody);
        TenderApplicationVo tenderApplicationVo = JSONObject.toJavaObject(jsonObj, TenderApplicationVo.class);
        //必要值检验
        Map<String,Object> map = tenderApplicationVo.getParams();
        if(CollectionUtils.isEmpty(map)){
            return  new ResponseMessage(Code.CODE_ERROR, "参数格式传值错误");
        }
        if(null==map.get("pageSize")){
            return  new ResponseMessage(Code.CODE_ERROR, "pageSize"+MessageUtils.NOT_PASSED);
        }
        if(null==map.get("pageNo")){
            return  new ResponseMessage(Code.CODE_ERROR, "pageNo"+MessageUtils.NOT_PASSED);
        }
        //分页条件查询
        Page page=new Page();
        int count = tenderApplicationMapper.selectRequestsCount(tenderApplicationVo);
        page.init(count,Integer.valueOf(map.get("pageNo").toString()),Integer.valueOf(map.get("pageSize").toString()));
        //重新放回计算过后分页数据
        Map<String,Object> tenderApplicationVoMap = new HashMap<String,Object>();
        tenderApplicationVoMap.put("pageNo",page.getRowNum());
        tenderApplicationVoMap.put("pageSize",page.getPageCount());
        tenderApplicationVo.setParams(tenderApplicationVoMap);

        List<TenderApplicationVo> tenderApplicationVos = tenderApplicationMapper.selectRequests(tenderApplicationVo);
        page.setList(tenderApplicationVos);

        return new ResponseMessage(Code.CODE_OK,"查询成功",page);
    }

    @Override
    public ResponseMessage getTenderNum() {
        //流水单号
        String tenderNum="";
        /**
         * 获取当天的申请流水单号(倒序)
         */
        String date = DateUtils.dateTime();
        TenderApplicationExample example = new TenderApplicationExample();
        example.setOrderByClause("tender_num desc");
        TenderApplicationExample.Criteria criteria = example.createCriteria();
        criteria.andTenderNumLike("%"+date+"%");

        List<TenderApplication> tenderApplications = tenderApplicationMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(tenderApplications)){
            //获取当天最后一个流水号
            String tNum =tenderApplications.get(0).getTenderNum();
            //截取最后流水号
            String num = tNum.substring(10,tNum.length());
            int count = Integer.parseInt(num) + 1;
            tenderNum ="ZB"+date+String.format("%02d", count);
        }else{
            tenderNum="ZB"+date+"01";
        }
        return new ResponseMessage(Code.CODE_OK, MessageUtils.SUCCESS,tenderNum);
    }

    /**
     * 暂存/提交
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage insertTender(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String userId = jsonObject.getString("UserId");//登录用户
        String userName = jsonObject.getString("UserName");//登录用户名
        JSONObject application1JSON = jsonObject.getJSONObject("TenderApplication");
        JSONArray nextViewJSON = jsonObject.getJSONArray("NextViews");
        String tTodoId = jsonObject.getString("tTodoId");
        String projectName = jsonObject.getString("projectName");//项目名字

        if(StringUtils.isEmpty(userId)){
            return new ResponseMessage(Code.CODE_ERROR,"UserId"+MessageUtils.NOT_PASSED);
        }
        if(StringUtils.isEmpty(application1JSON)){
            return new ResponseMessage(Code.CODE_ERROR,"TenderApplication"+MessageUtils.NOT_PASSED);
        }
        //招标信息
        TenderApplication application = JSONObject.toJavaObject(application1JSON,TenderApplication.class);

        if(StringUtils.isEmpty(application.getStatus())){
            return new ResponseMessage(Code.CODE_ERROR,"TenderApplication中的status"+MessageUtils.NOT_PASSED);
        }

        String status = application.getStatus();
        //提交和暂存的返回信息
        String message1;
        String message2;

        //0暂存
        if(status.equals("0")){
            message1 = "暂存失败";
            message2 = "更新失败";
            //暂存状态，不用接收负责人
            nextViewJSON.clear();
        }else{
            message1 = "提交失败";
            message2 = message1;
            //review 1:此条数据在审核 0:退回
            application.setReview("1");
            application.setStatus("1");
            //提交首先更新待办表
            if (!StringUtils.isEmpty(tTodoId)){
                TTodo todo = new TTodo();
                todo.setId(tTodoId);
                todo.setStatus("1");
                todo.setActiontime(new Date());
                int i = todoMapper.updateByPrimaryKeySelective(todo);
                if(i!=1){
                    return new ResponseMessage(Code.CODE_ERROR,message1);
                }
            }
        }

        //操作招标,判断插入还是更新
        if(StringUtils.isEmpty(application.getId())){
            application.setId(String.valueOf(IDUtils.genItemId()));
            application.setCreater(userId);
            application.setCreateTime(new Date());

            int i = tenderApplicationMapper.insertSelective(application);
            if(i!=1){
                return new ResponseMessage(Code.CODE_ERROR,message1);
            }
        }else{
            application.setUpdateTime(new Date());

            int i = tenderApplicationMapper.updateByPrimaryKeySelective(application);
            if(i!=1){
                return new ResponseMessage(Code.CODE_ERROR,message2);
            }
        }

        if(nextViewJSON.size()>1){
            return new ResponseMessage(Code.CODE_ERROR,"此流程只能选择一个人审核");
        }

        //进入流程
        if(!CollectionUtils.isEmpty(nextViewJSON)){
            //查询退回后的上个节点
            TWorkflowstepExample workflowstepExample = new TWorkflowstepExample();
            workflowstepExample.setOrderByClause("action_time desc");
            TWorkflowstepExample.Criteria workflowstepCriteria = workflowstepExample.createCriteria();
            workflowstepCriteria.andRelateddomainIdEqualTo(application.getId());
            workflowstepCriteria.andActionResultEqualTo(1);

            List<TWorkflowstep> list = workflowstepMapper.selectByExample(workflowstepExample);

            TWorkflowstep workflowstep = new TWorkflowstep();
            if(CollectionUtils.isEmpty(list)){
                //然后新增一条当前登录人的流程记录
                workflowstep.setId(String.valueOf(IDUtils.genItemId()));
                workflowstep.setRelateddomain("项目招投标");
                workflowstep.setPrestepId("0");
                workflowstep.setRelateddomainId(application.getId());
                workflowstep.setStepDesc("提交采购申请");
                workflowstep.setActionuserId(userId);
                workflowstep.setActionTime(new Date());
                workflowstep.setActionResult(0);
                workflowstep.setStatus("1");
                workflowstep.setBackup3("1");

                int i3 = workflowstepMapper.insertSelective(workflowstep);
                if(i3!=1){
                    return new ResponseMessage(Code.CODE_ERROR,"提交失败");
                }
            }else {
                workflowstep.setId(list.get(0).getId());
            }
            //接下来再新增一条部门负责人的流程记录
            TWorkflowstep tWorkflowstep = new TWorkflowstep();
            tWorkflowstep.setId(String.valueOf(IDUtils.genItemId()));
            tWorkflowstep.setRelateddomain("项目招投标");
            tWorkflowstep.setRelateddomainId(application.getId());
            tWorkflowstep.setPrestepId(workflowstep.getId());
            tWorkflowstep.setStepDesc("招标办人员审核");
            tWorkflowstep.setActionuserId(nextViewJSON.getString(0));
            tWorkflowstep.setStatus("0");
            tWorkflowstep.setBackup3("2");

            int i4 = workflowstepMapper.insertSelective(tWorkflowstep);
            if(i4!=1){
                return new ResponseMessage(Code.CODE_ERROR,"提交失败");
            }
            //最后新增一条代办
            TTodo todo = new TTodo();
            todo.setId(String.valueOf(IDUtils.genItemId()));
            todo.setCurrentstepId(tWorkflowstep.getId());
            todo.setStepDesc(projectName+"的招投标批复流程等待您的处理");
            todo.setRelateddomain("项目招投标");
            todo.setRelateddomainId(application.getId());
            todo.setSenderId(userId);
            todo.setSenderTime(new Date());
            todo.setReceiverId(nextViewJSON.getString(0));
            //查询代办类型
            TXietongDictionaryExample example = new TXietongDictionaryExample();
            TXietongDictionaryExample.Criteria criteria = example.createCriteria();
            criteria.andTypeIdEqualTo("8");
            criteria.andTypeCodeEqualTo("38");
            criteria.andMidValueEqualTo("1");
            List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
            //查询待办类型
            todo.setTodoType(dictionaryList.get(0).getMainValue());
            todo.setStatus("0");
            todo.setBackUp7(userName);//发起人
            int i5 = todoMapper.insertSelective(todo);
            if(i5!=1){
                return new ResponseMessage(Code.CODE_ERROR,"提交失败");
            }
        }
        return new ResponseMessage(Code.CODE_OK,"操作成功");
    }

    /**
     *查询招标申请单
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage queryTender(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);

        //项目编码
        String projectCode = jsonObject.getString("projectCode");
        //项目名称
        String projectName = jsonObject.getString("projectName");
        //招标方式
        String method = jsonObject.getString("method");
        //中标厂商
        String supplier = jsonObject.getString("supplier");
        //中标日期
        String bidDate = jsonObject.getString("bidDate");
        //流程状态
        String status = jsonObject.getString("status");
        //当前登录人
        String userId = jsonObject.getString("userId");
        //当前页数
        String pageNumS  = jsonObject.getString("pageNo");
        //每页显示记录数
        String pageCountS  = jsonObject.getString("pageSize");

        if(StringUtils.isEmpty(userId)){
            return new ResponseMessage(Code.CODE_ERROR,"userId"+MessageUtils.NOT_PASSED);
        }
        if(StringUtils.isEmpty(pageNumS)){
            return new ResponseMessage(Code.CODE_ERROR,"pageNo"+MessageUtils.NOT_PASSED);
        }
        if(StringUtils.isEmpty(pageCountS)){
            return new ResponseMessage(Code.CODE_ERROR,"pageSize"+MessageUtils.NOT_PASSED);
        }

        int pageNum = Integer.parseInt(pageNumS);
        int pageCount = Integer.parseInt(pageCountS);
        int count = tenderApplicationMapper.selectCount(projectCode,projectName,method,supplier,bidDate,status,userId);
        Page page = new Page();
        page.init(count,pageNum,pageCount);
        List<TenderApplication> list =  tenderApplicationMapper.selectPage(projectCode,projectName,method,supplier,bidDate,status,userId,page.getRowNum(),page.getPageCount());


        //处理操作状态
        List<TenderApplication> datalist = new ArrayList<TenderApplication>();
        list.forEach(map->{
            //查询对应的todo  operatingStatus操作状态 0：详情 1：审核
            String  tenderId = map.getId();
            TTodoExample todoExample = new TTodoExample();
            TTodoExample.Criteria criteria = todoExample.createCriteria();
            criteria.andRelateddomainIdEqualTo(tenderId);
            criteria.andReceiverIdEqualTo(userId);
            criteria.andStatusEqualTo("0");
            List<TTodo> todos = todoMapper.selectByExample(todoExample);
            List<TWorkflowstep> tworkList= workflowstepMapper.queryProjectRecords(tenderId);

            Map<String,Object>paramMap = new HashMap<String,Object>();
            if(tworkList!=null&&tworkList.size()>0) {
                String ownerId2 = tworkList.get(0).getActionuserId();
                if (ownerId2.equals(userId)) {
                    paramMap.put("IsRight",1);
                } else {
                    paramMap.put("IsRight",0);
                }
            }else {
                paramMap.put("IsRight",1);
            }
            //isApprove(当前任是否是审批人 0：不是 1：是)
            if (CollectionUtils.isEmpty(todos)) {
                paramMap.put("operatingStatus",0);
            } else {
                paramMap.put("operatingStatus",1);
            }
            map.setParams(paramMap);
            datalist.add(map);
        });
        page.setList(datalist);
        return new ResponseMessage(Code.CODE_OK,"查询成功",page);
    }

    @Override
    public ResponseMessage queryReviewTender(String requestBody) {
        //1.1查询招标信息1.2查询附件信息 2.查询待办 3.查询工作流程
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        JSONObject application1JSON = jsonObject.getJSONObject("TenderApplication");
        String userId = jsonObject.getString("UserId");//登录用户

        TenderApplication application = JSONObject.toJavaObject(application1JSON,TenderApplication.class);
        //1.查询招标信息
        if(StringUtils.isEmpty(application.getId())){
            return new ResponseMessage(Code.CODE_ERROR,"TenderApplication中的id"+MessageUtils.NOT_PASSED);
        }
        if(StringUtils.isEmpty(userId)){
            return new ResponseMessage(Code.CODE_ERROR,"UserId"+MessageUtils.NOT_PASSED);
        }
        TenderApplicationExample example = new TenderApplicationExample();
        TenderApplicationExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(application.getId());
        List<TenderApplication> tenderApplications = tenderApplicationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(tenderApplications)){
            return new ResponseMessage(Code.CODE_ERROR,"TenderApplication查询失败");
        }
        //查询结果集
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("TenderApplication",tenderApplications.get(0));
        //1.2查询附件信息
        InternalAttachmentExample internalAttachmentExample = new InternalAttachmentExample();
        InternalAttachmentExample.Criteria Incriteria = internalAttachmentExample.createCriteria();
        Incriteria.andRelateddomainIdEqualTo(tenderApplications.get(0).getId());
        List<InternalAttachment> InternalAttachments =attachmentMapper.selectByExample(internalAttachmentExample);
        map.put("InternalAttachments",InternalAttachments);


        //2.查询待办
        TTodoExample tTodoExample = new TTodoExample();
        TTodoExample.Criteria  tTodoExampleCriteria = tTodoExample.createCriteria();
        tTodoExampleCriteria.andReceiverIdEqualTo(userId);
        tTodoExampleCriteria.andRelateddomainIdEqualTo(application.getId());
        tTodoExampleCriteria.andStatusEqualTo("0");
        List<TTodo> list = todoMapper.selectByExample(tTodoExample);
        map.put("TTodo",list);

        //3.查询工作流程
        TWorkflowstepExample tWorkflowstepExample = new TWorkflowstepExample();
        tWorkflowstepExample.setOrderByClause("IF(ISNULL(action_time),1,0),action_time");
        TWorkflowstepExample.Criteria criteria1 = tWorkflowstepExample.createCriteria();
        criteria1.andRelateddomainEqualTo(application.getId());
        List<TWorkflowstep> tWorkflowsteps = workflowstepMapper.selectByExample(tWorkflowstepExample);
        map.put("TWorkflowstep",tWorkflowsteps);

        return new ResponseMessage(Code.CODE_OK,"查询成功",map);
    }

    /**
     *废除
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage abolitionTender(String requestBody) {
        //更新待办,更改招标的信息的状态
        JSONObject jsonObject = JSONObject.parseObject(requestBody);

        JSONObject application1JSON = jsonObject.getJSONObject("TenderApplication");
        String userId = jsonObject.getString("UserId");//登录用户

        //更新招标信息
        TenderApplication application = JSONObject.toJavaObject(application1JSON,TenderApplication.class);
        //废除状态
        application.setStatus("8");
        application.setUpdateTime(new Date());
        if(StringUtils.isEmpty(application.getId())){
            return new ResponseMessage(Code.CODE_ERROR,"id"+MessageUtils.NOT_PASSED);
        }
        int count = tenderApplicationMapper.updateByPrimaryKeySelective(application);
        if(count!=1){
            return new ResponseMessage(Code.CODE_ERROR,"废除失败");
        }

        TTodoExample example = new TTodoExample();
        TTodoExample.Criteria  criteria = example.createCriteria();
        criteria.andReceiverIdEqualTo(userId);
        criteria.andRelateddomainIdEqualTo(application.getId());
        criteria.andStatusEqualTo("0");
        List<TTodo> list = todoMapper.selectByExample(example);

        //更新待办
        TTodo tTodo = list.get(0);
        tTodo.setStatus("1");
        tTodo.setActiontime(new Date());
        int i = todoMapper.updateByPrimaryKeySelective(tTodo);
        if(i!=1){
            return new ResponseMessage(Code.CODE_ERROR,"废除失败");
        }

        return new ResponseMessage(Code.CODE_ERROR,"废除成功");
    }

    @Override
    public ResponseMessage deleteTender(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        //更新招标信息
        TenderApplication application = JSONObject.toJavaObject(jsonObject,TenderApplication.class);
        if(StringUtils.isEmpty(application.getId())){
            return new ResponseMessage(Code.CODE_ERROR,"id"+MessageUtils.NOT_PASSED);
        }
        application.setDeleteTime(new Date());
        int count = tenderApplicationMapper.updateByPrimaryKeySelective(application);
        if(count!=1){
            return new ResponseMessage(Code.CODE_ERROR,"删除失败");
        }
        return new ResponseMessage(Code.CODE_OK,"删除成功");
    }

    /**
     *审核
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage reviewTender(String requestBody) {
        JSONObject jsonObj=JSONObject.parseObject(requestBody);
        String relateddomain="项目招投标";//业务模块
        String relateddomain_id=jsonObj.getString("relateddomainId");//业务id
        String sender_id=jsonObj.getString("userId");//当前人的id
        String currentstep_id=jsonObj.getString("currentstepId");//当前处理步骤
        String todo_id=jsonObj.getString("todoId");//当前todo表中id
        String workflowstep_id=jsonObj.getString("workflowstepId");//当前workflowstep表中的id
        String actionComment=jsonObj.getString("actionComment");//审核意见
        String actionResult=jsonObj.getString("actionResult");//0 同意 1 不同意or退回
        String backup3 = jsonObj.getString("sort");//第几个步骤
        String reviewIds = jsonObj.getString("nextReviewerId");//下一个审核人的信息
        String userName = jsonObj.getString("userName");//用户姓名
        String projectName = jsonObj.getString("projectName");//项目名字
        String fistId =  jsonObj.getString("fistId");//项目负责人id

        //必要参数空值判断
        if(org.springframework.util.StringUtils.isEmpty(reviewIds)){
            return new ResponseMessage(Code.CODE_ERROR, "nextReviewerId"+MessageUtils.NOT_PASSED);
        }
        JSONArray nextReviewerId=JSONArray.parseArray(reviewIds);

        if(org.springframework.util.StringUtils.isEmpty(relateddomain_id)){
            return new ResponseMessage(Code.CODE_ERROR, "relateddomainId"+MessageUtils.NOT_PASSED);
        }
        if(org.springframework.util.StringUtils.isEmpty(sender_id)){
            return new ResponseMessage(Code.CODE_ERROR, "userId"+MessageUtils.NOT_PASSED);
        }
        if(org.springframework.util.StringUtils.isEmpty(currentstep_id)){
            return new ResponseMessage(Code.CODE_ERROR, "currentstepId"+MessageUtils.NOT_PASSED);
        }
        if(org.springframework.util.StringUtils.isEmpty(todo_id)){
            return new ResponseMessage(Code.CODE_ERROR, "todoId"+MessageUtils.NOT_PASSED);
        }
        if(org.springframework.util.StringUtils.isEmpty(workflowstep_id)){
            return new ResponseMessage(Code.CODE_ERROR, "workflowstepId"+MessageUtils.NOT_PASSED);
        }
        if(org.springframework.util.StringUtils.isEmpty(actionResult)){
            return new ResponseMessage(Code.CODE_ERROR, "actionResult"+MessageUtils.NOT_PASSED);
        }
        if(org.springframework.util.StringUtils.isEmpty(backup3)){
            return new ResponseMessage(Code.CODE_ERROR, "sort"+MessageUtils.NOT_PASSED);
        }

		/*
		 * 修改掉当前todo表对应的id的信息
		 */
        TTodo tTodo=new TTodo();
        tTodo.setId(todo_id);
        tTodo.setActiontime(new Date());
        tTodo.setStatus("1");
        int k=todoMapper.updateByPrimaryKeySelective(tTodo);
        if(k<=0) {
            return new ResponseMessage(Code.CODE_ERROR, "审核失败");
        }

		/*
		 * 修改当前workflowstep表中对应id的信息
		 */
        TWorkflowstep tWorkflowstep=new TWorkflowstep();
        tWorkflowstep.setId(workflowstep_id);
        tWorkflowstep.setActionTime(new Date());
        tWorkflowstep.setActionComment(actionComment);
        tWorkflowstep.setStatus("1");
        if(actionResult.equals("0")) {
            tWorkflowstep.setActionResult(0);
        }else if(actionResult.equals("1")) {
            tWorkflowstep.setActionResult(1);
        }
        int j=workflowstepMapper.updateByPrimaryKeySelective(tWorkflowstep);
        if(j<=0) {
            return new ResponseMessage(Code.CODE_ERROR, "审核失败");
        }

        //步骤描述
        String stepDesc="";
        //状态值
        String ss="1";
        //backup3 :下一步的操作步骤 stepDesc: 下一步的审核步骤名称
        if(backup3.equals("2")){
            ss=backup3;
            stepDesc="招标办人员审核";
            backup3=new String("3");
        }else if(backup3.equals("3")){
            ss=backup3;
            stepDesc="招标办主任审核";
            backup3=new String("4");
        }else if(backup3.equals("4")){
            ss=backup3;
            stepDesc="招标委员会审核";
            backup3=new String("5");
        }else if(backup3.equals("5")){
            ss=backup3;
            stepDesc="执行董事审核";
            backup3=new String("7");
        }

        //三个条件进入审核
        TWorkflowstepExample examples = new TWorkflowstepExample();
        TWorkflowstepExample.Criteria criteria1 = examples.createCriteria();
        criteria1.andRelateddomainIdEqualTo(relateddomain_id);
        criteria1.andActionResultEqualTo(1);
        criteria1.andBackup3EqualTo("4");
        List<TWorkflowstep> tWorkflowsteps = workflowstepMapper.selectByExample(examples);

        //查询是否是最后一人审核
        TWorkflowstepExample exampless = new TWorkflowstepExample();
        TWorkflowstepExample.Criteria criteria1s = exampless.createCriteria();
        criteria1s.andRelateddomainIdEqualTo(relateddomain_id);
        criteria1s.andBackup3EqualTo("4");
        criteria1s.andStatusEqualTo("0");
        List<TWorkflowstep> tWorkflowstepss = workflowstepMapper.selectByExample(exampless);

        //查询所有的工作记录
        List<TWorkflowstep> tWorkfow =workflowstepMapper.queryNotReviewProject(relateddomain_id);
        TWorkflowstep t = null;
        if(!CollectionUtils.isEmpty(tWorkfow)){
            t=tWorkfow.get(tWorkfow.size()-1);
        }
        TenderApplicationExample projectApplicationExample = new TenderApplicationExample();
        TenderApplicationExample.Criteria  criteri = projectApplicationExample.createCriteria();
        criteri.andReviewEqualTo("0");
        criteri.andIdEqualTo(relateddomain_id);
        List<TenderApplication> tenderApplications = tenderApplicationMapper.selectByExample(projectApplicationExample);

        //查询代办类型
        TXietongDictionaryExample example1 = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria4 = example1.createCriteria();
        criteria4.andTypeIdEqualTo("8");
        criteria4.andTypeCodeEqualTo("38");
        criteria4.andMidValueEqualTo("1");
        List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example1);

        if(!CollectionUtils.isEmpty(tWorkflowsteps)&&CollectionUtils.isEmpty(tWorkflowstepss)&&t!=null&&t.getBackup3().equals("4")&&!CollectionUtils.isEmpty(tenderApplications)){

            //判断现在是哪一步退回如果是技术委员退回则判断是否是最后一个人退回
            TWorkflowstepExample example = new TWorkflowstepExample();
            TWorkflowstepExample.Criteria criteria = example.createCriteria();
            criteria.andRelateddomainIdEqualTo(relateddomain_id);
            criteria.andStatusEqualTo("0");
            List<TWorkflowstep> tWorkflowste = workflowstepMapper.selectByExample(example);
            if(tWorkflowste.size()==0){
                //如果当前审核人员只有一个的话则生成待办
                TTodo todo = new TTodo();
                todo.setId(String.valueOf(IDUtils.genItemId()));
                todo.setCurrentstepId(workflowstep_id);
                todo.setStepDesc(projectName+"的招投标批复流程等待您的处理");
                todo.setRelateddomain("项目招投标");
                todo.setRelateddomainId(relateddomain_id);
                todo.setSenderId(sender_id);
                todo.setSenderTime(new Date());


                todo.setBackUp7(userName);//发起人
                //取项目流程中第一个项目负责人id
                TWorkflowstepExample exampl = new TWorkflowstepExample();
                exampl.setOrderByClause("prestep_id");
                TWorkflowstepExample.Criteria criteria3 = exampl.createCriteria();
                criteria3.andRelateddomainIdEqualTo(relateddomain_id);

                List<TWorkflowstep> tWorkflow = workflowstepMapper.selectByExample(exampl);
                todo.setReceiverId(tWorkflow.get(0).getActionuserId());


                todo.setTodoType(dictionaryList.get(0).getMainValue());
                todo.setStatus("0");
                int i1 = todoMapper.insertSelective(todo);
                if(i1!=1){
                    return new ResponseMessage(Code.CODE_ERROR,"退回失败");
                }
            }
            //改变当前立项表状态为退回
            TenderApplication application = new TenderApplication();
            application.setId(relateddomain_id);
            application.setStatus("6");
            int i1 = tenderApplicationMapper.updateByPrimaryKeySelective(application);
            if(i1==0){
                return new ResponseMessage(Code.CODE_ERROR,"退回失败");
            }
        }else{
			/*
			 * 选择下一个审核人进行的操作
			 * 对todo表中进行添加操作
			 * 对Workflowstep表中进行添加操作
			 */
            boolean flag= false;//最后一人审核标识
            for(int c=0;c<nextReviewerId.size();c++) {
                //进入到多个人审核阶段，修改待办
                if(ss.equals("4")){
                    TWorkflowstepExample example2=new TWorkflowstepExample();
                    TWorkflowstepExample.Criteria criteria2 = example2.createCriteria();
                    criteria2.andStatusEqualTo("0");
                    criteria2.andRelateddomainIdEqualTo(relateddomain_id);
                    criteria2.andBackup3EqualTo("4");
                    List<TWorkflowstep> list = workflowstepMapper.selectByExample(example2);
                    //最后一人审核
                    if(CollectionUtils.isEmpty(list)){
                        TWorkflowstep workflowstep=new TWorkflowstep();
                        workflowstep.setId(String.valueOf(UUID.randomUUID()));
                        workflowstep.setRelateddomain(relateddomain);
                        workflowstep.setRelateddomainId(relateddomain_id);
                        workflowstep.setPrestepId(workflowstep_id);
                        workflowstep.setActionuserId(nextReviewerId.getString(c));
                        workflowstep.setStatus("0");
                        workflowstep.setBackup3(backup3);
                        workflowstep.setStepDesc(stepDesc);
                        int m=workflowstepMapper.insertSelective(workflowstep);
                        if(m<=0) {
                            return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
                        }
                        TTodo internalToDo=new TTodo();
                        internalToDo.setId(String.valueOf(UUID.randomUUID()));
                        internalToDo.setCurrentstepId(workflowstep.getId());
                        internalToDo.setRelateddomain(relateddomain);
                        internalToDo.setRelateddomainId(relateddomain_id);
                        internalToDo.setSenderId(sender_id);
                        internalToDo.setReceiverId(nextReviewerId.getString(c));
                        internalToDo.setSenderTime(new Date());
                        internalToDo.setTodoType(dictionaryList.get(0).getMainValue());
                        internalToDo.setStepDesc(projectName+"的招投标批复流程等待您的处理");
                        internalToDo.setStatus("0");
                        internalToDo.setBackUp7(userName);//发起人

                        int n=todoMapper.insertSelective(internalToDo);
                        if(n<=0) {
                            return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
                        }
                        flag=true;
                    }
                }else{
                    TWorkflowstep workflowstep=new TWorkflowstep();
                    workflowstep.setId(String.valueOf(UUID.randomUUID()));
                    workflowstep.setRelateddomain(relateddomain);
                    workflowstep.setRelateddomainId(relateddomain_id);
                    workflowstep.setPrestepId(workflowstep_id);
                    workflowstep.setActionuserId(nextReviewerId.getString(c));
                    workflowstep.setStatus("0");
                    workflowstep.setBackup3(backup3);
                    workflowstep.setStepDesc(stepDesc);
                    int m=workflowstepMapper.insertSelective(workflowstep);
                    if(m<=0) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
                    }
                    if(ss.equals("5")){
                        TTodo internalToDo=new TTodo();
                        internalToDo.setId(String.valueOf(UUID.randomUUID()));
                        internalToDo.setCurrentstepId(workflowstep.getId());
                        internalToDo.setRelateddomain(relateddomain);
                        internalToDo.setRelateddomainId(relateddomain_id);
                        internalToDo.setSenderId(sender_id);
                        internalToDo.setReceiverId(fistId);
                        internalToDo.setSenderTime(new Date());
                        internalToDo.setTodoType(dictionaryList.get(0).getMainValue());
                        internalToDo.setStepDesc(projectName+"的招投标定标流程等待您的处理");
                        internalToDo.setStatus("0");
                        internalToDo.setBackUp7(userName);//发起人
                        int n=todoMapper.insertSelective(internalToDo);
                        if(n<=0) {
                            return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
                        }
                    }else{
                        TTodo internalToDo=new TTodo();
                        internalToDo.setId(String.valueOf(UUID.randomUUID()));
                        internalToDo.setCurrentstepId(workflowstep.getId());
                        internalToDo.setRelateddomain(relateddomain);
                        internalToDo.setRelateddomainId(relateddomain_id);
                        internalToDo.setSenderId(sender_id);
                        internalToDo.setReceiverId(nextReviewerId.getString(c));
                        internalToDo.setSenderTime(new Date());
                        internalToDo.setTodoType(dictionaryList.get(0).getMainValue());
                        internalToDo.setStepDesc(projectName+"的招投标批复流程等待您的处理");
                        internalToDo.setStatus("0");
                        internalToDo.setBackUp7(userName);//发起人
                        int n=todoMapper.insertSelective(internalToDo);
                        if(n<=0) {
                            return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
                        }
                    }

                }
            }
            //更新TenderApplication
            TenderApplication projectApplication = new TenderApplication();
            projectApplication.setId(relateddomain_id);
            projectApplication.setUpdateTime(new Date());
            //多人审核阶段
            if(backup3.equals("5")){
                //审核结束
                if(flag){
                    projectApplication.setStatus("5");
                }else{
                    projectApplication.setStatus("4");
                }
            }else{
                projectApplication.setStatus(ss);
            }

            int num =tenderApplicationMapper.updateByPrimaryKeySelective(projectApplication);
            if(num<=0){
                return new ResponseMessage(Code.CODE_ERROR, "审核完成失败");
            }
        }
        return new ResponseMessage(Code.CODE_OK, "审核完成");
    }

    /**
     *定标
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage targetTender(String requestBody) {
        JSONObject jsonObj=JSONObject.parseObject(requestBody);
        //当前待办的ID
        String todoId=jsonObj.getString("todoId");
        //当前步骤ID
        String workflowstepId=jsonObj.getString("workflowstepId");
        //业务id
        String relateddomainId=jsonObj.getString("relateddomainId");
        //招标信息
        JSONObject applicationJSON = jsonObj.getJSONObject("TenderApplication");
        TenderApplication tenderApplication = JSONObject.toJavaObject(applicationJSON,TenderApplication.class);
        //附件信息
        JSONArray resourcesJSON = jsonObj.getJSONArray("Files");
        //当前登录人id
        String userId = jsonObj.getString("userId");

        if(org.springframework.util.StringUtils.isEmpty(todoId)){
            return new ResponseMessage(Code.CODE_ERROR, "todoId"+MessageUtils.NOT_PASSED);
        }
        if(org.springframework.util.StringUtils.isEmpty(workflowstepId)){
            return new ResponseMessage(Code.CODE_ERROR, "workflowstepId"+MessageUtils.NOT_PASSED);
        }
        if(org.springframework.util.StringUtils.isEmpty(relateddomainId)){
            return new ResponseMessage(Code.CODE_ERROR, "relateddomainId"+MessageUtils.NOT_PASSED);
        }

        //修改掉当前todo表对应的id的信息
        TTodo tTodo=new TTodo();
        tTodo.setId(todoId);
        tTodo.setActiontime(new Date());
        tTodo.setStatus("1");
        int k=todoMapper.updateByPrimaryKeySelective(tTodo);
        if(k<=0) {
            return new ResponseMessage(Code.CODE_ERROR, "定标失败");
        }
        //修改当前workflowstep表中对应id的信息
        TWorkflowstep tWorkflowstep=new TWorkflowstep();
        tWorkflowstep.setId(workflowstepId);
        tWorkflowstep.setActionTime(new Date());
        tWorkflowstep.setStatus("1");
        int j=workflowstepMapper.updateByPrimaryKeySelective(tWorkflowstep);
        if(j<=0) {
            return new ResponseMessage(Code.CODE_ERROR, "定标失败");
        }

        //更新招标表
        tenderApplication.setUpdateTime(new Date());
        tenderApplication.setStatus("7");
        if(StringUtils.isEmpty(tenderApplication.getId())){
            return  new ResponseMessage(Code.CODE_ERROR, "TenderApplication中缺少id参数");
        }

        int count = tenderApplicationMapper.updateByPrimaryKeySelective(tenderApplication);
        if(count<=0){
            return new ResponseMessage(Code.CODE_ERROR, "定标失败");
        }
        //保存定标信息附件 先删除后增加
        InternalAttachmentExample exampleIn = new InternalAttachmentExample();
        InternalAttachmentExample.Criteria criteriaIn = exampleIn.createCriteria();
        criteriaIn.andRelateddomainIdEqualTo(tenderApplication.getId());
        attachmentMapper.deleteByExample(exampleIn);

        //增加附件
        for(int i=0;i<resourcesJSON.size();i++){
            JSONObject object = resourcesJSON.getJSONObject(i);
            InternalAttachment projectMembers = JSONObject.toJavaObject(object,InternalAttachment.class);
            projectMembers.setId(String.valueOf(IDUtils.genItemId()));
            projectMembers.setUploadTime(new Date());
            projectMembers.setUploader(userId);
            projectMembers.setRelateddomain("项目招投标模块");
            projectMembers.setRelateddomainId(tenderApplication.getId());
            int num = attachmentMapper.insertSelective(projectMembers);
            if(num<=0){
                return new ResponseMessage(Code.CODE_ERROR,"保存招标附件异常");
            }
        }
        return new ResponseMessage(Code.CODE_OK, "定标完成");
    }

    /**
     *退回
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage returnTender(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String application_id = jsonObject.getString("application_id");//招标id
        String workflowstep_id = jsonObject.getString("workflowstep_id");//招标流程id
        String stepDesc = jsonObject.getString("stepDesc");//当前流程步骤
        String stepDesc1 =  stepDesc.substring(0,stepDesc.length()-2);

        String user_id  = jsonObject.getString("user_id");//当前登录人id
        String user_name  = jsonObject.getString("user_name");//当前登录人姓名
        String action  = jsonObject.getString("action_commont");//处理意见
        String todoId =  jsonObject.getString("todoId");//当前步骤待办id
        String fistId =  jsonObject.getString("fistId");//项目负责人id
        String projectName = jsonObject.getString("projectName");//项目名字

        //将当前对应流程关闭
        TWorkflowstep workflowstep = new TWorkflowstep();
        workflowstep.setId(workflowstep_id);
        workflowstep.setStepDesc(stepDesc1+"退回");
        workflowstep.setStatus("1");
        workflowstep.setActionResult(1);
        workflowstep.setActionComment(action);
        workflowstep.setActionTime(new Date());
        int i = workflowstepMapper.updateByPrimaryKeySelective(workflowstep);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"退回失败");
        }
        //修改当前待办表
        TTodo tTodo = new TTodo();
        tTodo.setId(todoId);
        tTodo.setStatus("1");
        tTodo.setActiontime(new Date());
        int k = todoMapper.updateByPrimaryKeySelective(tTodo);
        if(k!=1){
            return new ResponseMessage(Code.CODE_ERROR,"退回失败");
        }

        //判断现在是哪一步退回如果是技术委员退回则判断是否是最后一个人退回
        TWorkflowstepExample example = new TWorkflowstepExample();
        TWorkflowstepExample.Criteria criteria = example.createCriteria();
        criteria.andRelateddomainIdEqualTo(application_id);
        criteria.andStatusEqualTo("0");
        List<TWorkflowstep> tWorkflowsteps = workflowstepMapper.selectByExample(example);
        if(tWorkflowsteps.size()==0){
            //如果当前审核人员只有一个的话则生成待办
            TTodo todo = new TTodo();
            todo.setId(String.valueOf(IDUtils.genItemId()));
            todo.setCurrentstepId(workflowstep_id);
            todo.setStepDesc(projectName+"的项目招投标流程等待您的处理");
            todo.setRelateddomain("项目招投标");
            todo.setRelateddomainId(application_id);
            todo.setSenderId(user_id);
            todo.setSenderTime(new Date());

            todo.setBackUp7(user_name);//发起人
            todo.setReceiverId(fistId);
            //查询代办类型
            TXietongDictionaryExample example1 = new TXietongDictionaryExample();
            TXietongDictionaryExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andTypeIdEqualTo("8");
            criteria1.andTypeCodeEqualTo("38");
            criteria1.andMidValueEqualTo("1");
            List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example1);
            todo.setTodoType(dictionaryList.get(0).getMainValue());
            todo.setStatus("0");
            int i1 = todoMapper.insertSelective(todo);
            if(i1!=1){
                return new ResponseMessage(Code.CODE_ERROR,"退回失败");
            }

            //改变当前招标表状态为退回
            TenderApplication application = new TenderApplication();
            application.setId(application_id);
            application.setReview("0");
            application.setStatus("6");
            application.setUpdateTime(new Date());
            int i11 = tenderApplicationMapper.updateByPrimaryKeySelective(application);
            if(i11==0){
                return new ResponseMessage(Code.CODE_ERROR,"退回失败");
            }
        }else{
            TenderApplication application = new TenderApplication();
            application.setId(application_id);
            application.setReview("0");
            application.setUpdateTime(new Date());
            int i11 = tenderApplicationMapper.updateByPrimaryKeySelective(application);
            if(i11==0){
                return new ResponseMessage(Code.CODE_ERROR,"退回失败");
            }
        }
        return new ResponseMessage(Code.CODE_OK,"退回成功");
    }
}
