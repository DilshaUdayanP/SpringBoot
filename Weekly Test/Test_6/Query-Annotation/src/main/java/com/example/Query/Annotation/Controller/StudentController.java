package com.example.Query.Annotation.Controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.example.Query.Annotation.Controller.Service.StudentService;
import com.example.Query.Annotation.model.Student;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    StudentService service;
    @PostMapping("saveStudent")//✅
    private ResponseEntity<String> saveStudent(@RequestBody Student student){
        JSONObject response = service.saveStudent(student);
        return new ResponseEntity<>(response.toString() , HttpStatus.CREATED);
    }

    @GetMapping("getStudent")//✅
    private ResponseEntity<String> getStudent(){
        JSONObject response = service.getStudent();
        return new ResponseEntity<>(response.toString() , HttpStatus.OK);
    }

    @PutMapping("updateStudent")
    private ResponseEntity<String> updateStudent(@RequestBody Student student, @RequestParam Integer studentId){
        JSONObject response = service.updateStudent(student, studentId);
        return new ResponseEntity<>(response.toString() , HttpStatus.CREATED);
    }
    @GetMapping("getActiveStudent")//✅
    private ResponseEntity<String> getActiveStudent(){
        JSONObject response = service.getActiveStudent();
        return new ResponseEntity<>(response.toString() , HttpStatus.OK);
    }

    @GetMapping("getInactiveStudent")//✅
    private ResponseEntity<String> getInactiveStudent(){
        JSONObject response = service.getInactiveStudent();
        return new ResponseEntity<>(response.toString() , HttpStatus.OK);
    }

    @GetMapping("findByLastNameAndFirstName")//✅
    private ResponseEntity<String> findByLastNameAndFirstName(@RequestParam String lastName, @RequestParam String firstName){
        JSONObject response = service.findByLastNameAndFirstName(lastName, firstName);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

    @GetMapping("findByLastNameOrFirstName")//✅
    private ResponseEntity<String> findByLastNameOrFirstName(@RequestParam String lastName, @RequestParam String firstName){
        JSONObject response = service.findByLastNameOrFirstName(lastName, firstName);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

    @GetMapping("findByFirstNameEquals")//✅
    private ResponseEntity<String> findByFirstnameEquals(@RequestParam String firstName){
        JSONObject response = service.findByFirstNameEquals(firstName);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

    @GetMapping(value = "findByAgeBetween")//✅
    private ResponseEntity<String> findByAgeBetween(@RequestParam Integer lowerLimit, @RequestParam Integer upperLimit){
        JSONObject response = service.findByAgeBetween(lowerLimit, upperLimit);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

    @GetMapping(value = "findByAgeLessThan")//✅
    private ResponseEntity<String> findByAgeLessThan(@RequestParam Integer limit){
        JSONObject response = service.findByAgeLessThan(limit);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

    @GetMapping(value = "findByAgeLessThanEqual")//✅
    private ResponseEntity<String> findByAgeLessThanEqual(@RequestParam Integer limit){
        JSONObject response = service.findByAgeLessThanEqual(limit);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

    @GetMapping(value = "findByAgeGreaterThan")//✅
    private ResponseEntity<String> findByAgeGreaterThan(@RequestParam Integer limit){
        JSONObject response = service.findByAgeGreaterThan(limit);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

    @GetMapping(value = "findByAgeGreaterThanEqual")//✅
    private ResponseEntity<String> findByAgeGreaterThanEqual(@RequestParam Integer limit){
        JSONObject response = service.findByAgeGreaterThanEqual(limit);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }
    @GetMapping(value = "findByFirstNameLike")//✅
    private ResponseEntity<String> findByFirstNameLike(@RequestParam String firstName){
        JSONObject response = service.findByFirstNameLike(firstName);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

    @GetMapping(value = "findByFirstNameStartingWith")//✅
    private ResponseEntity<String> findByFirstNameStartingWith(@RequestParam String firstName){
        JSONObject response = service.findByFirstNameStartingWith(firstName);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

    @GetMapping(value = "findByFirstNameContaining")//✅
    private ResponseEntity<String> findByFirstNameContaining(@RequestParam String firstName){
        JSONObject response = service.findByFirstNameContaining(firstName);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

    @GetMapping(value = "findByFirstNameEndingWith")//✅
    private ResponseEntity<String> findByFirstNameEndingWith(@RequestParam String firstName){
        JSONObject response = service.findByFirstNameEndingWith(firstName);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

    @GetMapping(value = "findByAgeGreaterThanOrderByLastNameDesc")//✅
    private ResponseEntity<String> findByAgeGreaterThanOrderByLastNameDesc(@RequestParam Integer limit){
        JSONObject response = service.findByAgeGreaterThanOrderByLastNameDesc(limit);
        return new ResponseEntity<>(response.toString()  , HttpStatus.OK);
    }

}
