package com.portjs.base.service;


import com.portjs.base.util.ResponseMessage;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by dengshuangzhen on 2018\12\17 0017
 */
@Transactional
public interface DailyLeadershipService {

    ResponseMessage selectLeadershipAgenda(String requestBody) throws Exception;

    ResponseMessage insertLeadershipAgenda(String requestBody) throws Exception ;

    ResponseMessage selectLeader(String requestBody);

    ResponseMessage deleteLeadershipAgenda(String requestBody);

    ResponseMessage deleteLeadershipAgenda1(String requestBody);

    ResponseMessage updateLeadershipAgenda(String requestBody)  throws Exception;

    ResponseMessage selectLeadershipAgendaByTime(String requestBody) throws Exception;

    ResponseMessage selectLeadershipAgendaByNull(String requestBody) throws Exception;

    ResponseMessage getAgendaForExcel(MultipartFile file) throws IOException, ParseException;

    ResponseMessage insertAgendaVisualHuanm(String requestBody);

    ResponseMessage selectAgendaVisualHuanm(String requestBody);

    ResponseMessage updateAgendaVisualHuanm(String requestBody);

    ResponseMessage deleteAgendaVisualHuanm(String requestBody);

    ResponseMessage selectAgenda(String requestBody) throws Exception;

    ResponseMessage updateAgenda(String requestBody) throws Exception;

    ResponseMessage insertAllLeadershipAgenda(String requestBody) throws Exception;

    ResponseMessage selectRecord(String requestBody) throws Exception;

    ResponseMessage submitAudit(String requestBody);

    ResponseMessage insertSelectLeader(String requestBody);

    ResponseMessage examineSelectLeader(String requestBody);


    /*ResponseMessage insertAggregatedPersonnel(String requestBody);*/

    ResponseMessage selectAggregatedPersonnel();


    ResponseMessage updateAggregatedPersonnel(String requestBody);

    /*ResponseMessage deleteAggregatedPersonnel(String requestBody);*/

    ResponseMessage selectPerson(String requestBody);

    ResponseMessage selectAuditor();

    ResponseMessage updateAuditor(String requestBody);

    ResponseMessage examine(String requestBody) ;

    /**
     *退回
     * @param requestBody
     * @return
     */
    ResponseMessage returnExamine(String requestBody);

    ResponseMessage selectExamine(String requestBody)  throws Exception;

    ResponseMessage selectDepartment(String requestBody);

    ResponseMessage selectOneAuditor();

    ResponseMessage updateOneAuditor(String requestBody);

    ResponseMessage selectScheduleAgency(String requestBody);


}
