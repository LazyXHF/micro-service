package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.PurchaseRequest;
import com.portjs.base.entity.TWorkflowstep;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.PuchaseRequestService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 采购清单列表
 */
@RequestMapping("puchaseRequest")
@CrossOrigin
@RestController
public class PurchaseRequestController extends BaseController {
    ResponseMessage responseMessage=null;
    static final String TAG = "purchaseListService===>";

    @Autowired
    PuchaseRequestService puchaseRequestService;


    /**
     * 暂存/提交购清单信息
     * @param responseBody
     * @return
     */
    @RequestMapping("insert-purchase-request-info")
    @LogInfo(methodName = "新建购清单信息")
    public ResponseMessage insertPurchaseListSelective(@RequestBody String responseBody) {
        logger.debug(TAG+responseBody);
        UnifiedExceptionHandler.method = TAG + "insertSelective============================" +responseBody;
        responseMessage = puchaseRequestService.insertPurchaseRequestSelective(responseBody);
        return responseMessage;
    }

    /**
     * 分页查询购清单信息
     * @param responseBody
     * @return
     */
    @RequestMapping("query-purchase-request-info-by-page")
    @LogInfo(methodName = "分页查询购清单列表信息")
    public ResponseMessage queryPurchaseListSelective(@RequestBody String responseBody) {
        logger.debug(TAG+responseBody);
        UnifiedExceptionHandler.method = TAG + "queryPurchaseListSelective============================" +responseBody;
        responseMessage = puchaseRequestService.queryPurchaseRequestInfo(responseBody);
        return responseMessage;
    }

    /**
     * 修改购物清单信息
     * @param responseBody
     * @return
     */
    @RequestMapping("update-purchase-request-info")
    @LogInfo(methodName = "修改购物清单信息")
    public ResponseMessage updateByPrimaryKeySelective(@RequestBody String responseBody) {
        logger.debug(TAG+responseBody);
        UnifiedExceptionHandler.method = TAG + "updateByPrimaryKeySelective============================" +responseBody;
        responseMessage = puchaseRequestService.updateByPrimaryKeySelective(responseBody);
        return responseMessage;
    }

    /**
     * 废除购物清单信息
     * @param purchaseRequest
     * @return
     */
    @RequestMapping("abolish-record")
    @LogInfo(methodName = "废除购物清单信息")
    public ResponseMessage abolishRecord(@RequestBody PurchaseRequest purchaseRequest) {
        logger.debug(TAG+purchaseRequest);
        UnifiedExceptionHandler.method = TAG + "abolishRecord============================" +purchaseRequest;
        responseMessage = puchaseRequestService.abolishRecord(purchaseRequest);
        return responseMessage;
    }


    /**
     * 批量软删除购物清单信息
     * @param arrayVO
     * @return
     */
    @RequestMapping("batch-update-purchase-request-info")
    @LogInfo(methodName = "批量软删除购物清单信息")
    public ResponseMessage updateDeleteTimeByIds(@RequestBody ArrayVO arrayVO) {
        logger.debug(TAG+arrayVO);
        UnifiedExceptionHandler.method = TAG + "updateDeleteTimeByIds============================" +arrayVO;
        responseMessage = puchaseRequestService.updateDeleteTimeByIds(arrayVO.getList());
        return responseMessage;
    }

    /**
     * 根据id查询购物清单信息
     * @param id
     * @return
     */
    @RequestMapping("query-purchase-request-info-by-id")
    @LogInfo(methodName = "根据id查询购物清单信息")
    public ResponseMessage queryPurchaseRequestById(@RequestBody String id) {
        logger.debug(TAG+id);
        JSONObject jsonObject = JSONObject.parseObject(id);
        String ids = jsonObject.getString("id");
        UnifiedExceptionHandler.method = TAG + "queryPurchaseRequestById()==================================>" + ids;
        responseMessage = puchaseRequestService.queryPurchaseRequestById(id);
        return responseMessage;
    }

    /**
     * 查询所有可用部门
     * @return
     */
    @RequestMapping("query-all-department")
    @LogInfo(methodName = "查询所有可用部门")
    public ResponseMessage findAllDepartment() {
        logger.debug(TAG);
        UnifiedExceptionHandler.method = TAG + "findAllDepartment()==================================>" ;
        responseMessage = puchaseRequestService.findAllDepartment();
        return responseMessage;
    }

    /**
     * 根据id查询购物清单信息
     * @param
     * @return
     */
   /* @RequestMapping("query-purchase-request-info-by-id")
    @LogInfo(methodName = "根据id查询购物清单信息")
    public ResponseMessage queryAllWorkFlowStep(@RequestBody String id) {
        logger.debug(TAG+id);
        JSONObject jsonObject = JSONObject.parseObject(id);
        String ids = jsonObject.getString("id");
        UnifiedExceptionHandler.method = TAG + "queryPurchaseRequestById()==================================>" + ids;
        responseMessage = puchaseRequestService.queryAllWorkFlowStep(id);
        return responseMessage;
    }
*/
    @LogInfo(methodName = "退回",modelName = "采购评审")
    @RequestMapping("return-record")
    @ResponseBody
    public ResponseMessage returnRecord(@RequestBody String requestBody) {
        logger.debug("returnRecord" + requestBody);
        return puchaseRequestService.returnRecord(requestBody);
    }

    @LogInfo(methodName = "采购评审审核",modelName = "采购评审")
    @RequestMapping("approve-purchase-request")
    @ResponseBody
    public ResponseMessage approvePurchaseRequest(@RequestBody String requestBody) {
        logger.debug("approvePurchaseRequest" + requestBody);
        return puchaseRequestService.approvePurchaseRequest(requestBody);
    }
    /**
     * 下拉框查询
     * @param
     * @return
     */
    @RequestMapping("query-dropList")
    @LogInfo(methodName = "下拉框查询")
    public ResponseMessage queryDropList() {
        logger.debug(TAG);
        UnifiedExceptionHandler.method = TAG + "queryDropList============================" ;
        responseMessage = puchaseRequestService.queryDropList();
        return responseMessage;
    }

}
