package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.BugDetailsRecordMapper;
import com.portjs.base.dao.TXietongDictionaryMapper;
import com.portjs.base.entity.BugDetailsRecord;
import com.portjs.base.entity.TXietongDictionary;
import com.portjs.base.entity.TXietongDictionaryExample;
import com.portjs.base.service.AgencyService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by dengshuangzhen on 2019\3\28 0028
 */
@Service
public class AgencyImpl implements AgencyService {
    private String message = "";
    private Integer code;
    @Autowired
    BugDetailsRecordMapper bugDetailsRecordMapper;

    @Autowired
    TXietongDictionaryMapper dictionaryMapper;
    /**
     * 代办查询
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage selectAgency(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String owner_id = jsonObject.getString("owner_id");
        String pageNum = jsonObject.getString("pageNum");
        String pageCount = jsonObject.getString("pageCount");
        int totelCount=bugDetailsRecordMapper.selectByOwnerIdCount(owner_id);
        Page page = new Page();
        page.init(totelCount,Integer.valueOf(pageNum),Integer.valueOf(pageCount));
        List<BugDetailsRecord> records = bugDetailsRecordMapper.selectByOwnerId(owner_id,page.getRowNum(),page.getPageCount());
        page.setList(records);
        message = records.isEmpty()?"查询失败":"查询成功";
        code = records.isEmpty() ? Code.CODE_ERROR : Code.CODE_OK ;
        return new ResponseMessage(code,message,page);
    }
    /**
     * 代办类型查询
     * @return
     */
    @Override
    public ResponseMessage selectAgencyType() {
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo("8");
        List<TXietongDictionary>list=dictionaryMapper.selectByExample(example);
        Map<Object,Object> map=new HashMap<Object,Object>();
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
}
