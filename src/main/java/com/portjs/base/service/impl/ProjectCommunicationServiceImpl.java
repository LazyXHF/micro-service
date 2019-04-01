package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.ProjectCommunicationMapper;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.service.ProjectCommunicationService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectCommunicationServiceImpl implements ProjectCommunicationService {
    ResponseMessage responseMessage = null;

    @Autowired
    ProjectCommunicationMapper projectCommunicationMapper;


    @Override
    public ResponseMessage deleteByPrimaryKey(String id) {

        return responseMessage;
    }

    /**
     * 项目问题沟通---添加问题
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertSelective(ProjectCommunication record) {
        record.setId(UUID.randomUUID().toString());
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        try {
            Date time = sdf.parse(nowTime);
            record.setCreateTime(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(record.getProjectId())){
            return new ResponseMessage(Code.CODE_ERROR,"添加信息时未选择项目！");
        }
        int i = projectCommunicationMapper.insertSelective(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加信息失败！",i);

        }
        return new ResponseMessage(Code.CODE_OK,"添加信息成功！",i);
    }

    /**
     * 项目问题沟通---分页并模糊查询问题信息
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage queryProjectCommunicationInfo(String requestBody) {
        JSONObject jsonObject=JSONObject.parseObject(requestBody);
        String projectId = jsonObject.getString("projectId");
        String classification = jsonObject.getString("classification");//问题分类
        String priority = jsonObject.getString("priority");//优先级
        String sponsor = jsonObject.getString("sponsor");//发起人
        String phase = jsonObject.getString("phase");//项目所处阶段
        int pageNo = jsonObject.getInteger("pageNo");
        int pageSize = jsonObject.getInteger("pageSize");

        if(StringUtils.isEmpty(projectId)){
            return new ResponseMessage(Code.CODE_ERROR,"查询时项目id未传!",projectId);
        }

        Page<InternalPersionResource> page = new Page<>();
        int totalCount = projectCommunicationMapper.projectCommunicationCounts(projectId,classification,priority,sponsor,phase);
        page.init(totalCount,pageNo,pageSize);
        List<InternalPersionResource> list = projectCommunicationMapper.queryProjectCommunicationInfo(projectId,classification,priority,sponsor,phase,page.getRowNum(), page.getPageCount());
        page.setList(list);

        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功！",page);

        return responseMessage;
    }

    /**
     * 批量软删除（通过添加删除时间字段来实现软删除，如果此字段里不为null则删除成功！）
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage insertDeleteTime(List<String> ids) {
        ProjectCommunication projectCommunication = null;
        int i = projectCommunicationMapper.insertDeleteTime(ids);
        for (String id:ids) {
           projectCommunication = projectCommunicationMapper.selectByPrimaryKey(id);
           if(StringUtils.isEmpty(projectCommunication.getDeleteTime().toString())){
               return new ResponseMessage(Code.CODE_ERROR,"删除失败","失败的项目问题id"+projectCommunication.getId()+" : "+projectCommunication.getDeleteTime());
           }
        }
        if(i == 0){
            return new ResponseMessage(Code.CODE_ERROR,"批量删除失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"批量删除成功！",i);
    }

    /**
     * 项目问题沟通---修改问题
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKeySelective(ProjectCommunication record) {

        if(StringUtils.isEmpty(record.getId())){
            return new ResponseMessage(Code.CODE_ERROR,"修改信息时未选中信息！");
        }
        int i = projectCommunicationMapper.updateByPrimaryKeySelective(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"修改信息失败！",i);

        }
        return new ResponseMessage(Code.CODE_OK,"修改信息成功！",i);
    }
}
