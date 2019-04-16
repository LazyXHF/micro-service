package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.TDepartmentMapper;
import com.portjs.base.dao.TUserDepartmentMapper;
import com.portjs.base.entity.TDepartment;
import com.portjs.base.entity.TUserDepartment;
import com.portjs.base.service.TUserDepartmentService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TUserDepartmentServiceImpl implements TUserDepartmentService {

    @Autowired
    TUserDepartmentMapper tUserDepartmentMapper;
    @Autowired
    TDepartmentMapper tDepartmentMapper;

    @Override
    public ResponseMessage findTUserDepartmentMapper(String uId) {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(uId);
        String uId1 = jsonObject.getString("uid");
        TUserDepartment tUserDepartmentMapper = this.tUserDepartmentMapper.findTUserDepartmentMapper(uId1);
        String s = tUserDepartmentMapper.getdId();
        TDepartment tDepartment = tDepartmentMapper.selectByPrimaryKey(s);
        if(tDepartment==null){
            return  new ResponseMessage(Code.CODE_ERROR,"查询失败！！");
        }

        return  new ResponseMessage(Code.CODE_OK,"查询成功！！");
    }
}
