package com.example.Query.Annotation.repository;

import com.example.Query.Annotation.model.Student;
import org.json.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface IStudentRepository extends JpaRepository <Student, Integer>{

    @Query(value = "SELECT * FROM tbl_student s", nativeQuery = true )
    List<Student> getAll();


    //AND
    Student findByLastNameAndFirstName(String lastName, String firstName);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.last_name = ?1 AND s.first_name = ?2", nativeQuery = true )
    Student getByLastNameAndLastName(String lastName, String firstName);

    //******************************************************************************************************************************

    //OR
    Student findByLastNameOrFirstName(String lastName, String firstName);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.last_name = ?1 OR s.first_name = ?2", nativeQuery = true )
    Student getByLastNameOrLastName(String lastName, String firstName);

    //******************************************************************************************************************************

    //TRUE
    List<Student> findByActiveTrue();
    @Query(value = "SELECT * FROM tbl_student s WHERE s.active = true", nativeQuery = true )
    List<Student> getActiveStudent();

    //******************************************************************************************************************************

    //FALSE
    List<Student> findByActiveFalse();
    @Query(value = "SELECT * FROM tbl_student s WHERE s.active = false", nativeQuery = true )
    List<Student> getInactiveStudent();

    //******************************************************************************************************************************

    //IS, EQUAL
    Student findByFirstNameEquals(String firstName);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.first_name = ?1", nativeQuery = true )
    Student getByFirstNameEquals(String firstName);

    //******************************************************************************************************************************

    //BETWEEN
    List<Student> findByAgeBetween(int lowerLimit ,int upperLimit);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.age BETWEEN ?1 AND ?2", nativeQuery = true )
    List<Student> getByAgeBetween(int lowerLimit ,int upperLimit);

    //******************************************************************************************************************************

    //LESS THAN
    List<Student> findByAgeLessThan(int limit);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.age < ?", nativeQuery = true )
    List<Student> getByAgeLessThan(int limit);

    //******************************************************************************************************************************

    //LESS THAN EQUAL
    List<Student> findByAgeLessThanEqual(int limit);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.age <= ?", nativeQuery = true )
    List<Student> getByAgeLessThanEqual(int limit);

    //GREATER THAN
    List<Student> findByAgeGreaterThan(int limit);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.age > ?", nativeQuery = true )
    List<Student> getByAgeGreaterThan(int limit);

    //******************************************************************************************************************************

    //GREATER THAN EQUAL
    List<Student> findByAgeGreaterThanEqual(int limit);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.age >= ?", nativeQuery = true )
    List<Student> getByAgeGreaterThanEqual(int limit);

    //******************************************************************************************************************************

    //LIKE
    List<Student> findByFirstNameLike(String firstName);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.first_name like ?", nativeQuery = true )
    List<Student> getByFirstNameLike(String firstName);

    //******************************************************************************************************************************

    //STARTING WITH
    List<Student> findByFirstNameStartingWith(String firstName);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.first_name like ?%", nativeQuery = true )
    List<Student> getByFirstNameStartingWith(String firstName);

    //******************************************************************************************************************************

    //CONTAINING
    List<Student> findByFirstNameContaining(String firstName);

    @Query(value = "SELECT * FROM tbl_student s WHERE s.first_name like %?%", nativeQuery = true )
    List<Student> getByFirstNameContaining(String firstName);

    //******************************************************************************************************************************

    //ENDING WITH
    List<Student> findByFirstNameEndingWith(String firstName);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.first_name like %?", nativeQuery = true )
    List<Student> getByFirstNameEndingWith(String firstName);

    //******************************************************************************************************************************

    //ODER BY
    List<Student> findByAgeGreaterThanOrderByLastNameDesc(Integer limit);
    @Query(value = "SELECT * FROM tbl_student s WHERE s.age > ? ORDER by s.last_name DESC", nativeQuery = true )
    List<Student> getByAgeGreaterThanOrderByLastNameDesc(Integer limit);

}
