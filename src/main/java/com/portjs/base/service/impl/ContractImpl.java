package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.PurchaseReviewMapper;
import com.portjs.base.dao.TenderApplicationMapper;
import com.portjs.base.entity.TenderApplicationExample;
import com.portjs.base.service.ContractService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dengshuangzhen on 2019\4\10 0010
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ContractImpl implements ContractService {
    private String message = "";
    private Integer code;
    @Autowired
    private PurchaseReviewMapper reviewMapper;
    @Autowired
    private TenderApplicationMapper applicationMapper;

    /**
     * 查询合同来源
     * @param responseBody
     * @return
     */
    @Override
    public ResponseMessage selectContractSource(String responseBody) {
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        String method = jsonObject.getString("type");//采购方式
        String projectId = jsonObject.getString("projectId");//项目id
        String projectName = jsonObject.getString("projectName");//项目名称
        Integer pageNum = jsonObject.getInteger("pageNum");//当前页数
        Integer pageCount = jsonObject.getInteger("pageCount");//每页显示记录数
        //首先判断采购方式

        if(method.equals("1")||method.equals("2")){
            //查询招标申请单

            int count = applicationMapper.selectByMethodCount(method,projectId,projectName);


        }
        if(method.equals("3")||method.equals("4")||method.equals("5")||method.equals("6")){
            //查询采购评审单


        }

        return null;
    }
}
