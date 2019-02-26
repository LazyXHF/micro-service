package com.project.mgt.service.impl;

import com.project.mgt.dao.*;
import com.project.mgt.entity.*;
import com.project.mgt.service.TXietongUserService;
import com.project.mgt.util.*;
import com.project.mgt.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, timeout = -1)
public class TXietongUserServiceImpl implements UserDetailsService, TXietongUserService {

    ResponseMessage responseMessage = null;
    @Autowired
    private TXietongUserMapper userMapper;

    @Autowired
    private TXietongUserRoleMapper userRoleMapper;

    @Autowired
    private TXietongDepartmentMapper departmentMapper;

    @Autowired
    private TXietongRoleMapper roleMapper;

    @Autowired
    private TXietongUserDepartmentsMapper userDepartmentsMapper;

    @Autowired
    private TXietongDictionaryMapper dictionaryMapper;


    /**
     * 根据用户名查询对象，并返回用户信息和角色信息
     * @param login_name
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String login_name){
        TXietongUser user = userMapper.loadUserByUsername(login_name);
//        //根据部门领导id,判断是否是部门负责人
//        TXietongDepartment department = departmentMapper.selectByPrimaryKey(user.getDepartmentid());
//        if (user.getId().equals(department.getLeaderId())){
//            user.setExt4("true");
//        }else {
//            user.setExt4("false");
//        }
//
//        List<TXietongDictionary> dictionaries = selectDictionaryByType("9111");
//        for (int i=0;i<dictionaries.size();i++){
//            if (user.getId().equals(dictionaries.get(i).getMidValue())){
//                user.setExt5("true");
//                return user;
//            }else {
//                user.setExt5("false");
//            }
//        }

//        System.out.println(user);
//        String dids = user.getDepartmentid();
//        String[] did = dids.split(",");
//        for (int i=0;i<did.length;i++){
//
//        }

//        System.out.println(user);
//        if (null == user) {
//            throw new UsernameNotFoundException(login_name + "不存在");
//        }

//        UserRole userRole = new UserRole(user);
//        userRole.setRole(user.getRoles());
//        String departmentName = departmentMapper.selectNameById(user.getDepartmentid());
//        userRole.setDepartmentName(departmentName);
//         UserRole role = roleDao.slelctRoleById(user.getRole_id());
//        ur.setRole(user.);
//        ur.setEnabled("1".equals(String.valueOf(user.getIsdelete())) ? true : false);
//        ur.setEnabled(ur.isEnabled() ? "1".equals(String.valueOf(user.getStatus())) : ur.isEnabled());
        return user;
    }


    //根据type查询
    public List<TXietongDictionary> selectDictionaryByType(String type){
        TXietongDictionaryExample dictionaryExample = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = dictionaryExample.createCriteria();
        criteria.andTypeCodeEqualTo(type);
        List<TXietongDictionary> dictionaries = dictionaryMapper.selectByExample(dictionaryExample);
        return dictionaries;
    }
    /**
     * 添加用户
     * @param urvo
     * @return
     */
    @Override
    public ResponseMessage insertUser(UserRoleDeparmentsVO urvo) {

        TXietongUser user1 = userMapper.selectUserByUserName(urvo.gettXietongUser().getLoginName());
        if (user1!=null){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"用户登录名已存在");
            return responseMessage;
        }
        TXietongUser user = urvo.gettXietongUser();
        if (StringUtils.isEmpty(urvo.getRids())|| StringUtils.isEmpty(user.getDepartmentid())||
                StringUtils.isEmpty(user.getLoginName())|| StringUtils.isEmpty(user.getNameCn())||
                StringUtils.isEmpty(user.getPassword())|| StringUtils.isEmpty(user.getStatus())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }


        //补充user表
        String uid = String.valueOf(IDUtils.genItemId());
        urvo.gettXietongUser().setId(uid);
        urvo.gettXietongUser().setIsdelete((short) 1);
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        urvo.gettXietongUser().setPassword(urvo.gettXietongUser().getPassword());
        urvo.gettXietongUser().setSort(userMapper.selectMaxSort()+1);
        urvo.gettXietongUser().setCreatetime(new Date());
        urvo.gettXietongUser().setEmpNum(uid);
        urvo.gettXietongUser().setExt3(Pinyin4jUtil.converterToFirstSpell(urvo.gettXietongUser().getNameCn()));
        userMapper.insert(urvo.gettXietongUser());
        //关联表

