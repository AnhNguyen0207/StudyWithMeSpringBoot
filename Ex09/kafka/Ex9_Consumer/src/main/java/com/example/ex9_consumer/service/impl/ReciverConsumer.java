package com.example.ex9_consumer.service.impl;

import com.example.ex9_consumer.entity.TongSlSpKho;
import com.example.ex9_consumer.repository.SlSanPhamKhoRepo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ReciverConsumer {

    private final SlSanPhamKhoRepo slSanPhamKhoRepo;

    public ReciverConsumer(SlSanPhamKhoRepo slSanPhamKhoRepo) {
        this.slSanPhamKhoRepo = slSanPhamKhoRepo;
    }

    @KafkaListener(topics = "ex100",groupId = "myGroup")
    public void msg(String msg)
    {
        TongSlSpKho tongSlSpKho = new TongSlSpKho();
        tongSlSpKho.setMaKhoSp(msg);
        tongSlSpKho.setSlSpKho(slSanPhamKhoRepo.selectSanPhamKho(Integer.parseInt(msg)));
        tongSlSpKho.setNgayThongKe(Timestamp.valueOf(java.time.LocalDateTime.now()));
        slSanPhamKhoRepo.save(tongSlSpKho);
    }
}
