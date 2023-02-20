package com.example.Ecommerce.DOA;

import com.example.Ecommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Integer> {
}
