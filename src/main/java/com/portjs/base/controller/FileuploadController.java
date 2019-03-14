package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author gumingyang
 **/
@Controller
@CrossOrigin
@RequestMapping("/uploadFile")
public class FileuploadController extends BaseController {
    static final  String TAG = "FileuploadController================>";
    @Autowired
    private Upload upload;

    @LogInfo(methodName = "上传文件",modelName = "上传文件")
    @RequestMapping("/insert-file")
    @ResponseBody
    public ResponseMessage insertDesign(@RequestBody MultipartFile file){
        logger.debug(TAG+file);

       String url = upload.uploadFlie(file);
        if("1".equals(url)){
         return  new ResponseMessage(Code.CODE_ERROR,"上传失败");
        }
        return new ResponseMessage(Code.CODE_OK , "上传成功",url);
    }
}
