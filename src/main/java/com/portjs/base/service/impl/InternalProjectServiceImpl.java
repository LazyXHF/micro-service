package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.entity.InternalTodo;
import com.portjs.base.service.InternalProjectService;
import com.portjs.base.service.LifeService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class InternalProjectServiceImpl implements InternalProjectService {
    private Integer code;
    private String message = "";
    ResponseMessage responseMessage = null;

    @Autowired
    InternalProjectMapper internalProjectMapper;
    @Autowired
    private LifeMapper lifeMapper;
    @Autowired
    private InternalPersionResourceMapper internalPersionResourceMapper;
    @Autowired
    LifeService lifeService;
    @Autowired
    private InternalTodoMapper internalTodoMapper;
    @Autowired
    private InternalApprovalMapper approvalMapper;
    @Autowired
    private ProjectApplicationMapper applicationMapper;
    /**
     * 查询所有项目信息和相关人员信息
     * @return
     */
    @Override
    public Page<InternalProject> selectAllProjectInfo(String id, int pageNo, int pageSize) {
        Page<InternalProject> page = new Page<>();
        /*InternalProject internalProject = new InternalProject();
        internalProject.getId();*/
        int totalCount = internalProjectMapper.projectCount(id);
        page.init(totalCount,pageNo,pageSize);
        List<InternalProject>  list= internalProjectMapper.selectAllProjectInfo(id,page.getRowNum(),page.getPageCount());
        page.setList(list);
        return page;
    }

    /**
     * 查询所有项目信息
     * @return
     */
    @Override
    public Page<InternalProject> queryAllProjectInfo(int pageNo, int pageSize) {
        Page<InternalProject> page = new Page<>();
        int totalCount = internalProjectMapper.projectCounts();
        page.init(totalCount,pageNo,pageSize);
        List<InternalProject> list = internalProjectMapper.queryAllProjectInfo(page.getRowNum(),page.getPageCount());
        page.setList(list);
        return page;

    }
    /**
     * 查询所有项目信息包含生命周期和项目状态
     * @return
     */
    @Override
    public Page<Map<String,Object>> queryAllProjectInfos(int pageNo, int pageSize) {
        Page<Map<String,Object>> page = new Page<>();
        int totalCount = internalProjectMapper.projectCounts();
        page.init(totalCount,pageNo,pageSize);
        List<InternalProject> list = internalProjectMapper.queryAllProjectInfo(page.getRowNum(),page.getPageCount());
        List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
        Life record = new Life();
        for(int i =0;i<list.size();i++){
            Map<String,Object> map = new HashMap<String,Object>();
            String projectId = list.get(i).getId();
            record.setProjectId(projectId);
            List<Life> lifes = lifeMapper.selectByPrimaryKey(record);
            if(CollectionUtils.isEmpty(lifes)){
                map.put("status","未开发");
            }else if(lifes.size()<6){
                map.put("status","已开发");
            }else if(lifes.size()==6){
                map.put("status","已开发");
                for (int k=0;k<lifes.size();k++){
                    if("6".equals(lifes.get(k).getNode())&& "3".equals(lifes.get(k).getStatus())){
                        map.put("status","已完成");
                        break;
                    }
                }
            }
            map.put("proiect",list.get(i));
            map.put("lifes",lifes);
            dataList.add(map);
        }
        page.setList(dataList);
        return page;

    }
    /**
     * 报表页面
     * 添加项目信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertProjectInfo(InternalProject record) {
        record.setId(UUID.randomUUID().toString());
        Date date=new java.util.Date();
        java.sql.Date  data1=new java.sql.Date(date.getTime());
        record.setCreateTime(data1);
        record.setCreater(UserUtils.getCurrentUser().getUsername());
       /* List<InternalProject> list = internalProjectMapper.queryProjectNums();
        //项目编号不需要了
        for (InternalProject lists:list) {
            if(record.getBackUp2().equals(lists)){
                return new ResponseMessage(Code.CODE_ERROR,"项目编号已存在");
            }
        }*/
        int i  = internalProjectMapper.insertSelective(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"添加成功！",i);
    }
    /**
     * 添加项目概览信息
     * @param
     * @return
     */
    @Override
    public ResponseMessage insertProjectInfoOverview(InternalProject internalProject) {
        internalProject.setId(UUID.randomUUID().toString());
        Date date=new java.util.Date();
        java.sql.Date  data1=new java.sql.Date(date.getTime());
        internalProject.setModifyTime(data1);
        internalProject.setModifer(UserUtils.getCurrentUser().getUsername());

        int i  = internalProjectMapper.insertSelective(internalProject);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"添加成功！",i);
    }

    /**
     * 更新项目信息（报表页面）
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKeySelective(InternalProject record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新项目模块,id未传");
            }
            //如果创建时间已经存在，之后每次修改都是修改时间
            Date date=new java.util.Date();
            java.sql.Date  data1=new java.sql.Date(date.getTime());
            record.setModifyTime(data1);

            record.setModifer(UserUtils.getCurrentUser().getId());
            count =  internalProjectMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);

    }

    /**
     * 更新项目信息（项目概览）
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateSelective(InternalProject record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新项目概览模块,id未传");
            }
            //如果创建时间已经存在，之后每次修改都是修改时间
            Date date=new java.util.Date();
            java.sql.Date  data1=new java.sql.Date(date.getTime());
            record.setModifyTime(data1);
            record.setModifer(UserUtils.getCurrentUser().getId());
            count =  internalProjectMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);

    }

    /**
     * 根据id查询项目信息
     * @param internalProject
     * @return
     */
    @Override
    public ResponseMessage selectByPrimaryKey(InternalProject internalProject) {
        InternalProject internalProjects = internalProjectMapper.selectByPrimaryKey(internalProject);
        if(internalProjects==null){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",internalProjects);
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！",internalProjects);
    }

    @Override
    public  List<Map<String,Object>> selectListByBackup1(InternalProject record) {
        List<InternalProject> internalProjects = internalProjectMapper.selectListByBackup1(record);
        List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
        Life records = new Life();
        if(!CollectionUtils.isEmpty(internalProjects)){
            //加入生命周期
            for(int i =0;i<internalProjects.size();i++){
                Map<String,Object> map = new HashMap<String,Object>();
                String projectId = internalProjects.get(i).getId();
                records.setProjectId(projectId);
                List<Life> lifes = lifeMapper.selectByPrimaryKey(records);
                if(CollectionUtils.isEmpty(lifes)){
                    map.put("status","已开发");
                }else if(lifes.size()<6){
                    map.put("status","已开发");
                }else if(lifes.size()==6){
                    map.put("status","已开发");
                    for (int k=0;k<lifes.size();k++){
                        if("6".equals(lifes.get(k).getNode())&& "3".equals(lifes.get(k).getStatus())){
                            map.put("status","已完成");
                            break;
                        }
                    }
                }
                map.put("proiect",internalProjects.get(i));
                map.put("lifes",lifes);
                dataList.add(map);
            }
        }
        return dataList;
    }

    @Override
    public ResponseMessage queryAllProjects() {
        List<InternalProject> design = null;
        try {
            design  =   internalProjectMapper.selectListByBackup1(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message,design);
    }

    @Override
    public ResponseMessage updatesProject(String responseBody) {
        //转化必要的参数
        JSONObject requestJson =JSONObject.parseObject(responseBody);
        //人员
        JSONArray personJSONArray =  requestJson.getJSONArray("Persons");
        JSONObject projectObject =requestJson.getJSONObject("Project");
        InternalProject internalProject = JSONObject.toJavaObject(projectObject, InternalProject.class);
        int count = 0;
        try {
            if(StringUtils.isEmpty(internalProject.getId())){
                return new ResponseMessage(Code.CODE_ERROR , "更新项目模块,id未传");
            }
            //如果创建时间已经存在，之后每次修改都是修改时间
            Date date=new java.util.Date();
            java.sql.Date  data1=new java.sql.Date(date.getTime());
            internalProject.setModifyTime(data1);
            internalProject.setModifer(UserUtils.getCurrentUser().getId());
            count =  internalProjectMapper.updateByPrimaryKeySelective(internalProject);
            if(count <=0){
                return new ResponseMessage(Code.CODE_ERROR , "保存失败");
            }
            //删除person表
                internalPersionResourceMapper.deletePersons(internalProject.getId());
            //保存
            for(int i=0;i<personJSONArray.size();i++){
                JSONObject object = personJSONArray.getJSONObject(i);
                InternalPersionResource annex = JSONObject.toJavaObject(object, InternalPersionResource.class);
                //组建bean
                annex.setId(UUID.randomUUID().toString());
                count = internalPersionResourceMapper.insertPersionInfo(annex);
                if(count==0){
                    return  new ResponseMessage(Code.CODE_ERROR , "保存失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseMessage(Code.CODE_OK , "保存成功");
    }

    @Override
    public ResponseMessage queryProjectsByLoginer(InternalProject internalProject) {
        //分页查询
        Page<Map<String,Object>> page =null;
        if(!StringUtils.isEmpty(internalProject.getParams())){
            page = new Page<Map<String,Object>>();
            int totalCount = internalProjectMapper.queryByPage(internalProject);
            page.init(totalCount,Integer.parseInt(internalProject.getParams().get("pageNo").toString()),Integer.parseInt(internalProject.getParams().get("pageSize").toString()));
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("pageNo",page.getRowNum());
            map.put("pageSize",page.getPageCount());
            internalProject.setParams(map);
        }

        List<InternalProject> list = internalProjectMapper.queryProjectsByLoginer(internalProject);

        //筛选审核的项目
        List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
        InternalTodo todo = new InternalTodo();
        for (int i =0;i<list.size();i++){
            Map<String,Object> map = new HashMap<String, Object>();
            todo.setReceiverId(UserUtils.getCurrentUser().getId());
            todo.setRelateddomainId(list.get(i).getId());
            //未审核的数据
            todo.setStatus("0");
            List<InternalTodo> todos = internalTodoMapper.selectByObject(todo);
            if(CollectionUtils.isEmpty(todos)){
                  map.put("Review","");
             }else{
                map.put("Review","审核");
            }
            map.put("InternalProject",list.get(i));
            dataList.add(map);
        }
        if(page!=null){
            page.setList(dataList);
        }
        return  new ResponseMessage(Code.CODE_OK,"查询成功！",page);
    }

    @Override
    public ResponseMessage selectListsByBackup1(String createTime ,int pageNo, int pageSize) {

        Page<Map<String,Object>> page = new Page<>();
        int totalCount = internalProjectMapper.projectCounts();
        page.init(totalCount,pageNo,pageSize);
        List<InternalProject> internalProjects = internalProjectMapper.selectListsByBackup1(createTime,pageNo,pageSize);
        List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
        Life records = new Life();
        if(!CollectionUtils.isEmpty(internalProjects)){
            //加入生命周期
            for(int i =0;i<internalProjects.size();i++){
                Map<String,Object> map = new HashMap<String,Object>();
                String projectId = internalProjects.get(i).getId();
                records.setProjectId(projectId);
                List<Life> lifes = lifeMapper.selectByPrimaryKey(records);
                if(CollectionUtils.isEmpty(lifes)){
                    map.put("status","已开发");
                }else if(lifes.size()<6){
                    map.put("status","已开发");
                }else if(lifes.size()==6){
                    map.put("status","已开发");
                    for (int k=0;k<lifes.size();k++){
                        if("6".equals(lifes.get(k).getNode())&& "3".equals(lifes.get(k).getStatus())){
                            map.put("status","已完成");
                            break;
                        }
                    }
                }
                map.put("proiect",internalProjects.get(i));
                map.put("lifes",lifes);
                dataList.add(map);
                page.setList(dataList);
                if(page==null){
                    return new ResponseMessage(Code.CODE_ERROR,"查询失败!",page);
                }

            }
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！",page);
    }

    /**
     * 查询所有在建项目并分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public ResponseMessage queryConstructionProjects(List<String> id,int pageNo, int pageSize) {
        Page<InternalProject> page = new Page<>();
        int totalCount = lifeService.sumLine();
        page.init(totalCount,pageNo,pageSize);
        List<InternalProject> list = internalProjectMapper.queryConstructionProjects(id, page.getRowNum(), page.getPageCount());
        page.setList(list);
        return new ResponseMessage(Code.CODE_OK,"查询成功！",page);

    }

    /**
     * 页面在建项目的根据年份查询总数
     */
    @Override
    public ResponseMessage selectAbuildingProject() {
        LinkedHashMap<String,Integer> map=new LinkedHashMap<String,Integer>();
        //查询在建项目的时间点
        ProjectApplicationExample example = new ProjectApplicationExample();
        example.setOrderByClause("create_time");
        List<ProjectApplication> applications = applicationMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(applications)){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String minYear = format.format(applications.get(0).getCreateTime());
        /*String minYear = applicationMapper.selectCreateTime(projectId);*/
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        LinkedList list = new LinkedList();
        int aa = year-Integer.valueOf(minYear.substring(0,4));
        for (int i = 0; i <= aa; i++) {
            list.add(Integer.valueOf(minYear.substring(0,4))+i);
        }

        for(int i=0;i<list.size();i++) {
            if(map.containsKey(list.get(i))) {
                continue;
            }
            List<ProjectApplication> projectApplications = applicationMapper.selectapplicationByYear(list.get(i).toString());
            if (CollectionUtils.isEmpty(projectApplications)){
                return new ResponseMessage(Code.CODE_ERROR,"查询失败！");
            }
            map.put(list.get(i)+"年", projectApplications.size());
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！",map);
    }

    /**
     * 页面在建项目的根据年份查询总金额
     */
    @Override
    public ResponseMessage selectAbuildingProjectMoney() {
        LinkedHashMap map=new LinkedHashMap();
        //查询在建项目的时间点
        ProjectApplicationExample example = new ProjectApplicationExample();
        example.setOrderByClause("create_time");
        List<ProjectApplication> applications = applicationMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(applications)){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String minYear = format.format(applications.get(0).getCreateTime());
        /*String minYear = applicationMapper.selectCreateTime(projectId);*/
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        LinkedList list = new LinkedList();
        int aa = year-Integer.valueOf(minYear.substring(0,4));
        for (int i = 0; i <= aa; i++) {
            list.add(Integer.valueOf(minYear.substring(0,4))+i);
        }

        for(int i=0;i<list.size();i++) {
            if(map.containsKey(list.get(i))) {
                continue;
            }
            List<ProjectApplication> projectApplications = applicationMapper.selectapplicationByYear(list.get(i).toString());
            if (CollectionUtils.isEmpty(projectApplications)){
                return new ResponseMessage(Code.CODE_ERROR,"查询失败！");
            }
            BigDecimal decimal = new BigDecimal(0);
            for (ProjectApplication projectApplication : projectApplications) {
                /*money+=projectApplication.getApplicationAmount();*/
                if(projectApplication.getApplicationAmount()!=null){
                    decimal = decimal.add(projectApplication.getApplicationAmount());
                }
            }

            map.put(list.get(i)+"年", decimal);
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！",map);
    }



}
