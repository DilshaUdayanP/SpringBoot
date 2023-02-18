package com.example.UserManagment.controller;

import com.example.UserManagment.model.User_Model;
import com.example.UserManagment.service.User_Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/UserManagment")
public class User_Controller
{
    private final User_Service userService;

    public User_Controller(User_Service userService) {
        this.userService = userService;
    }

    @PostMapping("AdddNewUser")
    public void AddUser(@RequestBody User_Model user)
    {
        userService.AddUser(user);
    }

    @GetMapping("GetUserById/Id/{id}")
    public User_Model GetUserById(@PathVariable int id)
    {
        return userService.GetUserById(id);
    }

    @GetMapping("GetAllUser")
    public List<User_Model> GetAllUser()
    {
        return userService.GetAllUser();
    }

    @PutMapping("UpdateUser/Id/{id}")
    public void UpdateUser(@PathVariable int id,@RequestBody User_Model userModel)
    {
        userService.UpdateUser(id,userModel);
    }

    @DeleteMapping("DeleteUser/Id/{id}")
    public void DeleteUser(@PathVariable int id)
    {
        userService.DeleteUser(id);
    }
}
