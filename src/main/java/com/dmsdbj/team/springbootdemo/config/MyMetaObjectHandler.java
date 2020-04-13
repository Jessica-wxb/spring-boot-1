package com.dmsdbj.team.springbootdemo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName MyMetaObjectHandler.java
 * @Description MybatisPlus 自动填充
 * @createTime 2020年03月12日 15:42:00
 */
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createFieldType = getFieldValByName("createTime", metaObject);
        Object updateFieldType = getFieldValByName("updateTime", metaObject);
        if (createFieldType == null) {
            setFieldValByName("createTime", new Date(), metaObject);
        }
        if (updateFieldType == null) {
            setFieldValByName("createTime", new Date(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateFieldType = getFieldValByName("updateTime", metaObject);
        if (updateFieldType == null) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }

    }
}
