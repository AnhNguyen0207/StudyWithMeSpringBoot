package com.example.ex09_poducer.controller;

import com.example.ex09_poducer.config.MessageConfig;
import com.example.ex09_poducer.model.TotalProduct;
import com.example.ex09_poducer.service.ITotalProductService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TotalProductController {
    private final RabbitTemplate rabbitTemplate;
    private final ITotalProductService totalProductService;

    public TotalProductController(RabbitTemplate rabbitTemplate, ITotalProductService totalProductService) {
        this.rabbitTemplate = rabbitTemplate;
        this.totalProductService = totalProductService;
    }

    @PostMapping("/admin/total-product/{id}")
    public TotalProduct getToTalbyWareHouseId(@PathVariable("id") String id)
    {
        rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE,MessageConfig.KEY,totalProductService.getByWareHouseId(id));
        return totalProductService.getByWareHouseId(id);
    }
}
