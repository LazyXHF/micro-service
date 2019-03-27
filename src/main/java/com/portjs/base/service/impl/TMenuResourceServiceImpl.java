package com.portjs.base.service.impl;

import com.portjs.base.dao.TMenuResourceMapper;
import com.portjs.base.entity.TMenuResource;
import com.portjs.base.entity.TMenuResourceExample;
import com.portjs.base.service.TMenuResourceService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.*;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Transactional
@Service
public class TMenuResourceServiceImpl implements TMenuResourceService {


    private ResponseMessage responseMessage;
    @Autowired
    private TMenuResourceMapper menuResourceMapper;
    /**
     * 得到所有的资源
     * @return
     */
    @Override
    public List<TMenuResource> getAllMenuResource() {
        List<TMenuResource> resourceMappers = menuResourceMapper.getAllResource();

        return resourceMappers;
    }


    /**
     * 添加菜单或者资源
     * @param menuResource
     * @return
     */
    @Override
    public ResponseMessage insertTMenuResource(TMenuResource menuResource) {
        if (StringUtils.isEmpty(menuResource.getName())||menuResource.getName().equals("菜单树")){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        Integer isResourceMenu = menuResource.getResourceMenu();
        //0为菜单 ， 1为资源
        menuResource.setId(UUID.randomUUID().toString());
        menuResource.setSort(menuResourceMapper.getSortMax());
        menuResource.setCreateTime(new Date());
        menuResource.setUpdateTime(new Date());
        if (isResourceMenu ==0){
            List<TMenuResource> menuResources = selectMenuResourceByNameAndParentId(menuResource.getName(),menuResource.getParentId());
            if (!CollectionUtils.isEmpty(menuResources)){
                return  responseMessage = new ResponseMessage(Code.CODE_ERROR,"菜单已存在");
            }

            //判断是否存在在子节点
            if (StringUtils.isEmpty(menuResource.getParentId())){
                menuResource.setParentId("1");
                menuResource.setLeaf(1);
            }else{
                //判断前父节点是否存在子节点
                List<TMenuResource> menuResourceParent = selectMenuResourceByParentId(menuResource.getParentId());
                    if (CollectionUtils.isEmpty(menuResourceParent)){
                        //改变父节点叶子的状态
                        TMenuResource menuResource1 = menuResourceMapper.selectByPrimaryKey(menuResource.getParentId());
                        updateLeafByMenuId(menuResource1,menuResource1.getLeaf());
                    }
                    menuResource.setLeaf(1);
            }
        }else {
            menuResource.setLeaf(1);
            //进行对资源的一系列判断
            if (StringUtils.isEmpty(menuResource.getPath())|| StringUtils.isEmpty(menuResource.getResourceKey())){
                responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
                return responseMessage;
            }

            List<TMenuResource> menuResourcePath = selectResourcePathByParentId(menuResource.getPath(),menuResource.getMenuId());
            if (!CollectionUtils.isEmpty(menuResourcePath)){
                return  responseMessage = new ResponseMessage(Code.CODE_ERROR,"资源地址已存在");
            }

            List<TMenuResource> menuResourceResourceKey = selectResourceKeyByParentId(menuResource.getResourceKey());
            if (!CollectionUtils.isEmpty(menuResourceResourceKey)){
                return  responseMessage = new ResponseMessage(Code.CODE_ERROR,"资源值已存在");
            }
        }
        int  i = menuResourceMapper.insert(menuResource);
        if (i<0){
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "添加失败");

        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"添加成功");
        }

