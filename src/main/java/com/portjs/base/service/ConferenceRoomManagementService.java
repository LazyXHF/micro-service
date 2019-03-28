package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dengshuangzhen on 2019\1\3 0003
 */
@Transactional
public interface ConferenceRoomManagementService {
    ResponseMessage selectConferenceRoom();

    ResponseMessage insertConferenceRoom(String requestBody) throws Exception;

    ResponseMessage selectReservation(String requestBody) throws Exception;

    ResponseMessage selectReservationDetails(String requestBody);

    ResponseMessage updateReservationDetails(String requestBody);

    ResponseMessage conferenceRoomAudit(String requestBody);

    ResponseMessage updateconferenceRoomAudit(String requestBody);

    ResponseMessage selectUserAll(String requestBody);
}
