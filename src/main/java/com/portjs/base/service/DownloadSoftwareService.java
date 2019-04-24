package com.portjs.base.service;

import java.util.List;


import com.portjs.base.entity.TXietongSoftware;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.PageVo;


public interface DownloadSoftwareService {

	//页面展示数据
	ResponseMessage selectAllSoftware(String requestBody);

	//新增软件
	ResponseMessage insertSoftware(String filePath, String softwareName, String softwareVersion);
	//删除
	int deleteSoftware(String id);
	//模糊查询
	List<TXietongSoftware> selectBySoftwareName(String softwareName);
	//增加下载次数
	int updateByDownload(String id);
	//查重
	List<TXietongSoftware> selectDuplicate(String softwareName, String softwareVersion);

}
