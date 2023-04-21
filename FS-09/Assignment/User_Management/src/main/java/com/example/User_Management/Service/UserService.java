package com.example.User_Management.Service;

import com.example.User_Management.Model.User;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.*;

@Service
public class UserService {
    private static final Map<String, User> userMap = new HashMap<String, User>();

    public UserService() {
        User user_1 = new User("1", "Charle", "Clerk","Calicut","1234568");
        User user_2 = new User("2", "Allen", "Salesman","Calicut","1234568");
        User user_3 = new User("3", "Jones", "Manager","Calicut","1234568");
        User user_4 = new User("4", "Jone4", "programmer","Calicut","1234568");

        userMap.put(user_1.getUserId(), user_1);
        userMap.put(user_2.getUserId(), user_2);
        userMap.put(user_1.getUserId(), user_3);
        userMap.put(user_1.getUserId(), user_4);
    }

    public static List<User> getUsers()
    {
        Collection<User> c = userMap.values();
        List<User> list = new ArrayList<User>();
        list.addAll(c);
        return list;
    }

    public User addUser(User usr)
    {
       userMap.put(usr.getUserId(), usr);
       return usr;
    }

    public User getUser(String userId)
    {
        return userMap.get(userId);
    }

    public User updateEmployee(String id,User usr)
    {
        userMap.put(usr.getUserId(), usr);
        return usr;
    }
    public void deleteEmployee(String userId)
    {
        userMap.remove(userId);
        System.out.println("Deleting employee: " + userId);
    }
}
