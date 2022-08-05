package com.cvte.springboottest1.util;

/**
 * 返回给前端的数据信息包装类
 */
public class R {
    private int code;
    private String message;
    private Object data;

    public R(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static R success() {
        return new R(200, "success");
    }

    public static R fail(int code, String message) {
        return new R(code, message);
    }
    public R data(Object data){
        this.setData(data);
        return this;
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
