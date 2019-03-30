package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.TXietongDictionaryMapper;
import com.portjs.base.entity.TXietongDictionary;
import com.portjs.base.entity.TXietongDictionaryExample;
import com.portjs.base.service.UnifiedConfigurationService;
import com.portjs.base.util.Code;
import com.portjs.base.util.IDUtils;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by dengshuangzhen on 2019\3\14 0014
 */

@Service
@Transactional
public class UnifiedConfigurationServiceImpl implements UnifiedConfigurationService {
    @Autowired
    private TXietongDictionaryMapper dictionaryMapper;

    /**
     *统一模块新增项目等级
     * @param requestBody
     * @return
     */
    /*@Override
    public ResponseMessage insertProjectLevel(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String name = jsonObject.getString("name");//项目等级名称
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("99");
        List<TXietongDictionary> list = dictionaryMapper.selectByExample(example);
        if(list!=null){
            for (TXietongDictionary dictionary : list) {
                if(dictionary.getMainValue().equals(name)){
                    return new ResponseMessage(Code.CODE_ERROR, "项目等级不可重复");
                }
            }
        }
        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setId(UUID.randomUUID().toString());
        dictionary.setTypeCode("99");
        dictionary.setTypeDesc("项目等级");
        dictionary.setMainValue(name);
        dictionary.setMidValue(UUID.randomUUID().toString());
        int i = dictionaryMapper.insertSelective(dictionary);
        if(i!=1){
            return new ResponseMessage(Code.CODE_ERROR, "新增失败");
        }
        return new ResponseMessage(Code.CODE_OK, "新增成功");
    }*/

    /**
     *统一模块查询项目等级
     * @return
     */
    @Override
    public ResponseMessage selectProjectLevel() {
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("99");
        List<TXietongDictionary> list = dictionaryMapper.selectByExample(example);
        if(list==null){
            return new ResponseMessage(Code.CODE_ERROR, "暂无数据");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功",list);
    }

    /**
     *统一模块配置设置项目等级
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage updateProjectLevel(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String name = jsonObject.getString("name");//项目等级名称
        String id  = jsonObject.getString("id");//项目等级id
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("99");
        List<TXietongDictionary> list = dictionaryMapper.selectByExample(example);
        if(list!=null){
            for (TXietongDictionary dictionary : list) {
                if(dictionary.getMainValue().equals(name)){
                    return new ResponseMessage(Code.CODE_ERROR, "项目等级不可重复");
                }
            }
        }
        if(StringUtils.isEmpty(id)){
            TXietongDictionary dictionary = new TXietongDictionary();
            dictionary.setId(String.valueOf(IDUtils.genItemId()));
            dictionary.setTypeCode("99");
            dictionary.setTypeDesc("项目等级");
            dictionary.setMainValue(name);
            dictionary.setMidValue(UUID.randomUUID().toString());
            int i = dictionaryMapper.insertSelective(dictionary);
            if(i!=1){
                return new ResponseMessage(Code.CODE_ERROR, "新增失败");
            }
            return new ResponseMessage(Code.CODE_OK, "新增成功");
        } else {
            TXietongDictionary dictionary = new TXietongDictionary();
            dictionary.setId(id);
            dictionary.setMainValue(name);
            int update = dictionaryMapper.updateByPrimaryKeySelective(dictionary);
            if (update != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "修改失败");
            }
            return new ResponseMessage(Code.CODE_OK, "修改成功");
            }
    }

    /**
     *统一模块删除项目等级
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage deleteProjectLevel(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String id = jsonObject.getString("id");//项目等级id
        int i = dictionaryMapper.deleteByPrimaryKey(id);
        if(i!=1){
            return new ResponseMessage(Code.CODE_ERROR, "删除失败");
        }
        return new ResponseMessage(Code.CODE_OK, "删除成功");
    }



    /**
     *统一模块新增项目类型
     * @param requestBody
     * @return
     */
    /*@Override
    public ResponseMessage insertProjectType(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String name = jsonObject.getString("name");//项目类型名称
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("100");
        List<TXietongDictionary> list = dictionaryMapper.selectByExample(example);
        if(list!=null){
            for (TXietongDictionary dictionary : list) {
                if(dictionary.getMainValue().equals(name)){
                    return new ResponseMessage(Code.CODE_ERROR, "项目类型不可重复");
                }
            }
        }
        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setId(UUID.randomUUID().toString());
        dictionary.setTypeCode("100");
        dictionary.setTypeDesc("项目类型");
        dictionary.setMainValue(name);
        dictionary.setMidValue(UUID.randomUUID().toString());
        int i = dictionaryMapper.insertSelective(dictionary);
        if(i!=1){
            return new ResponseMessage(Code.CODE_ERROR, "新增失败");
        }
        return new ResponseMessage(Code.CODE_OK, "新增成功");
    }*/

    /**
     *统一模块查询项目类型
     * @return
     */
    @Override
    public ResponseMessage selectProjectType() {
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        example.setOrderByClause("midValue desc");
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("100");
        List<TXietongDictionary> list = dictionaryMapper.selectByExample(example);
        if(list==null){
            return new ResponseMessage(Code.CODE_ERROR, "暂无数据");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功",list);
    }

    /**
     *统一模块设置项目类型
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage updateProjectType(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String name = jsonObject.getString("name");//项目名称名称
        String id  = jsonObject.getString("id");//项目名称id
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("100");
        List<TXietongDictionary> list = dictionaryMapper.selectByExample(example);
        if(list!=null){
            for (TXietongDictionary dictionary : list) {
                if(dictionary.getMainValue().equals(name)){
                    return new ResponseMessage(Code.CODE_ERROR, "项目类型不可重复");
                }
            }
        }
        if(StringUtils.isEmpty(id)){
            TXietongDictionary dictionary = new TXietongDictionary();
            dictionary.setId(String.valueOf(IDUtils.genItemId()));
            dictionary.setTypeCode("100");
            dictionary.setTypeDesc("项目类型");
            dictionary.setMainValue(name);
            dictionary.setMidValue(UUID.randomUUID().toString());
            int i = dictionaryMapper.insertSelective(dictionary);
            if(i!=1){
                return new ResponseMessage(Code.CODE_ERROR, "新增失败");
            }
            return new ResponseMessage(Code.CODE_OK, "新增成功");
        } else {
            TXietongDictionary dictionary = new TXietongDictionary();
            dictionary.setId(id);
            dictionary.setMainValue(name);
            int update = dictionaryMapper.updateByPrimaryKeySelective(dictionary);
            if (update != 1) {
              return new ResponseMessage(Code.CODE_ERROR, "修改失败");
            }
            return new ResponseMessage(Code.CODE_OK, "修改成功");
        }
    }

    /**
     *统一模块删除项目类型
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage deleteProjectType(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String id = jsonObject.getString("id");//项目类型id
        int delete = dictionaryMapper.deleteByPrimaryKey(id);
        if(delete!=1){
            return new ResponseMessage(Code.CODE_ERROR, "删除失败");
        }
        return new ResponseMessage(Code.CODE_OK, "删除成功");
    }

}
