package com.portjs.base.service.impl;

import com.portjs.base.dao.BugDetailsMapper;
import com.portjs.base.dao.BugDetailsRecordMapper;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BugDetailsRecordServiceImpl implements BugDetailsRecordService {
    ResponseMessage responseMessage;


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
     * 添加审批意见
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
                    detailsMapper.updateStatusById("1",bugId);
                }
            }

            //判断指派人是否是经理
            for (int i=0;i<managerUsers.size();i++){
                String managerIds = managerUsers.get(i).getId();
                if (managerIds.equals(ownerId)){
                    detailsMapper.updateStatusById("2",bugId);
                }
            }
            //判断指派人是否是测试人员
            for (int i=0;i<testUsers.size();i++){
                String testIds = testUsers.get(i).getId();
                if (testIds.equals(ownerId)){
                    detailsMapper.updateStatusById("3",bugId);
                }
            }

        }else {
            //结束此单
            detailsMapper.updateStatusById("4",bugId);
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




}
