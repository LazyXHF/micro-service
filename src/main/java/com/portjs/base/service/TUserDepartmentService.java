package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

public interface TUserDepartmentService {
    /**
     * 根据当前登录人id查找其所在部门
     * @return uId 当前登录人id
     */
    ResponseMessage findTUserDepartmentMapper(String uId);
}
