package com.lzm.projectdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description:
 * @author: lzm
 * @create: 2023-04-27 20:36
 **/
@RestControllerAdvice
@Slf4j
public class ExceptionHandler {
    @Value(value = "${spring.profiles.active}")
    private String active = "prod";

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        log.error(e.getMessage(), e);
        if (!"prod".equals(active)) {
            return Result.error(GlobalReturnCode.SC_ERROR_404, "非生产环境的报错提示:" + e.getCause().getMessage());
        }
        return Result.error(GlobalReturnCode.SC_ERROR_404, "系统繁忙,请稍后再试..");
    }
}
