package com.dmsdbj.team.springbootdemo.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jessica
 * @since 2020-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
// @Accessors 注解用来配置lombok 如何产生和显示getters 和setters的方法。
// chain为一个布尔值，如果为true生成的set方法返回this,为false生成的set方法是void类型。
// 默认为false，除非当fluent为true时，chain默认则为true
@Accessors(chain = true)
@TableName(autoResultMap = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 行命
     */

    private String name;
    /**
     * 电话
     */

    private Integer phone;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 邮箱
     */

    private String email;

    /**
     * CRUD
     */
    // 新增的时候自动插入
    @TableField("userEvaluation")
    private String userEvaluation;

    /**
     * 逻辑删除
     */
    // 逻辑删除注解
    @TableLogic
    // 忽略
    @JsonIgnore
    private Integer deleted;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    @Column(name = "create_time")
    private Date createTime;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 注意！！ 必须开启映射注解
     *
     * @TableName(autoResultMap = true)
     *
     * 以下两种类型处理器，二选一 也可以同时存在
     *
     * 注意！！选择对应的 JSON 处理器也必须存在对应 JSON 解析依赖包
     */

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private OtherInfo otherInfo;

    private Integer count;
}
