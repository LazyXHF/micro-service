package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.controller.BaseController;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.TXietongConferenceRoomService;
import com.portjs.base.util.Code;
import com.portjs.base.util.DaibanUtil;
import com.portjs.base.util.Page;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, timeout = -1)
public class TXietongConferenceRoomImp extends BaseController implements TXietongConferenceRoomService {
	@Autowired
	private TXietongMeetingroomMapper meetingroomMapper;
	@Autowired
	private TXietongMrApplyMapper mrApplyMapper;
	/*@Autowired
	private TDepartmentMapper departmentMapper;*/
	@Autowired
	private TXietongMrApplyRecordMapper mrApplyRecordMapper;
	@Autowired
	private TXietongDictionaryMapper dictionaryMapper;
	@Autowired
	private TXietongDictionaryMapper txietongDictionaryMapper;
	@Autowired
	private DaibanUtil daibanUtil;
	// 根据用户和用户部门获取可见范围的会议室
	@Override
	public ResponseMessage selectMeetingRoom(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String departmentName = requestJson.getString("departmentName");
		String departmentId = requestJson.getString("departmentId");
		String status = "0";
		String room_id="";
		List<TXietongMeetingroom> meetingRoom = meetingroomMapper.selectMeetingRoomByDepartmentId(departmentName,
				departmentId, status,room_id);
		if (!CollectionUtils.isEmpty(meetingRoom)) {
			return new ResponseMessage(Code.CODE_OK, "查询成功", meetingRoom);
		}
		return new ResponseMessage(Code.CODE_ERROR, "查询失败");
	}

