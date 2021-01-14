package com.qrcode.eenum;

public enum ErrorCodeEnum {
    OK(0, "成功"),
    NOT_LOGIN(-1, "没有登录"),
    LOGIN_FAIL(-2, "登录失败"),
    NOT_AUTH(-3,"权限不足"),
    USER_EXITS(-4,"用户已经存在");
    private int error;
    private String errmsg;

    ErrorCodeEnum(int error, String errmsg) {
        this.error = error;
        this.errmsg = errmsg;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}

