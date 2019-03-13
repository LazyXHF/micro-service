package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

public interface ProjectManagerService {
    /**
     * 获取当前项目id  来获取项目生命周期的时间节点
     * 此接口进行时间处理
     * @return
     */
    ResponseMessage dealProjectTime(String id);

}
