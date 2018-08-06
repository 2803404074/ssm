package com.zt.model;

/**
 * 比分id和赔率模型
 */
public class FB_BfInfo {
    private String matchID;
    private Object current_bf;

    public FB_BfInfo() {
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public Object getCurrent_bf() {
        return current_bf;
    }

    public void setCurrent_bf(Object current_bf) {
        this.current_bf = current_bf;
    }
}
