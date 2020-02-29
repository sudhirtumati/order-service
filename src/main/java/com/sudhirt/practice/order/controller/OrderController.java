package com.sudhirt.practice.order.controller;

import com.sudhirt.practice.order.entity.Order;
import com.sudhirt.practice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    String create(@RequestBody Order order) {
        return orderService.create(order);
    }
}
