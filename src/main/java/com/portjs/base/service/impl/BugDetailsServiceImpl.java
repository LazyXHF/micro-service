package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.BugDetailsMapper;
import com.portjs.base.dao.BugDetailsRecordMapper;
import com.portjs.base.dao.InternalProjectMapper;
import com.portjs.base.entity.BugDetails;
import com.portjs.base.entity.BugDetailsRecord;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.service.BugDetailsService;
import com.portjs.base.service.InternalProjectService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.UserUtils;
import com.portjs.base.vo.Bug;
import com.portjs.base.vo.BugSearchDO;
import com.portjs.base.vo.PageVo;
import com.portjs.base.vo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class BugDetailsServiceImpl implements BugDetailsService {
    ResponseMessage responseMessage = null;

    @Autowired
    BugDetailsMapper bugDetailsMapper;

    @Autowired
    private InternalProjectMapper projectMapper;

    @Autowired
    BugDetailsRecordMapper bugDetailsRecordMapper;


    /**
     * 根据id删除bug信息（批量删除）
     * @param ids
     * @return
     */
    @Override
    public ResponseMessage deleteByPrimaryKey(List<String> ids) {
        int count = 0;
        try {
            count =  bugDetailsMapper.deleteByPrimaryKey(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(count==0){
            return new ResponseMessage(Code.CODE_ERROR,"删除失败！",count);
        }
        return  new ResponseMessage(Code.CODE_OK,"删除成功！",count);

    }

    /**
     * TODO 新增bug接口
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertSelective(BugDetails record) {
        String uuid = UUID.randomUUID().toString();
        record.setId(uuid);

        int i = 0;
        try {
            if(StringUtils.isEmpty(record.getProjectId())){
                return new ResponseMessage(Code.CODE_ERROR , "添加项目Bug信息,项目id未传");
            }


            //补充主表信息
            record.setAcceptTime(new Date());
            record.setBugCreateTime(new Date());

            //result  0 未完成  1 已完成
            record.setResult(0);


            i = bugDetailsMapper.insertSelective(record);


            //创建人的record
            BugDetailsRecord bugDetailsRecord1 = new BugDetailsRecord();

            bugDetailsRecord1.setCreaterId(record.getBackup7());
            bugDetailsRecord1.setBackup7(record.getAccepter());

            //属于人
            bugDetailsRecord1.setOwnerId(record.getBackup7());
            bugDetailsRecord1.setBackup8(record.getAccepter());

            // Status  0 未完成   1已完成
            bugDetailsRecord1.setStatus(1);

            bugDetailsRecord1.setFileUrl(record.getFileUrl());
            bugDetailsRecord1.setRecordTime(record.getBugCreateTime());
            bugDetailsRecord1.setId(UUID.randomUUID().toString());
            bugDetailsRecord1.setBugId(uuid);
            // accepter 提单人   创建者
//            bugDetailsRecord.setOwnerId(record.getBackup3());
//            bugDetailsRecord.setStatus(record.getResult());//添加成功之后，所处的审批状态
            bugDetailsRecord1.setBackup5("null");//身份标识 获取指派人
            bugDetailsRecordMapper.insert(bugDetailsRecord1);




            //指派人得record
            BugDetailsRecord bugDetailsRecord = new BugDetailsRecord();
           // designatedPersion姓名  Backup6提单人id    指派人  接受者
            //Backup7提单人id   accept提单人姓名            主
            //从    creater_id    创建人id    backUp7  创建人姓名
            //      backUp8属于人得姓名    owner_id 属于人id
            //创建人
            bugDetailsRecord.setCreaterId(record.getBackup7());
            bugDetailsRecord.setBackup7(record.getAccepter());


            //属于人
            bugDetailsRecord.setOwnerId(record.getBackup6());
            bugDetailsRecord.setBackup8(record.getDesignatedPersion());

            // Status  0 未完成   1已完成
            bugDetailsRecord.setStatus(0);
            bugDetailsRecord.setFileUrl(record.getFileUrl());
            bugDetailsRecord.setRecordTime(record.getBugCreateTime());
            bugDetailsRecord.setBugId(uuid);
            bugDetailsRecord.setId(UUID.randomUUID().toString());
            // accepter 提单人   创建者
//            bugDetailsRecord.setOwnerId(record.getBackup3());
//            bugDetailsRecord.setStatus(record.getResult());//添加成功之后，所处的审批状态
            bugDetailsRecord.setBackup5("开发");//身份标识 获取指派人

          int j =   bugDetailsRecordMapper.insert(bugDetailsRecord);
            System.out.println(j);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",i);
        }
        return  new ResponseMessage(Code.CODE_OK,"添加成功！",i);
    }

    /**
     * 根据自身id查询Bug信息
     * @param id
     * @return
     */
    @Override
    public ResponseMessage selectByPrimaryKey(String id) {
        BugDetails bugDetails = bugDetailsMapper.selectByPrimaryKey(id);
        if(StringUtils.isEmpty(bugDetails)){
            responseMessage= new ResponseMessage(Code.CODE_ERROR,"查询失败！",bugDetails);
        }
        return responseMessage= new ResponseMessage(Code.CODE_OK,"查询成功！",bugDetails);
    }

    /**
     * 根据项目id查询Bug信息并分页（添加）
     * @param
     * @return
     */
    @Override
    public ResponseMessage queryAllBugInfo(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String projectId = jsonObject.getString("projectId");
        String modules = jsonObject.getString("modules");
        String projectedName = jsonObject.getString("projectedName");
        String designatedPersion = jsonObject.getString("designatedPersion");
        int result = jsonObject.getInteger("result");
        int pageNo = jsonObject.getInteger("pageNo");
        int pageSize = jsonObject.getInteger("pageSize");

       BugDetails bugDetails1 = new BugDetails();

       // int i = bugDetailsMapper.updateByPrimaryKeySelective(bugDetails);

        int result1 = 0;

        Page page = new Page();
        int totelCount = bugDetailsMapper.bugCounts(projectId,result,modules,projectedName,designatedPersion);

        page.init(totelCount, pageNo, pageSize);

        List<BugDetails> list = bugDetailsMapper.queryAllBugInfo(projectId,result,modules ,projectedName ,designatedPersion, page.getRowNum(), page.getPageCount());

        for ( int j = 0;j<list.size();j++) {
            bugDetails1 = list.get(j);
            bugDetails1.setResult(bugDetails1.getResult());
            bugDetails1.setResult(result);
            bugDetails1.setProjectId(projectId);
            bugDetails1.setModules(modules);
            bugDetails1.setProjectedName(projectedName);
            bugDetails1.setDesignatedPersion(designatedPersion);
            result1 = bugDetailsMapper.updateByPrimaryKeySelective(bugDetails1);
        }

        List<BugDetails> list2 = bugDetailsMapper.queryAllBugInfo(projectId,result1,modules ,projectedName ,designatedPersion, page.getRowNum(), page.getPageCount());

        if (CollectionUtils.isEmpty(list2)) {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        page.setList(list2);
        return new ResponseMessage(Code.CODE_OK, "查询成功",page);
    }

    /**
     * 根据项目id查询Bug信息并分页（待办）
     * @param
     * @return
     */
    /*@Override
    public ResponseMessage queryAllBugInfoDB(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String projectId = jsonObject.getString("projectId");
        String modules = jsonObject.getString("modules");
        String projectedName = jsonObject.getString("projectedName");
        String designatedPersion = jsonObject.getString("designatedPersion");//必传
        int result = jsonObject.getInteger("result");
        int pageNo = jsonObject.getInteger("pageNo");
        int pageSize = jsonObject.getInteger("pageSize");

        Page page = new Page();
        int totelCount = bugDetailsMapper.bugDBCounts(projectId,result,modules,projectedName,designatedPersion);
        page.init(totelCount, pageNo, pageSize);
        List<BugDetails> list = bugDetailsMapper.queryAllBugInfoDB(projectId,result,modules ,projectedName ,designatedPersion, page.getRowNum(), page.getPageCount());

        if (CollectionUtils.isEmpty(list)) {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        page.setList(list);
        return new ResponseMessage(Code.CODE_OK, "查询成功",page);
    }*/

    /**
     * TODO 更新bug信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKeySelective(BugDetails record) {
        int count = 0;
        try {
            if(com.portjs.base.util.StringUtils.StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(Code.CODE_ERROR , "更新项目Bug模块,id未传");
            }
            count = bugDetailsMapper.updateByPrimaryKeySelective(record);
            BugDetailsRecord bugDetailsRecord = new BugDetailsRecord();
            bugDetailsRecord.setCreaterId(record.getAccepter());
            bugDetailsRecord.setFileUrl(record.getFileUrl());
            bugDetailsRecord.setRecordTime(record.getAcceptTime());
            if(bugDetailsRecord.getBugId()==record.getId()){
                bugDetailsRecordMapper.updateByPrimaryKeySelective(bugDetailsRecord);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if(count==0){
            return new ResponseMessage(Code.CODE_ERROR,"更新失败！",count);
        }
        return new ResponseMessage(Code.CODE_OK,"更新成功！",count);
    }

    /*@Override
    public ResponseMessage queryAllBugInfos() {
        List<BugDetails> bugDetails = bugDetailsMapper.queryAllBugIf();
        if(CollectionUtils.isEmpty(bugDetails)){
            responseMessage = new ResponseMessage(Code.CODE_ERROR,"查询失败！",bugDetails);
        }

        return  responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功！",bugDetails);
    }*/

    /**
     * 级联查询
     * @param id
     * @return
     */
    @Override
    public ResponseMessage queryAllBugAndRecordInfo( String id) {
        List<BugDetails> bugDetails = bugDetailsMapper.queryAllBugAndRecordInfo(id);
        if(CollectionUtils.isEmpty(bugDetails)){

            return new ResponseMessage(Code.CODE_ERROR,"查询失败",bugDetails);
        }

        return new ResponseMessage(Code.CODE_OK,"查询成功",bugDetails);
    }

    /**
     * bug查询条件
     * @return
     */
    @Override
    public ResponseMessage queryBugSearch() {
        BugSearchDO searchDO = new BugSearchDO();

       /* List<Bug> bugs = bugDetailsMapper.queryAllBugIf();
        List<Bug> bugList = new ArrayList<>();
        Bug bug = new Bug();
        for(int i=0;i<bugs.size();i++){
            bug = bugs.get(i);
            String type = bug.getType();
            String status = bug.getStatus();
            String priority = bug.getPriority();
            for(int j = 0 ;j<bugList.size();j++){

                if(bugList.get(j).getStatus()==type){

                }

            }*/


            /*if(!(bugList.contains(type)){

//                if(!bugList.contains(status)){
//
//                    if(!bugList.contains(priority)){
//                        bug.setPriority(priority);
//                        bug.setStatus(status);
                        bug.setType(type);
                        bugList.add(bug);
//                    }
//                }
            }*/


//        }


        List<Project> projects = projectMapper.selectProjectAll();
        Map map = new HashMap();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        map.put("5","5");

//        searchDO.setBugDetailsList(bugList);
        searchDO.setProjectList(projects);
        searchDO.setSituation(map);
        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",searchDO);


        return responseMessage;
    }

    /**
     * 根据record表的ownerid ,status(result) ,去查询主表信息并分页
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage queryAllBugInfoFlow(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        //String projectId = jsonObject.getString("projectId");
        //String modules = jsonObject.getString("modules");
        //String projectedName = jsonObject.getString("projectedName");
        String ownerid = jsonObject.getString("ownerId");
        //String designatedPersion = jsonObject.getString("designatedPersion");
        int result = jsonObject.getInteger("status");
        int pageNo = jsonObject.getInteger("pageNo");
        int pageSize = jsonObject.getInteger("pageSize");

        //判断在哪里该显示在哪里不该显示

        String id =null;
        BugDetailsRecord bugDetailsRecord = bugDetailsRecordMapper.queryBugIdByStatusAndOwnerId(result, ownerid);
        if(!StringUtils.isEmpty(bugDetailsRecord)){
            id = bugDetailsRecord.getBugId();
        }

        Page page = new Page();
        int totelCount = bugDetailsMapper.bugFlowCounts(id);
        page.init(totelCount, pageNo, pageSize);
        List<BugDetails> list = bugDetailsMapper.queryAllBugInfoFlow(id, page.getRowNum(), page.getPageCount());

        if (CollectionUtils.isEmpty(list)) {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        page.setList(list);
        return new ResponseMessage(Code.CODE_OK, "查询成功",page);
    }



    /**
     * 查询待办
     * @return
     */
    @Override
    public ResponseMessage selectBugSearchDealtWith(PageVo pageVo) {
        Page<BugDetails> page = new Page<>();
        String ownerId = pageVo.getObject();
        int totalCount= bugDetailsMapper.countBugSearchDealtWith(ownerId);
        // userPage.init(total,pageVo.getPageNo(),pageVo.getPageSize());
        page.init(totalCount, pageVo.getPageNo(), pageVo.getPageSize());
        List<BugDetails> bugDetails = bugDetailsMapper.selectBugSearchDealtWith(ownerId,page.getRowNum(),page.getPageCount());
        page.setList(bugDetails);
        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",page);
        return responseMessage;
    }

    /**
     * 查询在办
     * @param pageVo
     * @return
     */
    @Override
    public ResponseMessage selectBugSearchDealtDoing(PageVo pageVo) {
        Page<BugDetails> page = new Page<>();
        String ownerId = pageVo.getObject();
        int totalCount = bugDetailsMapper.countBugSearchDealtDoing(pageVo.getObject());
        page.init(totalCount,pageVo.getPageNo(),pageVo.getPageSize());
        List<BugDetails> bugDetails = bugDetailsMapper.selectBugSearchDealtDoing(ownerId,page.getRowNum(),page.getPageCount());
        page.setList(bugDetails);
        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",page);
        return responseMessage;
    }

    /**
     * 查询已办
     * @param pageVo
     * @return
     */
    @Override
    public ResponseMessage selectBugSearchDealtEnd(PageVo pageVo) {
        Page<BugDetails> page = new Page<>();
        String ownerId = pageVo.getObject();
        int totalCount = bugDetailsMapper.countBugSearchDealtEnd(pageVo.getObject());
        page.init(totalCount,pageVo.getPageNo(),pageVo.getPageSize());
        List<BugDetails> bugDetails = bugDetailsMapper.selectBugSearchDealtEnd(ownerId,page.getRowNum(),page.getPageCount());
        page.setList(bugDetails);
        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功",page);
        return responseMessage;
    }


}
