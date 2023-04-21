package com.example.User_Management.Controller;

import com.example.User_Management.Model.User;
import com.example.User_Management.Service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private static UserService userservice;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Assignment - User Management";
    }

    @RequestMapping(value = "/users",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<User> getusers() {
        List<User> list = userservice.getUsers();
        return list;
    }

    @RequestMapping(value = "/user/{userid}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public User getuser(@PathVariable("userid") String userid) {
        return userservice.getUser(userid);
    }

    @RequestMapping(value = "/user_create",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public User adduser(@RequestBody User usr) {

        System.out.println("(Service Side) Creating employee: " + usr.getUserId());

        return userservice.addUser(usr);
    }

    @RequestMapping(value = "/user_edit/{userid}",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public User updateEmployee(@RequestBody User usr, @PathVariable("userid") String userId) {
        return userservice.updateEmployee(userId,usr);
    }

}
