package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.PucharseReviewService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

/**
 * Created by Administrator on 2019/4/8.
 */

@Service
@Transactional
public class PucharseReviewServiceImpl implements PucharseReviewService {
    @Autowired
    PurchaseReviewMapper purchaseReviewMapper;
    @Autowired
    PurchaseRequestMapper purchaseRequestMapper;
    @Autowired
    InternalAttachmentMapper internalAttachmentMapper;
    @Autowired
    private TWorkflowstepMapper workflowstepMapper;
    @Autowired
    private TXietongDictionaryMapper dictionaryMapper;
    @Autowired
    private TTodoMapper todoMapper;

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

    //根据purchase_request表进行条件查询
    @Override
    public ResponseMessage queryPucharseList(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        //采购方式
        String method = jsonObject.getString("method");
        //项目编码
        String projectCode = jsonObject.getString("projectCode");
        //项目名称
        String projectName = jsonObject.getString("projectName");
        int pageNum = jsonObject.getInteger("pageNum");
        int pageCount = jsonObject.getInteger("pageCount");
        PageHelper.startPage(pageNum, pageCount);
        List list = purchaseRequestMapper.queryPucharseList(method, projectCode, projectName);
        if (list.isEmpty()) {
            return new ResponseMessage(Code.CODE_OK, "分页信息为空");
        }
        PageInfo pageInfo = new PageInfo(list);
        return new ResponseMessage(Code.CODE_OK, "采购单信息列表", pageInfo);
    }