        //添加时选择多个角色
        for (int i=0;i<urvo.getRids().size();i++){
            TXietongUserRole userRole = new TXietongUserRole();
            userRole.setUserId(urvo.gettXietongUser().getId());
            userRole.setRoleId(urvo.getRids().get(i));
            userRole.setStatus(1);
            userRoleMapper.insert(userRole);
        }

//        //添加选着一个角色
//
//            TXietongUserRole userRole = new TXietongUserRole();
//            userRole.setUserId(urvo.gettXietongUser().getId());
//            userRole.setRoleId(urvo.getRid());
//            userRole.setStatus(1);
//            userRoleMapper.insert(userRole);


        //补填UserDepartments对象
        List<StatusVO> did = urvo.getDids();
        TXietongUserDepartments userDepartmentss1 = new TXietongUserDepartments();
        userDepartmentss1.setStatus(1);
        userDepartmentss1.setDid("1");
       userDepartmentss1.setUid(uid);
        userDepartmentsMapper.insert(userDepartmentss1);
        for (int i=0;i<did.size();i++){
                List<TXietongUserDepartments> userDepartments = userDepartmentsMapper.selectUserAndDepartment(uid,did.get(i).getId());
                //判断数据库中书否存在此数据，如果不存在则直接插入,否则根据传来的状态进行判断
                if (CollectionUtils.isEmpty(userDepartments)&&did.get(i).isStatus()){
                    TXietongUserDepartments userDepartmentss = new TXietongUserDepartments();
                    userDepartmentss.setUid(uid);
                    userDepartmentss.setDid(did.get(i).getId());
                    userDepartmentss.setStatus(1);
                    userDepartmentsMapper.insert(userDepartmentss);
                }else {
                    //如果与数据库中的状态一致,则不做任何操作
                    if (did.get(i).isStatus()){
                    }else{
                        //如传来的状态和数据库不一样则删除
                       userDepartmentsMapper.deleteUserAndDepartment(uid,did.get(i).getId());
                    }
                }


        }


        //添加某用户可见部门
//        TXietongUserDepartments departments = new TXietongUserDepartments();
//        departments.setUid(uid);
//        departments.setDid();


//        //是否添加部门领导人
//        System.out.println("--------------->"+urvo.getIsLeader());
//        if (StringUtils.isEmpty(urvo.getIsLeader())){
//            responseMessage = new ResponseMessage(Code.CODE_OK,"------------");
//            return responseMessage;
//        }
//        if (urvo.getIsLeader().equals("是")){
//            //是否是部门领导人
//            TXietongDepartment department = new TXietongDepartment();
//            department.setId(user.getDepartmentid());
//            department.setLeaderId(user.getId());
//            departmentMapper.updateByPrimaryKeySelective(department);
//        }
//
//
//
//



