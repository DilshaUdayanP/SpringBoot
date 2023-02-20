package com.example.Ecommerce.Service;

import com.example.Ecommerce.DOA.orderRepository;
import com.example.Ecommerce.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {
    @Autowired
    orderRepository orderRepository;

    public Order getOrderbyID(Integer ID){
        Order order = orderRepository.findById(ID).get();
        return order;
    }
}
