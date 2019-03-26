package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.AnnexMapper;
import com.portjs.base.dao.CoordMapper;
import com.portjs.base.dao.DesignMapper;
import com.portjs.base.entity.Annex;
import com.portjs.base.entity.Coord;
import com.portjs.base.entity.Design;
import com.portjs.base.service.DesignService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
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
@Transactional(rollbackFor = Exception.class)
public class DesignServiceImpl  implements DesignService{
    private String message = "";
    private Integer code;
    @Autowired
    private DesignMapper designMapper;
    @Autowired
    private CoordMapper coordMapper;
    @Autowired
    private AnnexMapper annexMapper;

    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> id) {
        int count = 0;
        try {
           count =  designMapper.updateDesign(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"删除成功":"删除失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insert(Design record) {
        int count = 0;
        try {
            count =  designMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"保存成功":"保存失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage insertSelective(JSONObject requestJson) {
        int  count =0;
        try {
            //保存项目设计
            JSONObject designJson = requestJson.getJSONObject("Design");
            Design construction = JSONObject.toJavaObject(designJson, Design.class);
            //组装bean
            if (StringUtils.isEmpty(construction.getProjectId())) {
                return new ResponseMessage(Code.CODE_ERROR, "添加项目开发模块,projectId未传");
            }
            Design approval = new Design();
            approval.setProjectId(construction.getProjectId());
            List<Design> approvals = designMapper.selectByPrimaryKey(approval);
            if (!CollectionUtils.isEmpty(approvals)) {
                approval.setEnable("1");
                designMapper.updateByPrimaryKeySelective(approval);
            }
            if (StringUtils.isEmpty(construction.getUnit())) {
                return new ResponseMessage(Code.CODE_ERROR, "添加项目开发模块,unit未传");
            }
            if (StringUtils.isEmpty(construction.getPlanStartTime().toString())) {
                return new ResponseMessage(Code.CODE_ERROR, "添加项目开发模块,planStartTime未传");
            }
            if (StringUtils.isEmpty(construction.getPlanEndTime().toString())) {
                return new ResponseMessage(Code.CODE_ERROR, "添加项目开发模块,planEndTime未传");
            }
            construction.setId(UUID.randomUUID().toString());
            construction.setCreater(UserUtils.getCurrentUser().getId());
            count =  designMapper.insertSelective(construction);
            if (count == 0) {
                throw new Exception();
            }

            //保存附件
            JSONObject datas = requestJson.getJSONObject("Annexs");
            JSONArray data1 = datas.getJSONArray("table1");//附件一
            JSONArray data2 = datas.getJSONArray("table2");//附件二
            JSONArray data3 = datas.getJSONArray("table3");//附件三
            JSONArray data4 = datas.getJSONArray("table4");//附件四
            JSONArray data5 = datas.getJSONArray("table5");//附件五
            insertAnnex(data1);
            insertAnnex(data2);
            insertAnnex(data3);
            insertAnnex(data4);
            insertAnnex(data5);

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
    public ResponseMessage selectByPrimaryKey(Design record) {
       List<Design> design = null;
        try {
            design  =  designMapper.selectByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = design != null?"查询成功":"查询失败";
        code = design != null?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message,design);
    }

    @Override
    public ResponseMessage updateByPrimaryKeySelective(Design record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新项目设计模块,id未传");
            }
            record.setUpdater(UserUtils.getCurrentUser().getId());
            count =  designMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);
    }

    @Override
    public ResponseMessage updateByPrimaryKey(Design record) {
        int count = 0;
        try {
            count =  designMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;

        return new ResponseMessage(code , message);
    }

    /**
     * 保存附件
     * @param data
     * @throws Exception
     */
    public void insertAnnex(JSONArray data) throws Exception{
        int count =0;
        for (int i = 0; i < data.size(); i++) {
            JSONObject object = data.getJSONObject(i);
            Annex annex = JSONObject.toJavaObject(object, Annex.class);
            if (StringUtils.isEmpty(annex.getBackUp1())) {
                throw new Exception();
            }
            if (StringUtils.isEmpty(annex.getNode())) {
                throw new Exception();
            }
            if (StringUtils.isEmpty(annex.getFileModule())) {
                throw new Exception();
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
    }
}
