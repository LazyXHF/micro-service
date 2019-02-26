package com.project.mgt.util;

import com.project.mgt.dao.TXietongDaiBanRecordMapper;
import com.project.mgt.entity.TXietongDaiBanRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author: daiyueyuan
 * @date: 2019/1/24 17:20
 * @description:
 */
@Component
public class DaibanUtil extends LogUtil {
    static final String tag = "SupervisionServiceImpl===>";

    @Autowired
    private TXietongDaiBanRecordMapper daiBanRecordMapper;

    //修改消息状态
    public int UpdateDaibanRecord(String recordId) {
        logger.debug(tag + "UpdateDaibanRecord()begin recordId=", recordId);
        try {
            int k = daiBanRecordMapper.updateStatus(recordId);
            if (k > 0) {
                return k;
            }
        } catch (Exception e) {
            logger.error("UpdateDaibanRecord()error=", e);
        }
        return 0;
    }

    //添加消息提醒
    public int insertDaibanRecord(String recordId, String recordContent, String type, String ownerId) {
        logger.debug(tag + "insertDaibanRecord()begin recordId=", recordId);
        try {
            TXietongDaiBanRecord daiBanRecord = new TXietongDaiBanRecord();
            daiBanRecord.setId(String.valueOf(UUID.randomUUID()));
            daiBanRecord.setRecordId(recordId);
            daiBanRecord.setRecordContent(recordContent);
            daiBanRecord.setType(type);
            daiBanRecord.setOwnerId(ownerId);
            int i = daiBanRecordMapper.insertDaibanRecord(daiBanRecord);
            if (i > 0) {
                return i;
            }
        } catch (Exception e) {
            logger.error("UpdateDaibanRecord()error=", e);
        }
        return 0;
    }

    //添加催办消息提醒
    public int insertDaibanRecord2(String recordId, String recordContent, String type, String ownerId) {
        logger.debug(tag + "insertDaibanRecord()begin recordId=", recordId);
        try {
            TXietongDaiBanRecord daiBanRecord = new TXietongDaiBanRecord();
            daiBanRecord.setId(String.valueOf(UUID.randomUUID()));
            daiBanRecord.setRecordId(recordId);
            daiBanRecord.setRecordContent(recordContent);
            daiBanRecord.setType(type);
            daiBanRecord.setOwnerId(ownerId);
            int i = daiBanRecordMapper.insertDaibanRecord2(daiBanRecord);
            if (i > 0) {
                return i;
            }
        } catch (Exception e) {
            logger.error("UpdateDaibanRecord()error=", e);
        }
        return 0;
    }

    //修改催办状态
    public int updateisUrgent(String recordId) {
        logger.debug(tag + "updateisUrgent()begin recordId=", recordId);
        try {
            int k = daiBanRecordMapper.updateisUrgent(recordId);
            if (k > 0) {
                return k;
            }
        } catch (Exception e) {
            logger.error("updateisUrgent()error=", e);
        }
        return 0;
    }
}