        responseMessage = new ResponseMessage(Code.CODE_OK,"添加成功");
        return responseMessage;
    }


    /**
     * 查询所有用户  排序字段为 sort
     * @return
     */
    @Override
    public Page<TXietongUser> selectAllUser(int pageNo, int pageSize) {
        Page<TXietongUser> page = new Page<>();
        int totalCount = userMapper.userCount();
        page.init(totalCount,pageNo,pageSize);
        List<TXietongUser> user = userMapper.findAllUser(page.getRowNum(),page.getPageCount());
        for (int i=0;i<user.size();i++){
            if (user.get(i).getRstatus().equals("0")){
                user.get(i).setRoleName("");
            }
            user.get(i).setPassword("");
        }
        page.setList(user);
        // Page类的设置顺序：
        // 1、setPageCount
        // 2、setTotalCount()
        // 3、setTotalPage()
        // 4、setPageNum()
        // 5、setRowNum()
//        System.out.println(page);
        return page;
    }

    /**
     * 根据用户登录的账号，更改用户的登录状态
     * @param login_name
     * @return
     */
    @Override
    public ResponseMessage enOrDisUser(String login_name) {
        if (StringUtils.isEmpty(login_name)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        TXietongUser user = userMapper.selectUserByUserName(login_name);
        if (user==null){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"查询用户不存在");
            return responseMessage;
        }
        int status = user.getStatus();
        if (status == 0){
            status = 1;
        }else {
            status = 0 ;
        }
        userMapper.enOrDisUser(status,login_name);
        responseMessage = new ResponseMessage(Code.CODE_OK,"启用/禁用成功");
        return responseMessage;
    }

    /**
     * 根据用户id称删除用户
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage deleteUserByLoginNames(List<String> ids) {
        StringBuffer leadDepartmentName = new StringBuffer();
        StringBuffer viceDepartmentName = new StringBuffer();


        if(CollectionUtils.isEmpty(ids)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        for(int i =0 ; i<ids.size();i++){
//           TXietongUser user =  userMapper.selectUserByUserName(login_names.get(i));
////           if (user==null){
////               responseMessage = new ResponseMessage(Code.CODE_ERROR,"用户不存在");
////               return responseMessage;
////           }
            List<TXietongUser> users = getUserByid(ids.get(i));
            List<TXietongDepartment> leadDepartments = departmentMapper.findDepartmentByLeadId(ids.get(i));
            List<TXietongDepartment> viceDepartments = departmentMapper.findDepartmentViceId(ids.get(i));

            //判断此用户是否为副部长或者正部长
            if (CollectionUtils.isEmpty(leadDepartments)&&CollectionUtils.isEmpty(viceDepartments)){
                userRoleMapper.updateStatusByUid(ids.get(i));
                userMapper.deleteUserByLoginName(ids.get(i));
                responseMessage = new ResponseMessage(Code.CODE_OK,"用户名为:"+users.get(0).getNameCn()+"删除成功");
                //此用户是部长
            }else if (!CollectionUtils.isEmpty(leadDepartments)){
                for (int j=0;j<leadDepartments.size();j++){
                    if (j==leadDepartments.size()-1){
                        leadDepartmentName.append(leadDepartments.get(j).getName());
                    }else {
                        leadDepartmentName.append(leadDepartments.get(j).getName()+",");
                    }

                }
                responseMessage = new ResponseMessage(Code.CODE_ERROR,"用户名为:"+users.get(0).getNameCn()+"删除失败,此用户是"+leadDepartmentName+"的部门主任");
            }else if (!CollectionUtils.isEmpty(viceDepartments)){
                for (int j=0;j<viceDepartments.size();j++) {
                    if (j ==viceDepartments.size()-1){
                        viceDepartmentName.append(viceDepartments.get(i).getName());
                    }else {
                        viceDepartmentName.append(viceDepartments.get(i).getName()+",");
                    }
                }
                responseMessage = new ResponseMessage(Code.CODE_ERROR,"用户名为:"+users.get(0).getNameCn()+"删除失败,此用户是"+viceDepartmentName+"的副部长");
            }

        }
//        if (j>0){
//            responseMessage = new ResponseMessage(Code.CODE_OK,"删除成功");
//        }else {
//            responseMessage = new ResponseMessage(Code.CODE_OK,"删除失败");
//        }
        return responseMessage;
    }



    /**
     * 根据用户名获取当前用户信息（包括角色）
     * @param login_name
     * @return
     */
    @Override
    public ResponseMessage selectUserAndRoleByUserName(String login_name) {
        if (StringUtils.isEmpty(login_name)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
       TXietongUser user = userMapper.findUserAndRoleByUserName(login_name);
        user.setPassword("");
        if (user == null){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"用户不存在");
            return responseMessage;
        }
        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",user);
        return responseMessage;
    }

    /**
     *  修改用户信息
     * @param urvo
     * @return
     */
    @Override
    public ResponseMessage updateUserInfo(UserRoleDeparmentsVO urvo) {
        List<TXietongUser> user1 = getUserByid(urvo.gettXietongUser().getId());
        if (CollectionUtils.isEmpty(user1)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"修改用户不存在");
            return responseMessage;
        }
        TXietongUser user = urvo.gettXietongUser();
        if (StringUtils.isEmpty(urvo.getRids())|| StringUtils.isEmpty(user.getDepartmentid())||
                StringUtils.isEmpty(user.getLoginName())|| StringUtils.isEmpty(user.getNameCn())||
             StringUtils.isEmpty(user.getStatus())){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }
        TXietongUser user11 = userMapper.selectUserByUserName(urvo.gettXietongUser().getLoginName());
        if (user11!=null){
            if (!user11.getId().equals(urvo.gettXietongUser().getId())) {
                responseMessage = new ResponseMessage(Code.CODE_ERROR, "用户登录名已存在");
                return responseMessage;
            }
        }


