package com.portjs.base.controller;

import com.portjs.base.entity.ProjectMonthly;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.ProjectMonthlyService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.poi.ExcelUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
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
import java.util.*;

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
            String[] title = {"项目名称", "项目阶段", "工作内容", "计划开始时间", "计划完成时间", "当前进度", "截至本月工作",
                    "下月计划", "备注"};
            //excel文件名
            String fileName = "项目月报表" + System.currentTimeMillis() + ".xls";
            //sheet名
            String sheetName = "项目月报表";

            //创建HSSFWorkbook
//            Resource resource = new ClassPathResource("/excel/项目月报表.xls");
//            File file = resource.getFile();
//
//            String excel = file.getAbsolutePath();
//
//            File fi = new File(excel);
//            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fi));
            // 读取excel模板
//            HSSFWorkbook wb = null;
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);//水平居中  
            cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中  

            if (responseMessage.getData() != null) {
                Object data = responseMessage.getData();
                Map<String, List> map = (Map) data;

                //wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.createSheet(sheetName);
                HSSFRow sheetRow = sheet.createRow(0);


                for (int i = 0; i < title.length; i++) {
                    HSSFCell cell = sheetRow.createCell(i);
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue(title[i]);
                }
                List<Map<String, List<ProjectMonthly>>> list = new ArrayList<>();
                for (Map.Entry<String, List> listEntry : map.entrySet()) {
                    Map<String, List<ProjectMonthly>> map1 = new HashMap<>();
                    String key = listEntry.getKey();
                    List value = listEntry.getValue();
                    map1.put(key, value);
                    list.add(map1);
                }

                for (int i = 0; i < list.size(); i++) {

                    Set<Map.Entry<String, List<ProjectMonthly>>> entries = list.get(i).entrySet();
                    for (Map.Entry<String, List<ProjectMonthly>> entry : entries) {
                        String key = entry.getKey();
                        List<ProjectMonthly> list1 = entry.getValue();
                        if (i == 0) {
                            HSSFRow row = sheet.createRow(i + 1);
                            HSSFCell cell = row.createCell(0);
                            cell.setCellValue(key);
                            cell.setCellStyle(cellStyle);
                            int z = 0;
                            for (int j=0;j<list1.size();j++){
                                HSSFRow row1 = sheet.createRow(z + 1);
                                    if ("A".equals(list1.get(j).getProjectSchedule())) {
                                        list1.get(j).setProjectSchedule("项目立项");
                                    } else if ("B".equals(list1.get(j).getProjectSchedule())) {
                                        list1.get(j).setProjectSchedule("合同签订");
                                    } else if ("C".equals(list1.get(j).getProjectSchedule())) {
                                        list1.get(j).setProjectSchedule("项目启动");
                                    } else if ("项目建设".equals(list1.get(j).getProjectSchedule())) {
                                        list1.get(j).setProjectSchedule("项目建设");
                                    } else if ("G".equals(list1.get(j).getProjectSchedule())) {
                                        list1.get(j).setProjectSchedule("上线试运行");
                                    } else if ("H".equals(list1.get(j).getProjectSchedule())) {
                                        list1.get(j).setProjectSchedule("项目验收");
                                    }
                                row1.createCell(1).setCellValue(list1.get(j).getProjectSchedule());
                                row1.createCell(2).setCellValue(list1.get(j).getContent());
                                row1.createCell(3).setCellValue(list1.get(j).getPredictStarttime());
                                row1.createCell(4).setCellValue(list1.get(j).getPridectEndtime());
                                row1.createCell(5).setCellValue(list1.get(j).getCurrentProgress());
                                row1.createCell(6).setCellValue(list1.get(j).getPerformance());
                                row1.createCell(7).setCellValue(list1.get(j).getSchedule());
                                row1.createCell(8).setCellValue(list1.get(j).getRemark());
                                    z++;
                                }


                        } else {
                            HSSFRow row = sheet.createRow(i * 6 + 1);
                            HSSFCell cell = row.createCell(0);
                            cell.setCellValue(key);
                            cell.setCellStyle(cellStyle);
                            int z = i * 6 + 1;
                            for (int j=0;j<list1.size();j++){
                                HSSFRow row1 = sheet.createRow(z + 1);
                                if ("A".equals(list1.get(j).getProjectSchedule())) {
                                    list1.get(j).setProjectSchedule("项目立项");
                                } else if ("B".equals(list1.get(j).getProjectSchedule())) {
                                    list1.get(j).setProjectSchedule("合同签订");
                                } else if ("C".equals(list1.get(j).getProjectSchedule())) {
                                    list1.get(j).setProjectSchedule("项目启动");
                                } else if ("项目建设".equals(list1.get(j).getProjectSchedule())) {
                                    list1.get(j).setProjectSchedule("项目建设");
                                } else if ("G".equals(list1.get(j).getProjectSchedule())) {
                                    list1.get(j).setProjectSchedule("上线试运行");
                                } else if ("H".equals(list1.get(j).getProjectSchedule())) {
                                    list1.get(j).setProjectSchedule("项目验收");
                                }
                                row1.createCell(1).setCellValue(list1.get(j).getProjectSchedule());
                                row1.createCell(2).setCellValue(list1.get(j).getContent());
                                row1.createCell(3).setCellValue(list1.get(j).getPredictStarttime());
                                row1.createCell(4).setCellValue(list1.get(j).getPridectEndtime());
                                row1.createCell(5).setCellValue(list1.get(j).getCurrentProgress());
                                row1.createCell(6).setCellValue(list1.get(j).getPerformance());
                                row1.createCell(7).setCellValue(list1.get(j).getSchedule());
                                row1.createCell(8).setCellValue(list1.get(j).getRemark());
                                z++;
                            }
                        }
                    }

                    if (i == 0) {
                        CellRangeAddress region = new CellRangeAddress(i + 1, (i + 1) * 5 + 1, 0, 0);
                        sheet.addMergedRegion(region);
                    } else {
                        CellRangeAddress region = new CellRangeAddress(i * 6 + 1, i * 6 + 6, 0, 0);
                        sheet.addMergedRegion(region);
                    }


                }


                //响应到客户端
                try {
                    this.setResponseHeader(response, fileName);
                    OutputStream os = response.getOutputStream();
                    wb.write(os);
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

    public static String getSystemFileCharset() {
        Properties pro = System.getProperties();
        return pro.getProperty("file.encoding");
    }


}
