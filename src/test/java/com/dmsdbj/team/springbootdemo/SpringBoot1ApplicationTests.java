package com.dmsdbj.team.springbootdemo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team.springbootdemo.entity.User;
import com.dmsdbj.team.springbootdemo.mapper.UserMapper;
import com.dmsdbj.team.springbootdemo.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot1ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testSelect() {
        // null表示无条件
        List<User> users = userMapper.selectList(null);
        // 简单断言
        Assert.assertEquals(6, users.size());
        users.forEach(System.out::println);
    }

   @Test
    void testPage() {
        //(当前页，页大小)
       IPage<User> page = new Page<User>(1, 5);
       IPage<User> page1 = userService.page(page);
       List<User> list = page1.getRecords();
       list.forEach(System.out::println);
   }
}
