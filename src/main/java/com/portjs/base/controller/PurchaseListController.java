package com.portjs.base.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.InvestmentPlan;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.entity.PurchaseList;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.PurchaseListService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 采购清单列表
 */
@RequestMapping("purchaseList")
@CrossOrigin
@RestController
public class PurchaseListController extends BaseController {
    ResponseMessage responseMessage=null;
    static final String TAG = "purchaseListService===>";

    @Autowired
    PurchaseListService purchaseListService;

    /**
     * 查询采购清单列表信息并分页
     * @param requestBody
     * @return
     */
    @RequestMapping("query-purchase-list-info")
    @LogInfo(methodName = "查询项目沟通信息并分页且模糊查询")
    public ResponseMessage queryPurchaseListInfo(@RequestBody String requestBody) {
        logger.debug(TAG+requestBody);
        UnifiedExceptionHandler.method = TAG + "queryPurchaseListInfo()==================================>" + requestBody;
        responseMessage = purchaseListService.queryPurchaseListInfo(requestBody);
        return responseMessage;
    }

    /**
     * 根据id查询采购清单列表信息
     * @param id
     * @return
     */
    @RequestMapping("select-purchase-list-info")
    @LogInfo(methodName = "根据id查询采购清单列表信息")
    public ResponseMessage queryProjectCommunicationById(@RequestBody String id) {
        logger.debug(TAG+id);
        JSONObject jsonObject = JSONObject.parseObject(id);
        String ids = jsonObject.getString("id");
        UnifiedExceptionHandler.method = TAG + "selectByPrimaryKey()==================================>" + ids;
        responseMessage = purchaseListService.queryPurchaseListById(ids);
        return responseMessage;
    }

    /**
     * 根据id批量软删除采购清单列表信息
     * @param
     * @return
     */
    @RequestMapping("update-purchase-list-delete-time")
    @LogInfo(methodName = "根据id批量软删除采购清单列表信息")
    public ResponseMessage updateDeleteTimeByIds(@RequestBody ArrayVO arrayVO) {
        logger.debug(TAG+arrayVO);
        UnifiedExceptionHandler.method = TAG + "updateDeleteTimeByIds============================" +arrayVO;
        responseMessage = purchaseListService.updateDeleteTimeByIds(arrayVO.getList());
        return responseMessage;
    }
    /**
     * 根据request_id查询采购清单列表信息
     * @param
     * @return
     */
    @RequestMapping("query-purchase-list-by-request-id")
    @LogInfo(methodName = "根据id批量软删除采购清单列表信息")
    public ResponseMessage queryPurchaseListByRequestId(@RequestBody String requestId) {
        logger.debug(TAG+requestId);
        UnifiedExceptionHandler.method = TAG + "queryPurchaseListByRequestId============================" +requestId;
        responseMessage = purchaseListService.queryPurchaseListByRequestId(requestId);
        return responseMessage;
    }

    /**
     * 修改购清单列表信息
     * @param record
     * @return
     */
    @RequestMapping("update-purchase-list")
    @LogInfo(methodName = "根据id更新购清单列表信息")
    public ResponseMessage updateByPrimaryKeySelective(@RequestBody PurchaseList record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method = TAG + "updateByPrimaryKeySelective============================" +record;
        responseMessage = purchaseListService.updateByPrimaryKeySelective(record);
        return responseMessage;
    }

    /**
     * TODO -----暂存/提交购清单列表信息
     * @param record
     * @return
     */
    @RequestMapping("insert-purchase-list-info")
    @LogInfo(methodName = "新建购清单列表信息")
    public ResponseMessage insertPurchaseListSelective(@RequestBody PurchaseList record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method = TAG + "insertSelective============================" +record;
        responseMessage = purchaseListService.insertPurchaseListSelective(record);
        return responseMessage;
    }

    /**
     *Excel导入（poi）
     * @param file
     * @return
     */
    @LogInfo(methodName = "Excel导入（poi）",modelName = "采购模块")
    @RequestMapping("insert-excel")
    @ResponseBody
    public ResponseMessage insertExcel (@RequestParam("file") MultipartFile file) {
        logger.error(TAG + "insert-excel()begin....."+file );
        try {
            if(file == null){
                return new ResponseMessage(Code.CODE_ERROR,"文件为空");
            }
            ResponseMessage uploadResponse= purchaseListService.insertExcel(file);
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
    /*@LogInfo(methodName = "Excel导出（EasyPoi）")
    @RequestMapping("select-for-excel")
    public ResponseMessage selectForExcel () {
        try {
            List list = purchaseListService.selectAll();
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("","江苏省港口集团2019年度投资计划表"), InvestmentPlan.class, list);
            return new ResponseMessage(Code.CODE_OK,"",workbook);


        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insert-for-excel() end...",e);
            return new ResponseMessage(Code.CODE_ERROR,"未知异常");
        }
    }*/


}
