package com.example.ex09_poducer.service.impl;

import com.example.ex09_poducer.model.TotalProduct;
import com.example.ex09_poducer.repository.TotalProductRepo;
import com.example.ex09_poducer.service.ITotalProductService;
import org.springframework.stereotype.Service;

@Service
public class TotalProductService implements ITotalProductService {
    private final TotalProductRepo totalProductRepo;

    public TotalProductService(TotalProductRepo totalProductRepo) {
        this.totalProductRepo = totalProductRepo;
    }
    @Override
    public TotalProduct getByWareHouseId(String id) {
        TotalProduct totalProduct = new TotalProduct();
        totalProduct.setWarehouseId(id);
        totalProduct.setTotalProduct(totalProductRepo.totalProduct(id));
        return totalProduct;
    }
}
