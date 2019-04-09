package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.portjs.base.dao.InternalAttachmentMapper;
import com.portjs.base.dao.PurchaseRequestMapper;
import com.portjs.base.dao.PurchaseReviewMapper;
import com.portjs.base.dao.TWorkflowstepMapper;
import com.portjs.base.entity.*;
import com.portjs.base.service.PucharseReviewService;
import com.portjs.base.util.Code;
import com.portjs.base.util.IDUtils;
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
        InternalAttachmentMapper  internalAttachmentMapper;
        @Autowired
        private TWorkflowstepMapper workflowstepMapper;
        Date currentTime=this.getCurrentTime();
        public  Date  getCurrentTime(){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date time = null;
            try {
                time = sdf.parse(sdf.format(new Date()));
                return  time;
            } catch (Exception e) {
                e.printStackTrace();
                return time;
            }
        }
    //根据purchase_request表进行条件查询
        @Override
        public ResponseMessage  queryPucharseList(String requestBody){
        JSONObject jsonObject=JSONObject.parseObject(requestBody);
        //采购方式
        String method=jsonObject.getString("method");
        //项目编码
        String projectCode=jsonObject.getString("projectCode");
        //项目名称
        String projectName=jsonObject.getString("projectName");
        int pageNum = jsonObject.getInteger("pageNum");
        int pageCount = jsonObject.getInteger("pageCount");
        PageHelper.startPage(pageNum,pageCount);
        List list=purchaseRequestMapper.queryPucharseList(method,projectCode,projectName);
        if(list.isEmpty()){
            return  new ResponseMessage(Code.CODE_OK,"分页信息为空");
        }
        PageInfo pageInfo=new PageInfo(list);
        return  new ResponseMessage(Code.CODE_OK,"采购单信息列表",pageInfo);
    }


/*
        @Override
        public ResponseMessage addPucharseReview(String requestBody) {
            JSONObject jsonObject=JSONObject.parseObject(requestBody);
            //申请单
            String requestNum=jsonObject.getString("request_num");
            String projectId=jsonObject.getString("project_id");
            String method=jsonObject.getString("method");
            //供应商
            String supplier=jsonObject.getString("supplier");
            //成交金额
            String amount=jsonObject.getString("amount");
            String purchaseDept=jsonObject.getString("purchaseDept");
            Date submit_time=jsonObject.getDate("submit_time");
            String remark=jsonObject.getString("remark");
            //暂存和提交
            String status=jsonObject.getString("status");
            String ownerId=jsonObject.getString("ownerId");
            //指定处理人的id
            String actionuserId=jsonObject.getString("actionuserId");
            PurchaseReview  purchaseReview=new PurchaseReview();
            String id= UUID.randomUUID().toString();
            purchaseReview.setId(id);
            purchaseReview.setRequestId(requestNum);
            purchaseReview.setProjectId(projectId);
            purchaseReview.setPurchaseDept(purchaseDept);
            purchaseReview.setMethod(method);
            purchaseReview.setSupplier(supplier);
            BigDecimal amount1=new BigDecimal(amount);
            purchaseReview.setAmount(amount1);
            purchaseReview.setRemark(remark);
            purchaseReview.setStatus(status);
            purchaseReview.setCreater(ownerId);
            purchaseReview.setCreateTime(currentTime);
            purchaseReview.setIsDelete("0");

            InternalAttachment internalAttachment=new InternalAttachment();
            internalAttachment.setId(UUID.randomUUID().toString());
            internalAttachment.setUploadTime(currentTime);
            internalAttachment.setUploader(ownerId);
            String fieModule="采购评审";
            //业务单Id
            String relateddomainId=id;
            internalAttachment.setFileModule(fieModule);
            internalAttachment.setRelateddomain("采购评审");
            internalAttachment.setRelateddomainId(relateddomainId);
            JSONArray jsonArray=jsonObject.getJSONArray("filepaths");
            for(int i=0;i<jsonArray.size();i++){
                JSONObject jo = jsonArray.getJSONObject(i);
                String filepath=jo.getString("filepath");
                String fileName=jsonObject.getString("fileName");
                internalAttachment.setFileUrl(filepath);
                internalAttachment.setFileName(fileName);
                int f=internalAttachmentMapper.insertSelective(internalAttachment);
                if(f!=1){
                    return new ResponseMessage(Code.CODE_ERROR,"添加附件信息失败");
                }
            }
            TWorkflowstep tWorkflowstep=new TWorkflowstep();
            tWorkflowstep.setId(UUID.randomUUID().toString());
            tWorkflowstep.setRelateddomain("采购评审");
            tWorkflowstep.setPrestepId("0");
            tWorkflowstep.setStepDesc("采购申请提交");
            tWorkflowstep.setActionuserId(actionuserId);
            tWorkflowstep.setEnable("1");
            tWorkflowstep.setStatus("0");
            tWorkflowstep.setRelateddomainId(id);
            //获取所有审批人的id
            JSONArray jsonArray1=jsonObject.getJSONArray("approvers");
            for(int i=0;i<jsonArray1.size();i++){
                JSONObject jo=jsonArray1.getJSONObject(i);
                String userId=jo.getString("userId");
                tWorkflowstep.setActionuserId(userId);
                int f2= workflowstepMapper.insertSelective(tWorkflowstep);
                if(f2!=1){
                    return new ResponseMessage(Code.CODE_ERROR,"添加流程表信息失败");
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
            if(f3!=1){
                return new ResponseMessage(Code.CODE_ERROR,"添加流程表信息失败");
            }
            TTodo todo = new TTodo();
            todo.setId(UUID.randomUUID().toString());
            todo.setCurrentstepId(tWorkflowstep2.getId());
            todo.setStepDesc("采购评审提交");
            todo.setRelateddomain("采购评审");
            todo.setRelateddomainId(id);
            todo.setSenderId(ownerId);
            todo.setSenderTime(currentTime);
            todo.setReceiverId(nextViewJSON.getString(i));
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







            return  null;

        }*/
    }

