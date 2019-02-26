package com.project.mgt.service;

import com.project.mgt.entity.TXietongMenuResource;
import com.project.mgt.util.ResponseMessage;
import com.project.mgt.vo.BRVO;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TXietongMenuResourceService {

    List<TXietongMenuResource> getAllMenuResource();


    /**
     * 分页查取某菜单按钮下的资源
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    ResponseMessage selectMenuResourcesByMenuButtonName(String name, int pageNo, int pageSize);


    /**
     * 添加一个菜单资源
     * @param brvo
     * @return
     */
    ResponseMessage insertMenuResource(BRVO brvo);


    /**
     * 根据资源id修改资源*/

    ResponseMessage updateMenuResource(TXietongMenuResource menuResource);


    /**
     * 删除一个资源
     * @param id
     * @return
     */
    ResponseMessage deleteResource(String id);

    /**
     * 根据角色名获取对应的权限资源
     * @param rname
     * @return
     */
    ResponseMessage selectMenuResourceByRoleName(String rname);

    /**
     * 获得所有的资源
     */
    ResponseMessage selectAllMenuResource(int pageNo, int pageSize);


    /**
     * 根据按钮id查询该按钮下的所有资源
     * @param bid
     * @return
     */
    ResponseMessage selectMenuResourceByButtonId(String bid);


    /**
     * 根据path得资源
     * @param path
     * @return
     */
    ResponseMessage selectMenuResourceByPath(String path, String rid);




//    ------------------------------------------一人多角色

    /**
     * 多个角色查询资源
     * @param rids
     * @return
     */
    ResponseMessage selectMenuResourceByRoleIds(List<String> rids);
}
