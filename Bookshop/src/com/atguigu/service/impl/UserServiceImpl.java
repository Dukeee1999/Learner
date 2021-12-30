package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userdao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userdao.saveUser(user);
    }

    @Override
    public User Login(User user) {
        return userdao.queryUserByUsernameAndPwd(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean exitsUsername(String username) {
        if(userdao.queryUserByUsername(username)==null){
            return false;
        }
        return true;

    }
}
