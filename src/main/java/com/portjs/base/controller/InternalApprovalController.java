package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.service.InternalApprovalService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("internal-approval")
@CrossOrigin
@RestController
public class InternalApprovalController {
    ResponseMessage responseMessage = null;
    @Autowired
    InternalApprovalService internalApprovalService;

    /**
     * 查询所有立项信息
     * @param id
     * @return
     */
    @RequestMapping("query-all-approval-info")
    @LogInfo(methodName = "查询所有立项信息")
    public ResponseMessage selectByPrimaryKey(@RequestBody String id){
        try {
            responseMessage = internalApprovalService.selectByPrimaryKey(id);

        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"查询s失败",e);
        }
        return responseMessage;
    }

    /**
     * 统计所有新增数据条数
     * @param
     * @return
     */
    @RequestMapping("new-increase-project-count")
    @LogInfo(methodName = "统计所有新增数据条数")
    public ResponseMessage newIncreaseProjectCount(){
        try {
            responseMessage = internalApprovalService.newIncreaseProjectCount();
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"查询s失败",e);
        }


        return responseMessage;
    }

    /**
     * 统计所有新增项目总金额
     * @param
     * @return
     */
    @RequestMapping("new-increase-project-amount-count")
    @LogInfo(methodName = "统计所有新增项目总金额")
    public ResponseMessage newIncreaseProjectAmountCount(){
        try {
            responseMessage = internalApprovalService.newIncreaseProjectAmountCount();
        }catch (Exception e){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"查询s失败",e);
        }
        return responseMessage;
    }
}
