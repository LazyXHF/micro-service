package com.portjs.base.service;

import com.portjs.base.util.ResponseMessage;

public interface TenderService {

	/**
	 * 招标的采购清单查询
	 * @param requestBody
	 * @return
	 */
	ResponseMessage queryRequests(String requestBody)throws Exception;
}
