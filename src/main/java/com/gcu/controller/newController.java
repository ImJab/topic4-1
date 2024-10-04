package com.gcu.controller;

import com.gcu.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class newController {
    @GetMapping("/")
    public String display(Model model){
        model.addAttribute("pageTitle", "Login Form");
        model.addAttribute("loginModel", new LoginModel());

        return "login";
    }
}
