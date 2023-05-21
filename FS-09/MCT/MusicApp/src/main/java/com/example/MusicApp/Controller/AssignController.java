package com.example.MusicApp.Controller;

import com.example.MusicApp.Exception.ResourceNotFoundException;
import com.example.MusicApp.Model.User;
import com.example.MusicApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/User")
public class AssignController {
    @Autowired
    private UserRepository user_repository;

    //Get all user details
    @GetMapping
    public List<User> getAllUserDetails(){
        return user_repository.findAll();
    }

    //create a new user
    @PostMapping("/createUser")
    public User createNewUser(@RequestBody User user)
    {
        return user_repository.save(user);
    }

    //show selected user
    @GetMapping("selectedUser/{id}")
    public ResponseEntity<User> getuserById(@PathVariable long id)
    {
        User user = user_repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User not exist. Please check the ID"));
        return ResponseEntity.ok(user);
    }

    //delete the user
    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id)
    {
        User user = user_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found to update your changes"));
        user_repository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update user role
    //@PutMapping("updateUser/{id}")
    @RequestMapping(value = "/updateUser/{id}",
            produces = "application/json",
            method=RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userdetails)
    {
        User user = user_repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found to update your changes"));
        user.setRole(userdetails.getRole());
        user.setUserName(userdetails.getUserName());
        user.setPassword(userdetails.getPassword());

        user_repository.save(user);
        return ResponseEntity.ok(user);
    }
}
