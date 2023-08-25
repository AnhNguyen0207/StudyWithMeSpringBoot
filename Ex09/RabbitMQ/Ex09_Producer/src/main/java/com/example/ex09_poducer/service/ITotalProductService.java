package com.example.ex09_poducer.service;

import com.example.ex09_poducer.model.TotalProduct;

public interface ITotalProductService {
    TotalProduct getByWareHouseId(String id);
}
