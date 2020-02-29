package com.sudhirt.practice.order.service;

import com.sudhirt.practice.order.dto.Customer;
import com.sudhirt.practice.order.entity.Order;
import com.sudhirt.practice.order.gateway.CustomerClient;
import com.sudhirt.practice.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerClient customerClient;

    public String create(Order order) {
        Customer customer = customerClient.get(order.getCustomerId());
        return "OK";
    }
}
