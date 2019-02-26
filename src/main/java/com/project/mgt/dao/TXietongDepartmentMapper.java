package com.project.mgt.dao;

import com.project.mgt.entity.TXietongDepartment;
import com.project.mgt.entity.TXietongDepartmentExample;
import com.project.mgt.entity.TXietongDictionary;
import com.project.mgt.entity.TXietongUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TXietongDepartmentMapper {
    int countByExample(TXietongDepartmentExample example);

    int deleteByExample(TXietongDepartmentExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongDepartment record);

    int insertSelective(TXietongDepartment record);

    List<TXietongDepartment> selectByExample(TXietongDepartmentExample example);

    TXietongDepartment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongDepartment record, @Param("example") TXietongDepartmentExample example);

    int updateByExample(@Param("record") TXietongDepartment record, @Param("example") TXietongDepartmentExample example);

    int updateByPrimaryKeySelective(TXietongDepartment record);

    int updateByPrimaryKey(TXietongDepartment record);




    //查询所有部门sort中最大的数据
    int selectMaxSort();

    //根据部门parent_id查找部门
    List<TXietongDepartment> findDepartmentByParentId(String parent_id);

    //查找所有部门 可用的部门
    List<TXietongDepartment> findAllDepartment();

    //根据部门id删除部门
    int deleteDepartmentByName(String Name);


    //根据部门name修改部门名称
    int updateDepartmentNameByName(@Param("newName") String name, @Param("oldName") String oldName);

    //根据部门的name查找部门
    TXietongDepartment selectDepartmentByName(String name);

    //部门排序
    int updateDepartmentSort(@Param("sort") int sort, @Param("name") String name);

    //根据部门的id查找部门
    TXietongDepartment findDepartmentById(String id);

    //根据id修改是否是叶子节点
    int updateLeafById(@Param("id") String id, @Param("leaf") int leaf);

    //查找所有叶子部门
    List<TXietongDepartment> findDepartmentLeaf();


    //一次性将所有的部门tree取出
    List<TXietongDepartment> findDepartmentTree(String name);

    //根据用户id将部门tree取出
    List<TXietongDepartment> findDepartmentTreeByUid(String uid);

    //根据部门id查找该部门下的所有用户(分页)
    List<TXietongUser> findUsersByDepartmentIdPage(@Param("did") String did, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    //根据部门id查找该部门下的所有用户(不分页)
    List<TXietongUser> findUsersByDepartmentId(String did);

    //查询部门下的用户数目
    int countUsersByDepartmentId(String did);


    int deleteDeparmentId(String id);

//    TXietongDepartment selectDepartmentById(String id);

    String selectNameById(String id);


    List<TXietongDictionary> queryDepartMentName();

    //根据LeadId查询部门
    List<TXietongDepartment> findDepartmentByLeadId(String id);

    //根据ViceId查询部门
    List<TXietongDepartment> findDepartmentViceId(String id);


    //模糊查找部门
    List<TXietongDepartment> findDepartmentByNameOrPingyin(String name);




    int updateDepartmentLeader(@Param("id") String id, @Param("leader") String leader);






}