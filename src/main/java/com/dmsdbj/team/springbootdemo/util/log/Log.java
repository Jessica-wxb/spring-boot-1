package com.dmsdbj.team.springbootdemo.util.log;


import java.lang.annotation.*;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName Log.java
 * @Description TODO
 * @createTime 2020年03月14日 05:52:00
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Log {
    String name() default "";
}
