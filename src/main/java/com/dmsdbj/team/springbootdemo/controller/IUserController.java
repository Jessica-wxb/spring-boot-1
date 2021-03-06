package com.dmsdbj.team.springbootdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team.springbootdemo.entity.User;
import com.dmsdbj.team.springbootdemo.util.log.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName SwaggerController
 * @Description TODO
 * @createTime 2020年03月14日 07:54:00
 */
@Api(tags = {"用户表接口"})
public interface IUserController {
    @ApiOperation(value = "根据Id查询用户", notes = "请用户输出ID")
    @GetMapping("/user/info/{id}")
    User getUser(@ApiParam(value = "id", required = true, defaultValue = "4") @PathVariable("id") int id);

    @ApiOperation(value = "查询所有用户")
    @GetMapping("/user/list")
    @Log
    IPage getUserList(@ApiParam(value = "page", required = true) Page page);

    @Log
    @ApiOperation(value = "根据UserId删除一个用户", notes = "请输入主键id进行查询")
    @DeleteMapping("/user/remove/{id}")
    String removeUser(@ApiParam(value = "id", required = true, defaultValue = "2") @PathVariable("id") int id);

    @Log
    @ApiOperation(value = "新增一个用户", notes = "请输入要新增的用户信息")
    @PostMapping("/user/save")
    String saveUser(@ApiParam(value = "user", required = true) @RequestBody User user);

    @Log
    @ApiOperation(value = "根据姓名模糊查询", notes = "请输入要模糊查询的信息")
    @GetMapping(value = "/user/getUserByLikeName/{name}")
    List<User> getUserByLikeName(@ApiParam(value = "name", required = true) @PathVariable String name);
}
