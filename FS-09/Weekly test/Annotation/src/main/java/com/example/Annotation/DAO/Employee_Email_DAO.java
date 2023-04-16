package com.example.Annotation.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Annotation.Model.Email;
import com.example.Annotation.Model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class Employee_Email_DAO
{
    private static final Map<String, Employee> empMap = new HashMap<String, Employee>();

    static
    {
        initEmps();
    }

    private static void initEmps()
    {
        Employee emp1 = new Employee("E01", "Smith", "Clerk");
        Employee emp2 = new Employee("E02", "Allen", "Salesman");
        Employee emp3 = new Employee("E03", "Jones", "Manager");
        Employee emp4 = new Employee("E04", "Jone4", "programmer");

        empMap.put(emp1.getEmpNo(), emp1);
        empMap.put(emp2.getEmpNo(), emp2);
        empMap.put(emp3.getEmpNo(), emp3);
        empMap.put(emp4.getEmpNo(), emp4);
    }

    public Employee getEmployee(String empNo)
    {
        return empMap.get(empNo);
    }
    public Employee addEmployee(Employee emp)
    {
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }
    public Employee updateEmployee(String id,Employee emp)
    {
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }
    public void deleteEmployee(String empNo)
    {
        empMap.remove(empNo);
    }
    public static List<Employee> getAllEmployees()
    {
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }
}
