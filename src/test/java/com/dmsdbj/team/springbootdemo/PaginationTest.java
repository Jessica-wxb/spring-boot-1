package com.dmsdbj.team.springbootdemo;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team.springbootdemo.entity.User;
import com.dmsdbj.team.springbootdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName PaginationTest.java
 * @Description TODO
 * @createTime 2020年03月27日 16:38:00
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaginationTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void lambdaPagination() {
        Page<User> page = new Page<>(1, 3);
        Page<User> result = (Page<User>) userMapper.selectPage(page, Wrappers.<User>lambdaQuery().ge(User::getAge, 1).orderByAsc(User::getAge));
        assertThat(result.getTotal()).isGreaterThan(3);
        assertThat(result.getRecords().size()).isEqualTo(3);
    }
}