	// 获取会议室申请的详细信息
	@Override
	public ResponseMessage selectConferenceRoom(String requestBody) {
		try {
			JSONObject requestJson = JSONObject.parseObject(requestBody);
			String departmentName = requestJson.getString("departmentName");
			String departmentId = requestJson.getString("departmentId");
			String room_id = requestJson.getString("room_id");
			String beginTime = requestJson.getString("beginTime");
			String endTime = requestJson.getString("endTime");
			String status = "0";
			List<String> ldate = findDates(new SimpleDateFormat("yyyy-MM-dd").parse(beginTime),
					new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
			List<TXietongMeetingroom> meetingRoom = meetingroomMapper.selectMeetingRoomByDepartmentId(departmentName,
					departmentId, status,room_id);
			Map<String, List> map = new LinkedHashMap<String, List>();
			for (int j = 0; j < ldate.size(); j++) {
				List<TXietongMeetingroom> meeting = new ArrayList<TXietongMeetingroom>();
				for (int i = 0; i < meetingRoom.size(); i++) {
					TXietongMeetingroom room = new TXietongMeetingroom();
					List<TXietongMrApply> mr = mrApplyMapper.selectMrApplyMapperByMeetingId(meetingRoom.get(i).getId(),
							ldate.get(j));
					room.setId(meetingRoom.get(i).getId());
					room.setRoomName(meetingRoom.get(i).getRoomName());
					room.setGalleryful(meetingRoom.get(i).getGalleryful());
					room.setMrApply(mr);
					room.setPalce(meetingRoom.get(i).getPalce());
					room.setRemark(meetingRoom.get(i).getRemark());
					meeting.add(room);

				}
				map.put(ldate.get(j), meeting);
			}
			return new ResponseMessage(Code.CODE_OK, "查询成功", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 预定会议室
	@Override
	public ResponseMessage reserveConferenceRoom(String requestBody) {
		try {
			JSONObject requestJson = JSONObject.parseObject(requestBody);
			String meeting_id = requestJson.getString("meeting_id");
			String meeting_name = requestJson.getString("meeting_name");
			String beginTime = requestJson.getString("beginTime");
			String endTime = requestJson.getString("endTime");
			String apply_id = requestJson.getString("apply_id");
			String apply_name = requestJson.getString("apply_name");
			String apply_dep_id = requestJson.getString("apply_dep_id");
			String apply_dep_name = requestJson.getString("apply_dep_name");
			String content = requestJson.getString("content");
			String time_cell = requestJson.getString("time_cell");
			String nextApproverId = requestJson.getString("nextApproverId");
			TXietongMrApply mrApply = new TXietongMrApply();
			mrApply.setId(String.valueOf(UUID.randomUUID()));
			mrApply.setApplyId(apply_id);
			mrApply.setMeetingName(meeting_name);
			mrApply.setApplyName(apply_name);
			mrApply.setApplyDepId(apply_dep_id);
			mrApply.setApplyDepName(apply_dep_name);
			mrApply.setContent(content);
			mrApply.setTime_cell(time_cell);
			mrApply.setBegintime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beginTime));
			mrApply.setEndtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime));
			mrApply.setMeetingId(meeting_id);
			mrApply.setMeetingLeader(requestJson.getString("meetingLeader"));
			mrApply.setMeetingPersonnel(requestJson.getString("meetingPersonnel"));
			mrApply.setSeatCard(Integer.valueOf(requestJson.getString("seatCard")));
			mrApply.setTeaWater(Integer.valueOf(requestJson.getString("teaWater")));
			mrApply.setProjector(Integer.valueOf(requestJson.getString("projector")));
			mrApply.setMicrophone(Integer.valueOf(requestJson.getString("microphone")));
			mrApply.setFilePath(requestJson.getString("filePath"));
			mrApply.setAttendance(requestJson.getString("attendance"));
			int i = mrApplyMapper.insertConferenceRoom(mrApply);
			if (i == 1) {
				TXietongMrApplyRecord mrRecord = new TXietongMrApplyRecord();
				mrRecord.setId(String.valueOf(UUID.randomUUID()));
				mrRecord.setApplyId(mrApply.getId());
				mrRecord.setOwnerId(nextApproverId);
				int a = mrApplyRecordMapper.insert(mrRecord);
				if (a == 1) {
					daibanUtil.insertDaibanRecord(mrRecord.getId(),mrApply.getContent(),"hys",mrRecord.getOwnerId());
					TXietongMrApply mrApply1=mrApplyMapper.selectMrApplyById(mrApply.getId());
					return new ResponseMessage(Code.CODE_OK, "预定成功",mrApply1);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return new ResponseMessage(Code.CODE_ERROR, "预定失败");
	}

	// 会议室预定详情
	@Override
	public ResponseMessage reservationDetails(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String apply_id = requestJson.getString("apply_id");
		String pageNum = requestJson.getString("pageNum");//当前页数
		String pageCount = requestJson.getString("pageCount");//每页显示记录数

		List<TXietongMrApply> mrApply = mrApplyMapper.selectMrApplyByApplyId(apply_id);
		Page page = new Page();
		page.init(mrApply.size(),Integer.valueOf(pageNum),Integer.valueOf(pageCount));
		List<TXietongMrApply> applies =mrApplyMapper.selectMrApplyByPage(apply_id,page.getRowNum(),page.getPageCount());
		page.setList(applies);
		return new ResponseMessage(Code.CODE_OK, "查询成功",page);
	}

	// 取消会议室预定
	@Override
	public ResponseMessage cancelConferenceRoom(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String id = requestJson.getString("id");
		TXietongMrApply apply=mrApplyMapper.selectMrApplyById(id);
		if(apply.getStatus().equals("2")) {
			if(new Date().getTime()>apply.getBegintime().getTime()&&new Date().getTime()<apply.getEndtime().getTime()) {
				return new ResponseMessage(Code.CODE_OK, "取消失败，已在使用中");
			}
		}
		TXietongMrApply mrApply = new TXietongMrApply();
		mrApply.setId(id);
		mrApply.setStatus("0");
		int i = mrApplyMapper.updateMrApplyStatus(mrApply);
		if (i > 0) {
			return new ResponseMessage(Code.CODE_OK, "取消成功");
		}
		return new ResponseMessage(Code.CODE_ERROR, "取消失败");
	}

	// 会议室审批查询页面
	@Override
	public ResponseMessage approveConferenceRoom(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String apply_dep_id = requestJson.getString("apply_dep_id");
		String apply_id = requestJson.getString("apply_id");
		String owner_id = requestJson.getString("owner_id");
		String pageNum = requestJson.getString("pageNum");
        String pageCount = requestJson.getString("pageCount"); 
        int totelCount=mrApplyMapper.selectConferenceRoomCount(apply_dep_id, apply_id,owner_id);
        Page<TXietongMrApply> page=new Page<TXietongMrApply>();
        page.init(totelCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
		List<TXietongMrApply> mrApply = mrApplyMapper.selectConferenceRoomByStatusIsOne(apply_dep_id, apply_id,
				owner_id,page.getRowNum(),page.getPageCount());
		for(TXietongMrApply mrApply1:mrApply) {
			List<TXietongMrApplyRecord>list=mrApplyRecordMapper.selectMrApplyByMrApplyId(mrApply1.getId());
			mrApply1.setApplyRecord(list);
		}
		page.setList(mrApply);
		return new ResponseMessage(Code.CODE_OK, "查询成功", page);
	}

	// 审批人审批
	@Override
	public ResponseMessage updateAfterCheckConferenceRoom(String requestBody) {
		try {
			JSONObject requestJson = JSONObject.parseObject(requestBody);
			String opinion = requestJson.getString("opinion");
			String rec_comment = requestJson.getString("rec_comment");
			String mrRecordId = requestJson.getString("mrRecordId");
			String nextApproverId = requestJson.getString("nextApproverId");
			String mrApplyId = requestJson.getString("id");
			int i = mrApplyRecordMapper.updateAfterCheckConferenceRoom(opinion, rec_comment, mrRecordId);
			
			//查询会议室的物业人员
			  TXietongDictionaryExample example = new TXietongDictionaryExample();
		      example.setOrderByClause("(VALUE_SORT+0)");
		      TXietongDictionaryExample.Criteria criteria = example.createCriteria();
		      criteria.andTypeCodeEqualTo("37");
		      List<TXietongDictionary> dictionary=txietongDictionaryMapper.selectByExample(example);
		      
			if (!nextApproverId.equals("") && nextApproverId != null) {
				if (i > 0) {
					daibanUtil.UpdateDaibanRecord(mrRecordId);
					if (opinion.equals("1")) {
						TXietongMrApply mrApply = new TXietongMrApply();
						mrApply.setStatus("3");
						mrApply.setId(mrApplyId);
						int k = mrApplyMapper.updateMrApplyStatus(mrApply);
						if (k > 0) {
							return new ResponseMessage(Code.CODE_OK, "已拒绝");
						}
					} else {
						for(int j=0;j<dictionary.size();j++) {
							if(nextApproverId.equals(dictionary.get(j).getMidValue())) {
								TXietongMrApply mrApply = new TXietongMrApply();
								mrApply.setStatus("2");
								mrApply.setId(mrApplyId);
								int k = mrApplyMapper.updateMrApplyStatus(mrApply);
							}else {
								TXietongMrApply mrApply = new TXietongMrApply();
								mrApply.setStatus("5");
								mrApply.setId(mrApplyId);
								int k = mrApplyMapper.updateMrApplyStatus(mrApply);
								break;
							}
						}
						TXietongMrApplyRecord mrRecord = new TXietongMrApplyRecord();
						mrRecord.setId(String.valueOf(UUID.randomUUID()));
						mrRecord.setApplyId(mrApplyId);
						mrRecord.setOwnerId(nextApproverId);
						int a = mrApplyRecordMapper.insert(mrRecord);
						if (a == 1) {
							TXietongMrApply mrApply = mrApplyMapper.selectByPrimaryKey(mrApplyId);
							daibanUtil.insertDaibanRecord(mrRecord.getId(),mrApply.getContent(),"hys",mrRecord.getOwnerId());
							return new ResponseMessage(Code.CODE_OK, "审批完成");
						}
					}
				}
			}else {
				if (i > 0) {
					daibanUtil.UpdateDaibanRecord(mrRecordId);
					if (opinion.equals("1")) {
						TXietongMrApply mrApply = new TXietongMrApply();
						mrApply.setStatus("3");
						mrApply.setId(mrApplyId);
						int k = mrApplyMapper.updateMrApplyStatus(mrApply);
						if (k > 0) {
							return new ResponseMessage(Code.CODE_OK, "审批完成");
						}
					} else {
						TXietongMrApply mrApply = new TXietongMrApply();
						mrApply.setStatus("4");
						mrApply.setId(mrApplyId);
						int k = mrApplyMapper.updateMrApplyStatus(mrApply);
						if (k > 0) {
							return new ResponseMessage(Code.CODE_OK, "审批完成");
						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseMessage(Code.CODE_ERROR, "审批失败");
	}

	/**
	 * 根据开始时间和结束时间返回时间段内的时间集合
	 * 
	 * @param dBegin
	 * @param dEnd
	 * @return List
	 */

	public List<String> findDates(Date dBegin, Date dEnd) {
		List<String> lDate = new ArrayList<String>();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		lDate.add(sd.format(dBegin));
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH,1);
			lDate.add(sd.format(calBegin.getTime()));

		}
		lDate.remove(lDate.size()-1);
		return lDate;
	}

}
