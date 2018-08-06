package com.zt.pojo;

import java.util.Date;

public class SlDataSoccer {
    private String id;
    private String eventId;
    private String dataId;
    private String numberOfPeriods;
    private String lotteryType;
    private String dataType;
    private String period;
    private String numId;
    private String numName;
    private String startDate;
    private String startTime;
    private String eventDate;
    private String eventType;
    private String eventTypeAbrv;
    private String home;
    private String homeAbrv;
    private String visitor;
    private String visitorAbrv;
    private String eventBgColor;
    private String contents;
    private String homeScore;
    private String visitorScore;
    private String homeScoreHalf;
    private String visitorScoreHalf;
    private String created;
    private String updated;
    private Date createdAt;
    private Date updatedAt;

    public SlDataSoccer() {
    }

    public SlDataSoccer(String id, String numId, String startDate, String startTime, String eventType, String home, String visitor, String eventBgColor) {
        this.id = id;
        this.numId = numId;
        this.startDate = startDate;
        this.startTime = startTime;
        this.eventType = eventType;
        this.home = home;
        this.visitor = visitor;
        this.eventBgColor = eventBgColor;
    }

    @Override
    public String toString() {
        return "SlDataSoccer{" +
                "id='" + id + '\'' +
                ", eventId='" + eventId + '\'' +
                ", dataId='" + dataId + '\'' +
                ", numberOfPeriods='" + numberOfPeriods + '\'' +
                ", lotteryType='" + lotteryType + '\'' +
                ", dataType='" + dataType + '\'' +
                ", period='" + period + '\'' +
                ", numId='" + numId + '\'' +
                ", numName='" + numName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventTypeAbrv='" + eventTypeAbrv + '\'' +
                ", home='" + home + '\'' +
                ", homeAbrv='" + homeAbrv + '\'' +
                ", visitor='" + visitor + '\'' +
                ", visitorAbrv='" + visitorAbrv + '\'' +
                ", eventBgColor='" + eventBgColor + '\'' +
                ", contents='" + contents + '\'' +
                ", homeScore='" + homeScore + '\'' +
                ", visitorScore='" + visitorScore + '\'' +
                ", homeScoreHalf='" + homeScoreHalf + '\'' +
                ", visitorScoreHalf='" + visitorScoreHalf + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public SlDataSoccer(String id, String eventId, String dataId, String numberOfPeriods, String lotteryType, String dataType, String period, String numId, String numName, String startDate, String startTime, String eventDate, String eventType, String eventTypeAbrv, String home, String homeAbrv, String visitor, String visitorAbrv, String eventBgColor, String contents, String homeScore, String visitorScore, String homeScoreHalf, String visitorScoreHalf, String created, String updated, Date createdAt, Date updatedAt) {
        this.id = id;
        this.eventId = eventId;
        this.dataId = dataId;
        this.numberOfPeriods = numberOfPeriods;
        this.lotteryType = lotteryType;
        this.dataType = dataType;
        this.period = period;
        this.numId = numId;
        this.numName = numName;
        this.startDate = startDate;
        this.startTime = startTime;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.eventTypeAbrv = eventTypeAbrv;
        this.home = home;
        this.homeAbrv = homeAbrv;
        this.visitor = visitor;
        this.visitorAbrv = visitorAbrv;
        this.eventBgColor = eventBgColor;
        this.contents = contents;
        this.homeScore = homeScore;
        this.visitorScore = visitorScore;
        this.homeScoreHalf = homeScoreHalf;
        this.visitorScoreHalf = visitorScoreHalf;
        this.created = created;
        this.updated = updated;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getNumberOfPeriods() {
        return numberOfPeriods;
    }

    public void setNumberOfPeriods(String numberOfPeriods) {
        this.numberOfPeriods = numberOfPeriods;
    }

    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getNumName() {
        return numName;
    }

    public void setNumName(String numName) {
        this.numName = numName;
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

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTypeAbrv() {
        return eventTypeAbrv;
    }

    public void setEventTypeAbrv(String eventTypeAbrv) {
        this.eventTypeAbrv = eventTypeAbrv;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getHomeAbrv() {
        return homeAbrv;
    }

    public void setHomeAbrv(String homeAbrv) {
        this.homeAbrv = homeAbrv;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getVisitorAbrv() {
        return visitorAbrv;
    }

    public void setVisitorAbrv(String visitorAbrv) {
        this.visitorAbrv = visitorAbrv;
    }

    public String getEventBgColor() {
        return eventBgColor;
    }

    public void setEventBgColor(String eventBgColor) {
        this.eventBgColor = eventBgColor;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getVisitorScore() {
        return visitorScore;
    }

    public void setVisitorScore(String visitorScore) {
        this.visitorScore = visitorScore;
    }

    public String getHomeScoreHalf() {
        return homeScoreHalf;
    }

    public void setHomeScoreHalf(String homeScoreHalf) {
        this.homeScoreHalf = homeScoreHalf;
    }

    public String getVisitorScoreHalf() {
        return visitorScoreHalf;
    }

    public void setVisitorScoreHalf(String visitorScoreHalf) {
        this.visitorScoreHalf = visitorScoreHalf;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
