package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by dengshuangzhen on 2019\3\28 0028
 */
public interface ProjectPreservationService {

    /**
     * 立项暂存/提交
     * @param responseBody
     * @return
     */
    ResponseMessage insertStorage(String responseBody) throws Exception;
    /**
     * 立项退回
     * @param responseBody
     * @return
     */
    ResponseMessage returnStorage(String responseBody)throws Exception;

    /**
     * 查询项目分类/投资主体/责任单位/建设方式
     * @return
     */
    ResponseMessage selectBox(String requestBody);


    /**
     * 按条件分页查询投资计划
     * @param requestBody
     * @return
     */
    ResponseMessage selectInvestment(String requestBody);

    /**
     *Excel导入（poi）
     * @param file
     * @return
     */
    ResponseMessage insertExcel(MultipartFile file)  throws IOException, ParseException;
}
