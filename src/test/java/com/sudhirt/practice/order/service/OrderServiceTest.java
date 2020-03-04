package com.sudhirt.practice.order.service;

import com.sudhirt.practice.order.BaseStubRunner;
import com.sudhirt.practice.order.entity.Order;
import com.sudhirt.practice.order.entity.OrderItem;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"${customer-service.stubs}"})
public class OrderServiceTest extends BaseStubRunner {

    @Autowired
    private OrderService orderService;

    @Test
    void given_an_order_when_customer_is_found_then_order_should_be_created_successfully() {
        Order order = createOrder();
        assertThat(orderService.create(order)).isEqualTo("OK");
    }

    @Test
    void given_an_order_when_customer_is_not_found_then_404_error_should_be_thrown() {
        Order order = createOrder("invalid_id");
        assertThatExceptionOfType(FeignException.class).isThrownBy(() -> {
            orderService.create(order);
        }).withMessageContaining("404");
    }

    private Order createOrder() {
        return createOrder("valid_id");
    }

    private Order createOrder(String customerId) {
        return Order.builder().customerId(customerId).items(createOrderItems()).build();
    }

    private Set<OrderItem> createOrderItems() {
        Set<OrderItem> items = new HashSet<>();
        items.add(OrderItem.builder().id("item1").productId("product1").price(10.99d).build());
        items.add(OrderItem.builder().id("item2").productId("product2").price(0.99d).build());
        return items;
    }
}
