package com.mgt.project.Example.dao;

import com.mgt.project.Example.entity.TXietongUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TXietongUserMapper {

    TXietongUser loadUserByUsername(String login_name);

    //删除用户根据id
    int deleteUserByLoginName(String id);
}