package com.portjs.base.service;

import com.portjs.base.entity.BugFileOperation;
import com.portjs.base.util.ResponseMessage;

public interface BugFileOperationService {

    ResponseMessage deleteByPrimaryKey(String id);

    //int insert(BugFileOperation record);

    ResponseMessage insertSelective(BugFileOperation record);

    ResponseMessage selectByPrimaryKey(String id);

    ResponseMessage updateByPrimaryKeySelective(BugFileOperation record);

    //int updateByPrimaryKey(BugFileOperation record);
}
