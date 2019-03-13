package com.portjs.base.service;

import com.portjs.base.entity.Coord;
import com.portjs.base.util.ResponseMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CoordService {
    /**
     * 多条删除，支持单条删除
     * @param id
     * @return
     */
    ResponseMessage deleteByPrimaryKey(@Param("id") List<String> id);
    /**
     * 插入
     * @param record
     * @return
     */
    ResponseMessage insert(Coord record);
    /**
     * 条件插入
     * @param record
     * @return
     */
    ResponseMessage insertSelective(Coord record,MultipartFile file);
    /**
     * record，条件查询
     * @param record
     * @return
     */
    ResponseMessage selectByPrimaryKey(Coord record);
    /**
     * 条件更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(Coord record);
    /**
     * 全更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeyWithBLOBs(Coord record);
    /**
     * id更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKey(Coord record);
    /**
     * 下载文件
     * @param request
     * @param response
     * @param id
     * @return
     */

    ResponseMessage downloadFile(HttpServletRequest request, HttpServletResponse response, String id);
}