package com.zt.model;

/**
 * 进球数id和赔率模型
 */
public class FB_JqsInfo {
    private String matchID;
    private Object current_jqs;

    public FB_JqsInfo() {
    }

    public FB_JqsInfo(String matchID, Object current_jqs) {
        this.matchID = matchID;
        this.current_jqs = current_jqs;
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public Object getCurrent_jqs() {
        return current_jqs;
    }

    public void setCurrent_jqs(Object current_jqs) {
        this.current_jqs = current_jqs;
    }
}
