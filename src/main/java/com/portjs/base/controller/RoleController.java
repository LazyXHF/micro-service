package com.portjs.base.controller;

import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.TRole;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.TRoleService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色
 */
@RestController
@RequestMapping("role")
@CrossOrigin
public class RoleController extends  BaseController{
    static  final String tag = "RoleController======>";

    private ResponseMessage responseMessage;

    @Autowired
    private TRoleService roleService;


    /**
     * 添加角色
     * @param role
     * @return
     */

    @LogInfo(methodName = "添加角色",modelName = "角色模块")
    @RequestMapping("insert-role")
    @ResponseBody
    public ResponseMessage insertRole(@RequestBody TRole role){
        logger.debug(tag+role);
        UnifiedExceptionHandler.method= tag+"insertRole=============================="+role;
        responseMessage = roleService.insertRole(role);
        return responseMessage;
    }


    /**
     * 批量删除角色
     * @param arrayVO
     * @return
     */
    @LogInfo(methodName = "批量删除角色",modelName = "角色模块")
    @RequestMapping("delete-role")
    @ResponseBody
    public ResponseMessage deleteRole(@RequestBody ArrayVO arrayVO){
        logger.debug(tag+arrayVO);
        UnifiedExceptionHandler.method= tag+"deleteRole=============================="+arrayVO;
        responseMessage = roleService.deleteRoleByRid(arrayVO);
        return responseMessage;
    }


    /**
     * 修改角色
     * @param role
     * @return
     */
    @LogInfo(methodName = "修改角色",modelName = "角色模块")
    @RequestMapping("update-role")
    @ResponseBody
    public ResponseMessage updateRoleById(@RequestBody TRole role){
        logger.debug(tag+role);
        UnifiedExceptionHandler.method= tag+"updateRoleById=============================="+role;
        responseMessage = roleService.updateRoleById(role);
        return responseMessage;
    }

    /**
     * 根据角色名和状态查找角色
     * @param pageVo
     * @return
     */
    @LogInfo(methodName = "根据角色名和状态查找角色",modelName = "角色模块")
    @RequestMapping("select-role")
    @ResponseBody
    public ResponseMessage selectRolesPage(@RequestBody PageVo pageVo){
        logger.debug(tag+pageVo);
        UnifiedExceptionHandler.method= tag+"selectRolesPage=============================="+pageVo;
        responseMessage = roleService.selectRolesPage(pageVo);
        return responseMessage;
    }





}
