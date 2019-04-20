package com.portjs.base.service;

import com.alibaba.fastjson.JSONArray;
import com.portjs.base.entity.Annex;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface AnnexService {
    /**
     * 多条删除，支持单条删除
     * @param ids
     * @return
     */
    ResponseMessage deleteByPrimaryKey(List<String> ids);

    /**
     * 插入
     * @param record
     * @return
     */
    ResponseMessage insert(Annex record);
    /**
     * 插入 加入上传文件
     * @param
     * @return
     */
    ResponseMessage insertSelective(JSONArray list);

    /**
     * 根据annex，条件查询
     * @param annex
     * @return
     */
    ResponseMessage selectByPrimaryKey(Annex annex);

    /**
     * 条件更新
     * @param requestJson
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(JSONArray requestJson);

    /**
     * 更新所有
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKey(Annex record);

    /**
     * 下载文件
     * @param request
     * @param response
     * @param id
     * @return
     */

    ResponseMessage downloadFile(HttpServletRequest request, HttpServletResponse response, String id);
}