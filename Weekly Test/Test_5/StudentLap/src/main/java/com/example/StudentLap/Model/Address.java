package com.example.StudentLap.Model;
import jakarta.persistence.*;
@Entity
@Table(name = "address_tbl")
public class Address {
    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;
}
