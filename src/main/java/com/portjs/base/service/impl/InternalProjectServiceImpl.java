package com.portjs.base.service.impl;

import com.portjs.base.dao.InternalProjectMapper;
import com.portjs.base.dao.LifeMapper;
import com.portjs.base.entity.InternalProject;
import com.portjs.base.entity.Life;
import com.portjs.base.service.InternalProjectService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.StringUtils.StringUtils;
import com.portjs.base.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class InternalProjectServiceImpl implements InternalProjectService {
    private Integer code;
    private String message = "";
    ResponseMessage responseMessage = null;

    @Autowired
    InternalProjectMapper internalProjectMapper;
    @Autowired
    private LifeMapper lifeMapper;

    /**
     * 查询所有项目信息和相关人员信息
     * @return
     */
    @Override
    public Page<InternalProject> selectAllProjectInfo(String id, int pageNo, int pageSize) {
        Page<InternalProject> page = new Page<>();
        /*InternalProject internalProject = new InternalProject();
        internalProject.getId();*/
        int totalCount = internalProjectMapper.projectCount(id);
        page.init(totalCount,pageNo,pageSize);
        List<InternalProject>  list= internalProjectMapper.selectAllProjectInfo(id,page.getRowNum(),page.getPageCount());
        page.setList(list);
        return page;
    }

    /**
     * 查询所有项目信息
     * @return
     */
    @Override
    public Page<InternalProject> queryAllProjectInfo(int pageNo, int pageSize) {
        Page<InternalProject> page = new Page<>();
        int totalCount = internalProjectMapper.projectCounts();
        page.init(totalCount,pageNo,pageSize);
        List<InternalProject> list = internalProjectMapper.queryAllProjectInfo(page.getRowNum(),page.getPageCount());
        page.setList(list);
        return page;

    }
    /**
     * 查询所有项目信息包含生命周期和项目状态
     * @return
     */
    @Override
    public Page<Map<String,Object>> queryAllProjectInfos(int pageNo, int pageSize) {
        Page<Map<String,Object>> page = new Page<>();
        int totalCount = internalProjectMapper.projectCounts();
        page.init(totalCount,pageNo,pageSize);
        List<InternalProject> list = internalProjectMapper.queryAllProjectInfo(page.getRowNum(),page.getPageCount());
        List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
        Life record = new Life();
        for(int i =0;i<list.size();i++){
            Map<String,Object> map = new HashMap<String,Object>();
            String projectId = list.get(i).getId();
            record.setProjectId(projectId);
            List<Life> lifes = lifeMapper.selectByPrimaryKey(record);
            if(CollectionUtils.isEmpty(lifes)){
                map.put("status","未开发");
            }else if(lifes.size()<6){
                map.put("status","已开发");
            }else if(lifes.size()==6){
                map.put("status","已开发");
                for (int k=0;k<lifes.size();k++){
                    if("6".equals(lifes.get(k).getNode())&& "3".equals(lifes.get(k).getStatus())){
                        map.put("status","已完成");
                        break;
                    }
                }
            }
            map.put("proiect",list.get(i));
            map.put("lifes",lifes);
            dataList.add(map);
        }
        page.setList(dataList);
        return page;

    }
    /**
     * 报表页面
     * 添加项目信息
     * @param record
     * @return
     */
    @Override
    public ResponseMessage insertProjectInfo(InternalProject record) {
        record.setId(UUID.randomUUID().toString());
        Date date=new java.util.Date();
        java.sql.Date  data1=new java.sql.Date(date.getTime());
        record.setCreateTime(data1);
        record.setCreater(UserUtils.getCurrentUser().getUsername());

        int i  = internalProjectMapper.insertSelective(record);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"添加成功！",i);
    }
    /**
     * 报表页面
     * 添加项目概览信息
     * @param
     * @return
     */
    @Override
    public ResponseMessage insertProjectInfoOverview(InternalProject internalProject) {
        internalProject.setId(UUID.randomUUID().toString());
        Date date=new java.util.Date();
        java.sql.Date  data1=new java.sql.Date(date.getTime());
        internalProject.setModifyTime(data1);
        internalProject.setModifer(UserUtils.getCurrentUser().getUsername());

        int i  = internalProjectMapper.insertSelective(internalProject);
        if(i==0){
            return new ResponseMessage(Code.CODE_ERROR,"添加失败！",i);
        }
        return new ResponseMessage(Code.CODE_OK,"添加成功！",i);
    }

    /**
     * 更新项目信息（报表页面）
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateByPrimaryKeySelective(InternalProject record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新项目模块,id未传");
            }
            //如果创建时间已经存在，之后每次修改都是修改时间
            Date date=new java.util.Date();
            java.sql.Date  data1=new java.sql.Date(date.getTime());
            record.setModifyTime(data1);

            record.setModifer(UserUtils.getCurrentUser().getId());
            count =  internalProjectMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);

    }

    /**
     * 更新项目信息（项目概览）
     * @param record
     * @return
     */
    @Override
    public ResponseMessage updateSelective(InternalProject record) {
        int count = 0;
        try {
            if(StringUtils.isEmpty(record.getId())){
                return new ResponseMessage(code , "更新项目概览模块,id未传");
            }
            //如果创建时间已经存在，之后每次修改都是修改时间
            Date date=new java.util.Date();
            java.sql.Date  data1=new java.sql.Date(date.getTime());
            record.setModifyTime(data1);
            record.setModifer(UserUtils.getCurrentUser().getId());
            count =  internalProjectMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message = count > 0?"更新成功":"更新失败";
        code=count>0?Code.CODE_OK:Code.CODE_ERROR;
        return new ResponseMessage(code , message);

    }

    /**
     * 根据id查询项目信息
     * @param internalProject
     * @return
     */
    @Override
    public ResponseMessage selectByPrimaryKey(InternalProject internalProject) {
        InternalProject internalProjects = internalProjectMapper.selectByPrimaryKey(internalProject);
        if(internalProjects==null){
            return new ResponseMessage(Code.CODE_ERROR,"查询失败！",internalProjects);
        }
        return new ResponseMessage(Code.CODE_OK,"查询成功！",internalProjects);
    }

    @Override
    public List<InternalProject> selectListByBackup1(InternalProject record) {
        return internalProjectMapper.selectListByBackup1(record);
    }
}
