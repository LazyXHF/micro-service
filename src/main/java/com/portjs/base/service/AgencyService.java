package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dengshuangzhen on 2019\3\28 0028
 */
@Transactional
public interface AgencyService {
    /**
     * 代办查询
     * @param requestBody
     * @return
     */
    ResponseMessage selectAgency(String requestBody);

    /**
     * 代办类型查询
     * @return
     */
    ResponseMessage selectAgencyType();
}
