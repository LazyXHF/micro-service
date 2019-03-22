package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.InternalPactMapper;
import com.portjs.base.dao.InternalProjectMapper;
import com.portjs.base.entity.InternalPact;
import com.portjs.base.service.InternalPactService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Service
public class InternalPactServiceImpl implements InternalPactService {
    ResponseMessage responseMessage = null;
    @Autowired
    InternalPactMapper internalPactMapper;

    @Autowired
    InternalProjectMapper internalProjectMapper;

    private String message = "";
    private Integer code;
    /**
     * 查询所有合同信息
     * @param id  项目id
     * @param pageNo
     * @param pageSize
     * @return（,String name,String signState,String involvedUnit,String tradeNames）
     */
    @Override
    public ResponseMessage queryAllPacts(String id, int pageNo, int pageSize) {
        Page<InternalPact> page = new Page<>();
        int totalCount = internalPactMapper.pactCount();
        page.init(totalCount,pageNo,pageSize);

        List<InternalPact> list = internalPactMapper.queryAllPacts(id, page.getRowNum(), page.getPageCount());
        page.setList(list);
        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功！",page);

        return responseMessage;
    }

    /**
     * 插入合同信息
     * @param requestJson
     * @return
     */
    @Override
    public ResponseMessage insertSelective(JSONArray requestJson) {
        int count =0;
        for (int i =0;i<requestJson.size();i++){
            JSONObject object = requestJson.getJSONObject(i);
            InternalPact annex = JSONObject.toJavaObject(object, InternalPact.class);
            if(StringUtils.isEmpty(annex.getProjectId())){
                return new ResponseMessage(Code.CODE_ERROR , "项目合同,projectId未传");
            }
            //1.软删除库中数据2.插入
            InternalPact coord = new InternalPact();
            coord.setProjectId(annex.getProjectId());
            List<InternalPact> list = internalPactMapper.selectByPrimaryKey(coord);
            if(!CollectionUtils.isEmpty(list)){
                coord.setEnable("1");
                internalPactMapper.updateByPrimaryKeySelective(coord);
            }
        }
        for (int i =0;i<requestJson.size();i++){
            JSONObject object = requestJson.getJSONObject(i);
            InternalPact annex = JSONObject.toJavaObject(object, InternalPact.class);
            //组建bean
            annex.setId(UUID.randomUUID().toString());
            annex.setUploader(UserUtils.getCurrentUser().getId());
            count = internalPactMapper.insertSelective(annex);
        }
        message = count > 0?"保存成功":"保存失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertPact(InternalPact record) {
        int count = 0;
        if(StringUtils.isEmpty(record.getProjectId())){
            return new ResponseMessage(Code.CODE_ERROR , "项目合同,projectId未传");
        }
        //组建bean
        record.setId(UUID.randomUUID().toString());
        record.setUploader(UserUtils.getCurrentUser().getId());
        count = internalPactMapper.insertSelective(record);

        message = count > 0?"插入成功":"插入失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    /**
     * 根据id删除合同信息
     * @param
     * @return
     */
    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> id) {
        int count = 0;
        try {
            count =  internalPactMapper.updateFalseDeletion(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"删除成功":"删除失败";
        code=count>0? Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    /**
     * 根据id查询合同信息
     * @param annex
     * @return
     */
    @Override
    public ResponseMessage selectByPrimaryKey(InternalPact annex) {
        List<InternalPact> design = null;
        try {
            design  =  internalPactMapper.selectByPrimaryKey(annex);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code,message,design);
    }

    /**
     * 根据id修改合同信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKeySelective(InternalPact record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(Code.CODE_ERROR , "更新项目合同模块,id未传");
            }
            record.setUploader(UserUtils.getCurrentUser().getId());
            count =  internalPactMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }
}
