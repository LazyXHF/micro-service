package com.portjs.base.service.impl;

import com.portjs.base.dao.InternalApprovalMapper;
import com.portjs.base.entity.InternalApproval;
import com.portjs.base.service.InternalApprovalService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class InternalApprovalServiceImpl implements InternalApprovalService {

    ResponseMessage responseMessage = null;

    @Autowired
    InternalApprovalMapper internalApprovalMapper;

    /**
     * 添加数据
     * @param id
     * @return
     */
    @Override
    public ResponseMessage selectByPrimaryKey(String id) {

        InternalApproval internalApproval = internalApprovalMapper.selectByPrimaryKey(id);
        if(internalApproval!=null ){
            responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",internalApproval);
        }else {
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"无数据",internalApproval);
        }

        return new ResponseMessage(Code.CODE_OK,"已查询数据",internalApproval);
    }

    /**
     * 统计新增数据条数
     * @return
     */
    @Override
    public ResponseMessage newIncreaseProjectCount() {


        int i = internalApprovalMapper.newIncreaseProjectCount();
        if(i==0){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"暂无数据",i);
        }

        return new ResponseMessage(Code.CODE_OK,"新增数据",i);
    }

    /**
     * 统计今年新增项目总金额
     * @return
     */
    @Override
    public ResponseMessage newIncreaseProjectAmountCount() {
        BigDecimal amount = internalApprovalMapper.newIncreaseProjectAmountCount();
        return new ResponseMessage(Code.CODE_OK,"新增项目总金额",amount);
    }
}
