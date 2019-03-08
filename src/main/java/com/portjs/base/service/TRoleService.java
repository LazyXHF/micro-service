package com.portjs.base.service;

import com.portjs.base.entity.TRole;
import com.portjs.base.util.Response;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.ArrayVO;
import com.portjs.base.vo.PageVo;


/**
 * 角色接口
 */
public interface TRoleService {

    /**
     * 添加角色
     * @param role
     * @return
     */
    ResponseMessage insertRole(TRole role);

    /**
     * 批量删除角色
     * @param arrayVO
     * @return
     */
    ResponseMessage deleteRoleByRid(ArrayVO arrayVO);


    /**
     * 修改角色
     * @param tRole
     * @return
     */
    ResponseMessage updateRoleById(TRole tRole);


    /**
     * 根据角色名和状态查找角色
     * @param pageVo
     * @return
     */
    ResponseMessage selectRolesPage(PageVo pageVo);


    /**
     * 设置权限
     */

    ResponseMessage insertPremiter(ArrayVO arrayVO);

}
