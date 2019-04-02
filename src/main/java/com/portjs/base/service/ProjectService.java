package com.portjs.base.service;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.util.ResponseMessage;

/**
 * Created by Administrator on 2019/4/2.
 */

public interface ProjectService {
    ResponseMessage queryProjectAllInfo(JSONObject requestJson);
}
