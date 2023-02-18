package com.example.EventDB.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class EventModel {
    private int eventId;
    private String eventName;
    private String locationOfEvent;
    private String date;
    private String startTime;
    private String endTime;
    private String imageurl;

    EventModel(){    }

    public EventModel(int eventId, String eventName,
                      String location, String date, String StartTime,
                      String EndTime, String ImgUrl)
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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