//        TXietongRoleExample roleExample = new TXietongRoleExample();
//        TXietongRoleExample.Criteria criteria1 = roleExample.createCriteria();
//        criteria1.andIdEqualTo(urvo.getRid());
//        criteria1.andIsdeleteEqualTo(1);
//        List<TXietongRole> roles = roleMapper.selectByExample(roleExample);
//        //判断角色是否存在
//        if (CollectionUtils.isEmpty(roles)){
//            responseMessage = new ResponseMessage(Code.CODE_ERROR,"此角色不存在");
//            return responseMessage;
//        }

        //填充用户表
        String uid = user1.get(0).getId();
        urvo.gettXietongUser().setIsdelete((short) 1);
        if (StringUtils.isEmpty(urvo.gettXietongUser().getPassword())){
            urvo.gettXietongUser().setPassword(user1.get(0).getPassword());
        }else {
//            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            urvo.gettXietongUser().setPassword(urvo.gettXietongUser().getPassword());
        }

        urvo.gettXietongUser().setCreatetime(user1.get(0).getCreatetime());
        urvo.gettXietongUser().setSort(user1.get(0).getSort());
        urvo.gettXietongUser().setExt3(Pinyin4jUtil.converterToFirstSpell(urvo.gettXietongUser().getNameCn()));
//        urvo.gettXietongUser().setSort(urvo.gettXietongUser().getSort());
//        urvo.gettXietongUser().setCreatetime(urvo.gettXietongUser().getCreatetime());
//        urvo.gettXietongUser().setEmpNum(uid);


//        int i =  userRoleMapper.updateUserRoleRidByUid(uid,urvo.getRid());


        //更新用户角色（先删再插）
        TXietongUserRoleExample userRoleExample = new TXietongUserRoleExample();
        TXietongUserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        userRoleMapper.deleteByExample(userRoleExample);
        //插入

        for (int j=0;j<urvo.getRids().size();j++){
            TXietongUserRole userRole = new TXietongUserRole();
            userRole.setUserId(urvo.gettXietongUser().getId());
            userRole.setRoleId(urvo.getRids().get(j));
            userRole.setStatus(1);
            userRoleMapper.insert(userRole);
        }



        int j =  userMapper.updateByPrimaryKey(urvo.gettXietongUser());

        //补填UserDepartments对象
        List<StatusVO> did = urvo.getDids();

        for (int q=0;q<did.size();q++){
            List<TXietongUserDepartments> userDepartments = userDepartmentsMapper.selectUserAndDepartment(uid,did.get(q).getId());
            //判断数据库中书否存在此数据，如果不存在则直接插入,否则根据传来的状态进行判断
            if (CollectionUtils.isEmpty(userDepartments)&&did.get(q).isStatus()){
                TXietongUserDepartments userDepartmentss = new TXietongUserDepartments();
                userDepartmentss.setUid(uid);
                userDepartmentss.setDid(did.get(q).getId());
                userDepartmentss.setStatus(1);
                userDepartmentsMapper.insert(userDepartmentss);
            }else {
                //如果与数据库中的状态一致,则不做任何操作
                if (did.get(q).isStatus()){
                }else{
                    //如传来的状态和数据库不一样则删除
                    userDepartmentsMapper.deleteUserAndDepartment(uid,did.get(q).getId());
                }
            }
        }



