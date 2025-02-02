package com.example.Ecommerce.Controller;


import com.example.Ecommerce.Model.User;
import com.example.Ecommerce.Service.userService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @Autowired
    userService userService;

    public User getUserByID(@Nullable @RequestParam Integer ID){
        return userService.getUserById(ID);
    }

}
