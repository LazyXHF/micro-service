package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.controller.BaseController;
import com.portjs.base.dao.TXietongMeetingroomMapper;
import com.portjs.base.entity.TXietongMeetingroom;
import com.portjs.base.entity.TXietongMeetingroomExample;
import com.portjs.base.service.TXietongMeetingroomService;
import com.portjs.base.util.Code;
import com.portjs.base.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, timeout = -1)
public class TXietongMeetingRoom extends BaseController implements TXietongMeetingroomService {
	 @Autowired
	 private TXietongMeetingroomMapper meetingroomMapper;
	//添加会议室信息
	@Override
	public ResponseMessage insertMeetingroom(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
        String roomName = requestJson.getString("roomName");//会议室名称
        String palce = requestJson.getString("palce");//会议室地点
        String status = requestJson.getString("status");//会议室状态
        String apply = requestJson.getString("apply");//申请范围
        String galleryful = requestJson.getString("galleryful");//可容纳人数
        TXietongMeetingroomExample example = new TXietongMeetingroomExample();
        TXietongMeetingroomExample.Criteria criteria = example.createCriteria();
        criteria.andRoomNameEqualTo(roomName);
        criteria.andIsdeleteEqualTo(1);

        List<TXietongMeetingroom> meetingroomList = meetingroomMapper.selectByExample(example);
        if(meetingroomList.size()>0){
            return new ResponseMessage(Code.CODE_ERROR, "当前会议室名称已存在");
        }

        TXietongMeetingroom meetingroom = new TXietongMeetingroom();
        meetingroom.setId(UUID.randomUUID().toString());
        meetingroom.setIsdelete(1);
        meetingroom.setRoomName(roomName);
        meetingroom.setGalleryful(galleryful);;
        meetingroom.setStatus(Integer.valueOf(status));
        meetingroom.setApply(apply);
        meetingroom.setPalce(palce);
        int insert = meetingroomMapper.insertSelective(meetingroom);
        if (insert==1) {
            return new ResponseMessage(Code.CODE_OK, "新增成功");
        }
        return new ResponseMessage(Code.CODE_ERROR, "新增失败");
	}

    //查询会议室信息
	@Override
	public ResponseMessage selectMeetingroom(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String departmentName=requestJson.getString("departmentName");
		String departmentId=requestJson.getString("departmentId");
		String status="";
		String room_id="";
		List<TXietongMeetingroom>meetingRoom=meetingroomMapper.selectMeetingRoomByDepartmentId(departmentName,departmentId,status,room_id);
		if (meetingRoom.size()>0) {
            return new ResponseMessage(Code.CODE_OK, "查询成功",meetingRoom);
        }
        return new ResponseMessage(Code.CODE_ERROR, "未有可见会议室");
	}
    //编辑会议室之前获取该会议室信息
	@Override
	public ResponseMessage selectMeetingroomBeforUpdate(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String id=requestJson.getString("id");
		TXietongMeetingroom meetingRoom =meetingroomMapper.selectMeetingRoomById(id);
		if (meetingRoom!=null) {
            return new ResponseMessage(Code.CODE_OK, "查询成功",meetingRoom);
        }
        return new ResponseMessage(Code.CODE_ERROR, "查询失败");
	}
	//修改会议室的信息
	@Override
	public ResponseMessage updateMeetingroom(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String id=requestJson.getString("id");
        String roomName = requestJson.getString("roomName");//会议室名称
        String palce = requestJson.getString("palce");//会议室地点
        String status = requestJson.getString("status");//会议室状态
        String apply = requestJson.getString("apply");//申请范围
        String galleryful = requestJson.getString("galleryful");//可容纳人数
        List<TXietongMeetingroom>meetingRoom=meetingroomMapper.selectMeetingroomById(id);
        for(TXietongMeetingroom room:meetingRoom) {
        	if(room.getRoomName().equals(roomName)) {
        		return new ResponseMessage(Code.CODE_ERROR, "当前会议室名称已存在");
        	}
        }
        TXietongMeetingroom room=new TXietongMeetingroom();
        room.setId(id);
        room.setRoomName(roomName);
        room.setPalce(palce);
        room.setStatus(Integer.valueOf(status));
        room.setApply(apply);
        room.setGalleryful(galleryful);
        int i=meetingroomMapper.updateTXietongMeetingroom(room);
        if (i==1) {
            return new ResponseMessage(Code.CODE_OK, "修改成功");
        }
        return new ResponseMessage(Code.CODE_ERROR, "修改失败");
	}
    //删除会议室
	@Override
	public ResponseMessage deleteMeetingroom(String requestBody) {
		JSONObject requestJson = JSONObject.parseObject(requestBody);
		String id=requestJson.getString("id");
		TXietongMeetingroom room=new TXietongMeetingroom();
	    room.setIsdelete(0);
	    room.setId(id);
		int i=meetingroomMapper.updateTXietongMeetingroom(room);
		if (i==1) {
            return new ResponseMessage(Code.CODE_OK, "删除成功");
        }
        return new ResponseMessage(Code.CODE_ERROR, "删除失败");
	}

	

}
