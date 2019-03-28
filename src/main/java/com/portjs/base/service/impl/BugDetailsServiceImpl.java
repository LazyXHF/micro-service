package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.BugDetailsMapper;
import com.portjs.base.dao.InternalProjectMapper;
import com.portjs.base.entity.BugDetails;
import com.portjs.base.entity.InternalPersionResource;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.service.BugDetailsService;
import com.portjs.base.service.InternalProjectService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.vo.Bug;
import com.portjs.base.vo.BugSearchDO;
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
     * 新增bug接口
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertSelective(BugDetails record) {
        record.setId(UUID.randomUUID().toString());
        int i = 0;
        try {
            if(StringUtils.isEmpty(record.getProjectId())){
                return new ResponseMessage(Code.CODE_ERROR , "添加项目Bug信息,项目id未传");
            }
            i = bugDetailsMapper.insertSelective(record);
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
     * 根据项目id查询Bug信息并分页
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

        Page page = new Page();
        int totelCount = bugDetailsMapper.bugCounts(projectId,result,modules,projectedName,designatedPersion);
        page.init(totelCount, pageNo, pageSize);
        List<BugDetails> list = bugDetailsMapper.queryAllBugInfo(projectId,result,modules ,projectedName ,designatedPersion, page.getRowNum(), page.getPageCount());

        if (CollectionUtils.isEmpty(list)) {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        page.setList(list);
        return new ResponseMessage(Code.CODE_OK, "查询成功",page);
        /*
        if(StringUtils.isEmpty(projectId)){
            return new ResponseMessage(Code.CODE_ERROR,"查询bug信息时未传项目id");
        }
        Page<InternalPersionResource> page = new Page<>();
        int totalCount = bugDetailsMapper.bugCounts(projectId);
        page.init(totalCount,pageNo,pageSize);
        List<InternalPersionResource> list = bugDetailsMapper.queryAllBugInfo(projectId,modules ,title ,designatedPersion,result ,page.getRowNum(), page.getPageCount());
        page.setList(list);

        responseMessage = new ResponseMessage(Code.CODE_OK,"查询成功！",page);
        return responseMessage;
        */


    }

    /**
     * 更新bug信息
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


}
