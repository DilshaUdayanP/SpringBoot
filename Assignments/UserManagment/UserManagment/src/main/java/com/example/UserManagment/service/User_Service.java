package com.example.UserManagment.service;

import com.example.UserManagment.model.User_Model;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class User_Service
{
    private static List<User_Model> userModel = new ArrayList<>();

    private static int UserIdCount=0;

    static {
        userModel.add(new User_Model(++UserIdCount,"Dilsha","dilshaudayan@gmail.com","9447073577","30-06-1996","18-02-2022","08:33 AM"));
        userModel.add(new User_Model(++UserIdCount,"Keerthi","dilshaudayanp@gmail.com","8848536371","31-07-1997","19-02-2022","09:33 AM"));
        userModel.add(new User_Model(++UserIdCount,"Arjun","dileshprintn@gmail.com","9597054330","20-08-1998","20-02-2022","10:33 AM"));
        userModel.add(new User_Model(++UserIdCount,"Dilesh","dileshudayan@gmail.com","8301051776","10-09-1999","21-02-2022","11:33 AM"));
        userModel.add(new User_Model(++UserIdCount,"Shyni","dileshudayanp@gmail.com","0495 2345715","30-10-2000","22-02-2022","12:33 AM"));
    }

    public void AddUser(User_Model SingleuserModel)
    {
        userModel.add(SingleuserModel);
    }

    public User_Model GetUserById(int Id)
    {
        Predicate<? super User_Model> predicate = userModel -> userModel.getUserId() == Id;
        User_Model DatauserModel = userModel.stream().filter(predicate).findFirst().get();
        return DatauserModel;
    }

    public List<User_Model> GetAllUser(){
        return userModel;
    }

    public void UpdateUser(int id, User_Model newUser)
    {
        Predicate<? super User_Model> predicate = userModel -> userModel.getUserId() == id;
        User_Model student = userModel.stream().filter(predicate).findFirst().get();
        student.setUserId(newUser.getUserId());
        student.setEmail(newUser.getEmail());
        student.setTime(newUser.getTime());
        student.setUsername(newUser.getUsername());
        student.setDate(newUser.getDate());
        student.setPhone_Number(newUser.getPhone_Number());
        student.setDateOfBirth(newUser.getDateOfBirth());
    }

    public void DeleteUser(int id)
    {
        Predicate<? super User_Model> predicate = userModel -> userModel.getUserId() == id;
        userModel.removeIf(predicate);
    }
}


