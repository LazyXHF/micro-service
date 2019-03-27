package com.portjs.base.util;

import java.util.List;

/**
 * Created by 许虎飞 on 2018/12/14.
 * 统一请求体返回
 */
public class ResponseMessage {
    private Integer code;
    private String message;
    private Object data;

    public ResponseMessage(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
