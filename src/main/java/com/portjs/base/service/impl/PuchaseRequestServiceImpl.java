package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.PuchaseRequestService;
import com.portjs.base.util.*;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.vo.FlashProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PuchaseRequestServiceImpl implements PuchaseRequestService {
    ResponseMessage responseMessage = null;

    @Autowired
    PurchaseRequestMapper purchaseRequestMapper;

    @Autowired
    TWorkflowstepMapper tWorkflowstepMapper;
    @Autowired
    PurchaseListMapper purchaseListMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    TTodoMapper todoMapper;

    @Autowired
    InternalAttachmentMapper internalAttachmentMapper;

    @Autowired
    private TXietongDictionaryMapper dictionaryMapper;
    @Autowired
    TDepartmentMapper tDepartmentMapper;
    Date currentTime = this.getCurrentTime();

    public Date getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date time = null;
        try {
            time = sdf.parse(sdf.format(new Date()));
            return time;
        } catch (Exception e) {
            e.printStackTrace();
            return time;
        }
    }
    //返参信息
    public final static String PARAM_MESSAGE_1 = "未传";
    public final static String PARAM_MESSAGE_2 = "已存在";


    /**
     * 采购申请表暂存/提交
     * @param
     * @return
     */
    @Override
    public ResponseMessage insertPurchaseRequestSelective(String responseBody) {
        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(responseBody);
        //申请单
        //这是前段传过来的id  如果这个id存在说明已经暂存过  进行更新  如果为null 说明是新增
        String id = jsonObject.getString("id");
        //String request_id = jsonObject.getString("request_id");
        String  reviewNum= LSUtils.createOdd("PR");//申请单单号
        String projectId = jsonObject.getString("projectId");//项目id
        String method = jsonObject.getString("method");//采购方式
        String amount = jsonObject.getString("amount");//采购金额
        String purchaseDept = jsonObject.getString("purchaseDept");//采购部门
        String content  = jsonObject.getString("content");//采购内容
        String applicant = jsonObject.getString("applicant");//采购申请人
        String applicantId = jsonObject.getString("applicantId");//采购申请人id
        String agency = jsonObject.getString("agency");

        String applyDate1 = jsonObject.getString("applyDate");
        java.sql.Date applyDate = java.sql.Date.valueOf(applyDate1);//申请时间
        String DS = jsonObject.getString("DS");//获取导入的清单列表JSON数组字符串

        //暂存和提交
        String status = jsonObject.getString("status");//0:暂存  1:采购办审核  2：采购办主任审核 3：采购管理员委员会审核 4：执行董事审核 5：已完成  6：退回
        String ownerId = jsonObject.getString("ownerId");//当前登录人id
        String ownerName = jsonObject.getString("ownerName");//当前登录人姓名
        //指定处理人的id
        String actionuserId = jsonObject.getString("actionuserId");//流程表里指定处理人的id
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setRequestNum(reviewNum);
        purchaseRequest.setProjectId(projectId);
        purchaseRequest.setPurchaseDept(purchaseDept);
        purchaseRequest.setMethod(method);
        BigDecimal amount1 = new BigDecimal(amount);
        purchaseRequest.setAmount(amount1);
        purchaseRequest.setApplyDate(applyDate);
        purchaseRequest.setCreater(ownerId);
        purchaseRequest.setCreateTime(currentTime);
        purchaseRequest.setApplicant(applicant);
        purchaseRequest.setApplicantId(applicantId);
        purchaseRequest.setContent(content);
        purchaseRequest.setAgency(agency);


        PurchaseList purchaseList = new PurchaseList();
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(DS);//并将DS内容取出转为json数组
        for (int j = 0; j < jsonArray.size(); j++) {     //遍历json数组内容
            net.sf.json.JSONObject object = jsonArray.getJSONObject(j);
            purchaseList.setId(UUID.randomUUID().toString());
            purchaseList.setRequestId(id);//上面刚刚创建的采购申请数据的id
            purchaseList.setProjectId(projectId);//所属项目id
            purchaseList.setContent(object.getString("content"));//需求说明
            purchaseList.setDemander(object.getString("demander"));//需求人姓名
            BigDecimal b=new BigDecimal(object.getLong("quantity"));
            purchaseList.setQuantity(b);//数量
            purchaseList.setUnit(object.getString("unit"));//单位
            purchaseList.setSpec(object.getString("spec"));//规格
            purchaseList.setModel(object.getString("model"));//型号
            purchaseList.setName(object.getString("name"));//品名
            purchaseList.setBrand(object.getString("brand"));//品牌
            purchaseList.setCreater(ownerId);//创建人id
            purchaseList.setCreateTime(new Date());//创建时间
            int i1 = purchaseListMapper.insertPurchaseListSelective(purchaseList);
            if(i1==0){
                return new ResponseMessage(Code.CODE_ERROR,"采购清单列表添加失败！",i1);
            }

        }
        //获取所有审批人的id
        JSONArray jsonArray1 = jsonObject.getJSONArray("approvers");
        //status ：0  暂存  1  提交
        if (status.equals("0")) {
            purchaseRequest.setStatus("0");
            //id 为空新增
            if (id.isEmpty()) {
                String id2 = UUID.randomUUID().toString();
                purchaseRequest.setId(id2);
                int f = purchaseRequestMapper.insertPurchaseRequest(purchaseRequest);
                net.sf.json.JSONArray jsonArray2 = net.sf.json.JSONArray.fromObject(DS);//并将DS内容取出转为json数组
                for (int j = 0; j < jsonArray2.size(); j++) {     //遍历json数组内容
                    net.sf.json.JSONObject object = jsonArray2.getJSONObject(j);
                    purchaseList.setId(UUID.randomUUID().toString());
                    purchaseList.setRequestId(id2);//上面刚刚创建的采购申请数据的id
                    purchaseList.setProjectId(projectId);//所属项目id
                    purchaseList.setContent(object.getString("content"));//需求说明
                    purchaseList.setDemander(object.getString("demander"));//需求人姓名
                    BigDecimal b=new BigDecimal(object.getLong("quantity"));
                    purchaseList.setQuantity(b);//数量
                    purchaseList.setUnit(object.getString("unit"));//单位
                    purchaseList.setSpec(object.getString("spec"));//规格
                    purchaseList.setModel(object.getString("model"));//型号
                    purchaseList.setName(object.getString("name"));//品名
                    purchaseList.setBrand(object.getString("brand"));//品牌
                    purchaseList.setCreater(ownerId);//创建人id
                    purchaseList.setCreateTime(new Date());//创建时间
                    int i1 = purchaseListMapper.insertPurchaseListSelective(purchaseList);
                    if(i1==0){
                        return new ResponseMessage(Code.CODE_ERROR,"采购清单列表添加失败！",i1);
                    }
                }

                if (f != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "添加采购申请失败");
                }
                return new ResponseMessage(Code.CODE_OK, "暂存成功");
            } else {
                purchaseRequest.setId(id);
                int f = purchaseRequestMapper.updateByPrimaryKeySelective(purchaseRequest);
                if (f != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "更新采购申请失败!");
                }
                net.sf.json.JSONArray jsonArray3 = net.sf.json.JSONArray.fromObject(DS);//并将DS内容取出转为json数组
                for (int j = 0; j < jsonArray3.size(); j++) {     //遍历json数组内容
                    net.sf.json.JSONObject object = jsonArray3.getJSONObject(j);
                    purchaseList.setId(object.getString("id"));
                    purchaseList.setContent(object.getString("content"));//需求说明
                    purchaseList.setDemander(object.getString("demander"));//需求人id
                    BigDecimal b = new BigDecimal(object.getLong("quantity"));
                    purchaseList.setQuantity(b);//数量
                    purchaseList.setUnit(object.getString("unit"));//单位
                    purchaseList.setSpec(object.getString("spec"));//规格
                    purchaseList.setModel(object.getString("model"));//型号
                    purchaseList.setName(object.getString("name"));//品名
                    purchaseList.setBrand(object.getString("brand"));//品牌

                    purchaseList.setRequestId(id);
                    int i1 = purchaseListMapper.updateByRequestId(purchaseList);
                    if(i1==0){
                        return new ResponseMessage(Code.CODE_ERROR,"采购清单列表修改失败！",i1);
                    }

                }
                return new ResponseMessage(Code.CODE_OK, "暂存成功");
            }
            //提交
        } else if (status.equals("1")) {
            purchaseRequest.setStatus("1");
            //id为空 直接添加
            if (id.isEmpty()) {
                String id2 = UUID.randomUUID().toString();
                purchaseRequest.setId(id2);
                int f = purchaseRequestMapper.insertPurchaseRequest(purchaseRequest);
                if (f != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "添加采购申请失败");
                }
                net.sf.json.JSONArray jsonArray2 = net.sf.json.JSONArray.fromObject(DS);//并将DS内容取出转为json数组
                for (int j = 0; j < jsonArray2.size(); j++) {     //遍历json数组内容
                    net.sf.json.JSONObject object = jsonArray2.getJSONObject(j);
                    purchaseList.setId(UUID.randomUUID().toString());
                    purchaseList.setRequestId(id2);//上面刚刚创建的采购申请数据的id
                    purchaseList.setProjectId(projectId);//所属项目id
                    purchaseList.setContent(object.getString("content"));//需求说明
                    purchaseList.setDemander(object.getString("demander"));//需求人姓名
                    BigDecimal b=new BigDecimal(object.getLong("quantity"));
                    purchaseList.setQuantity(b);//数量
                    purchaseList.setUnit(object.getString("unit"));//单位
                    purchaseList.setSpec(object.getString("spec"));//规格
                    purchaseList.setModel(object.getString("model"));//型号
                    purchaseList.setName(object.getString("name"));//品名
                    purchaseList.setBrand(object.getString("brand"));//品牌
                    purchaseList.setCreater(ownerId);//创建人id
                    purchaseList.setCreateTime(new Date());//创建时间
                    int i1 = purchaseListMapper.insertPurchaseListSelective(purchaseList);
                    if(i1==0){
                        return new ResponseMessage(Code.CODE_ERROR,"采购清单列表添加失败！",i1);
                    }
                }
                //接下来再新增一条他自己的的流程记录
                TWorkflowstep tWorkflowstep = new TWorkflowstep();
                tWorkflowstep.setId(UUID.randomUUID().toString());
                tWorkflowstep.setRelateddomain("采购申请");
                tWorkflowstep.setRelateddomainId(id2);
                tWorkflowstep.setPrestepId("0提交");
                tWorkflowstep.setStepDesc("提交采购申请");
                tWorkflowstep.setActionuserId(ownerId);
                tWorkflowstep.setActionTime(new Date());
                tWorkflowstep.setActionResult(0);
                tWorkflowstep.setActionuserId(actionuserId);
                tWorkflowstep.setStatus("1");
                //排序字段  1:提交   暂存是没有流程记录的智力用0作为他自己的开始起点
                tWorkflowstep.setBackup3("0");
                tWorkflowstep.setBackUp7(ownerName);
                int i4 = tWorkflowstepMapper.insertSelective(tWorkflowstep);
                if (i4 != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "生成当前人记录失败");
                }
                //遍历添加部门负责人记录
                for (int i = 0; i < jsonArray1.size(); i++) {
                    JSONObject jo = jsonArray1.getJSONObject(i);
                    TWorkflowstep tWorkflowstep2 = new TWorkflowstep();
                    tWorkflowstep2.setId(UUID.randomUUID().toString());
                    tWorkflowstep2.setRelateddomain("采购申请");
                    tWorkflowstep2.setRelateddomainId(id2);
                    tWorkflowstep2.setPrestepId(tWorkflowstep.getId());
                    tWorkflowstep2.setStepDesc("采购办人员审核");
                    //审批人id
                    String approveUserId = jo.getString("approveUserId");
                    String approveUserName = jo.getString("approveUserName");
                    tWorkflowstep2.setBackUp7(approveUserName);
                    tWorkflowstep2.setActionuserId(approveUserId);
                    tWorkflowstep2.setStatus("0");
                    //
                    tWorkflowstep2.setBackup3("1");
                    tWorkflowstep2.setBackUp7(approveUserName);
                    int f2 = tWorkflowstepMapper.insertSelective(tWorkflowstep2);
                    if (f2 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加流程表信息失败");
                    }
                    TTodo todo = new TTodo();
                    todo.setId(UUID.randomUUID().toString());
                    todo.setCurrentstepId(tWorkflowstep2.getId());
                    todo.setStepDesc("采购办人员审核");
                    todo.setRelateddomain("采购申请");
                    todo.setRelateddomainId(id);
                    todo.setSenderId(ownerId);
                    todo.setSenderTime(currentTime);
                    todo.setReceiverId(approveUserId);
                    TXietongDictionaryExample example = new TXietongDictionaryExample();
                    TXietongDictionaryExample.Criteria criteria = example.createCriteria();
                    criteria.andTypeIdEqualTo("8");
                    criteria.andTypeCodeEqualTo("38");
                    criteria.andMidValueEqualTo("1");
                    List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
                    todo.setTodoType(dictionaryList.get(0).getMainValue());
                    todo.setStatus("0");
                    todo.setBackUp7(ownerName);
                    int i5 = todoMapper.insertSelective(todo);
                    if (i5 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "提交失败");
                    }
                }

                return new ResponseMessage(Code.CODE_OK, "提交成功");
            }
            //id不为空 主记录已经暂存过  存在id   更新主表状态
            else {
                purchaseRequest.setId(id);
                int f = purchaseRequestMapper.updateByPrimaryKeySelective(purchaseRequest);
                if (f != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "更新采购申请失败");
                }
                net.sf.json.JSONArray jsonArray3 = net.sf.json.JSONArray.fromObject(DS);//并将DS内容取出转为json数组
                for (int j = 0; j < jsonArray3.size(); j++) {     //遍历json数组内容
                    net.sf.json.JSONObject object = jsonArray3.getJSONObject(j);
                    purchaseList.setId(object.getString("id"));
                    purchaseList.setContent(object.getString("content"));//需求说明
                    purchaseList.setDemander(object.getString("demander"));//需求人id
                    BigDecimal b = new BigDecimal(object.getLong("quantity"));
                    purchaseList.setQuantity(b);//数量
                    purchaseList.setUnit(object.getString("unit"));//单位
                    purchaseList.setSpec(object.getString("spec"));//规格
                    purchaseList.setModel(object.getString("model"));//型号
                    purchaseList.setName(object.getString("name"));//品名
                    purchaseList.setBrand(object.getString("brand"));//品牌

                    purchaseList.setRequestId(id);
                    int i1 = purchaseListMapper.updateByRequestId(purchaseList);
                    if(i1==0){
                        return new ResponseMessage(Code.CODE_ERROR,"采购清单列表修改失败！",i1);
                    }

                }
                //接下来再新增一条他自己的的流程记录
                TWorkflowstep tWorkflowstep = new TWorkflowstep();
                tWorkflowstep.setId(UUID.randomUUID().toString());
                tWorkflowstep.setRelateddomain("采购申请");
                tWorkflowstep.setRelateddomainId(id);
                tWorkflowstep.setPrestepId("0提交");
                tWorkflowstep.setStepDesc("采购申请提交");
                tWorkflowstep.setActionuserId(ownerId);
                tWorkflowstep.setActionTime(new Date());
                tWorkflowstep.setActionResult(0);
                tWorkflowstep.setStatus("1");
                //排序字段  生成给自身为1
                tWorkflowstep.setBackup3("1");
                tWorkflowstep.setBackUp7(ownerName);
                int i4 = tWorkflowstepMapper.insertSelective(tWorkflowstep);
                if (i4 != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "生成当前人记录失败!");
                }
                //遍历添加部门负责人记录
                for (int i = 0; i < jsonArray1.size(); i++) {
                    JSONObject jo = jsonArray1.getJSONObject(i);
                    TWorkflowstep tWorkflowstep2 = new TWorkflowstep();
                    tWorkflowstep2.setId(UUID.randomUUID().toString());
                    tWorkflowstep2.setRelateddomain("采购申请");
                    tWorkflowstep2.setRelateddomainId(id);
                    tWorkflowstep2.setPrestepId(tWorkflowstep.getId());
                    tWorkflowstep2.setStepDesc("采购办人员审核");
                    //审批人id
                    String approveUserId = jo.getString("approveUserId");
                    String approveUserName = jo.getString("approveUserName");
                    tWorkflowstep2.setBackUp7(approveUserName);
                    tWorkflowstep2.setActionuserId(approveUserId);
                    tWorkflowstep2.setStatus("0");
                    //提交给部门负责人为2
                    tWorkflowstep2.setBackup3("2");
                    tWorkflowstep2.setBackUp7(approveUserName);
                    int f2 = tWorkflowstepMapper.insertSelective(tWorkflowstep2);
                    if (f2 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加流程表信息失败");
                    }
                    TTodo todo = new TTodo();
                    todo.setId(UUID.randomUUID().toString());
                    todo.setCurrentstepId(tWorkflowstep2.getId());
                    todo.setStepDesc("采购办人员审核");
                    todo.setRelateddomain("采购申请");
                    todo.setRelateddomainId(id);
                    todo.setSenderId(ownerId);
                    todo.setSenderTime(currentTime);
                    todo.setReceiverId(approveUserId);
                    TXietongDictionaryExample example = new TXietongDictionaryExample();
                    TXietongDictionaryExample.Criteria criteria = example.createCriteria();
                    criteria.andTypeIdEqualTo("8");
                    criteria.andTypeCodeEqualTo("38");
                    criteria.andMidValueEqualTo("1");
                    List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
                    todo.setTodoType(dictionaryList.get(0).getMainValue());
                    todo.setStatus("0");
                    todo.setBackUp7(ownerName);
                    int i5 = todoMapper.insertSelective(todo);
                    if (i5 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "提交失败");
                    }
                }
                return new ResponseMessage(Code.CODE_OK, "提交成功");
            }
        }
        return new ResponseMessage(Code.CODE_OK, "提交暂存成功");
    }

    /**
     * 分页并模糊查询采购申请信息
     * @param responseBody
     * @return
     */
    @Override
    public ResponseMessage queryPurchaseRequestInfo(String responseBody) {
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        String status = jsonObject.getString("status");//0暂存1提交
        String projectId = jsonObject.getString("projectId");//所属项目id
        Date applyDate = jsonObject.getDate("applyDate");//采购申请时间
        String applicant = jsonObject.getString("applicant");//申请人姓名
        String ownerId = jsonObject.getString("ownerId");//当前登录人id
        String method = jsonObject.getString("method");//采购方式1:公开招标、2:邀请招标、3:竞争性谈判、4:询价、5:单一来源、6:其他
        int pageNo = jsonObject.getInteger("pageNo");
        int pageSize = jsonObject.getInteger("pageSize");

        Page<PurchaseRequest> page = new Page<>();
        int totalCount = purchaseRequestMapper.purchaseRequestCounts(projectId,applyDate,status,applicant,method);
        page.init(totalCount,pageNo,pageSize);
        List<PurchaseRequest> list = purchaseRequestMapper.queryPurchaseRequestInfo(projectId,applyDate,status,applicant,method,page.getRowNum(), page.getPageCount());
        for(PurchaseRequest purchaseRequest:list) {
            int count = tWorkflowstepMapper.isApprover(purchaseRequest.getId(), ownerId);
            if (count == 1) {
                purchaseRequest.setIsApprover("1");
            }else {
                purchaseRequest.setIsApprover("0");
            }
        }

        page.setList(list);
        if(CollectionUtils.isEmpty(list)){
            return  new ResponseMessage(Code.CODE_ERROR,"查询失败！",page);
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！",page);
    }


    /**
     * 审核采购流程 (通过按钮)
     * @return
     */
    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public ResponseMessage approvePurchaseRequest(String responseBody) {
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        //采购申请单的Id  从基本信息里面取
        String id = jsonObject.getString("id");
        /*//toWorkFlow表的id
        String pucharseReviewRecordsId = jsonObject.getString("pucharseReviewRecordsId");*/
        String ownerId = jsonObject.getString("ownerId");
        //处理结果,0:通过1:退回
        Integer actionResult = jsonObject.getInteger("actionResult");
        String actionComment = jsonObject.getString("actionComment");
        TWorkflowstep tWorkflowstep = new TWorkflowstep();
        tWorkflowstep.setActionuserId(ownerId);
        tWorkflowstep.setRelateddomainId(id);
        TWorkflowstep tWorkflowstep1 = this.tWorkflowstepMapper.selectByPDS(tWorkflowstep);
        tWorkflowstep.setActionTime(new Date());
        tWorkflowstep.setActionResult(actionResult);
        tWorkflowstep.setActionComment(actionComment);
        tWorkflowstep.setStatus("1");
        String id1 = tWorkflowstep1.getId();
        tWorkflowstep.setId(id1);

        int maxBackUp3 = this.tWorkflowstepMapper.queryBackUp3(id);
        int nowBackUp3=maxBackUp3+1;
        /* String prestep_id=workflowstepMapper.queryprestepId(id,);*/

        String StepDesc="";
        String stepTodo="";
        int  ss =1;

        /*if (nowBackUp3 == 2) {
            ss = nowBackUp3;
            stepTodo = "采购办人员审核";
            StepDesc="提交采购申请";
            nowBackUp3 = new Integer("3");
        }else if(nowBackUp3==3){
            ss=nowBackUp3;
            stepTodo = "采购办主任审核";
            StepDesc="采购办人员审核";
            nowBackUp3 = new Integer("4");
        }else if(nowBackUp3==4){
            ss=nowBackUp3;
            stepTodo="采购管理委员会审核";
            StepDesc="采购办主任审核";
            nowBackUp3 = new Integer("5");
        }else if(nowBackUp3==5){
            ss=nowBackUp3;
            stepTodo="执行董事审核";
            StepDesc="采购管理委员会审核";
            nowBackUp3 = new Integer("6");
        }else if (nowBackUp3==6){
            ss=nowBackUp3;
            stepTodo="";
            StepDesc="执行董事审核";
            nowBackUp3 = new Integer("7");
        }*/

        if (nowBackUp3 == 2) {
            StepDesc="提交采购申请";
        }else if(nowBackUp3==3){
            StepDesc="采购办人员审核";
        }else if(nowBackUp3==4){
            StepDesc="采购办主任审核";
        }else if(nowBackUp3==5){
            StepDesc="采购管理委员会审核";
        }else if (nowBackUp3==6){
            StepDesc="执行董事审核";
        }
        //获取所有审批人的id
        JSONArray jsonArray1 = jsonObject.getJSONArray("approvers");
        //遍历添加部门负责人记录
        for (int i = 0; i < jsonArray1.size(); i++) {
            JSONObject jo = jsonArray1.getJSONObject(i);
            TWorkflowstep tWorkflowstep2 = new TWorkflowstep();
            tWorkflowstep2.setId(UUID.randomUUID().toString());
            tWorkflowstep2.setRelateddomain("采购申请");
            tWorkflowstep2.setRelateddomainId(id);
            tWorkflowstep2.setPrestepId(tWorkflowstep.getId());
            tWorkflowstep2.setStepDesc(StepDesc);
            //审批人id
            String approveUserId = jo.getString("approveUserId");
            String approveUserName = jo.getString("approveUserName");
            tWorkflowstep2.setActionuserId(approveUserId);
            tWorkflowstep2.setActionTime(new Date());
            tWorkflowstep2.setStatus("0");
            //提交给部门负责人为2
            tWorkflowstep2.setBackup3(String.valueOf(nowBackUp3));
            tWorkflowstep2.setBackUp7(approveUserName);
            int f2 = this.tWorkflowstepMapper.insertSelective(tWorkflowstep2);
            if (f2 != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "添加流程表信息失败");
            }
            TTodo todo = new TTodo();
            todo.setId(UUID.randomUUID().toString());
            todo.setCurrentstepId(tWorkflowstep2.getId());
            todo.setStepDesc(StepDesc);
            todo.setRelateddomain("采购申请");
            todo.setRelateddomainId(id);
            todo.setSenderId(ownerId);
            todo.setSenderTime(currentTime);
            todo.setReceiverId(approveUserId);
            TXietongDictionaryExample example = new TXietongDictionaryExample();
            TXietongDictionaryExample.Criteria criteria = example.createCriteria();
            criteria.andTypeIdEqualTo("8");
            criteria.andTypeCodeEqualTo("38");
            criteria.andMidValueEqualTo("1");
            List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
            todo.setTodoType(dictionaryList.get(0).getMainValue());
            todo.setStatus("0");
            int i5 = todoMapper.insertSelective(todo);
            if (i5 != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "提交失败");
            }
        }
        int f= this.tWorkflowstepMapper.updateTWorkflowstepRecords(tWorkflowstep);
        if(f!=1){
            return  new ResponseMessage(Code.CODE_ERROR,"更新审批记录失败");
        }
        TTodo tTodo = new TTodo();
        tTodo.setRelateddomainId(id);
        tTodo.setReceiverId(ownerId);


        List<TTodo> tTodos = todoMapper.queryTodoIdByOthers(tTodo.getRelateddomainId(), tTodo.getReceiverId());
        for (int i = 0; i < tTodos.size(); i++) {
            if(tTodos.get(i).getSenderId().equals(tTodo.getReceiverId())){
                String id2=tTodos.get(i).getId();
                tTodo.setStatus("1");
                tTodo.setId(id2);
                int f2= todoMapper.updateByPrimaryKeySelective(tTodo);
                if(f2!=1){
                    return  new ResponseMessage(Code.CODE_ERROR,"更新待办失败");
                }
            }
        }
        int f3=purchaseRequestMapper.updatePurchaseRequestStatus(id,nowBackUp3+"");
        if(f3!=1){
            return new ResponseMessage(Code.CODE_ERROR,"更新主表状态失败");
        }
        return  new ResponseMessage(Code.CODE_OK ,"处理成功");

    }

    /**
     * 查询所有可用部门
     * @return
     */
    @Override
    public ResponseMessage findAllDepartment() {
        List<TDepartment> allDepartment = tDepartmentMapper.findAllDepartment();
        if(CollectionUtils.isEmpty(allDepartment)){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！！");
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！！",allDepartment);
    }

    /**
     * 查询所有审核流程--
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage queryAllWorkFlowStep(String requestBody) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(requestBody);
        String relateddomainId1 = jsonObject.getString("relateddomainId");
        List<TWorkflowstep> tWorkflowsteps = tWorkflowstepMapper.queryByRelateddomainId(relateddomainId1);
        if(CollectionUtils.isEmpty(tWorkflowsteps)){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",tWorkflowsteps);
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！",tWorkflowsteps);
    }

    /**
     * 退回
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage returnRecord(String requestBody) {
        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(requestBody);
        //采购申请单的Id  从基本信息里面取
        String id = jsonObject.getString("id");
        String ownerId = jsonObject.getString("ownerId");
        String actionComment = jsonObject.getString("actionComment");
        int f3=purchaseRequestMapper.updatePurchaseRequestStatus(id,"6");
        if(f3!=1){
            return new ResponseMessage(Code.CODE_ERROR,"更新主表状态失败");
        }
        TTodo tTodo = new TTodo();
        tTodo.setRelateddomainId(id);
        tTodo.setReceiverId(ownerId);
        tTodo.setStatus("1");
        int f2=todoMapper.updateTodoRecord(tTodo);
        String backUp3="6";
        TWorkflowstep tWorkflowstep = new TWorkflowstep();
        tWorkflowstep.setActionTime(new Date());
        tWorkflowstep.setActionResult(1);
        tWorkflowstep.setActionComment(actionComment);
        tWorkflowstep.setStatus("1");
        tWorkflowstep.setActionuserId(ownerId);
        tWorkflowstep.setRelateddomainId(id);
        tWorkflowstep.setBackup3(backUp3);
        int f=tWorkflowstepMapper.updatetWorkflowstepRecord(tWorkflowstep);
        if (f != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "退回失败");
        }
        //查询对应的步骤id;
        String  nowBackUp3="5";
        TWorkflowstep tWorkflowstep1=tWorkflowstepMapper.queryCurrentstepId(id,ownerId,nowBackUp3);
        TTodo todo = new TTodo();
        todo.setId(UUID.randomUUID().toString());
        todo.setCurrentstepId(tWorkflowstep1.getId());
        todo.setStepDesc("退回");
        todo.setRelateddomain("采购申请");
        todo.setRelateddomainId(id);
        todo.setSenderId(ownerId);
        todo.setSenderTime(currentTime);
        String  firstBackUp3="1";
        TWorkflowstep tWorkflowstep2=tWorkflowstepMapper.queryCurrentstepId(id,ownerId,firstBackUp3);
        todo.setReceiverId(tWorkflowstep2.getActionuserId());
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo("8");
        criteria.andTypeCodeEqualTo("38");
        criteria.andMidValueEqualTo("1");
        List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
        todo.setTodoType(dictionaryList.get(0).getMainValue());
        todo.setStatus("0");
        int i5 = todoMapper.insertSelective(todo);
        if (i5 != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "提交失败");
        }
        return new ResponseMessage(Code.CODE_OK, "退回成功");
        /*JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String application_id = jsonObject.getString("application_id");//采购记录id
        String workflowstep_id = jsonObject.getString("workflowstep_id");//采购流程id
        String stepDesc = jsonObject.getString("stepDesc");//当前流程步骤
        String stepDesc1 =  stepDesc.substring(0,stepDesc.length()-2);

        String user_id  = jsonObject.getString("user_id");//当前登录人id
        String user_name  = jsonObject.getString("user_name");//当前登录人姓名
        String action  = jsonObject.getString("action_commont");//处理意见
        String todoId =  jsonObject.getString("todoId");//当前步骤待办id
        String fistId =  jsonObject.getString("fistId");//项目负责人id
        String projectName = jsonObject.getString("projectName");//项目名字
        String projectId = jsonObject.getString("projectId");//项目id

        //将当前对应流程关闭
        TWorkflowstep workflowstep = new TWorkflowstep();
        workflowstep.setId(workflowstep_id);
        workflowstep.setStepDesc(stepDesc1+"退回");
        workflowstep.setStatus("1");
        workflowstep.setActionResult(1);
        workflowstep.setActionComment(action);
        workflowstep.setActionTime(new Date());
        int i = tWorkflowstepMapper.updateByPrimaryKeySelective(workflowstep);
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
        List<TWorkflowstep> tWorkflowsteps = tWorkflowstepMapper.selectByExample(example);
        if(tWorkflowsteps.size()==0){
            //如果当前审核人员只有一个的话则生成待办
            TTodo todo = new TTodo();
            todo.setId(String.valueOf(IDUtils.genItemId()));
            todo.setCurrentstepId(workflowstep_id);
            todo.setStepDesc(projectName+"的采购申请流程等待您的处理");
            todo.setRelateddomain("采购申请");
            todo.setRelateddomainId(application_id);
            todo.setSenderId(user_id);
            todo.setSenderTime(new Date());

            todo.setBackUp7(user_name);//发起人
            *//*ProjectApplication application = applicationMapper.selectByPrimaryKey(application_id);*//*
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

            //改变当前立项表状态为退回
            PurchaseRequest purchaseRequest = new PurchaseRequest();
            purchaseRequest.setId(application_id);
            //purchaseRequest.setEnable("0");
            purchaseRequest.setStatus("8");
            int i11 = purchaseRequestMapper.updateByPrimaryKeySelective(purchaseRequest);
            if(i11==0){
                return new ResponseMessage(Code.CODE_ERROR,"退回失败");
            }
        }else{
            PurchaseRequest purchaseRequest = new PurchaseRequest();
            purchaseRequest.setId(application_id);
            //purchaseRequest.setEnable("0");
            int i11 = purchaseRequestMapper.updateByPrimaryKeySelective(purchaseRequest);
            if(i11==0){
                return new ResponseMessage(Code.CODE_ERROR,"退回失败");
            }
        }
        //新增一条退回流程
            *//*TWorkflowstep tWorkflowstep = new TWorkflowstep();
            tWorkflowstep.setId(String.valueOf(IDUtils.genItemId()));
            tWorkflowstep.setRelateddomain("项目立项");
            tWorkflowstep.setRelateddomainId(application_id);
            tWorkflowstep.setPrestepId(workflowstep.getId());
            tWorkflowstep.setStepDesc(stepDesc1+"退回");
            tWorkflowstep.setActionuserId(user_id);
            tWorkflowstep.setActionTime(new Date());
            tWorkflowstep.setStatus("1");
            int i4 = workflowstepMapper.insertSelective(tWorkflowstep);
            if(i4!=1){
                return new ResponseMessage(Code.CODE_ERROR,"退回失败");
            }*//*
        return new ResponseMessage(Code.CODE_OK,"退回成功");*/
    }

    /**
     * 批量软删除采购申请信息
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage updateDeleteTimeByIds(List<String> ids) {
        PurchaseRequest purchaseRequest = null;
        for (int j = 0 ;j < ids.size() ; j++) {
            String id = ids.get(j);
            purchaseRequest = purchaseRequestMapper.selectByPrimaryKey(id);
            if(purchaseRequest.getDeleteTime()!=null){
                return new ResponseMessage(Code.CODE_ERROR,"删除失败","失败的项目问题id："+purchaseRequest.getId()+" ： "+purchaseRequest.getDeleteTime());
            }
            //去删除 清单表
            //查询出来所有列表数据，然后去获取这些数据的id 一个一个的去软删除
            List<PurchaseList> purchaseLists = purchaseListMapper.queryPurchaseList(id);
            for (int i = 0; i < purchaseLists.size(); i++) {
                String id1 = purchaseLists.get(i).getId();
                int i1 = purchaseListMapper.updateDeleteTime(id1);
            }
        }
        int i = purchaseRequestMapper.updateDeleteTimeByIds(ids);


        if(i == 0){
            return new ResponseMessage(Code.CODE_ERROR,"批量删除失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"批量删除成功！",i);
    }

    /**
     * 根据id查询申请信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage queryPurchaseRequestById(String id) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(id);
        String ids = jsonObject.getString("id");
        PurchaseRequest purchaseRequest = purchaseRequestMapper.queryPurchaseRequestById(ids);
        List<TWorkflowstep> tWorkflowsteps = tWorkflowstepMapper.queryByRelateddomainId(ids);

        Map map = new HashMap();
        map.put("AA",purchaseRequest);
        map.put("BB",tWorkflowsteps);

        if(purchaseRequest==null){
            return new ResponseMessage(Code.CODE_ERROR,"信息查询失败！");
        }
        return new ResponseMessage(Code.CODE_OK,"信息查询成功！",map);
    }



    /**
     * 根据id修改采购信息
     * @param responseBody
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKeySelective(String responseBody) {

        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        String id = jsonObject.getString("id");
        String status = jsonObject.getString("status");//0暂存1提交
        String projectId = jsonObject.getString("projectId");//所属项目id
        String purchaseDept = jsonObject.getString("purchaseDept");//采购部门
        String applicantId = jsonObject.getString("applicantId");//申请人id
        String applicant = jsonObject.getString("applicant");//申请人姓名
        String method = jsonObject.getString("method");//采购方式1:公开招标、2:邀请招标、3:竞争性谈判、4:询价、5:单一来源、6:其他
        String agency = jsonObject.getString("agency");//代理机构
        BigDecimal amount = jsonObject.getBigDecimal("amount");//采购预算
        String content = jsonObject.getString("content");//内容说明(字段名字已改 原：desc 现：content)
        String creater = jsonObject.getString("creater");//创建人姓名
        String createrId = jsonObject.getString("createrId");//创建人id
        String DS = jsonObject.getString("DS");//获取导入的清单列表JSON数组字符串

        PurchaseRequest purchaseRequest = new PurchaseRequest();
        //purchaseRequest.setRequestNum(LSUtils.createOdd());
        purchaseRequest.setProjectId(projectId);//所属项目id
        purchaseRequest.setId(id);
        purchaseRequest.setCreater(creater);
        purchaseRequest.setStatus(status);
        //purchaseRequest.setCreateTime(new Date());
        purchaseRequest.setAgency(agency);
        purchaseRequest.setApplicant(applicant);
        purchaseRequest.setPurchaseDept(purchaseDept);
        purchaseRequest.setApplicantId(applicantId);
        purchaseRequest.setMethod(method);
        // purchaseRequest.setApplyDate(new Date());
        purchaseRequest.setAmount(amount);
        purchaseRequest.setContent(content);
        purchaseRequest.setCreaterId(createrId);
        if (StringUtils.isEmpty(id)) {
            return new ResponseMessage(Code.CODE_ERROR, "采购单的id未传！");
        }
        int i = purchaseRequestMapper.updateByPrimaryKeySelective(purchaseRequest);
        if (i == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "修改采购申请信息时失败！！", i);
        }
       /* String id1 = null;
        List<PurchaseList> purchaseLists = purchaseListMapper.queryByPurchaseRequestId(id);
        for (int x = 0; x < purchaseLists.size(); x++) {
            id1 = purchaseLists.get(x).getId();
        }*/
        PurchaseList purchaseList = new PurchaseList();
        net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(DS);//并将DS内容取出转为json数组
        for (int j = 0; j < jsonArray.size(); j++) {     //遍历json数组内容
            net.sf.json.JSONObject object = jsonArray.getJSONObject(j);

            //purchaseList.setId(UUID.randomUUID().toString());
            //purchaseList.setRequestId(id);//上面刚刚创建的采购申请数据的id
            //purchaseList.setProjectId(projectId);//所属项目id
            purchaseList.setId(object.getString("id"));
            purchaseList.setContent(object.getString("content"));//需求说明
            purchaseList.setDemander(object.getString("demander"));//需求人id
            BigDecimal b = new BigDecimal(object.getLong("quantity"));
            purchaseList.setQuantity(b);//数量
            purchaseList.setUnit(object.getString("unit"));//单位
            purchaseList.setSpec(object.getString("spec"));//规格
            purchaseList.setModel(object.getString("model"));//型号
            purchaseList.setName(object.getString("name"));//品名
            purchaseList.setBrand(object.getString("brand"));//品牌
            //purchaseList.setCreater(createrId);//创建人id
            //purchaseList.setCreateTime(new Date());//创建时间

            int i1 = purchaseListMapper.updateByPrimaryKeySelective(purchaseList);
            if(i1==0){
                return new ResponseMessage(Code.CODE_ERROR,"修改采购列表失败！！",i1);
            }

        }
        return new ResponseMessage(Code.CODE_OK, "修改采购申请信息时成功！！", i);
    }



}
