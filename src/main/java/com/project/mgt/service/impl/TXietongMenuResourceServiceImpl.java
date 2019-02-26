package com.project.mgt.service.impl;

import com.project.mgt.dao.TXietongButtonResourceMapper;
import com.project.mgt.dao.TXietongMenuResourceMapper;
import com.project.mgt.dao.TXietongRoleMenuMapper;
import com.project.mgt.entity.TXietongButtonResource;
import com.project.mgt.entity.TXietongMenuButton;
import com.project.mgt.entity.TXietongMenuResource;
import com.project.mgt.entity.TXietongRoleMenu;
import com.project.mgt.service.TXietongMenuResourceService;
import com.project.mgt.util.*;
import com.project.mgt.vo.BRVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, timeout = -1)
public class TXietongMenuResourceServiceImpl implements TXietongMenuResourceService {
    @Autowired
    private TXietongMenuResourceMapper menuResourceMapper;

    @Autowired
    private TXietongButtonResourceMapper buttonResourceMapper;

    @Autowired
    private TXietongRoleMenuMapper roleMenuMapper;
    private ResponseMessage responseMessage = null;
    /**
     * 获得所有权限资源
     * @return
     */
    @Override
    public List<TXietongMenuResource> getAllMenuResource() {
        List<TXietongMenuResource> menuResources = menuResourceMapper.getAllMenuResources();
        return menuResources;
    }


    /**
     * 分页查取某菜单按钮下的资源
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public ResponseMessage selectMenuResourcesByMenuButtonName(String name, int pageNo, int pageSize) {
        if (StringUtils.isEmpty(name)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        Page<TXietongMenuResource> page = new Page<>();
        int totalCount = menuResourceMapper.countMenuResourcesByMenuButtonName(name);
//        System.out.println(totalCount);
        page.init(totalCount,pageNo,pageSize);
//        System.out.println(pageNo);
        List<TXietongMenuResource> roles = menuResourceMapper.findMenuResourcesByMenuButtonName(name,page.getRowNum(), page.getPageCount());
//        System.out.println(roles+"------------------------");
        page.setList(roles);
        if (page == null){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求数据为空");
            return responseMessage;
        }
        responseMessage = new ResponseMessage(Code.CODE_OK,"请求成功",page);
        return responseMessage;
    }




    /**
     * 添加一个菜单按钮资源
     * @param brvo
     * @return
     */
    @Override
    public ResponseMessage insertMenuResource(BRVO brvo) {
        TXietongMenuResource resource = brvo.getMenuResource();
        if (StringUtils.isEmpty(resource.getUrl())||StringUtils.isEmpty(resource.getIcon())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        if (menuResourceMapper.findMenuResourcesByUrl(resource.getUrl())!=null){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"资源地址已存在");
            return responseMessage;
        }
        if (!CollectionUtils.isEmpty(menuResourceMapper.findMenuResourcesByIcon(resource.getIcon()))){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"资源值已存在");
            return responseMessage;
        }
//        if ()
        //得到菜单id
        String bid  = brvo.getBid();
        String reid = String.valueOf(IDUtils.genItemId());
        TXietongButtonResource buttonResource = new TXietongButtonResource();
        buttonResource.setBid(bid);
        buttonResource.setStatus(1);
        buttonResource.setReid(reid);
        resource.setId(reid);
        resource.setIsdelete(1);
        resource.setParentid("1");

        //管理员默认有此菜单
        TXietongRoleMenu roleMenu = new TXietongRoleMenu();
        roleMenu.setRoleId("1");
        roleMenu.setMenuId(reid);
        roleMenu.setStatus(1);
        roleMenuMapper.insert(roleMenu);



