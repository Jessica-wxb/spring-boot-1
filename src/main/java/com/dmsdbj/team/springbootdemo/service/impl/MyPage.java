package com.dmsdbj.team.springbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName MyPage.java
 * @Description TODO
 * @createTime 2020年03月27日 16:30:00
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class MyPage<T> extends Page<T> {
    private static final long serialVersionUID = 5194933845448697148L;

    private Integer selectInt;
    private String selectStr;
    private String name;

    public MyPage(long current, long size) {
        super(current, size);

    }
}