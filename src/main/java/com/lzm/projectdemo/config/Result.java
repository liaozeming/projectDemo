package com.lzm.projectdemo.config;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 接口返回数据格式
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回处理消息
     */
    private String msg = "操作成功！";

    /**
     * 返回代码
     */
    private Integer code = GlobalReturnCode.SC_OK_200;

    /**
     * 返回数据对象 data
     */
    private T data;

    /**
     * 时间戳
     */
    private LocalDateTime timestamp = LocalDateTime.now();

    public Result() {

    }

    public Result<T> success(String message) {
        this.msg = message;
        this.code = GlobalReturnCode.SC_OK_200;
        this.success = true;
        return this;
    }

    public static <T> Result<T> ok() {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(GlobalReturnCode.SC_OK_200);
        r.setMsg("成功");
        return r;
    }

    public static <T> Result<T> okMsg(String msg) {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(GlobalReturnCode.SC_OK_200);
        r.setMsg(msg);
        return r;
    }


    public static <T> Result<T> ok(T t) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(GlobalReturnCode.SC_OK_200);
        r.setData(t);
        return r;
    }

    public static <T> Result<T> ok(T t, String msg) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setMsg(msg);
        r.setCode(GlobalReturnCode.SC_OK_200);
        r.setData(t);
        return r;
    }


    public static <T> Result<T> okk(T t) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(GlobalReturnCode.SC_OK_200);
        r.setData(t);
        return r;
    }

    public static <T> Result<T> error(String msg) {
        return error(GlobalReturnCode.SC_ERROR_404, msg);
    }


    public static <T> Result<T> error(int code, String msg) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setSuccess(false);
        return r;
    }
}