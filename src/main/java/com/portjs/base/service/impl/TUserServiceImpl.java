package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.TErrcodeInfoService;
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

    @Autowired
    private TErrcodeInfoService errcodeInfoService;

    @Autowired
    private TXietongDictionaryMapper dictionaryMapper;

    @Autowired
private TUserDepartmentMapper userDepartmentMapper;

    @Autowired
    private TDepartmentMapper departmentMapper;




    /**
     * 登录验证
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserUtils.USER_NAME_ACCOUNT = s;

//        userList.get(i).setDepartments(departments);
        TUser user = userMapper.loginUserByAccount(s);
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andLoginAccountEqualTo(s);
        List<TUser> users = userMapper.selectByExample(example);

        //查询一人多部门用户
        if (!CollectionUtils.isEmpty(users)){
          List<TDepartment> departments = departmentMapper.selectDepartmentByUid(users.get(0).getId());
            user.setDepartments(departments);
        }

        user.setPasswdWrongCount(0);
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
        if (StringUtils.isEmpty(user.getLoginAccount())||StringUtils.isEmpty(user.getNameCn())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"必填项为空");
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
//        user.setNameCn(user.getLoginName());
        user.setPingyin(Pinyin4jUtil.converterToFirstSpell(user.getNameCn()));
        user.setLastUpdPasswdTime(new Date());
        user.setPasswdWrongCount(0);
        //重置密码周期
        user.setPasswordModifyCycle(90);
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
        if (StringUtils.isEmpty(user.getLoginAccount())||StringUtils.isEmpty(user.getNameCn())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"必填项为空");
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
//            int days = (int) ((new Date().getTime() - lastPasswordTime.getTime() ) / (1000*3600*24));

            //重置密码周期
            user.setPasswordModifyCycle(90);

            sb.append(user.getLoginPassword()+","+historyPassword);
            user.setHistoryPassword(sb.toString());
        }
        //更新用户信息
//        user.setNameCn(user.getLoginName());
         user.setPingyin(Pinyin4jUtil.converterToFirstSpell(user.getNameCn()));
        if (!StringUtils.isEmpty(user.getNameCn())){
            dictionaryMapper.updateMAINByMID(user.getId(),user.getNameCn());

        }
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
          //删除部门用户关联表
          deleteUserDepartment(uids.get(i));
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
            responseMessage = new ResponseMessage(Code.CODE_OK, "禁用成功");
        }else {
            user.setStatus(1);
            responseMessage = new ResponseMessage(Code.CODE_OK, "启用成功");
            user.setPasswdWrongCount(0);
        }
        userMapper.updateByPrimaryKeySelective(user);

//        if (i<0){
//            responseMessage = new ResponseMessage(Code.CODE_ERROR, "禁用/启用失败");
//        }else {
//            responseMessage = new ResponseMessage(Code.CODE_OK,"禁用/启用成功");
//        }

        return responseMessage;
    }


    @Override
    public ResponseMessage userPassword(String requestBody) {
        JSONObject jsonObj = JSONObject.parseObject(requestBody);
        String id = jsonObj.getString("id");
        String loginPassword = jsonObj.getString("loginPassword");
        TUser user = userMapper.selectByPrimaryKey(id);
        user.setLoginPassword(loginPassword);
        user.setLastUpdPasswdTime(new Date());
        StringBuilder historyPassword = new StringBuilder();
        String hp = user.getHistoryPassword();
        if (hp!=null && !hp.equals("")){
            historyPassword = historyPassword.append(hp);
        }
        historyPassword = historyPassword.append(loginPassword).append(",");
        user.setHistoryPassword(String.valueOf(historyPassword));
        user.setPasswordModifyCycle(90);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i < 0) {
            String errorMsg = errcodeInfoService.getErrorMsg("10001", "10140001");
            responseMessage = new ResponseMessage(Code.CODE_ERROR, errorMsg,"10140001");
        } else {
            responseMessage = new ResponseMessage(Code.CODE_OK, "修改密码成功","");
        }
        return responseMessage;
    }
/**
 * -----------------------------------------------------------------------------------------------------------------------------------------
 */
    /**
     * 一人多门添加用户
     * @param userRoleVO
     * @return
     */
    @Override
    public ResponseMessage insertUserDepartments(UserRoleVO userRoleVO) {
        TUser user = userRoleVO.getUser();
        List<String> rids = userRoleVO.getRids();
        List<String> dids = userRoleVO.getDids();
        if (StringUtils.isEmpty(user.getLoginAccount())||StringUtils.isEmpty(user.getNameCn())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"必填项为空");
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
//        user.setNameCn(user.getLoginName());
        user.setPingyin(Pinyin4jUtil.converterToFirstSpell(user.getNameCn()));
        user.setLastUpdPasswdTime(new Date());
        user.setPasswdWrongCount(0);
        //重置密码周期
        user.setPasswordModifyCycle(90);
        //删除所有角色信息
        deleteUserRole(user.getId());
        for (int i=0;i<rids.size();i++){
            TUserRole userRole = new TUserRole();
            userRole.setId(UUID.randomUUID().toString());
            userRole.setUserId(user.getId());
            userRole.setRoleId(rids.get(i));
            userRoleMapper.insert(userRole);
        }


        //添加部门表
        for (int i=0;i<dids.size();i++){
            TUserDepartment userDepartment = new TUserDepartment();
            userDepartment.setuId(user.getId());
            userDepartment.setdId(dids.get(i));
            userDepartmentMapper.insert(userDepartment);
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
     * 一人多门修改用户
     * @param userRoleVO
     * @return
     */
    @Override
    public ResponseMessage updateUserDepartments(UserRoleVO userRoleVO) {
        TUser user = userRoleVO.getUser();
        List<String> rids = userRoleVO.getRids();
        List<String> dids = userRoleVO.getDids();
        Date lastPasswordTime = userMapper.selectByPrimaryKey(userRoleVO.getUser().getId()).getLastUpdPasswdTime();
        String historyPassword = userMapper.selectByPrimaryKey(userRoleVO.getUser().getId()).getHistoryPassword();
        if (StringUtils.isEmpty(user.getLoginAccount())||StringUtils.isEmpty(user.getNameCn())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"必填项为空");
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

        //删除所有部门信息
        deleteUserDepartment(user.getId());
        //添加部门表
        for (int i=0;i<dids.size();i++){
            TUserDepartment userDepartment = new TUserDepartment();
            userDepartment.setuId(user.getId());
            userDepartment.setdId(dids.get(i));
            userDepartmentMapper.insert(userDepartment);
        }



        if (!StringUtils.isEmpty(user.getLoginPassword())){
            StringBuilder sb = new StringBuilder();
            user.setLastUpdPasswdTime(new Date());
            //计算周期
//            int days = (int) ((new Date().getTime() - lastPasswordTime.getTime() ) / (1000*3600*24));

            //重置密码周期
            user.setPasswordModifyCycle(90);

            sb.append(user.getLoginPassword()+","+historyPassword);
            user.setHistoryPassword(sb.toString());
        }
        //更新用户信息
//        user.setNameCn(user.getLoginName());
        user.setPingyin(Pinyin4jUtil.converterToFirstSpell(user.getNameCn()));
        if (!StringUtils.isEmpty(user.getNameCn())){
            dictionaryMapper.updateMAINByMID(user.getId(),user.getNameCn());

        }
        int i =   userMapper.updateByPrimaryKeySelective(user);



        if (i<0){
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "修改失败");
        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        }

        return responseMessage;
    }

    /**
     * 一人多部门查找
      * @param pageVo
     * @return
     */
    @Override
    public ResponseMessage selectUserDepartments(PageVo pageVo) {
        Page<UserRoleDO> page = new Page<>();
        System.out.println(pageVo.toString());
        int total = userMapper.selectUserCountByLoginNameAndDepartmentIds(pageVo.getObject(),pageVo.getDepartmentId());
        page.init(total,pageVo.getPageNo(),pageVo.getPageSize());
        List<TUser> users = userMapper.selectUserByLoginNameAndDepartmentIds(pageVo.getObject(),pageVo.getDepartmentId(),page.getRowNum(),page.getPageCount());
        List<UserRoleDO> userList = new ArrayList<>();

        for (int i=0;i<users.size();i++){
            if (!StringUtils.isEmpty(users.get(i).getId())){
                UserRoleDO userRoleDOS = userMapper.selectUserAndRoleAndDepartmentByUids(users.get(i).getId());
                if (userRoleDOS!=null){
                    userList.add(userRoleDOS);
                }
            }

        }

        //判断部门id是否为空
        if (StringUtils.isEmpty(pageVo.getDepartmentId())){
            for (int i=0;i<userList.size();i++){
                List<TDepartment> departments = departmentMapper.selectDepartmentByUid(userList.get(i).getId());
                userList.get(i).setDepartments(departments);
            }
        }else {
            for (int i = 0; i < userList.size(); i++) {
                List<TDepartment> departments = new ArrayList<>();
                TDepartment department = departmentMapper.selectByPrimaryKey(pageVo.getDepartmentId());
                departments.add(department);
                userList.get(i).setDepartments(departments);
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

    //批量删除部门
    public void deleteUserDepartment(String uid){
        TUserDepartmentExample example = new TUserDepartmentExample();
        TUserDepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andUIdEqualTo(uid);
        userDepartmentMapper.deleteByExample(example);
    }




}
