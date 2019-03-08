package com.portjs.base.service;

import com.portjs.base.entity.Design;
import com.portjs.base.util.ResponseMessage;
import org.springframework.stereotype.Repository;

public interface DesignService {
    ResponseMessage deleteByPrimaryKey(String id);

    ResponseMessage insert(Design record);

    ResponseMessage insertSelective(String param);

    ResponseMessage selectByPrimaryKey(String id);

    ResponseMessage updateByPrimaryKeySelective(Design record);

    ResponseMessage updateByPrimaryKey(Design record);
}