/**
 * CFR,2018-08-21
 * 竞彩足球 “比分” 赔率业务对象
 * */

package com.zt.model;

public class BoFootballOddsBf {
    String matchId;     // 比赛 ID

    String win_1_0;      // 主队胜，比分 1-0
    String win_2_0;      // 主队胜，比分 2-0
    String win_2_1;      // 主队胜，比分 2-1
    String win_3_0;      // 主队胜，比分 3-0
    String win_3_1;      // 主队胜，比分 3-1
    String win_3_2;      // 主队胜，比分 3-2
    String win_4_0;      // 主队胜，比分 4-0
    String win_4_1;      // 主队胜，比分 4-1
    String win_4_2;      // 主队胜，比分 4-2
    String win_5_0;      // 主队胜，比分 5-0
    String win_5_1;      // 主队胜，比分 5-1
    String win_5_2;      // 主队胜，比分 5-2
    String win_more;     // 主队胜，其他比分

    String draw_0_0;      // 平局，比分 0-0
    String draw_1_1;      // 平局，比分 1-1
    String draw_2_2;      // 平局，比分 2-2
    String draw_3_3;      // 平局，比分 3-3
    String draw_more;     // 平局，其他比分

    String loss_0_1;      // 主队负，比分 0-1
    String loss_0_2;      // 主队负，比分 0-2
    String loss_1_2;      // 主队负，比分 1-2
    String loss_0_3;      // 主队负，比分 0-3
    String loss_1_3;      // 主队负，比分 1-3
    String loss_2_3;      // 主队负，比分 2-3
    String loss_0_4;      // 主队负，比分 0-4
    String loss_1_4;      // 主队负，比分 1-4
    String loss_2_4;      // 主队负，比分 2-4
    String loss_0_5;      // 主队负，比分 0-5
    String loss_1_5;      // 主队负，比分 1-5
    String loss_2_5;      // 主队负，比分 2-5
    String loss_more;      // 主队负，比分 0-1

    public BoFootballOddsBf(String matchId,
                            String win_1_0, String win_2_0, String win_2_1, String win_3_0, String win_3_1, String win_3_2, String win_4_0, String win_4_1, String win_4_2, String win_5_0, String win_5_1, String win_5_2, String win_more,
                            String draw_0_0, String draw_1_1, String draw_2_2, String draw_3_3, String draw_more,
                            String loss_0_1, String loss_0_2, String loss_1_2, String loss_0_3, String loss_1_3, String loss_2_3, String loss_0_4, String loss_1_4, String loss_2_4, String loss_0_5, String loss_1_5, String loss_2_5, String loss_more)
    {
        this.matchId = matchId;     // 比赛 ID

        this.win_1_0 = win_1_0;      // 主队胜，比分 1-0
        this.win_2_0 = win_2_0;      // 主队胜，比分 2-0
        this.win_2_1 = win_2_1;      // 主队胜，比分 2-1
        this.win_3_0 = win_3_0;      // 主队胜，比分 3-0
        this.win_3_1 = win_3_1;      // 主队胜，比分 3-1
        this.win_3_2 = win_3_2;      // 主队胜，比分 3-2
        this.win_4_0 = win_4_0;      // 主队胜，比分 4-0
        this.win_4_1 = win_4_1;      // 主队胜，比分 4-1
        this.win_4_2 = win_4_2;      // 主队胜，比分 4-2
        this.win_5_0 = win_5_0;      // 主队胜，比分 5-0
        this.win_5_1 = win_5_1;      // 主队胜，比分 5-1
        this.win_5_2 = win_5_2;      // 主队胜，比分 5-2
        this.win_more = win_more;     // 主队胜，其他比分

        this.draw_0_0 = draw_0_0;      // 平局，比分 0-0
        this.draw_1_1 = draw_1_1;      // 平局，比分 1-1
        this.draw_2_2 = draw_2_2;      // 平局，比分 2-2
        this.draw_3_3 = draw_3_3;      // 平局，比分 3-3
        this.draw_more = draw_more;     // 平局，其他比分

        this.loss_0_1 = loss_0_1;      // 主队负，比分 0-1
        this.loss_0_2 = loss_0_2;      // 主队负，比分 0-2
        this.loss_1_2 = loss_1_2;      // 主队负，比分 1-2
        this.loss_0_3 = loss_0_3;      // 主队负，比分 0-3
        this.loss_1_3 = loss_1_3;      // 主队负，比分 1-3
        this.loss_2_3 = loss_2_3;      // 主队负，比分 2-3
        this.loss_0_4 = loss_0_4;      // 主队负，比分 0-4
        this.loss_1_4 = loss_1_4;      // 主队负，比分 1-4
        this.loss_2_4 = loss_2_4;      // 主队负，比分 2-4
        this.loss_0_5 = loss_0_5;      // 主队负，比分 0-5
        this.loss_1_5 = loss_1_5;      // 主队负，比分 1-5
        this.loss_2_5 = loss_2_5;      // 主队负，比分 2-5
        this.loss_more = loss_more;      // 主队负，比分 0-1
    }

