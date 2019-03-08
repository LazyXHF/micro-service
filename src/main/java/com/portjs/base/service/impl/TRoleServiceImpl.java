package com.portjs.base.service.impl;

import com.portjs.base.dao.TRoleMapper;
import com.portjs.base.dao.TRoleMenuMapper;
import com.portjs.base.dao.TUserRoleMapper;
import com.portjs.base.entity.*;
import com.portjs.base.service.TRoleService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import com.portjs.base.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 角色实现类
 */
@Transactional
@Service
public class TRoleServiceImpl implements TRoleService {

    private ResponseMessage responseMessage;

    @Autowired
    private TUserRoleMapper userRoleMapper;


    @Autowired
    private TRoleMapper roleMapper;

    @Autowired
    private TRoleMenuMapper roleMenuMapper;
    /**
     * 添加角色
     * @param role
     * @return
     */
    @Override
    public ResponseMessage insertRole(TRole role) {
        if (StringUtils.isEmpty(role.getRoleName())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        List<TRole> roles = selectRoleByName(role.getRoleName());
        if (!CollectionUtils.isEmpty(roles)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"角色已存在");
            return responseMessage;
        }
        int maxSort = roleMapper.selectMaxSort();
        role.setId(UUID.randomUUID().toString());
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        role.setSort(maxSort);
        int i =roleMapper.insert(role);

        if (i<0){
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "添加失败");

        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"添加成功");
        }
        return responseMessage;
    }


    /**
     * 批量删除角色
     * @param arrayVO
     * @return
     */
    @Override
    public ResponseMessage deleteRoleByRid(ArrayVO arrayVO) {
        List<String> rid = arrayVO.getList();
        for (int i=0;i<rid.size();i++){
            if (!CollectionUtils.isEmpty(selectUserRoleByRid(rid.get(i)))){
                responseMessage = new ResponseMessage(Code.CODE_OK,"删除失败,此角色下存在用户");
            }else {
                roleMapper.deleteByPrimaryKey(rid.get(i));
                responseMessage = new ResponseMessage(Code.CODE_OK,"删除成功");
            }
        }
        return responseMessage;
    }

    /**
     * 修改角色
     * @param tRole
     * @return
     */
    @Override
    public ResponseMessage updateRoleById(TRole tRole) {
        if (StringUtils.isEmpty(tRole.getRoleName())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        List<TRole> roles =selectRoleByName(tRole.getRoleName());
        if (!CollectionUtils.isEmpty(roles)){
            if (!roles.get(0).getId().equals(tRole.getId())){
                responseMessage = new ResponseMessage(Code.CODE_ERROR,"角色已存在");
                return responseMessage;
            }
        }

        tRole.setUpdateTime(new Date());
        int i = roleMapper.updateByPrimaryKeySelective(tRole);
        if (i<0){
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "修改失败");

        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        }
        return responseMessage;
    }

    /**
     * 根据角色名和状态查找角色
     * @param pageVo
     * @return
     */
    @Override
    public ResponseMessage selectRolesPage(PageVo pageVo) {
        Page<TRole> rolePage  = new Page<>();
//        if (StringUtils.isEmpty(pageVo.getObject())){
//            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
//            return responseMessage;
//        }
        rolePage.init(roleMapper.selectRoleByRoleNameCount(pageVo.getObject()),pageVo.getPageNo(),pageVo.getPageSize());

        List<TRole> roles = roleMapper.selectRoleByRoleName(pageVo.getObject(),rolePage.getRowNum(),rolePage.getPageCount());
        rolePage.setList(roles);
        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",rolePage);
        return responseMessage;
    }


    /**
     * 设置权限
     */
    @Override
    public ResponseMessage insertPremiter(ArrayVO arrayVO) {

        String rid = arrayVO.getObject();
        List<String>  mid = arrayVO.getList();
        TRoleMenuExample example = new TRoleMenuExample();
        TRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(rid);
        roleMenuMapper.deleteByExample(example);
        for (int i=0;i<mid.size();i++){
            TRoleMenu roleMenu = new TRoleMenu();
            roleMenu.setId(UUID.randomUUID().toString());
            roleMenu.setRoleId(rid);
            roleMenu.setMenuId(mid.get(i));
            roleMenuMapper.insert(roleMenu);
        }
        responseMessage = new ResponseMessage(Code.CODE_OK,"授权成功");
        return responseMessage;
    }


    public List<TRole>  selectRoleByName(String name){
        TRoleExample example = new TRoleExample();
        TRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleNameEqualTo(name);
        List<TRole> tRoles = roleMapper.selectByExample(example);
        return tRoles;
    }

    //根据角色id判断此角色下是否存在用户
    public List<TUserRole> selectUserRoleByRid(String rid){
        TUserRoleExample example = new TUserRoleExample();
        TUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(rid);
        List<TUserRole> tUserRoles = userRoleMapper.selectByExample(example);
        return tUserRoles;
    }



}
