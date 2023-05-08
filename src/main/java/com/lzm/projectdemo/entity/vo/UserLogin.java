package com.lzm.projectdemo.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @description:
 * @author: lzm
 * @create: 2023-04-27 17:34
 **/
public interface UserLogin {
    String getName();

    LocalDateTime getDate();
}
