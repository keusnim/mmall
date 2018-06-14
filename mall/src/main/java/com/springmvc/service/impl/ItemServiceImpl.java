package com.springmvc.service.impl;

import com.springmvc.dao.ItemMapper;
import com.springmvc.dao.TypeMapper;
import com.springmvc.pojo.Item;
import com.springmvc.pojo.Type;
import com.springmvc.service.IItemService;
import com.springmvc.vo.ItemVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("iItemService")
public class ItemServiceImpl implements IItemService {

    @Resource
    private ItemMapper itemMapper;

    @Resource
    private TypeMapper typeMapper;

    public int deleteItemById(int id) {
        int resultCount = itemMapper.deleteByPrimaryKey(id);
        return resultCount;
    }

    public int updateItem(Item item) {
        int resultCount = itemMapper.updateByPrimaryKey(item);
        return resultCount;
    }

    //添加商品
    public int addItem(Item item) {
        Item item1 = itemMapper.selectByItemName(item.getItemName());
        Type type = typeMapper.selectByPrimaryKey(item.getItemType());
        if(item1==null && type!=null){
            itemMapper.insert(item);
        }else if(item1==null || type!=null){
            return 0;
        }
        return 1;
    }

    public List<ItemVo> getAllItem() {
        List<Item> itemList = itemMapper.selectAll();
        List<ItemVo> itemVoList = new ArrayList<ItemVo>();
        for(Item item : itemList){
            ItemVo itemVo = new ItemVo();
            itemVo.setId(item.getId());
            itemVo.setItemName(item.getItemName());
            itemVo.setPrice(item.getPrice());
            itemVo.setItemNumber(item.getItemNumber());
            itemVo.setTypeName(typeMapper.selectByPrimaryKey(item.getItemType()).getName());
            itemVoList.add(itemVo);
        }
        return itemVoList;
    }

    public Item getItemById(int id) {
        return itemMapper.selectByPrimaryKey(id);
    }
}
