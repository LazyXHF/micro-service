package com.portjs.base.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.TXietongMrApplyMapper;
import com.portjs.base.dao.TXietongMrReservationMapper;
import com.portjs.base.entity.TXietongMrApply;
import com.portjs.base.entity.TXietongMrReservation;
import com.portjs.base.service.TXietongMrReservationService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, timeout = -1)
public class TXietongMrReservationServiceImpl implements TXietongMrReservationService {
	@Autowired
	private TXietongMrReservationMapper txietongMrReservationMapper;
	@Autowired
	private TXietongMrApplyMapper txietongMrApplyMapper;

	/**
	 * 会议查询
	 */
	@Override
	public ResponseMessage selectTXietongMrReservation(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String beginTime = requestJson.getString("beginTime");
		String endTime = requestJson.getString("endTime");
		String res_id = requestJson.getString("res_id");
		List<TXietongMrReservation> mrReservation = txietongMrReservationMapper.selectTXietongMrReservation(beginTime,
				endTime, res_id);
		for(int i=0;i<mrReservation.size();i++) {
			if(StringUtils.isEmpty(mrReservation.get(i).getMrId())) {
				if(mrReservation.get(i).getIssue()==3) {
					if(new Date().getTime()<mrReservation.get(i).getBegintime().getTime()) {
						mrReservation.get(i).setStatus(0);
					}else if(new Date().getTime()>mrReservation.get(i).getBegintime().getTime()&&new Date().getTime()<mrReservation.get(i).getEndtime().getTime()) {
						mrReservation.get(i).setStatus(1);
					}else if(new Date().getTime()>mrReservation.get(i).getEndtime().getTime()) {
						mrReservation.get(i).setStatus(2);
					}
				}
				continue;
			}else {
				TXietongMrApply mrApply=txietongMrApplyMapper.selectMrApplyById(mrReservation.get(i).getMrId());
				if(mrApply.getStatus().equals("2")) {
					if(mrReservation.get(i).getIssue()==3) {
						if(new Date().getTime()<mrReservation.get(i).getBegintime().getTime()) {
							mrReservation.get(i).setStatus(0);
						}else if(new Date().getTime()>mrReservation.get(i).getBegintime().getTime()&&new Date().getTime()<mrReservation.get(i).getEndtime().getTime()) {
							mrReservation.get(i).setStatus(1);
						}else if(new Date().getTime()>mrReservation.get(i).getEndtime().getTime()) {
							mrReservation.get(i).setStatus(2);
						}
					}else {
						mrReservation.get(i).setIssue(2);
					}
					
				}else if(mrApply.getStatus().equals("3")) {
					mrReservation.get(i).setIssue(1);
				}
			}
			
		}
		return new ResponseMessage(Code.CODE_OK, "查询成功", mrReservation);
	}

