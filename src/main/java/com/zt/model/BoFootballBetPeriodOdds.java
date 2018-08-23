/**
 * CFR,2018-08-14
 * 竞彩足球“受注场次” + “赔率” 分期数据结构
 *
 * */


package com.zt.model;

import java.util.ArrayList;
import java.util.List;

public class BoFootballBetPeriodOdds {
    private String period;
    private List<BoFootballBetGameOdds> gameOdds;    // 比赛和赔率

    public BoFootballBetPeriodOdds(String period, List<BoFootballBetGameOdds> gameOdds)
    {
        this.period = period;
        this.gameOdds = new ArrayList<BoFootballBetGameOdds>(gameOdds);
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<BoFootballBetGameOdds> getGameOdds() {
        return gameOdds;
    }

    public void setGameOdds(List<BoFootballBetGameOdds> gameOdds) {
        this.gameOdds = gameOdds;
    }
}
