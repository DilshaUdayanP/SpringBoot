package com.example.user.managment.Model;

public class User {
    public int UserId;
    public String username;
    public String DateOfBirth;
    public String email;
    public String Phone_Number;
    public String Date;
    public String Time;

    public User(int userId, String username, String dateOfBirth, String email, String phone_Number, String date, String time) {
        UserId = userId;
        this.username = username;
        DateOfBirth = dateOfBirth;
        this.email = email;
        Phone_Number = phone_Number;
        Date = date;
        Time = time;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
