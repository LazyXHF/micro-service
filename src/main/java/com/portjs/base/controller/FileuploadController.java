package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

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
    //上传公共连接
    @LogInfo(modelName = "多文件上传")
    @RequestMapping(value = "/uploadCailiao", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage uploadSuperVision(MultipartFile[] files) {
        logger.debug(TAG + "uploadCailiao()files#################### "+files);
        StringBuffer file_path = new StringBuffer();
        try {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                file_path.append(upload.uploadFlie(file));
                logger.debug(TAG + "uploadCailiao()file_path#################### "+file_path);
                if (file_path.toString().equals("1")) {
                    return new ResponseMessage(Code.CODE_ERROR, "error", "上传失败");
                }
                file_path = file_path.append("^");
                logger.debug(TAG + "uploadCailiao()file_path2#################### "+file_path);
            }
            if (!StringUtils.isEmpty(file_path)) {
                return new ResponseMessage(Code.CODE_OK, "success", file_path);
            }
            return new ResponseMessage(Code.CODE_ERROR, "error", "上传失败");
        } catch (Exception e) {
            logger.debug(TAG + "uploadCailiao()error#################### ", e);
            return new ResponseMessage(Code.CODE_ERROR, "error", "上传失败");
        }
    }

    @LogInfo(methodName = "下载文件",modelName = "下载文件")
    @RequestMapping("/down-file")
    @ResponseBody
    public void downDesign(HttpServletRequest request, HttpServletResponse response, String fileName)throws UnsupportedEncodingException {
        upload.downloadFile(request,response,fileName);
    }
}
