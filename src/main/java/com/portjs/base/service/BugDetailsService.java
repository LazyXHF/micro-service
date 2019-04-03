package com.portjs.base.service;

import com.portjs.base.entity.BugDetails;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.PageVo;

import java.util.List;

public interface BugDetailsService {

    ResponseMessage deleteByPrimaryKey(List<String> ids);

    //int insert(BugDetails record);

    /**
     * 新增bug页面接口
     * @param record
     * @return
     */
    ResponseMessage insertSelective(BugDetails record);

    /**
     * 根据自身id查询Bug信息
     * @param id
     * @return
     */
    ResponseMessage selectByPrimaryKey(String id);

    ResponseMessage updateByPrimaryKeySelective(BugDetails record);

    /**
     * bug分页列表(添加)
     * @param requestBody
     * @return
     */
    ResponseMessage queryAllBugInfo(String requestBody);

    /**
     * bug分页列表（待办）
     * @param requestBody
     * @return
     */
   // ResponseMessage queryAllBugInfoDB(String requestBody);

    //ResponseMessage queryAllBugInfos();

    /**
     * 级联查询
     * @return
     */
    ResponseMessage queryAllBugAndRecordInfo(String id);

    /**
     * bug查询条件
     * @return
     */
    ResponseMessage queryBugSearch();

    /**
     * 根据record表的ownerid ,status(result) ,去查询主表信息并分页
     * @param requestBody
     * @return
     */
    ResponseMessage queryAllBugInfoFlow(String requestBody);



    /**
     * 查询待办
     * @return
     */
    ResponseMessage selectBugSearchDealtWith(PageVo pageVo);


    /**
     * 查询在办
     * @param pageVo
     * @return
     */
    ResponseMessage selectBugSearchDealtDoing(PageVo pageVo);

    /**
     * 查询已办
     * @param pageVo
     * @return
     */
    ResponseMessage selectBugSearchDealtEnd(PageVo pageVo);


    /**
     * 暂存Bug信息
     * @param record
     * @return
     */
    ResponseMessage temporaryBugs(BugDetails record);

    /**
     * 查找暂存
     * @param pageVo
     * @return
     */

    ResponseMessage selectBugSearchDealtTemporary(PageVo pageVo);


    /**
     * 修改暂存
     * @param details
     * @return
     */
    ResponseMessage updateTemporaryBugs(BugDetails details);

    //int updateByPrimaryKeyWithBLOBs(BugDetails record);

    //int updateByPrimaryKey(BugDetails record);




}
