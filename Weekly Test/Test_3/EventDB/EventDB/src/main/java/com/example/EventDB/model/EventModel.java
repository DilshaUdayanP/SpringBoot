package com.example.EventDB.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class EventModel {
    private int eventId;
    private String eventName;
    private String locationOfEvent;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String imageurl;

    EventModel(){    }

    public EventModel(int eventId, String eventName,
                      String location, LocalDate date, LocalTime StartTime,
                      LocalTime EndTime, String ImgUrl)
    {
        this.eventId = eventId;
        this.eventName = eventName;
        this.locationOfEvent = location;
        this.date = date;
        this.startTime = StartTime;
        this.endTime = EndTime;
        this.imageurl = ImgUrl;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocationOfEvent() {
        return locationOfEvent;
    }

    public void setLocationOfEvent(String locationOfEvent) {
        this.locationOfEvent = locationOfEvent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", locationOfEvent='" + locationOfEvent + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }
}
