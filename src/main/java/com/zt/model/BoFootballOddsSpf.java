/**
 * CFR,2018-08-21
 * 竞彩足球 “胜平负/让球胜平负” 赔率业务对象
 * */

package com.zt.model;

public class BoFootballOddsSpf {
    String matchId;
    String handicap;

    String win;
    String draw;
    String loss;

    String win_rq;
    String draw_rq;
    String loss_rq;


    public BoFootballOddsSpf(String matchId, String handicap, String win, String draw, String loss,
                             String win_rq, String draw_rq, String loss_rq)
    {
        this.matchId = matchId;
        this.handicap = handicap;
        this.win = win;
        this.draw = draw;
        this.loss = loss;
        this.win_rq = win_rq;
        this.draw_rq = draw_rq;
        this.loss_rq = loss_rq;
    }

    public BoFootballOddsSpf(BoFootballOddsSpf oddsSpf)
    {
        this.matchId = oddsSpf.matchId;
        this.handicap = oddsSpf.handicap;
        this.win = oddsSpf.win;
        this.draw = oddsSpf.draw;
        this.loss = oddsSpf.loss;
        this.win_rq = oddsSpf.win_rq;
        this.draw_rq = oddsSpf.draw_rq;
        this.loss_rq = oddsSpf.loss_rq;
    }


    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getHandicap() {
        return handicap;
    }

    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getLoss() {
        return loss;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }

    public String getWin_rq() {
        return win_rq;
    }

    public void setWin_rq(String win_rq) {
        this.win_rq = win_rq;
    }

    public String getDraw_rq() {
        return draw_rq;
    }

    public void setDraw_rq(String draw_rq) {
        this.draw_rq = draw_rq;
    }

    public String getLoss_rq() {
        return loss_rq;
    }

    public void setLoss_rq(String loss_rq) {
        this.loss_rq = loss_rq;
    }
}
