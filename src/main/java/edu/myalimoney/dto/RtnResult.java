package edu.myalimoney.dto;

import java.io.Serializable;

/**
 * 数据传输对象
 */
public class RtnResult implements Serializable {

    private Boolean result;//结果
    private int code;//状态码
    private String message;//信息
    private Object data;//返回对象


    public RtnResult() {
    }

    public RtnResult(Boolean result, int code, String message) {
        this.result = result;
        this.code = code;
        this.message = message;
    }

    public RtnResult(Boolean result, int code, String message, Object data) {
        this.result = result;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
