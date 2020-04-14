package com.dmsdbj.team.springbootdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team.springbootdemo.entity.User;
import com.dmsdbj.team.springbootdemo.service.IUserService;
import com.dmsdbj.team.springbootdemo.util.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Jessica
 * @since 2020-03-11
 */
@RestController
@RequestMapping("/java/user")
@Slf4j
public class UserController implements IUserController {
  /*  @RequestMapping("/")
    public String index() {

        return "hello world";
    }*/

    @Autowired
    private IUserService userService;


    @Override
    public User getUser(int id) {
        log.info("用户输入的ID:[{}]", id);
        User user = userService.getById(id);
        return user;
    }

    @Override
    @Log
    public IPage getUserList(Page page) {
        log.info("用户输入的查询条件：[{}]", page.toString());
        IPage iPage = userService.page(page);
        return iPage;
    }

    @Override
    public String removeUser(int id) {
        log.info("用户输入的ID:[{}]", id);
        userService.removeById(id);
        return "success remove userId=" + id;
    }

    @Override
    public String saveUser(User user) {
        log.info("用户输入的ID:[{}]", user);
        userService.save(user);
        return "success insert user=" + user;
    }

    @Override
    public List<User> getUserByLikeName(String name) {
        List<User> userList = userService.getUserByLikeName(name);
        return userList;
    }


}