    public BoFootballOddsBf(BoFootballOddsBf odds)
    {
        this.matchId = odds.matchId;     // 比赛 ID

        this.win_1_0 = odds.win_1_0;      // 主队胜，比分 1-0
        this.win_2_0 = odds.win_2_0;      // 主队胜，比分 2-0
        this.win_2_1 = odds.win_2_1;      // 主队胜，比分 2-1
        this.win_3_0 = odds.win_3_0;      // 主队胜，比分 3-0
        this.win_3_1 = odds.win_3_1;      // 主队胜，比分 3-1
        this.win_3_2 = odds.win_3_2;      // 主队胜，比分 3-2
        this.win_4_0 = odds.win_4_0;      // 主队胜，比分 4-0
        this.win_4_1 = odds.win_4_1;      // 主队胜，比分 4-1
        this.win_4_2 = odds.win_4_2;      // 主队胜，比分 4-2
        this.win_5_0 = odds.win_5_0;      // 主队胜，比分 5-0
        this.win_5_1 = odds.win_5_1;      // 主队胜，比分 5-1
        this.win_5_2 = odds.win_5_2;      // 主队胜，比分 5-2
        this.win_more = odds.win_more;     // 主队胜，其他比分

        this.draw_0_0 = odds.draw_0_0;      // 平局，比分 0-0
        this.draw_1_1 = odds.draw_1_1;      // 平局，比分 1-1
        this.draw_2_2 = odds.draw_2_2;      // 平局，比分 2-2
        this.draw_3_3 = odds.draw_3_3;      // 平局，比分 3-3
        this.draw_more = odds.draw_more;     // 平局，其他比分

        this.loss_0_1 = odds.loss_0_1;      // 主队负，比分 0-1
        this.loss_0_2 = odds.loss_0_2;      // 主队负，比分 0-2
        this.loss_1_2 = odds.loss_1_2;      // 主队负，比分 1-2
        this.loss_0_3 = odds.loss_0_3;      // 主队负，比分 0-3
        this.loss_1_3 = odds.loss_1_3;      // 主队负，比分 1-3
        this.loss_2_3 = odds.loss_2_3;      // 主队负，比分 2-3
        this.loss_0_4 = odds.loss_0_4;      // 主队负，比分 0-4
        this.loss_1_4 = odds.loss_1_4;      // 主队负，比分 1-4
        this.loss_2_4 = odds.loss_2_4;      // 主队负，比分 2-4
        this.loss_0_5 = odds.loss_0_5;      // 主队负，比分 0-5
        this.loss_1_5 = odds.loss_1_5;      // 主队负，比分 1-5
        this.loss_2_5 = odds.loss_2_5;      // 主队负，比分 2-5
        this.loss_more = odds.loss_more;      // 主队负，比分 0-1

    }


    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getWin_1_0() {
        return win_1_0;
    }

    public void setWin_1_0(String win_1_0) {
        this.win_1_0 = win_1_0;
    }

    public String getWin_2_0() {
        return win_2_0;
    }

    public void setWin_2_0(String win_2_0) {
        this.win_2_0 = win_2_0;
    }

    public String getWin_2_1() {
        return win_2_1;
    }

    public void setWin_2_1(String win_2_1) {
        this.win_2_1 = win_2_1;
    }

    public String getWin_3_0() {
        return win_3_0;
    }

    public void setWin_3_0(String win_3_0) {
        this.win_3_0 = win_3_0;
    }

    public String getWin_3_1() {
        return win_3_1;
    }

    public void setWin_3_1(String win_3_1) {
        this.win_3_1 = win_3_1;
    }

    public String getWin_3_2() {
        return win_3_2;
    }

