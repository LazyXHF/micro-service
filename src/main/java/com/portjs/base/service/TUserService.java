package com.portjs.base.service;

import com.portjs.base.entity.TStuff;
import com.portjs.base.entity.TUser;
import com.portjs.base.entity.TUserRole;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.*;

import java.util.List;

public interface TUserService {

    /**
     * 添加用户
     * @param userRoleVO
     * @return
     */
    ResponseMessage insertUser(UserRoleVO userRoleVO);

    /**
     * 修改用户信息
     * @param userRoleVO
     * @return
     */
    ResponseMessage updateUser(UserRoleVO userRoleVO);


    /**
     * 删除用户
     * @param arrayVO
     * @return
     */
    ResponseMessage deleteUser(ArrayVO arrayVO);


    /**
     * 查找用户
     * @param pageVo
     * @return
     */
    ResponseMessage selectUser(PageVo pageVo);

    /**
     * 用户排序
     * @param sortVo
     * @return
     */
    ResponseMessage sortUser(List<SortVo> sortVo);


    /**
     * 禁用/或启用用户
     * @param user
     * @return
     */
    ResponseMessage updateUserStatus(TUser user);



    ResponseMessage userPassword(String requestBody);








    //////-------------------------------------------------------------一人多部门

    ResponseMessage insertUserDepartments(UserRoleVO userRoleVO);


    ResponseMessage updateUserDepartments(UserRoleVO userRoleVO);


    ResponseMessage selectUserDepartments(PageVo pageVo);





    /**
     *  //////-------------------------------------------------------------一人多部门  （员工表)
     */

    /**
     * 添加员工信息
     * @param stuff
     * @return
     */
    ResponseMessage insertSuffer(TStuff stuff);
    /**
     * 添加用工部门信息
     * @param userRoleStuffDepartmentVO
     * @return
     */
    ResponseMessage insertSufferDepartment(UserRoleStuffDepartmentVO userRoleStuffDepartmentVO);


    ResponseMessage insertUserDepartmentsSuffer(UserRoleVO userRoleVO);




}
