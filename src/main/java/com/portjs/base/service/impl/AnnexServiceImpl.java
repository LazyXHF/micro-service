package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.AnnexMapper;
import com.portjs.base.entity.Annex;
import com.portjs.base.service.AnnexService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.Upload;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * @author gumingyang
 **/
@Service
@Transactional
public class AnnexServiceImpl implements AnnexService {
    private String message = "";
    private Integer code;
    @Autowired
    private AnnexMapper annexMapper;
    @Autowired
    private Upload upload;
    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> ids) {
        int count = 0;
        try {
            count =  annexMapper.deleteByPrimaryKey(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"删除成功":"删除失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insert(Annex record) {
        int count = 0;
        try {
            count =  annexMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(Annex record,MultipartFile file) {
        int count = 0;
        String url = upload.uploadFlie(file);
        if("1".equals(url)){
            return new ResponseMessage(Code.CODE_ERROR ,"添加附件资源模块,文件上传失败");
        }
        //组建bean
        record.setId(UUID.randomUUID().toString());
        record.setFileUrl(url);
        record.setUploader(UserUtils.getCurrentUser().getId());
        try {
            count =  annexMapper.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage selectByPrimaryKey( Annex annex) {
        List<Annex> design = null;
        try {
            design  =  annexMapper.selectByPrimaryKey(annex);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message,design);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(Annex record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新附件资源模块,id未传");
            }
            record.setUploader(UserUtils.getCurrentUser().getId());
            count =  annexMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKey(Annex record) {
        int count = 0;
        try {
            count =  annexMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage downloadFile(HttpServletRequest request, HttpServletResponse response, String id) {
        Annex annex = new Annex();
        annex.setId(id);
        try {
            List<Annex> list =annexMapper.selectByPrimaryKey(annex);
            if(!CollectionUtils.isEmpty(list)){
                String fileName = list.get(0).getFileUrl();
                upload.downloadFile(request,response,fileName);
                return new ResponseMessage(Code.CODE_OK,"下载成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseMessage(Code.CODE_ERROR,"下载失败");
    }
}