    public void setWin_3_2(String win_3_2) {
        this.win_3_2 = win_3_2;
    }

    public String getWin_4_0() {
        return win_4_0;
    }

    public void setWin_4_0(String win_4_0) {
        this.win_4_0 = win_4_0;
    }

    public String getWin_4_1() {
        return win_4_1;
    }

    public void setWin_4_1(String win_4_1) {
        this.win_4_1 = win_4_1;
    }

    public String getWin_4_2() {
        return win_4_2;
    }

    public void setWin_4_2(String win_4_2) {
        this.win_4_2 = win_4_2;
    }

    public String getWin_5_0() {
        return win_5_0;
    }

    public void setWin_5_0(String win_5_0) {
        this.win_5_0 = win_5_0;
    }

    public String getWin_5_1() {
        return win_5_1;
    }

    public void setWin_5_1(String win_5_1) {
        this.win_5_1 = win_5_1;
    }

    public String getWin_5_2() {
        return win_5_2;
    }

    public void setWin_5_2(String win_5_2) {
        this.win_5_2 = win_5_2;
    }

    public String getWin_more() {
        return win_more;
    }

    public void setWin_more(String win_more) {
        this.win_more = win_more;
    }

    public String getDraw_0_0() {
        return draw_0_0;
    }

    public void setDraw_0_0(String draw_0_0) {
        this.draw_0_0 = draw_0_0;
    }

    public String getDraw_1_1() {
        return draw_1_1;
    }

    public void setDraw_1_1(String draw_1_1) {
        this.draw_1_1 = draw_1_1;
    }

    public String getDraw_2_2() {
        return draw_2_2;
    }

    public void setDraw_2_2(String draw_2_2) {
        this.draw_2_2 = draw_2_2;
    }

    public String getDraw_3_3() {
        return draw_3_3;
    }

    public void setDraw_3_3(String draw_3_3) {
        this.draw_3_3 = draw_3_3;
    }

    public String getDraw_more() {
        return draw_more;
    }

    public void setDraw_more(String draw_more) {
        this.draw_more = draw_more;
    }

    public String getLoss_0_1() {
        return loss_0_1;
    }

    public void setLoss_0_1(String loss_0_1) {
        this.loss_0_1 = loss_0_1;
    }

    public String getLoss_0_2() {
        return loss_0_2;
    }

    public void setLoss_0_2(String loss_0_2) {
        this.loss_0_2 = loss_0_2;
    }

    public String getLoss_1_2() {
        return loss_1_2;
    }

    public void setLoss_1_2(String loss_1_2) {
        this.loss_1_2 = loss_1_2;
    }

    public String getLoss_0_3() {
        return loss_0_3;
    }

    public void setLoss_0_3(String loss_0_3) {
        this.loss_0_3 = loss_0_3;
    }

    public String getLoss_1_3() {
        return loss_1_3;
    }

    public void setLoss_1_3(String loss_1_3) {
        this.loss_1_3 = loss_1_3;
    }

    public String getLoss_2_3() {
        return loss_2_3;
    }

    public void setLoss_2_3(String loss_2_3) {
        this.loss_2_3 = loss_2_3;
    }

    public String getLoss_0_4() {
        return loss_0_4;
    }

    public void setLoss_0_4(String loss_0_4) {
        this.loss_0_4 = loss_0_4;
    }

    public String getLoss_1_4() {
        return loss_1_4;
    }

    public void setLoss_1_4(String loss_1_4) {
        this.loss_1_4 = loss_1_4;
    }

    public String getLoss_2_4() {
        return loss_2_4;
    }

    public void setLoss_2_4(String loss_2_4) {
        this.loss_2_4 = loss_2_4;
    }

    public String getLoss_0_5() {
        return loss_0_5;
    }

    public void setLoss_0_5(String loss_0_5) {
        this.loss_0_5 = loss_0_5;
    }

    public String getLoss_1_5() {
        return loss_1_5;
    }

    public void setLoss_1_5(String loss_1_5) {
        this.loss_1_5 = loss_1_5;
    }

    public String getLoss_2_5() {
        return loss_2_5;
    }

    public void setLoss_2_5(String loss_2_5) {
        this.loss_2_5 = loss_2_5;
    }

    public String getLoss_more() {
        return loss_more;
    }

    public void setLoss_more(String loss_more) {
        this.loss_more = loss_more;
    }
}
