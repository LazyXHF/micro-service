package com.portjs.base.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.Annex;
import com.portjs.base.service.AnnexService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.Upload;
import com.portjs.base.vo.ArrayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author gumingyang
 **/
@Controller
@CrossOrigin
@RequestMapping("/annex")
public class AnnexController extends BaseController{
    static final  String TAG = "AnnexController================>";
    @Resource
    private AnnexService annexService;

    @LogInfo(methodName = "添加附件资源",modelName = "附件模块")
    @RequestMapping("/insert-annex")
    @ResponseBody
    public ResponseMessage insertDesign(String node,String fileModule,String fileType,String fileName, MultipartFile file){
        //node 1:开发2:设计3:试点实施4:立项
        if(StringUtils.isEmpty(node)){
            return  new ResponseMessage(Code.CODE_ERROR , "添加附件资源模块,node未传");
        }
        if(StringUtils.isEmpty(fileType)){
            return  new ResponseMessage(Code.CODE_ERROR , "添加附件资源模块,fileType未传");
        }
        if(StringUtils.isEmpty(fileName)){
            return  new ResponseMessage(Code.CODE_ERROR , "添加附件资源模块,fileName未传");
        }
        Annex annex = new Annex();
        annex.setNode(node);
        annex.setFileModule(fileModule==null?"0":fileModule);
        annex.setFileType(fileType);
        annex.setFileName(fileName);
        return annexService.insertSelective(annex,file);
    }

    @LogInfo(methodName = "根据主键更新附件资源",modelName = "附件模块")
    @RequestMapping("/update-annex")
    @ResponseBody
    public ResponseMessage updateDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Annex annex = JSONObject.toJavaObject(requestJson, Annex.class);
        return annexService.updateByPrimaryKeySelective(annex);
    }

    @LogInfo(methodName = "查询附件资源",modelName = "附件模块")
    @RequestMapping("/select-annex")
    @ResponseBody
    public ResponseMessage selectDesign(@RequestBody String responseBody){
        logger.debug(TAG+responseBody);
        JSONObject requestJson = JSONObject.parseObject(responseBody);
        Annex annex = JSONObject.toJavaObject(requestJson, Annex.class);
        return annexService.selectByPrimaryKey(annex);
    }

    @LogInfo(methodName = "删除附件资源",modelName = "附件模块")
    @RequestMapping("/delete-annex")
    @ResponseBody
    public ResponseMessage deleteDesign(@RequestBody ArrayVO arrayVO){
        logger.debug(TAG+arrayVO);
        return annexService.deleteByPrimaryKey(arrayVO.getList());
    }
    @LogInfo(methodName = "下载附件资源",modelName = "附件模块")
    @RequestMapping("/down-annex")
    @ResponseBody
    public ResponseMessage downDesign(HttpServletRequest request, HttpServletResponse response, String id){
        return annexService.downloadFile(request,response,id);
    }

}
