package com.example.EventDB.controller;

import com.example.EventDB.model.StudentModel;
import com.example.EventDB.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/StudentManage/")
public class StudentController {
    private final StudentService studentservice;

    StudentController(StudentService studentservice){
        this.studentservice = studentservice;
    }


    //Add student
    @PostMapping("AddNewStudent")
    public void AddStudent(@RequestBody StudentModel student)
    {
        studentservice.AddStudent(student);
    }

    //update student department
    @PutMapping("UpdateStudent/Id/{Id}")
    public  void UpdateStudent(@PathVariable int Id, @RequestBody StudentModel student)
    {
        studentservice.UpdateStudent(Id,student);
    }

    //delete student
    @DeleteMapping("DeleteStudent/Id/{Id}")
    public void DeleteStudent(@PathVariable int Id)
    {
        studentservice.DeleteStudent(Id);
    }

    //Get all students
    @GetMapping("/GetAllStudents")
    public List<StudentModel> GetAllStudent()
    {
        return studentservice.GetAllStudentFrom();
    }

    //Get student by Id
    @GetMapping("GetSingleStudent/Id/{Id}")
    public StudentModel GetStudentById(@PathVariable int Id)
    {
        return studentservice.GetStudentById(Id);
    }
}
