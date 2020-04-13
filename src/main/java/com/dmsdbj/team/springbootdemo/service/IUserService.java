package com.dmsdbj.team.springbootdemo.service;

import com.dmsdbj.team.springbootdemo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jessica
 * @since 2020-03-11
 */
public interface IUserService extends IService<User> {

    List<User> getUserByLikeName(String queryName);
}