//        //是否添加部门领导人
//        if (urvo.getIsLeader().equals("是")){
//            //是否是部门领导人
//            TXietongDepartment department = new TXietongDepartment();
//            department.setId(user.getDepartmentid());
//            department.setLeaderId(user.getId());
//            departmentMapper.updateByPrimaryKeySelective(department);
//        }else {
//            if( CollectionUtils.isEmpty(getDeparmentById(user.getDepartmentid()))){
//                responseMessage = new ResponseMessage(Code.CODE_ERROR,"部门id请求参数有误");
//                return responseMessage;
//            }
//            TXietongDepartment department = getDeparmentById(user.getDepartmentid()).get(0);
//            //如果当前取消的部门负责人，是当前登录用户
//            if (!StringUtils.isEmpty(department.getLeaderId())){
//                if (department.getLeaderId().equals(user.getId())){
////                department.setLeaderId(null);
//                    departmentMapper.updateDepartmentLeader(department.getId(),null);
//                }
//            }
//
//
//        }


        if (j>0){
            responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        }

        return responseMessage;
    }

    /**
     * 用户排序
     * @param name1
     * @param name2
     * @return
     */
    @Override
    public ResponseMessage updateSortByLoginName(String name1, String name2) {

        if(StringUtils.isEmpty(name1)&& StringUtils.isEmpty(name2)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }

//        根据用户loginName，查找用户
          TXietongUser user = userMapper.selectUserByUserName(name1);
          TXietongUser user1 = userMapper.selectUserByUserName(name2);
//
        if ( user == null || user1 ==null){
                responseMessage = new ResponseMessage(Code.CODE_ERROR,"用户不存在");
                return responseMessage;
            }else {
                //获得部门的sort
                int solr  = user.getSort();
                int solr1 = user1.getSort();

                int i = userMapper.updateUserSort(solr,user1.getLoginName());
                int j = userMapper.updateUserSort(solr1,user.getLoginName());

                if (i<=0||j<=0){
                    responseMessage = new ResponseMessage(Code.CODE_ERROR,"修改失败");
                }else {
                    responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
                }

        }

        return responseMessage;
}


    /**
     * 拖动排序
     * @param sortVos
     * @return
     */
    @Override
    public ResponseMessage sortButtons(List<SortVo> sortVos) {
        if (CollectionUtils.isEmpty(sortVos)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }

        for (int i=0;i<sortVos.size();i++){
           userMapper.updateUserSort(sortVos.get(i).getSort(),sortVos.get(i).getId());
        }
        responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        return responseMessage;
    }


    /**
     * 模糊查找用户
     * @param name
     * @return
     */
    @Override
    public ResponseMessage selectUserByLikeName(String name) {
        if (StringUtils.isEmpty(name)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }

        List<TXietongUser> users = userMapper.selectUserByLikeName(name);
        if (CollectionUtils.isEmpty(users)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"查询数据为空!");
        }else {
           responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",users);
        }
        return responseMessage;
    }



    /**
     * 修改密码
     * @param password
     * @param uid
     * @return
     */

    @Override
    public ResponseMessage updatePassword(String password, String uid) {
        List<TXietongUser> users = getUserByid(uid);
        String oldPassword = users.get(0).getPassword();
        if (StringUtils.isEmpty(password)){
            password = oldPassword;
        }
        int i = userMapper.updatePassword(password,uid);
        if (i<0){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"修改失败");
        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"修改成功");
        }
        return responseMessage;
    }

    /**
     * 模糊查找用户(分页)
     * @param pageVo
     * @return
     */
    @Override
    public ResponseMessage selectUserByLikeNamePage(PageVo pageVo) {
            Page<TXietongUser> userPage = new Page<>();
            //int total = userMapper.selectUserByLikeNamePageCount(pageVo.getObject(),pageVo.getDepartmentId());
            int totalCount=userMapper.selectTotalCountLikeName(pageVo.getObject(),pageVo.getDepartmentId());
           // userPage.init(total,pageVo.getPageNo(),pageVo.getPageSize());
            userPage.init(totalCount, pageVo.getPageNo(), pageVo.getPageSize());
           //List<TXietongUser> users = userMapper.selectUserByLikeNamePage(pageVo.getObject(),pageVo.getDepartmentId(),userPage.getRowNum(),userPage.getPageCount());
            List<TXietongUser> users=userMapper.selectUserByNamePage(pageVo.getObject(),pageVo.getDepartmentId(),userPage.getRowNum(),userPage.getPageCount());
            List<TXietongUser> user=new ArrayList<TXietongUser>();
            for(int i=0;i<users.size();i++) {
            	TXietongUser u=userMapper.selectUserByUserId(users.get(i).getId());
            	if (u!=null)
            	user.add(u);
            }


//        //判断是否是其他部门负责人当前用户是否是处事负责人
//        if (!StringUtils.isEmpty(getDeparmentById(departmentTrees.get(i).getId()).get(0).getLeaderId())){
//            //判断当前用户是否是处事负责人
//            TXietongUser leaderUser = getUserByid(getDeparmentById(departmentTrees.get(i).getId()).get(0).getLeaderId()).get(0);
//            if (leaderUser!=null&&getDeparmentById(departmentTrees.get(i).getId()).get(0).getId().equals(departmentTrees.get(i).getId())){
//                users.add(leaderUser);
//            }
//        }


        for (int j=0;j<user.size();j++){
            //取出每个部门的领导id
            TXietongDepartment department = departmentMapper.findDepartmentById(user.get(j).getDepartmentid());
            if (department!=null) {
                if (department.getLeaderId().equals(user.get(j).getId())) {
                    user.get(j).setIsLeader("true");
                } else {
                    user.get(j).setIsLeader("false");
                }
            }
        }
//            if (!CollectionUtils.isEmpty(users)){
//                for (int i=0;i<users.size();i++){
//                    List<TXietongRole> roles = users.get(i).getRoles();
//                    if (!CollectionUtils.isEmpty(roles)){
//                        for (int  j=0;j<roles.size();j++){
//                            String status = String.valueOf(roles.get(j).getRoleFlag());
//                            if (status.equals("0")){
//                                roles.get(j).setName(null);
//                                roles.get(j).setId(null);
//                               roles.get(j).setName(null);
//                               users.get(i).setRoleName(null);
//                               users.get(i).getRoles().get(j).setName(null);
//                                users.get(i).getRoles().get(j).setId(null);
//                            }
//                        }
//                    }
//
//            }
//
//
//                if(StringUtils.isEmpty(users.get(i).getDstatus())||users.get(i).getDstatus().equals("0")){
//                        users.get(i).setDepartmentName(null);
//                      users.get(i).setDepartmentid(null);
//              }
//
//            }
            //userPage.setList(users);
            userPage.setList(user);
            if (CollectionUtils.isEmpty(user)){
                responseMessage = new ResponseMessage(Code.CODE_ERROR,"查询数据为空!");
            }else {
                responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",userPage);
            }
            return responseMessage;
    }


    /**
     * 删除部门时，判断该部门下是否有用户
     * @param id
     * @return
     */
    @Override
    public ResponseMessage selectUserByDepartmentId(String id) {
        if (StringUtils.isEmpty(id)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"请求参数有误");
            return responseMessage;
        }

        int i = userMapper.selectUserByDepartmentId(id);
        if (i>0){
            responseMessage = new ResponseMessage(Code.CODE_OK,"此部门下存在用户",i);
        }else {
            responseMessage = new ResponseMessage(Code.CODE_OK,"此部门下不存在用户",i);
        }
        return responseMessage;
    }


    //根据用户的id查询用户

    public List<TXietongUser> getUserByid(String id){
        TXietongUserExample userExample = new TXietongUserExample();
        TXietongUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsdeleteEqualTo((short) 1);
        criteria.andIdEqualTo(id);

        List<TXietongUser> users = userMapper.selectByExample(userExample);

        return users;
    }



    //根据Id查找部门
    public  List<TXietongDepartment> getDeparmentById(String id){
        TXietongDepartmentExample departmentExample  = new TXietongDepartmentExample();
        TXietongDepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andIdEqualTo(id).andIsdeleteEqualTo((short) 1);
        List<TXietongDepartment> department = departmentMapper.selectByExample(departmentExample);
        return department;
    }


}
