package com.portjs.base.service.impl;

import com.portjs.base.dao.BusinessConfigurationMapper;
import com.portjs.base.dao.ProjectCommunicationMapper;
import com.portjs.base.dao.ProjectMapper;
import com.portjs.base.dao.TTodoMapper;
import com.portjs.base.entity.BusinessConfiguration;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.entity.TTodo;
import com.portjs.base.service.ProjectCommunicationService;
import com.portjs.base.util.Code;
import com.portjs.base.util.DealtWith;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.vo.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.PortUnreachableException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProjectCommunicationServiceImpl implements ProjectCommunicationService {
    ResponseMessage responseMessage = null;

    @Autowired
    ProjectCommunicationMapper projectCommunicationMapper;

    @Autowired
    BusinessConfigurationMapper businessConfigurationMapper;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    TTodoMapper todoMapper;

    @Autowired
    DealtWith dealtWith;

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
    public ResponseMessage insertProjectCommunicationSelective(ProjectCommunication record) {
        String id = UUID.randomUUID().toString();//风控表里的问题自身id
        record.setId(id);
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
        int i = projectCommunicationMapper.insertProjectCommunicationSelective(record);

        //再待办表里生成一条问题记录，并且选中了几个人就生成几条
        //先把选中人的id遍历取出来，之后根据这些id分别存入数据库


        /*JSONObject jsonObject = JSONObject.fromObject(record.getFollower());//字符串转json对象
        String data = jsonObject.getString("DS");//获取DS内容
        JSONArray jsonArray = JSONArray.fromObject(data);//并将DS内容取出转为json数组*/
//        JSONArray jsonArray= JSONArray.fromObject(record.getFollower());
//        for (int j = 0; j < jsonArray.size(); j++) {     //遍历json数组内容
//            TTodo todo = new TTodo();
//            JSONObject object = jsonArray.getJSONObject(j);
//            String name = object.getString("nameId");
//            //设置存入的值
//            String ids = UUID.randomUUID().toString();
//            todo.setId(ids);
//            todo.setSenderId(record.getBackup3());//发送人id
//            todo.setSenderTime(new Date());//发送时间
//            todo.setReceiverId(name);//接收人id（被提醒人）
//            todo.setRelateddomain("风控记录");//对应的业务模块
//            todo.setRelateddomainId(id);//把当前新建问题id存入待办表里
//            todo.setTodoType("事务处理");//待办类型
//            todo.setStatus("0");//0为待办未完成状态
//            todo.setBackup3(record.getPriority());//优先级
//            todo.setStepDesc(record.getTitle()+"存在问题，需要您的回复!");
//            todo.setBackUp7(record.getSponsor());//发起人姓名
//
//            //添加到待办表里
//            int i1 = todoMapper.insertSelective(todo);
//            if(i1==0){
//                return new ResponseMessage(Code.CODE_ERROR,"存入待办表失败！",i1);
//            }
//        }

        int i1 = dealtWith.dealtWithMethodStringArray(record.getFollower(),record.getSponsor(),record.getSponsor(),
                "风控记录",id,"事务处理",record.getTitle()+"存在问题，需要您的回复!",record.getPriority());


        if(i1==0){
                return new ResponseMessage(Code.CODE_ERROR,"存入待办表失败！",i1);
            }

        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加信息失败！",i);

        }
        return new ResponseMessage(Code.CODE_OK,"添加信息成功！",i);
    }

    /**
     * 根据id查询项目问题信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage queryProjectCommunicationById(String id) {
        ProjectCommunication projectCommunication = projectCommunicationMapper.queryProjectCommunicationById(id);
        if(projectCommunication==null){
            return new ResponseMessage(Code.CODE_ERROR,"暂无数据",projectCommunication);
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功!",projectCommunication);
    }

    /**
     * 项目问题沟通---分页并模糊查询问题信息
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage queryProjectCommunicationInfo(String requestBody) {
        com.alibaba.fastjson.JSONObject jsonObject=com.alibaba.fastjson.JSONObject.parseObject(requestBody);
        String projectId = jsonObject.getString("projectId");
        String classification = jsonObject.getString("classification");//问题分类
        String priority = jsonObject.getString("priority");//优先级
        String sponsor = jsonObject.getString("sponsor");//发起人
        String phase = jsonObject.getString("phase");//项目所处阶段
        int pageNo = jsonObject.getInteger("pageNo");
        int pageSize = jsonObject.getInteger("pageSize");



        Page<ProjectCommunication> page = new Page<>();
        int totalCount = projectCommunicationMapper.projectCommunicationCounts(projectId,classification,priority,sponsor,phase);
        page.init(totalCount,pageNo,pageSize);
        List<ProjectCommunication> list = projectCommunicationMapper.queryProjectCommunicationInfo(projectId,classification,priority,sponsor,phase,page.getRowNum(), page.getPageCount());
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
    public ResponseMessage updateDeleteTime(List<String> ids) {
        ProjectCommunication projectCommunication = null;
        /*Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time = null;
        try {
            time = sdf.parse(nowTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        for (int j = 0 ;j < ids.size() ; j++) {
            String id = ids.get(j);
            projectCommunication = projectCommunicationMapper.selectByPrimaryKey(id);
//            System.out.println(projectCommunication.getDeleteTime().toString()+"----------------------------------------------------------");
            if(projectCommunication.getDeleteTime()!=null){
                return new ResponseMessage(Code.CODE_ERROR,"删除失败","失败的项目问题id："+projectCommunication.getId()+" ： "+projectCommunication.getDeleteTime());
            }
        }
        int i = projectCommunicationMapper.updateDeleteTime(ids);

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

    /**
     * 项目问题沟通查询条件
     * @return
     */
    @Override
    public ResponseMessage queryProjectCommunicationSearch() {

        ProjectSearchDO projectSearchDO = new ProjectSearchDO();

        List<FlashProject> flashProjects = projectMapper.selectProjectAll();


        projectSearchDO.setProjectList(flashProjects);
        // projectSearchDO.setBusinessConfigurationList(businessConfigurations);
        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",projectSearchDO);


        return responseMessage;
    }


}