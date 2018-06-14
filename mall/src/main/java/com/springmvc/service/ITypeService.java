package com.springmvc.service;

import com.springmvc.pojo.Type;

import java.util.List;

public interface ITypeService {
    List<Type> getList();

    int delete(int id);

    int insert(Type type);

    Type getTypeByTypeName(String typeName);

    int update(Type type);
}
