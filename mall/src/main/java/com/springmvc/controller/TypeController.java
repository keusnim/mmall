package com.springmvc.controller;

import com.springmvc.common.Message;
import com.springmvc.pojo.Type;
import com.springmvc.service.ITypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("type")
public class TypeController {

    @Resource
    private ITypeService iTypeService;

    //显示所有type
    @RequestMapping("list")
    public String getList(HttpServletRequest request){
        List<Type> list = iTypeService.getList();
        request.setAttribute("typeList",list);
        return "manageType";
    }

    //删除type
    @RequestMapping("delete")
    public ModelAndView deleteType(@RequestParam Integer id){
        ModelAndView modelAndView = new ModelAndView();
       int resultCount = iTypeService.delete(id);
       if(resultCount>0){
           modelAndView.setViewName("redirect:/type/list");
       }else{
           modelAndView.setViewName("fail");
           modelAndView.addObject(Message.createErr("该类别下存在商品，不能删除","/type/list"));
       }
        return modelAndView;
    }

    //跳转页面
    @RequestMapping("addType")
    public String addType(){
        return "addType";
    }

    //增加type
    @RequestMapping("add")
    public ModelAndView addType(Type type){
        ModelAndView modelAndView = new ModelAndView();
        int resultCount = iTypeService.insert(type);
        if(resultCount > 0 ){
            modelAndView.setViewName("redirect:/type/list");
        }else{
            modelAndView.setViewName("fail");
            modelAndView.addObject(Message.createErr("该类别名字已存在，请重新添加","/type/addType"));
        }
        return modelAndView;

    }

    //跳转修改type页面
    @RequestMapping("update")
    public ModelAndView update(@RequestParam String typeName){
        Type type = iTypeService.getTypeByTypeName(typeName);
        ModelAndView modelAndView = new ModelAndView("update_type");
        modelAndView.addObject(type);
        return modelAndView;
    }

    //修改type
    @RequestMapping("save")
    public ModelAndView doSave(Type type){
        iTypeService.update(type);
        return new ModelAndView("redirect:/type/list");
    }

}
