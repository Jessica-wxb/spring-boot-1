package com.dmsdbj.team.springbootdemo.controller;

import com.dmsdbj.team.springbootdemo.entity.User;
import com.dmsdbj.team.springbootdemo.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName UserControllerTest.java
 * @Description TODO
 * @createTime 2020年03月14日 07:31:00
 */
@WebMvcTest(UserController.class)
//@AutoConfigureMybatis
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserService userService;
    List<User> userList = new ArrayList<User>();

    User user = new User();


}
