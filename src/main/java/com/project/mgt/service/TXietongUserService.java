package com.project.mgt.service;

import com.project.mgt.entity.TXietongUser;
import com.project.mgt.util.Page;
import com.project.mgt.util.ResponseMessage;
import com.project.mgt.vo.PageVo;
import com.project.mgt.vo.SortVo;
import com.project.mgt.vo.UserRoleDeparmentsVO;

import java.util.List;

/**
 * 用户模块
 */
public interface TXietongUserService {
    /**
     * 添加用户
     * @param urvo
     * @return
     */
    ResponseMessage insertUser(UserRoleDeparmentsVO urvo);

    /**
     * 查询所有用户  排序字段为 sort
     * @return
     */
    Page<TXietongUser> selectAllUser(int pageNo, int pageSize);

    /**
     * 根据用户登录的账号，更改用户的登录状态
     * @param login_name
     * @return
     */
    ResponseMessage enOrDisUser(String login_name);


    /**
     * 根据用户id称删除用户
     * @param ids
     */
    ResponseMessage deleteUserByLoginNames(List<String> ids);

    /**
     * 根据用户名获取当前用户信息（包括角色）
     * @param login_name
     * @return
     */
    ResponseMessage selectUserAndRoleByUserName(String login_name);


    /**
     * 修改用户信息
     * @param urvo
     * @return
     */
    ResponseMessage updateUserInfo(UserRoleDeparmentsVO urvo);


    /**
     * 用户排序
     * @return
     */
    ResponseMessage updateSortByLoginName(String name1, String name2);


    /**
     * 拖动排序
     * @param sortVos
     * @return
     */
    ResponseMessage sortButtons(List<SortVo> sortVos);


    /**
     * 模糊查找用户
     * @param name
     * @return
     */
    ResponseMessage selectUserByLikeName(String name);


    /**
     * 修改密码
     * @param password
     * @param uid
     * @return
     */
    ResponseMessage updatePassword(String password, String uid);


    /**
     * 模糊查找用户(分页)
     * @param pageVo
     * @return
     */
    ResponseMessage selectUserByLikeNamePage(PageVo pageVo);


    /**
     * 删除部门时，判断该部门下是否有用户
     * @param id
     * @return
     */
    ResponseMessage selectUserByDepartmentId(String id);




}
