package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.PucharseReviewService;
import com.portjs.base.util.Code;
import com.portjs.base.util.LSUtils;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
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
        //这是前段传过来的id  如果这个id存在说明已经暂存过  进行更新  如果为null 说明是新增
        String id = jsonObject.getString("id");
        //带出来的采购单id
        String request_id = jsonObject.getString("request_id");
        String  reviewNum= PucharseReviewServiceImpl.createOdd("CP");
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
        purchaseReview.setRequestId(request_id);
        purchaseReview.setReviewNum(reviewNum);
        purchaseReview.setProjectId(projectId);
        purchaseReview.setPurchaseDept(purchaseDept);
        purchaseReview.setMethod(method);
        purchaseReview.setSupplier(supplier);
        BigDecimal amount1 = new BigDecimal(amount);
        purchaseReview.setAmount(amount1);
        purchaseReview.setRemark(remark);
        purchaseReview.setSubmitTime(submit_time);
        purchaseReview.setCreater(ownerId);
        purchaseReview.setCreateTime(currentTime);
        purchaseReview.setIsDelete("0");
        InternalAttachment internalAttachment = new InternalAttachment();
        internalAttachment.setUploadTime(currentTime);
        internalAttachment.setUploader(ownerId);
        String fieModule = "采购评审";
        internalAttachment.setFileModule(fieModule);
        internalAttachment.setRelateddomain("采购评审");
        JSONArray jsonArray = jsonObject.getJSONArray("files");
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
                    internalAttachment.setId(UUID.randomUUID().toString());
                    String fileType = jo.getString("fileType");
                    internalAttachment.setFileType(fileType);
                    String filepath = jo.getString("filePath");
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
                return new ResponseMessage(Code.CODE_OK, "暂存成功");
            } else {
                purchaseReview.setId(id);
                int f = purchaseReviewMapper.updateByPrimaryKeySelective(purchaseReview);
                if (f != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "更新采购评审失败");
                }
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jo = jsonArray.getJSONObject(i);
                    String fileid=jo.getString("id");
                    String fileType = jo.getString("fileType");
                    internalAttachment.setFileType(fileType);
                    String filepath = jo.getString("filepath");
                    String fileName = jsonObject.getString("fileName");
                    internalAttachment.setId(fileid);
                    internalAttachment.setFileUrl(filepath);
                    internalAttachment.setFileName(fileName);
                    String relateddomainId = id;
                    internalAttachment.setRelateddomainId(relateddomainId);
                    int ff = internalAttachmentMapper.updateByrelateddomainId(internalAttachment);
                    if (ff != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "修改附件信息失败");
                    }
                }
                return new ResponseMessage(Code.CODE_OK, "暂存成功");
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
                    internalAttachment.setId(UUID.randomUUID().toString());
                    String fileType = jo.getString("fileType");
                    internalAttachment.setFileType(fileType);
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
                if (i4 != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "生成当前人记录失败");
                }
                //遍历添加部门负责人记录
                for (int i = 0; i < jsonArray1.size(); i++) {
                    JSONObject jo = jsonArray1.getJSONObject(i);
                    TWorkflowstep tWorkflowstep2 = new TWorkflowstep();
                    tWorkflowstep2.setId(UUID.randomUUID().toString());
                    tWorkflowstep2.setRelateddomain("采购评审");
                    tWorkflowstep2.setRelateddomainId(id2);
                    tWorkflowstep2.setPrestepId(tWorkflowstep.getId());
                    tWorkflowstep2.setStepDesc("采购评审提交");
                    //审批人id
                    String approveUserId = jo.getString("approveUserId");
                    String approveUserName = jo.getString("approveUserName");
                    tWorkflowstep2.setBackUp7(approveUserName);
                    tWorkflowstep2.setActionuserId(approveUserId);
                    tWorkflowstep2.setStatus("0");
                    tWorkflowstep2.setBackup3("2");
                    int f2 = workflowstepMapper.insertSelective(tWorkflowstep2);
                    if (f2 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加流程表信息失败");
                    }
                    TTodo todo = new TTodo();
                    todo.setId(UUID.randomUUID().toString());
                    todo.setCurrentstepId(tWorkflowstep2.getId());
                    todo.setStepDesc("采购评审提交");
                    todo.setRelateddomain("采购评审");
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
                purchaseReview.setId(id);
                purchaseReview.setStatus("0");
                int f = purchaseReviewMapper.updateByPrimaryKeySelective(purchaseReview);
                if (f != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "更新采购评审失败");
                }
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jo = jsonArray.getJSONObject(i);
                    String fileid=jo.getString("id");
                    String fileType = jo.getString("fileType");
                    internalAttachment.setFileType(fileType);
                    String filepath = jo.getString("filepath");
                    String fileName = jsonObject.getString("fileName");
                    internalAttachment.setId(fileid);
                    internalAttachment.setFileUrl(filepath);
                    internalAttachment.setFileName(fileName);
                    String relateddomainId = id;
                    internalAttachment.setRelateddomainId(relateddomainId);
                    int ff = internalAttachmentMapper.updateByrelateddomainId(internalAttachment);
                    if (ff != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "修改附件信息失败");
                    }
                }
                //接下来再新增一条他自己的的流程记录
                TWorkflowstep tWorkflowstep = new TWorkflowstep();
                tWorkflowstep.setId(UUID.randomUUID().toString());
                tWorkflowstep.setRelateddomain("采购评审");
                tWorkflowstep.setRelateddomainId(id);
                tWorkflowstep.setPrestepId("0提交");
                tWorkflowstep.setStepDesc("采购申请提交");
                tWorkflowstep.setActionuserId(ownerId);
                tWorkflowstep.setActionTime(new Date());
                tWorkflowstep.setActionResult(0);
                tWorkflowstep.setStatus("1");
                //排序字段  生成给自身为1
                tWorkflowstep.setBackup3("1");
                int i4 = workflowstepMapper.insertSelective(tWorkflowstep);
                if (i4 != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "生成当前人记录失败");
                }
                //遍历添加部门负责人记录
                for (int i = 0; i < jsonArray1.size(); i++) {
                    JSONObject jo = jsonArray1.getJSONObject(i);
                    TWorkflowstep tWorkflowstep2 = new TWorkflowstep();
                    tWorkflowstep2.setId(UUID.randomUUID().toString());
                    tWorkflowstep2.setRelateddomain("采购评审");
                    tWorkflowstep2.setRelateddomainId(id);
                    tWorkflowstep2.setPrestepId(tWorkflowstep.getId());
                    tWorkflowstep2.setStepDesc("采购评审提交");
                    //审批人id
                    String approveUserId = jo.getString("approveUserId");
                    String approveUserName = jo.getString("approveUserName");
                    tWorkflowstep2.setBackUp7(approveUserName);
                    tWorkflowstep2.setActionuserId(approveUserId);
                    tWorkflowstep2.setStatus("0");
                    //提交给部门负责人为2
                    tWorkflowstep2.setBackup3("2");
                    int f2 = workflowstepMapper.insertSelective(tWorkflowstep2);
                    if (f2 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加流程表信息失败");
                    }
                    TTodo todo = new TTodo();
                    todo.setId(UUID.randomUUID().toString());
                    todo.setCurrentstepId(tWorkflowstep2.getId());
                    todo.setStepDesc("采购评审提交");
                    todo.setRelateddomain("采购评审");
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

    @Override
    public ResponseMessage queryPucharseReview(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String projectCode = jsonObject.getString("projectCode");
        String projectName = jsonObject.getString("projectName");
        String  projectType= PucharseReviewServiceImpl.createOdd("projectType");
        String projectId = jsonObject.getString("project_id");
        String method = jsonObject.getString("method");
        return  null;
    }




    //生成流水单号
        private int number;
        private static PucharseReviewServiceImpl odd;
        @PostConstruct
        public void init() {
            odd = this;
        }
        /**
         * 编写测试流水订单号
         * 测试流水订单号规则：自动生成(PR+8位日期+4位流水号)  示例：LL201809270001
         * @param num
         * @return
         */
    public static String getBody(Integer num) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String str = String.format("%02d", num);
        return sdf.format(new Date()).substring(0, 8) + str;

    }
    /**
     *截取流水尾号转换数字
     * @param string
     * @return
     */
    public static int getOddCode(String string) {
        int oddCode = Integer.parseInt(string.substring(10));
        return oddCode;

    }
    /**
     * 截取流水单号入库日期
     * @param string
     * @return
     */
    public static int getOddSenttime(String string) {
        int oddSenttime = Integer.parseInt(string.substring(2, 10));
        return oddSenttime;

    }
    public static int getNowTimeCode() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        int nowTimeCode = Integer.parseInt(simpleDateFormat.format(new Date()).substring(0, 8));
        return nowTimeCode;
    }
    public static String createOdd(String cp) {
        String nowOdd=null;
        String oddMaxCode = odd.purchaseReviewMapper.findMaxOdd();
        //如果最大流水单号不为空
        if (!StringUtils.isEmpty(oddMaxCode)) {
            //如果当前时间不相同，例如：20181009=！20180809，重新开始以当天日期拼流水单号201810100001
            if (getNowTimeCode() != getOddSenttime(oddMaxCode)) {
                int number = 1;
                PurchaseRequest express = new PurchaseRequest();
                express.setRequestNum(cp+getBody(number));
                nowOdd = express.getRequestNum();
                //相同，则加1，例如：201810100002
            }else {
                int number = odd.getOddCode(oddMaxCode);
                PurchaseRequest express = new PurchaseRequest();
                express.setRequestNum("CP"+getBody(getOddCode(oddMaxCode)+1));
                nowOdd = express.getRequestNum();
            }
            //如果没有流水单号，以当前日期重新开始生成流水单号
        }else  {
            int number = 1;
            PurchaseRequest express = new PurchaseRequest();

            express.setRequestNum("CP"+getBody(number));

            nowOdd = express.getRequestNum();
        }

        return nowOdd;
    }






}

