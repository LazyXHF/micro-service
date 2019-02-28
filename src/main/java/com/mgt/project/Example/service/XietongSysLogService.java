package com.mgt.project.Example.service;


import com.mgt.project.Example.dao.IXietongSysLogDao;
import com.mgt.project.Example.entity.TXietongSysLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class XietongSysLogService {
	static final String tag = "XietongSysLogService======";
	static final Logger logger = LoggerFactory.getLogger(XietongSysLogService.class);

	@Autowired
	private IXietongSysLogDao sysLogDao;

	public int getCount(String operatorName,String startTime, String endTime) {
		return sysLogDao.selectCount(operatorName,startTime,endTime);
	}

	public List<TXietongSysLog> getSyslog(String operatorName, String startTime, String endTime, int rownum, int pagenum,
										  int pagecount) {
		return sysLogDao.selectSyslog(operatorName, startTime, endTime, rownum, pagecount);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
	public int insertSyslog(TXietongSysLog sysLog) {
		logger.debug(tag + "sysLog={}", sysLog);
		return sysLogDao.insertSyslog(sysLog);
	}

}
