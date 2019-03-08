package com.portjs.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.entity.TDepartment;
import com.portjs.base.exception.UnifiedExceptionHandler;
import com.portjs.base.service.TDepartmentService;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.SortVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理
 */
@CrossOrigin
@RequestMapping("department")
@RestController
public class departmentController extends BaseController {

    static final  String tag = "departmentController================>";

    private ResponseMessage responseMessage;

    @Autowired
    private TDepartmentService departmentService;

    /**
     * 添加部门
     * @param department
     * @return
     */
    @LogInfo(methodName = "添加部门",modelName = "部门模块")
    @RequestMapping("insert-department")
    @ResponseBody
    public ResponseMessage insertDepartment(@RequestBody TDepartment department){
        logger.debug(tag+department);
        UnifiedExceptionHandler.method= tag+"insertDepartment=============================="+department;
        responseMessage = departmentService.insertDepartment(department);
        return responseMessage;
    }

    /**
     * 修改部门
     * @param department
     * @return
     */
    @LogInfo(methodName = "修改部门",modelName = "部门模块")
    @RequestMapping("update-department")
    @ResponseBody
    public ResponseMessage updateDepartment(@RequestBody TDepartment department){
        logger.debug(tag+department);
        UnifiedExceptionHandler.method= tag+"updateDepartment=============================="+department;
        responseMessage = departmentService.updateDepartment(department);
        return responseMessage;
    }


    /**
     * 删除部门
     * @param body
     * @return
     */

    @LogInfo(methodName = "删除部门",modelName = "部门模块")
    @RequestMapping("delete-department")
    @ResponseBody
    public ResponseMessage deleteDepartment(@RequestBody String  body){
        logger.debug(tag+body);
        UnifiedExceptionHandler.method= tag+"deleteDepartment=============================="+body;
        JSONObject jsonObject = JSON.parseObject(body);
        String id = jsonObject.getString("id") ;
        responseMessage = departmentService.deleteDepartmentByDids(id);
        return responseMessage;
    }


    /**
     * 查询所有部门  （不是树）
     * @return
     */

    @LogInfo(methodName = "查询所有部门  （不是树）",modelName = "部门模块")
    @RequestMapping("select-department")
    @ResponseBody
    public ResponseMessage selectDepartment(){
        logger.debug(tag);
        UnifiedExceptionHandler.method= tag+"selectDepartment==============================";
        responseMessage = departmentService.selectAllDepartmentNoTree();
        return responseMessage;
    }


    /***
     * 查询所有部门树
     * @return  body
     */

    @LogInfo(methodName = "查询所有部门树",modelName = "部门模块")
    @RequestMapping("select-department-tree")
    @ResponseBody
    public ResponseMessage selectAllDepartmentTree(@RequestBody  String body){
        logger.debug(tag);
        UnifiedExceptionHandler.method= tag+"selectAllDepartmentTree==============================";
        JSONObject jsonObject = JSON.parseObject(body);
        String name = jsonObject.getString("name") ;
        responseMessage = departmentService.selectAllDepartmentTree(name);
        return responseMessage;
    }


    /**
     * 部门分类
     * @param list
     * @return
     */
    @LogInfo(methodName = "部门分类",modelName = "部门模块")
    @RequestMapping("sort-department")
    @ResponseBody
    public ResponseMessage sortUser(@RequestBody List<SortVo> list){
        logger.debug(tag+list);
        UnifiedExceptionHandler.method= tag+"sortUser=============================="+list;
        responseMessage = departmentService.sortDepartment(list);
        return responseMessage;
    }

}
