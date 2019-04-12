package com.portjs.base.dao;

import com.portjs.base.entity.PurchaseRequest;
import com.portjs.base.entity.TenderApplication;
import com.portjs.base.entity.TenderApplicationExample;
import com.portjs.base.entity.TenderApplicationVo;
import com.portjs.base.vo.ContractVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TenderApplicationMapper {
    int countByExample(TenderApplicationExample example);

    int deleteByExample(TenderApplicationExample example);

    int deleteByPrimaryKey(String id);

    int insert(TenderApplication record);

    int insertSelective(TenderApplication record);

    List<TenderApplication> selectByExample(TenderApplicationExample example);

    TenderApplication selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TenderApplication record, @Param("example") TenderApplicationExample example);

    int updateByExample(@Param("record") TenderApplication record, @Param("example") TenderApplicationExample example);

    int updateByPrimaryKeySelective(TenderApplication record);

    int updateByPrimaryKey(TenderApplication record);

    /**
     * 项目招标的分页数据查询
     * @param tenderApplicationVo
     * @return
     */
    List<TenderApplicationVo>selectRequests(TenderApplicationVo tenderApplicationVo);
    /**
     * 项目招标的总数查询
     */
    int  selectRequestsCount(TenderApplicationVo tenderApplicationVo);

    /**
     * 查询总数
     * @param method
     * @param projectCode
     * @param projectName
     * @return
     */
    int selectByMethodCount(@Param("method") String method, @Param("projectCode") String projectCode,@Param("projectName")  String projectName);

    /**
     * 查询每页数据
     * @param method
     * @param projectCode
     * @param projectName
     * @param rowNum
     * @param pageCount
     * @return
     */
    List<ContractVo> selectByPage(@Param("method") String method, @Param("projectCode") String projectCode,@Param("projectName") String projectName,@Param("rowNum") Integer rowNum,@Param("pageCount") Integer pageCount);
}