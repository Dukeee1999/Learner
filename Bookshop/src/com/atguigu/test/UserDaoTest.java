package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryUserByUsername("admin")==null){
            System.out.println("UserName Available!");
        }else{
            System.out.println("Already exits!");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(null,"Duke","52cm99","cm931003@gmail.com")));

    }

    @Test
    public void queryUserByUsernameAndPwd() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryUserByUsernameAndPwd("admin","admin")==null){
            System.out.println("Login fail!");
        }else{
            System.out.println("successful login!");
        }
    }
}