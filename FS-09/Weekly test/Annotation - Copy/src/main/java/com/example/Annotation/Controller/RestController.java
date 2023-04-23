package com.example.Annotation.Controller;


import java.util.List;

import com.example.Annotation.DAO.Employee_Email_DAO;
import com.example.Annotation.Model.Email;
import com.example.Annotation.Model.Employee;
import com.example.Annotation.Service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private Employee_Email_DAO employee_email_DAO;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Weekly test - Annotation.";
    }

    @RequestMapping(value = "/employees", 
            method = RequestMethod.GET, 
            produces = { MediaType.APPLICATION_JSON_VALUE, 
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employee_email_DAO.getAllEmployees();
        return list;
    }

    @RequestMapping(value = "/employee/{empNo}", 
            method = RequestMethod.GET, 
            produces = { MediaType.APPLICATION_JSON_VALUE, 
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmployee(@PathVariable("empNo") String empNo) {
        return employee_email_DAO.getEmployee(empNo);
    }

    @RequestMapping(value = "/employee_create",
            method = RequestMethod.POST, 
            produces = { MediaType.APPLICATION_JSON_VALUE, 
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp) {

        System.out.println("(Service Side) Creating employee: " + emp.getEmpNo());

        return employee_email_DAO.addEmployee(emp);
    }

    @RequestMapping(value = "/employee_edit/{empNo}",
            method = RequestMethod.PUT, 
            produces = { MediaType.APPLICATION_JSON_VALUE, 
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("empNo") String empNo) {
        return employee_email_DAO.updateEmployee(empNo,emp);
    }

    @RequestMapping(value = "/employee_delete/{empNo}",
            method = RequestMethod.DELETE, 
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("empNo") String empNo) {
        employee_email_DAO.deleteEmployee(empNo);
    }


    @Autowired private SendMailService emailService;

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody Email details)
    {
        String status = SendMailService.sendMail(details);

        return status;
    }
}
