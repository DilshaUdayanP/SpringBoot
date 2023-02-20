package com.example.Ecommerce.DOA;

import com.example.Ecommerce.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<Order,Integer> {
}
