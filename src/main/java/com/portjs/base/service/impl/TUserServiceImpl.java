package com.portjs.base.service.impl;

import com.portjs.base.dao.TUserMapper;
import com.portjs.base.dao.TUserRoleMapper;
import com.portjs.base.entity.TUser;
import com.portjs.base.entity.TUserExample;
import com.portjs.base.entity.TUserRole;
import com.portjs.base.entity.TUserRoleExample;
import com.portjs.base.service.TUserService;
import com.portjs.base.util.*;
import com.portjs.base.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户实现类
 */
@Service
@Transactional
public class TUserServiceImpl implements UserDetailsService, TUserService {

    ResponseMessage responseMessage;
    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TUserRoleMapper userRoleMapper;






    /**
     * 登录验证
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserUtils.USER_NAME_ACCOUNT = s;


        TUser user = userMapper.loginUserByAccount(s);



        return user;
    }


    /**
     * 添加用户
     * @param userRoleVO
     * @return
     */
    @Override
    public ResponseMessage insertUser(UserRoleVO userRoleVO) {
        TUser user = userRoleVO.getUser();
        List<String> rids = userRoleVO.getRids();
        if (StringUtils.isEmpty(user.getLoginAccount())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        if (!CollectionUtils.isEmpty(selectUserByAcccount(user.getLoginAccount()))){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"登录名已存在");
            return responseMessage;
        }
        //添加用户表
        int sort = userMapper.selectMaxSort();
        user.setId(UUID.randomUUID().toString());
        user.setCreatetime(new Date());
        user.setSort(sort);
        user.setPingyin(Pinyin4jUtil.converterToFirstSpell(user.getLoginName()));
        user.setLastUpdPasswdTime(new Date());
        user.setPasswdWrongCount(0);
        //删除所有角色信息
        deleteUserRole(user.getId());


        for (int i=0;i<rids.size();i++){
            TUserRole userRole = new TUserRole();
            userRole.setId(UUID.randomUUID().toString());
            userRole.setUserId(user.getId());
            userRole.setRoleId(rids.get(i));
            userRoleMapper.insert(userRole);
        }

       int i =  userMapper.insert(user);
        if (i<0){
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "添加失败");
        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"添加成功");
        }
        return responseMessage;
    }

    /**
     * 修改用户信息
     * @param userRoleVO
     * @return
     */
    @Override
    public ResponseMessage updateUser(UserRoleVO userRoleVO) {
        TUser user = userRoleVO.getUser();
        List<String> rids = userRoleVO.getRids();
        Date lastPasswordTime = userMapper.selectByPrimaryKey(userRoleVO.getUser().getId()).getLastUpdPasswdTime();
        String historyPassword = userMapper.selectByPrimaryKey(userRoleVO.getUser().getId()).getHistoryPassword();
        if (StringUtils.isEmpty(user.getLoginAccount())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        if (!CollectionUtils.isEmpty(selectUserByAcccount(user.getLoginAccount()))){
            //除掉当前用户
            if (!selectUserByAcccount(user.getLoginAccount()).get(0).getId().equals(user.getId())){
                responseMessage = new ResponseMessage(Code.CODE_ERROR,"登录名已存在");
                return responseMessage;
            }
        }

        //删除所有角色信息
        deleteUserRole(user.getId());




        //添加角色
        for (int i=0;i<rids.size();i++){
            TUserRole userRole = new TUserRole();
            userRole.setId(UUID.randomUUID().toString());
            userRole.setUserId(user.getId());
            userRole.setRoleId(rids.get(i));
            userRoleMapper.insert(userRole);
        }

        if (!StringUtils.isEmpty(user.getLoginPassword())){
            StringBuilder sb = new StringBuilder();
            user.setLastUpdPasswdTime(new Date());
            //计算周期
            int days = (int) ((new Date().getTime() - lastPasswordTime.getTime() ) / (1000*3600*24));

            user.setPasswordModifyCycle(days);
            sb.append(user.getLoginPassword()+","+historyPassword);
            user.setHistoryPassword(sb.toString());
        }
        //更新用户信息
         user.setPingyin(Pinyin4jUtil.converterToFirstSpell(user.getLoginName()));
        int i =   userMapper.updateByPrimaryKeySelective(user);
        if (i<0){
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "修改失败");
        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        }

        return responseMessage;
    }




    /**
     * 删除用户
     * @param arrayVO
     * @return
     */
    @Override
    public ResponseMessage deleteUser(ArrayVO arrayVO) {
        List<String> uids = arrayVO.getList();
        for (int i=0;i<uids.size();i++){
            //删除关联表数据
          userRoleMapper.deleteUserRoleByUid(uids.get(i));

          //删除用户
            userMapper.deleteByPrimaryKey(uids.get(i));
        }

        responseMessage = new ResponseMessage(Code.CODE_OK,"删除成功");
        return responseMessage;
    }

    /**
     * 查找用户
     * @param pageVo
     * @return
     */
    @Override
    public ResponseMessage selectUser(PageVo pageVo) {

        Page<UserRoleDO> page = new Page<>();
        System.out.println(pageVo.toString());
        int total = userMapper.selectUserCountByLoginNameOrDepartmentId(pageVo.getObject(),pageVo.getDepartmentId());
        page.init(total,pageVo.getPageNo(),pageVo.getPageSize());
        List<TUser> users = userMapper.selectUserByLoginNameOrDepartmentId(pageVo.getObject(),pageVo.getDepartmentId(),page.getRowNum(),page.getPageCount());

        List<UserRoleDO> userList = new ArrayList<>();
        for (int i=0;i<users.size();i++){

            if (!StringUtils.isEmpty(users.get(i).getId())){
                UserRoleDO userRoleDOS = userMapper.selectUserAndRoleAndDepartmentByUid(users.get(i).getId());
                if (userRoleDOS!=null){
                    userList.add(userRoleDOS);
                }
            }

        }
//
//        //判断是否是部门负责人
//        for (int i=0;i<userList.size();i++){
//            if (userList.get(i).getLeaderId().equals(userList.get(i).getId())){
//                userList.get(i).setIsLeader("true");
//            }else {
//                userList.get(i).setIsLeader("false");
//            }
//        }

        page.setList(userList);


        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",page);

        return responseMessage;
    }

    /**
     * 用户排序
     * @param sortVo
     * @return
     */
    @Override
    public ResponseMessage sortUser(List<SortVo> sortVo) {
        if (CollectionUtils.isEmpty(sortVo)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        for (int i=0;i<sortVo.size();i++){
          userMapper.updateSortByUid(sortVo.get(i).getSort(),sortVo.get(i).getId());
        }

        responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        return responseMessage;
    }

    /**
     * 禁用/或启用用户
     * @param user
     * @return
     */
    @Override
    public ResponseMessage updateUserStatus(TUser user) {
        TUser user1 = userMapper.selectByPrimaryKey(user.getId());
        int status = user1.getStatus();
        if (status ==1){
            user.setStatus(0);
        }else {
            user.setStatus(1);
            user.setPasswdWrongCount(0);
        }
        int i = userMapper.updateByPrimaryKeySelective(user);

        if (i<0){
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "禁用/启用失败");
        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"禁用/启用成功");
        }

        return responseMessage;
    }


    //根据用户名查找用户
    public List<TUser> selectUserByAcccount(String account){
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginAccountEqualTo(account);
        List<TUser> tUsers = userMapper.selectByExample(example);
        return tUsers;
    }


    //批量删除角色
    public void  deleteUserRole(String uid){
        TUserRoleExample example = new TUserRoleExample();
        TUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(uid);
        userRoleMapper.deleteByExample(example);
    }



}
