package com.project.mgt.util;

import com.project.mgt.dao.TXietongDepartmentMapper;
import com.project.mgt.dao.TXietongUserMapper;
import com.project.mgt.entity.TXietongDepartment;
import com.project.mgt.entity.TXietongUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 当前登陆人的所有信息
 * @author user
 *
 */

@Component
public class UserInfoUtil {
	@Autowired
	private  TXietongDepartmentMapper tXietongDepartmentMapper;
	
	@Autowired
	private  TXietongUserMapper tXietongUserMapper;
	
    public  Map<String,String> getUserInfo(String userId){
        try {
        	
        	Map<String,String> userMap = new HashMap<String, String>();
        	TXietongUser userRole = tXietongUserMapper.selectByPrimaryKey(userId);
        	//获取当前登陆人员的信息
        	//TXietongUser userRole = (TXietongUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		
    		//当前登陆人姓名
    		String name = userRole.getNameCn();
    		String id = userRole.getId();//当前登陆人id
    		
    		
    		//当前登陆人所属部门id
    		String departmentid = userRole.getDepartmentid();
    		
    		//当前登陆人电话
    		String telphone = userRole.getTelphone();
    		
    		
    		userMap.put("userName", name);
    		userMap.put("userId", id);
    		userMap.put("telphone", telphone);
    		userMap.put("departmentid", departmentid);
    		
    		//通过部门id查找部门名称和部门领导人
    		TXietongDepartment department = tXietongDepartmentMapper.selectByPrimaryKey(departmentid);
    		
    		if(department != null){
    			String deptmentName = department.getName();//部门名称
    			//获得部门领导人id
        		String leaderId = department.getLeaderId();//领导id
        		
        		userMap.put("deptmentName", deptmentName);
        		
        		userMap.put("leaderId", leaderId);
        		
        		//通过部门领导人id查询领导人姓名
        		TXietongUser leaderUser = tXietongUserMapper.selectByPrimaryKey(leaderId);
        		
        		if(leaderUser != null){
        			String leaderName = leaderUser.getNameCn();//领导姓名
        			userMap.put("leaderName", leaderName);
        		}else{
        			userMap.put("leaderName", null);
        		}
    		}else{
    			userMap.put("deptmentName", null);
    			userMap.put("leaderName", null);
        		userMap.put("leaderId", null);
    		}
    		
    		return userMap;
    		
    		
        }catch (Exception e){
            return  new HashMap<String, String>();
        }

    }
}
