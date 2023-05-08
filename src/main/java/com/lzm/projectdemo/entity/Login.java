package com.lzm.projectdemo.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: lzm
 * @create: 2023-04-27 16:41
 **/
@Data
@Entity
public class Login implements Serializable {
    @Id
    private Integer id;
    private int userId;
    private int clientId;
    private LocalDateTime date;

    public void setId(Integer id) {
        this.id = id;
    }

    @jakarta.persistence.Id
    public Integer getId() {
        return id;
    }
}
