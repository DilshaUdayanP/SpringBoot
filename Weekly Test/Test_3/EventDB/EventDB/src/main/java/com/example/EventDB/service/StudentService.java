package com.example.EventDB.service;

import com.example.EventDB.model.EventModel;
import com.example.EventDB.model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class StudentService {
    private static List<StudentModel> Student = new ArrayList<>();
    private static int StudentCount = 0;

    static{
        Student.add(new StudentModel(++StudentCount,"Dilsha","Udayan",27,"CSE"));
        Student.add(new StudentModel(++StudentCount,"Keerthi","AV",28,"ECE"));
        Student.add(new StudentModel(++StudentCount,"Shyni","P",30,"Mech"));
        Student.add(new StudentModel(++StudentCount,"Udayan","P",40,"CSE"));
        Student.add(new StudentModel(++StudentCount,"Arjun","K",25,"Civil"));
        Student.add(new StudentModel(++StudentCount,"Dilesh","P",26,"CSE"));
        Student.add(new StudentModel(++StudentCount,"Karthik","K",27,"Electronics"));
        Student.add(new StudentModel(++StudentCount,"Sheela","J",28,"ECE"));
    }

    public List<StudentModel> GetAllStudentFrom(){
        return Student;
    }

    public StudentModel GetStudentById(int Id)
    {
        Predicate<? super StudentModel> predicate = Student -> Student.getStudentId() == Id;
        StudentModel student = Student.stream().filter(predicate).findFirst().get();
        return student;
    }

    public void AddStudent(StudentModel student)
    {
        Student.add(student);
    }

    public void UpdateStudent(int id, StudentModel newstudent)
    {
        Predicate<? super StudentModel> predicate = Student -> Student.getStudentId() == id;
        StudentModel student = Student.stream().filter(predicate).findFirst().get();
        student.setStudentId(newstudent.getStudentId());
        student.setAge(newstudent.getAge());
        student.setDepartment(newstudent.getDepartment());
        student.setFirstname(newstudent.getFirstname());
        student.setLastname(newstudent.getLastname());
    }

    public void DeleteStudent(int id)
    {
        Predicate<? super StudentModel> predicate = Student -> Student.getStudentId() == id;
        Student.removeIf(predicate);
    }
}
