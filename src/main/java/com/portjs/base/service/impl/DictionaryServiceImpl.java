package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.TXietongDictionaryMapper;
import com.portjs.base.dao.TUserMapper;
import com.portjs.base.entity.*;
import com.portjs.base.entity.TXietongDictionaryExample.Criteria;
import com.portjs.base.service.DictionaryService;
import com.portjs.base.util.Code;
import com.portjs.base.util.LogUtil;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.TemplateModelDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;







import java.util.*;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, timeout = -1)
public class DictionaryServiceImpl extends LogUtil implements DictionaryService {
    static final String tag = "DictionaryServiceImpl===>";

    private ResponseMessage responseMessage;
    @Autowired
    private TXietongDictionaryMapper dictionaryMapper;
    @Autowired
    private TUserMapper userMapper;

    @Override
    public List<TXietongDictionary> selectTpyeXiala() {
        return dictionaryMapper.selectTpyeXiala();
    }

    @Override
    public ResponseMessage insertDictionaryType(String request) {
        JSONObject msg = JSONObject.parseObject(request);
        String typeId = msg.getString("typeId");
        String typeCode = msg.getString("typeCode");
        String typeDesc = msg.getString("typeDesc");

        TXietongDictionaryExample example1 = new TXietongDictionaryExample();
        Criteria criteria1 = example1.createCriteria();
        criteria1.andTypeCodeEqualTo(typeCode);
        int j = dictionaryMapper.countByExample(example1);
        if (j != 0) {
            return new ResponseMessage(Code.CODE_ERROR, "error", "typeCode已存在");
        }
        TXietongDictionaryExample example2 = new TXietongDictionaryExample();
        Criteria criteria2 = example2.createCriteria();
        criteria2.andTypeCodeEqualTo(typeDesc);
        int a = dictionaryMapper.countByExample(example2);
        if (a != 0) {
            return new ResponseMessage(Code.CODE_ERROR, "error", "typeDesc已存在");
        }
        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setId(UUID.randomUUID().toString());
        dictionary.setTypeDesc(typeDesc);
        dictionary.setTypeCode(typeCode);
        dictionary.setTypeId(typeId);
        int i = dictionaryMapper.insertSelective(dictionary);
        if (i != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "error", "新增失败");
        }

