package com.portjs.base.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponsePackUtil {
	public static final Logger logger = LoggerFactory.getLogger(ResponsePackUtil.class);

	/**
	 * 打包应答实体
	 * 
	 * @param code
	 * @param body
	 * @return
	 */
	public static Response buildResponse(String code, String desc, Object body) {
		Response response = new Response();
		response.setResponse_code(code);
		response.setResponse_desc(desc);
		response.setResponse_body(body);
		return response;
	}

	public static Response ok(String msg, Object obj) {
		return buildResponse("200", msg, obj);
	}

	public static Response ok(String msg) {
		return  buildResponse("200", msg, null);
	}

	public static Response error(String msg, Object obj) {
		return  buildResponse("500", msg, obj);
	}

	public static Response error(String msg) {
		return buildResponse("500", msg, null);
	}

}
