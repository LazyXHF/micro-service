package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Project;
import com.portjs.base.entity.ProjectWeekly;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.TUserService;
import com.portjs.base.service.WeeklyAndMonthlyReportManagementService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.poi.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dengshuangzhen on 2019\4\23 0023
 * 周报月报管理
 */
@RestController
@RequestMapping("WeeklyAndMonthlyReportManagement")
@CrossOrigin
public class WeeklyAndMonthlyReportManagementController extends BaseController  {
    static  final String tag = "UserController======>";
    private ResponseMessage responseMessage;
    @Autowired
    private WeeklyAndMonthlyReportManagementService weeklyAndMonthlyReportManagementService;




    @LogInfo(methodName = "周报详情查询",modelName = "周报月报管理模块")
    @RequestMapping("select-weekly-details")
    @ResponseBody
    public ResponseMessage selectWeeklyDetails(@RequestBody String requestBody){
        logger.debug(tag+requestBody);
        UnifiedExceptionHandler.method= tag+"select-weekly-details=============================="+requestBody;

        try {
            responseMessage = weeklyAndMonthlyReportManagementService.selectWeeklyDetails(requestBody);
        } catch (Exception e) {
            return new ResponseMessage(Code.CODE_ERROR,e.getMessage());
        }
        return responseMessage;
    }

    @LogInfo(methodName = "提交保存周报详情",modelName = "周报月报管理模块")
    @RequestMapping("submission-weekly-details")
    @ResponseBody
    public ResponseMessage submissionWeeklyDetails(@RequestBody String requestBody){
        logger.debug(tag+requestBody);
        UnifiedExceptionHandler.method= tag+"submission-weekly-details=============================="+requestBody;
        try {
            responseMessage = weeklyAndMonthlyReportManagementService.submissionWeeklyDetails(requestBody);
        } catch (Exception e) {
            return new ResponseMessage(Code.CODE_ERROR,e.getMessage());
        }
        return responseMessage;
    }
    @LogInfo(methodName = "周报查询",modelName = "周报月报管理模块")
    @RequestMapping("select-weekly")
    @ResponseBody
    public ResponseMessage selectWeekly(@RequestBody String requestBody){
        logger.debug(tag+requestBody);
        UnifiedExceptionHandler.method= tag+"select-weekly=============================="+requestBody;
        try {
            responseMessage = weeklyAndMonthlyReportManagementService.selectWeekly(requestBody);
        } catch (Exception e) {
            return new ResponseMessage(Code.CODE_ERROR,e.getMessage());
        }
        return responseMessage;
    }

    @LogInfo(methodName = "周报查询",modelName = "周报月报管理模块")
    @RequestMapping("export")
    @ResponseBody
    public void export(@RequestBody String requestBody, HttpServletRequest request, HttpServletResponse response){
        logger.debug(tag+requestBody);
        UnifiedExceptionHandler.method= tag+"select-weekly=============================="+requestBody;
        //获取数据

        try {
            responseMessage = weeklyAndMonthlyReportManagementService.selectWeeklyDetails(requestBody);
            Object data = responseMessage.getData();
            List list = (List)data;
            //excel标题
            String[] title = {"项目分类","项目编号","项目名称","项目状态","项目经理","联系电话","本周完成情况","下周任务计划","需协调事项"};
            //excel文件名
            String fileName = "项目周报"+System.currentTimeMillis()+".xls";
            //sheet名
            String sheetName = "项目周报表";

            String[][] content = new String[title.length][];
            for (int i = 0; i < list.size(); i++) {
                content[i] = new String[title.length];
                Map map = (Map)list.get(i);
                Project project = (Project)map.get("project");
                ProjectWeekly weekly = (ProjectWeekly) map.get("weekly");

                content[i][0] = project.getProjectType();
                content[i][1] = project.getProjectCode();
                content[i][2] = project.getProjectName();
                if(project.getStatus().equals(0)){
                    content[i][3] ="未完成";
                }else if(project.getStatus().equals(1)){
                    content[i][3] ="已完成";
                }else if(project.getStatus().equals(2)){
                    content[i][3] ="进行中";
                }else if(project.getStatus().equals(3)){
                    content[i][3] ="延期";
                }

                content[i][4] = project.getProjectManager();
                content[i][5] = project.getManagerPhone();
                if(weekly!=null){
                    content[i][6] = weekly.getPerformance();
                    content[i][7] = weekly.getSchedule();
                    content[i][8] = weekly.getCoordination();
                }else {
                    content[i][6] = "";
                    content[i][7] = "";
                    content[i][8] = "";
                }
            }
            //创建HSSFWorkbook
            String basePath = request.getSession().getServletContext().getRealPath("/");
            String excel = basePath + "/excel/项目周报表.xls";
            File fi = new File(excel);
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
            // 读取excel模板
            HSSFWorkbook wb = null;

            wb = new HSSFWorkbook(fs);

            HSSFWorkbook workbook = ExcelUtil.getHSSFWorkbook(sheetName, title, content, wb);
            //响应到客户端
            try {
                this.setResponseHeader(response, fileName);
                OutputStream os = response.getOutputStream();
                workbook.write(os);
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
