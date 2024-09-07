package com.gcu;

import com.gcu.business.AnotherBusinessService;
import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.OrdersBusinessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class SpringConfig {

    public OrdersBusinessInterface getOrdersBusiness(){
        return new OrdersBusinessService();
    }

}
