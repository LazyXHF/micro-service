package com.portjs.base.vo;

import com.portjs.base.entity.CommunicationLog;

import java.util.List;
import java.util.Map;

public class CommunicationLogDO {
    private List<CommunicationLog> communicationLogList;
    private List<CommunicationLogRecord> communicationLogRecordList;

    private  Map  map;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<CommunicationLog> getCommunicationLogList() {
        return communicationLogList;
    }

    public void setCommunicationLogList(List<CommunicationLog> communicationLogList) {
        this.communicationLogList = communicationLogList;
    }

    public List<CommunicationLogRecord> getCommunicationLogRecordList() {
        return communicationLogRecordList;
    }

    public void setCommunicationLogRecordList(List<CommunicationLogRecord> communicationLogRecordList) {
        this.communicationLogRecordList = communicationLogRecordList;
    }
}
