package ch.zhaw.jassboard.activity;

import java.io.Serializable;

/**
 * SchieberScore class to view and update the different needed scores
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */
public class SchieberScore implements Serializable {
    public int count_100 = 0;
    public int count_20 = 0;
    public int count_50 = 0;
    public int rest = 0;
    public int score = 0;

    /*
    Constructor: initialize with 0
     */
    public SchieberScore(int scoreTotal, int score_20, int score_50, int score_100) {
        this.score = scoreTotal;
        this.count_20 = score_20;
        this.count_50 = score_50;
        this.count_100 = score_100;
    }
    
    public int getScore() {
        return score;
    }
    
    /*
    public setter to update the different score types
     */
    public void setPoints(int scoreTotal){
        this.count_100 = calc100(scoreTotal);
        this.count_50 = calc50(scoreTotal);
        this.count_20 = calc20(scoreTotal);
        this.rest = calcRest(scoreTotal);

    }

    /*
    Divide the total score by 50 and the leftover by 20
     */
    public int calc20(int scoreTotal) {
        int tmp = scoreTotal % 50;
        return tmp / 20;
    }

    /*
    Divide the total score by 100 and the leftover by 50
     */
    public int calc50(int scoreTotal) {
        int tmp = scoreTotal % 100;
        return tmp / 50;
    }

    /*
    Divide total score by 100
     */
    public int calc100(int scoreTotal) {
        return scoreTotal / 100;
    }

    /*
    Divide the total score by 50 and the leftover by 20
    */
    public int calcRest(int scoreTotal) {
        int tmp = scoreTotal % 50;
        return tmp % 20;
    }

}