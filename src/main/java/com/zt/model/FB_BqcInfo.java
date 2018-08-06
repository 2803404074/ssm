package com.zt.model;

/**
 * 半全场id和赔率模型
 */
public class FB_BqcInfo {
    private String matchID;
    private Object current_bqc;

    public FB_BqcInfo() {
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public Object getCurrent_bqc() {
        return current_bqc;
    }

    public void setCurrent_bqc(Object current_bqc) {
        this.current_bqc = current_bqc;
    }
}
