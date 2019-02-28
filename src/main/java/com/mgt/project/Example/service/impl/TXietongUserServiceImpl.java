package com.mgt.project.Example.service.impl;

import com.mgt.project.Example.dao.TXietongUserMapper;
import com.mgt.project.Example.entity.TXietongUser;
import com.mgt.project.Example.service.impl.TXietongUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, timeout = -1)
public class TXietongUserServiceImpl implements UserDetailsService ,TXietongUserService{

    @Autowired
    private TXietongUserMapper userMapper;

    /**
     * 根据用户名查询对象，并返回用户信息和角色信息
     * @param login_name
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String login_name){
        TXietongUser user = userMapper.loadUserByUsername(login_name);
//        //根据部门领导id,判断是否是部门负责人
//        TXietongDepartment department = departmentMapper.selectByPrimaryKey(user.getDepartmentid());
//        if (user.getId().equals(department.getLeaderId())){
//            user.setExt4("true");
//        }else {
//            user.setExt4("false");
//        }
//
//        List<TXietongDictionary> dictionaries = selectDictionaryByType("9111");
//        for (int i=0;i<dictionaries.size();i++){
//            if (user.getId().equals(dictionaries.get(i).getMidValue())){
//                user.setExt5("true");
//                return user;
//            }else {
//                user.setExt5("false");
//            }
//        }

//        System.out.println(user);
//        String dids = user.getDepartmentid();
//        String[] did = dids.split(",");
//        for (int i=0;i<did.length;i++){
//
//        }

//        System.out.println(user);
//        if (null == user) {
//            throw new UsernameNotFoundException(login_name + "不存在");
//        }

//        UserRole userRole = new UserRole(user);
//        userRole.setRole(user.getRoles());
//        String departmentName = departmentMapper.selectNameById(user.getDepartmentid());
//        userRole.setDepartmentName(departmentName);
//         UserRole role = roleDao.slelctRoleById(user.getRole_id());
//        ur.setRole(user.);
//        ur.setEnabled("1".equals(String.valueOf(user.getIsdelete())) ? true : false);
//        ur.setEnabled(ur.isEnabled() ? "1".equals(String.valueOf(user.getStatus())) : ur.isEnabled());
        return user;
    }

    @Override
    public int deleteUserByLoginName(String id) {
        return userMapper.deleteUserByLoginName(id);
    }
}
