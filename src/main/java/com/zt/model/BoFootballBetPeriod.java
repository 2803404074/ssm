/**
 * CFR,2018-08-14
 * 竞彩足球受注分期数据结构
 *
 * */

package com.zt.model;

import java.util.ArrayList;
import java.util.List;

public class BoFootballBetPeriod {
    private String period;
    private List<BoFootballBetGame> games;


    public BoFootballBetPeriod(String period, List<BoFootballBetGame> games)
    {
        this.period = period;

        if (games != null)
            this.games = new ArrayList<BoFootballBetGame>(games);  // 深拷贝
    }



    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setGames(List<BoFootballBetGame> games) {
        this.games = games;
    }

    public List<BoFootballBetGame> getGames() {

        return games;
    }
}
