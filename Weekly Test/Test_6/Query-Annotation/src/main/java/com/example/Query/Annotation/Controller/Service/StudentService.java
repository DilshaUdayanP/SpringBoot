
package com.example.Query.Annotation.Controller.Service;

import com.example.Query.Annotation.model.Student;
import com.example.Query.Annotation.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentService {
    @Autowired
    IStudentRepository repository;

    public JSONObject saveStudent(Student student) {
        student.setAdmissionDate(new Date(System.currentTimeMillis()));
        JSONObject response = new JSONObject();
        response.put("Created",new JSONObject(repository.save(student)));
        return response;
    }

    public JSONObject updateStudent(Student newStudent, Integer studentId) {
        JSONObject response = new JSONObject();
        try{
            Student oldStudent = repository.findById(studentId).get();
            if(newStudent.getAge() != null) newStudent.setAge(newStudent.getAge());
            if(newStudent.getFirstName() != null) newStudent.setFirstName(newStudent.getFirstName());
            if(newStudent.getLastName() != null) newStudent.setLastName(newStudent.getLastName());
            if(newStudent.getAdmissionDate() != null) newStudent.setAdmissionDate(newStudent.getAdmissionDate());
            if(newStudent.getActive() != null) newStudent.setActive(newStudent.getActive());
            response.put("Updated",new JSONObject(repository.save(oldStudent)));
        }catch (Exception e){
            response.put("Error", e.toString());
        }
        return  response;
    }

    public JSONObject getStudent() {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findAll());
        response.put("By Query Annotation", repository.getAll());
        return response;
    }

    public JSONObject getActiveStudent() {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findByActiveTrue());
        response.put("By Query Annotation", repository.getActiveStudent());
        return response;
    }

    public JSONObject getInactiveStudent() {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findByActiveFalse());
        response.put("By Query Annotation", repository.getInactiveStudent());
        return response;
    }
    public JSONObject findByLastNameAndFirstName(String lastName, String firstName) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", new JSONObject(repository.findByLastNameAndFirstName(lastName, firstName)));
        response.put("By Query Annotation", new JSONObject(repository.getByLastNameAndLastName(lastName, firstName)));
        return response;
    }

    public JSONObject findByLastNameOrFirstName(String lastName, String firstName) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", new JSONObject(repository.findByLastNameOrFirstName(lastName, firstName)));
        response.put("By Query Annotation", new JSONObject(repository.getByLastNameOrLastName(lastName, firstName)));
        return response;
    }

    public JSONObject findByFirstNameEquals(String firstName) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", new JSONObject(repository.findByFirstNameEquals(firstName)));
        response.put("By Query Annotation", new JSONObject(repository.getByFirstNameEquals(firstName)));
        return response;
    }

    public JSONObject findByAgeBetween(Integer lowerLimit ,Integer upperLimit) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findByAgeBetween(lowerLimit, upperLimit));
        response.put("By Query Annotation", repository.getByAgeBetween(lowerLimit, upperLimit));
        return response;
    }

    public JSONObject findByAgeLessThan(Integer limit) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findByAgeLessThan(limit));
        response.put("By Query Annotation", repository.getByAgeLessThan(limit));
        return response;
    }

    public JSONObject findByAgeLessThanEqual(Integer limit) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findByAgeLessThanEqual(limit));
        response.put("By Query Annotation",repository.getByAgeLessThanEqual(limit));
        return response;
    }

    public JSONObject findByAgeGreaterThan(Integer limit) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findByAgeGreaterThan(limit));
        response.put("By Query Annotation", repository.getByAgeGreaterThan(limit));
        return response;
    }

    public JSONObject findByAgeGreaterThanEqual(Integer limit) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findByAgeGreaterThanEqual(limit));
        response.put("By Query Annotation", repository.getByAgeGreaterThanEqual(limit));
        return response;
    }


    public JSONObject findByFirstNameLike(String firstName) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method",repository.findByFirstNameLike("%" + firstName + "%"));
        response.put("By Query Annotation", repository.getByFirstNameLike("%" + firstName + "%"));
        return response;
    }

    public JSONObject findByFirstNameStartingWith(String firstName) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findByFirstNameStartingWith(firstName));
        response.put("By Query Annotation", repository.getByFirstNameStartingWith(firstName));
        return response;
    }

    public JSONObject findByFirstNameContaining(String firstName) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findByFirstNameContaining(firstName));
        response.put("By Query Annotation", repository.getByFirstNameContaining(firstName));
        return response;
    }

    public JSONObject findByFirstNameEndingWith(String firstName) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findByFirstNameEndingWith(firstName));
        response.put("By Query Annotation", repository.getByFirstNameEndingWith(firstName));
        return response;
    }

    public JSONObject findByAgeGreaterThanOrderByLastNameDesc(Integer limit) {
        JSONObject response = new JSONObject();
        response.put("By Custom Method", repository.findByAgeGreaterThanOrderByLastNameDesc(limit));
        response.put("By Query Annotation", repository.getByAgeGreaterThanOrderByLastNameDesc(limit));
        return response;
    }
}
