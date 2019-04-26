package com.portjs.base.controller;

import com.portjs.base.entity.ProjectMonthly;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.ProjectMonthlyService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.poi.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * @author: daiyueyuan
 * @date: 2019/4/24 10:18
 * @description:
 */


@CrossOrigin
@RestController
@RequestMapping("/projectMonthly")
public class ProjectMonthlyController extends BaseController {
    static final String tag = "ProjectProceduresService===>";
    @Autowired
    private ProjectMonthlyService projectMonthlyService;

    //项目月报新增
    @RequestMapping("/insert_projectMonthly")
    public ResponseMessage insertProjectMonthly(@RequestBody List<ProjectMonthly> projectMonthlyList) {
        logger.debug("insertProjectMonthly()begin......" + projectMonthlyList);
//        try {
        return projectMonthlyService.insertProjectMonthly(projectMonthlyList);
//        } catch (Exception e) {
//            logger.error("select_BusinessConfiguration_ById()error....", e);
//            throw new RuntimeException();
//        }
    }

    //根据项目id查询里程碑
    @RequestMapping("/select_businessConfiguration")
    public ResponseMessage selectBusinessConfiguration(@RequestBody String requestBody) {
        logger.debug("selectBusinessConfiguration()begin......" + requestBody);
//        try {
        return projectMonthlyService.selectBusinessConfiguration(requestBody);
//        } catch (Exception e) {
//            logger.error("select_BusinessConfiguration_ById()error....", e);
//            throw new RuntimeException();
//        }
    }

    //月报查询
    @RequestMapping("/select_projectMonthly")
    public ResponseMessage selectProjectMonthly(@RequestBody String requestBody) {
        logger.debug("selectProjectMonthly()begin......" + requestBody);
        try {
            return projectMonthlyService.selectProjectMonthly(requestBody);
        } catch (Exception e) {
            logger.error("selectProjectMonthly()error....", e);
            throw new RuntimeException();
        }
    }


    //月报导出（poi）
    @RequestMapping("export-monthly")
    public void exportMonthly(@RequestBody String requestBody, HttpServletResponse response) {
        logger.debug(tag + requestBody);
        UnifiedExceptionHandler.method = tag + "export-monthly==============================" + requestBody;
        try {
            ResponseMessage responseMessage = projectMonthlyService.selectProjectMonthly(requestBody);
            //excel标题
            String[] title = {"项目名称", "项目阶段", "工作内容", "计划开始时间", "计划完成时间", "当前进度", "截至本月工作", "下月计划", "备注"};
            //excel文件名
            String fileName = "项目月报表" + System.currentTimeMillis() + ".xls";
            //sheet名
            String sheetName = "项目月报表";

            if (responseMessage.getData() != null) {
                Object data = responseMessage.getData();
                Map<String, List> map = (Map) data;
                String[][] content = new String[title.length][];
                for (Map.Entry<String, List> entry : map.entrySet()) {
                    /*content[0][0] = entry.getKey();*/
                    if (!CollectionUtils.isEmpty(entry.getValue())) {
                        for (int i = 0; i < entry.getValue().size(); i++) {
                            content[i] = new String[title.length];
                            ProjectMonthly monthly = (ProjectMonthly) entry.getValue().get(i);
                            if (monthly.getProjectSchedule().equals("A")) {
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println(content[i]);
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                                content[i][1] = "项目立项";
                            } else if (monthly.getProjectSchedule().equals("B")) {
                                content[i][1] = "合同签订";
                            } else if (monthly.getProjectSchedule().equals("C")) {
                                content[i][1] = "项目启动";
                            } else if (monthly.getProjectSchedule().equals("项目建设")) {
                                content[i][1] = "项目建设";
                            } else if (monthly.getProjectSchedule().equals("G")) {
                                content[i][1] = "上线试运行";
                            } else if (monthly.getProjectSchedule().equals("H")) {
                                content[i][1] = "项目验收";
                            }
                            if (!StringUtils.isEmpty(monthly.getPredictStarttime())) {
                                content[i][2] = monthly.getPredictStarttime().toString();
                            }
                            if (!StringUtils.isEmpty(monthly.getPridectEndtime())) {
                                content[i][3] = monthly.getPridectEndtime().toString();
                            }
                            content[i][4] = monthly.getContent();
                            content[i][5] = monthly.getCurrentProgress();
                            content[i][6] = monthly.getPerformance();
                            content[i][7] = monthly.getSchedule();
                            content[i][8] = monthly.getRemark();
                        }
                    }
                }
                //创建HSSFWorkbook
                Resource resource = new ClassPathResource("/excel/项目月报表.xls");
                File file = resource.getFile();
                String excel = file.getAbsolutePath();

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

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
