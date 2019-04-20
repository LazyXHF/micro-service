package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.TUserDepartmentService;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("tUserDepartment")
@CrossOrigin
@RestController
public class TUserDepartmentController extends BaseController {
    ResponseMessage responseMessage=null;
    static final String TAG = "tUserDepartmentService===>";

    @Autowired
    TUserDepartmentService tUserDepartmentService;

    /**
     * 查询采购清单列表信息并分页
     * @param uId
     * @return
     */
    @RequestMapping("find-department-by-user-id")
    @LogInfo(methodName = "查询项目沟通信息并分页且模糊查询")
    public ResponseMessage queryPurchaseListInfo(@RequestBody String uId) {
        logger.debug(TAG+uId);
        UnifiedExceptionHandler.method = TAG + "queryPurchaseListInfo()==================================>" + uId;
        responseMessage = tUserDepartmentService.findTUserDepartmentMapper(uId);
        return responseMessage;
    }

}
