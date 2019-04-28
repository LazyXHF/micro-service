package com.portjs.base.service;

import com.portjs.base.entity.ProjectMonthly;
import com.portjs.base.util.ResponseMessage;

import java.util.List;

/**
 * @author: daiyueyuan
 * @date: 2019/4/24 10:21
 * @description:
 */
public interface ProjectMonthlyService {
    ResponseMessage insertProjectMonthly(List<ProjectMonthly> projectMonthlyList);

    ResponseMessage selectBusinessConfiguration(String requestBody);

    ResponseMessage selectProjectMonthly(String requestBody);

    ResponseMessage selectProjectMonthlyBymohu(String requestBody);
}
