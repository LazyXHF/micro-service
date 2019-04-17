package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

/**
 * Created by Administrator on 2019/4/8.
 */
public interface PucharseReviewService {

    ResponseMessage queryPucharseList(String requestBody);

    ResponseMessage addPucharseReview(String requestBody);

    ResponseMessage queryPucharseReview(String requestBody);

    ResponseMessage queryPucharseReviewAll(String requestBody);

    ResponseMessage handlePucharseReview(String requestBody);

    ResponseMessage returnRecord(String requestBody);
}
