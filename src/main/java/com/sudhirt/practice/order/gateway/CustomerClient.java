package com.sudhirt.practice.order.gateway;

import com.sudhirt.practice.order.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "customers", url = "${customers.url}")
public interface CustomerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = "application/json")
    Customer get(@PathVariable("id") String id);
}
