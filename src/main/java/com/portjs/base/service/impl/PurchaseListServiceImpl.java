package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.PurchaseListMapper;
import com.portjs.base.entity.ProjectCommunication;
import com.portjs.base.entity.PurchaseList;
import com.portjs.base.service.PurchaseListService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseListServiceImpl implements PurchaseListService {
    ResponseMessage responseMessage = null ;

    @Autowired
    PurchaseListMapper purchaseListMapper;

    /**
     * 添加列表信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertPurchaseListSelective(PurchaseList record) {
        record.setId(UUID.randomUUID().toString());
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        try {
            Date time = sdf.parse(nowTime);
            record.setCreateTime(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(record.getProjectId())){
            return new ResponseMessage(Code.CODE_ERROR,"查询采购列表时projectId未传!",record.getProjectId());
        }
        int i = purchaseListMapper.insertPurchaseListSelective(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加信息时失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"添加信息成功！",i);
    }

    /**
     * 根据列表自身id查询信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage queryPurchaseListById(String id) {
        PurchaseList purchaseList = purchaseListMapper.queryPurchaseListById(id);
        if(purchaseList == null){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",purchaseList);
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！",purchaseList);
    }

    /**
     * 修改列表信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKeySelective(PurchaseList record) {
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        try {
            Date time = sdf.parse(nowTime);
            record.setUpdateTime(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(record.getId())){
            return new ResponseMessage(Code.CODE_ERROR,"修改信息时未选中信息！");
        }
        int i = purchaseListMapper.updateByPrimaryKeySelective(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"修改信息失败",i);
        }
        return new ResponseMessage(Code.CODE_ERROR,"修改信息失败",i);
    }

    /**
     * 查询列表并分页且模糊查询
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage queryPurchaseListInfo(String requestBody) {
        JSONObject jsonObject=JSONObject.parseObject(requestBody);
        String projectId = jsonObject.getString("projectId");
        String requestId = jsonObject.getString("requestId");//问题分类
        int pageNo = jsonObject.getInteger("pageNo");
        int pageSize = jsonObject.getInteger("pageSize");

        if(StringUtils.isEmpty(projectId)){
            return new ResponseMessage(Code.CODE_ERROR,"查询采购列表时projectId未传!",projectId);
        }
        if(StringUtils.isEmpty(requestId)){
            return new ResponseMessage(Code.CODE_ERROR,"查询采购列表时采购申请d未传!",requestId);
        }

        Page<PurchaseList> page = new Page<>();
        int totalCount = purchaseListMapper.purchaseListCounts(projectId,requestId);
        page.init(totalCount,pageNo,pageSize);
        List<PurchaseList> list = purchaseListMapper.queryPurchaseListInfo(projectId,requestId,page.getRowNum(), page.getPageCount());
        page.setList(list);

        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功！",page);

        return responseMessage;
    }

    /**
     * 批量软删除
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage updateDeleteTimeByIds(List<String> ids) {
        PurchaseList purchaseList = null;
        /*Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time = null;
        try {
            time = sdf.parse(nowTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        for (int j = 0 ;j < ids.size() ; j++) {
            String id = ids.get(j);
            purchaseList = purchaseListMapper.selectByPrimaryKey(id);
            if(!StringUtils.isEmpty(String.valueOf(purchaseList.getDeleteTime()))){
                return new ResponseMessage(Code.CODE_ERROR,"删除失败","失败的列表问题id："+purchaseList.getId()+" ： "+purchaseList.getDeleteTime());
            }
        }
        int i = purchaseListMapper.updateDeleteTimeByIds(ids);

        if(i == 0){
            return new ResponseMessage(Code.CODE_ERROR,"批量删除失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"批量删除成功！",i);
    }
}
