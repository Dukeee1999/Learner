package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {

    public void registUser(User user);

    public User Login(User user);

    public boolean exitsUsername(String username);
}
