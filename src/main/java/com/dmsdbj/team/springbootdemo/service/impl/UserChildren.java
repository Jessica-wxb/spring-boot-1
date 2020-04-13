package com.dmsdbj.team.springbootdemo.service.impl;

import com.dmsdbj.team.springbootdemo.entity.Children;
import com.dmsdbj.team.springbootdemo.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName MyPage.java
 * @Description TODO
 * @createTime 2020年03月27日 16:28:00
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserChildren extends User {
    private List<Children> c;

}
