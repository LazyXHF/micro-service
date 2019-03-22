package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.ApprovalMapper;
import com.portjs.base.entity.Approval;
import com.portjs.base.service.ApprovalService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.Convert;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
    public ResponseMessage deleteByPrimaryKey(List<String> id) {
        int count = 0;
        try {
            count =  approvalMapper.updateApprovals(id);
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

        message = count > 0?"保存成功":"保存失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(JSONArray construction) {
        int count =0;
        //1.软删除库中数据2.插入
        for (int i =0;i<construction.size();i++){
            JSONObject object = construction.getJSONObject(i);
            Approval annex = JSONObject.toJavaObject(object, Approval.class);
            if(StringUtils.isEmpty(annex.getProjectId())){
                return new ResponseMessage(Code.CODE_ERROR , "添加项目立项模块,projectId未传");
            }
            Approval coord = new Approval();
            coord.setProjectId(annex.getProjectId());
            List<Approval> list = approvalMapper.selectByPrimaryKey(coord);
            if(!CollectionUtils.isEmpty(list)){
                coord.setEnable("1");
                approvalMapper.updateByPrimaryKeySelective(coord);
            }
        }
        for (int i =0;i<construction.size();i++){
            JSONObject object = construction.getJSONObject(i);
            Approval annex = JSONObject.toJavaObject(object, Approval.class);
            annex.setId(UUID.randomUUID().toString());
            annex.setCreater(UserUtils.getCurrentUser().getId());
            count = approvalMapper.insertSelective(annex);
        }
        message = count > 0?"保存成功":"保存失败";
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
