package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.PuchaseRequestService;
import com.portjs.base.util.ResponseMessage;
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
     * 暂存/提交购清单列表信息
     * @param record
     * @return
     */
    @RequestMapping("insert-purchase-request-info")
    @LogInfo(methodName = "新建购清单列表信息")
    public ResponseMessage insertPurchaseListSelective(@RequestBody String record) {
        logger.debug(TAG+record);
        UnifiedExceptionHandler.method = TAG + "insertSelective============================" +record;
        responseMessage = puchaseRequestService.insertPurchaseRequestSelective(record);
        return responseMessage;
    }


}
