/**
 * CFR,2018-08-21
 * 竞彩足球 “半全场” 赔率业务对象
 * */


package com.zt.model;

public class BoFootballOddsBqc {
    String matchId; // 比赛ID
    String ww;       // 上半场胜，全场胜
    String wd;       // 上半场胜，全场平
    String wl;       // 上半场胜，全场负

    String dw;       // 上半场平，全场胜
    String dd;       // 上半场平，全场平
    String dl;       // 上半场平，全场负

    String lw;       // 上半场负，全场胜
    String ld;       // 上半场负，全场平
    String ll;       // 上半场负，全场负

    public BoFootballOddsBqc(String matchId, String ww, String wd, String wl,
                             String dw, String dd, String dl,
                             String lw, String ld, String ll)
    {
        this.matchId = matchId;
        this.ww = ww;
        this.wd = wd;
        this.wl = wl;
        this.dw = dw;
        this.dd = dd;
        this.dl = dl;
        this.lw = lw;
        this.ld = ld;
        this.ll = ll;
    }

    public BoFootballOddsBqc(BoFootballOddsBqc odds)
    {
        this.matchId = odds.matchId;
        this.ww = odds.ww;
        this.wd = odds.wd;
        this.wl = odds.wl;
        this.dw = odds.dw;
        this.dd = odds.dd;
        this.dl = odds.dl;
        this.lw = odds.lw;
        this.ld = odds.ld;
        this.ll = odds.ll;
    }


    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getWw() {
        return ww;
    }

    public void setWw(String ww) {
        this.ww = ww;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getWl() {
        return wl;
    }

    public void setWl(String wl) {
        this.wl = wl;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    public String getLw() {
        return lw;
    }

    public void setLw(String lw) {
        this.lw = lw;
    }

    public String getLd() {
        return ld;
    }

    public void setLd(String ld) {
        this.ld = ld;
    }

    public String getLl() {
        return ll;
    }

    public void setLl(String ll) {
        this.ll = ll;
    }

}
