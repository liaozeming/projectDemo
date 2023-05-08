package com.lzm.projectdemo.entity;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @description:
 * @author: lzm
 * @create: 2023-04-27 17:05
 **/
@Data
public class PageEntity {
    private int page;

    private int pageSize;

    public int getPage() {
        return page;
    }

    public Pageable toPageable() {
        return PageRequest.of(getPage() - 1, getPageSize());
    }

    public Pageable toPageable(Sort sort) {
        return PageRequest.of(getPage() - 1, getPageSize(), sort);
    }
}
