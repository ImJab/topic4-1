package com.gcu.controller;
import java.util.*;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model; // Import the Model class


@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private OrdersBusinessInterface service;
    @Autowired
    private SecurityBusinessService security;

    @Autowired
    public void setSecurity(SecurityBusinessService security) {
        this.security = security;
    }
    @Autowired
    public void setService(OrdersBusinessInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public String display(Model model){
        model.addAttribute("pageTitle", "Login Form");
        model.addAttribute("loginModel", new LoginModel());

        return "login";
    }
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){
        service.test();
        security.authenticate(loginModel.getUsername(), loginModel.getPassword());

        List<OrderModel> orders = service.getOrders();

        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Login Form");
            return"login";
        }
        System.out.println(String.format("Form with Username of %s and Passwrod of %s", loginModel.getUsername(), loginModel.getPassword()));

        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);
        return "orders";
    }
}