        buttonResourceMapper.insert(buttonResource);
        resource.setIsdelete(1);
        menuResourceMapper.insertResource(resource);
        responseMessage = new ResponseMessage(Code.CODE_OK,"添加成功");

//        /11111/11111
//        resource.setKey(resource.getUrl().substring(1,resource.getUrl().indexOf("/",1)));
        return responseMessage;
    }

    /**
     * 根据资源id修改资源*/
    @Override
    public ResponseMessage updateMenuResource(TXietongMenuResource menuResource) {
        if (StringUtils.isEmpty(menuResource.getId())||StringUtils.isEmpty(menuResource.getUrl())||
                StringUtils.isEmpty(menuResource.getName())||StringUtils.isEmpty(menuResource.getIcon())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }

        TXietongMenuResource resource = menuResourceMapper.findMenuResourcesByUrl(menuResource.getUrl());
        if (resource!=null){
            if (!menuResource.getId().equals(resource.getId())){
                responseMessage = new ResponseMessage(Code.CODE_ERROR,"资源地址已存在");
                return responseMessage;
            }
        }

        List<TXietongMenuResource> resource1 = menuResourceMapper.findMenuResourcesByIcon(menuResource.getIcon());
        if (!CollectionUtils.isEmpty(resource1)){
            if (!resource1.get(0).getId().equals(menuResource.getId())){
                responseMessage = new ResponseMessage(Code.CODE_ERROR,"资源值已存在");
                return responseMessage;
            }
        }

        menuResource.setIsdelete(1);
        menuResource.setParentid("1");
        int i =menuResourceMapper.updateResource(menuResource.getUrl(),menuResource.getName(),menuResource.getId(),menuResource.getIcon());
        if (i>=0){
            responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"修改失败");
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage deleteResource(String id) {
        if (StringUtils.isEmpty(id)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        int i = menuResourceMapper.deleteResource(id);
        if (i>0){
            responseMessage = new ResponseMessage(Code.CODE_OK,"删除成功");
        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"删除失败");
        }
        return responseMessage;
    }

    /**
     * 根据角色名获取对应的权限资源
     * @param rname
     * @return
     */
    @Override
    public ResponseMessage selectMenuResourceByRoleName(String rname) {
        if (StringUtils.isEmpty(rname)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }

        List<TXietongMenuResource> menuResources = menuResourceMapper.findMenuResourceByRoleName(rname);
        if (CollectionUtils.isEmpty(menuResources)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求数据为空");
            return responseMessage;
        }

        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",menuResources);
        return responseMessage;
    }


    /**
     * 获得所有的资源
     */
    @Override
    public ResponseMessage selectAllMenuResource(int pageNo, int pageSize) {
        Page<TXietongMenuResource> page = new Page<>();
        int totalCount = menuResourceMapper.countMenuResource();
//            System.out.println(totalCount);
        page.init(totalCount,pageNo,pageSize);
        List<TXietongMenuResource> tXietongMenuResources = menuResourceMapper.findAllMenuResource(page.getRowNum(),page.getPageCount());
        page.setList(tXietongMenuResources);
        if (CollectionUtils.isEmpty(tXietongMenuResources)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求数据为空");
            return responseMessage;
        }

        responseMessage = new ResponseMessage(Code.CODE_OK,"请求成功",page);
        return responseMessage;
    }

    /**
     * 根据按钮id查询该按钮下的所有资源
     * @param bid
     * @return
     */
    @Override
    public ResponseMessage selectMenuResourceByButtonId(String bid) {
        if (StringUtils.isEmpty(bid)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        List<TXietongMenuResource> resources = menuResourceMapper.findMenuResourceByButtonId(bid);
        if (CollectionUtils.isEmpty(resources)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求数据为空");
            return responseMessage;
        }
        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",resources);
        return responseMessage;
    }

    /**
     * 根据path得资源
     * @param path
     * @return
     */
    @Override
    public ResponseMessage selectMenuResourceByPath(String path,String rid) {
        if (StringUtils.isEmpty(path)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        List<TXietongMenuResource> menuResources = menuResourceMapper.findMenuResourceByPath(path,rid);

        if (CollectionUtils.isEmpty(menuResources)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求数据为空");
            return responseMessage;
        }
        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",menuResources);
        return responseMessage;
    }















//    ------------------------------------------一人多角色
    /**
     * 根据角色名获取对应的权限资源
     * @param rids
     * @return
     */
    @Override
    public ResponseMessage selectMenuResourceByRoleIds(List<String> rids) {
        if (CollectionUtils.isEmpty(rids)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }

        List<TXietongMenuResource> menuResources = menuResourceMapper.findMenuResourceByRoleIds(rids);
        if (CollectionUtils.isEmpty(menuResources)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求数据为空");
            return responseMessage;
        }


        Set<TXietongMenuResource> treeSet = new TreeSet<>(new Comparator<TXietongMenuResource>() {
            @Override
            public int compare(TXietongMenuResource o1, TXietongMenuResource o2) {
                int compareTo = o1.getId().compareTo(o2.getId());
                return compareTo;
            }

        });
        treeSet.addAll(menuResources);
        //放入新的list 或者把当前的list进行close
        List<TXietongMenuResource> arrayList = new ArrayList<>(treeSet);
//        for (int i=0;i<arrayList.size();i++){
//            List<TXietongMenuResource> menuResources = resourceMapper.findMenuResourceByButtonId(arrayList.get(i).getId());
//            arrayList.get(i).setMenuResources(menuResources);
//        }
        responseMessage = new ResponseMessage(Code.CODE_OK,"请求成功",arrayList);
        return responseMessage;


    }

}
