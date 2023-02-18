package com.example.EventDB.controller;

import com.example.EventDB.model.EventModel;
import com.example.EventDB.service.EventService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/EventManage/")
public class EventController {
    //For Event model

    private final EventService eventservice;

    public EventController(EventService eventservice) {
        this.eventservice = eventservice;
    }

    //Add event
    @PostMapping("AddNewEvent")
    public void AddEvent(@RequestBody EventModel event)
    {
        eventservice.AddEvent(event);
    }

    //Update event
    @PutMapping("UpdateEvent/Id/{Id}")
    public  void UpdateEvent(@PathVariable int Id, @RequestBody EventModel event)
    {
        eventservice.UpdateEvent(Id,event);
    }

    //Delete event
    @DeleteMapping("DeleteEvent/Id/{Id}")
    public void DeleteEvent(@PathVariable int Id)
    {
        eventservice.DeleteEvent(Id);
    }


    //Get All event by date
//    @GetMapping("/GetEventOn/Date/{date}")
//    public EventModel GetAllEvent(@PathVariable LocalDate date)
//    {
//        return eventservice.GetAllEvent(date);
//    }

    //Get All event by Id
    @GetMapping("/GetEventOn/Id/{id}")
    public EventModel GetAllEvent(@PathVariable int id)
    {
        return eventservice.GetAllEvent(id);
    }

}
