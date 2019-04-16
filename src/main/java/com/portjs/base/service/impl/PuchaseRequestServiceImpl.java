package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.PuchaseRequestService;
import com.portjs.base.util.Code;
import com.portjs.base.util.LSUtils;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.vo.FlashProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
    TDepartmentMapper tDepartmentMapper;

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
        //status为10：完成 ；0：暂存；1：提交（开始流程）2：根据前端传值来判断是暂存还是提交
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
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
        String actionuserId = jsonObject.getString("actionuserId");//处理人id
        String backUp7 = jsonObject.getString("backUp7");//处理人姓名
        String DS = jsonObject.getString("DS");//获取导入的清单列表JSON数组字符串
        if(StringUtils.isEmpty(status)){
            return new ResponseMessage(Code.CODE_ERROR,"Status"+PARAM_MESSAGE_1);
        }
        if(StringUtils.isEmpty(projectId)){
            return new ResponseMessage(Code.CODE_ERROR,"projectId"+PARAM_MESSAGE_1);
        }
        String id = UUID.randomUUID().toString();
        if(status=="0"){//暂存到purchase_request表里去
            PurchaseRequest purchaseRequest = new PurchaseRequest();
            purchaseRequest.setRequestNum(LSUtils.createOdd());
            purchaseRequest.setProjectId(projectId);//所属项目id
            purchaseRequest.setId(id);
            purchaseRequest.setCreater(creater);
            purchaseRequest.setStatus(status);

            purchaseRequest.setCreateTime(new Date());
            purchaseRequest.setAgency(agency);
            purchaseRequest.setApplicant(applicant);
            purchaseRequest.setPurchaseDept(purchaseDept);
            purchaseRequest.setApplicantId(applicantId);
            purchaseRequest.setMethod(method);
            purchaseRequest.setApplyDate(new Date());
            purchaseRequest.setAmount(amount);
            purchaseRequest.setContent(content);
            purchaseRequest.setCreaterId(createrId);

            int i = purchaseRequestMapper.insertPurchaseRequestSelective(purchaseRequest);

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
                purchaseList.setCreater(createrId);//创建人id
                purchaseList.setCreateTime(new Date());//创建时间

                int i1 = purchaseListMapper.insertPurchaseListSelective(purchaseList);
                if(i1==0){
                    return new ResponseMessage(Code.CODE_ERROR,"采购清单列表添加失败！",i1);
                }

            }
            if(i==0){
                return  new ResponseMessage(Code.CODE_ERROR,"添加采购申请单失败！",i);
            }

        }else if(status.equals("1")){
            PurchaseRequest purchaseRequest = new PurchaseRequest();
            purchaseRequest.setRequestNum(LSUtils.createOdd());
            purchaseRequest.setProjectId(projectId);//所属项目id
            purchaseRequest.setId(id);
            purchaseRequest.setCreater(creater);
            purchaseRequest.setStatus(status);
            purchaseRequest.setCreateTime(new Date());
            purchaseRequest.setAgency(agency);
            purchaseRequest.setApplicant(applicant);
            purchaseRequest.setPurchaseDept(purchaseDept);
            purchaseRequest.setApplicantId(applicantId);
            purchaseRequest.setMethod(method);
            purchaseRequest.setApplyDate(new Date());
            purchaseRequest.setAmount(amount);
            purchaseRequest.setContent(content);
            purchaseRequest.setCreaterId(createrId);

            int i = purchaseRequestMapper.insertPurchaseRequestSelective(purchaseRequest);

            PurchaseList purchaseList = new PurchaseList();

            net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(DS);//并将DS内容取出转为json数组
            for (int j = 0; j < jsonArray.size(); j++) {     //遍历json数组内容
                net.sf.json.JSONObject object = jsonArray.getJSONObject(j);

                purchaseList.setId(UUID.randomUUID().toString());
                purchaseList.setRequestId(id);//上面刚刚创建的采购申请数据的id
                purchaseList.setProjectId(projectId);//所属项目id
                purchaseList.setContent(object.getString("content"));//需求说明
                purchaseList.setDemander(object.getString("demander"));//需求人id
                BigDecimal b=new BigDecimal(object.getLong("quantity"));
                purchaseList.setQuantity(b);//数量
                purchaseList.setUnit(object.getString("unit"));//单位
                purchaseList.setSpec(object.getString("spec"));//规格
                purchaseList.setModel(object.getString("model"));//型号
                purchaseList.setName(object.getString("name"));//品名
                purchaseList.setBrand(object.getString("brand"));//品牌
                purchaseList.setCreater(createrId);//创建人id
                purchaseList.setCreateTime(new Date());//创建时间

                int i1 = purchaseListMapper.insertPurchaseListSelective(purchaseList);
                if(i1==0){
                    return new ResponseMessage(Code.CODE_ERROR,"采购清单列表添加失败！",i1);
                }

            }
            if(i==0){
                return  new ResponseMessage(Code.CODE_ERROR,"添加采购申请单失败！",i);
            }
            //存到流程表里
            TWorkflowstep tWorkflowstep = new TWorkflowstep();

            tWorkflowstep.setId(UUID.randomUUID().toString());
            tWorkflowstep.setStatus("0");//状态 0 ： 未完成   1：已完成
            //tWorkflowstep.setStepDesc();//步骤描述
            tWorkflowstep.setActionuserId(actionuserId);//处理人id
            tWorkflowstep.setBackUp7(backUp7);//处理人名字
            tWorkflowstep.setPrestepId(applicantId);//上一步流程id  发起申请的人的id
            tWorkflowstep.setRelateddomain("采购申请");//对应的业务模块
            tWorkflowstep.setRelateddomainId(id);//业务单id
            tWorkflowstep.setBackup3("0");//用来指定流程身份   0：提交采购申请 1：采购办人员审核 2：采购办主任审核 3：采购管理委员会审核 4：执行董事审核
            //tWorkflowstep.setActionResult();//处理结果,0:同意1:不同意
            //tWorkflowstep.setActionTime();//处理时间
            //tWorkflowstep.setActionComment();//处理意见
            int i1 = tWorkflowstepMapper.insertSelective(tWorkflowstep);
            if(i1 == 0 ){
                return new ResponseMessage(Code.CODE_ERROR,"存到流程表时失败！！！",i1);
            }
            TTodo todo = new TTodo();
            todo.setId(UUID.randomUUID().toString());
            todo.setStepDesc("有一条采购申请需要您的审核！");//步骤描述
            todo.setBackUp7(applicant);//发起人
            todo.setSenderId(applicantId);//发起人id
            todo.setStatus("0");//0：未完成 1：已完成
            todo.setTodoType("流程审批");//待办类型
            todo.setRelateddomainId(id);//业务单id
            todo.setReceiverId(actionuserId);//接收人
            todo.setSenderTime(new Date());//发送时间
            todo.setRelateddomain("采购申请");
            int i2 = todoMapper.insertSelective(todo);
            if(i2==0){
                return new ResponseMessage(Code.CODE_ERROR,"加入todo表失败!",i2);
            }

        }
        return new ResponseMessage(Code.CODE_OK,"操作成功");
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
        String method = jsonObject.getString("method");//采购方式1:公开招标、2:邀请招标、3:竞争性谈判、4:询价、5:单一来源、6:其他
        int pageNo = jsonObject.getInteger("pageNo");
        int pageSize = jsonObject.getInteger("pageSize");

        Page<PurchaseRequest> page = new Page<>();
        int totalCount = purchaseRequestMapper.purchaseRequestCounts(projectId,applyDate,status,applicant,method);
        page.init(totalCount,pageNo,pageSize);
        List<PurchaseRequest> list = purchaseRequestMapper.queryPurchaseRequestInfo(projectId,applyDate,status,applicant,method,page.getRowNum(), page.getPageCount());

        page.setList(list);
        if(!CollectionUtils.isEmpty(list)){
            responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功！",page);
        }
        return responseMessage;
    }



    /**
     * 审核采购流程 (通过按钮)
     * @return
     */
    @Override
    public ResponseMessage approvePurchaseRequest(String responseBody) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(responseBody);
        String relateddomainId = jsonObject.getString("relateddomainId");//业务单id
        String actionuserId = jsonObject.getString("actionuserId");//处理人id
        String backUp7 = jsonObject.getString("backUp7");//处理人名字
        Integer actionResult = jsonObject.getInteger("actionResult");//处理结果,0:同意1:不同意
        String actionComment = jsonObject.getString("actionComment");//处理意见

        //流程表里先改变指定给自己的数据的状态，然后生成一条指定给其他人的数据
        //更新别人传过来的数据，作为自己的数据
        TWorkflowstep tWorkflowstep = new TWorkflowstep();

        //tWorkflowstep.setId(UUID.randomUUID().toString());
        tWorkflowstep.setStatus("1");//状态 0 ： 未完成   1：已完成
        tWorkflowstep.setStepDesc("采购办人员审核");//步骤描述
        tWorkflowstep.setActionuserId(actionuserId);//处理人id
        tWorkflowstep.setBackUp7(backUp7);//处理人名字
        //tWorkflowstep.setPrestepId(applicantId);//上一步流程id
        tWorkflowstep.setRelateddomain("采购申请");//对应的业务模块
        tWorkflowstep.setRelateddomainId(relateddomainId);//业务单id
        tWorkflowstep.setBackup3("1");//用来指定流程身份   0：提交采购申请 1：采购办人员审核 2：采购办主任审核 3：采购管理委员会审核 4：执行董事审核
        tWorkflowstep.setActionResult(actionResult);//处理结果,0:同意1:不同意
        tWorkflowstep.setActionTime(new Date());//处理时间
        tWorkflowstep.setActionComment(actionComment);//处理意见

        int i = tWorkflowstepMapper.updateByPrimaryKeySelective(tWorkflowstep);
        //再添加一条数据给别人穿过去处理

        int i1 = tWorkflowstepMapper.insertSelective(tWorkflowstep);


        return null;
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
     * @param relateddomainId
     * @return
     */
    @Override
    public ResponseMessage queryAllWorkFlowStep(String relateddomainId) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(relateddomainId);
        String relateddomainId1 = jsonObject.getString("relateddomainId");
        List<TWorkflowstep> tWorkflowsteps = tWorkflowstepMapper.queryByRelateddomainId(relateddomainId1);
        if(CollectionUtils.isEmpty(tWorkflowsteps)){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",tWorkflowsteps);
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！",tWorkflowsteps);
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
        if(purchaseRequest==null){
            return new ResponseMessage(Code.CODE_ERROR,"信息查询失败！");
        }
        return new ResponseMessage(Code.CODE_OK,"信息查询成功！",purchaseRequest);
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
