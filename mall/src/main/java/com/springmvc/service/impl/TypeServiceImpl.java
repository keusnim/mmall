package com.springmvc.service.impl;


import com.springmvc.dao.ItemMapper;
import com.springmvc.dao.TypeMapper;
import com.springmvc.pojo.Item;
import com.springmvc.pojo.Type;
import com.springmvc.service.ITypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("iTypeService")
public class TypeServiceImpl implements ITypeService {

    @Resource
    private TypeMapper typeMapper;

    @Resource
    private ItemMapper itemMapper;

    public List<Type> getList() {
        List<Type> list = typeMapper.selectAll();
        return list;
    }

    public int delete(int id) {
        Item item = itemMapper.selectByTypeId(id);
        if(item==null){
            typeMapper.deleteByPrimaryKey(id);
        }else{
            return 0;
        }
        return 1;
    }

    public int insert(Type type) {
        Type type1 = typeMapper.selectByTypeName(type.getName());
        if(type1==null){
            typeMapper.insert(type);
        }else {
            return 0;
        }
        return 1;
    }

    public Type getTypeByTypeName(String typeName) {
        return typeMapper.selectByTypeName(typeName);
    }

    public int update(Type type) {
        return typeMapper.updateByPrimaryKey(type);
    }
}
