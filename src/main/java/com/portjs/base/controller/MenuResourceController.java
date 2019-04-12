package com.portjs.base.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.dao.TRoleMenuMapper;
import com.portjs.base.entity.TMenuResource;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.TMenuResourceService;
import com.portjs.base.service.TRoleService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import com.portjs.base.vo.PageVo;
import com.portjs.base.vo.SortVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu-resource")
public class MenuResourceController extends BaseController {
    static final String tag = "MenuResourceController======>";


    private ResponseMessage responseMessage;

    @Autowired
    private TMenuResourceService menuResourceService;

    @Autowired
    private TRoleService roleService;

    @LogInfo(methodName = "添加菜单或者资源",modelName = "菜单资源")
    @RequestMapping("insert-menu-resource")
    @ResponseBody
    public ResponseMessage insertTMenuResource(@RequestBody TMenuResource menuResource){
        //统一异常拦截
        logger.debug(tag+menuResource);
        UnifiedExceptionHandler.method= tag+"insertTMenuResource=============================="+menuResource;
        responseMessage = menuResourceService.insertTMenuResource(menuResource);
        return responseMessage;
    }

    @LogInfo(methodName = "删除资源或则菜单",modelName = "菜单资源")
    @RequestMapping("delete-menu-resource")
    @ResponseBody
    public ResponseMessage deleteTMenuResource(@RequestBody ArrayVO arrayVO){
        //统一异常拦截
        logger.debug(tag+arrayVO);
        UnifiedExceptionHandler.method= tag+"deleteTMenuResource=============================="+arrayVO;
//        JSONObject jsonObject = JSON.parseObject(arrayVO);
//        String id = jsonObject.getString("id");
        responseMessage = menuResourceService.deleteTMenuResource(arrayVO);
        return responseMessage;
    }


    @LogInfo(methodName = "修改菜单或则资源",modelName = "菜单资源")
    @RequestMapping("update-menu-resource")
    @ResponseBody
    public ResponseMessage updateTMenuResource(@RequestBody TMenuResource menuResource){
        //统一异常拦截
        logger.debug(tag+menuResource);
        UnifiedExceptionHandler.method= tag+"updateTMenuResource=============================="+menuResource;
        responseMessage = menuResourceService.updateTMenuResource(menuResource);
        return responseMessage;
    }

    @LogInfo(methodName = "根据角色的id查找菜单和资源",modelName = "菜单资源")
    @RequestMapping("select-menu-resource-roles")
    @ResponseBody
    public ResponseMessage selectMenuAndResourceByRoles(@RequestBody ArrayVO arrayVO){
        //统一异常拦截
        logger.debug(tag+arrayVO);
        UnifiedExceptionHandler.method= tag+"selectMenuAndResourceByRoles=============================="+arrayVO;
        responseMessage = menuResourceService.selectMenuAndResourceByRoles(arrayVO.getList());
        return responseMessage;
    }


    @LogInfo(methodName = "根据角色的id查找菜单和资源（设置权限时）",modelName = "菜单资源")
    @RequestMapping("select-menu-resource-tree-roles")
    @ResponseBody
    public ResponseMessage selectMenuAndResourceTreeByRoles(@RequestBody ArrayVO arrayVO){
        //统一异常拦截
        logger.debug(tag+arrayVO);
        UnifiedExceptionHandler.method= tag+"selectMenuAndResourceByRoles=============================="+arrayVO;
        responseMessage = menuResourceService.selectMenuAndResourceTreeByRoles(arrayVO.getList());
        return responseMessage;
    }



   @LogInfo(methodName = "根据菜单获得资源",modelName = "菜单资源")
    @RequestMapping("select-menus-resources-menu-id")
    @ResponseBody
    public ResponseMessage selectMenusResourcesByMenuId(@RequestBody PageVo pageVo){
        //统一异常拦截
        logger.debug(tag+pageVo);
        UnifiedExceptionHandler.method= tag+"selectMenusResourcesByMenuId=============================="+pageVo;
        responseMessage = menuResourceService.selectMenusResourcesByMenuId(pageVo);
        return responseMessage;
    }




    @LogInfo(methodName = "获取所有的菜单树",modelName = "菜单资源")
    @RequestMapping("select-menus-tree")
    @ResponseBody
    public ResponseMessage selectMenusTree(){
        //统一异常拦截
        logger.debug(tag);
        UnifiedExceptionHandler.method= tag+"selectMenusTree==============================";
        responseMessage = menuResourceService.selectMenusTree();
        return responseMessage;
    }




    /**
     * 菜单排序
     * @param list
     * @return
     */
    @LogInfo(methodName = "菜单排序",modelName = "菜单模块")
    @RequestMapping("sort-menu")
    @ResponseBody
    public ResponseMessage sortUser(@RequestBody List<SortVo> list){
        logger.debug(tag+list);
        UnifiedExceptionHandler.method= tag+"sortUser=============================="+list;
        responseMessage =menuResourceService.UpdateSort(list);
        return responseMessage;
    }




    /**
     * 获得所有的菜单树
     * @param
     * @return
     */
    @LogInfo(methodName = "获得所有的菜单树",modelName = "菜单模块")
    @RequestMapping("select-menu")
    @ResponseBody
    public ResponseMessage selectMenu(){
        logger.debug(tag);
        UnifiedExceptionHandler.method= tag+"selectMenu==============================" ;
        responseMessage =menuResourceService.selectMenuAndResource();
        return responseMessage;
    }



    /**
     * 设置权限
     * @param
     * @return
     */
    @LogInfo(methodName = "设置权限",modelName = "菜单模块")
    @RequestMapping("insert-permit")
    @ResponseBody
    public ResponseMessage selectMenu(@RequestBody ArrayVO arrayVO){
        logger.debug(tag+arrayVO);
        UnifiedExceptionHandler.method= tag+"selectMenu=============================="+arrayVO ;
        responseMessage =roleService.insertPremiter(arrayVO);
        return responseMessage;
    }


    /**
     * 查询用户的首页菜单
     * @param
     * @return
     */
    @LogInfo(methodName = "查询用户的首页菜单",modelName = "菜单模块")
    @RequestMapping("select-page-home")
    @ResponseBody
    public ResponseMessage selectHomePageMenuByRids(@RequestBody ArrayVO arrayVO){
        logger.debug(tag+arrayVO);
        UnifiedExceptionHandler.method= tag+"selectHomePageMenuByRids=============================="+arrayVO ;
        responseMessage = menuResourceService.selectHomePageMenuByRids(arrayVO);
        return responseMessage;
    }

}
