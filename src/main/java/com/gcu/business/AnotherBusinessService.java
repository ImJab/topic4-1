package com.gcu.business;

import com.gcu.api.OrdersRestService;
import com.gcu.model.OrderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class AnotherBusinessService implements OrdersBusinessInterface {
    private static final Logger logger = LoggerFactory.getLogger(OrdersRestService.class);
    @Override
    public void test() {
        System.out.println("Hello from the AnotherOrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> orders = new ArrayList<OrderModel>();
        orders.add(new OrderModel(0L, "000000001", "Product 1", 1.00f, 1));
        orders.add(new OrderModel(1L, "000000002", "Product 2", 2.00f, 2));
        orders.add(new OrderModel(2L, "000000003", "Product 3", 3.00f, 3));
        orders.add(new OrderModel(3L, "000000004", "Product 4", 4.00f, 4));
        orders.add(new OrderModel(4L, "000000005", "Product 5", 5.00f, 5));

        return orders;
    }
    @Override
    public void init() {
        System.out.println("Hello from the Init() method");
    }
    @Override
    public void destroy() {
        System.out.println("Hello from the DESTROY() method");
    }
}
