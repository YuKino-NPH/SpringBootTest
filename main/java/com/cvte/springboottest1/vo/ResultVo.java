package com.cvte.springboottest1.vo;

/**
 * 返回给前端的数据信息包装类
 */
public class ResultVo {
    private int code;
    private String message;
    private Object data;

    public ResultVo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultVo success() {
        return new ResultVo(200, "success");
    }

    public static ResultVo fail(int code, String message) {
        return new ResultVo(code, message);
    }
    public ResultVo data(Object data){
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
