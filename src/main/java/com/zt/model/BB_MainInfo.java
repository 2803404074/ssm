package com.zt.model;

public class BB_MainInfo {
    private String id;
    private String numId ;
    private String eventType ;
    private String date ;
    private String time;
    private String home ;
    private String abrv ;

    public BB_MainInfo() {
    }

    public BB_MainInfo(String id,String numId, String eventType, String date, String time, String home, String abrv) {
        this.id = id;
        this.numId = numId;
        this.eventType = eventType;
        this.date = date;
        this.time = time;
        this.home = home;
        this.abrv = abrv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAbrv() {
        return abrv;
    }

    public void setAbrv(String abrv) {
        this.abrv = abrv;
    }
}
