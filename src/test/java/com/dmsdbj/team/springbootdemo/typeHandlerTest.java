package com.dmsdbj.team.springbootdemo;

import com.dmsdbj.team.springbootdemo.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName typeHandlerTest.java
 * @Description TODO
 * @createTime 2020年04月13日 11:50:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class typeHandlerTest {
    @Resource
    private UserMapper userMapper;

    /**
     * 自定义类型处理器演示参数 mybatis-
     */
}
