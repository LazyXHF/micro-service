package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
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

        message = count > 0?"保存成功":"保存失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(JSONArray data) {
        int count =0;
        for (int i =0;i<data.size();i++){
           JSONObject object = data.getJSONObject(i);
            Annex annex = JSONObject.toJavaObject(object, Annex.class);
            if(StringUtils.isEmpty(annex.getBackUp1())){
                return new ResponseMessage(Code.CODE_ERROR , "上传附件,backUp1未传");
            }
            if(StringUtils.isEmpty(annex.getFileUrl())){
                return new ResponseMessage(Code.CODE_ERROR , "上传附件,fileUrl未传");
            }
            if(StringUtils.isEmpty(annex.getNode())){
                return new ResponseMessage(Code.CODE_ERROR , "上传附件,node未传");
            }
            if(StringUtils.isEmpty(annex.getFileModule())){
                return new ResponseMessage(Code.CODE_ERROR , "上传附件,fileModule未传");
            }
            //1.软删除库中数据2.插入
            Annex coord = new Annex();
            coord.setBackUp1(annex.getBackUp1());
            coord.setNode(annex.getNode());
            coord.setFileModule(annex.getFileModule());
            List<Annex> list = annexMapper.selectByPrimaryKey(coord);
            if(!CollectionUtils.isEmpty(list)){
                coord.setEnable("1");
                annexMapper.updateByPrimaryKeySelective(coord);
            }
        }
        for (int i =0;i<data.size();i++){
            JSONObject object = data.getJSONObject(i);
            Annex annex = JSONObject.toJavaObject(object, Annex.class);
            //组建bean
            annex.setId(UUID.randomUUID().toString());
            annex.setUploader(UserUtils.getCurrentUser().getId());
            count = annexMapper.insertSelective(annex);
        }
        message = count > 0?"保存成功":"保存失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage selectByPrimaryKey( Annex annex) {
        List<Annex> design = null;
        if(StringUtils.isEmpty(annex.getBackUp1())){
            return new ResponseMessage(Code.CODE_ERROR , "上传附件,backUp1未传");
        }
        Annex a = new Annex();
        a.setBackUp1(annex.getBackUp1());
        if(!StringUtils.isEmpty(annex.getNode())){
            a.setNode(annex.getNode());
        }
        try {
            design  =  annexMapper.selectByPrimaryKey(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message,design);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(JSONArray requestJson) {
        int count = 0;
        for (int i =0;i<requestJson.size();i++){
            JSONObject object = requestJson.getJSONObject(i);
            Annex annex = JSONObject.toJavaObject(object, Annex.class);
            if(StringUtils.isEmpty(annex.getBackUp1())){
                return new ResponseMessage(Code.CODE_ERROR , "上传附件,backUp1未传");
            }
            if(StringUtils.isEmpty(annex.getFileUrl())){
                return new ResponseMessage(Code.CODE_ERROR , "上传附件,fileUrl未传");
            }
            if(StringUtils.isEmpty(annex.getNode())){
                return new ResponseMessage(Code.CODE_ERROR , "上传附件,node未传");
            }
            if(StringUtils.isEmpty(annex.getId())){
                //组建bean
                annex.setId(UUID.randomUUID().toString());
                annex.setUploader(UserUtils.getCurrentUser().getId());
                count = annexMapper.insertSelective(annex);
            }else{
                annex.setUploader(UserUtils.getCurrentUser().getId());
                count =  annexMapper.updateByPrimaryKeySelective(annex);
            }
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
