package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.BugDetailsMapper;
import com.portjs.base.dao.BugDetailsMapper;
import com.portjs.base.dao.BugDetailsRecordMapper;
import com.portjs.base.entity.BugDetails;
import com.portjs.base.dao.TUserMapper;
import com.portjs.base.dao.TUserRoleMapper;
import com.portjs.base.entity.BugDetailsRecord;
import com.portjs.base.entity.TUser;
import com.portjs.base.service.BugDetailsRecordService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BugDetailsRecordServiceImpl implements BugDetailsRecordService {
    ResponseMessage responseMessage;
    @Autowired
    BugDetailsMapper bugDetailsMapper;

    @Autowired
    BugDetailsRecordMapper bugDetailsRecordMapper;

    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private BugDetailsMapper detailsMapper;
    /**
     * 根据id删除bug审批信息（可批量删除）
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> ids) {
        int count = 0;
        try {
            count =  bugDetailsRecordMapper.deleteByPrimaryKey(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",count);
        }
        return  new ResponseMessage(Code.CODE_OK,"添加成功！",count);

    }

    /**
     * TODO 添加审批意见
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertSelective(BugDetailsRecord record) {
        record.setId(UUID.randomUUID().toString());

        Date date = new Date();
        //SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        record.setRecordTime(date);


        if(StringUtils.isEmpty(record.getBugId())){
            return new ResponseMessage(Code.CODE_ERROR , "添加Bug审批信息,Bug id未传");
        }

        if(StringUtils.isEmpty(record.getCreaterId())){
//            record.setCreaterId(UserUtils.getCurrentUser().getId());
            return new ResponseMessage(Code.CODE_ERROR , "创建人员Id为空");
        }

        //指派人id
        String ownerId = record.getOwnerId();
        //经理角色id
        String managerId = "c2582665-3730-4b4b-896c-e50242e9471b";
        //开发人员角色
        String developerId = "565ecec0-6ed3-4f44-bd8d-faa6fe6c744e";
        //测试人员角色
        String testID = "d3bcbe76-604e-4d89-93e6-e19438daad96";
        //bugId
        String bugId = record.getBugId();
        //如果有指派人
        if (!StringUtils.isEmpty(record.getOwnerId())){
            //经理用户
            List<TUser> managerUsers = tUserMapper.selectUserByRoleId(managerId);
            if (CollectionUtils.isEmpty(managerUsers)){
                return  new ResponseMessage(Code.CODE_ERROR,"该经理角色下无用户");
            }
            //开发人员用户
            List<TUser> developerUsers = tUserMapper.selectUserByRoleId(developerId);
            if (CollectionUtils.isEmpty(developerUsers)){
                return  new ResponseMessage(Code.CODE_ERROR,"该开发角色下无用户");
            }
            //测试人员角色
            List<TUser> testUsers = tUserMapper.selectUserByRoleId(testID);
            if (CollectionUtils.isEmpty(testUsers)){
                return  new ResponseMessage(Code.CODE_ERROR,"该测试角色下无用户");
            }
            //result  1  开发   2 经理   3 测试
            //判断指派人是否是开发人员
            for (int j=0;j<developerUsers.size();j++){
                String developerIds = developerUsers.get(j).getId();
                if (developerIds.equals(ownerId)){
//                    detailsMapper.updateStatusById("1",bugId);
                }
            }

            //判断指派人是否是经理
            for (int i=0;i<managerUsers.size();i++){
                String managerIds = managerUsers.get(i).getId();
                if (managerIds.equals(ownerId)){
//                    detailsMapper.updateStatusById("2",bugId);
                }
            }
            //判断指派人是否是测试人员
            for (int i=0;i<testUsers.size();i++){
                String testIds = testUsers.get(i).getId();
                if (testIds.equals(ownerId)){
//                    detailsMapper.updateStatusById("3",bugId);
                }
            }

        }else {
            //结束此单
//            detailsMapper.updateStatusById("4",bugId);
            bugDetailsRecordMapper.updateStatusByOwnerIDAndBugId("0",record.getId());
        }
          int i = bugDetailsRecordMapper.insertSelective(record);
            if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",i);
            }
        return  new ResponseMessage(Code.CODE_OK,"添加成功！",i);
    }

    /**
     * 根据自身id查询Bug 审批信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage selectByPrimaryKey(String id) {
        BugDetailsRecord bugDetailsRecord = bugDetailsRecordMapper.selectByPrimaryKey(id);
        if(StringUtils.isEmpty(bugDetailsRecord)){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",bugDetailsRecord);
        }
        return  new ResponseMessage(Code.CODE_OK,"查询成功！",bugDetailsRecord);
    }

    /**
     * 根据Bug ID查询Bug审批信息
     * @param bugDetailsRecord
     * @return
     */
    @Override
    public ResponseMessage queryBugRecordByBugId(BugDetailsRecord bugDetailsRecord) {
        List<BugDetailsRecord> list = null;
        try {
            if(StringUtils.isEmpty(bugDetailsRecord.getBugId())){
                return new ResponseMessage(Code.CODE_ERROR , "根据Bug id查询Bug审批信息,Bug id未传");
            }
            list = bugDetailsRecordMapper.queryBugRecordByBugId(bugDetailsRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(CollectionUtils.isEmpty(list)){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",list);
        }
        return  new ResponseMessage(Code.CODE_OK,"查询成功！",list);
    }
    /**
     * 更新Bug审批信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKeySelective(BugDetailsRecord record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(Code.CODE_ERROR , "更新项目Bug审批模块,id未传");
            }
            count = bugDetailsRecordMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count==0){
            return new ResponseMessage(Code.CODE_ERROR,"更新失败！",count);
        }
        return new ResponseMessage(Code.CODE_OK,"更新成功！",count);
    }


    /**
     * TODO  流程操作方法------------------分割线--------------------------------------------------------------------------------------------------------------------
     */
    /*@Override
    public ResponseMessage updateFlowOperation(String requestBody) {
        int i = 0;
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        int status1 = jsonObject.getInteger("status");
        String ids = jsonObject.getString("id");//主表id
        BugDetails bugDetails = bugDetailsMapper.selectByPrimaryKey(ids);
        BugDetailsRecord bugDetailsRecord = bugDetailsRecordMapper.selectByPrimaryKey(ids);

        //判断主表指派人id 和record表的所属人员id是否相等，如果相等代表数据流转到当前阶段，改变其状态值
        if(bugDetails.getDesignatedPersion().equals(bugDetailsRecord.getOwnerId())){
           i = bugDetailsRecordMapper.updateFlowOperation(bugDetailsRecord.getOwnerId(),status1);
        }


        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"流程跳转阶段record status状态更新失败！",i);
        }
        return new ResponseMessage(Code.CODE_ERROR,"流程跳转阶段record status状态更新成功！",i);
    }*/

    /**
     * 流转一次record对应数据多一条，从表的指派人改变一次（backup3），从表的状态要添加进去，
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage insertFlowOperation(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        //String ids = jsonObject.getString("id");//bug表的id
        //BugDetails bugDetails = bugDetailsMapper.selectByPrimaryKey(ids);
        int i = 0;
        //把审批信息新添加一条数据，给个ownerId，代表此条数据属于哪个被指派的人（例如开发）
//        int status1 = jsonObject.getInteger("status");//从表的状态值
        String ownerId = jsonObject.getString("ownerId");//前端传过来的指派人id
        String ownerName = jsonObject.getString("backup8");
        String createrId = jsonObject.getString("createrId");//创建人得ID
        String backup7 = jsonObject.getString("backup7");//创建人得姓名
        String bugId = jsonObject.getString("id");//前端传来的主表id
        String remark = jsonObject.getString("remark");//从表的备注信息，前端传过来
        String isAgree = jsonObject.getString("isAgree");//从表的同意意见

        String backup1 = jsonObject.getString("backup1");//解决方案
        String backup2 = jsonObject.getString("backup2");//解决结果
        String fileUrl = jsonObject.getString("fileUrl");
        String backup5 = jsonObject.getString("backup5");
        String backup6 = jsonObject.getString("backup6");
        String backup10 = jsonObject.getString("backup10");//修复版本
        String loginAccount = jsonObject.getString("loginAccount");




//        //补充从表信息
//
//        BugDetails bugDetails = bugDetailsMapper.selectByPrimaryKey(bugId);
//        Date recordTime = bugDetails.getAcceptTime();//指派时间
//        String fileUrl = bugDetails.getFileUrl();//根据主表id去查询主表文件路径

        //如果存在审核人，
        //1.改变属于我得record记录状态
        //2.创建一个新的record记录并指定状态
        // Status  0 未完成   1已完成
        if (!StringUtils.isEmpty(ownerId)){
            //改变自身的流转意见
            BugDetailsRecord bugDetailsRecord1= new BugDetailsRecord();
            bugDetailsRecord1.setBugId(bugId);
//            bugDetailsRecord1.setStatus(1);
            bugDetailsRecord1.setOwnerId(loginAccount);//当前登录人 指派人传值
            bugDetailsRecord1.setRemark(remark);
            bugDetailsRecord1.setFileUrl(fileUrl);
            bugDetailsRecord1.setBackup1(backup1);//解决结果
            bugDetailsRecord1.setBackup2(backup2);//解决方法
            bugDetailsRecord1.setBackup10(backup10);
            if(!StringUtils.isEmpty(isAgree)){
                bugDetailsRecord1.setIsAgree(Integer.valueOf(isAgree));
            }
            bugDetailsRecord1.setBackup6(backup6);//文件名称
            int j =     bugDetailsRecordMapper.updateBugRecordInfoss(bugDetailsRecord1);
            System.out.println(j);
               bugDetailsRecordMapper.updateRecordStatus("1",loginAccount,bugId);


            BugDetailsRecord bugDetailsRecord = new BugDetailsRecord();
            bugDetailsRecord.setCreaterId(createrId);
            bugDetailsRecord.setBackup7(backup7);
            bugDetailsRecord.setBackup8(ownerName);
//            bugDetailsRecord.setFileUrl(fileUrl);
            bugDetailsRecord.setRecordTime(new Date());
            bugDetailsRecord.setBugId(bugId);
            bugDetailsRecord.setStatus(0);//代表流程下一步的状态值
//            bugDetailsRecord.setBackup10(backup10);
                bugDetailsRecord.setId(UUID.randomUUID().toString());


//            bugDetailsRecord.setRemark(remark);
            bugDetailsRecord.setOwnerId(ownerId);
            if(!StringUtils.isEmpty(isAgree)){
                bugDetailsRecord.setIsAgree(Integer.valueOf(isAgree));
            }
//            bugDetailsRecord.setBackup1(backup1);
//            bugDetailsRecord.setBackup2(backup2);

            //指派人id
            //String ownerId = ownerId;
            //经理角色id
            String managerId = "c2582665-3730-4b4b-896c-e50242e9471b";
            //开发人员角色
            String developerId = "565ecec0-6ed3-4f44-bd8d-faa6fe6c744e";
            //测试人员角色
            String testID = "d3bcbe76-604e-4d89-93e6-e19438daad96";
            //bugId
           /// String bugId = bugId;
            //如果有指派人
            if (!StringUtils.isEmpty(ownerId)) {
                //经理用户
                List<TUser> managerUsers = tUserMapper.selectUserByRoleId(managerId);
                if (CollectionUtils.isEmpty(managerUsers)) {
                    return new ResponseMessage(Code.CODE_ERROR, "该经理角色下无用户");
                }
                //开发人员用户
                List<TUser> developerUsers = tUserMapper.selectUserByRoleId(developerId);
                if (CollectionUtils.isEmpty(developerUsers)) {
                    return new ResponseMessage(Code.CODE_ERROR, "该开发角色下无用户");
                }
                //测试人员角色
                List<TUser> testUsers = tUserMapper.selectUserByRoleId(testID);
                if (CollectionUtils.isEmpty(testUsers)) {
                    return new ResponseMessage(Code.CODE_ERROR, "该测试角色下无用户");
                }
                //result  1  开发   2 经理   3 测试
                //判断指派人是否是开发人员
                for (int h = 0; h < developerUsers.size(); h++) {
                    String developerIds = developerUsers.get(h).getId();
                    if (developerIds.equals(ownerId)) {
                        bugDetailsRecord.setBackup5("开发");//身份标识 获取指派人
                    }
                }

                //判断指派人是否是经理
                for (int h = 0; h < managerUsers.size(); h++) {
                    String managerIds = managerUsers.get(h).getId();
                    if (managerIds.equals(ownerId)) {
                        bugDetailsRecord.setBackup5("经理");//身份标识 获取指派人
                    }
                }
                //判断指派人是否是测试人员
                for (int h = 0; h < testUsers.size(); h++) {
                    String testIds = testUsers.get(h).getId();
                    if (testIds.equals(ownerId)) {
                        bugDetailsRecord.setBackup5("测试");//身份标识 获取指派人
                    }
                }
            }
                //插入一条新的流转数据到record表里
                i = bugDetailsRecordMapper.insertFlowOperation(bugDetailsRecord);

        }else {


            //改变自身的流转意见
            BugDetailsRecord bugDetailsRecord2= new BugDetailsRecord();
            bugDetailsRecord2.setBugId(bugId);
            bugDetailsRecord2.setStatus(1);
            bugDetailsRecord2.setOwnerId(loginAccount);//当前登录人 指派人传值

            bugDetailsRecord2.setRemark(remark);
            bugDetailsRecord2.setFileUrl(fileUrl);
            bugDetailsRecord2.setBackup1(backup1);//解决结果
            bugDetailsRecord2.setBackup2(backup2);//解决方法
            bugDetailsRecord2.setBackup10(backup10);
            if (!StringUtils.isEmpty(isAgree)) {
                bugDetailsRecord2.setIsAgree(Integer.valueOf(isAgree));
            }
            bugDetailsRecord2.setBackup6(backup6);//文件名称
            bugDetailsRecordMapper.updateBugRecordInfoss(bugDetailsRecord2);
            //1.改变属于我得record记录状态
           /* bugDetailsRecordMapper.updateRecordStatus("1",loginAccount,bugId);

            BugDetailsRecord bugDetailsRecord = new BugDetailsRecord();
            bugDetailsRecord.setCreaterId(createrId);
            bugDetailsRecord.setBackup7(backup7);
            bugDetailsRecord.setBackup8(ownerName);
            bugDetailsRecord.setFileUrl(fileUrl);
            bugDetailsRecord.setRecordTime(new Date());
            bugDetailsRecord.setBugId(bugId);
            bugDetailsRecord.setStatus(1);//代表流程下一步的状态值
            bugDetailsRecord.setId(UUID.randomUUID().toString());
            bugDetailsRecord.setRemark(remark);
            bugDetailsRecord.setOwnerId(ownerId);
//            bugDetailsRecord.setIsAgree(isAgree);
            bugDetailsRecord.setBackup1(backup1);
            bugDetailsRecord.setBackup2(backup2);
            bugDetailsRecord.setBackup5(backup5);//身份标识 获取指派人
            //插入一条新的流转数据到record表里
            i = bugDetailsRecordMapper.insertFlowOperation(bugDetailsRecord);
*/
            //改变主表状态
            Date date = new Date();//获得系统时间.
            SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
            String nowTime = sdf.format(date);
            Date time = null;
            try {
                time = sdf.parse(nowTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            bugDetailsMapper.updateStatusById("1",bugId,time);
        }



//        if(i==0){
//            return new ResponseMessage(Code.CODE_ERROR,"流程跳转阶段指派人id存入record表失败！",i);
//        }

        return new ResponseMessage(Code.CODE_OK,"流程跳转阶段指派人id存入record表成功！",i);
    }
/**
 * TODO  流程操作方法------------------分割线--------------------------------------------------------------------------------------------------------------------
 */




}
