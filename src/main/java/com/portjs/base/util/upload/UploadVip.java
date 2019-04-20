package com.portjs.base.util.upload;


import com.portjs.base.exception.FileNameLengthLimitExceededException;
import com.portjs.base.util.LogUtil;
import com.portjs.base.util.common.FileConstants;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Calendar;

/**
 * @author  gumingyang
 * @description 上传工具类
 */
@Component
public class UploadVip extends LogUtil{

    @Value("${web.upload-path}")
    private String uploadPath;

    public String uploadFlie(MultipartFile file) {
        try {
            if (StringUtils.isEmpty(file)) {
                throw new Exception("上传文件不能为空");
            }
            String fileName = file.getOriginalFilename();
            if(!isValidFileName(fileName)){
                throw new Exception("上传文件名字不合法");
            }

            int fileNamelength = fileName.length();
            if (fileNamelength > FileConstants.DEFAULT_FILE_NAME_LENGTH){
                throw new FileNameLengthLimitExceededException(file.getOriginalFilename(), fileNamelength,
                        FileConstants.DEFAULT_FILE_NAME_LENGTH);
            }

            long size = file.getSize();
            if (FileConstants.DEFAULT_MAX_SIZE != -1 && size > FileConstants.DEFAULT_MAX_SIZE){
                throw new FileUploadBase.FileSizeLimitExceededException("文件大小不能超过"+FileConstants.DEFAULT_MAX_SIZE+"字节", size, FileConstants.DEFAULT_MAX_SIZE);
            }

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            //服务器上存储的路径
            String filePath1 = uploadPath + File.separator + year + File.separator + month + File.separator;
            //入库的路径
            String filePath2 = File.separator + year + File.separator + month + File.separator;
            //添加时间戳
            fileName = System.currentTimeMillis() + "~" + fileName;
            File fp = new File(filePath1);
            // 创建目录
            if (!fp.exists()) {
                // 目录不存在的情况下，创建目录。
                fp.mkdirs();
            }

            File dest = new File(filePath1 + fileName);
            //判断文件父目录是否存在
            if (!dest.getParentFile().exists()) {
                //没有就创建
                dest.getParentFile().mkdir();
            }
            if (!dest.exists()) {
                dest.createNewFile();
            }
            //写入
            file.transferTo(dest);
            String result = dest.toString();
            return result.substring(result.indexOf(filePath2));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 下载文件
     * @param request
     * @param response
     * @param fileName
     * @throws UnsupportedEncodingException
     */
    public void downloadFile(HttpServletRequest request, HttpServletResponse response,String fileName) throws UnsupportedEncodingException {
        if (fileName != null) {
            //设置文件路径
            File file = new File(uploadPath + fileName);
            if (file.exists()) {
                if ("FF".equals(getBrowser(request))) {
                    // 火狐浏览器 设置编码new String(realName.getBytes("GB2312"), "ISO-8859-1");
                    fileName = new String(fileName.getBytes("GB2312"), "ISO-8859-1");
                }else{
                    fileName = URLEncoder.encode(fileName, "UTF-8");//encode编码UTF-8 解决大多数中文乱码
                    fileName = fileName.replace("+", "%20");//encode后替换空格  解决空格问题
                }
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    private static String getBrowser(HttpServletRequest request) {
        String UserAgent = request.getHeader("USER-AGENT").toLowerCase();
        if (UserAgent != null) {
            if (UserAgent.indexOf("msie") != -1){
                return "IE";
            }

            if (UserAgent.indexOf("firefox") != -1){
                return "FF";
            }

            if (UserAgent.indexOf("safari") != -1){
                return "SF";
            }
        }
        return null;
    }

    public static boolean isValidFileName(String fileName) {
        if (StringUtils.isEmpty(fileName) || fileName.length() > 255) {
            return false;
        } else{
            return fileName.matches("[^\\s\\\\/:\\*\\?\\\"<>\\|](\\x20|[^\\s\\\\/:\\*\\?\\\"<>\\|])*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$");
        }
    }
}