        return responseMessage;
    }


    /**
     * 删除资源或则菜单
     */
    @Override
    public ResponseMessage deleteTMenuResource(ArrayVO arrayVO) {
        if(CollectionUtils.isEmpty(arrayVO.getList())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }


        for (int j=0;j<arrayVO.getList().size();j++) {
            TMenuResource menuResource = menuResourceMapper.selectByPrimaryKey(arrayVO.getList().get(j));
            if (menuResource.getResourceMenu() == 0) {
                //判断是否存在子菜单
                if (menuResource.getLeaf() == 0) {
                    responseMessage = new ResponseMessage(Code.CODE_ERROR, "删除失败,存在子菜单");
                    return responseMessage;
                }

                    int i = menuResourceMapper.deleteByPrimaryKey(arrayVO.getList().get(j));
                if (i <= 0) {
                    responseMessage = new ResponseMessage(Code.CODE_ERROR, "删除失败");
                } else {
                    responseMessage = new ResponseMessage(Code.CODE_OK, "删除成功");
                }
                //判断前父节点是否存在子节点
                List<TMenuResource> menuResourceParent = selectMenuResourceByParentId(menuResource.getParentId());
                TMenuResource menuResourceFu = menuResourceMapper.selectByPrimaryKey(menuResource.getParentId());

                if (CollectionUtils.isEmpty(menuResourceParent)) {
                    updateLeafByMenuId(menuResourceFu, menuResourceFu.getLeaf());
                }

            } else {
                int i = menuResourceMapper.deleteByPrimaryKey(arrayVO.getList().get(j));
                if (i <= 0) {
                    responseMessage = new ResponseMessage(Code.CODE_ERROR, "删除失败");
                } else {
                    responseMessage = new ResponseMessage(Code.CODE_OK, "删除成功");
                }
            }
        }


        return responseMessage;
    }


    /**
     * 修改菜单或则资源
     * @param menuResource
     * @return
     */
    @Override
    public ResponseMessage updateTMenuResource(TMenuResource menuResource) {

        Integer isResourceMenu = menuResource.getResourceMenu();
        if (isResourceMenu ==0){
            List<TMenuResource> menuResources = selectMenuResourceByNameAndParentId(menuResource.getName(),menuResource.getParentId());
            if (!CollectionUtils.isEmpty(menuResources)) {
                if (!menuResource.getId().equals(menuResources.get(0).getId())){
                    return responseMessage = new ResponseMessage(Code.CODE_ERROR, "菜单已存在");
                }
            }

        }else {
            //进行对资源的一系列判断
            if (StringUtils.isEmpty(menuResource.getPath())|| StringUtils.isEmpty(menuResource.getResourceKey())){
                responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
                return responseMessage;
            }

            List<TMenuResource> menuResourcePath = selectResourcePathByParentId(menuResource.getPath(),menuResource.getMenuId());
            if (!CollectionUtils.isEmpty(menuResourcePath)){
                if (!menuResource.getId().equals(menuResourcePath.get(0).getId()))
                return  responseMessage = new ResponseMessage(Code.CODE_ERROR,"资源地址已存在");
            }

            List<TMenuResource> menuResourceResourceKey = selectResourceKeyByParentId(menuResource.getResourceKey());
            if (!CollectionUtils.isEmpty(menuResourceResourceKey)){
                if (!menuResourceResourceKey.get(0).getId().equals(menuResource.getId()))
                return  responseMessage = new ResponseMessage(Code.CODE_ERROR,"资源值已存在");
            }
        }

        int i = menuResourceMapper.updateByPrimaryKeySelective(menuResource);
        if (i<0){
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "修改失败");

        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        }
        return responseMessage;
    }

    /**
     * 根据角色的id查找菜单和资源     （登录时）
     * @param roles
     * @return
     */
    @Override
    public ResponseMessage selectMenuAndResourceByRoles(List<String> roles) {
        if (CollectionUtils.isEmpty(roles)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        List<TMenuResource> menus = menuResourceMapper.selectMenusRis(roles);
        if (CollectionUtils.isEmpty(menus)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"菜单获取有误");
            return responseMessage;
        }
        MenuResourceTree menuResourceTree = new MenuResourceTree();
        menuResourceTree = getMenuResourceTree(menus,menuResourceTree);

        List<TMenuResource> resources = menuResourceMapper.selectResourcesRis(roles);

        MenuResourceVO menuResourceVO = new MenuResourceVO();
        menuResourceVO.setResourceTree(menuResourceTree);
        menuResourceVO.setResources(resources);

        responseMessage = new ResponseMessage(Code.CODE_OK,"获取成功",menuResourceVO);
        return responseMessage;
    }

    /**
     * 根据角色的id查找菜单和资源     （设置权限时）
     */
    @Override
    public ResponseMessage selectMenuAndResourceTreeByRoles(List<String> roles) {
        if (CollectionUtils.isEmpty(roles)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }

        List<TMenuResource> menuResources = menuResourceMapper.selectMenusResourcesRis(roles);
        if (CollectionUtils.isEmpty(menuResources)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"菜单获取有误");
            return responseMessage;
        }

        MenuResourceTree menuResourceTree = new MenuResourceTree();
        menuResourceTree = getMenuResourceTree(menuResources,menuResourceTree);

        responseMessage = new ResponseMessage(Code.CODE_OK,"获取成功",menuResourceTree);



        return responseMessage;
    }

    @Override
    public ResponseMessage selectMenusResourcesByMenuId(PageVo page) {
        Page<TMenuResource> menuResourcePage = new Page<>();
        if (StringUtils.isEmpty(page.getObject())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        menuResourcePage.init(menuResourceMapper.selectMenusResourcesByMenuIdCount(page.getObject()),page.getPageNo(),page.getPageSize());
        List<TMenuResource> resources = menuResourceMapper.selectMenusResourcesByMenuId(page.getObject(),menuResourcePage.getRowNum(),menuResourcePage.getPageCount());

        menuResourcePage.setList(resources);
        if (CollectionUtils.isEmpty(resources)){
            responseMessage = new ResponseMessage(Code.CODE_OK,"无数据");
            return responseMessage;
        }
        responseMessage = new ResponseMessage(Code.CODE_OK,"获取成功",menuResourcePage);
        return responseMessage;
    }

    @Override
    public ResponseMessage selectMenusTree() {
        List<TMenuResource> menuResources = menuResourceMapper.selectMenuTree();
        if (CollectionUtils.isEmpty(menuResources)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"菜单获取有误");
            return responseMessage;
        }
        MenuResourceTree menuResourceTree = new MenuResourceTree();
        menuResourceTree = getMenuResourceTree(menuResources,menuResourceTree);

        responseMessage = new ResponseMessage(Code.CODE_OK,"获取成功",menuResourceTree);

        return responseMessage;
    }


    /**
     * 排序
     * @param sortVos
     * @return
     */
    @Override
    public ResponseMessage UpdateSort(List<SortVo> sortVos) {
        if (CollectionUtils.isEmpty(sortVos)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        for (int i=0;i<sortVos.size();i++){
           menuResourceMapper.updateSort(sortVos.get(i).getSort(),sortVos.get(i).getId());
        }

        responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        return responseMessage;
    }


    /**
     * 获得所有的菜单树
     * @return
     */
    @Override
    public ResponseMessage selectMenuAndResource() {
        List<TMenuResource> menuResources = menuResourceMapper.selectMenuAndResource();

        MenuResourceTree menuResourceTree = new MenuResourceTree();
        menuResourceTree = getMenuResourceTree(menuResources,menuResourceTree);

        responseMessage = new ResponseMessage(Code.CODE_OK,"获取成功",menuResourceTree);
        return responseMessage;
    }


    /**
     *  查询用户的首页菜单
     * @param arrayVO
     * @return
     */
    @Override
    public ResponseMessage selectHomePageMenuByRids(ArrayVO arrayVO) {
        if (CollectionUtils.isEmpty(arrayVO.getList())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数为空");
        }else {
            List<TMenuResource> menuResources = menuResourceMapper.selectHomePageMenuByRids(arrayVO.getList());
            responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",menuResources);
        }

        return responseMessage;
    }


    //改变叶子的状态
    public void updateLeafByMenuId(TMenuResource resource,int leaf){
        if (leaf == 0){
            leaf = 1;
        }else {
            leaf = 0;
        }
        resource.setLeaf(leaf);
        menuResourceMapper.updateByPrimaryKeySelective(resource);
    }

    //判断是否存在菜单
    public List<TMenuResource> selectMenuResourceByNameAndParentId(String name,String parentId){
        TMenuResourceExample example = new TMenuResourceExample();
        TMenuResourceExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andParentIdEqualTo(parentId);
        List<TMenuResource> menuResources= menuResourceMapper.selectByExample(example);
        return menuResources;
    }


    //判断当前父节点是否存在子节点
    public List<TMenuResource> selectMenuResourceByParentId(String parentId){
        TMenuResourceExample example = new TMenuResourceExample();
        TMenuResourceExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TMenuResource> menuResources= menuResourceMapper.selectByExample(example);
        return menuResources;
    }

    //判断当前path是否存在
    public List<TMenuResource> selectResourcePathByParentId(String path,String menuId){
        TMenuResourceExample example = new TMenuResourceExample();
        TMenuResourceExample.Criteria criteria = example.createCriteria();
        criteria.andPathEqualTo(path);
        criteria.andMenuIdEqualTo(menuId);
        List<TMenuResource> menuResources= menuResourceMapper.selectByExample(example);
        return menuResources;
    }

    //判断当前resourceKey是否存在
    public List<TMenuResource> selectResourceKeyByParentId(String resourceKey){
        TMenuResourceExample example = new TMenuResourceExample();
        TMenuResourceExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(resourceKey);
        List<TMenuResource> menuResources= menuResourceMapper.selectByExample(example);
        return menuResources;
    }




    //    //获得指标树内部方法
    private MenuResourceTree getMenuResourceTree(List<TMenuResource> menuResources, MenuResourceTree menuResourceTree) {
        Map<String, MenuResourceTree> menuResourceTreeMap = new LinkedHashMap<>();

        for (TMenuResource menuResource : menuResources) {
            menuResourceTreeMap.put(menuResource.getId(), new MenuResourceTree(menuResource));
        }
        for (Map.Entry<String, MenuResourceTree> entry : menuResourceTreeMap.entrySet()) {
            if (!StringUtil.isNullOrEmpty(entry.getValue().getParent_id())) {
                menuResourceTreeMap.get(entry.getValue().getParent_id()).getChildren().add(entry.getValue());
            } else {
                menuResourceTree = entry.getValue();
            }
        }
//

        return menuResourceTree;
    }

}
