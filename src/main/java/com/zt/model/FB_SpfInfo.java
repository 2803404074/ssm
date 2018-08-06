package com.zt.model;

/**
 * 胜平负id赔率模型
 */
public class FB_SpfInfo {
    private String matchID;
    private String handicap;
    private Object current_spf;
    private Object current_rqspf;



    public FB_SpfInfo(String matchID, String handicap, String current_spf, String current_rqspf) {
        this.matchID = matchID;
        this.handicap = handicap;
        this.current_spf = current_spf;
        this.current_rqspf = current_rqspf;
    }

    public FB_SpfInfo() {
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
