package com.lzm.projectdemo.config.error;


public enum ErrorConfig implements ErrorConfigInterface {
    FORBIDDEN(403,"无权访问"),
    NOT_FOUND(404, "NOT FOUND");

    private final String msg;
    private final int code;

    ErrorConfig(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
