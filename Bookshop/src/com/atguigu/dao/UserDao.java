package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {

    //return null, no user, vice versa
    public User queryUserByUsername(String username);

    //save user Info
    public int saveUser(User user);

    // query by username and password
    public User queryUserByUsernameAndPwd(String username,String password);


}
