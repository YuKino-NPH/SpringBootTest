package com.cvte.springboottest1.enums;

public enum UserResponseEnum {
    SELECT_ERROR(4000003,"用户不存在"),SAVE_ERROR(4000003,"该用户已存在"),
    DELETE_ERROR(4000003,"用户名错误"),UPDATE_ERROR(4000003,"用户ID错误");
    private int code;
    private String msg;

    UserResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "UserResponseEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
