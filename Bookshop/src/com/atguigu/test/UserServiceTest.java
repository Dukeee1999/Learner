package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {

        userService.registUser(new User(null,"jerry","12345","213131@163.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.Login(new User(null,"admin","admin",null)));
    }

    @Test
    public void exitsUsername() {
        System.out.println(userService.exitsUsername("admin"));
    }
}