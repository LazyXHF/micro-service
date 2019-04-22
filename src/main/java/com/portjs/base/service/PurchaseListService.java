package com.portjs.base.service;

import com.portjs.base.entity.InvestmentPlan;
import com.portjs.base.entity.PurchaseList;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
@Repository
public interface PurchaseListService {

    //ResponseMessage deleteByPrimaryKey(String id);

    //ResponseMessage insert(PurchaseList record);

    //ResponseMessage insertSelective(PurchaseList record);

    //ResponseMessage selectByPrimaryKey(String id);

    ResponseMessage updateByPrimaryKeySelective(PurchaseList record);


    ResponseMessage insertPurchaseListSelective(PurchaseList record);
    //ResponseMessage updateByPrimaryKey(PurchaseList record);
    /**
     * 对列表的分页并模糊查询
     * @param requestBody
     * @return
     */
    ResponseMessage queryPurchaseListInfo(String requestBody);
    /**
     * 批量软删除
     * @param ids
     * @return
     */
    ResponseMessage updateDeleteTimeByIds(List<String> ids);

    ResponseMessage queryPurchaseListById(String ids);


    /**
     *Excel导入（poi）
     * @param file
     * @return
     */
    ResponseMessage insertExcel(MultipartFile file)  throws IOException, ParseException;
    /**
     *Excel导入（EasyPoi）
     * @param list
     * @return
     */
    //ResponseMessage insertExcelByEasyPoi(List<PurchaseList> list,String loginId) throws Exception;

    /**
     * 根据request_id查询信息
     * @param requestId
     * @return
     */
    ResponseMessage queryPurchaseListByRequestId(String requestId);
}
