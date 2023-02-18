package com.example.EventDB.service;

import com.example.EventDB.model.EventModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class EventService {
    private static List<EventModel> Event = new ArrayList<>();
    private static int EventCount = 0;

    static{
        //int eventId, String eventName,
        //               String location, Date date, String StartTime,
        //               String EndTime, String ImgUrl
        Event.add(new EventModel(++EventCount,"Event_1","Location_1", "2023-11-11", "2:59:21.5864648","05:32:22",""));
        Event.add(new EventModel(++EventCount,"Event_2","Location_2", "2023-11-11", "05:32:22","2:59:21.5864648",""));
        Event.add(new EventModel(++EventCount,"Event_3","Location_3","2023-11-11", "05:32:22","2:59:21.5864648",""));
        Event.add(new EventModel(++EventCount,"Event_4","Location_4", "2023-11-11", "2:59:21.5864648","05:32:22",""));
        Event.add(new EventModel(1,"Event_5","Location_4", "2023-11-11", "2:59:21.5864648","05:32:22",""));
        Event.add(new EventModel(1,"Event_6","Location_4","2023-11-11", "05:32:22","2:59:21.5864648",""));
    }

//    public EventModel GetAllEvent(LocalDate date)
//    {
//        Predicate<? super EventModel> predicate = Event ->  Event.getDate() == date;
//        EventModel event = Event.stream().filter(predicate).findFirst().get();
//        return event;
//    }

    public EventModel GetAllEvent(int id)
    {
        Predicate<? super EventModel> predicate = Event ->  Event.getEventId() == id;
        EventModel event = Event.stream().filter(predicate).findFirst().get();
        return event;
    }

    public void DeleteEvent(int id) {
        Predicate<? super EventModel> predicate = Event -> Event.getEventId() == id;
        Event.removeIf(predicate);
    }

    public void UpdateEvent(int id, EventModel newevent)
    {
        Predicate<? super EventModel> predicate = Event ->  Event.getEventId() == id;
        EventModel event = Event.stream().filter(predicate).findFirst().get();
        event.setEventName(newevent.getEventName());
        event.setLocationOfEvent(newevent.getLocationOfEvent());
        event.setImageurl(newevent.getImageurl());
    }

    public void AddEvent(EventModel event) {
        Event.add(event);
    }
}
