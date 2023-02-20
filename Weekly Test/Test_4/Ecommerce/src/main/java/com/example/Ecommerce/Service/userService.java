package com.example.Ecommerce.Service;

import com.example.Ecommerce.DOA.userRepository;
import com.example.Ecommerce.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    userRepository userRepo;
    public User getUserById(Integer id){
        return userRepo.findById(id).get();
    }

}

