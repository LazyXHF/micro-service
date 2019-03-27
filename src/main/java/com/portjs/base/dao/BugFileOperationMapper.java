package com.portjs.base.dao;

import com.portjs.base.entity.BugFileOperation;
import org.springframework.stereotype.Repository;

@Repository
public interface BugFileOperationMapper {
    int deleteByPrimaryKey(String id);

    int insert(BugFileOperation record);

    int insertSelective(BugFileOperation record);

    BugFileOperation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BugFileOperation record);

    int updateByPrimaryKey(BugFileOperation record);
}