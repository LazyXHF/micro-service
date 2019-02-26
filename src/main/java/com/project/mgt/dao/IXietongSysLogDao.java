package com.project.mgt.dao;


import com.project.mgt.entity.TXietongSysLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IXietongSysLogDao {

	public int selectCount(@Param("operatorName") String operatorName, @Param("startTime") String startTime, @Param("endTime") String endTime);// 此处传入的 id

	public List<TXietongSysLog> selectSyslog(@Param("operatorName") String operatorName, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("rownum") int rownum,
                                             @Param("pagecount") int pagecount);// 此处传入的 id

	public int insertSyslog(TXietongSysLog sysLog);
	public void del(String id);

}
