package com.sudhirt.practice.order;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import java.net.ServerSocket;

public abstract class BaseStubRunner {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeAll
    protected static void setup() throws Exception {
        ServerSocket ss = new ServerSocket(0);
        initCustomerService(ss.getLocalPort());
    }

    private static void initCustomerService(int port) {
        System.setProperty("customer-service.stubs", "com.sudhirt.practice:customer-service:+:stubs:" + port);
        System.setProperty("customers.url", "http://localhost:" + port + "/customers/v1");
    }
}