    @Override
    public ResponseMessage addPucharseReview(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        //申请单
        //这是前段传过来的id  如果这个id存在寿命已经暂存过  进行更新  如果为null 说明是新增
        String id = jsonObject.getString("id");
        String requestNum = jsonObject.getString("request_num");
        String projectId = jsonObject.getString("project_id");
        String method = jsonObject.getString("method");
        //供应商
        String supplier = jsonObject.getString("supplier");
        //成交金额
        String amount = jsonObject.getString("amount");
        String purchaseDept = jsonObject.getString("purchaseDept");
        Date submit_time = jsonObject.getDate("submit_time");
        String remark = jsonObject.getString("remark");
        //暂存和提交
        String status = jsonObject.getString("status");
        String ownerId = jsonObject.getString("ownerId");
        String ownerName = jsonObject.getString("ownerName");
        //指定处理人的id
        String actionuserId = jsonObject.getString("actionuserId");
        PurchaseReview purchaseReview = new PurchaseReview();
        purchaseReview.setRequestId(requestNum);
        purchaseReview.setProjectId(projectId);
        purchaseReview.setPurchaseDept(purchaseDept);
        purchaseReview.setMethod(method);
        purchaseReview.setSupplier(supplier);
        BigDecimal amount1 = new BigDecimal(amount);
        purchaseReview.setAmount(amount1);
        purchaseReview.setRemark(remark);
        purchaseReview.setCreater(ownerId);
        purchaseReview.setCreateTime(currentTime);
        purchaseReview.setIsDelete("0");
        InternalAttachment internalAttachment = new InternalAttachment();
        internalAttachment.setId(UUID.randomUUID().toString());
        internalAttachment.setUploadTime(currentTime);
        internalAttachment.setUploader(ownerId);
        String fieModule = "采购评审";
        internalAttachment.setFileModule(fieModule);
        internalAttachment.setRelateddomain("采购评审");


        JSONArray jsonArray = jsonObject.getJSONArray("filepaths");
        //获取所有审批人的id
        JSONArray jsonArray1 = jsonObject.getJSONArray("approvers");
        //status ：0  暂存  1  提交
        if (status.equals("0")) {
            purchaseReview.setStatus("0");
            //id 为空新增
            if (id.isEmpty()) {
                String id2 = UUID.randomUUID().toString();
                purchaseReview.setId(id2);
                int f = purchaseReviewMapper.insertSelective(purchaseReview);
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jo = jsonArray.getJSONObject(i);
                    String filepath = jo.getString("filepath");
                    String fileName = jsonObject.getString("fileName");
                    internalAttachment.setFileUrl(filepath);
                    internalAttachment.setFileName(fileName);
                    //业务单Id
                    String relateddomainId = id2;
                    internalAttachment.setRelateddomainId(relateddomainId);
                    int ff = internalAttachmentMapper.insertSelective(internalAttachment);
                    if (ff != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加附件信息失败");
                    }
                }
                if (f != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "添加采购评审失败");
                }
            } else {
                purchaseReview.setId(id);
                int f = purchaseReviewMapper.updateByPrimaryKeySelective(purchaseReview);
                if (f != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "更新采购评审失败");
                }
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jo = jsonArray.getJSONObject(i);
                    String filepath = jo.getString("filepath");
                    String fileName = jsonObject.getString("fileName");
                    internalAttachment.setFileUrl(filepath);
                    internalAttachment.setFileName(fileName);
                    String relateddomainId = id;
                    internalAttachment.setRelateddomainId(relateddomainId);
                    int ff = internalAttachmentMapper.updateByrelateddomainId(internalAttachment);
                    if (ff != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "修改附件信息失败");
                    }
                }
            }
            //提交
        } else if (status.equals("1")) {

            //id为空 直接添加
            if (id.isEmpty()) {
                String id2 = UUID.randomUUID().toString();
                purchaseReview.setId(id2);
                int f = purchaseReviewMapper.insertSelective(purchaseReview);
                if (f != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "添加采购评审失败");
                }
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jo = jsonArray.getJSONObject(i);
                    String filepath = jo.getString("filepath");
                    String fileName = jsonObject.getString("fileName");
                    internalAttachment.setFileUrl(filepath);
                    internalAttachment.setFileName(fileName);
                    //业务单Id
                    String relateddomainId = id2;
                    internalAttachment.setRelateddomainId(relateddomainId);
                    int ff = internalAttachmentMapper.insertSelective(internalAttachment);
                    if (ff != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加附件信息失败");
                    }
                }
                //接下来再新增一条他自己的的流程记录
                TWorkflowstep tWorkflowstep = new TWorkflowstep();
                tWorkflowstep.setId(UUID.randomUUID().toString());
                tWorkflowstep.setRelateddomain("采购评审");
                tWorkflowstep.setRelateddomainId(id2);
                tWorkflowstep.setPrestepId("0提交");
                tWorkflowstep.setStepDesc("采购申请提交");
                tWorkflowstep.setActionuserId(ownerId);
                tWorkflowstep.setActionTime(new Date());
                tWorkflowstep.setActionResult(0);
                tWorkflowstep.setStatus("1");
                //排序字段
                tWorkflowstep.setBackup3("1");
                int i4 = workflowstepMapper.insertSelective(tWorkflowstep);
                if(i4!=1){
                    return new ResponseMessage(Code.CODE_ERROR,"生成当前人记录失败");
                }
                //遍历添加部门负责人记录
                for (int i = 0; i < jsonArray1.size(); i++) {
                    JSONObject jo = jsonArray1.getJSONObject(i);
                    TWorkflowstep tWorkflowstep2= new TWorkflowstep();
                    tWorkflowstep2.setId(UUID.randomUUID().toString());
                    tWorkflowstep2.setRelateddomain("采购评审");
                    tWorkflowstep2.setRelateddomainId(id2);
                    tWorkflowstep2.setPrestepId(tWorkflowstep.getId());
                    tWorkflowstep2.setStepDesc("采购评审提交");
                    String userId = jo.getString("userId");
                    tWorkflowstep2.setActionuserId(userId);
                    tWorkflowstep2.setStatus("0");
                    tWorkflowstep2.setBackup3("2");
                    int f2 = workflowstepMapper.insertSelective(tWorkflowstep2);
                    TTodo todo = new TTodo();
                    todo.setId(UUID.randomUUID().toString());
                    todo.setCurrentstepId(tWorkflowstep2.getId());
                    todo.setStepDesc("采购评审提交");
                    todo.setRelateddomain("采购评审");
                    todo.setRelateddomainId(id);
                    todo.setSenderId(ownerId);
                    todo.setSenderTime(currentTime);
                    todo.setReceiverId(userId);
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
                    if (f2 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加流程表信息失败");
                    }

                }




            } else {


            }


        }



        //接下来再新增一条部门负责人的流程记录
        TWorkflowstep tWorkflowstep2 = new TWorkflowstep();
        tWorkflowstep2.setId(UUID.randomUUID().toString());
        tWorkflowstep2.setRelateddomain("采购评审");
        tWorkflowstep2.setPrestepId("0");
        tWorkflowstep2.setStepDesc("采购申请提交");
        tWorkflowstep2.setActionuserId(actionuserId);
        tWorkflowstep2.setEnable("1");
        tWorkflowstep2.setStatus("0");
        tWorkflowstep2.setRelateddomainId(id);
        tWorkflowstep2.setActionuserId(ownerId);
        int f3 = workflowstepMapper.insertSelective(tWorkflowstep2);
        if (f3 != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "添加流程表信息失败");
        }

        JSONArray jsonArray2 = jsonObject.getJSONArray("approvers");

    return  null;

    }
}

