package com.example.UserManagment.model;

public class User_Model {
    private int UserId;
    private  String username;
    private String email;
    private String Phone_Number;
    private  String DateOfBirth;

    @Override
    public String toString() {
        return "User_Model{" +
                "UserId=" + UserId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", Phone_Number='" + Phone_Number + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    private String date;
    private String time;

    User_Model(){}

    public User_Model(int userId, String username, String email, String phone_Number, String dateOfBirth, String date, String time) {
        UserId = userId;
        this.username = username;
        this.email = email;
        Phone_Number = phone_Number;
        DateOfBirth = dateOfBirth;
        this.date = date;
        this.time = time;
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

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
