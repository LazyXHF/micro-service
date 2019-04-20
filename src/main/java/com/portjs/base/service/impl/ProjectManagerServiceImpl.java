package com.portjs.base.service.impl;/*
package com.portjs.base.service.impl;

import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.ProjectManagerService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjectManagerServiceImpl implements ProjectManagerService {

    ResponseMessage responseMessage = null;

    */
/**
     * 节点--立项
     *//*

    @Autowired
    InternalApprovalMapper internalApprovalMapper;

    */
/**
     * 节点--合同签订
     *//*

    @Autowired
    InternalPactMapper internalPactMapper;

    */
/**
     * 节点--需求设计
     *//*

    @Autowired
    InternalDesignMapper internalDesignMapper;

    */
/**
     * 节点--开发测试
     *//*

    @Autowired
    InternalConstructionMapper internalConstructionMapper;

    */
/**
     * 节点--试运行
     *//*

    @Autowired
    InternalPilotMapper internalPilotMapper;

    */
/**
     * 根据项目id判断当前项目处于哪个节点位置（实际时间和计划时间的比较）
     * @param id
     * @return
     *//*

    public ResponseMessage dealProjectTime(String id){
        InternalApproval internalApproval = null;
        InternalPact internalPact = null;
        InternalDesign internalDesign = null;
        InternalConstruction internalConstruction = null;
        InternalPilot internalPilot = null;
        try {
            internalApproval = internalApprovalMapper.selectByPrimaryKey(id);
            internalPact = internalPactMapper.selectByPrimaryKey(id);
            internalDesign = internalDesignMapper.selectByPrimaryKey(id);
            internalConstruction = internalConstructionMapper.selectByPrimaryKey(id);
            internalPilot = internalPilotMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<Object> list = new ArrayList<>();
        list.add(internalApproval);
        list.add(internalPact);
        list.add(internalDesign);
        list.add(internalConstruction);
        list.add(internalPilot);



        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        long approvalPlanEnd = 0 ;
        long approvalActualEnd = 0 ;
        long pactPlanEnd = 0;
        long pactActualEnd = 0;
        long designPlanEnd = 0;
        long designActualEnd = 0;
        long constructionPlanEnd = 0;
        long constructionActualEnd = 0;
        long pilotPlanEnd = 0;
        long pilotActualEnd = 0;
        try {
            //立项计划结束时间
            date = simpleDateFormat.parse(String.valueOf(internalApproval.getPlanEndTime()));
            approvalPlanEnd = date.getTime();
            //立项实际结束时间
            date = simpleDateFormat.parse(String.valueOf(internalApproval.getActualEndTime()));
            approvalActualEnd = date.getTime();
            //合同签订计划结束时间
            date = simpleDateFormat.parse(String.valueOf(internalPact.getPlanEndTime()));
            pactPlanEnd = date.getTime();
            //合同签订实际结束时间
            date = simpleDateFormat.parse(String.valueOf(internalPact.getActualEndTime()));
            pactActualEnd = date.getTime();
            //需求设计计划结束时间
            date = simpleDateFormat.parse(String.valueOf(internalDesign.getPlanEndTime()));
            designPlanEnd = date.getTime();
            //需求设计实际结束时间
            date = simpleDateFormat.parse(String.valueOf(internalDesign.getActualEndTime()));
            designActualEnd = date.getTime();
            //开发测试计划结束时间
            date = simpleDateFormat.parse(String.valueOf(internalConstruction.getPlanEndTime()));
            constructionPlanEnd = date.getTime();
            //开发测试实际结束时间
            date = simpleDateFormat.parse(String.valueOf(internalConstruction.getActualEndTime()));
            constructionActualEnd = date.getTime();
            //试运行计划开始时间
            date = simpleDateFormat.parse(String.valueOf(internalPilot.getPlanEndTime()));
            pilotPlanEnd = date.getTime();
            //试运行实际开始时间
            date = simpleDateFormat.parse(String.valueOf(internalPilot.getActualEndTime()));
            pilotActualEnd = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //如果阶段节点实际结束时间小于计划结束时间，那么项目处于当前阶段，否则处于其他阶段
       if(approvalActualEnd<approvalPlanEnd){
            responseMessage = new ResponseMessage(Code.CODE_OK,"当前项目处于立项阶段",list);
        }else if(pactActualEnd<pactPlanEnd){
           responseMessage = new ResponseMessage(Code.CODE_OK,"当前项目处于合同签订阶段",list);
       }else if(designActualEnd<designPlanEnd){
           responseMessage = new ResponseMessage(Code.CODE_OK,"当前项目处于需求设计阶段",list);
       }else if(constructionActualEnd<constructionPlanEnd){
           responseMessage = new ResponseMessage(Code.CODE_OK,"当前项目处于开发测试阶段",list);
       }else if(pilotActualEnd<pilotPlanEnd){
           responseMessage = new ResponseMessage(Code.CODE_OK,"当前项目处于试运行阶段",list);
       }else{
           responseMessage = new ResponseMessage(Code.CODE_ERROR,"项目处于异常状态，请协调",list);
       }

        return responseMessage;
    }

}
*/
