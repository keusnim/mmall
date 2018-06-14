package com.springmvc.controller;

import com.springmvc.common.Message;
import com.springmvc.pojo.Item;
import com.springmvc.service.IItemService;
import com.springmvc.vo.ItemVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("item")
public class ItemController {

    @Resource
    private IItemService iItemService;

    //展示商品
    @RequestMapping("list")
    public ModelAndView getItem(){
        ModelAndView modelAndView = new ModelAndView();
        List<ItemVo> itemVoList = iItemService.getAllItem();
        modelAndView.setViewName("item");
        modelAndView.addObject(itemVoList);
        return modelAndView;
    }

    //删除商品
    @RequestMapping("delete")
    public String deleteItem(@RequestParam int id){
        int resultCount = iItemService.deleteItemById(id);
        return "redirect:/item/list";
    }

    //跳转更新商品页面
    @RequestMapping("update")
    public ModelAndView updateItem(@RequestParam int id){
        Item item = iItemService.getItemById(id);
        ModelAndView modelAndView = new ModelAndView("update_item");
        modelAndView.addObject(item);
        return modelAndView;
    }

    @RequestMapping("save")
    public ModelAndView doSave(Item item){
        iItemService.updateItem(item);
        return new ModelAndView("redirect:/item/list");
    }

    //跳转增加商品页面
    @RequestMapping("addItem")
    public String addItem(){
        return "addItem";
    }

    //添加商品
    @RequestMapping("add")
    public ModelAndView addItem(Item item){
        int resultCount = iItemService.addItem(item);
        ModelAndView modelAndView = new ModelAndView();
        if(resultCount>0){
            //添加成功
            modelAndView.setViewName("redirect:/item/list");
        }else{
            modelAndView.setViewName("fail");
            modelAndView.addObject(Message.createErr("添加失败，请检查商品名字是否重复或者类型ID是否存在。","/item/addItem"));
        }
        return modelAndView;
    }

}
