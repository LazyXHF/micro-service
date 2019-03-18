package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.CoordMapper;
import com.portjs.base.entity.Coord;
import com.portjs.base.service.CoordService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author gumingyang
 **/
@Service
@Transactional
public class CoordServiceImpl implements CoordService {
    private String message = "";
    private Integer code;
    @Autowired
    private CoordMapper coordMapper;
    @Autowired
    private Upload upload;
    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> id) {
        int count = 0;
        try {
            count =  coordMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"删除成功":"删除失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insert(Coord record) {
        int count = 0;
        try {
            count =  coordMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(Coord annex) {
        if(StringUtils.isEmpty(annex.getProjectId())){
            return new ResponseMessage(Code.CODE_ERROR , "添加协调事项,projectId未传");
        }
        if(StringUtils.isEmpty(annex.getNodeType())){
            return new ResponseMessage(Code.CODE_ERROR , "添加协调事项,nodeType未传");
        }
        //1.软删除库中数据2.插入
        Coord coord = new Coord();
        coord.setProjectId(annex.getProjectId());
        coord.setNodeType(annex.getNodeType());
        List<Coord> list = coordMapper.selectByPrimaryKey(coord);
        int  count =0;
        if(!CollectionUtils.isEmpty(list)){
            coord.setEnable("1");
            coordMapper.updateByPrimaryKeySelective(coord);
        }

        annex.setId(UUID.randomUUID().toString());
        annex.setUploader(UserUtils.getCurrentUser().getId());
        count =  coordMapper.insertSelective(annex);
        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage selectByPrimaryKey(Coord record) {
        List<Coord> design = null;
        try {
            design  =  coordMapper.selectByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message,design);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(Coord record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新协调事项,id未传");
            }
            record.setModifer(UserUtils.getCurrentUser().getId());
            count =  coordMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKeyWithBLOBs(Coord record) {
        int count = 0;
        try {
            count =  coordMapper.updateByPrimaryKeyWithBLOBs(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKey(Coord record) {
        int count = 0;
        try {
            count = coordMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0 ? "更新成功" : "更新失败";
        code = count > 0 ? Code.CODE_OK : Code.CODE_ERROR;

        return new ResponseMessage(code, message);
    }

    @Override
    public ResponseMessage downloadFile(HttpServletRequest request, HttpServletResponse response, String id) {
        Coord annex = new Coord();
        annex.setId(id);
        try {
            List<Coord> list =coordMapper.selectByPrimaryKey(annex);
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
