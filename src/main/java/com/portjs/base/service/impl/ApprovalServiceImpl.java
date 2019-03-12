package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.ApprovalMapper;
import com.portjs.base.entity.Approval;
import com.portjs.base.service.ApprovalService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author gumingyang
 **/
@Service
@Transactional
public class ApprovalServiceImpl implements ApprovalService {
    private String message = "";
    private Integer code;
    @Autowired
    private ApprovalMapper approvalMapper;

    @Override
    public ResponseMessage deleteByPrimaryKey(String id) {
        int count = 0;
        try {
            count =  approvalMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"删除成功":"删除失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insert(Approval record) {
        int count = 0;
        try {
            count =  approvalMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(String record) {
       JSONObject requestJson = JSONObject.parseObject(record);
        //组装bean
        Approval construction = JSONObject.toJavaObject(requestJson,Approval.class);
        if(StringUtils.isEmpty(construction.getProjectId())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目立项模块,projectId未传");
        }
        if(StringUtils.isEmpty(construction.getUnit())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目立项模块,unit未传");
        }
        if(StringUtils.isEmpty(construction.getMethod())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目立项模块,method未传");
        }
        if(StringUtils.isEmpty(construction.getCalibrationTime().toString())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目立项模块,calibrationTime未传");
        }
        if(StringUtils.isEmpty(construction.getSuccessfulBidder())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目立项模块,successfulBidder未传");
        }
        if(StringUtils.isEmpty(construction.getBiddingContent())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目立项模块,biddingContent未传");
        }
        if(construction.getAmount() == null){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目立项模块,amount未传");
        }
        construction.setId(UUID.randomUUID().toString());
        construction.setCreater(UserUtils.getCurrentUser().getId());
        int count = 0;
        try {
            count =  approvalMapper.insertSelective(construction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage selectByPrimaryKey(Approval record) {
        List<Approval> design = null;
        try {
            design  =  approvalMapper.selectByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message,design);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(Approval record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新项目立项模块,id未传");
            }
            record.setUpdater(UserUtils.getCurrentUser().getId());
            count =  approvalMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKeyWithBLOBs(Approval record) {
        int count = 0;
        try {
            count =  approvalMapper.updateByPrimaryKeyWithBLOBs(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKey(Approval record) {
        int count = 0;
        try {
            count =  approvalMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }
}
