package com.example.restaurant.DAO;

import com.example.restaurant.Model.Restuarant;

import java.util.*;

public class Restuarant_DAO {
    private static final Map<String, Restuarant> empMap = new HashMap<String, Restuarant>();

    static
    {
        initEmps();
    }

    private static void initEmps()
    {
        Restuarant emp1 = new Restuarant("E01", "Smith", "Clerk");
        Restuarant emp2 = new Restuarant("E02", "Allen", "Salesman");
        Restuarant emp3 = new Restuarant("E03", "Jones", "Manager");
        Restuarant emp4 = new Restuarant("E04", "Jone4", "programmer");

        empMap.put(emp1.getEmpNo(), emp1);
        empMap.put(emp2.getEmpNo(), emp2);
        empMap.put(emp3.getEmpNo(), emp3);
        empMap.put(emp4.getEmpNo(), emp4);
    }

    public Restuarant getselecteddata(String empNo)
    {
        return empMap.get(empNo);
    }
    public Restuarant addRestuarant(Restuarant emp)
    {
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }
    public Restuarant updateRestuarant(String id, Restuarant emp)
    {
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }
    public void deleteRestuarant(String empNo)
    {
        empMap.remove(empNo);
        System.out.println("(Service Side) Deleting employee: " + empNo);
    }
    public static List<Restuarant> getalldata()
    {
        Collection<Restuarant> c = empMap.values();
        List<Restuarant> list = new ArrayList<Restuarant>();
        list.addAll(c);
        return list;
    }
}
