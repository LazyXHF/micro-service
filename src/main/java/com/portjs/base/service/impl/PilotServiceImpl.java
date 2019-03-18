package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.PilotMapper;
import com.portjs.base.entity.Pilot;
import com.portjs.base.service.PilotService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
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
public class PilotServiceImpl implements PilotService {
    private String message = "";
    private Integer code;
    @Autowired
    private PilotMapper pilotMapper;
    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> id) {
        int count = 0;
        try {
            count =  pilotMapper.updateFalseDeletion(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"删除成功":"删除失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insert(Pilot record) {
        int count = 0;
        try {
            count =  pilotMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(Pilot construction) {
        if(StringUtils.isEmpty(construction.getProjectId())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目试点实施模块,projectId未传");
        }
        Pilot approval = new Pilot();
        approval.setProjectId(construction.getProjectId());
        List<Pilot> approvals = pilotMapper.selectByPrimaryKey(approval);
        if(!CollectionUtils.isEmpty(approvals)){
            approval.setEnable("1");
            pilotMapper.updateByPrimaryKeySelective(approval);
        }

        if(StringUtils.isEmpty(construction.getPlanStartTime().toString())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目试点实施模块,planStartTime未传");
        }
        if(StringUtils.isEmpty(construction.getPlanEndTime().toString())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目试点实施模块,planEndTime未传");
        }
        construction.setId(UUID.randomUUID().toString());
        construction.setCreater(UserUtils.getCurrentUser().getId());
        int count = 0;
        try {
            count =  pilotMapper.insertSelective(construction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage selectByPrimaryKey(Pilot record) {
        List<Pilot> design = null;
        try {
            design  =  pilotMapper.selectByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message,design);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(Pilot record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新项目建设试点实施模块,id未传");
            }
            record.setUpdater(UserUtils.getCurrentUser().getId());
            count =  pilotMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKey(Pilot record) {
        int count = 0;
        try {
            count =  pilotMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }
}
