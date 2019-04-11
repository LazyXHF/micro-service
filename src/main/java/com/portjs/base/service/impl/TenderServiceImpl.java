package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.TenderApplicationMapper;
import com.portjs.base.entity.PurchaseRequest;
import com.portjs.base.service.TenderService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author gumingyang
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TenderServiceImpl implements TenderService {
    //返参信息
    public final static String PARAM_MESSAGE_1 = "未传";

    @Autowired
    private TenderApplicationMapper tenderApplicationMapper;

    @Override
    public ResponseMessage queryRequests(String requestBody) throws Exception {
        JSONObject jsonObj=JSONObject.parseObject(requestBody);
        PurchaseRequest purchaseRequest = JSONObject.toJavaObject(jsonObj, PurchaseRequest.class);
        //必要值检验
        Map<String,Object> map = purchaseRequest.getParams();
        if(null==map.get("pageSize")){
            return  new ResponseMessage(Code.CODE_ERROR, "pageSize"+PARAM_MESSAGE_1);
        }
        if(null==map.get("pageNo")){
            return  new ResponseMessage(Code.CODE_ERROR, "pageNo"+PARAM_MESSAGE_1);
        }
        //查询全部的数据
        if(null==purchaseRequest.getStatus()){
            purchaseRequest.setStatus("0");
        }
        //查询项目编码对应的projectid
        if(null!=purchaseRequest.getProjectCode()){

        }
        //查询项目名称对应的projectid
        if(null!=purchaseRequest.getProjectName()){

        }
        List<PurchaseRequest> purchaseRequests = tenderApplicationMapper.selectRequests(purchaseRequest);


        return null;
    }
}
