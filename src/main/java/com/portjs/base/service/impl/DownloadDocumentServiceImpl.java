package com.portjs.base.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.portjs.base.dao.TXietongDocModelMapper;
import com.portjs.base.entity.TXietongDocModel;
import com.portjs.base.entity.TXietongDocModelExample;
import com.portjs.base.entity.TXietongDocModelExample.Criteria;
import com.portjs.base.service.DownloadDocumentService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.Upload;
@Service
@Transactional
public class DownloadDocumentServiceImpl implements DownloadDocumentService{

	
	@Autowired
	private TXietongDocModelMapper tXietongDocModelMapper;
	@Autowired
	private Upload upload;
	
	//展示所有未删除模板文件
	@Override
	public List<TXietongDocModel> selectAllDocument() {
		
		TXietongDocModelExample example = new TXietongDocModelExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIsdeleteEqualTo(1);
		return  tXietongDocModelMapper.selectByExample(example );
	}
	
	//新增文档模板
	@Override
	public ResponseMessage insertDocument(String filePath, String docName,String docDescription) {
		
		/*String flieUrl = upload.uploadFlie(file);
		
		if("1".equals(flieUrl)){
			return new ResponseMessage(Code.CODE_STOP ,"stop","上传失败");
		}*/
		
		
		TXietongDocModel tXietongDocModel = new TXietongDocModel();
		tXietongDocModel.setId(UUID.randomUUID().toString());
		tXietongDocModel.setDownloadPath(filePath);
		tXietongDocModel.setDocName(docName);
		tXietongDocModel.setDocDescription(docDescription);
		tXietongDocModel.setDownloadTimes(0);
		tXietongDocModel.setIsdelete(1);
		tXietongDocModel.setCreatetime(new Date());
		
		int status = tXietongDocModelMapper.insert(tXietongDocModel);
		if(status>0){
			return new ResponseMessage(Code.CODE_OK ,"success","保存成功");
		}else{
			return new ResponseMessage(Code.CODE_ERROR ,"error","保存失败");
		}
	}

	//删除模板文档
	@Override
	public int deleteDocument(String id) {
		TXietongDocModel docModel = tXietongDocModelMapper.selectByPrimaryKey(id);
		docModel.setIsdelete(0);
		int status = tXietongDocModelMapper.updateByPrimaryKey(docModel);
		return status;
	}

	//模糊查询
	@Override
	public List<TXietongDocModel> selectByDocumentName(String documentName) {
		TXietongDocModelExample example = new TXietongDocModelExample();
		Criteria criteria = example.createCriteria();
		criteria.andDocNameLike("%"+documentName+"%");
		criteria.andIsdeleteEqualTo(1);
		List<TXietongDocModel> list = tXietongDocModelMapper.selectByExample(example);
		return list;
	}

	//下载成功后下载次数新增1
	@Override
	public int updateByDownload(String id) {
		TXietongDocModel docModel = tXietongDocModelMapper.selectByPrimaryKey(id);
		if(docModel != null){
			docModel.setDownloadTimes(docModel.getDownloadTimes()+1);
			return tXietongDocModelMapper.updateByPrimaryKey(docModel);
		}else{
			return 0;
		}
	}

	//查重
	@Override
	public List<TXietongDocModel> selectDuplicate(String documentName,String docDescription) {
		TXietongDocModelExample example = new TXietongDocModelExample();
		Criteria criteria = example.createCriteria();
		criteria.andDocNameEqualTo(documentName);
		criteria.andDocDescriptionEqualTo(documentName);
		criteria.andIsdeleteEqualTo(1);
		List<TXietongDocModel> list = tXietongDocModelMapper.selectByExample(example );
		return list;
	}

}