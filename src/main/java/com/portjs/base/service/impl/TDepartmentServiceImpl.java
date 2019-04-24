package com.portjs.base.service.impl;

import com.portjs.base.dao.TDepartmentMapper;
import com.portjs.base.dao.TUserMapper;
import com.portjs.base.entity.*;
import com.portjs.base.service.TDepartmentService;
import com.portjs.base.util.Code;
import com.portjs.base.util.IDUtils;
import com.portjs.base.util.Pinyin4jUtil;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.DepartmentTree;
import com.portjs.base.vo.SortVo;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门实现类
 */
@Service
@Transactional
public class TDepartmentServiceImpl implements TDepartmentService {

    @Autowired
    private TDepartmentMapper departmentMapper;


    private ResponseMessage responseMessage;


    @Autowired
    private TUserMapper userMapper;
    /**
     * 添加部门
     * @param department
     * @return
     */
    @Override
    public ResponseMessage insertDepartment(TDepartment department) {
        String departmentName = department.getName();
        String parentId = department.getParentId();
        if (StringUtils.isEmpty(departmentName)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        List<TDepartment> department1 = selectDepartmentParentAndName(parentId,departmentName);
        if (!CollectionUtils.isEmpty(department1)){
            return  responseMessage = new ResponseMessage(Code.CODE_ERROR,"部门已存在");
        }

        //判断当前部门是否已经存在
        if (StringUtils.isEmpty(parentId)){
            parentId = "1";
            List<TDepartment> department2 = selectDepartmentParentAndName(parentId,departmentName);
            if (!CollectionUtils.isEmpty(department2)){
                return  responseMessage = new ResponseMessage(Code.CODE_ERROR,"部门已存在");
            }
            department.setParentId("1");
            department.setLeafFlag(1);

        }else {
            List<TDepartment> departments = selectDepartmentByParent(parentId);
            //判断是否改变主节点状态
            TDepartment department2 = departmentMapper.selectByPrimaryKey(parentId);
            if (CollectionUtils.isEmpty(departments)){
                updateLeafByDepartentId(department2,department2.getLeafFlag());
            }
            department.setLeafFlag(1);
        }
        department.setId(String.valueOf(IDUtils.genItemId()));
        department.setCreatetime(new Date());
        department.setSort(departmentMapper.selectSortMax());

        department.setPingyin(Pinyin4jUtil.converterToFirstSpell(department.getName()));
        int i = departmentMapper.insert(department);
        if (i<0){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"添加失败");
        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK, "添加成功");
        }

