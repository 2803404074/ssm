package com.zt.model;

/**
 * 比赛信息模型
 */
public class FB_MainInfo {
    private String id;
    private String numId;
    private String eventType;
    private String startDate;
    private String startTime;
    private String home;
    private String visitor;
    private String color;

    public FB_MainInfo(String id, String numId, String eventType, String startDate, String startTime, String home, String visitor, String color) {
        this.id = id;
        this.numId = numId;
        this.eventType = eventType;
        this.startDate = startDate;
        this.startTime = startTime;
        this.home = home;
        this.visitor = visitor;
        this.color = color;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
