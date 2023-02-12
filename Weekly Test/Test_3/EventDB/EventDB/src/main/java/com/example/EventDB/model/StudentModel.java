package com.example.EventDB.model;

public class StudentModel
{
    private int StudentId;
    private String firstname;
    private String lastname;
    private int age;
    private String department;

    StudentModel(){

    }

    public StudentModel(int studId, String FName, String LName, int age, String dept)
    {
        this.StudentId = studId;
        this.firstname = FName;
        this.lastname = LName;
        this.age = age;
        this.department = dept;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "StudentId=" + StudentId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}
