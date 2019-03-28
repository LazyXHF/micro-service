package com.portjs.base.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.ConferenceRoomManagementService;
import com.portjs.base.util.Code;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * Created by dengshuangzhen on 2019\1\3 0003
 */
@Service
public class ConferenceRoomManagementImpl implements ConferenceRoomManagementService {
    @Autowired
    private TXietongMeetingroomMapper meetingroomMapper;

    @Autowired
    private TXietongMrReservationMapper mrReservationMapper;

    @Autowired
    private TXietongMrApplyMapper applyMapper;

    @Autowired
    private TXietongMrApplyRecordMapper mrApplyRecordMapper;

    @Autowired
    private TUserMapper userMapper;
    /**
     * 查询所有会议室
     * @param
     * @return
     */
    @Override
    public ResponseMessage selectConferenceRoom() {

        TXietongMeetingroomExample example = new TXietongMeetingroomExample();
        example.setOrderByClause("createtime desc");
        TXietongMeetingroomExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        criteria.andIsdeleteNotEqualTo(0);
        List<TXietongMeetingroom> meetingroomList = meetingroomMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(meetingroomList)) {
            return new ResponseMessage(Code.CODE_OK, "查询成功", meetingroomList);
        }
        return new ResponseMessage(Code.CODE_ERROR, "查询失败");

    }

    /**
     * 申请人新增会议室预定
     * @return
     */
    @Override
    public ResponseMessage insertConferenceRoom(String requestBody) throws Exception{
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String mrId = requestJson.getString("mrId");//会议室id
        String beginTime = requestJson.getString("beginTime");//开始时间
        String endTime = requestJson.getString("endTime");//结束时间
        String resId = requestJson.getString("resId");//预订人id
        String resName = requestJson.getString("resName");//预订人名称
        String resDepId = requestJson.getString("resDepId");//预订人部门id
        String resDepName = requestJson.getString("resDepName");//预订人部门名称
        String meetingSubject = requestJson.getString("meetingSubject");//用途
        String status  = requestJson.getString("status");//状态
        String owner_id = requestJson.getString("owner_id");//审核人id
        TXietongMrReservation reservation = new TXietongMrReservation();
        reservation.setId(UUID.randomUUID().toString());
        reservation.setMrId(mrId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        reservation.setBegintime(format.parse(beginTime));
        reservation.setEndtime(format.parse(endTime));
        reservation.setResId(resId);
        reservation.setResName(resName);
        reservation.setResDepId(resDepId);
        reservation.setResDepName(resDepName);
        reservation.setIsdelete(1);
        reservation.setMeetingSubject(meetingSubject);
        reservation.setStatus(Integer.valueOf(status));
        int i = mrReservationMapper.insertSelective(reservation);
        if (i!=1) {
            return new ResponseMessage(Code.CODE_ERROR, "新增失败");
        }
        TXietongMrApply apply = new TXietongMrApply();
        apply.setId(UUID.randomUUID().toString());
        apply.setStatus("1");
        apply.setIsdelete(1);
        apply.setApplyId(resId);
        apply.setApplyName(resName);
        apply.setApplyDepId(resDepId);
        apply.setApplyDepName(resDepName);
        apply.setContent(meetingSubject);
        apply.setMrResId(reservation.getId());
        apply.setNextApproverId(owner_id);
        String name_cn = userMapper.selectById(owner_id);
        apply.setNextApprover(name_cn);
        int selective = applyMapper.insertSelective(apply);
        if (selective!=1) {
            return new ResponseMessage(Code.CODE_ERROR, "新增失败");
        }
        TXietongMrApplyRecord record = new TXietongMrApplyRecord();
        record.setId(UUID.randomUUID().toString());
        record.setApplyId(apply.getId());
        record.setOwnerId(owner_id);
        record.setIsdelete(1);
        record.setStatus(0);
        record.setCreatorId(resId);
        record.setCreatorName(resName);
        record.setIsParallel(0);
        int i1 = mrApplyRecordMapper.insertSelective(record);
        if (i1!=1){
            return new ResponseMessage(Code.CODE_ERROR, "新增失败");
        }
        return new ResponseMessage(Code.CODE_OK, "新增成功");
    }

    /**
     * 申请人查询会议室预定
     * @return
     */
    @Override
    public ResponseMessage selectReservation(String requestBody) throws Exception{
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String mrId = requestJson.getString("mrId");//会议室id
        String beginTime = requestJson.getString("beginTime");//开始时间
        String endTime = requestJson.getString("endTime");//结束时间
        /*String pageNum = requestJson.getString("pageNum");
        String pageCount = requestJson.getString("pageCount");*/

        TXietongMrReservationExample example = new TXietongMrReservationExample();
        TXietongMrReservationExample.Criteria criteria = example.createCriteria();
        criteria.andIsdeleteEqualTo(1);
        if(!mrId.isEmpty()){
            criteria.andMrIdEqualTo(mrId);
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!beginTime.isEmpty()){
            criteria.andBegintimeGreaterThanOrEqualTo(format.parse(beginTime));
            criteria.andEndtimeGreaterThanOrEqualTo(format.parse(beginTime));
        }
        if (!endTime.isEmpty()){
            criteria.andBegintimeLessThanOrEqualTo(format.parse(endTime));
            criteria.andEndtimeLessThanOrEqualTo(format.parse(endTime));
        }
        /*Page page = new Page();
        int totelCount = mrReservationMapper.countByExample(example);
        page.init(totelCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));*/
        List<TXietongMrReservation> mrReservationList = mrReservationMapper.selectByExample(example);
        if (mrReservationList.size()>0){
            return new ResponseMessage(Code.CODE_OK, "查询成功",mrReservationList);
        }
        return new ResponseMessage(Code.CODE_ERROR, "查询失败");

    }

    /**
     * 查询申请人会议室预定详情
     * @return
     */
    @Override
    public ResponseMessage selectReservationDetails(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String resId = requestJson.getString("resId");//申请人id
        TXietongMrReservationExample example = new TXietongMrReservationExample();
        TXietongMrReservationExample.Criteria criteria = example.createCriteria();
        criteria.andIsdeleteEqualTo(1);
        criteria.andResIdEqualTo(resId);
        List<TXietongMrReservation> mrReservationList = mrReservationMapper.selectByExample(example);

        if (mrReservationList.size()>0){
            return new ResponseMessage(Code.CODE_OK, "查询成功",mrReservationList);
        }
        return new ResponseMessage(Code.CODE_ERROR, "查询失败");
    }

    /**
     * 申请人取消会议室预定
     * @return
     */
    @Override
    public ResponseMessage updateReservationDetails(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String id = requestJson.getString("id");//申请记录id
        TXietongMrReservationExample example = new TXietongMrReservationExample();
        TXietongMrReservationExample.Criteria criteria = example.createCriteria();
        criteria.andIsdeleteEqualTo(1);
        criteria.andIdEqualTo(id);
        TXietongMrReservation reservation = new TXietongMrReservation();
        reservation.setStatus(2);
        int update = mrReservationMapper.updateByExampleSelective(reservation, example);
        if (update!=1) {
            return new ResponseMessage(Code.CODE_ERROR, "取消失败");
        }
        TXietongMrApplyExample example1 = new TXietongMrApplyExample();
        TXietongMrApplyExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andMrResIdEqualTo(id);
        TXietongMrApply apply = new TXietongMrApply();
        apply.setIsdelete(0);
        int i = applyMapper.updateByExampleSelective(apply, example1);
        if (i!=1) {
            return new ResponseMessage(Code.CODE_ERROR, "取消失败");
        }
        List<TXietongMrApply> tXietongMrApplies = applyMapper.selectByExample(example1);
        TXietongMrApplyRecordExample example2 = new TXietongMrApplyRecordExample();
        TXietongMrApplyRecordExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andApplyIdEqualTo(tXietongMrApplies.get(0).getId());
        TXietongMrApplyRecord mrApplyRecord = new TXietongMrApplyRecord();
        mrApplyRecord.setIsdelete(0);
        int i1 = mrApplyRecordMapper.updateByExampleSelective(mrApplyRecord, example2);
        if (i1!=1) {
            return new ResponseMessage(Code.CODE_ERROR, "取消失败");
        }
        return new ResponseMessage(Code.CODE_OK, "取消成功");
    }

    /**
     * 审核人审核页面查询
     * @return
     */
    @Override
    public ResponseMessage conferenceRoomAudit(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String applyId = requestJson.getString("applyId");//申请人id
        String applyDepId = requestJson.getString("applyDepId");//申请部门id
        String ownerId = requestJson.getString("ownerId");//处理人id
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");
        Page page = new Page();
        int totelCount = applyMapper.count(applyId,applyDepId,ownerId);
        page.init(totelCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
        List<TXietongMrApply> applyList= applyMapper.selectByPage(applyId,applyDepId,ownerId,page.getRowNum(),page.getPageCount());
        page.setList(applyList);
        if (!CollectionUtils.isEmpty(applyList)) {
            return new ResponseMessage(Code.CODE_OK, "查询成功",page);
        }
        return new ResponseMessage(Code.CODE_ERROR, "查询失败");
    }

    /**
     * 审核人审核页面审核
     * @return
     */
    @Override
    public ResponseMessage updateconferenceRoomAudit(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String id = requestJson.getString("id");//审批记录id
        String opinion = requestJson.getString("opinion");//审批意见
        String recComment = requestJson.getString("recComment");//备注
        /*JSONArray owner_ids = requestJson.getJSONArray("owner_ids");//下一步审核人*/
        TXietongMrApplyRecordExample example = new TXietongMrApplyRecordExample();
        TXietongMrApplyRecordExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        TXietongMrApplyRecord record = new TXietongMrApplyRecord();
        record.setOpinion(Integer.valueOf(opinion));
        record.setRecComment(recComment);
        record.setStatus(1);

        int update = mrApplyRecordMapper.updateByExampleSelective(record, example);
        if (update!=1) {
            return new ResponseMessage(Code.CODE_ERROR, "更新失败");
        }
        TXietongMrApplyRecord select = mrApplyRecordMapper.selectByPrimaryKey(id);
        TXietongMrApply apply = new TXietongMrApply();
        apply.setStatus("2");
        TXietongMrApplyExample example1 = new TXietongMrApplyExample();
        TXietongMrApplyExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andIdEqualTo(select.getApplyId());
        int i = applyMapper.updateByExampleSelective(apply, example1);
        if (i!=1) {
            return new ResponseMessage(Code.CODE_ERROR, "更新失败");
        }
        List<TXietongMrApply> tXietongMrApplies = applyMapper.selectByExample(example1);
        TXietongMrReservationExample example2 = new TXietongMrReservationExample();
        TXietongMrReservationExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andIdEqualTo(tXietongMrApplies.get(0).getMrResId());
        TXietongMrReservation reservation = new TXietongMrReservation();
        reservation.setStatus(1);
        int i1 = mrReservationMapper.updateByExampleSelective(reservation, example2);
        if (i1!=1) {
            return new ResponseMessage(Code.CODE_ERROR, "更新失败");
        }
        return new ResponseMessage(Code.CODE_OK, "更新成功");
    }

    @Override
    public ResponseMessage selectUserAll(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String departmentId = requestJson.getString("departmentId");//部门id
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        /*criteria.andIsdeleteEqualTo((short) 1);*/
        criteria.andDepartmentidEqualTo(departmentId);
        List<TUser> userList = userMapper.selectByExample(example);
        if (userList.size()>0) {
            return new ResponseMessage(Code.CODE_OK, "查询成功",userList);
        }
        return new ResponseMessage(Code.CODE_ERROR, "查询失败");

    }
}
