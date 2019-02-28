package com.mgt.common.utils;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = -4099448271450978247L;

	/** 响应编号 */
	private String response_code = "";

	/** 响应描述 */
	private String response_desc = "";

	/** 响应内容 */
	private Object response_body = "";

	public String getResponse_code() {
		return response_code;
	}

	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}

	public String getResponse_desc() {
		return response_desc;
	}

	public void setResponse_desc(String response_desc) {
		this.response_desc = response_desc;
	}

	public Object getResponse_body() {
		return response_body;
	}

	public void setResponse_body(Object response_body) {
		this.response_body = response_body;
	}

}
