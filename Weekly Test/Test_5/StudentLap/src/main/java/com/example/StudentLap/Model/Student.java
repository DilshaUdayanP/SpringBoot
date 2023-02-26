package com.example.StudentLap.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Student_tbl")
public class Student {
    @Id
    private String ID;
    private String name;
    private String age;
    private String phoneNumber;
    private String branch;
    private String department;

    @Embedded
    private Address address;
}
