package com.gcu.business;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.model.OrderModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersBusinessService implements OrdersBusinessInterface {

    @Autowired
    private DataAccessInterface<OrderModel> service;

    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        return service.findAll();
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
