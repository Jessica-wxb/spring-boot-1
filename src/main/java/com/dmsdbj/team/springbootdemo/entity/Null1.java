package com.dmsdbj.team.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName Null1.java
 * @Description TODO
 * @createTime 2020年03月20日 23:08:00
 */
@Data
@Accessors(chain = true)
public class Null1 {
    private Long id;
    private String name;
    @TableLogic(delval = "null", value = "1")
    private Integer deleted;
}
