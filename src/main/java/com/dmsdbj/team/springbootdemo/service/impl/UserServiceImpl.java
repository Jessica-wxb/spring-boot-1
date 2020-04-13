package com.dmsdbj.team.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmsdbj.team.springbootdemo.entity.User;
import com.dmsdbj.team.springbootdemo.mapper.UserMapper;
import com.dmsdbj.team.springbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jessica
 * @since 2020-03-11
 */
@Service
@Transactional
public class UserServiceImpl  extends ServiceImpl<UserMapper,User>implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUserByLikeName(String queryName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", queryName);
        List<User> userList = userMapper.selectList(queryWrapper);
        return userList;
    }

    public IPage<User> selectUserPage(Page<User> page, Integer state) {
        // 不进行count sql 优化， 解决MP无法自动优化SQL问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false)
        // 当total为小于0 或者设置 setSearchCount(false) 分页插件不会进行 count查询
        // 要点！！分页返回的对象与传入的对象是同一个
        return userMapper.selectPageVo(page, state);
    }
}
