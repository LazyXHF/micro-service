package com.portjs.base.service;

import com.portjs.base.entity.TDepartment;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import com.portjs.base.vo.SortVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门接口
 */
public interface TDepartmentService {
    /**
     * 添加部门
     * @param department
     * @return
     */
    ResponseMessage insertDepartment(TDepartment department);

    /**
     * 修改部门
     * @param department
     * @return
     */
    ResponseMessage updateDepartment(TDepartment department);


    /**
     * 删除部门
     * @param id
     * @return
     */
    ResponseMessage deleteDepartmentByDids(String  id);

    /**
     * 查询所有部门  （不是树）
     * @return
     */
    ResponseMessage selectAllDepartmentNoTree();


    /***
     * 查询所有部门树
     * @return
     */
    ResponseMessage selectAllDepartmentTree(String name);


    /**
     * 部门排序
     */

    ResponseMessage sortDepartment(List<SortVo> sortVos);

    /**
     * 查询所有部门
     * @return
     */
    List<TDepartment> findAllDepartment();
}
