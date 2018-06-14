package com.springmvc.service;

import com.springmvc.pojo.Item;
import com.springmvc.vo.ItemVo;

import java.util.List;

public interface IItemService {

    int deleteItemById(int id);

    int updateItem(Item item);

    int addItem(Item item);

    List<ItemVo> getAllItem();

    Item getItemById(int id);
}