	/**
	 * 新建会议
	 */
	@Override
	public ResponseMessage insertTXietongMrReservation(String requestBody) {
		try {
			JSONObject requestJson = JSONObject.parseObject(requestBody);
			TXietongMrReservation mrReservation=new TXietongMrReservation();
			mrReservation.setId(String.valueOf(UUID.randomUUID()));
			mrReservation.setMeetingSubject(requestJson.getString("meeting_subject"));
			mrReservation.setBegintime(new SimpleDateFormat("yyyy-MM-dd").parse(requestJson.getString("beginTime")));
			mrReservation.setEndtime(new SimpleDateFormat("yyyy-MM-dd").parse(requestJson.getString("endTime")));
			mrReservation.setResId(requestJson.getString("res_id"));
			mrReservation.setResName(requestJson.getString("res_name"));
			mrReservation.setResDepId(requestJson.getString("res_dep_id"));
			mrReservation.setResDepName(requestJson.getString("res_dep_name"));
			mrReservation.setParticipants(requestJson.getString("participants"));
			mrReservation.setMeetingId(requestJson.getString("meeting_id"));
			mrReservation.setMeetingName(requestJson.getString("meeting_name"));
			mrReservation.setMrId(requestJson.getString("mr_id"));
			mrReservation.setMeetingSupplies(requestJson.getString("meeting_supplies"));
			mrReservation.setMeetingStatus(requestJson.getString("meeting_status"));
			mrReservation.setMeetingContent(requestJson.getString("meeting_content"));
			mrReservation.setFilepath(requestJson.getString("filepath"));
			if(requestJson.getString("mr_id")!=null && !requestJson.getString("mr_id").equals("")) {
				mrReservation.setStatus(0);
				mrReservation.setIssue(0);
			}else {
				mrReservation.setStatus(2);
				mrReservation.setIssue(1);
			}
			
			int i=txietongMrReservationMapper.insert(mrReservation);
			if(i==1) {
				return new ResponseMessage(Code.CODE_OK, "新增成功" );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseMessage(Code.CODE_ERROR, "新增失败" );
	}
	//编辑会议
	@Override
	public ResponseMessage updateTXietongMrReservation(String requestBody) {
		try {
			JSONObject requestJson = JSONObject.parseObject(requestBody);
			TXietongMrReservation mrReservation=new TXietongMrReservation();
			mrReservation.setId(requestJson.getString("id"));
			mrReservation.setMeetingSubject(requestJson.getString("meeting_subject"));
			mrReservation.setBegintime(new SimpleDateFormat("yyyy-MM-dd").parse(requestJson.getString("beginTime")));
			mrReservation.setEndtime(new SimpleDateFormat("yyyy-MM-dd").parse(requestJson.getString("endTime")));
			mrReservation.setResId(requestJson.getString("res_id"));
			mrReservation.setResName(requestJson.getString("res_name"));
			mrReservation.setResDepId(requestJson.getString("res_dep_id"));
			mrReservation.setResDepName(requestJson.getString("res_dep_name"));
			mrReservation.setParticipants(requestJson.getString("participants"));
			mrReservation.setMeetingId(requestJson.getString("meeting_id"));
			mrReservation.setMeetingName(requestJson.getString("meeting_name"));
			mrReservation.setMrId(requestJson.getString("mr_id"));
			mrReservation.setMeetingSupplies(requestJson.getString("meeting_supplies"));
			mrReservation.setMeetingStatus(requestJson.getString("meeting_status"));
			mrReservation.setMeetingContent(requestJson.getString("meeting_content"));
			mrReservation.setFilepath(requestJson.getString("filepath"));
			if(!StringUtils.isEmpty(requestJson.getString("mr_id"))) {
				mrReservation.setStatus(0);
				mrReservation.setIssue(0);
			}else {
				mrReservation.setStatus(0);
				mrReservation.setIssue(2);
			}
			int i=txietongMrReservationMapper.updateByPrimaryKey(mrReservation);
			if(i==1) {
				return new ResponseMessage(Code.CODE_OK, "修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseMessage(Code.CODE_ERROR, "修改失败" );
	}
    //会议删除
	@Override
	public ResponseMessage deleteTXietongMrReservation(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String ids=requestJson.getString("ids");
		int i=txietongMrReservationMapper.deleteTXietongMrReservation(ids);
		if(i>0) {
			return new ResponseMessage(Code.CODE_OK, "删除成功");
		}
		return new ResponseMessage(Code.CODE_ERROR, "删除失败" );
	}
    //待开会议查询
	@Override
	public ResponseMessage waitingTXietongMrReservation(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String res_id=requestJson.getString("res_id");
		List<TXietongMrReservation>list=txietongMrReservationMapper.selectWaitingTXietongMrReservation(res_id);
		return new ResponseMessage(Code.CODE_OK, "查询成功",list);
	}
    //撤销待开会议
	@Override
	public ResponseMessage revocationTXietongMrReservation(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String id=requestJson.getString("id");
		TXietongMrReservation mrReservation=new TXietongMrReservation();
		mrReservation.setIssue(2);
		mrReservation.setId(id);
		int i=txietongMrReservationMapper.updateByPrimaryKey(mrReservation);
		if(i==1) {
			return new ResponseMessage(Code.CODE_OK, "撤销成功");
		}
		return  new ResponseMessage(Code.CODE_ERROR, "撤销失败");
	}
     
	//会议的查询详情
	@Override
	public ResponseMessage txietongMrReservationInformation(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String id=requestJson.getString("id");
		TXietongMrReservation mrReservation=txietongMrReservationMapper.selectByPrimaryKey(id);
		return new ResponseMessage(Code.CODE_OK, "查询成功",mrReservation);
	}
    //已开会议的查询详情
	@Override
	public ResponseMessage txietongMrReservationIsOver(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String meeting_subject=requestJson.getString("meeting_subject");
		String beginTime=requestJson.getString("beginTime");
		String endTime=requestJson.getString("endTime");
		String res_id=requestJson.getString("res_id");
		List<TXietongMrReservation>list=txietongMrReservationMapper.txietongMrReservationIsOver(meeting_subject,beginTime,endTime,res_id);
		return new ResponseMessage(Code.CODE_OK, "查询成功",list);
	}
    //会议发布
	@Override
	public ResponseMessage txietongMrReservationPublish(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		TXietongMrReservation mrReservation=new TXietongMrReservation();
		String id =requestJson.getString("id");
		mrReservation.setId(id);
		mrReservation.setIssue(3);
		int i=txietongMrReservationMapper.updateByPrimaryKey(mrReservation);
		if(i==1) {
			return new ResponseMessage(Code.CODE_OK, "发布成功");
		}
		return new ResponseMessage(Code.CODE_ERROR, "发布失败");
	}

}
