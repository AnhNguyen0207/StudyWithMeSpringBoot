package com.example.ex09_consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalProduct {
    private String  warehouseId;
    private String totalProduct;
}
