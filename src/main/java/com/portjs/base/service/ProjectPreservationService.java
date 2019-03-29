package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

/**
 * Created by dengshuangzhen on 2019\3\28 0028
 */
public interface ProjectPreservationService {

    /**
     * 立项暂存/提交
     * @param responseBody
     * @return
     */
    ResponseMessage insertStorage(String responseBody);
    /**
     * 立项退回
     * @param responseBody
     * @return
     */
    ResponseMessage returnStorage(String responseBody);
}
