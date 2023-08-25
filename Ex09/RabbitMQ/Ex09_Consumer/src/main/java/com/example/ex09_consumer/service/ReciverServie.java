package com.example.ex09_consumer.service;

import com.example.ex09_consumer.config.ReciverConfig;
import com.example.ex09_consumer.entity.TongSlSpKho;
import com.example.ex09_consumer.model.TotalProduct;
import com.example.ex09_consumer.repository.TotalProductRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;

@Service
public class ReciverServie {
    private final TotalProductRepo totalProductRepo;

    public ReciverServie(TotalProductRepo totalProductRepo) {
        this.totalProductRepo = totalProductRepo;
    }

    @RabbitListener(queues = ReciverConfig.QUEU)
    public  void getMessage(Message message)
    {
        ObjectMapper objectMapper= new ObjectMapper();

        try {
            TotalProduct totalProduct= objectMapper.readValue(message.getBody(),TotalProduct.class);
            TongSlSpKho tongSlSpKho = new TongSlSpKho();
            tongSlSpKho.setMaKhoSp(totalProduct.getWarehouseId());
            tongSlSpKho.setSlSpKho(Integer.parseInt(totalProduct.getTotalProduct()));
            tongSlSpKho.setNgayThongKe(Timestamp.valueOf(java.time.LocalDateTime.now()));
            totalProductRepo.save(tongSlSpKho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
