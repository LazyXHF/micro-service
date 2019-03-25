package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.AcceptanceMapper;
import com.portjs.base.dao.AnnexMapper;
import com.portjs.base.dao.CoordMapper;
import com.portjs.base.entity.Acceptance;
import com.portjs.base.entity.Annex;
import com.portjs.base.entity.Coord;
import com.portjs.base.service.AcceptanceService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.Convert;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author gumingyang
 **/
@Service
@Transactional
public class AcceptanceServiceImpl implements AcceptanceService {
    private String message = "";
    private Integer code;
    @Autowired
    private AcceptanceMapper acceptanceMapper;
    @Autowired
    private CoordMapper coordMapper;
    @Autowired
    private AnnexMapper annexMapper;

    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> id) {
        int count = 0;
        try {
            count =  acceptanceMapper.updateFalseDeletion(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"删除成功":"删除失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insert(Acceptance record) {
        int count = 0;
        try {
            count =  acceptanceMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"保存成功":"保存失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(JSONObject requestJson) {
        int count =0;
        try {
            JSONObject constructionJson = requestJson.getJSONObject("Acceptance");
            Acceptance construction = JSONObject.toJavaObject(constructionJson, Acceptance.class);
            if (StringUtils.isEmpty(construction.getProjectId())) {
                return new ResponseMessage(Code.CODE_ERROR, "添加项目验收模块,projectId未传");
            }
            Acceptance approval = new Acceptance();
            approval.setProjectId(construction.getProjectId());
            List<Acceptance> approvals = acceptanceMapper.selectByPrimaryKey(approval);
            if (!CollectionUtils.isEmpty(approvals)) {
                approval.setEnable("1");
                acceptanceMapper.updateByPrimaryKeySelective(approval);
            }

            construction.setId(UUID.randomUUID().toString());
            construction.setCreater(UserUtils.getCurrentUser().getId());
             count = acceptanceMapper.insertSelective(construction);
            if (count == 0) {
                throw new Exception();
            }

            //保存附件
            JSONArray data = requestJson.getJSONArray("Annexs");
            for (int i = 0; i < data.size(); i++) {
                JSONObject object = data.getJSONObject(i);
                Annex annex = JSONObject.toJavaObject(object, Annex.class);
                if (StringUtils.isEmpty(annex.getBackUp1())) {
                    return new ResponseMessage(Code.CODE_ERROR, "上传附件,backUp1未传");
                }
                if (StringUtils.isEmpty(annex.getNode())) {
                    return new ResponseMessage(Code.CODE_ERROR, "上传附件,node未传");
                }
                if (StringUtils.isEmpty(annex.getFileModule())) {
                    return new ResponseMessage(Code.CODE_ERROR, "上传附件,fileModule未传");
                }
                //1.软删除库中数据2.插入
                Annex coord = new Annex();
                coord.setBackUp1(annex.getBackUp1());
                coord.setNode(annex.getNode());
                coord.setFileModule(annex.getFileModule());
                List<Annex> list = annexMapper.selectByPrimaryKey(coord);
                if (!CollectionUtils.isEmpty(list)) {
                    coord.setEnable("1");
                    annexMapper.updateByPrimaryKeySelective(coord);
                }
            }
            for (int i = 0; i < data.size(); i++) {
                JSONObject object = data.getJSONObject(i);
                Annex annex = JSONObject.toJavaObject(object, Annex.class);
                //组建bean
                annex.setId(UUID.randomUUID().toString());
                annex.setUploader(UserUtils.getCurrentUser().getId());
                count = annexMapper.insertSelective(annex);
                if(count==0){
                    throw new Exception();
                }
            }
            //保存协调事项
            JSONObject coord = requestJson.getJSONObject("Coord");
            Coord annex = JSONObject.toJavaObject(coord, Coord.class);
            if (StringUtils.isEmpty(annex.getProjectId())) {
                return new ResponseMessage(Code.CODE_ERROR, "添加协调事项,projectId未传");
            }
            if (StringUtils.isEmpty(annex.getNodeType())) {
                return new ResponseMessage(Code.CODE_ERROR, "添加协调事项,nodeType未传");
            }
            //1.软删除库中数据2.插入
            Coord coo = new Coord();
            coo.setProjectId(annex.getProjectId());
            coo.setNodeType(annex.getNodeType());
            List<Coord> list = coordMapper.selectByPrimaryKey(coo);
            if (!CollectionUtils.isEmpty(list)) {
                coo.setEnable("1");
                coordMapper.updateByPrimaryKeySelective(coo);
            }
            annex.setId(UUID.randomUUID().toString());
            annex.setUploader(UserUtils.getCurrentUser().getId());
            count = coordMapper.insertSelective(annex);
            if (count == 0) {
                throw new Exception();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        message = count > 0?"保存成功":"保存失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage selectByPrimaryKey(Acceptance record) {
        List<Acceptance> design = null;
        try {
            design  =  acceptanceMapper.selectByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message,design);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(Acceptance record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新项目验收模块,id未传");
            }
            record.setUpdater(UserUtils.getCurrentUser().getId());
            count =  acceptanceMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKey(Acceptance record) {
        int count = 0;
        try {
            count =  acceptanceMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }
}
