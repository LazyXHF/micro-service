package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.DesignMapper;
import com.portjs.base.entity.Design;
import com.portjs.base.service.DesignService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author gumingyang
 **/
@Service
@Transactional
public class DesignServiceImpl  implements DesignService{
    private String message = "";
    private Integer code;
    @Autowired
    private DesignMapper designMapper;

    @Override
    public ResponseMessage deleteByPrimaryKey(String id) {
        int count = 0;
        try {
           count =  designMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"查询成功":"查询失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insert(Design record) {
        int count = 0;
        try {
            count =  designMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(String param) {
        JSONObject requestJson = JSONObject.parseObject(param);
        Design design = new Design();
        design.setId(UUID.randomUUID().toString());
        design.setProjectId(requestJson.getString("project_id"));
        int count = 0;
        try {
            count =  designMapper.insertSelective(design);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage selectByPrimaryKey(String id) {
        Design design = null;
        try {
            design  =  designMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = design == null?"查询成功":"查询失败";
        code = design == null?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message,design);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(Design record) {
        int count = 0;
        try {
            count =  designMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKey(Design record) {
        int count = 0;
        try {
            count =  designMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }
}
