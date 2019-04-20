package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.entity.InternalTodo;
import com.portjs.base.service.ProjectCommunicationService;
import com.portjs.base.service.ProjectProceduresService;
import com.portjs.base.util.*;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

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


    @Service
    @Transactional(rollbackFor = Exception.class)
    public static class ProjectProceduresServiceImpl implements ProjectProceduresService {
        @Autowired
        private InternalTodoMapper internalToDoMapper;
        @Autowired
        private InternalWorkflowstepMapper internalWorkflowstepMapper;
        @Autowired
        private InternalProjectMapper internalProjectMapper;
        @Autowired
        private InternalPersionResourceMapper internalPersionResourceMapper;
        //创建项目流程
        @Override
        public ResponseMessage createProjectProcedures(@RequestBody Map<String, Object> requestBody) {
            try {
                com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSONArray.parseArray(JsonXMLUtils.obj2json(requestBody.get("InternalPersionResource")));
                com.alibaba.fastjson.JSONArray nextReviewerIdArray= com.alibaba.fastjson.JSONArray.parseArray(JsonXMLUtils.obj2json(requestBody.get("NextReviewerId")));
                //项目添加
                InternalProject internalProject=JsonXMLUtils.map2obj((Map<String, Object>)requestBody.get("InternalProject"), InternalProject.class);
                //暂存还是提交
                String type =requestBody.get("Type").toString();
                //type 1:暂存 2.提交
                if(type.equals("1")){
                    internalProject.setStatus("草稿");
                    nextReviewerIdArray.clear();
                }
                internalProject.setId(String.valueOf(UUID.randomUUID()));
                internalProject.setCreater(UserUtils.getCurrentUser().getId());
                int c=internalProjectMapper.insert(internalProject);
                if(c<=0) {
                    return new ResponseMessage(Code.CODE_ERROR, "创建失败");
                }
                //人员添加
                for (int i = 0; i < array.size(); i++) {
                     com.alibaba.fastjson.JSONObject requestMsg = com.alibaba.fastjson.JSONObject.parseObject(array.getString(i));
                    InternalPersionResource internalPersionResource=new InternalPersionResource();
                    internalPersionResource.setId(String.valueOf(UUID.randomUUID()));
                    internalPersionResource.setProjectId(internalProject.getId());
                    internalPersionResource.setPersionName(requestMsg.getString("persionName"));
                    internalPersionResource.setUnnit(requestMsg.getString("unnit"));
                    internalPersionResource.setType(requestMsg.getString("type"));
                    internalPersionResource.setSort(requestMsg.getString("sort"));
                    int k=internalPersionResourceMapper.insertPersionInfo(internalPersionResource);
                    if(k<=0) {
                        return new ResponseMessage(Code.CODE_ERROR, "创建失败");
                    }
                }

                for(int n=0;n<nextReviewerIdArray.size();n++) {
                    //放入待办事项
                    com.portjs.base.entity.InternalTodo BackLoginternalToDo=new com.portjs.base.entity.InternalTodo();
                    BackLoginternalToDo.setId(String.valueOf(UUID.randomUUID()));
                    BackLoginternalToDo.setCurrentstepId(BackLoginternalToDo.getId());
                    BackLoginternalToDo.setStepDesc("项目负责人提交");
                    BackLoginternalToDo.setRelateddomain("项目立项");
                    BackLoginternalToDo.setRelateddomainId(internalProject.getId());
                    BackLoginternalToDo.setSenderId(internalProject.getCreater());
                    BackLoginternalToDo.setReceiverId(nextReviewerIdArray.getString(n));
                    BackLoginternalToDo.setTodoType("项目立项");
                    BackLoginternalToDo.setStatus("0");
                    int b=internalToDoMapper.insert(BackLoginternalToDo);
                    if(b<=0) {
                        return new ResponseMessage(Code.CODE_ERROR, "创建失败");
                    }

                    //工作流
                    InternalWorkflowstep workflowstep=new InternalWorkflowstep();
                    workflowstep.setId(String.valueOf(UUID.randomUUID()));
                    workflowstep.setRelateddomain("项目立项");
                    workflowstep.setRelateddomainId(internalProject.getId());
                    workflowstep.setPrestepId("0");
                    workflowstep.setStepDesc("项目负责人提交");
                    workflowstep.setActionuserId(UserUtils.getCurrentUser().getId());
                    workflowstep.setStatus("1");
                    workflowstep.setBackup3("1");
                    int m=internalWorkflowstepMapper.insert(workflowstep);
                    if(m<=0) {
                        return new ResponseMessage(Code.CODE_ERROR, "创建失败");
                    }
                    InternalWorkflowstep workflowstep2=new InternalWorkflowstep();
                    workflowstep2.setId(String.valueOf(UUID.randomUUID()));
                    workflowstep2.setRelateddomain("项目立项");
                    workflowstep2.setRelateddomainId(internalProject.getId());
                    workflowstep2.setPrestepId(workflowstep.getId());
                    workflowstep2.setStepDesc("部门负责人审核");
                    workflowstep2.setActionuserId(nextReviewerIdArray.getString(n));
                    workflowstep2.setStatus("0");
                    workflowstep2.setBackup3("2");
                    int s=internalWorkflowstepMapper.insert(workflowstep2);
                    if(s<=0) {
                        return new ResponseMessage(Code.CODE_ERROR, "创建失败");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ResponseMessage(Code.CODE_OK, "创建成功");
        }

        //项目立项阶段的信息查询
        @Override
        public ResponseMessage selectProjectProcedures(String requestBody) {
            com.alibaba.fastjson.JSONObject jsonObj= com.alibaba.fastjson.JSONObject.parseObject(requestBody);
            String id=jsonObj.getString("projectId");
            String person_id=jsonObj.getString("personId");
            String pageNo=jsonObj.getString("pageNo");
            String pageSize=jsonObj.getString("pageSize");
            InternalProject internalProject=new InternalProject();
            internalProject.setId(id);
            internalProject=internalProjectMapper.selectByPrimaryKey(internalProject);
            /*
             * 分页查询项目人员信息
             */
            Page<InternalPersionResource>page=new Page<InternalPersionResource>();
            int totleCount=internalPersionResourceMapper.persionCounts(id);
            page.init(totleCount, Integer.valueOf(pageNo), Integer.valueOf(pageSize));
            List<InternalPersionResource> list = internalPersionResourceMapper.queryAllPersionInfo(id, page.getRowNum(), page.getPageCount());
            page.setList(list);
            internalProject.setPage(page);
            /*
             * 查询对应todo表中该登陆人待审核信息
             */
            InternalTodoExample example=new InternalTodoExample();
            InternalTodoExample.Criteria criteria = example.createCriteria();
            criteria.andRelateddomainIdEqualTo(id);
            criteria.andReceiverIdEqualTo(person_id);
            criteria.andStatusEqualTo("0");
            List<com.portjs.base.entity.InternalTodo> internalTodo = internalToDoMapper.selectByExample(example);
            internalProject.setInternalToDo(internalTodo);
            /*
             * 查询workflowstep表中所有该业务id对应的信息
             */
            InternalWorkflowstepExample example1=new InternalWorkflowstepExample();
            InternalWorkflowstepExample.Criteria criteria2 = example1.createCriteria();
            criteria2.andRelateddomainIdEqualTo(id);
            //criteria2.andActionuserIdEqualTo(person_id);
            List<InternalWorkflowstep> internalWorkflowstep = internalWorkflowstepMapper.selectByExample(example1);
            internalProject.setInternalWorkflowstep(internalWorkflowstep);
            return new ResponseMessage(Code.CODE_OK, "查询成功",internalProject);
        }


        //项目立项阶段的审批流程添加
        @Override
        public ResponseMessage insertProjectProcedures(String requestBody) {
            com.alibaba.fastjson.JSONObject jsonObj= com.alibaba.fastjson.JSONObject.parseObject(requestBody);
            String relateddomain="项目立项";//业务模块
            String relateddomain_id=jsonObj.getString("relateddomainId");//业务id
            String sender_id=jsonObj.getString("senderId");//当前人的id
            com.alibaba.fastjson.JSONArray nextReviewerId= JSONArray.parseArray(jsonObj.getString("nextReviewerId"));//下一个审核人的信息
            String currentstep_id=jsonObj.getString("currentstep_id");//当前处理步骤
            String todo_id=jsonObj.getString("todo_id");//当前todo表中id
            String workflowstep_id=jsonObj.getString("workflowstep_id");//当前workflowstep表中的id
            String actionComment=jsonObj.getString("actionComment");//审核意见
            String actionResult=jsonObj.getString("actionResult");//0 同意 1 不同意or退回
            String backup3 = jsonObj.getString("backup3");//第几个步骤
            String stepDesc="";
            if(backup3.equals("2")){
                stepDesc="分管领导审核";
                backup3="3";
            }else if(backup3.equals("3")){
                stepDesc="技术委员会审核";
                backup3="4";
            }else if(backup3.equals("4")){
                stepDesc="总经办审核";
                backup3="5";
            }else if(backup3.equals("5")){
                stepDesc="规划部归档";
                backup3="6";
            }
            /*
             * 修改掉当前todo表对应的id的信息
             */
            com.portjs.base.entity.InternalTodo BackLoginternalToDo=new com.portjs.base.entity.InternalTodo();
            BackLoginternalToDo.setId(todo_id);
            BackLoginternalToDo.setActiontime(new Date());
            BackLoginternalToDo.setStatus("1");
            int k=internalToDoMapper.updateByPrimaryKeySelective(BackLoginternalToDo);
            if(k<=0) {
                return new ResponseMessage(Code.CODE_ERROR, "审核失败");
            }
            /*
             * 修改当前workflowstep表中对应id的信息
             */
            InternalWorkflowstep BackLoginternalWorkflowstep=new InternalWorkflowstep();
            BackLoginternalWorkflowstep.setId(workflowstep_id);
            BackLoginternalWorkflowstep.setActionTime(new Date());
            BackLoginternalWorkflowstep.setActionComment(actionComment);
            BackLoginternalWorkflowstep.setStatus("1");
            if(actionResult.equals("0")) {
                BackLoginternalWorkflowstep.setActionResult(0);
            }else if(actionResult.equals("1")) {
                BackLoginternalWorkflowstep.setActionResult(1);
            }
            int j=internalWorkflowstepMapper.updateByPrimaryKeySelective(BackLoginternalWorkflowstep);
            if(j<=0) {
                return new ResponseMessage(Code.CODE_ERROR, "审核失败");
            }
            /*
             * 选择下一个审核人进行的操作
             * 对todo表中进行添加操作
             * 对Workflowstep表中进行添加操作
             */
            for(int c=0;c<nextReviewerId.size();c++) {
                //进入到多个人审核阶段
                if(backup3.equals("5")){
                    InternalWorkflowstepExample example1=new InternalWorkflowstepExample();
                    InternalWorkflowstepExample.Criteria criteria2 = example1.createCriteria();
                    criteria2.andStatusEqualTo("0");
                    criteria2.andRelateddomainIdEqualTo(relateddomain_id);
                    criteria2.andBackup3EqualTo("4");
                    List<InternalWorkflowstep> list = internalWorkflowstepMapper.selectByExample(example1);
                    if(CollectionUtils.isEmpty(list)){
                        com.portjs.base.entity.InternalTodo internalToDo=new com.portjs.base.entity.InternalTodo();
                        internalToDo.setId(String.valueOf(UUID.randomUUID()));
                        internalToDo.setCurrentstepId(currentstep_id);
                        internalToDo.setRelateddomain(relateddomain);
                        internalToDo.setRelateddomainId(relateddomain_id);
                        internalToDo.setSenderId(sender_id);
                        internalToDo.setReceiverId(nextReviewerId.getString(c));
                        internalToDo.setSenderTime(new Date());
                        internalToDo.setTodoType("项目立项审核流程");
                        internalToDo.setStatus("0");
                        int n=internalToDoMapper.insert(internalToDo);
                        if(n<=0) {
                            return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
                        }
                        InternalWorkflowstep workflowstep=new InternalWorkflowstep();
                        workflowstep.setId(String.valueOf(UUID.randomUUID()));
                        workflowstep.setRelateddomain(relateddomain);
                        workflowstep.setRelateddomainId(relateddomain_id);
                        workflowstep.setPrestepId(workflowstep_id);
                        workflowstep.setActionuserId(nextReviewerId.getString(c));
                        workflowstep.setStatus("0");
                        workflowstep.setBackup3(backup3);
                        workflowstep.setStepDesc(stepDesc);
                        int m=internalWorkflowstepMapper.insert(workflowstep);
                        if(m<=0) {
                            return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
                        }
                    }
                }else{
                    com.portjs.base.entity.InternalTodo internalToDo=new com.portjs.base.entity.InternalTodo();
                    internalToDo.setId(String.valueOf(UUID.randomUUID()));
                    internalToDo.setCurrentstepId(currentstep_id);
                    internalToDo.setRelateddomain(relateddomain);
                    internalToDo.setRelateddomainId(relateddomain_id);
                    internalToDo.setSenderId(sender_id);
                    internalToDo.setReceiverId(nextReviewerId.getString(c));
                    internalToDo.setSenderTime(new Date());
                    internalToDo.setTodoType("项目立项审核流程");
                    internalToDo.setStatus("0");
                    int n=internalToDoMapper.insert(internalToDo);
                    if(n<=0) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
                    }
                    InternalWorkflowstep workflowstep=new InternalWorkflowstep();
                    workflowstep.setId(String.valueOf(UUID.randomUUID()));
                    workflowstep.setRelateddomain(relateddomain);
                    workflowstep.setRelateddomainId(relateddomain_id);
                    workflowstep.setPrestepId(workflowstep_id);
                    workflowstep.setActionuserId(nextReviewerId.getString(c));
                    workflowstep.setStatus("0");
                    workflowstep.setBackup3(backup3);
                    workflowstep.setStepDesc(stepDesc);
                    int m=internalWorkflowstepMapper.insert(workflowstep);
                    if(m<=0) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加下一个审核人信息失败");
                    }
                }
        }
       return new ResponseMessage(Code.CODE_OK, "审核完成");
    }

        //立项阶段的归档操作
        @Override
        public ResponseMessage projectProceduresArchive(String requestBody) {
            com.alibaba.fastjson.JSONObject jsonObj= JSONObject.parseObject(requestBody);
            String todo_id=jsonObj.getString("todo_id");
            String workflowstep_id=jsonObj.getString("workflowstep_id");
            String projectCoding=jsonObj.getString("projectCoding");
            /*
             * 修改掉当前todo表对应的id的信息
             */
            com.portjs.base.entity.InternalTodo BackLoginternalToDo=new InternalTodo();
            BackLoginternalToDo.setId(todo_id);
            BackLoginternalToDo.setActiontime(new Date());
            BackLoginternalToDo.setStatus("1");
            int k=internalToDoMapper.updateByPrimaryKeySelective(BackLoginternalToDo);
            if(k<=0) {
                return new ResponseMessage(Code.CODE_ERROR, "归档失败");
            }
            /*
             * 修改当前workflowstep表中对应id的信息
             */
            InternalWorkflowstep BackLoginternalWorkflowstep=new InternalWorkflowstep();
            BackLoginternalWorkflowstep.setId(workflowstep_id);
            BackLoginternalWorkflowstep.setActionTime(new Date());
            BackLoginternalWorkflowstep.setStatus("1");
            BackLoginternalWorkflowstep.setProjectCoding(projectCoding);
            int j=internalWorkflowstepMapper.updateByPrimaryKeySelective(BackLoginternalWorkflowstep);
            if(j<=0) {
                return new ResponseMessage(Code.CODE_ERROR, "归档失败");
            }
             return new ResponseMessage(Code.CODE_OK, "归档完成");
        }
    }
}