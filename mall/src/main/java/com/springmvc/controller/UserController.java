package com.springmvc.controller;

import com.springmvc.common.Message;
import com.springmvc.pojo.User;
import com.springmvc.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService iUserService;


    //获取用户 返回User
    //测试MVC
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable int id){
        User user = iUserService.getUser(id);
        return user;
    }

    //跳转登录页面
    @RequestMapping("/showLogin")
    public ModelAndView showLogin(){
        return new ModelAndView("login");
    }

    //登录判断
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int resultCount = iUserService.login(username,password);
        if(resultCount>0){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            modelAndView.setViewName("show_item");
        }else{
            modelAndView.setViewName("fail");
            modelAndView.addObject(Message.createErr("登录失败","/user/showLogin"));
        }
        return modelAndView;

    }

    //注册
    @RequestMapping(value = "/doRegister",method = RequestMethod.POST)
    public ModelAndView doRegister(@Param("username")String username, @Param("password")String password){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int resultCount = iUserService.insertUser(user);
        if(resultCount>0){
            modelAndView.setViewName("login");
        }else{
            modelAndView.setViewName("fail");
            modelAndView.addObject(Message.createErr("用户名重复，请重新输入","/user/showRegister"));
        }
        return modelAndView;
    }

    //显示注册页面
    @RequestMapping(value = "/showRegister")
    public ModelAndView showPage(){
        return new ModelAndView("register");
    }

    //退出系统 将session设置为null
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("username",null);
        return "login";
    }


}
