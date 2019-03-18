package com.portjs.base.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.dao.*;
import com.portjs.base.entity.*;
import com.portjs.base.service.DailyLeadershipService;
import com.portjs.base.util.Code;
import com.portjs.base.util.DaibanUtil;
import com.portjs.base.util.ResponseMessage;
import com.portjs.base.util.WDWUtil;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by dengshuangzhen on 2018\12\17 0017
 */
@Service
@Transactional
public class DailyLeadershipImpl implements DailyLeadershipService {

    /*static final String tag = "XietongSysLogService======";
    static final Logger logger = LoggerFactory.getLogger(XietongSysLogService.class);*/

    @Autowired
    private TXietongAgendaMapper agendaMapper;
    @Autowired
    private TXietongAgendaHumanMapper agendaHumanMapper;
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private TXietongAgendaReleaseMapper agendaReleaseMapper;
    @Autowired
    private TXietongUserMinisterRelationMapper userMinisterRelationMapper;
    @Autowired
    private TXietongDictionaryMapper dictionaryMapper;
    @Autowired
    private TXietongAgendaProcessMapper agendaProcessMapper;
    @Autowired
    private TXietongAgendaRecordMapper agendaRecordMapper;
    @Autowired
    private TDepartmentMapper departmentMapper;
    @Autowired
    private DaibanUtil daibanUtil;

