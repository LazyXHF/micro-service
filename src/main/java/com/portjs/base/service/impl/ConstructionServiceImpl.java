package com.portjs.base.service.impl;

import com.portjs.base.dao.ConstructionMapper;
import com.portjs.base.entity.Construction;
import com.portjs.base.service.ConstructionService;
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
public class ConstructionServiceImpl implements ConstructionService {
    private String message = "";
    private Integer code;
    @Autowired
    private ConstructionMapper constructionMapper;

    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> id) {
        int count = 0;
        try {
            count =  constructionMapper.updateFalseDeletion(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"删除成功":"删除失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insert(Construction record) {
        int count = 0;
        try {
            count =  constructionMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(Construction construction) {

        if(StringUtils.isEmpty(construction.getProjectId())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目开发模块,projectId未传");
        }
        Construction approval = new Construction();
        approval.setProjectId(construction.getProjectId());
        List<Construction> approvals = constructionMapper.selectByPrimaryKey(approval);
        if(!CollectionUtils.isEmpty(approvals)){
            approval.setEnable("1");
            constructionMapper.updateByPrimaryKeySelective(approval);
        }
        if(StringUtils.isEmpty(construction.getDevUnit())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目开发模块,devUnit未传");
        }
        if(StringUtils.isEmpty(construction.getPlanStartTime().toString())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目开发模块,planStartTime未传");
        }
        if(StringUtils.isEmpty(construction.getPlanEndTime().toString())){
            return new ResponseMessage(Code.CODE_ERROR , "添加项目开发模块,planEndTime未传");
        }
        construction.setId(UUID.randomUUID().toString());
        construction.setCreater(UserUtils.getCurrentUser().getId());

        int   count =  constructionMapper.insertSelective(construction);

        message = count > 0?"插入成功":"插入失败";
        code = count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage selectByPrimaryKey(Construction record) {
        List<Construction> design = null;
        try {
            design  =  constructionMapper.selectByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message,design);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(Construction record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新项目开发模块,id未传");
            }
            record.setUpdater(UserUtils.getCurrentUser().getId());
            count =  constructionMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKeyWithBLOBs(Construction record) {
        int count = 0;
        try {
            count =  constructionMapper.updateByPrimaryKeyWithBLOBs(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKey(Construction record) {
        int count = 0;
        try {
            count =  constructionMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }
}
