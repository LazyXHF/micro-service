package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.ProblemMapper;
import com.portjs.base.entity.Problem;
import com.portjs.base.service.ProblemService;
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
public class ProblemServiceImpl   implements ProblemService {
    private String message = "";
    private Integer code;
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public ResponseMessage insertProblem(Problem record) {
        int count = 0;
        record.setId(UUID.randomUUID().toString());
        record.setCreater(UserUtils.getCurrentUser().getId());
        count = problemMapper.insertSelective(record);

        message = count > 0?"保存成功":"保存失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> id) {
        int count = 0;
        try {
            count =  problemMapper.updateFalseDeletion(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"删除成功":"删除失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insert(Problem record) {
        int count = 0;
        try {
            count =  problemMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"保存成功":"保存失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(JSONArray data) {
        int count =0;
        for (int i =0;i<data.size();i++){
            JSONObject object = data.getJSONObject(i);
            Problem annex = JSONObject.toJavaObject(object, Problem.class);
            if(StringUtils.isEmpty(annex.getProjectId())){
                return new ResponseMessage(Code.CODE_ERROR , "添加项目问题,projectId未传");
            }
            //1.软删除库中数据2.插入
            Problem coord = new Problem();
            coord.setProjectId(annex.getProjectId());
            List<Problem> list = problemMapper.selectByPrimaryKey(coord);
            if(!CollectionUtils.isEmpty(list)){
                coord.setEnable("1");
                problemMapper.updateByPrimaryKeySelective(coord);
            }
        }
        for (int i =0;i<data.size();i++){
            JSONObject object = data.getJSONObject(i);
            Problem annex = JSONObject.toJavaObject(object, Problem.class);
            //组建bean
            annex.setId(UUID.randomUUID().toString());
            annex.setCreater(UserUtils.getCurrentUser().getId());
            count = problemMapper.insertSelective(annex);
        }
        message = count > 0?"保存成功":"保存失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage selectByPrimaryKey(String responseBody) {
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        String id=requestJson.getString("id");
        String projectId=requestJson.getString("projectId");
        String beginTime=requestJson.getString("beginTime");
        String problemType=requestJson.getString("problemType");
        String problemPriority=requestJson.getString("problemPriority");
        String proposer=requestJson.getString("proposer");
        String solve=requestJson.getString("solve");
        String endTime=requestJson.getString("endTime");
        List<Problem> design = null;
        try {
            design  =  problemMapper.queryBySomeThing(id,projectId,beginTime,endTime,problemType,problemPriority,proposer,solve);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message,design);
    }
/*
    @Override
    public ResponseMessage selectByPrimaryKey(Problem record) {
        List<Problem> design = null;
        try {
            design  =  problemMapper.selectByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message,design);
    }*/

    @Override
    public ResponseMessage updateByPrimaryKeySelective(Problem record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新项目问题,id未传");
            }
            record.setUpdater(UserUtils.getCurrentUser().getId());
            count =  problemMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKey(Problem record) {
        int count = 0;
        try {
            count =  problemMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }
}
