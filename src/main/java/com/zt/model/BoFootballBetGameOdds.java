/**
 * CFR,2018-08-21
 * BoFootballBetGameOdds
 * 竞彩足球受注场次与各种赔率的数据结构
 *
 * */

package com.zt.model;

public class BoFootballBetGameOdds {
    private BoFootballBetGame game;         // 受注场次，如无数据，此项保持为 null
    private BoFootballOddsSpf oddsSpf;      // 本场比赛胜平负/让球胜平负的赔率，如无数据，此项保持为 null
    private BoFootballOddsJqs oddsJqs;      // 本场比赛进球数的赔率，如无数据，此项保持为 null
    private BoFootballOddsBf oddsBf;        // 本场比赛比分的赔率，如无数据，此项保持为 null
    private BoFootballOddsBqc oddsBqc;      // 本场比赛半全场的赔率，如无数据，此项保持为 null


    public BoFootballBetGameOdds(BoFootballBetGame game, BoFootballOddsSpf oddsSpf
            , BoFootballOddsJqs oddsJqs, BoFootballOddsBf oddsBf, BoFootballOddsBqc oddsBqc)
    {
        if (game != null)
            this.game = new BoFootballBetGame(game);

        if (oddsSpf != null)
            this.oddsSpf = new BoFootballOddsSpf(oddsSpf);

        if (oddsJqs != null)
            this.oddsJqs = new BoFootballOddsJqs(oddsJqs);

        if (oddsBf != null)
            this.oddsBf = new BoFootballOddsBf(oddsBf);

        if (oddsBqc != null)
            this.oddsBqc = new BoFootballOddsBqc(oddsBqc);

    }

    public BoFootballBetGame getGame() {
        return game;
    }

    public void setGame(BoFootballBetGame game) {
        this.game = game;
    }

    public BoFootballOddsSpf getOddsSpf() {
        return oddsSpf;
    }

    public void setOddsSpf(BoFootballOddsSpf oddsSpf) {
        this.oddsSpf = oddsSpf;
    }

    public BoFootballOddsJqs getOddsJqs() {
        return oddsJqs;
    }

    public void setOddsJqs(BoFootballOddsJqs oddsJqs) {
        this.oddsJqs = oddsJqs;
    }

    public BoFootballOddsBf getOddsBf() {
        return oddsBf;
    }

    public void setOddsBf(BoFootballOddsBf oddsBf) {
        this.oddsBf = oddsBf;
    }

    public BoFootballOddsBqc getOddsBqc() {
        return oddsBqc;
    }

    public void setOddsBqc(BoFootballOddsBqc oddsBqc) {
        this.oddsBqc = oddsBqc;
    }
}