        return responseMessage;
    }

    /**
     * 修改部门
     * @param department
     * @return
     */
    @Override
    public ResponseMessage updateDepartment(TDepartment department) {
        if (StringUtils.isEmpty(department.getId()) ||
//                StringUtils.isEmpty(department.getParentId())||
                StringUtils.isEmpty(department.getName())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        //根据parent当前部门是否存在
        if (StringUtils.isEmpty(department.getParentId())){
            department.setParentId("1");
        }
        List<TDepartment> departments = selectDepartmentParentAndName(department.getParentId(),department.getName());
        if (!CollectionUtils.isEmpty(departments)) {
            if (!department.getId().equals(departments.get(0).getId())){
                return new ResponseMessage(Code.CODE_ERROR,"部门已存在");
            }
        }

        department.setPingyin(Pinyin4jUtil.converterToFirstSpell(department.getName()));
        departmentMapper.updateByPrimaryKeySelective(department);
        responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        return responseMessage;
    }


    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<TDepartment> findAllDepartment() {
        return departmentMapper.findAllDepartment();
    }





//    @Override
//    public ResponseMessage selectDepartmentUsers(String name) {
//
//        List<TDepartment> departmentTrees = departmentMapper.selectAllDepartmentTree(name);
//
//        //将该部门下的用户加入到部门下
//        for (int i=0;i<departmentTrees.size();i++){
//            List<TUser> users = selectUsersByDepartmentId(departmentTrees.get(i).getId());
//            departmentTrees.get(i).setUserList(users);
//        }
//        DepartmentTree departmentTree = new DepartmentTree();
//        departmentTree = getDepartmentTree(departmentTrees,departmentTree);
//        if (departmentTree == null){
//            responseMessage = new ResponseMessage(Code.CODE_ERROR,"查询数据为空!");
//        }else {
//            responseMessage = new ResponseMessage(Code.CODE_OK,"查询数据成功!",departmentTree);
//        }
//        return responseMessage;
//    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @Override
    public ResponseMessage deleteDepartmentByDids(String id) {

        if (StringUtils.isEmpty(id)){
            responseMessage  = new ResponseMessage(Code.CODE_ERROR,"id为空");
        }

        TDepartment department = departmentMapper.selectByPrimaryKey(id);
        String parentId = department.getParentId();
        if (department.getLeafFlag().equals(0)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"删除失败,此部门存在子部门");
            return responseMessage;
        }

        List<TUser> users =selectUsersByDepartmentId(id);
        if (!CollectionUtils.isEmpty(users)){
            return  new ResponseMessage(Code.CODE_ERROR,"删除失败,该部门下存在用户");
        }
        int i = departmentMapper.deleteByPrimaryKey(id);
        if (i>0){
            responseMessage = new ResponseMessage(Code.CODE_OK,"删除成功");
        }

        //查看父接节点是否存在字节节点
        List<TDepartment> departments = selectDepartmentByParent(parentId);
        TDepartment departments1 = departmentMapper.selectByPrimaryKey(parentId);
        if (CollectionUtils.isEmpty(departments)){
            updateLeafByDepartentId(departments1,departments1.getLeafFlag());
        }

        return responseMessage;
    }

    /**
     * 查询所有部门  （不是树）
     * @return
     */
    @Override
    public ResponseMessage selectAllDepartmentNoTree() {

        List<TDepartment> departments = departmentMapper.selectAllDepartment();
       responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",departments);
        return responseMessage;
    }

    /***
     * 查询所有部门树
     * @return
     */
    @Override
            public ResponseMessage selectAllDepartmentTree(String name) {
        List<TDepartment> departmentTrees = departmentMapper.selectAllDepartmentTree(name);

        //将该部门下的用户加入到部门下
        for (int i=0;i<departmentTrees.size();i++){
            List<TUser> users = userMapper.selectUserByUD(departmentTrees.get(i).getId());
            departmentTrees.get(i).setUserList(users);
        }
        DepartmentTree departmentTree = new DepartmentTree();
        departmentTree = getDepartmentTree(departmentTrees,departmentTree);
        if (departmentTree == null){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"查询数据为空!");
        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"查询数据成功!",departmentTree);
        }
        return responseMessage;
    }

    /**
     * 部门排序
     */
    @Override
    public ResponseMessage sortDepartment(List<SortVo> sortVos) {
        if (CollectionUtils.isEmpty(sortVos)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        for (int i=0;i<sortVos.size();i++){
            departmentMapper.SortDepartment(sortVos.get(i).getSort(),sortVos.get(i).getId());
        }

        responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        return responseMessage;
    }


    //根据name和parentId查询部门
    public List<TDepartment> selectDepartmentParentAndName(String parent,String name){
        TDepartmentExample example = new TDepartmentExample();
        TDepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parent);
        criteria.andNameEqualTo(name);
        List<TDepartment> departments = departmentMapper.selectByExample(example);
        return departments;
    }


    //根据parentId查询部门
    public List<TDepartment> selectDepartmentByParent(String parentId){
        TDepartmentExample example = new TDepartmentExample();
        TDepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TDepartment> departments = departmentMapper.selectByExample(example);
        return departments;
    }

    //改变叶子的状态
    public void updateLeafByDepartentId(TDepartment department, int leaf){
        if (leaf == 0){
            leaf = 1;
        }else {
            leaf = 0;
        }
       department.setLeafFlag(leaf);
        departmentMapper.updateByPrimaryKeySelective(department);
    }


    public List<TUser> selectUsersByDepartmentId(String did){
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andDepartmentIdEqualTo(did);
        List<TUser> users = userMapper.selectByExample(example);
        return users;
    }


    //获得指标树内部方法
    private DepartmentTree getDepartmentTree(List<TDepartment> departments, DepartmentTree departmentTree) {
        Map<String, DepartmentTree> departmentTreeMap = new LinkedHashMap<>();

        for (TDepartment department : departments) {
            departmentTreeMap.put(department.getId(), new DepartmentTree(department));
        }
        for (Map.Entry<String, DepartmentTree> entry : departmentTreeMap.entrySet()) {
            if (!StringUtil.isNullOrEmpty(entry.getValue().getParent_id())) {
                departmentTreeMap.get(entry.getValue().getParent_id()).getChildren().add(entry.getValue());
            } else {
                departmentTree = entry.getValue();
            }
        }
//

        return departmentTree;
    }


}
