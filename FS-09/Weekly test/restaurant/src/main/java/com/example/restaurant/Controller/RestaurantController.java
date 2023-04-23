package com.example.restaurant.Controller;

import com.example.restaurant.DAO.Restuarant_DAO;
import com.example.restaurant.Model.Restuarant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private Restuarant_DAO restuarantDao;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Weekly test - Restuarant.";
    }

    @RequestMapping(value = "/Restuarants",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Restuarant> getalldata() {
        List<Restuarant> list = restuarantDao.getalldata();
        return list;
    }

    @RequestMapping(value = "/Restuarant/{empNo}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Restuarant getselecteddata(@PathVariable("empNo") String empNo) {
        return restuarantDao.getselecteddata(empNo);
    }

    @RequestMapping(value = "/Restuarant_create",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Restuarant addRestuarant(@RequestBody Restuarant emp) {

        System.out.println("(Service Side) Creating Restuarant: " + emp.getEmpNo());

        return restuarantDao.addRestuarant(emp);
    }

    @RequestMapping(value = "/Restuarant_edit/{empNo}",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public Restuarant updateRestuarant(@RequestBody Restuarant emp, @PathVariable("empNo") String empNo) {
        return restuarantDao.updateRestuarant(empNo,emp);
    }

    @RequestMapping(value = "/Restuarant_delete/{empNo}",
            method = RequestMethod.DELETE,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteRestuarant(@PathVariable("empNo") String empNo) {
        restuarantDao.deleteRestuarant(empNo);
    }

}
