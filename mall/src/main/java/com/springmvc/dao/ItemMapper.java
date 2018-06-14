package com.springmvc.dao;

import com.springmvc.pojo.Item;

import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    Item selectByTypeId(int id);

    List<Item> selectAll();

    Item selectByItemName(String name);
}