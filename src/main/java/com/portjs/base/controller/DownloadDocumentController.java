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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.TXietongDocModel;
import com.portjs.base.service.DownloadDocumentService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
/**
 * 文档模板管理控制类
 * @author zhangyu
 *
 */
@RestController
@RequestMapping("/downloadDocument")
public class DownloadDocumentController extends BaseController{
	ResponseMessage responseMessage = null;
	static final String tag = "DownloadDocumentController======";

	@Autowired
	private DownloadDocumentService downloadDocumentService;

	/**
	 * 页面展示所有文档模板信息
	 * @return 文档对象的集合
	 */
	@LogInfo(methodName = "页面文档展示")
	@RequestMapping("/selectAllDocument")
	@ResponseBody
	public ResponseMessage selectAllDocument(@RequestBody PageVo pageVo){
		logger.debug(tag+"selectAllDocument()===> begin");
		UnifiedExceptionHandler.method = tag + "findAllDepartment()==================================>" ;
		responseMessage = downloadDocumentService.selectAllDocument(pageVo);
		return responseMessage;

	}

	/**
	 * 新增文档模板
	 * @param requestBody
	 * @return
	 */
	@LogInfo(methodName = "新增文档模板")
	@PostMapping("/insertDocument")
	@ResponseBody
	public ResponseMessage insertDocument(@RequestBody String requestBody){
		logger.debug(tag+"insertDocument() begin===>requestBody="+requestBody);
		try{
			
			JSONObject request = JSONObject.parseObject(requestBody);
			String filePath = request.getString("filePath");//文档路径
			String docName = request.getString("docName");//文档名称
			String docDescription = request.getString("docDescription");//文档说明
			
			ResponseMessage insertDocument = downloadDocumentService.insertDocument(filePath,docName,docDescription);
			return insertDocument;
		}catch(Exception e){
			e.printStackTrace();
			logger.error(tag+"insertDocument() end===>"+e);
			return new ResponseMessage(Code.CODE_ERROR ,"error","未知异常");
		}
		
	}
	
	/**
	 * 删除文档
	 * @param requestBody 软件id
	 * @return ResponseMessage 返回信息
	 */
	@LogInfo(methodName = "删除文档")
	@RequestMapping("/deleteDocument")
	@ResponseBody
	public ResponseMessage deleteDocument(@RequestBody String requestBody){
		logger.debug(tag+"deleteDocument() begin===>requestBody="+requestBody);
		try{
			
			int status =0;
			JSONObject request = JSONObject.parseObject(requestBody);
			JSONArray ids = request.getJSONArray("id");
			
			for (Object id : ids) {
				
				status=downloadDocumentService.deleteDocument(id+"");
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
			logger.error(tag+"deleteDocument() end===>"+e);
			return new ResponseMessage(Code.CODE_ERROR ,"error","未知异常");
		}
	}
	
	/**
	 * 根据模板名 模糊查询
	 * @param requestBody 模糊模板名
	 * @return ResponseMessage 返回信息
	 */
	@LogInfo(methodName = "根据模板名 模糊查询")
	@RequestMapping("/selectByDocumentName")
	@ResponseBody
	public ResponseMessage selectByDocumentName(@RequestBody String requestBody){
		logger.debug(tag+"selectByDocumentName() begin===>requestBody="+requestBody);
		try{
			JSONObject request = JSONObject.parseObject(requestBody);
	        String documentName = request.getString("documentName");
	        List<TXietongDocModel> result = downloadDocumentService.selectByDocumentName(documentName);
	        return new ResponseMessage(Code.CODE_OK ,"success",result);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(tag+"selectByDocumentName() end===>"+e);
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
	        int status = downloadDocumentService.updateByDownload(id);
	        if(status == 0){
	        	return new ResponseMessage(Code.CODE_ERROR ,"error","修改失败");
	        }
	        return new ResponseMessage(Code.CODE_OK ,"success","修改成功");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(tag+"updateByDownload() end===>"+e);
			return new ResponseMessage(Code.CODE_ERROR ,"error","未知异常");
		}
		
	}
	
	/**
	 * 查询软件是否已经存在（不同版本不算重复）
	 * @param requestBody
	 * @return
	 */
	@LogInfo(methodName = "查询软件是否已经存在")
	@RequestMapping("/selectDuplicate")
	@ResponseBody
	public ResponseMessage selectDuplicate(@RequestBody String requestBody){
		
		logger.debug(tag+"selectDuplicate() begin===>requestBody="+requestBody);
		try{
			JSONObject request = JSONObject.parseObject(requestBody);
	        String documentName = request.getString("documentName"); //doc_description
	        String docDescription = request.getString("docDescription");
	        List<TXietongDocModel> resultList = downloadDocumentService.selectDuplicate(documentName,docDescription);
	        if(!CollectionUtils.isEmpty(resultList)){
	        	return new ResponseMessage(Code.CODE_NOAUTH ,"success",resultList.get(0).getId());
	        }else{
	        	return new ResponseMessage(Code.CODE_OK ,"success","文档不存在");
	        }
		}catch(Exception e){
			e.printStackTrace();
			logger.error(tag+"selectDuplicate() end===>"+e);
			return new ResponseMessage(Code.CODE_ERROR ,"error","未知异常");
		}
		
	}
	
	
	
}
