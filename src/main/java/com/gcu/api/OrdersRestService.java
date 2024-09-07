package com.gcu.api;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class OrdersRestService {

    @Autowired
    private OrdersBusinessInterface service;

    @GetMapping(path="/getjson", produces={MediaType.APPLICATION_JSON_VALUE})
    public List<OrderModel> getOrdersAsJson(){
        return service.getOrders();
    }
    @GetMapping(path="/getxml", produces={MediaType.APPLICATION_XML_VALUE})
    public List<OrderModel> getOrdersAsXml(){
        return service.getOrders();
    }
    @GetMapping(value="/orders", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<OrderModel> getOrders(){
        return service.getOrders();
    }

}
