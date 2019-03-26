package com.portjs.base.service;

import com.portjs.base.entity.InternalProject;
import com.portjs.base.entity.Life;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface LifeService {

    /**
     * 条件插入
     * @param record
     * @return
     */
    ResponseMessage insertSelective(List<Life> record);
    /**
     * 条件查询
     * @param record
     * @return
     */
    ResponseMessage selectByPrimaryKey(Life record);
    /**
     * id更新
     * @param record
     * @return
     */
    ResponseMessage updateByPrimaryKeySelective(Life record);
    /**
     * 计算在建项目总个数
     * @return
     */
    int sumLine();

    /**
     * 查询在建项目id
     * @return
     */
    List<Life> sumLines();

    /**
     * 计算在建项目的总金额
     * @return
     */
    BigDecimal sumMoney();

    /**
     * 异常项目
     * @return
     */
    List<InternalProject> abnormalProjects();

    /**
     * 在建项目
     * @return
     */
    List<Map<String,Object>>  onlineList();
}