package com.dmsdbj.team.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmsdbj.team.springbootdemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmsdbj.team.springbootdemo.service.impl.MyPage;
import com.dmsdbj.team.springbootdemo.service.impl.ParamSome;
import com.dmsdbj.team.springbootdemo.service.impl.UserChildren;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jessica
 * @since 2020-03-11
 */
public interface UserMapper extends BaseMapper<User> {
// UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper，所以不填写就是无任何条件

    /**
     * <p>
     * 查询：根据state状态查询用户列表，分页显示
     * </p>
     *
     * @param page  分页对象，xml中可以从里面进行取值。传递参数 Page 即自动分页，必须放在第一位（你可以继承Page实现自己的分页对象）
     * @param state 状态
     * @return 分页对象
     */
    IPage<User> selectPageVo(Page<?> page, Integer state);
    /**
     * 3.x 的page 可以进行取值，多个入参记录得加上注解
     * 自定义page 类必须放在入参第一位
     * 返回值可以用 IPage<T> 接收 也可以使用入参得 MyPage<T> 接收
     * <li>3.1.0 之前的版本使用注解会报错，写在xml 里就没事</li>
     * <li>3.1.0 开始支持注解，但是返回值只支持 IPage,不支持 IPage 的子类</li>
     *
     * @param myPage 自定义 page
     * @return 分页数据
     */
    MyPage<User> mySelectPage(@Param("pg") MyPage<User> myPage, @Param("ps") ParamSome paramSome);

    @ResultMap("userChildrenMap")
    @Select("<script>select u.id,u.name,u.email,u.age,c.id as \"c_id\",c.name as \"c_name\",c.user_id as \"c_user_id\" " +
            "from user u " +
            "left join children c on c.user_id = u.id " +
            "<where>" +
            "<if test=\"selectInt != null\"> " +
            "and u.age = #{selectInt} " +
            "</if> " +
            "<if test=\"selectStr != null and selectStr != ''\"> " +
            "and c.name = #{selectStr} " +
            "</if> " +
            "</where>" +
            "</script>")
    MyPage<UserChildren> userChildrenPage(MyPage<UserChildren> myPage);


    MyPage<User> mySelectPageMap(@Param("pg") MyPage<User> myPage, @Param("map") Map param);

    List<User> mySelectMap(Map param);

    List<User> myPageSelect(MyPage<User> myPage);

    List<User> iPageSelect(IPage<User> myPage);

    List<User> rowBoundList(RowBounds rowBounds, Map map);

}
