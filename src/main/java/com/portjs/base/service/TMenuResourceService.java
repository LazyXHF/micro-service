package com.portjs.base.service;

import com.portjs.base.entity.TMenuResource;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import com.portjs.base.vo.PageVo;
import com.portjs.base.vo.SortVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface TMenuResourceService {


    /**
     * 得到所有的资源
     */
    List<TMenuResource> getAllMenuResource();




    /**
     * 添加菜单或者资源
     * @param menuResource
     * @return
     */
    ResponseMessage insertTMenuResource(TMenuResource menuResource);


    /**
     * 删除资源或则菜单
     */
    ResponseMessage deleteTMenuResource(ArrayVO id);

    /**
     * 修改菜单或则资源
     * @param menuResource
     * @return
     */
    ResponseMessage updateTMenuResource(TMenuResource menuResource);


    /**
     * 根据角色的id查找菜单和资源     （登录时）
     * @param roles
     * @return
     */
    ResponseMessage selectMenuAndResourceByRoles(List<String> roles);


    /**
     * 根据角色的id查找菜单和资源     （设置权限时）
     */
    ResponseMessage selectMenuAndResourceTreeByRoles(List<String> roles);


    /**
     * 根据菜单获得资源
     * @param page
     * @return
     */
    ResponseMessage selectMenusResourcesByMenuId(PageVo page);



    ResponseMessage selectMenusTree();



    ResponseMessage UpdateSort(List<SortVo> sortVos);


    ResponseMessage selectMenuAndResource();





    /**
     *   首页查询用户的首页菜单
     * @param arrayVO
     * @return
     */
    ResponseMessage selectHomePageMenuByRids(ArrayVO arrayVO);

}
