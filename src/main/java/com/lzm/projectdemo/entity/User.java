package com.lzm.projectdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: lzm
 * @create: 2023-04-27 21:51
 **/
@Data
@Entity
public class User implements Serializable {
    private Long id;

    private String name;

    private String password;

    private LocalDateTime date;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
