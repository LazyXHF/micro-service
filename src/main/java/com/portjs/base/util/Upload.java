package com.portjs.base.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by dengshuangzhen on 2018\11\29 0029
 */
@Component
public class Upload extends LogUtil{
    static final String tag = "Upload===>";
    @Value("${web.upload-path}")
    private String path1;

    public String uploadFlie(MultipartFile file) {
        if (StringUtils.isEmpty(file)) {
            return "1";
        }
        try {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            ApplicationHome home = new ApplicationHome(this.getClass());
            File jarFile = home.getSource();
            File file1 = new File("");
            String filePath1 = path1 + file1.separator + year + file1.separator + month + file1.separator;//服务器上存储的路径
//            String filePath1 = jarFile.getParentFile().toString()+file1.separator+year+file1.separator+month+file1.separator;//服务器上存储的路径
            String filePath2 = file1.separator + year + file1.separator + month + file1.separator;//入库的路径
           /* String filePath1 = jarFile.getParentFile().toString()+"\\files\\"+year+"\\"+month+"\\";
            String filePath2 = "\\files\\"+year+"\\"+month+"\\";//入库的路径*/
            String fileName = file.getOriginalFilename();
            fileName = System.currentTimeMillis() + "~" + fileName;//添加时间戳
            File fp = new File(filePath1);
            // 创建目录
            if (!fp.exists()) {
                fp.mkdirs();// 目录不存在的情况下，创建目录。
            }

            File dest = new File(filePath1 + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();   //没有就创建
            }
            if (!dest.exists()) {
                dest.createNewFile();
            }

            file.transferTo(dest);
            String result = dest.toString();
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println(result.substring(result.indexOf(filePath2)));
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            return result.substring(result.indexOf(filePath2));
            //return dest.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            logger.debug(tag + "Upload()error#################### ", e);
        }
        return "1";
    }
}
