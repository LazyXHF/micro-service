package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.BusinessConfigurationMapper;
import com.portjs.base.dao.BusinessDictionaryMapper;
import com.portjs.base.dao.ProjectMapper;
import com.portjs.base.entity.*;
import com.portjs.base.service.BusinessConfigurationService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: daiyueyuan
 * @date: 2019/4/18 19:27
 * @description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BusinessConfigurationServiceImpl implements BusinessConfigurationService {

    @Autowired
    private BusinessConfigurationMapper businessConfigurationMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private BusinessDictionaryMapper businessDictionaryMapper;

    @Override
    public ResponseMessage selectBusinessConfigurationById(String requestBody) {
        JSONObject requestMsg = JSONObject.parseObject(requestBody);
        String projectId = requestMsg.getString("project_id");
        Map<String, Map<String, String>> map = new LinkedHashMap<>();
        List<BusinessConfiguration> businessConfigurations = businessConfigurationMapper.selectAll(projectId);
        for (BusinessConfiguration businessConfiguration : businessConfigurations) {
            Map<String, String> map1 = new LinkedHashMap<>();
            if (!StringUtils.isEmpty(businessConfiguration.getProjectStatus())) {
                String[] statuss = businessConfiguration.getProjectStatus().split(",");
                for (String status : statuss) {
                    if (status.contains(businessConfiguration.getProNode())) {
                        status = status.substring(2, 3);
                        map1.put(businessConfiguration.getProjectNodeName(), status);
                    }
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (businessConfiguration.getPredictStarttime() != null) {
                    //预计开始时间
                    map1.put("PredictStarttime", sdf.format(businessConfiguration.getPredictStarttime()));
                }
                if (businessConfiguration.getPridectEndtime() != null) {
                    //预计完成时间
                    map1.put("PridectEndtime", sdf.format(businessConfiguration.getPridectEndtime()));
                }
                if (businessConfiguration.getActualStarttime() != null) {
                    //实际开始时间
                    map1.put("ActualStarttime", sdf.format(businessConfiguration.getActualStarttime()));
                }
                if (businessConfiguration.getActualEndtime() != null) {
                    //实际结束时间
                    map1.put("ActualEndtime", sdf.format(businessConfiguration.getActualEndtime()));
                }
                if (map.get(businessConfiguration.getProjectSchedule()) == null) {
                    map.put(businessConfiguration.getProjectSchedule(), map1);
                } else {
                    map.get(businessConfiguration.getProjectSchedule()).putAll(map1);
                }
            } else {
                map1.put(businessConfiguration.getProjectNodeName(), null);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (businessConfiguration.getPredictStarttime() != null) {
                    //预计开始时间
                    map1.put("PredictStarttime", sdf.format(businessConfiguration.getPredictStarttime()));
                }
                if (businessConfiguration.getPridectEndtime() != null) {
                    //预计完成时间
                    map1.put("PridectEndtime", sdf.format(businessConfiguration.getPridectEndtime()));
                }
                if (businessConfiguration.getActualStarttime() != null) {
                    //实际开始时间
                    map1.put("ActualStarttime", sdf.format(businessConfiguration.getActualStarttime()));
                }
                if (businessConfiguration.getActualEndtime() != null) {
                    //实际结束时间
                    map1.put("ActualEndtime", sdf.format(businessConfiguration.getActualEndtime()));
                }
                if (map.get(businessConfiguration.getProjectSchedule()) == null) {
                    map.put(businessConfiguration.getProjectSchedule(), map1);
                } else {
                    map.get(businessConfiguration.getProjectSchedule()).putAll(map1);
                }
            }
        }
        if (map.size() != 0) {
            return new ResponseMessage(Code.CODE_OK, "查询成功", map);
        }
        return new ResponseMessage(Code.CODE_ERROR, "暂无数据");
    }
}
