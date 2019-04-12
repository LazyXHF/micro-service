package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.TenderApplicationMapper;
import com.portjs.base.entity.PurchaseRequest;
import com.portjs.base.entity.TenderApplicationVo;
import com.portjs.base.service.TenderService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
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
        TenderApplicationVo tenderApplicationVo = JSONObject.toJavaObject(jsonObj, TenderApplicationVo.class);
        //必要值检验
        Map<String,Object> map = tenderApplicationVo.getParams();
        if(CollectionUtils.isEmpty(map)){
            return  new ResponseMessage(Code.CODE_ERROR, "参数格式传值错误");
        }
        if(null==map.get("pageSize")){
            return  new ResponseMessage(Code.CODE_ERROR, "pageSize"+PARAM_MESSAGE_1);
        }
        if(null==map.get("pageNo")){
            return  new ResponseMessage(Code.CODE_ERROR, "pageNo"+PARAM_MESSAGE_1);
        }
        //分页条件查询
        Page page=new Page();
        int count = tenderApplicationMapper.selectRequestsCount(tenderApplicationVo);
        page.init(count,Integer.valueOf(map.get("pageNo").toString()),Integer.valueOf(map.get("pageSize").toString()));
        //重新放回计算过后分页数据
        Map<String,Object> tenderApplicationVoMap = new HashMap<String,Object>();
        tenderApplicationVoMap.put("pageNo",page.getRowNum());
        tenderApplicationVoMap.put("pageSize",page.getPageCount());
        tenderApplicationVo.setParams(tenderApplicationVoMap);

        List<TenderApplicationVo> tenderApplicationVos = tenderApplicationMapper.selectRequests(tenderApplicationVo);
        page.setList(tenderApplicationVos);

        return new ResponseMessage(Code.CODE_OK,"查询成功",page);
    }
}
