package com.example.Restaurant.model;

public class Restaurant
{
    private String reataurant_name;
    private String reataurant_address;
    private int reataurant_number;
    private String reataurant_speciality;
    private int reataurant_Total_Staff;
    private int reataurawnt_Number_Branches;

    private Boolean Open_Or_Not;

    Restaurant(){ }

    Restaurant(String reataurant_name, String reataurant_address, int reataurant_number, String reataurant_speciality, int reataurant_Total_Staff, int reataurawnt_Number_Branches)
    {
        this.reataurant_name = reataurant_name;
        this.reataurant_address = reataurant_address;
        this.reataurant_number = reataurant_number;
        this.reataurant_speciality=reataurant_speciality;
        this.reataurant_Total_Staff=reataurant_Total_Staff;
        this.reataurawnt_Number_Branches=reataurawnt_Number_Branches;
    }

    public void setReataurant_name(String reataurant_name) {
        this.reataurant_name = reataurant_name;
    }

    public void setReataurant_address(String reataurant_address) {
        this.reataurant_address = reataurant_address;
    }

    public void setReataurant_number(int reataurant_number) {
        this.reataurant_number = reataurant_number;
    }

    public void setReataurant_speciality(String reataurant_speciality) {
        this.reataurant_speciality = reataurant_speciality;
    }

    public void setReataurant_Total_Staff(int reataurant_Total_Staff) {
        this.reataurant_Total_Staff = reataurant_Total_Staff;
    }

    public void setReataurawnt_Number_Branches(int reataurawnt_Number_Branches) {
        this.reataurawnt_Number_Branches = reataurawnt_Number_Branches;
    }

    public void setOpen_Or_Not(Boolean open_Or_Not) {
        Open_Or_Not = open_Or_Not;
    }

    public String getReataurant_name() {
        return reataurant_name;
    }

    public String getReataurant_address() {
        return reataurant_address;
    }

    public int getReataurant_number() {
        return reataurant_number;
    }

    public String getReataurant_speciality() {
        return reataurant_speciality;
    }

    public int getReataurant_Total_Staff() {
        return reataurant_Total_Staff;
    }

    public int getReataurawnt_Number_Branches() {
        return reataurawnt_Number_Branches;
    }

    public Boolean getOpen_Or_Not() {
        return Open_Or_Not;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "reataurant_name='" + reataurant_name + '\'' +
                ", reataurant_address='" + reataurant_address + '\'' +
                ", reataurant_number=" + reataurant_number +
                ", reataurant_speciality='" + reataurant_speciality + '\'' +
                ", reataurant_Total_Staff=" + reataurant_Total_Staff +
                ", reataurawnt_Number_Branches=" + reataurawnt_Number_Branches +
                ", Open_Or_Not=" + Open_Or_Not +
                '}';
    }
}
