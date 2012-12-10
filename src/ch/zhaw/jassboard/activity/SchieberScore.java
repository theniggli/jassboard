package ch.zhaw.jassboard.activity;

import java.io.Serializable;

/*
TODO: doc
 */
public class SchieberScore implements Serializable {
    public int count_100 = 0;
    public int count_20 = 0;
    public int count_50 = 0;
    public int rest = 0;

    public int score = 0;

    public SchieberScore(int scoreTotal, int score_20, int score_50, int score_100) {
        this.score = scoreTotal;
        this.count_20 = score_20;
        this.count_50 = score_50;
        this.count_100 = score_100;
    }

    public int getScore() {
        return score;
    }

    public void setPoints(int scoreTotal, int multi){
        this.score = this.score + (scoreTotal*multi);
        this.count_100 = calc100(scoreTotal);
        this.count_50 = calc50(scoreTotal);
        this.count_20 = calc20(scoreTotal);
        this.rest = calcRest(scoreTotal);

    }

    public int calc20(int scoreTotal) {
        int tmp = scoreTotal % 50;
        return tmp / 20;
    }

    public int calc50(int scoreTotal) {
        int tmp = scoreTotal % 100;
        return tmp / 50;
    }

    public int calc100(int scoreTotal) {
        return scoreTotal / 100;
    }

    public int calcRest(int scoreTotal) {
        int tmp = scoreTotal % 50;
        return tmp % 20;
    }

}