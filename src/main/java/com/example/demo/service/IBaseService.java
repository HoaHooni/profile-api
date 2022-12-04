package com.example.demo.service;

import java.util.List;

public interface IBaseService<T> {

    T getById(Long id);

    List<T> getAll();

    T add(T dto);

    List<T> addList(List<T> dtos);

    T update(T dto);

    List<T> updateList(List<T> dtos);

    void delete(T dto);

    void delete(Long id);

    void deleteList(List<T> dtos);

    void deleteByIds(List<Long> ids);
}
