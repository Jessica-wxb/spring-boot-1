package com.dmsdbj.team.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName Null2.java
 * @Description TODO
 * @createTime 2020年03月20日 23:09:00
 */
@Data
@Accessors(chain = true)
public class Null2 {
    private Long id;
    private String name;
    @TableLogic(delval = "now()", value = "null")
    private LocalDateTime delTime;
}
