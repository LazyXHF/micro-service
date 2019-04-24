package com.portjs.base.controller;

import java.util.List;

import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.TXietongSoftware;
import com.portjs.base.service.DownloadSoftwareService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;

/**
 * 常用软件下载控制类
 * @author zhangyu
 *
 */
@RestController
@RequestMapping("/downloadSoftware")
public class DownloadSoftwareController extends BaseController{

	ResponseMessage responseMessage = null;

	static final String tag = "DownloadDocumentController======";
	@Autowired
	private DownloadSoftwareService DownloadSoftwareService;
	
	/**
	 * 展示所有软件
	 * @return 软件对象的集合
	 */
	@LogInfo(methodName = "展示所有软件")
	@RequestMapping("/selectAllSoftware")
	@ResponseBody
	public ResponseMessage selectAllSoftware(@RequestBody String requestBody){
		logger.debug(tag+"selectAllSoftware() begin===>");
		UnifiedExceptionHandler.method = tag + "selectAllSoftware()==================================>" ;
		responseMessage = DownloadSoftwareService.selectAllSoftware(requestBody);
		return responseMessage;
	}

	/**
	 * 新增软件
	 * @param requestBody
	 * @return
	 */
	@LogInfo(methodName = "新增软件")
	@PostMapping("/insertSoftware")
	@ResponseBody
	public ResponseMessage insertSoftware(@RequestBody String requestBody){
		
		JSONObject request = JSONObject.parseObject(requestBody);
		String filePath = request.getString("filePath");//状态
		String softwareName = request.getString("softwareName");//状态
		String softwareVersion = request.getString("softwareVersion");//状态
		
		
		logger.debug(tag+"insertSoftware() begin===>file="+filePath+"softwareName="+softwareName+"softwareVersion="+softwareVersion);
		try{
			return DownloadSoftwareService.insertSoftware(filePath,softwareName,softwareVersion);
		}catch(Exception  e){
			e.printStackTrace();
			logger.error(tag+"insertSoftware() end===>"+e);
			return new ResponseMessage(Code.CODE_ERROR ,"error","未知异常");
		}
		
	}
	/**
	 * 删除软件
	 * @param requestBody 软件id
	 * @return ResponseMessage 返回信息
	 */
	@LogInfo(methodName = "删除软件")
	@RequestMapping("/deleteSoftware")
	@ResponseBody
	public ResponseMessage deleteSoftware(@RequestBody String requestBody){
		logger.debug(tag+"deleteSoftware() begin===>requestBody="+requestBody);
		
		try{
			int status =0;
			JSONObject request = JSONObject.parseObject(requestBody);
			JSONArray ids = request.getJSONArray("id");
			for (Object id : ids) {
				
				status=DownloadSoftwareService.deleteSoftware(id+"");
		        if(status == 0){
		        	return new ResponseMessage(Code.CODE_ERROR ,"error","删除失败");
		        }
			}
			
			if(status !=0){
				 return new ResponseMessage(Code.CODE_OK ,"success","删除成功");	
			}else{
				return new ResponseMessage(Code.CODE_ERROR ,"error","删除失败");
			}
	        
		}catch(Exception e){
			e.printStackTrace();
			logger.error(tag+"deleteSoftware() end ===>"+e);
			return new ResponseMessage(Code.CODE_ERROR ,"error","未知异常");
		}
		
	}
	/**
	 * 根据软件名 模糊查询
	 * @param requestBody 模糊软件名
	 * @return ResponseMessage 返回信息
	 */
	@LogInfo(methodName = "根据软件名 模糊查询")
	@RequestMapping("/selectBySoftwareName")
	@ResponseBody
	public ResponseMessage selectBySoftwareName(@RequestBody String requestBody){
		logger.debug(tag+"selectBySoftwareName() begin===>requestBody="+requestBody);
		try{
			JSONObject request = JSONObject.parseObject(requestBody);
	        String softwareName = request.getString("softwareName");
	        List<TXietongSoftware> result = DownloadSoftwareService.selectBySoftwareName(softwareName);
	        return new ResponseMessage(Code.CODE_OK ,"success",result);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(tag+"selectBySoftwareName() end ===>"+e);
			return new ResponseMessage(Code.CODE_ERROR ,"error","未知异常");
		}
		
	}
	
	/**
	 * 下载成功后下载次数加一
	 * @param requestBody 软件id
	 * @return ResponseMessage 返回信息
	 */
	@LogInfo(methodName = "下载成功后下载次数加一")
	@RequestMapping("/updateByDownload")
	@ResponseBody
	public ResponseMessage updateByDownload(@RequestBody String requestBody){
		logger.debug(tag+"updateByDownload() begin===>requestBody="+requestBody);
		try{
			JSONObject request = JSONObject.parseObject(requestBody);
	        String id = request.getString("id");
	        int status = DownloadSoftwareService.updateByDownload(id);
	        if(status == 0){
	        	return new ResponseMessage(Code.CODE_ERROR ,"error","修改失败");
	        }
	        return new ResponseMessage(Code.CODE_OK ,"success","修改成功");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(tag+"updateByDownload() end ===>"+e);
			return new ResponseMessage(Code.CODE_ERROR ,"error","未知异常");
		}
		
	}
	
	/**
	 * 查询软件是否已经存在（不同版本不算重复）
	 * @param requestBody
	 * @return
	 */
	@LogInfo(methodName = "查询软件是否已经存在（不同版本不算重复）")
	@RequestMapping("/selectDuplicate")
	@ResponseBody
	public ResponseMessage selectDuplicate(@RequestBody String requestBody){
		logger.debug(tag+"selectDuplicate() begin===>requestBody="+requestBody);
		try{
			JSONObject request = JSONObject.parseObject(requestBody);
	        String softwareName = request.getString("softwareName");
	        String softwareVersion = request.getString("softwareVersion");
	        
	        List<TXietongSoftware> resultList = DownloadSoftwareService.selectDuplicate(softwareName,softwareVersion);
	        if(!CollectionUtils.isEmpty(resultList)){
	        	return new ResponseMessage(Code.CODE_NOAUTH ,"success",resultList.get(0).getId());
	        }else{
	        	return new ResponseMessage(Code.CODE_OK ,"success","软件不存在");
	        }
		}catch(Exception e){
			e.printStackTrace();
			logger.error(tag+"selectDuplicate() end===>"+e);
			return new ResponseMessage(Code.CODE_ERROR ,"error","未知异常");
		}
		
	}
}
