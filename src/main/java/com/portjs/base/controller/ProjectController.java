package com.portjs.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.dao.ApprovalMapper;
import com.portjs.base.entity.Approval;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.entity.Life;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.InternalProjectService;
import com.portjs.base.service.LifeService;
import com.portjs.base.service.ProjectService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author gumingyang
 * 项目动态跟踪
 **/
@CrossOrigin
@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController {
    static final  String TAG = "ProjectController================>";
    @Resource
    private LifeService lifeService;
    @Resource
    private InternalProjectService internalProjectService;
    @Resource
    private ApprovalMapper approvalService;
    @Autowired
    private ProjectService projectService;
    @LogInfo(methodName = "动态跟踪",modelName = "首页动态跟踪")
    @RequestMapping("/query-project")
    @ResponseBody
    public ResponseMessage insertDesigns(){
        UnifiedExceptionHandler.method= TAG + "query-project";
        //在建的项目总个数
        int sumLine = lifeService.sumLine();
        //在建项目总金额
        BigDecimal bigDecimal = lifeService.sumMoney();

        //异常项目查询
        List<InternalProject> list = lifeService.abnormalProjects();

        //获取当前年份
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Date date = null;
        try {
          date = new SimpleDateFormat("yyyy").parse(year+"");
        }catch (Exception e){
            e.printStackTrace();
        }

        InternalProject internal =new InternalProject();
        internal.setCreateTime(date);
        //今年新增项目列表
        List<Map<String,Object>> thisYearList = internalProjectService.selectListByBackup1(internal);
        //今年新增项目总金额
        BigDecimal bigDecimalThisYear = new BigDecimal(0);
        Approval approval = new Approval();
        for (int i=0;i<thisYearList.size();i++){
            Map<String,Object> map =thisYearList.get(i);
            if(map.get("project")!=null){
                InternalProject internalProject =(InternalProject)map.get("project");
                String projectId = internalProject.getId();
                approval.setProjectId(projectId);
                List<Approval> dataList = approvalService.selectByPrimaryKey(approval);
                if(!CollectionUtils.isEmpty(dataList)&&dataList.get(0).getAmount()!=null){
                    bigDecimalThisYear = bigDecimalThisYear.add(dataList.get(0).getAmount());
                }
            }
        }
        //在建项目列表
        List<Map<String,Object>> onlineList = lifeService.onlineList();

        Map<String,Object> datamap = new HashMap<String,Object>();
        datamap.put("sumProject",sumLine);//在建的项目总个数
        datamap.put("sumMoney",bigDecimal);//在建项目总金额
        datamap.put("abnormalList",list);//异常项目查询
        if(!CollectionUtils.isEmpty(list)){
            datamap.put("totalAbnormal",list.size());//异常项目个数
        }else{
            datamap.put("totalAbnormal",0);//异常项目个数
        }
        if(!CollectionUtils.isEmpty(thisYearList)){
            datamap.put("thisYearTotal",thisYearList.size());//今年的新增项目个数
        }else{
            datamap.put("thisYearTotal",0);//今年的新增项目个数
        }
        datamap.put("onlineList",onlineList);//在建项目列表
        datamap.put("thisYearList",thisYearList);//今年新增项目列表
        datamap.put("bigDecimalThisYear",bigDecimalThisYear);//今年新增项目总额
        return new ResponseMessage(Code.CODE_OK,"查询成功",datamap);
    }
    @LogInfo(methodName = "批量添加更新项目生命周期",modelName = "项目生命周期管理")
    @RequestMapping("/insert-life")
    @ResponseBody
    public ResponseMessage insertDesigns(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= TAG + "insert-life";
        JSONArray requestJson = JSON.parseArray(responseBody);
        List<Life> records =JSONObject.parseArray(requestJson.toJSONString(), Life.class);
        return lifeService.insertSelective(records);
    }
    @LogInfo(methodName = "项目生命周期管理",modelName = "项目生命周期管理")
    @RequestMapping("/query-life")
    @ResponseBody
    public ResponseMessage queryLife(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "query-life==============================" + responseBody;
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        Life record = JSONObject.toJavaObject(jsonObject,Life.class);
        return lifeService.selectByPrimaryKey(record);
    }
    @LogInfo(methodName = "项目概览增加",modelName = "项目概览")
    @RequestMapping("/updates-project")
    @ResponseBody
    public ResponseMessage addProject(@RequestBody String responseBody){
        logger.debug(TAG + responseBody);
        UnifiedExceptionHandler.method= responseBody + "updates-project==============================" + responseBody;
        return internalProjectService.updatesProject(responseBody);
    }
    @LogInfo(methodName = "登录人的项目查询",modelName = "项目概览")
    @RequestMapping("/query-projects-by-loginer")
    @ResponseBody
    public ResponseMessage queryProjectsByLoginer(@RequestBody String responseBody){
        UnifiedExceptionHandler.method= responseBody + "queryProjectsByLoginer==============================" + responseBody;
        logger.debug(TAG + responseBody);
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        InternalProject internalProject = JSONObject.toJavaObject(jsonObject,InternalProject.class);
        return internalProjectService.queryProjectsByLoginer(internalProject);
    }

    @LogInfo(methodName = "查询不同年份的在建项目总数",modelName = "项目概览")
    @RequestMapping("select-abuilding-project")
    @ResponseBody
    public ResponseMessage selectAbuildingProject() {
        return internalProjectService.selectAbuildingProject();
    }

    @LogInfo(methodName = "查询不同年份的在建项目总金额",modelName = "项目概览")
    @RequestMapping("select-abuilding-project-money")
    @ResponseBody
    public ResponseMessage selectAbuildingProjectMoney() {
        return internalProjectService.selectAbuildingProjectMoney();
    }

   //**** --------------------------------------项目概览接口rsh-------------------------------------------------
   @LogInfo(methodName = "查询所有项目信息",modelName = "项目管理")
   @RequestMapping("queryProjectAllInfo")
   @ResponseBody
   public ResponseMessage queryProjectAllInfo(@RequestBody String requestBody) {
       JSONObject requestJson=JSONObject.parseObject(requestBody);
       return projectService.queryProjectAllInfo(requestJson);
   }








}
