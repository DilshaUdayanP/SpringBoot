package com.example.User_Management.Model;

public class User {
    private String UserId;
    private String Name;
    private String UserName;
    private String Address;
    private String Number;

    public User(String userId, String name, String userName, String address, String number) {
        UserId = userId;
        Name = name;
        UserName = userName;
        Address = address;
        Number = number;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
