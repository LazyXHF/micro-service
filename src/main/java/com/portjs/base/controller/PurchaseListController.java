package com.portjs.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.entity.PurchaseList;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.PurchaseListService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * 新建购清单列表信息
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


}
