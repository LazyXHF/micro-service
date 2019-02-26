package com.project.mgt.dao;

import com.project.mgt.entity.TXietongMenuResource;
import com.project.mgt.entity.TXietongMenuResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TXietongMenuResourceMapper {
    int countByExample(TXietongMenuResourceExample example);

    int deleteByExample(TXietongMenuResourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(TXietongMenuResource record);

    int insertSelective(TXietongMenuResource record);

    List<TXietongMenuResource> selectByExample(TXietongMenuResourceExample example);

    TXietongMenuResource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TXietongMenuResource record, @Param("example") TXietongMenuResourceExample example);

    int updateByExample(@Param("record") TXietongMenuResource record, @Param("example") TXietongMenuResourceExample example);

    int updateByPrimaryKeySelective(TXietongMenuResource record);

    int updateByPrimaryKey(TXietongMenuResource record);

    List<TXietongMenuResource> getAllMenuResources();

    //根据按钮获得所需菜单资源
    List<TXietongMenuResource> findMenuResourcesByMenuButtonName(@Param("name") String name, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    //数量
    int countMenuResourcesByMenuButtonName(String name);


    //根据资源url查询是否存在此资源
    TXietongMenuResource findMenuResourcesByUrl(String url);


    List<TXietongMenuResource> findMenuResourcesByIcon(String icon);

    int insertResource(TXietongMenuResource resource);

    int updateResource(@Param("url") String url, @Param("name") String name, @Param("id") String id, @Param("icon") String icon);

    int deleteResource(String id);


    //根据角色名获取对应的权限资源
    List<TXietongMenuResource> findMenuResourceByRoleName(String rname);

    //获取所有菜单资源
    List<TXietongMenuResource> findAllMenuResource(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);


    //根据菜单的id查询此菜单下的资源(不分页)
    List<TXietongMenuResource> findMenuResourceByButtonId(String bid);

    int countMenuResource();


    //根据path得资源
    List<TXietongMenuResource>  findMenuResourceByPath(@Param("path") String path, @Param("rid") String rid);





    //根据角色ids获取对应的权限资源
    List<TXietongMenuResource> findMenuResourceByRoleIds(@Param("rids") List<String> rids);


}