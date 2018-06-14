package com.springmvc.service;

import com.springmvc.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface IUserService {

    User getUser(int id);

    int insertUser(User user);

    int login(String username, String password);

}
