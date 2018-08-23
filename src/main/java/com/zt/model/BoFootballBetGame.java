/**
 * CFR,2018-08-14
 * 竞彩足球受注场次的数据结构
 * */

package com.zt.model;

public class BoFootballBetGame {

    private String matchId;         // 比赛ID
    private String numId;           //
    private String eventType;       //
    private String startDate;       //
    private String startTime;       //
    private String home;            //
    private String visitor;         //
    private String color;           //

    public BoFootballBetGame(String matchId, String numId, String eventType, String startDate, String startTime, String home, String visitor, String color) {
        this.matchId = matchId;
        this.numId = numId;
        this.eventType = eventType;
        this.startDate = startDate;
        this.startTime = startTime;
        this.home = home;
        this.visitor = visitor;
        this.color = color;
    }

    public BoFootballBetGame(BoFootballBetGame game)
    {
        this.matchId = game.matchId;
        this.numId = game.numId;
        this.eventType = game.eventType;
        this.startDate = game.startDate;
        this.startTime = game.startTime;
        this.home = game.home;
        this.visitor = game.visitor;
        this.color = game.color;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
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

