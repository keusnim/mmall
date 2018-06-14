package com.springmvc.service.impl;

import com.springmvc.dao.UserMapper;
import com.springmvc.pojo.User;
import com.springmvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public User getUser(int id){
        User user = userMapper.selectByPrimaryKey(id);
        if(user!=null){
            return user;
        }
        return null;
    }

    public int insertUser(User user) {
        User user1 = userMapper.selectByUsername(user.getUsername());
        if(user1==null){
            return userMapper.insertSelective(user);
        }else{
            return 0;
        }
    }

    public int login(String username, String password) {
        User user = userMapper.selectByUsernameAndPassword(username,password);
        if(user!=null){
            return 1;
        }
        return 0;
    }


}
