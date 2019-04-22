package com.portjs.base.controller;

/**
 * Created by dengshuangzhen on 2019\3\28 0028
 * 立项保存
 */

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.InvestmentPlan;
import com.portjs.base.service.ProjectPreservationService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/projectPreservation")
public class ProjectPreservationController  extends BaseController {
    static final  String TAG = "ProjectController================>";
    @Resource
    private ProjectPreservationService projectPreservationService;
    @LogInfo(methodName = "立项暂存/提交",modelName = "立项保存模块")
    @RequestMapping("/insert-designs")
    @ResponseBody
    public ResponseMessage insertDesigns(@RequestBody String responseBody) {
        try {
            logger.error(TAG + "insert-designs()begin....." + responseBody);
            return projectPreservationService.insertStorage(responseBody);
        } catch (Exception e) {
            logger.error(TAG + "insert-designs()error.....", e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "立项退回",modelName = "立项保存模块")
    @RequestMapping("/return-designs")
    @ResponseBody
    public ResponseMessage returnDesigns(@RequestBody String responseBody){
        try {
            logger.error(TAG + "return-designs()begin....." + responseBody);
            return projectPreservationService.returnStorage(responseBody);
        } catch (Exception e) {
            logger.error(TAG + "return-designs()error.....", e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "查询所有下拉框",modelName = "投资计划管理模块")
    @RequestMapping("/select-box")
    @ResponseBody
    public ResponseMessage selectBox(@RequestBody String requestBody){
        try {
            logger.error(TAG + "select-box()begin....."+requestBody );
            return projectPreservationService.selectBox(requestBody);
        } catch (Exception e) {
            logger.error(TAG + "select-box()error.....", e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "查询所有下拉框",modelName = "立项管理模块")
    @RequestMapping("/select-box-two")
    @ResponseBody
    public ResponseMessage selectBoxTwo(@RequestBody String requestBody){
        try {
            logger.error(TAG + "select-box-two()begin....."+requestBody );
            return projectPreservationService.selectBoxTwo(requestBody);
        } catch (Exception e) {
            logger.error(TAG + "select-box-two()error.....", e);
            throw new RuntimeException();
        }
    }

    @LogInfo(methodName = "按条件分页查询投资计划",modelName = "投资计划管理模块")
    @RequestMapping("/select-investment")
    @ResponseBody
    public ResponseMessage selectInvestment(@RequestBody String requestBody){
        try {
            logger.error(TAG + "select-investment()begin....."+requestBody );
            return projectPreservationService.selectInvestment(requestBody);
        } catch (Exception e) {
            logger.error(TAG + "select-investment()error.....", e);
            throw new RuntimeException();
        }
    }


    @LogInfo(methodName = "Excel导入（EasyPoi）",modelName = "投资计划管理模块")
    @RequestMapping("/insert-for-excel")
    @ResponseBody
    public ResponseMessage insertForExcel(@RequestParam("file")MultipartFile file, String loginId){
        List<InvestmentPlan> list = null;
        ImportParams importParams =  new ImportParams();
        importParams.setTitleRows(0);
        importParams.setHeadRows(1);
        importParams.setNeedSave(true);
        logger.error(TAG + "insert-for-excel()begin....."+file );
        try {
            try {
                list = ExcelImportUtil.importExcel(file.getInputStream(), InvestmentPlan.class,importParams);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseMessage(Code.CODE_ERROR,"导入表格数据错误，请修改");
            }
            if(!CollectionUtils.isEmpty(list)){
                ResponseMessage responseMessage = projectPreservationService.insertExcelByEasyPoi(list,loginId);
                return responseMessage;
            }
            return new ResponseMessage(Code.CODE_ERROR,"插入失败");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insert-for-excel() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,e.getMessage());
        }
    }

    /**
     *Excel导入（poi）
     * @param file
     * @return
     */
    @LogInfo(methodName = "Excel导入（poi）",modelName = "投资计划管理模块")
    @RequestMapping("insert-excel")
    @ResponseBody
    public ResponseMessage insertExcel (@RequestParam("file") MultipartFile file,String loginId) {
        logger.error(TAG + "insert-excel()begin....."+file );
        try {
            if(file == null){
                return new ResponseMessage(Code.CODE_ERROR,"文件为空");
            }
            ResponseMessage uploadResponse= projectPreservationService.insertExcel(file,loginId);
            return uploadResponse;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insert-excel() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *Excel导出（EasyPoi）
     * @param
     * @return
     */
    @LogInfo(methodName = "Excel导出（EasyPoi）")
    @RequestMapping("select-for-excel")
    public ResponseMessage selectForExcel () {
        try {
            List list = projectPreservationService.selectAll();
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("","江苏省港口集团2019年度投资计划表"), InvestmentPlan.class, list);
            return new ResponseMessage(Code.CODE_OK,"",workbook);


        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insert-for-excel() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    /**
     *总经办查询
     * @param
     * @return
     */
    @LogInfo(methodName = "总经办查询")
    @RequestMapping("select-user")
    @ResponseBody
    public ResponseMessage selectUser () {
        try {
            logger.error(TAG + "select-user()begin....." );
            return projectPreservationService.selectUser();
        } catch (Exception e) {
            logger.error(TAG + "select-user()error.....", e);
            throw new RuntimeException();
        }
    }



}
