package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.ProjectClarificaitonMapper;
import com.portjs.base.entity.ProjectClarificaiton;
import com.portjs.base.entity.PurchaseList;
import com.portjs.base.entity.PurchaseRequest;
import com.portjs.base.service.ProjectClarificaitonService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectClarificaitonServiceImpl implements ProjectClarificaitonService {
    ResponseMessage responseMessage = null;

    @Autowired
    ProjectClarificaitonMapper projectClarificaitonMapper;

    @Override
    public ResponseMessage insertSelective(ProjectClarificaiton record) {
        record.setId(UUID.randomUUID().toString());
        record.setCreateTime(new Date());
        int i = projectClarificaitonMapper.insertSelective(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"保存失败!",i);
        }
        return new ResponseMessage(Code.CODE_OK,"保存成功!",i);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(ProjectClarificaiton record) {
        if(record.getId().equals("")){
            return new ResponseMessage(Code.CODE_ERROR,"id未传!",record.getId()+"未找到");
        }
        int i = projectClarificaitonMapper.updateByPrimaryKeySelective(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"修改失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"修改成功！",i);
    }

    @Override
    public ResponseMessage queryByPage(String responseBody) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(responseBody);
        String projectCode = jsonObject.getString("projectCode");
        String projectName = jsonObject.getString("projectName");
        String projectManager = jsonObject.getString("projectManager");
        Integer pageNo = jsonObject.getInteger("pageNo");
        Integer pageSize = jsonObject.getInteger("pageSize");

        Page<ProjectClarificaiton> page = new Page<>();
        int totalCount = projectClarificaitonMapper.countsByProjectClarification(projectCode,projectName,projectManager);
        page.init(totalCount,pageNo,pageSize);
        List<ProjectClarificaiton> projectClarificaitons = projectClarificaitonMapper.queryByPage(projectCode, projectName, projectManager, page.getRowNum(), page.getPageCount());
        page.setList(projectClarificaitons);

        if(CollectionUtils.isEmpty(projectClarificaitons)){
            return  new ResponseMessage(Code.CODE_ERROR,"查询失败！",page);
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！",page);
    }

    @Override
    public ResponseMessage updateDeleteTimeByIds(List<String> ids) {
        ProjectClarificaiton projectClarificaiton = null;
        for (int j = 0 ;j < ids.size() ; j++) {
            String id = ids.get(j);
            projectClarificaiton = projectClarificaitonMapper.selectByPrimaryKey(id);
            if(StringUtils.isEmpty(String.valueOf(projectClarificaiton.getDeleteTime()))){
                return new ResponseMessage(Code.CODE_ERROR,"删除失败","失败的列表问题id："+projectClarificaiton.getId()+" ： "+projectClarificaiton.getDeleteTime());
            }
        }
        int i = projectClarificaitonMapper.updateDeleteTimeByIds(ids);

        if(i == 0){
            return new ResponseMessage(Code.CODE_ERROR,"批量删除失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"批量删除成功！",i);
    }
}