        return new ResponseMessage(Code.CODE_OK, "success", "新增成功");
    }

    @Override
    public ResponseMessage selectDictionaryType() {
        List<TXietongDictionary> list = dictionaryMapper.selectDictionaryType();
        if (list.size() > 0) {
            return new ResponseMessage(Code.CODE_OK, "success", list);
        }
        return new ResponseMessage(Code.CODE_ERROR, "error", "查询失败");

    }

    @Override
    public ResponseMessage insertDictionary(String request) {
        JSONObject msg = JSONObject.parseObject(request);
        String mainValue = msg.getString("mainValue");
        String typeCode = msg.getString("typeCode");
        String typeDesc = msg.getString("typeDesc");
        String typeId = msg.getString("typeId");
        String subValue = msg.getString("subValue");
        String valueSort = msg.getString("valueSort");
        String valueDesc = msg.getString("valueDesc");
        String midValue = msg.getString("midValue");
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andMainValueEqualTo(mainValue);
        criteria.andTypeCodeEqualTo(typeCode);
        List<TXietongDictionary> list = dictionaryMapper.selectByExample(example);
        if (list.size() != 0) {
            return new ResponseMessage(Code.CODE_ERROR, "error", "当前名称已存在");
        }

        TXietongDictionaryExample example2 = new TXietongDictionaryExample();
        Criteria criteria2 = example2.createCriteria();
        criteria2.andMidValueEqualTo(midValue);
        criteria2.andTypeCodeEqualTo(typeCode);
        List<TXietongDictionary> list1 = dictionaryMapper.selectByExample(example2);
        if (list1.size() != 0) {
            return new ResponseMessage(Code.CODE_ERROR, "error", "当前字段Code已存在");
        }

        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setId(UUID.randomUUID().toString());
        dictionary.setTypeDesc(typeDesc);
        dictionary.setTypeCode(typeCode);
        dictionary.setTypeId(typeId);
        dictionary.setSubValue(subValue);
        dictionary.setValueSort(valueSort);
        dictionary.setValueDesc(valueDesc);
        dictionary.setMainValue(mainValue);
        dictionary.setMidValue(midValue);
        int i = dictionaryMapper.insertSelective(dictionary);
        if (i != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "error", "新增失败");
        }
        return new ResponseMessage(Code.CODE_OK, "success", "新增成功");

    }

    @Override
    public ResponseMessage selectAll(String request) {
        JSONObject msg = JSONObject.parseObject(request);
        String code = msg.getString("code");
        String pageNum = msg.getString("pageNum");
        String pageCount = msg.getString("pageCount");
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        Criteria criteria = example.createCriteria();
        if (!code.isEmpty()) {
            criteria.andTypeCodeEqualTo(code);
        }
        int totelCount = dictionaryMapper.countByExample(example);
        Page page = new Page();
        page.init(totelCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
        List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByPage(code, page.getRowNum(), page.getPageCount());
        if (dictionaryList.size() == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "error", "查询失败");
        }
        page.setList(dictionaryList);
        return new ResponseMessage(Code.CODE_OK, "success", page);

    }

    @Override
    public ResponseMessage deleteDictionary(String request) {
        JSONObject msg = JSONObject.parseObject(request);
        String id = msg.getString("id");
        int i = dictionaryMapper.deleteByPrimaryKey(id);
        if (i != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "error", "删除失败");
        }
        return new ResponseMessage(Code.CODE_OK, "success", "删除成功");
    }

    @Override
    public ResponseMessage updateDictionary(String request) {
        JSONObject msg = JSONObject.parseObject(request);
        String id = msg.getString("id");
        String mainValue = msg.getString("mainValue");
        String midValue = msg.getString("midValue");
        String subValue = msg.getString("subValue");
        String valueSort = msg.getString("valueSort");
        String valueDesc = msg.getString("valueDesc");
        String typeCode = msg.getString("typeCode");
        String remark = msg.getString("remark");
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andMainValueEqualTo(mainValue);
        criteria.andTypeCodeEqualTo(typeCode);
        List<TXietongDictionary> list = dictionaryMapper.selectByExample(example);
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                TXietongDictionary dictionary = list.get(i);
                if (!dictionary.getId().equals(id)) {
                    return new ResponseMessage(Code.CODE_ERROR, "error", "当前名称已存在");
                }
            }
        }
        TXietongDictionaryExample example2 = new TXietongDictionaryExample();
        Criteria criteria2 = example2.createCriteria();
        criteria2.andMainValueEqualTo(midValue);
        criteria2.andTypeCodeEqualTo(typeCode);
        List<TXietongDictionary> list2 = dictionaryMapper.selectByExample(example);
        if (list2.size() != 0) {
            for (int i = 0; i < list2.size(); i++) {
                TXietongDictionary dictionary = list2.get(i);
                if (!dictionary.getId().equals(id)) {
                    return new ResponseMessage(Code.CODE_ERROR, "error", "当前midValue已存在");
                }
            }
        }

        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setMainValue(mainValue);
        dictionary.setSubValue(subValue);
        dictionary.setValueSort(valueSort);
        dictionary.setMidValue(midValue);
        dictionary.setValueDesc(valueDesc);
        dictionary.setTypeCode(typeCode);
        dictionary.setRemark(remark);
        TXietongDictionaryExample example1 = new TXietongDictionaryExample();
        Criteria criteria1 = example1.createCriteria();
        criteria1.andIdEqualTo(id);
        int update = dictionaryMapper.updateByExampleSelective(dictionary, example1);
        if (update != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "error", "更新失败");
        }
        return new ResponseMessage(Code.CODE_OK, "success", "更新成功");
    }

    @Override
    public List<TXietongDictionary> selectJinjiXiala() {
        return dictionaryMapper.selectJinjiXiala();
    }

    // 字典表通用类
    @Override
    public List<TXietongDictionary> selectDictionary(String code) {

        TXietongDictionaryExample example = new TXietongDictionaryExample();
        example.setOrderByClause("(VALUE_SORT+0)");
        Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo(code);

        return dictionaryMapper.selectByExample(example);
    }

    // 督办员查询
    @Override
    public TXietongDictionary selectDubanyuan() {
        TXietongDictionary dictionary = dictionaryMapper.selectDubanyuan();
        if (dictionary != null) {
            return dictionary;
        }
        return null;
    }

    @Override
    public int updateDubanyuan(String requestBody) {
        logger.debug("updateDubanyuan() begin===>");
        try {
            JSONObject msg = JSONObject.parseObject(requestBody);
            String mainValue = msg.getString("mainValue");
            String midValue = msg.getString("midValue");
            TXietongDictionary dubanyuan = dictionaryMapper.selectDubanyuan();
            if (dubanyuan == null) {
                TXietongDictionary dictionary = new TXietongDictionary();
                dictionary.setId(String.valueOf(UUID.randomUUID()));
                dictionary.setMainValue(mainValue);
                dictionary.setMidValue(midValue);
                int i = dictionaryMapper.insertDubanyuan(dictionary);
                if (i > 0) {
                    return i;
                }
            } else {
                if (midValue == null || midValue.equals("")) {
                    int i = dictionaryMapper.deletedubanyuan();
                    if (i > 0) {
                        return i;
                    }
                } else {
                    int i = dictionaryMapper.updateDubanyuan(mainValue, midValue);
                    if (i > 0) {
                        return i;
                    }
                }
            }
        } catch (Exception e) {
            logger.error(tag + "updateDubanyuan() end===>" + e);
        }
        return 0;
    }

    @Override
    public ResponseMessage insertDuban(String requestBody) {
        logger.debug("insertDuban() begin===>");
        try {
            JSONObject msg = JSONObject.parseObject(requestBody);
            String mainValue = msg.getString("mainValue");
            String midValue = msg.getString("midValue");
            String subValue = msg.getString("subValue");
            String valueSort = msg.getString("valueSort");
            String remark = msg.getString("remark");
            List<TXietongDictionary> dictionaries = dictionaryMapper.selectTpyeXiala();
            for (TXietongDictionary dictionary : dictionaries) {
                if (mainValue.equals(dictionary.getMainValue())){
                    return new ResponseMessage(Code.CODE_ERROR, "当前督办类型已存在", "当前督办类型已存在");
                }
            }
            TXietongDictionary dictionary = new TXietongDictionary();
            dictionary.setId(String.valueOf(UUID.randomUUID()));
            dictionary.setMainValue(mainValue);
            dictionary.setMidValue(midValue);
            dictionary.setSubValue(subValue);
            dictionary.setValueSort(valueSort);
            dictionary.setRemark(remark);
            int i = dictionaryMapper.insertDuban(dictionary);
            if (i > 0) {
                return new ResponseMessage(Code.CODE_OK, "添加成功", "添加成功");
            }
        } catch (Exception e) {
            logger.error(tag + "insertDuban() end===>" + e);
        }
        return new ResponseMessage(Code.CODE_ERROR, "添加失败", "添加失败");
    }

    // 插入机要员信息
    @Override
    public int insertJiyaoyuan(String requestBody) {
        JSONObject msg = JSONObject.parseObject(requestBody);
        JSONArray ReceivingNameArray = JSONArray.parseArray(msg.getString("ReceivingName"));
        JSONArray ReceivingIdArray = JSONArray.parseArray(msg.getString("ReceivingId"));
        if (ReceivingNameArray.size() <= 0 && ReceivingIdArray.size() <= 0) {
            int d = dictionaryMapper.deleteJiyaoMsg();
            return 1;
        } else {
            dictionaryMapper.deleteJiyaoMsg();
            if (ReceivingIdArray.size() > 1 && ReceivingNameArray.size() > 1) {
                int k = 0;
                for (int i = 0; i < ReceivingIdArray.size(); i++) {
                    TXietongDictionary dictionary = new TXietongDictionary();
                    dictionary.setId(String.valueOf(UUID.randomUUID()));
                    dictionary.setMidValue(ReceivingIdArray.getString(i));
                    dictionary.setMainValue(ReceivingNameArray.getString(i));
                    k = dictionaryMapper.insertJiyaoyuan(dictionary);
                    if (k > 0) {
                        continue;
                    } else {
                        return k;
                    }
                }
                return k;
            } else {
                TXietongDictionary dictionary = new TXietongDictionary();
                dictionary.setId(String.valueOf(UUID.randomUUID()));
                dictionary.setMidValue(ReceivingIdArray.getString(0));
                dictionary.setMainValue(ReceivingNameArray.getString(0));
                int j = dictionaryMapper.insertJiyaoyuan(dictionary);
                return j;
            }
        }
    }

    // 查询机要员信息
    @Override
    public List<TXietongDictionary> selectJiyaoyuan() {
        List<TXietongDictionary> dictionary = dictionaryMapper.selectalljiyaoMsg();
        if (dictionary.size() > 0) {
            return dictionary;
        }
        return null;
    }

    // 修改机要员信息
    @Override
    public int updateJiyaoyuan(String requestBody) {
        JSONObject msg = JSONObject.parseObject(requestBody);
        String id = msg.getString("id");
        String mainValue = msg.getString("mainValue");
        String midValue = msg.getString("midValue");
        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setId(id);
        dictionary.setMainValue(mainValue);
        dictionary.setMidValue(midValue);
        int i = dictionaryMapper.updateJiyaoyuan(dictionary);
        return i;
    }
  //修改部委领导信息
    @Override
	public ResponseMessage updateReceivingLeader(String requestBody) {
    	  JSONObject msg = JSONObject.parseObject(requestBody);
          JSONArray ReceivingNameArray = JSONArray.parseArray(msg.getString("ReceivingName"));
          JSONArray ReceivingIdArray = JSONArray.parseArray(msg.getString("ReceivingId"));
          String typeCode=msg.getString("Type_Code");
          String typeId=msg.getString("Type_Id");
          if (ReceivingNameArray.size() <= 0 && ReceivingIdArray.size() <= 0) {
              int d = dictionaryMapper.deleteReceivingLeader(typeCode);
              return new ResponseMessage(Code.CODE_OK, "修改成功");
          } else {
              dictionaryMapper.deleteReceivingLeader(typeCode);
              if (ReceivingIdArray.size() > 1 && ReceivingNameArray.size() > 1) {
                  int k = 0;
                  for (int i = 0; i < ReceivingIdArray.size(); i++) {
                      TXietongDictionary dictionary = new TXietongDictionary();
                      dictionary.setId(String.valueOf(UUID.randomUUID()));
                      dictionary.setTypeCode(typeCode);
                      dictionary.setMidValue(ReceivingIdArray.getString(i));
                      dictionary.setMainValue(ReceivingNameArray.getString(i));
                      dictionary.setValueSort(i+1+"");
                      dictionary.setTypeId(typeId);
                      k = dictionaryMapper.insertReceivingLeader(dictionary);
                      if (k > 0) {
                          continue;
                      } else {
                          return new ResponseMessage(Code.CODE_ERROR, "修改失败");
                      }
                  }
                  return new ResponseMessage(Code.CODE_OK, "修改成功");
              } else {
                  TXietongDictionary dictionary = new TXietongDictionary();
                  dictionary.setId(String.valueOf(UUID.randomUUID()));
                  dictionary.setTypeCode(typeCode);
                  dictionary.setMidValue(ReceivingIdArray.getString(0));
                  dictionary.setMainValue(ReceivingNameArray.getString(0));
                  int j = dictionaryMapper.insertReceivingLeader(dictionary);
                  return new ResponseMessage(Code.CODE_OK, "修改成功");
              }
          }
	}

    //固定资产申请类型新增(已弃用)
    @Override
    public ResponseMessage insertInsertType(String requestBody) {
        JSONObject msg = JSONObject.parseObject(requestBody);
        String mainValue = msg.getString("mainValue");

        TXietongDictionaryExample example = new TXietongDictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andMainValueEqualTo(mainValue);
        criteria.andTypeCodeEqualTo("17");

        List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
        if (dictionaryList.size() > 0) {
            return new ResponseMessage(Code.CODE_ERROR, "当前名称已存在", "当前名称已存在");
        }
        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setId(UUID.randomUUID().toString());
        dictionary.setTypeDesc("固定资产申请类型");
        dictionary.setTypeCode("17");
        dictionary.setTypeId("1");
        dictionary.setValueDesc("固定资产申请类型");
        dictionary.setMainValue(mainValue);
        dictionary.setMidValue(UUID.randomUUID().toString());
        int i = dictionaryMapper.insertSelective(dictionary);
        if (i != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "新增失败", "新增失败");
        }
        return new ResponseMessage(Code.CODE_OK, "新增成功", "新增成功");
    }

    //配置固定资产审核人、负责人、采购员
    @Override
    public ResponseMessage updateInsertType(String requestBody) {
        JSONObject msg = JSONObject.parseObject(requestBody);

        String peopleId = msg.getString("peopleId");
        String peopleName = msg.getString("peopleName");
        String code = msg.getString("code");
        String typeDesc = msg.getString("typeDesc");

        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setId(UUID.randomUUID().toString());

        dictionary.setTypeDesc(typeDesc);
        dictionary.setValueDesc(typeDesc);
        dictionary.setMainValue(peopleName);
        dictionary.setMidValue(peopleId);
        dictionary.setTypeCode(code);
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo(code);
        int status = 0;
        status = dictionaryMapper.updateByExample(dictionary, example);
        if (status == 0) {
            status = dictionaryMapper.insert(dictionary);
            if (status == 0) {
                return new ResponseMessage(Code.CODE_ERROR, "添加失败");
            }
        }


        return new ResponseMessage(Code.CODE_OK, "添加成功");
    }

    @Override
    public List<TXietongDictionary> selectDubanzhonmglei() {
        return dictionaryMapper.selectDubanzhonglei();
    }

    @Override
    public ResponseMessage insertDubanzhonglei(String requestBody) {
        logger.debug("insertDubanzhonglei() begin===>");
        try {
            JSONObject msg = JSONObject.parseObject(requestBody);
            String mainValue = msg.getString("mainValue");
            String midValue = msg.getString("midValue");
            String subValue = msg.getString("subValue");
            String valueSort = msg.getString("valueSort");
            String remark = msg.getString("remark");
            List<TXietongDictionary> dictionaries = dictionaryMapper.selectDubanzhonglei();
            for (TXietongDictionary dictionary : dictionaries) {
                if (mainValue.equals(dictionary.getMainValue())) {
                    return new ResponseMessage(Code.CODE_ERROR, "年度不可重复","年度不可重复");
                }
            }
            TXietongDictionary dictionary = new TXietongDictionary();
            dictionary.setId(String.valueOf(UUID.randomUUID()));
            dictionary.setMainValue(mainValue);
            dictionary.setMidValue(midValue);
            dictionary.setSubValue(subValue);
            dictionary.setValueSort(valueSort);
            dictionary.setRemark(remark);
            int i = dictionaryMapper.insertDubanzhonglei(dictionary);
            if (i > 0) {
                return new ResponseMessage(Code.CODE_OK, "添加成功","添加成功");
            }
        } catch (Exception e) {
            logger.error(tag + "insertDubanzhonglei() end===>" + e);
        }
        return new ResponseMessage(Code.CODE_ERROR, "添加失败","添加失败");
    }

    /**
     * 查询公务接待审批人
     *
     * @return
     */
    @Override
    public ResponseMessage selectReceptionManager() {
        List<TXietongDictionary> dictionaries = selectDictionaryByType("9100");
        if (CollectionUtils.isEmpty(dictionaries)) {
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "请求数据为空");
            return responseMessage;
        }
        responseMessage = new ResponseMessage(Code.CODE_OK, "请求数据成功", dictionaries);
        return responseMessage;
    }

    /**
     * 修改公务接待审和办公室核稿批人
     *
     * @param dictionary
     * @return
     */
    @Override
    public ResponseMessage updateReceptionManager(TXietongDictionary dictionary) {
//        TXietongDictionaryExample dictionaryExample = new TXietongDictionaryExample();
//        Criteria criteria = dictionaryExample.createCriteria();
//        criteria.andMainValueEqualTo(dictionary.getMainValue());
//        criteria.andMidValueEqualTo(dictionary.getMidValue());
        int i = dictionaryMapper.updateByPrimaryKeySelective(dictionary);
        if (i < 0) {
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "修改失败");
            return responseMessage;
        }
        responseMessage = new ResponseMessage(Code.CODE_OK, "修改成功");
        return responseMessage;
    }

    /**
     * 查询办公室核稿人
     *
     * @return
     */
    @Override
    public ResponseMessage selectOfficePeople() {
        List<TXietongDictionary> dictionaries = selectDictionaryByType("9111");
        if (CollectionUtils.isEmpty(dictionaries)) {
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "请求数据为空");
            return responseMessage;
        }
        responseMessage = new ResponseMessage(Code.CODE_OK, "请求数据成功", dictionaries);
        return responseMessage;
    }

    @Override
    public ResponseMessage selectNiandu() {
        List<TXietongDictionary> dictionaries = dictionaryMapper.selectNiandu();
        return new ResponseMessage(Code.CODE_OK,"查询成功",dictionaries) ;
    }

    @Override
    public ResponseMessage insertNiandu(String requestBody) {
        logger.debug("insertNiandu() begin===>");
        try {
            JSONObject msg = JSONObject.parseObject(requestBody);
            String mainValue = msg.getString("mainValue");
            String midValue = msg.getString("midValue");
            String subValue = msg.getString("subValue");
            String valueSort = msg.getString("valueSort");
            String remark = msg.getString("remark");
            List<TXietongDictionary> dictionaries = dictionaryMapper.selectNiandu();
            for (TXietongDictionary dictionary : dictionaries) {
                if (mainValue.equals(dictionary.getMainValue())) {
                    return new ResponseMessage(Code.CODE_ERROR, "年度不可重复","年度不可重复");
                }
            }

            TXietongDictionary dictionary = new TXietongDictionary();
            dictionary.setId(String.valueOf(UUID.randomUUID()));
            dictionary.setMainValue(mainValue);
            dictionary.setMidValue(midValue);
            dictionary.setSubValue(subValue);
            dictionary.setValueSort(valueSort);
            dictionary.setRemark(remark);
            int i = dictionaryMapper.insertNiandu(dictionary);
            if (i > 0) {
                return new ResponseMessage(Code.CODE_OK, "添加成功","添加成功");
            }
        } catch (Exception e) {
            logger.error(tag + "insertNiandu() end===>" + e);
        }
        return new ResponseMessage(Code.CODE_ERROR, "添加失败","添加失败");
    }


    //根据type查询
    public List<TXietongDictionary> selectDictionaryByType(String type) {
        TXietongDictionaryExample dictionaryExample = new TXietongDictionaryExample();
        Criteria criteria = dictionaryExample.createCriteria();
        criteria.andTypeCodeEqualTo(type);
        List<TXietongDictionary> dictionaries = dictionaryMapper.selectByExample(dictionaryExample);
        return dictionaries;
    }

	@Override
	public ResponseMessage selectDictionaryByType() {
		return new ResponseMessage(Code.CODE_OK,"查询成功",dictionaryMapper.selectConferenceRoom());
	}

	//固定资产统一配置回显
	@Override
	public ResponseMessage selectPeopleGd(String requestBody) {
		JSONObject msg = JSONObject.parseObject(requestBody);
        String typeCode = msg.getString("typeCode");
        
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo(typeCode);
		List<TXietongDictionary> list = dictionaryMapper.selectByExample(example );
		
		return new ResponseMessage(Code.CODE_OK,"查询成功",list);
	}

	//固定资产统一配置修改
	@Override
	public ResponseMessage updatePeopleGd(String requestBody) {
		
		JSONObject msg = JSONObject.parseObject(requestBody);
        String typeCode = msg.getString("typeCode");
        JSONArray mainValue = msg.getJSONArray("mainValue");//人员名称
        JSONArray midValue = msg.getJSONArray("midValue");//人员ID
        String typeDesc = msg.getString("typeDesc");//人员说明
        
        if(mainValue.size() == 1 && midValue.size() == 1){
        	//固定资产配置
        	TXietongDictionary record = new TXietongDictionary();
            record.setMainValue(mainValue.getString(0));
            record.setMidValue(midValue.getString(0));
            record.setTypeDesc(typeDesc);
            record.setValueDesc(typeDesc);
    		TXietongDictionaryExample example = new TXietongDictionaryExample();
    		Criteria criteria = example.createCriteria();
    		criteria.andTypeCodeEqualTo(typeCode);
    		int status = dictionaryMapper.updateByExampleSelective(record , example );
    		if(status == 0){
    			record.setId(UUID.randomUUID().toString());
    			status = dictionaryMapper.insert(record);
    			if(status == 0){
    				return new ResponseMessage(Code.CODE_ERROR,"更新失败","更新失败");
    			}
    		}
        }else{
        	//签报机要员能看到的领导人员
        	TXietongDictionaryExample example = new TXietongDictionaryExample();
        	Criteria criteria = example.createCriteria();
        	criteria.andTypeCodeEqualTo("9095"); 
			dictionaryMapper.deleteByExample(example );
			
			for (int i =0;i<midValue.size();i++) {
				TXietongDictionary record = new TXietongDictionary();
				record.setId(UUID.randomUUID().toString());
				record.setTypeCode("9095");
				record.setMidValue(midValue.getString(i));
				TUser user = userMapper.selectByPrimaryKey(midValue.getString(i));
				record.setMainValue(user.getNameCn());
	            record.setTypeDesc("签报机要员查看领导");
	            record.setValueDesc("签报机要员查看领导");
	            
	            int status = dictionaryMapper.insert(record);
	            if(status == 0){
    				return new ResponseMessage(Code.CODE_ERROR,"更新失败","更新失败");
    			}
			}
			
        }
        
		return new ResponseMessage(Code.CODE_OK,"更新成功","更新成功");
	}

    @Override
    public ResponseMessage selectTypeCodeModelByCodeId(String codeId) {
        //根究typeId查询所有的配置项
        TXietongDictionaryExample dictionaryExample = new TXietongDictionaryExample();
        Criteria criteria = dictionaryExample.createCriteria();
        criteria.andTypeIdEqualTo(codeId);
        List<TXietongDictionary> dictionaries = dictionaryMapper.selectByExample(dictionaryExample);
        List<TemplateModelDO> templateModelDOS  = new ArrayList<>();

            for (int i = 0; i < dictionaries.size(); i++) {
                TemplateModelDO templateModelDO = new TemplateModelDO();
                List<TXietongDictionary> dictionaries1 = new ArrayList<>();
                String typeCode = dictionaries.get(i).getTypeCode();
                dictionaries1.add(dictionaries.get(i));
                //内层循环取出对应的dictionaries
                for (int j = i + 1; j < dictionaries.size(); j++) {
                    String typeCodes = dictionaries.get(j).getTypeCode();
                    if (typeCode.equals(typeCodes)) {
                        templateModelDO.setTpye_code(typeCode);
                        dictionaries1.add(dictionaries.get(j));


                        templateModelDO.setDictionaries(dictionaries1);
                    }

                }
                if (!StringUtils.isEmpty(templateModelDO.getTpye_code())){
                    templateModelDOS.add(templateModelDO);
                }
            }
        Set<TemplateModelDO> treeSet = new TreeSet<>(new Comparator<TemplateModelDO>() {
            @Override
            public int compare(TemplateModelDO o1, TemplateModelDO o2) {
                int compareTo = o1.getTpye_code().compareTo(o2.getTpye_code());
                return compareTo;
            }

        });
        treeSet.addAll(templateModelDOS);
        //放入新的list 或者把当前的list进行close
        List<TemplateModelDO> arrayList = new ArrayList<>(treeSet);

        ResponseMessage responseMessage = new ResponseMessage(Code.CODE_OK,"查询",arrayList);
        return responseMessage;
    }

     
	//查询发文中的配置项
	@Override
	public ResponseMessage selectDispatchTypeByTypeId(String requestBody) {
		JSONObject msg = JSONObject.parseObject(requestBody);
		String type_id=msg.getString("typeId");
		TXietongDictionaryExample example = new TXietongDictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeIdEqualTo(type_id);
		List<TXietongDictionary>list=dictionaryMapper.selectByExample(example);
		Map<Object,Object>map=new HashMap<Object,Object>();
		for(int i=0;i<list.size();i++) {
			if(map.containsKey(list.get(i).getTypeCode())) {
				continue;
			}
			List<TXietongDictionary>dicList=new LinkedList<TXietongDictionary>();
			dicList.add(list.get(i));
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i).getTypeCode().equals(list.get(j).getTypeCode())) {
					dicList.add(list.get(j));
				}
			}
			map.put(list.get(i).getTypeCode(), dicList);
		}
		return new ResponseMessage(Code.CODE_OK, "查询成功",map);
	}
    //统一配置
	@Override
	public ResponseMessage updateDictionaryByCodeAndId(String requestBody) {
		JSONObject msg = JSONObject.parseObject(requestBody);
        JSONArray mainValueArray = JSONArray.parseArray(msg.getString("mainValue"));
        JSONArray midValueArray = JSONArray.parseArray(msg.getString("midValue"));
        String typeCode=msg.getString("type_Code");
        String typeId=msg.getString("type_Id");
        String typeDesc=msg.getString("type_Desc");
        if (mainValueArray.size() <= 0 && midValueArray.size() <= 0) {
            int d = dictionaryMapper.deleteReceivingLeader(typeCode);
            return new ResponseMessage(Code.CODE_OK, "修改成功");
        } else {
            dictionaryMapper.deleteReceivingLeader(typeCode);
            if (midValueArray.size() > 1 && mainValueArray.size() > 1) {
                int k = 0;
                for (int i = 0; i < midValueArray.size(); i++) {
                    TXietongDictionary dictionary = new TXietongDictionary();
                    dictionary.setId(String.valueOf(UUID.randomUUID()));
                    dictionary.setTypeCode(typeCode);
                    dictionary.setMidValue(midValueArray.getString(i));
                    dictionary.setMainValue(mainValueArray.getString(i));
                    dictionary.setValueSort(i+1+"");
                    dictionary.setTypeId(typeId);
                    dictionary.setTypeDesc(typeDesc);
                    k = dictionaryMapper.insert(dictionary);
                    if (k > 0) {
                        continue;
                    } else {
                        return new ResponseMessage(Code.CODE_ERROR, "修改失败");
                    }
                }
                return new ResponseMessage(Code.CODE_OK, "修改成功");
            } else {
                TXietongDictionary dictionary = new TXietongDictionary();
                dictionary.setId(String.valueOf(UUID.randomUUID()));
                dictionary.setTypeCode(typeCode);
                dictionary.setMidValue(midValueArray.getString(0));
                dictionary.setMainValue(mainValueArray.getString(0));
                dictionary.setValueSort(1+"");
                dictionary.setTypeId(typeId);
                dictionary.setTypeDesc(typeDesc);
                int j = dictionaryMapper.insert(dictionary);
                if(j>0) {
                return new ResponseMessage(Code.CODE_OK, "修改成功");
            }else {
            	return new ResponseMessage(Code.CODE_ERROR, "修改失败");
            }              
        }
	}
}
	

}
