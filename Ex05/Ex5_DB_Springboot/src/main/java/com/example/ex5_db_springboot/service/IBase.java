package com.example.ex5_db_springboot.service;

import java.util.List;

public interface IBase<T> {
    List<T> getAll();
    void create(T t);

}
