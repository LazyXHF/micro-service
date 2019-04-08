package com.portjs.base.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.portjs.base.aop.LogInfo;

import com.portjs.base.entity.InvestmentPlan;
import com.portjs.base.entity.PurchaseList;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.PurchasingManagementService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by dengshuangzhen on 2019\4\4 0004
 * 采购管理模块
 */
@CrossOrigin
@RestController
@RequestMapping("/purchasing-management")
public class PurchasingManagementController  extends BaseController {
    static final String tag = "ProjectProceduresService===>";
    @Autowired
    private PurchasingManagementService managementService;

    @LogInfo(methodName = "Excel导入（EasyPoi）",modelName = "投资计划管理模块")
    @RequestMapping("/insert-for-excel")
    @ResponseBody
    public ResponseMessage insertForExcel(@RequestParam("file") MultipartFile file){
        List<InvestmentPlan> list = null;
        ImportParams importParams =  new ImportParams();
        importParams.setTitleRows(0);
        importParams.setHeadRows(1);
        logger.error(tag + "insert-for-excel()begin....."+file );
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), PurchaseList.class,importParams);
            if(!CollectionUtils.isEmpty(list)){
                ResponseMessage responseMessage = new ResponseMessage(Code.CODE_OK,"插入成功",list);
                return responseMessage;
            }
            return new ResponseMessage(Code.CODE_ERROR,"插入失败");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insert-for-excel() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }

    @LogInfo(methodName = "采购详情暂存/提交",modelName = "采购管理")
    @RequestMapping("/insert-procurement-details")
    @ResponseBody
    public ResponseMessage inserProcurementDetails(@RequestBody String responseBody){
        UnifiedExceptionHandler.method= responseBody + "inserProcurementDetails==============================" + responseBody;
        logger.debug(tag + responseBody);
        return managementService.inserProcurementDetails(responseBody);
    }

}
