package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.TUser;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.TUserService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import com.portjs.base.vo.PageVo;
import com.portjs.base.vo.SortVo;
import com.portjs.base.vo.UserRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController extends BaseController  {
    static  final String tag = "UserController======>";

    private ResponseMessage responseMessage;

    @Autowired
    TUserService tUserService;

    /**
     * 添加用户
     */
    @LogInfo(methodName = "添加角色",modelName = "角色模块")
    @RequestMapping("insert-user")
    @ResponseBody
    public ResponseMessage insertUser(@RequestBody UserRoleVO user){
        logger.debug(tag+user);
        UnifiedExceptionHandler.method= tag+"insertUser=============================="+user;
        responseMessage = tUserService.insertUser(user);
        return responseMessage;
    }

    /**
     * 删除用户
     * @param arrayVO
     * @return
     */
    @LogInfo(methodName = "删除用户",modelName = "用户模块")
    @RequestMapping("delete-user")
    @ResponseBody
    public ResponseMessage deleteUser(@RequestBody ArrayVO arrayVO){
        logger.debug(tag+arrayVO);
        UnifiedExceptionHandler.method= tag+"deleteUser=============================="+arrayVO;
        responseMessage = tUserService.deleteUser(arrayVO);
        return responseMessage;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @LogInfo(methodName = "修改用户",modelName = "用户模块")
    @RequestMapping("update-user")
    @ResponseBody
    public ResponseMessage updateUser(@RequestBody UserRoleVO user){
        logger.debug(tag+user);
        UnifiedExceptionHandler.method= tag+"updateUser=============================="+user;
        responseMessage = tUserService.updateUser(user);
        return responseMessage;
    }

    /**
     * 查询用户信息
     * @param pageVo
     * @return
     */
    @LogInfo(methodName = "查询用户信息",modelName = "用户模块")
    @RequestMapping("select-user")
    @ResponseBody
    public ResponseMessage selectUser(@RequestBody PageVo pageVo){
        logger.debug(tag+pageVo);
        UnifiedExceptionHandler.method= tag+"selectUser=============================="+pageVo;
        responseMessage = tUserService.selectUser(pageVo);
        return responseMessage;
    }

    /**
     * 用户分类
     * @param list
     * @return
     */
    @LogInfo(methodName = "用户分类",modelName = "用户模块")
    @RequestMapping("sort-user")
    @ResponseBody
    public ResponseMessage sortUser(@RequestBody List<SortVo> list){
        logger.debug(tag+list);
        UnifiedExceptionHandler.method= tag+"sortUser=============================="+list;
        responseMessage = tUserService.sortUser(list);
        return responseMessage;
    }
    /**
     * 禁用/启用用户
     * @param user
     * @return
     */
    @LogInfo(methodName = "禁用/启用用户",modelName = "用户模块")
    @RequestMapping("update-userStatus")
    @ResponseBody
    public ResponseMessage updateUserStatus(@RequestBody TUser user){
        logger.debug(tag+user);
        UnifiedExceptionHandler.method= tag+"updateUserStatus=============================="+user;
        responseMessage = tUserService.updateUserStatus(user);
        return responseMessage;
    }

}