    /**
     * 查询领导日程(按领导查)
     * begin_time 开始时间
     * end_time 结束时间
     * participant_value 领导名称
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage selectLeadershipAgenda(String requestBody) throws Exception {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String begin_time = requestJson.getString("begin_time");
        String end_time = requestJson.getString("end_time");
        String participant_id = requestJson.getString("participant_id");
        //String ispublish = requestJson.getString("ispublish");//是否已发布 0未发布 1已发布

        Map map = selectMap(begin_time, end_time, participant_id);
        Map map1 = new TreeMap();
        map1.put(participant_id, map);
        if (map.size() > 0) {
            return new ResponseMessage(Code.CODE_OK, "查询成功", map1);
        } else {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }

    }

    @Override
    public ResponseMessage selectLeadershipAgendaByNull(String requestBody) throws Exception {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String begin_time = requestJson.getString("begin_time");
        String end_time = requestJson.getString("end_time");
        JSONArray participant_ids = requestJson.getJSONArray("participant_ids");
        //String ispublish = requestJson.getString("ispublish");//是否已发布 0未发布 1已发布
        /*Map map1 = new TreeMap();*/
        Map map1 = new TreeMap();
        for (Object participant_id : participant_ids) {
            Map map = selectMap(begin_time, end_time, participant_id.toString());
            String name = userMapper.selectById(participant_id.toString());
            map1.put(name + "~~" + participant_id, map);
            //map1.put(participant_id.toString(),map);
        }
        if (!CollectionUtils.isEmpty(map1)) {
            return new ResponseMessage(Code.CODE_OK, "查询成功", map1);
        }
        return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        /*TXietongDepartmentExample example = new TXietongDepartmentExample();
        TXietongDepartmentExample.Criteria criteria1 = example.createCriteria();
        criteria1.andNameEqualTo("部领导");

        List<TXietongDepartment> departmentList = departmentMapper.selectByExample(example);

        TXietongUserExample userExample = new TXietongUserExample();
        userExample.setOrderByClause("sort");
        TXietongUserExample.Criteria criteria = userExample.createCriteria();
        Short aa = 0;
        criteria.andIsdeleteNotEqualTo(aa);
        criteria.andDepartmentidEqualTo(departmentList.get(0).getId());
        List<TXietongUser> userList = userMapper.selectByExample(userExample);

            Map map1 = new TreeMap();
            for (TXietongUser user :userList) {

                Map map = selectMap(begin_time, end_time, user.getNameCn());
                map1.put(user.getNameCn(),map);
            }
            if (!CollectionUtils.isEmpty(map1)) {
                return new ResponseMessage(Code.CODE_OK, "查询成功", map1);
            } else {
                return new ResponseMessage(Code.CODE_ERROR, "查询失败");
            }*/
    }

    /**
     * 查询领导日程(按日期查)
     * begin_time 开始时间
     * end_time 结束时间
     * participant_value 领导名称
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage selectLeadershipAgendaByTime(String requestBody) throws Exception {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String begin_time = requestJson.getString("begin_time");
        String end_time = requestJson.getString("end_time");
        String participant_id = requestJson.getString("participant_id");
        //String ispublish = requestJson.getString("ispublish");//是否已发布 0未发布 1已发布
        Map map = selectMap(begin_time, end_time, participant_id);
            /*Map map1 = new HashMap();
            map1.put(participant_id,map);*/
        if (!CollectionUtils.isEmpty(map)) {
            return new ResponseMessage(Code.CODE_OK, "查询成功", map);
        } else {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
    }

    /**
     * 领导填写页查询
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage selectAgenda(String requestBody) throws Exception {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String ministerId = requestJson.getString("ministerId");//领导人id
        String begin_time = requestJson.getString("begin_time");//开始时间
        String end_time = requestJson.getString("end_time");//结束时间
        //String ispublish = requestJson.getString("ispublish");//是否已发布 这里默认传0查所有的
        TUser user = userMapper.selectByPrimaryKey(ministerId);
        Map map = selectMap(begin_time, end_time, user.getNameCn());
        if (map == null) {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", map);
    }


    public Map selectMap(String begin_time, String end_time, String participant_id) throws Exception {

        TXietongAgenda agenda = new TXietongAgenda();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!begin_time.isEmpty()) {
            agenda.setBeginTime(format.parse(begin_time));
        }
        if (!end_time.isEmpty()) {
            agenda.setEndTime(format.parse(end_time));
        }

        agenda.setRemark(participant_id);
        /*if(ispublish==1 || ispublish==0){
            agenda.setIspublish(ispublish);
        }*/
        List<TXietongAgenda> agendaList = agendaMapper.selectAgendaByTime(agenda);
        Map map = new TreeMap();
        SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd");
        //得到输入开始时间与结束时间的差
        long a = (e.parse(end_time).getTime() - e.parse(begin_time).getTime()) / (24 * 60 * 60 * 1000) + 1;
        for (int j = 0; j < a; j++) {
            List list1 = new ArrayList();
            for (int i = 0; i < agendaList.size(); i++) {
                TXietongAgendaHumanExample example = new TXietongAgendaHumanExample();
                //example.setOrderByClause("");
                TXietongAgendaHumanExample.Criteria criteria = example.createCriteria();
                criteria.andAgendaIdEqualTo(agendaList.get(i).getId());
                criteria.andIsdeleteEqualTo(1);
                List<TXietongAgendaHuman> agendaHumanList = agendaHumanMapper.selectByExample(example);
                agendaList.get(i).setList(agendaHumanList);
                long diff = (agendaList.get(i).getBeginTime().getTime() - e.parse(begin_time).getTime()) / (24 * 60 * 60 * 1000);//这样得到的差值是微秒级别
                if (j == diff) {
                    list1.add(agendaList.get(i));
                }
            }
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(e.parse(begin_time));
            rightNow.add(Calendar.DAY_OF_YEAR, j);

            Date dt1 = rightNow.getTime();
            switch (rightNow.get(Calendar.DAY_OF_WEEK) - 1) {
                case 0:
                    map.put(e.format(dt1) + "~~" + "星期日", list1);
                    break;
                case 1:
                    map.put(e.format(dt1) + "~~" + "星期一", list1);
                    break;
                case 2:
                    map.put(e.format(dt1) + "~~" + "星期二", list1);
                    break;
                case 3:
                    map.put(e.format(dt1) + "~~" + "星期三", list1);
                    break;
                case 4:
                    map.put(e.format(dt1) + "~~" + "星期四", list1);
                    break;
                case 5:
                    map.put(e.format(dt1) + "~~" + "星期五", list1);
                    break;
                case 6:
                    map.put(e.format(dt1) + "~~" + "星期六", list1);
                    break;
                default:
                    map.put("error", "服务器异常");

            }

        }
        return map;

    }

    /**
     * 查询可见领导
     *
     * @return
     */
    @Override
    public ResponseMessage selectLeader(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String visualId = requestJson.getString("visualId");//可见人id

        TXietongUserMinisterRelationExample example1 = new TXietongUserMinisterRelationExample();
        TXietongUserMinisterRelationExample.Criteria criteria2 = example1.createCriteria();
        criteria2.andVisualIdEqualTo(visualId);
        criteria2.andStatusEqualTo("0");
        List<TXietongUserMinisterRelation> relations = userMinisterRelationMapper.selectByExample(example1);

        //部领导排序
        TreeSet<TUser> users = new TreeSet<>(new Comparator<TUser>() {
            @Override
            public int compare(TUser o1, TUser o2) {
                return o1.getSort() - o2.getSort();
            }
        });

        for (TXietongUserMinisterRelation relation : relations) {
            TUser user = userMapper.selectByPrimaryKey(relation.getMinisterId());
            if (StringUtils.isEmpty(user)) {
                return new ResponseMessage(Code.CODE_ERROR, "查询失败");
            }
            users.add(user);

        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", users);


        /*TXietongDepartmentExample example = new TXietongDepartmentExample();
        TXietongDepartmentExample.Criteria criteria1 = example.createCriteria();
        criteria1.andNameEqualTo("部领导");

        List<TXietongDepartment> departmentList = departmentMapper.selectByExample(example);

        TXietongUserExample userExample = new TXietongUserExample();
        userExample.setOrderByClause("sort");
        TXietongUserExample.Criteria criteria = userExample.createCriteria();
        Short aa = 0;
            criteria.andIsdeleteNotEqualTo(aa);
            criteria.andDepartmentidEqualTo(departmentList.get(0).getId());
        List<TXietongUser> userList = userMapper.selectByExample(userExample);
        if (!CollectionUtils.isEmpty(userList)) {
            return new ResponseMessage(Code.CODE_OK, "查询成功", userList);
        } else {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }*/

    }

    /**
     * 添加领导日程
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage insertLeadershipAgenda(String requestBody) throws Exception {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String begin_time = requestJson.getString("begin_time");//开始时间
        String end_time = requestJson.getString("end_time");//结束时间
        String meeting_subjet = requestJson.getString("meeting_subjet");//会议名称
        String meeting_place = requestJson.getString("meeting_place");//会议地点
        String participant_ids = requestJson.getString("participant_ids");//领导id数组
        String remark = requestJson.getString("remark");//备注
        String createrId = requestJson.getString("createrId");//创建人id(登录人id)
        JSONArray participant_id = JSONObject.parseArray(participant_ids);
        TXietongAgenda agenda = new TXietongAgenda();
        agenda.setId(UUID.randomUUID().toString());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        agenda.setBeginTime(format.parse(begin_time));
        agenda.setEndTime(format.parse(end_time));
        agenda.setMeetingPlace(meeting_place);
        agenda.setMeetingSubject(meeting_subjet);
        agenda.setRemark(remark);
        agenda.setIsdelete(1);
        agenda.setIspublish(0);
        agenda.setCreaterid(createrId);
        //agenda.setCreatetime(new java.util.Date());
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String str = df.format(format.parse(begin_time));
        int a = Integer.parseInt(str);
        if (a >= 0 && a <= 12) {
            agenda.setAmPm(0);
        } else {
            agenda.setAmPm(1);
        }
           /* TXietongAgendaExample example = new TXietongAgendaExample();
            TXietongAgendaExample.Criteria criteria = example.createCriteria();
            criteria.andMeetingSubjectEqualTo(meeting_subjet);
            List<TXietongAgenda> agenda1 = agendaMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(agenda1)){
                return new ResponseMessage(Code.CODE_ERROR, "会议名称已存在");
            }*/

        int sign = agendaMapper.insert(agenda);
        if (sign != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "新增失败");
        }
        TXietongAgendaHuman agendaHuman = new TXietongAgendaHuman();
        for (int i = 0; i < participant_id.size(); i++) {
            agendaHuman.setId(UUID.randomUUID().toString());
            agendaHuman.setAgendaId(agenda.getId());
            agendaHuman.setAmPm(agenda.getAmPm());
            agendaHuman.setIsdelete(1);
            String name_cn = userMapper.selectById(participant_id.getString(i));
            agendaHuman.setParticipantValue(name_cn);
            agendaHuman.setParticipantId(participant_id.getString(i));
            //agendaHuman.setCreatetime(new java.util.Date());
            agendaHuman.setBeginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(begin_time));
            int flag = agendaHumanMapper.insert(agendaHuman);
            if (flag != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "新增失败");
            }
        }
        return new ResponseMessage(Code.CODE_OK, "新增成功");
    }

  /*  //批量新增领导日程
    @Override
    public ResponseMessage insertAllLeadershipAgenda(String requestBody) throws Exception {
        //JSONObject requestJson = JSONObject.parseObject(requestBody);
        JSONArray requestJson = JSONArray.parseArray(requestBody);
        for (int i = 0; i < requestJson.size(); i++) {
            Map map = (Map) requestJson.get(i);
            String begin_time = map.get("begin_time").toString();//开始时间
            String end_time = map.get("end_time").toString();//结束时间

            List participant_ids = (List) map.get("participant_ids");//领导id数组
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //删除领导所有日程
            for (Object participant_id : participant_ids) {
                TXietongAgenda agenda = new TXietongAgenda();
                if (!begin_time.isEmpty()) {
                    String begin[] = begin_time.split(" ");
                    String beginTime = begin[0] + " 00:00:00";
                    agenda.setBeginTime(format.parse(beginTime));
                }
                if (!end_time.isEmpty()) {
                    String begin[] = end_time.split(" ");
                    String endTime = begin[0] + " 23:59:59";
                    agenda.setEndTime(format.parse(endTime));
                }

                agenda.setRemark(participant_id.toString());

                List<TXietongAgenda> agendas = agendaMapper.selectAgendaByTime(agenda);
                for (TXietongAgenda agenda1 : agendas) {
                    TXietongAgenda agenda2 = new TXietongAgenda();
                    agenda2.setId(agenda1.getId());
                    agenda2.setIsdelete(0);

                    //删除日程表
                    int update = agendaMapper.updateByPrimaryKeySelective(agenda2);
                    if (update != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "新增失败");
                    }
                    TXietongAgendaHumanExample humanExample = new TXietongAgendaHumanExample();
                    TXietongAgendaHumanExample.Criteria criteria = humanExample.createCriteria();
                    criteria.andAgendaIdEqualTo(agenda1.getId());

                    TXietongAgendaHuman human = new TXietongAgendaHuman();
                    human.setIsdelete(0);

                    //删除领导表
                    int update1 = agendaHumanMapper.updateByExampleSelective(human, humanExample);
                    if (update1 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "新增失败");
                    }
                }

            }
        }

        for (int i = 0; i < requestJson.size(); i++) {
            Map map = (Map) requestJson.get(i);
            String begin_time = map.get("begin_time").toString();//开始时间
            String end_time = map.get("end_time").toString();//结束时间
            String meeting_subjet = map.get("meeting_subjet").toString();//会议名称
            String meeting_place = map.get("meeting_place").toString();//会议地点
            List participant_ids = (List) map.get("participant_ids");//领导id数组
            String ispublish = map.get("ispublish").toString();//状态
            String amPm = map.get("amPm").toString();//0上午1下午2全天
            *//*ArrayList participant_ids =(ArrayList)*//*
            String remark = map.get("remark").toString();//备注
            String createrId = map.get("createrId").toString();//创建人id(登录人id)


            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            TXietongAgenda agenda = new TXietongAgenda();
            agenda.setId(UUID.randomUUID().toString());

            agenda.setBeginTime(format.parse(begin_time));
            agenda.setEndTime(format.parse(end_time));
            agenda.setMeetingPlace(meeting_place);
            agenda.setMeetingSubject(meeting_subjet);
            agenda.setRemark(remark);
            agenda.setIsdelete(1);
            if(ispublish.isEmpty()){
                agenda.setIspublish(0);
            }else {
                agenda.setIspublish(Integer.valueOf(ispublish));
            }



            agenda.setCreaterid(createrId);
            //agenda.setCreatetime(new java.util.Date());
            agenda.setAmPm(Integer.valueOf(amPm));

            *//*TXietongAgendaExample example = new TXietongAgendaExample();
            TXietongAgendaExample.Criteria criteria = example.createCriteria();
            criteria.andMeetingSubjectEqualTo(meeting_subjet);
            List<TXietongAgenda> agenda1 = agendaMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(agenda1)){
                return new ResponseMessage(Code.CODE_ERROR, "会议名称已存在");
            }*//*
            //新增领导日程表
            int sign = agendaMapper.insert(agenda);
            if (sign != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "新增失败");
            }
            TXietongAgendaHuman agendaHuman = new TXietongAgendaHuman();
            for (int j = 0; j < participant_ids.size(); j++) {
                agendaHuman.setId(UUID.randomUUID().toString());
                agendaHuman.setAgendaId(agenda.getId());
                agendaHuman.setAmPm(agenda.getAmPm());
                agendaHuman.setIsdelete(1);
                String name_cn = userMapper.selectById(participant_ids.get(j).toString());
                agendaHuman.setParticipantValue(name_cn);
                agendaHuman.setParticipantId(participant_ids.get(j).toString());
                //agendaHuman.setCreatetime(new java.util.Date());
                agendaHuman.setBeginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(begin_time));
                //新增领导表
                int flag = agendaHumanMapper.insert(agendaHuman);
                if (flag != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "新增失败");
                }
            }
        }
        return new ResponseMessage(Code.CODE_OK, "新增成功");
        *//*String begin_time = requestJson.getString("begin_time");//开始时间
        String end_time = requestJson.getString("end_time");//结束时间
        String meeting_subjet = requestJson.getString("meeting_subjet");//会议名称
        String meeting_place = requestJson.getString("meeting_place");//会议地点
        String participant_ids = requestJson.getString("participant_ids");//领导id数组
        String remark = requestJson.getString("remark");//备注
        String createrId = requestJson.getString("createrId");//创建人id(登录人id)
        JSONArray participant_id = JSONObject.parseArray(participant_ids);*//*


    }*/

    /**
     * 根据会议id删除会议以及关联表新建删除
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage deleteLeadershipAgenda(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        JSONArray agenda_ids = requestJson.getJSONArray("agenda_ids");//会议id
        TXietongAgenda agenda = new TXietongAgenda();

        for (Object agenda_id : agenda_ids) {
            agenda.setId(agenda_id.toString());
            agenda.setIsdelete(0);
            int i = agendaMapper.updateByPrimaryKeySelective(agenda);
            if (i != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "删除失败");
            }
            TXietongAgendaHumanExample agendaHumanExample = new TXietongAgendaHumanExample();
            TXietongAgendaHumanExample.Criteria criteria = agendaHumanExample.createCriteria();
            criteria.andAgendaIdEqualTo(agenda_id.toString());
            TXietongAgendaHuman agendaHuman = new TXietongAgendaHuman();
            agendaHuman.setIsdelete(0);
            int j = agendaHumanMapper.updateByExampleSelective(agendaHuman, agendaHumanExample);
            if (j == 0) {
                return new ResponseMessage(Code.CODE_ERROR, "删除失败");
            }
        }


        return new ResponseMessage(Code.CODE_OK, "删除成功");
    }

    /**
     * 根据会议id删除会议以及关联表审核删除
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage deleteLeadershipAgenda1(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        JSONArray agenda_ids = requestJson.getJSONArray("agenda_ids");//会议id
        TXietongAgenda agenda = new TXietongAgenda();

        for (Object agenda_id : agenda_ids) {
            agenda.setId(agenda_id.toString());
            agenda.setIsdelete(0);
            int i = agendaMapper.updateByPrimaryKeySelective(agenda);
            if (i != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "删除失败");
            }
            TXietongAgendaHumanExample agendaHumanExample = new TXietongAgendaHumanExample();
            TXietongAgendaHumanExample.Criteria criteria = agendaHumanExample.createCriteria();
            criteria.andAgendaIdEqualTo(agenda_id.toString());
            TXietongAgendaHuman agendaHuman = new TXietongAgendaHuman();
            agendaHuman.setIsdelete(0);
            int j = agendaHumanMapper.updateByExampleSelective(agendaHuman, agendaHumanExample);
            if (j == 0) {
                return new ResponseMessage(Code.CODE_ERROR, "删除失败");
            }
        }
        TXietongAgendaExample example3 = new TXietongAgendaExample();
        TXietongAgendaExample.Criteria criteria3 = example3.createCriteria();
        criteria3.andIsdeleteEqualTo(1);
        criteria3.andIspublishEqualTo(1);
        List<TXietongAgenda> agenda2 = agendaMapper.selectByExample(example3);
        if (agenda2.size() > 0) {
            return new ResponseMessage(Code.CODE_OK, "删除成功");
        }


        TXietongAgendaProcessExample example1 = new TXietongAgendaProcessExample();
        TXietongAgendaProcessExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andStatusEqualTo(0);
        TXietongAgendaProcess process = new TXietongAgendaProcess();
        process.setStatus(2);
        int update = agendaProcessMapper.updateByExampleSelective(process, example1);


        if (update == 1) {
            TXietongAgendaRecordExample example2 = new TXietongAgendaRecordExample();
            TXietongAgendaRecordExample.Criteria criteria2 = example2.createCriteria();
            criteria2.andRstatusEqualTo("0");
            TXietongAgendaRecord agendaRecord = new TXietongAgendaRecord();
            agendaRecord.setRstatus("2");
            int update1 = agendaRecordMapper.updateByExampleSelective(agendaRecord, example2);
            if (update1 == 1) {
                return new ResponseMessage(Code.CODE_OK, "删除成功");
            }

        }


        return new ResponseMessage(Code.CODE_OK, "删除成功");
    }

    /**
     * 根据会议id修改会议以及关联表
     *
     * @param requestBody
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMessage updateLeadershipAgenda(String requestBody) throws Exception {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String agenda_id = requestJson.getString("agenda_id");//会议id
        String meeting_subjet = requestJson.getString("meeting_subjet");//会议名称
        String meeting_place = requestJson.getString("meeting_place");//会议地点
        JSONArray participant_ids = requestJson.getJSONArray("participant_ids");//参与领导id
        String remark = requestJson.getString("remark");//备注
        String ispublish = requestJson.getString("ispublish");//状态
        String amPm = requestJson.getString("amPm");//0上午1下午2全天
        String begin_time = requestJson.getString("begin_time");//开始时间
        String end_time = requestJson.getString("end_time");//结束时间

        /*TXietongAgendaExample example = new TXietongAgendaExample();
        TXietongAgendaExample.Criteria criteria = example.createCriteria();
        criteria.andMeetingSubjectEqualTo(meeting_subjet);
        criteria.andIsdeleteEqualTo(1);
        List<TXietongAgenda> agenda1 = agendaMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(agenda1)){
            for (TXietongAgenda agenda :agenda1) {
                if (!agenda.getId().equals(agenda_id)){
                    return new ResponseMessage(Code.CODE_ERROR, "会议名称已存在");
                }
            }
        }*/
        TXietongAgenda agenda = new TXietongAgenda();
        agenda.setId(agenda_id);
        agenda.setMeetingSubject(meeting_subjet);
        agenda.setMeetingPlace(meeting_place);
        agenda.setRemark(remark);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        agenda.setBeginTime(format.parse(begin_time));
        agenda.setEndTime(format.parse(end_time));
        if (!"1".equals(ispublish)) {
            agenda.setIspublish(0);
        }
        TXietongAgendaHuman agendaHuman = new TXietongAgendaHuman();

        agenda.setAmPm(Integer.valueOf(amPm));
        agendaHuman.setAmPm(Integer.valueOf(amPm));

        //修改日程表
        int i = agendaMapper.updateByPrimaryKeySelective(agenda);
        if (i != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "修改失败");
        }

        //删除对应关系
        TXietongAgendaHumanExample agendaHumanExample = new TXietongAgendaHumanExample();
        TXietongAgendaHumanExample.Criteria criteria1 = agendaHumanExample.createCriteria();
        criteria1.andAgendaIdEqualTo(agenda_id);
        TXietongAgendaHuman agendaHuman1 = new TXietongAgendaHuman();
        agendaHuman1.setIsdelete(0);
        int b = agendaHumanMapper.updateByExampleSelective(agendaHuman1, agendaHumanExample);
        if (b == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "修改失败");
        }
        //添加对应关系
       /* participant_ids = participant_ids.substring(2, participant_ids.length() - 2);
        String[] participant_id = participant_ids.split("\",\"");*/
        for (int j = 0; j < participant_ids.size(); j++) {
            agendaHuman.setId(UUID.randomUUID().toString());
            //agendaHuman.setCreatetime(new Date());
            agendaHuman.setParticipantId(participant_ids.getString(j));
            String name = userMapper.selectById(participant_ids.getString(j));
            agendaHuman.setParticipantValue(name);
            agendaHuman.setIsdelete(1);
            agendaHuman.setAgendaId(agenda_id);
            agendaHuman.setBeginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(begin_time));
            int insert = agendaHumanMapper.insert(agendaHuman);
            if (insert != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "修改失败");
            }
        }
        return new ResponseMessage(Code.CODE_OK, "修改成功");
    }

    @Override
    public ResponseMessage getAgendaForExcel(MultipartFile file) throws IOException, ParseException {
        InputStream is;

        // 判断文件的类型，是2003还是2007
        boolean isExcel2003 = true;
        if (WDWUtil.isExcel2007(file.getOriginalFilename())) {
            isExcel2003 = false;
        }
        is = file.getInputStream();
        Workbook workbook = read(is, isExcel2003);
        Sheet sheet = workbook.getSheetAt(0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat df = new SimpleDateFormat("HH");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);
            TXietongAgenda agenda = new TXietongAgenda();
            agenda.setId(UUID.randomUUID().toString());
            //设置会议主题
            agenda.setMeetingSubject(row.getCell(0).toString());
            //设置开始时间
            agenda.setBeginTime(format.parse(format.format(HSSFDateUtil.getJavaDate(row.getCell(1).getNumericCellValue()))));
            //设置结束时间
            agenda.setEndTime(format.parse(format.format(HSSFDateUtil.getJavaDate(row.getCell(2).getNumericCellValue()))));
            //设置会议活动地点
            agenda.setMeetingPlace(row.getCell(3).toString());
            //设置备注
            agenda.setRemark(row.getCell(5).toString());
            //设置可用
            agenda.setIsdelete(1);
            //设置上午还是下午
            String str = df.format(format.parse(format.format(HSSFDateUtil.getJavaDate(row.getCell(1).getNumericCellValue()))));
            int a = Integer.parseInt(str);
            if (a >= 0 && a <= 12) {
                agenda.setAmPm(0);
            } else {
                agenda.setAmPm(1);
            }
            int agendaInsert = agendaMapper.insert(agenda);
            if (agendaInsert != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "导入失败");
            }
            //新增部领导信息
            String names = row.getCell(4).toString();
            String[] participantValues = names.split("，");
            TXietongAgendaHuman agendaHuman = new TXietongAgendaHuman();
            for (String participantValue : participantValues) {
                agendaHuman.setId(UUID.randomUUID().toString());
                agendaHuman.setIsdelete(1);
                TUserExample userExample = new TUserExample();
                TUserExample.Criteria criteria = userExample.createCriteria();
                criteria.andNameCnEqualTo(participantValue);
              //  criteria.andIsdeleteEqualTo((short) 1);
                List<TUser> userList = userMapper.selectByExample(userExample);
                agendaHuman.setParticipantValue(participantValue);
                agendaHuman.setParticipantId(userList.get(0).getId());
                agendaHuman.setAmPm(agenda.getAmPm());
                agendaHuman.setAgendaId(agenda.getId());
                agendaHuman.setBeginTime(format.parse(format.format(HSSFDateUtil.getJavaDate(row.getCell(1).getNumericCellValue()))));
                int insert = agendaHumanMapper.insert(agendaHuman);
                if (insert != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "导入失败");
                }
            }

        }
        return new ResponseMessage(Code.CODE_OK, "导入成功");
    }

    // 根据不同类型的文件 创建不同的处理对象
    public Workbook read(InputStream inputStream, boolean isExcel2003) throws IOException {
        /** 根据版本选择创建Workbook的方式 */
        Workbook wb;
        if (isExcel2003) {
            wb = new HSSFWorkbook(inputStream);
        } else {
            wb = new XSSFWorkbook(inputStream);
        }
        return wb;
    }


    /**
     * 领导日程可见人员范围配置新增
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage insertAgendaVisualHuanm(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String ministerId = requestJson.getString("ministerId");//领导人id
        JSONArray visualIds = requestJson.getJSONArray("visualIds");//可见人id
        TXietongUserMinisterRelationExample example = new TXietongUserMinisterRelationExample();
        TXietongUserMinisterRelationExample.Criteria criteria = example.createCriteria();
        criteria.andMinisterIdEqualTo(ministerId);
        criteria.andStatusEqualTo("0");
        List<TXietongUserMinisterRelation> list = userMinisterRelationMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list) || list.size() != 0) {
            System.out.println(CollectionUtils.isEmpty(list));
            return new ResponseMessage(Code.CODE_STOP, "领导已存在");
        }
        for (Object visualId : visualIds) {
            TXietongUserMinisterRelation relation = new TXietongUserMinisterRelation();
            relation.setId(UUID.randomUUID().toString());
            relation.setMinisterId(ministerId);
            relation.setVisualId(visualId.toString());
            relation.setStatus("0");
            int insert = userMinisterRelationMapper.insert(relation);
            if (insert != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "新增失败");
            }
        }
        return new ResponseMessage(Code.CODE_OK, "新增成功");
    }

    /**
     * 领导日程可见人员范围配置查询
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage selectAgendaVisualHuanm() {
        /*JSONObject requestJson = JSONObject.parseObject(requestBody);*/

        List<TUser> userList = userMinisterRelationMapper.selectAll();
        if (userList.size() == 0) {
            return new ResponseMessage(Code.CODE_OK, "无领导数据", userList);
        }
        for (TUser user : userList) {

            TXietongUserMinisterRelationExample example = new TXietongUserMinisterRelationExample();
            TXietongUserMinisterRelationExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo("0");
            criteria.andMinisterIdEqualTo(user.getId());
            List<TXietongUserMinisterRelation> relations = userMinisterRelationMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(relations)) {

                ArrayList arrayList = new ArrayList();
                for (TXietongUserMinisterRelation relation : relations) {
                    TUser user1 = userMapper.selectByPrimaryKey(relation.getVisualId());
                    if (StringUtils.isEmpty(user1)) {
                        return new ResponseMessage(Code.CODE_ERROR, "查询失败");
                    }
                    arrayList.add(user1);
                }
                user.setUsers(arrayList);
            }
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", userList);

        /*String departmentId = requestJson.getString("departmentId");//领导人部门id

        TXietongUserExample userExample = new TXietongUserExample();
        userExample.setOrderByClause("sort");
        TXietongUserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andIsdeleteEqualTo((short) 1);
        userCriteria.andDepartmentidEqualTo(departmentId);
        List<TXietongUser> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)){
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        for (TXietongUser user :userList) {

            TXietongUserMinisterRelationExample example = new TXietongUserMinisterRelationExample();
            TXietongUserMinisterRelationExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo("0");

            criteria.andMinisterIdEqualTo(user.getId());
            List<TXietongUserMinisterRelation> relations = userMinisterRelationMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(relations)){

                ArrayList arrayList = new ArrayList();
                for (TXietongUserMinisterRelation relation :relations) {
                    TXietongUser user1 = userMapper.selectByPrimaryKey(relation.getVisualId());
                    if (StringUtils.isEmpty(user1)){
                        return new ResponseMessage(Code.CODE_ERROR, "查询失败");
                    }
                    arrayList.add(user1);
                }
                user.setUsers(arrayList);
            }
        }*/

    }

    /**
     * 领导日程可见人员范围配置修改
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage updateAgendaVisualHuanm(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String ministerId = requestJson.getString("ministerId");//领导人id
        JSONArray visualIds = requestJson.getJSONArray("visualIds");//可见人id

        //根据领导人id删除关联表记录
        TXietongUserMinisterRelationExample example = new TXietongUserMinisterRelationExample();
        TXietongUserMinisterRelationExample.Criteria criteria = example.createCriteria();
        criteria.andMinisterIdEqualTo(ministerId);
        TXietongUserMinisterRelation relation = new TXietongUserMinisterRelation();
        relation.setStatus("1");
        int update = userMinisterRelationMapper.updateByExampleSelective(relation, example);
        if (update <= 0) {
            return new ResponseMessage(Code.CODE_ERROR, "修改失败");
        }

        //新增可见人关联表
        for (Object visualId : visualIds) {
            TXietongUserMinisterRelation relation1 = new TXietongUserMinisterRelation();
            relation1.setId(UUID.randomUUID().toString());
            relation1.setStatus("0");
            relation1.setMinisterId(ministerId);
            relation1.setVisualId(visualId.toString());
            int insert = userMinisterRelationMapper.insert(relation1);
            if (insert != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "修改失败");
            }
        }
        return new ResponseMessage(Code.CODE_OK, "修改成功");
    }

    /**
     * 领导日程可见人员范围配置删除
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage deleteAgendaVisualHuanm(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String ministerId = requestJson.getString("ministerId");//领导人id
        TXietongUserMinisterRelationExample example = new TXietongUserMinisterRelationExample();
        TXietongUserMinisterRelationExample.Criteria criteria = example.createCriteria();
        criteria.andMinisterIdEqualTo(ministerId);
        TXietongUserMinisterRelation relation = new TXietongUserMinisterRelation();
        relation.setStatus("1");
        int update = userMinisterRelationMapper.updateByExampleSelective(relation, example);
        if (update <= 0) {
            return new ResponseMessage(Code.CODE_ERROR, "修改失败");
        }
        return new ResponseMessage(Code.CODE_OK, "修改成功");
    }

    /**
     *领导日程汇总人员新增
     * @param
     * @return
     */
   /* @Override
    public ResponseMessage insertAggregatedPersonnel(String requestBody) {
        JSONObject object = JSONObject.parseObject(requestBody);
        String userId = object.getString("userId");
        String userName = object.getString("userName");
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("30");
        List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
        if(!dictionaryList.isEmpty()){
            return new ResponseMessage(Code.CODE_ERROR, "汇总人员已存在");
        }
        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setId(UUID.randomUUID().toString());
        dictionary.setTypeCode("30");
        dictionary.setTypeDesc("领导日程汇总人员");
        dictionary.setMainValue(userName);
        dictionary.setMidValue(userId);
        int i = dictionaryMapper.insertSelective(dictionary);
        if (i<=0){
            return new ResponseMessage(Code.CODE_ERROR, "新增失败");
        }
        return new ResponseMessage(Code.CODE_OK, "新增成功");

    }*/

    /**
     * 领导日程汇总人员查询
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage selectAggregatedPersonnel() {
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("30");
        List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
        if (dictionaryList.isEmpty()) {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", dictionaryList);
    }

    /**
     * 领导日程汇总人员修改
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage updateAggregatedPersonnel(String requestBody) {
        JSONObject object = JSONObject.parseObject(requestBody);

        String userId = object.getString("userId");
        String userName = object.getString("userName");

        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("30");
        dictionaryMapper.deleteByExample(example);

        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setId(UUID.randomUUID().toString());
        dictionary.setTypeCode("30");
        dictionary.setTypeDesc("领导日程汇总人员");
        dictionary.setMainValue(userName);
        dictionary.setMidValue(userId);
        int insert = dictionaryMapper.insertSelective(dictionary);
        if (insert <= 0) {
            return new ResponseMessage(Code.CODE_ERROR, "修改失败");
        }
        return new ResponseMessage(Code.CODE_OK, "修改成功");
    }

    /**
     *领导日程汇总人员删除
     * @param
     * @return
     */
    /*@Override
    public ResponseMessage deleteAggregatedPersonnel(String requestBody) {
        JSONObject object = JSONObject.parseObject(requestBody);
        String id = object.getString("id");
        int i = dictionaryMapper.deleteByPrimaryKey(id);
        if (i!=1){
            return new ResponseMessage(Code.CODE_ERROR, "删除失败");
        }
        return new ResponseMessage(Code.CODE_OK, "删除成功");
    }*/


    /**
     * 领导日程部委审核人员查询
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage selectAuditor() {
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("31");
        List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
        if (dictionaryList.isEmpty()) {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", dictionaryList);
    }

    /**
     * 领导日程部委审核人员修改
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage updateAuditor(String requestBody) {
        JSONObject object = JSONObject.parseObject(requestBody);

        String userId = object.getString("userId");
        String userName = object.getString("userName");

        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("31");
        dictionaryMapper.deleteByExample(example);

        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setId(UUID.randomUUID().toString());
        dictionary.setTypeCode("31");
        dictionary.setTypeDesc("领导日程部委审核人员");
        dictionary.setMainValue(userName);
        dictionary.setMidValue(userId);
        int insert = dictionaryMapper.insertSelective(dictionary);
        if (insert <= 0) {
            return new ResponseMessage(Code.CODE_ERROR, "修改失败");
        }
        return new ResponseMessage(Code.CODE_OK, "修改成功");
    }

    /**
     * 领导日程一级审核人员查询
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage selectOneAuditor() {
        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("32");
        List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(example);
        if (dictionaryList.isEmpty()) {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", dictionaryList);
    }

    /**
     * 领导日程一级审核人员修改
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage updateOneAuditor(String requestBody) {
        JSONObject object = JSONObject.parseObject(requestBody);

        String userId = object.getString("userId");
        String userName = object.getString("userName");

        TXietongDictionaryExample example = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andTypeCodeEqualTo("32");
        dictionaryMapper.deleteByExample(example);

        TXietongDictionary dictionary = new TXietongDictionary();
        dictionary.setId(UUID.randomUUID().toString());
        dictionary.setTypeCode("32");
        dictionary.setTypeDesc("领导日程一级审核人员");
        dictionary.setMainValue(userName);
        dictionary.setMidValue(userId);
        int insert = dictionaryMapper.insertSelective(dictionary);
        if (insert <= 0) {
            return new ResponseMessage(Code.CODE_ERROR, "修改失败");
        }
        return new ResponseMessage(Code.CODE_OK, "修改成功");
    }


    /**
     * 机要员发布
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage updateAgenda(String requestBody) throws Exception {
        /*JSONObject requestJson = JSONObject.parseObject(requestBody);
        JSONArray agendaIds = requestJson.getJSONArray("agendaIds");//会议id
        TXietongAgenda agenda = new TXietongAgenda();
        for (Object agendaId :agendaIds) {
            agenda.setId(agendaId.toString());
            agenda.setIspublish(1);
            int update = agendaMapper.updateByPrimaryKeySelective(agenda);
            if (update!=1){
                return new ResponseMessage(Code.CODE_ERROR, "发布失败");
            }

            TXietongAgenda agenda1 = agendaMapper.selectByPrimaryKey(agendaId.toString());
        }*/

        JSONObject requestJson = JSONObject.parseObject(requestBody);
        JSONArray userIds = requestJson.getJSONArray("userIds");//领导id
        String beginTime = requestJson.getString("beginTime");//开始时间
        String endTime = requestJson.getString("endTime");//结束时间

        for (Object userId : userIds) {
            TXietongAgenda agenda = new TXietongAgenda();
            agenda.setRemark(userId.toString());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            agenda.setBeginTime(format.parse(beginTime));
            agenda.setEndTime(format.parse(endTime));
            /*agenda.setIspublish(2);*/
            //根据时间和领导全量删除发布表
            int i = agendaReleaseMapper.deleteRelease(agenda);
            /*if (i != 0) {
                return new ResponseMessage(Code.CODE_ERROR, "发布失败");
            }*/

            List<TXietongAgenda> agendas = agendaMapper.selectAgendaByTime(agenda);
            if (!StringUtils.isEmpty(agendas)) {
                for (TXietongAgenda agenda1 : agendas) {
                    if (agenda1.getIspublish() == 2) {
                        agenda1.setIspublish(3);
                    }
                    //根据时间和领导全量更新发布状态
                    int update = agendaMapper.updateByPrimaryKey(agenda1);
                    if (update != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "发布失败");
                    }
                    if (agenda1.getIsdelete() == 0) {
                        TXietongAgendaHumanExample example = new TXietongAgendaHumanExample();
                        TXietongAgendaHumanExample.Criteria criteria = example.createCriteria();
                        criteria.andAgendaIdEqualTo(agenda1.getId());
                        TXietongAgendaHuman agendaHuman = new TXietongAgendaHuman();
                        agendaHuman.setIsdelete(0);
                        int update1 = agendaHumanMapper.updateByExample(agendaHuman, example);
                        if (update1 != 1) {
                            return new ResponseMessage(Code.CODE_ERROR, "发布失败");
                        }
                    }
                    //根据时间和领导全量新增发布表
                    if (agenda1.getIspublish() == 3) {
                        int insert = agendaReleaseMapper.insert(agenda1);
                        if (insert != 1) {
                            return new ResponseMessage(Code.CODE_ERROR, "发布失败");
                        }
                    }
                }
            }
        }
        return new ResponseMessage(Code.CODE_OK, "发布成功");
    }

    //查看已发布页面
    @Override
    public ResponseMessage selectRecord(String requestBody) throws Exception {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String begin_time = requestJson.getString("begin_time");
        String end_time = requestJson.getString("end_time");
        JSONArray participant_ids = requestJson.getJSONArray("participant_ids");
        Map map1 = new TreeMap();
        for (Object participant_id : participant_ids) {
            Map map = selectRecordMap(begin_time, end_time, participant_id.toString());
            String name = userMapper.selectById(participant_id.toString());
            map1.put(name + "~~" + participant_id, map);
            //map1.put(participant_id.toString(),map);
        }
        if (!CollectionUtils.isEmpty(map1)) {
            return new ResponseMessage(Code.CODE_OK, "查询成功", map1);
        }
        return new ResponseMessage(Code.CODE_OK, "暂无数据");

    }

    public Map selectRecordMap(String begin_time, String end_time, String participant_id) throws Exception {

        TXietongAgendaRelease agendaRelease = new TXietongAgendaRelease();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!begin_time.isEmpty()) {
            agendaRelease.setBeginTime(format.parse(begin_time));
        }
        if (!end_time.isEmpty()) {
            agendaRelease.setEndTime(format.parse(end_time));
        }

        agendaRelease.setRemark(participant_id);

        List<TXietongAgendaRelease> agendaReleaseList = agendaReleaseMapper.selectAgendaByTime(agendaRelease);
        Map map = new TreeMap();
        SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd");
        //得到输入开始时间与结束时间的差
        long a = (e.parse(end_time).getTime() - e.parse(begin_time).getTime()) / (24 * 60 * 60 * 1000) + 1;
        for (int j = 0; j < a; j++) {
            List list1 = new ArrayList();
            for (int i = 0; i < agendaReleaseList.size(); i++) {
                TXietongAgendaHumanExample example = new TXietongAgendaHumanExample();
                TXietongAgendaHumanExample.Criteria criteria = example.createCriteria();
                criteria.andAgendaIdEqualTo(agendaReleaseList.get(i).getId());
                criteria.andIsdeleteEqualTo(1);
                List<TXietongAgendaHuman> agendaHumanList = agendaHumanMapper.selectByExample(example);
                agendaReleaseList.get(i).setList(agendaHumanList);
                long diff = (agendaReleaseList.get(i).getBeginTime().getTime() - e.parse(begin_time).getTime()) / (24 * 60 * 60 * 1000);//这样得到的差值是微秒级别
                if (j == diff) {
                    list1.add(agendaReleaseList.get(i));
                }
            }
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(e.parse(begin_time));
            rightNow.add(Calendar.DAY_OF_YEAR, j);

            Date dt1 = rightNow.getTime();
            switch (rightNow.get(Calendar.DAY_OF_WEEK) - 1) {
                case 0:
                    map.put(e.format(dt1) + "~~" + "星期日", list1);
                    break;
                case 1:
                    map.put(e.format(dt1) + "~~" + "星期一", list1);
                    break;
                case 2:
                    map.put(e.format(dt1) + "~~" + "星期二", list1);
                    break;
                case 3:
                    map.put(e.format(dt1) + "~~" + "星期三", list1);
                    break;
                case 4:
                    map.put(e.format(dt1) + "~~" + "星期四", list1);
                    break;
                case 5:
                    map.put(e.format(dt1) + "~~" + "星期五", list1);
                    break;
                case 6:
                    map.put(e.format(dt1) + "~~" + "星期六", list1);
                    break;
                default:
                    map.put("error", "服务器异常");

            }

        }
        return map;

    }

    /**
     * 新增领导日程领导下拉框查询
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage insertSelectLeader(String requestBody) {
        JSONObject object = JSONObject.parseObject(requestBody);
        String id = object.getString("userId");
        TUser user1 = userMapper.selectByPrimaryKey(id);

        if (!user1.getDepartmentId().equals("3")) {
            TUserExample userExample = new TUserExample();
            TUserExample.Criteria criteria1 = userExample.createCriteria();
        /*    Short aa = 1;
            criteria1.andIsdeleteEqualTo(aa);*/
            criteria1.andDepartmentidEqualTo("3");
            List<TUser> userList = userMapper.selectByExample(userExample);
            if (userList.isEmpty()) {
                return new ResponseMessage(Code.CODE_ERROR, "查询失败");
            }
            return new ResponseMessage(Code.CODE_OK, "查询成功", userList);
        } else {
            TUser user = userMapper.selectByPrimaryKey(id);
            ArrayList list = new ArrayList();
            list.add(user);
            if (list.isEmpty()) {
                return new ResponseMessage(Code.CODE_ERROR, "查询失败");
            }
            return new ResponseMessage(Code.CODE_OK, "查询成功", list);
        }
    }

    /**
     * 审核领导日程领导下拉框查询
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage examineSelectLeader(String requestBody) {
        JSONObject object = JSONObject.parseObject(requestBody);
        String id = object.getString("userId");
        TXietongAgendaRecordExample example = new TXietongAgendaRecordExample();
        TXietongAgendaRecordExample.Criteria criteria = example.createCriteria();
        criteria.andOwnerIdEqualTo(id);
        criteria.andRstatusEqualTo("0");
        List<TXietongAgendaRecord> records = agendaRecordMapper.selectByExample(example);
        if (records.size() == 1) {
            TUserExample userExample = new TUserExample();
            TUserExample.Criteria criteria1 = userExample.createCriteria();
            Short aa = 1;
            //criteria1.andIsdeleteEqualTo(aa);
            criteria1.andDepartmentidEqualTo("3");
            List<TUser> userList = userMapper.selectByExample(userExample);
            if (userList.isEmpty()) {
                return new ResponseMessage(Code.CODE_ERROR, "查询失败");
            }
            return new ResponseMessage(Code.CODE_OK, "查询成功", userList);
        }
        return new ResponseMessage(Code.CODE_OK, "暂无审核数据");
    }

    /**
     * 查询机要员领导
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage selectPerson(String requestBody) {
        JSONObject object = JSONObject.parseObject(requestBody);
        String userId = object.getString("userId");//机要员id
        TUser user = userMapper.selectByPrimaryKey(userId);
        TDepartment department = departmentMapper.selectByPrimaryKey(user.getDepartmentId());
        TUser user1 = userMapper.selectByPrimaryKey(department.getLeaderId());

        return new ResponseMessage(Code.CODE_OK, "查询成功", user1);
    }

    /**
     * 提交审核
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage submitAudit(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        /*JSONArray userIds = requestJson.getJSONArray("userIds");//领导id
        String beginTime = requestJson.getString("beginTime");//开始时间
        String endTime = requestJson.getString("endTime");//结束时间*/
        String createrId = requestJson.getString("creatorId");//创建人id
        String leaderId = requestJson.getString("leaderId");//领导id
        TXietongAgendaExample example1 = new TXietongAgendaExample();
        TXietongAgendaExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andIspublishEqualTo(1);
        criteria1.andIsdeleteEqualTo(1);
        List<TXietongAgenda> agenda = agendaMapper.selectByExample(example1);
        if (agenda.size() > 0) {
            return new ResponseMessage(Code.CODE_STOP, "存在审核中数据");
        }

        TXietongAgendaProcessExample example2 = new TXietongAgendaProcessExample();
        TXietongAgendaProcessExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andStatusEqualTo(0);
        List<TXietongAgendaProcess> list = agendaProcessMapper.selectByExample(example2);
        if (list.size() > 0) {
            return new ResponseMessage(Code.CODE_ERROR, "存在审核中数据");
        }

        TXietongAgendaExample example = new TXietongAgendaExample();
        TXietongAgendaExample.Criteria criteria = example.createCriteria();
        criteria.andIspublishEqualTo(0);
        criteria.andIsdeleteEqualTo(1);
        TXietongAgenda agenda1 = new TXietongAgenda();
        agenda1.setIspublish(1);
        int update = agendaMapper.updateByExampleSelective(agenda1, example);
        if (update <= 0) {
            return new ResponseMessage(Code.CODE_ERROR, "无需要提交审核数据");
        }

        TXietongAgendaProcess process = new TXietongAgendaProcess();
        process.setId(UUID.randomUUID().toString());
        process.setStatus(0);
        process.setCreaterId(createrId);
        process.setIsdelete(1);


        int insert = agendaProcessMapper.insertProcess(process);
        if (insert != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "提交失败");
        }

        TXietongAgendaRecord record = new TXietongAgendaRecord();
        record.setId(UUID.randomUUID().toString());
        record.setIsdelete(1);
        record.setRstatus("0");
        record.setAgendaProcessId(process.getId());
        record.setOwnerId(leaderId);

        int i = agendaRecordMapper.insertSelective(record);
        if (i != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "提交失败");
        }
        daibanUtil.insertDaibanRecord(record.getId(), "你有一条新的待审核日程", "ldrc", record.getOwnerId());
        return new ResponseMessage(Code.CODE_OK, "提交成功");
    }

    /**
     * 审核
     *
     * @param requestBody
     * @return
     */
    @Override
    public ResponseMessage examine(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        /*String dealTime = requestJson.getString("dealTime");//审核时间*/
        String status = requestJson.getString("status");//审核状态
        String comment = requestJson.getString("comment");//领导意见
        String ownerId = requestJson.getString("ownerId");//登录人id
        String nextId = requestJson.getString("nextId");//下一步处理人id

        TXietongAgendaRecordExample example = new TXietongAgendaRecordExample();
        TXietongAgendaRecordExample.Criteria criteria1 = example.createCriteria();
        criteria1.andOwnerIdEqualTo(ownerId);
        criteria1.andRstatusEqualTo("0");
        List<TXietongAgendaRecord> records = agendaRecordMapper.selectByExample(example);
        if (records.size() <= 0) {
            return new ResponseMessage(Code.CODE_ERROR, "暂无审核数据");
        }

        //查询会议表中是否还有未删除的审核中数据
        TXietongAgendaExample example3 = new TXietongAgendaExample();
        TXietongAgendaExample.Criteria criteria3 = example3.createCriteria();
        criteria3.andIsdeleteEqualTo(1);
        criteria3.andIspublishEqualTo(1);
        List<TXietongAgenda> agenda = agendaMapper.selectByExample(example3);
        if (agenda.size() == 0) {
            TXietongAgendaProcess process = new TXietongAgendaProcess();
            process.setStatus(2);
            TXietongAgendaProcessExample example1 = new TXietongAgendaProcessExample();
            TXietongAgendaProcessExample.Criteria criteria = example1.createCriteria();
            criteria.andIdEqualTo(records.get(0).getAgendaProcessId());
            agendaProcessMapper.updateByExampleSelective(process, example1);
            return new ResponseMessage(Code.CODE_ERROR, "暂无审核数据");
        }

        TXietongDictionaryExample dictionaryExample = new TXietongDictionaryExample();
        TXietongDictionaryExample.Criteria criteria = dictionaryExample.createCriteria();
        criteria.andTypeCodeEqualTo("31");
        List<TXietongDictionary> dictionaryList = dictionaryMapper.selectByExample(dictionaryExample);


        if (!ownerId.equals(dictionaryList.get(0).getMidValue())) {

            TXietongAgendaRecordExample example1 = new TXietongAgendaRecordExample();
            TXietongAgendaRecordExample.Criteria criteria2 = example1.createCriteria();
            criteria2.andAgendaProcessIdEqualTo(records.get(0).getAgendaProcessId());
            List<TXietongAgendaRecord> records1 = agendaRecordMapper.selectByExample(example1);
            if (records1.size() == 2) {
                return new ResponseMessage(Code.CODE_ERROR, "已提交审核请勿重复提交");
            }

            //汇总人员领导审核时新增一条审核记录
            TXietongAgendaRecord record1 = new TXietongAgendaRecord();
            record1.setId(UUID.randomUUID().toString());
            record1.setIsdelete(1);
            record1.setAgendaProcessId(records.get(0).getAgendaProcessId());
            record1.setRstatus("0");
            record1.setOwnerId(nextId);

            int i = agendaRecordMapper.insertSelective(record1);
            if (i != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "审核失败");
            }
            daibanUtil.insertDaibanRecord(record1.getId(),"你有一条新的待审核日程","ldrc",record1.getOwnerId());
        } else {
            if (records.size() <= 0) {
                return new ResponseMessage(Code.CODE_ERROR, "暂无审核数据");
            }

            TXietongAgendaRecordExample example1 = new TXietongAgendaRecordExample();
            TXietongAgendaRecordExample.Criteria criteria2 = example1.createCriteria();
            criteria2.andAgendaProcessIdEqualTo(records.get(0).getAgendaProcessId());
            List<TXietongAgendaRecord> records1 = agendaRecordMapper.selectByExample(example1);
            if (records1.size() != 2) {
                return new ResponseMessage(Code.CODE_ERROR, "暂无审核数据");
            }


            //部委领导审核更新审核流程表和会议表
            int update1 = agendaProcessMapper.updateProcess(records.get(0).getAgendaProcessId(), status);
            if (update1 != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "审核失败");
            }

            TXietongAgendaExample example2 = new TXietongAgendaExample();
            TXietongAgendaExample.Criteria criteria5 = example2.createCriteria();
            criteria5.andIspublishEqualTo(1);
            criteria5.andIsdeleteEqualTo(1);
            TXietongAgenda agenda1 = new TXietongAgenda();
            agenda1.setIspublish(2);
            int update2 = agendaMapper.updateByExampleSelective(agenda1, example2);
            if (update2 <= 0) {
                return new ResponseMessage(Code.CODE_ERROR, "审核失败");
            }

        }
        //更新审核记录表
        TXietongAgendaRecord record = new TXietongAgendaRecord();
        /*record.setDealTime(dateFormat.parse(dealTime));*/
        record.setRstatus(status);
        record.setComment(comment);
        int update = agendaRecordMapper.updateByExampleSelective(record, example);
        if (update != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "审核失败");
        }
        daibanUtil.UpdateDaibanRecord(record.getId());
        return new ResponseMessage(Code.CODE_OK, "审核成功");
    }

    /**
     * 审核记录查询
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage selectExamine() {
        TXietongAgendaProcessExample example = new TXietongAgendaProcessExample();
        TXietongAgendaProcessExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        List<TXietongAgendaProcess> list = agendaProcessMapper.selectByExample(example);
        if (list.size() <= 0) {
            return new ResponseMessage(Code.CODE_ERROR, "无未审核数据");
        }
        TXietongAgendaRecordExample example1 = new TXietongAgendaRecordExample();
        TXietongAgendaRecordExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andAgendaProcessIdEqualTo(list.get(0).getId());
        List<TXietongAgendaRecord> records = agendaRecordMapper.selectByExample(example1);
        for (TXietongAgendaRecord record : records) {
            String name = userMapper.selectById(record.getOwnerId());
            record.setAgendaProcessId(name);
        }


        return new ResponseMessage(Code.CODE_OK, "查询成功", records);
    }

    /**
     * 根据部门id查询部门人员
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage selectDepartment(String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String id = requestJson.getString("did");
        TUserExample example = new TUserExample();
        example.setOrderByClause("id desc");
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andDepartmentidEqualTo(id);
        //Short aa = 1;
        //criteria.andIsdeleteEqualTo(aa);
        List<TUser> userList = userMapper.selectByExample(example);
        if (userList.size() <= 0) {
            return new ResponseMessage(Code.CODE_ERROR, "查询失败");
        }
        return new ResponseMessage(Code.CODE_OK, "查询成功", userList);
    }

    /**
     * 查询领导日程代办
     *
     * @param
     * @return
     */
    @Override
    public ResponseMessage selectScheduleAgency(String requestBody) {
        JSONObject jsonObject = JSONObject.parseObject(requestBody);
        String id = jsonObject.getString("userId");
        TXietongAgendaRecordExample example = new TXietongAgendaRecordExample();
        TXietongAgendaRecordExample.Criteria criteria = example.createCriteria();
        criteria.andOwnerIdEqualTo(id);
        criteria.andRstatusEqualTo("0");
        List<TXietongAgendaRecord> records = agendaRecordMapper.selectByExample(example);
        if (records.size() == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "暂无审核数据");
        }
        return new ResponseMessage(Code.CODE_OK, "有代审核数据");
    }
    @Override
    public ResponseMessage insertAllLeadershipAgenda(String requestBody) throws Exception {
        //JSONObject requestJson = JSONObject.parseObject(requestBody);
        JSONArray requestJson = JSONArray.parseArray(requestBody);
        for (int i = 0; i < requestJson.size(); i++) {
            Map map = (Map) requestJson.get(i);
            String begin_time = map.get("begin_time").toString();//开始时间
            String end_time = map.get("end_time").toString();//结束时间

            List participant_ids = (List) map.get("participant_ids");//领导id数组
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //删除领导所有日程
            for (Object participant_id : participant_ids) {
                TXietongAgenda agenda = new TXietongAgenda();
                if (!begin_time.isEmpty()) {
                    String begin[] = begin_time.split(" ");
                    String beginTime = begin[0] + " 00:00:00";
                    agenda.setBeginTime(format.parse(beginTime));
                }
                if (!end_time.isEmpty()) {
                    String begin[] = end_time.split(" ");
                    String endTime = begin[0] + " 23:59:59";
                    agenda.setEndTime(format.parse(endTime));
                }

                agenda.setRemark(participant_id.toString());

                List<TXietongAgenda> agendas = agendaMapper.selectAgendaByTime(agenda);
                for (TXietongAgenda agenda1 : agendas) {
                    TXietongAgenda agenda2 = new TXietongAgenda();
                    agenda2.setId(agenda1.getId());
                    agenda2.setIsdelete(0);

                    //删除日程表
                    int update = agendaMapper.deleteByPrimaryKey(agenda1.getId());
                    if (update != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "新增失败");
                    }
                    TXietongAgendaHumanExample humanExample = new TXietongAgendaHumanExample();
                    TXietongAgendaHumanExample.Criteria criteria = humanExample.createCriteria();
                    criteria.andAgendaIdEqualTo(agenda1.getId());
                    criteria.andIsdeleteEqualTo(1);
                    TXietongAgendaHuman human = new TXietongAgendaHuman();
                    human.setIsdelete(0);

                    //删除领导表
                    int update1 = agendaHumanMapper.updateByExampleSelective(human, humanExample);
                    if (update1 != 1) {
                        return new ResponseMessage( Code.CODE_ERROR, "新增失败");
                    }
                }

            }
        }

        for (int i = 0; i < requestJson.size(); i++) {
            Map map = (Map) requestJson.get(i);
            String id  = map.get("id").toString();//开始时间
            String begin_time = map.get("begin_time").toString();//开始时间
            String end_time = map.get("end_time").toString();//结束时间
            String meeting_subjet = map.get("meeting_subjet").toString();//会议名称
            String meeting_place = map.get("meeting_place").toString();//会议地点
            List participant_ids = (List) map.get("participant_ids");//领导id数组
            String ispublish = map.get("ispublish").toString();//状态
            String amPm = map.get("amPm").toString();//0上午1下午2全天
            /*ArrayList participant_ids =(ArrayList)*/
            String remark = map.get("remark").toString();//备注
            String createrId = map.get("createrId").toString();//创建人id(登录人id)


            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            TXietongAgenda agenda = new TXietongAgenda();
            if(id.isEmpty()){
                agenda.setId(UUID.randomUUID().toString());
            }else {
                agenda.setId(id);
            }


            agenda.setBeginTime(format.parse(begin_time));
            agenda.setEndTime(format.parse(end_time));
            agenda.setMeetingPlace(meeting_place);
            agenda.setMeetingSubject(meeting_subjet);
            agenda.setRemark(remark);
            agenda.setIsdelete(1);
            if(ispublish.isEmpty()){
                agenda.setIspublish(0);
            }else {
                agenda.setIspublish(Integer.valueOf(ispublish));
            }



            agenda.setCreaterid(createrId);
            //agenda.setCreatetime(new java.util.Date());
            agenda.setAmPm(Integer.valueOf(amPm));

            /*TXietongAgendaExample example = new TXietongAgendaExample();
            TXietongAgendaExample.Criteria criteria = example.createCriteria();
            criteria.andMeetingSubjectEqualTo(meeting_subjet);
            List<TXietongAgenda> agenda1 = agendaMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(agenda1)){
                return new ResponseMessage(Code.CODE_ERROR, "会议名称已存在");
            }*/
            //新增领导日程表
            int sign = agendaMapper.insert(agenda);
            if (sign != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "新增失败");
            }
            TXietongAgendaHuman agendaHuman = new TXietongAgendaHuman();
            for (int j = 0; j < participant_ids.size(); j++) {
                agendaHuman.setId(UUID.randomUUID().toString());
                agendaHuman.setAgendaId(agenda.getId());
                agendaHuman.setAmPm(agenda.getAmPm());
                agendaHuman.setIsdelete(1);
                String name_cn = userMapper.selectById(participant_ids.get(j).toString());
                agendaHuman.setParticipantValue(name_cn);
                agendaHuman.setParticipantId(participant_ids.get(j).toString());
                //agendaHuman.setCreatetime(new java.util.Date());
                agendaHuman.setBeginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(begin_time));
                //新增领导表
                int flag = agendaHumanMapper.insert(agendaHuman);
                if (flag != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "新增失败");
                }
            }
        }
        return new ResponseMessage(Code.CODE_OK, "新增成功");
        /*String begin_time = requestJson.getString("begin_time");//开始时间
        String end_time = requestJson.getString("end_time");//结束时间
        String meeting_subjet = requestJson.getString("meeting_subjet");//会议名称
        String meeting_place = requestJson.getString("meeting_place");//会议地点
        String participant_ids = requestJson.getString("participant_ids");//领导id数组
        String remark = requestJson.getString("remark");//备注
        String createrId = requestJson.getString("createrId");//创建人id(登录人id)
        JSONArray participant_id = JSONObject.parseArray(participant_ids);*/


    }
}
