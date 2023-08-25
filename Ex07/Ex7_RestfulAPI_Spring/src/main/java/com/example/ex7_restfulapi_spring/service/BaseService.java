package com.example.ex7_restfulapi_spring.service;

import com.example.ex7_restfulapi_spring.entity.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    List<T> getAll();
    T add(T t);
    T updateById(T t,int id);
    T findById(int id);
    void deleteById(int id);
    List<T> getAllByNamePage(String ten, Pageable pageable);

}
