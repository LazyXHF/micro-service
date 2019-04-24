package com.portjs.base.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.entity.TXietongDocModel;
import com.portjs.base.util.Page;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.portjs.base.dao.TXietongSoftwareMapper;
import com.portjs.base.entity.TXietongSoftware;
import com.portjs.base.entity.TXietongSoftwareExample;
import com.portjs.base.entity.TXietongSoftwareExample.Criteria;
import com.portjs.base.service.DownloadSoftwareService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.Upload;
@Service
@Transactional
public class DownloadSoftwareServiceImpl implements DownloadSoftwareService{

	@Autowired
	private TXietongSoftwareMapper tXietongSoftwareMapper;
	@Autowired
	private Upload upload;

	//页面展示下载软件
	@Override
	public ResponseMessage selectAllSoftware(String requestBody) {
		JSONObject jsonObject = (JSONObject) JSONObject.parse(requestBody);
		String softwareName = jsonObject.getString("softwareName");
		Integer pageNo = jsonObject.getInteger("pageNo");
		Integer pageSize = jsonObject.getInteger("pageSize");

		Page<TXietongSoftware> page = new Page<>();
		int total = tXietongSoftwareMapper.selectSoftwareCounts(softwareName);
		page.init(total, pageNo, pageSize);
		List<TXietongSoftware> list = tXietongSoftwareMapper.querySoftwareByPage(softwareName,page.getRowNum(),page.getPageCount());
		page.setList(list);
		return new ResponseMessage(Code.CODE_OK,"查询成功！",page);
	}

	//新增软件
	@Override
	public ResponseMessage insertSoftware(String filePath, String softwareName, String softwareVersion) {
		
		/*String flieUrl = upload.uploadFlie(file);
		
		if("1".equals(flieUrl)){
			return new ResponseMessage(Code.CODE_STOP ,"stop","上传失败");
		}*/

		TXietongSoftware software = new TXietongSoftware();
		software.setDownloadPath(filePath);
		software.setSoftwareName(softwareName);
		software.setSoftwareVersion(softwareVersion);
		software.setCreatetime(new Date());
		software.setIsdelete(1);//是否删除 0 为删除 1 为未删除
		software.setDownloadTimes(0);//下载次数默认为0
		software.setId(UUID.randomUUID().toString());

		int status = tXietongSoftwareMapper.insert(software);
		if(status == 0){
			return new ResponseMessage(Code.CODE_ERROR ,"error","插入数据库失败");
		}

		return new ResponseMessage(Code.CODE_OK ,"success","上传成功");

	}

	//逻辑删除
	@Override
	public int deleteSoftware(String id) {

		TXietongSoftware software = tXietongSoftwareMapper.selectByPrimaryKey(id);

		if(software != null){
			software.setIsdelete(0);
			int status = tXietongSoftwareMapper.updateByPrimaryKey(software);
			return status;
		}else{
			return 0;
		}


	}

	//模糊查询
	@Override
	public List<TXietongSoftware> selectBySoftwareName(String softwareName) {

		TXietongSoftwareExample example = new TXietongSoftwareExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andSoftwareNameLike("%"+softwareName+"%");
		createCriteria.andIsdeleteEqualTo(1);
		return tXietongSoftwareMapper.selectByExample(example );
	}

	//下载成功后下载次数加一
	@Override
	public int updateByDownload(String id) {
		TXietongSoftware software = tXietongSoftwareMapper.selectByPrimaryKey(id);
		software.setDownloadTimes(software.getDownloadTimes()+1);

		int updateByPrimaryKey = tXietongSoftwareMapper.updateByPrimaryKey(software);
		return updateByPrimaryKey;
	}

	//查重
	@Override
	public List<TXietongSoftware> selectDuplicate(String softwareName, String softwareVersion) {
		TXietongSoftwareExample example = new TXietongSoftwareExample();
		Criteria create = example.createCriteria();
		create.andSoftwareNameEqualTo(softwareName);
		create.andSoftwareVersionEqualTo(softwareVersion);
		create.andIsdeleteEqualTo(1);
		List<TXietongSoftware> resultList = tXietongSoftwareMapper.selectByExample(example );
		return resultList;
	}

}
