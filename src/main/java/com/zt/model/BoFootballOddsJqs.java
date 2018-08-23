/**
 * CFR,2018-08-18
 * 竞彩足球 “进球数” 赔率业务对象
 * */

package com.zt.model;

public class BoFootballOddsJqs {
    String matchId;     // 比赛 ID

    String goals_0;          // 进球数 0
    String goals_1;          // 进球数 1
    String goals_2;          // 进球数 2
    String goals_3;          // 进球数 3
    String goals_4;          // 进球数 4
    String goals_5;          // 进球数 5
    String goals_6;          // 进球数 6
    String goals_7More;      // 进球数 7+

    public BoFootballOddsJqs(String matchId, String goals_0, String goals_1, String goals_2, String goals_3,
                             String goals_4, String goals_5, String goals_6, String goals_7More)
    {
        this.matchId = matchId;
        this.goals_0 = goals_0;
        this.goals_1 = goals_1;
        this.goals_2 = goals_2;
        this.goals_3 = goals_3;
        this.goals_4 = goals_4;
        this.goals_5 = goals_5;
        this.goals_6 = goals_6;
        this.goals_7More = goals_7More;
    }

    public BoFootballOddsJqs(BoFootballOddsJqs odds)
    {
        this.matchId = odds.matchId;
        this.goals_0 = odds.goals_0;
        this.goals_1 = odds.goals_1;
        this.goals_2 = odds.goals_2;
        this.goals_3 = odds.goals_3;
        this.goals_4 = odds.goals_4;
        this.goals_5 = odds.goals_5;
        this.goals_6 = odds.goals_6;
        this.goals_7More = odds.goals_7More;
    }


    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getGoals_0() {
        return goals_0;
    }

    public void setGoals_0(String goals_0) {
        this.goals_0 = goals_0;
    }

    public String getGoals_1() {
        return goals_1;
    }

    public void setGoals_1(String goals_1) {
        this.goals_1 = goals_1;
    }

    public String getGoals_2() {
        return goals_2;
    }

    public void setGoals_2(String goals_2) {
        this.goals_2 = goals_2;
    }

    public String getGoals_3() {
        return goals_3;
    }

    public void setGoals_3(String goals_3) {
        this.goals_3 = goals_3;
    }

    public String getGoals_4() {
        return goals_4;
    }

    public void setGoals_4(String goals_4) {
        this.goals_4 = goals_4;
    }

    public String getGoals_5() {
        return goals_5;
    }

    public void setGoals_5(String goals_5) {
        this.goals_5 = goals_5;
    }

    public String getGoals_6() {
        return goals_6;
    }

    public void setGoals_6(String goals_6) {
        this.goals_6 = goals_6;
    }

    public String getGoals_7More() {
        return goals_7More;
    }

    public void setGoals_7More(String goals_7More) {
        this.goals_7More = goals_7More;
    }
}
