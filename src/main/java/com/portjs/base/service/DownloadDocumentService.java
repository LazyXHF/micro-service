package com.portjs.base.service;

import java.util.List;


import com.portjs.base.entity.TXietongDocModel;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.PageVo;


public interface DownloadDocumentService {

	ResponseMessage selectAllDocument(PageVo pageVo);

	ResponseMessage insertDocument(String filePath, String docName, String docDescription);

	int deleteDocument(String id);

	List<TXietongDocModel> selectByDocumentName(String documentName);

	int updateByDownload(String id);

	List<TXietongDocModel> selectDuplicate(String documentName, String docDescription);

}
