package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Order;
import com.example.Ecommerce.Service.orderService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class orderController {
    @Autowired
    orderService orderService;

    @GetMapping("OrderById")
    public Order getOrderByID(@Nullable @RequestParam Integer ID){
        return orderService.getOrderbyID(ID);
    }

}
