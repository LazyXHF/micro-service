package com.portjs.base.dao;

import com.portjs.base.entity.TMenuResource;
import com.portjs.base.entity.TMenuResourceExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TMenuResourceMapper {
    int countByExample(TMenuResourceExample example);

    int deleteByExample(TMenuResourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(TMenuResource record);

    int insertSelective(TMenuResource record);

    List<TMenuResource> selectByExample(TMenuResourceExample example);

    TMenuResource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TMenuResource record, @Param("example") TMenuResourceExample example);

    int updateByExample(@Param("record") TMenuResource record, @Param("example") TMenuResourceExample example);

    int updateByPrimaryKeySelective(TMenuResource record);

    int updateByPrimaryKey(TMenuResource record);


    //获取所有的资源   1
    List<TMenuResource> getAllResource();

    //获取菜单或资源的最大值
    int getSortMax();


    //根据角色id查找菜单
    List<TMenuResource> selectMenusRis(@Param("rids") List<String> rids);

    //根据角色id查找资源
    List<TMenuResource> selectResourcesRis(@Param("rids") List<String> rids);


    //根据角色id查找资源和菜单
    List<TMenuResource> selectMenusResourcesRis(@Param("rids") List<String> rids);



    //根据菜单获得资源
    List<TMenuResource> selectMenusResourcesByMenuId(@Param("menuId") String menuId,@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    int selectMenusResourcesByMenuIdCount(@Param("menuId") String menuId);

    //获得所有的菜单
    List<TMenuResource>  selectMenuTree();



    int updateSort(@Param("sort")int sort,@Param("id")String id);

    List<TMenuResource> selectMenuAndResource();


}