package com.zt.model;

public class FB_threeall {
    /**
     * 场次
     */
    private String id;
    private String numId;
    private String eventType;
    private String startDate;
    private String startTime;
    private String home;
    private String visitor;
    private String color;
    /**
     * 赔率
     */
    private String matchID;
    private String handicap;
    private Object current_spf;
    private Object current_rqspf;

    public FB_threeall(String id, String numId, String eventType, String startDate, String startTime, String home, String visitor, String color, String matchID, String handicap, Object current_spf, Object current_rqspf) {
        this.id = id;
        this.numId = numId;
        this.eventType = eventType;
        this.startDate = startDate;
        this.startTime = startTime;
        this.home = home;
        this.visitor = visitor;
        this.color = color;

        this.matchID = matchID;
        this.handicap = handicap;
        this.current_spf = current_spf;
        this.current_rqspf = current_rqspf;
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

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public String getHandicap() {
        return handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }

    public Object getCurrent_spf() {
        return current_spf;
    }

    public void setCurrent_spf(Object current_spf) {
        this.current_spf = current_spf;
    }

    public Object getCurrent_rqspf() {
        return current_rqspf;
    }

    public void setCurrent_rqspf(Object current_rqspf) {
        this.current_rqspf = current_rqspf;
    }
}
