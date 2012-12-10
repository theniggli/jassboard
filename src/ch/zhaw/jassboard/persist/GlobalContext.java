package ch.zhaw.jassboard.persist;

import android.app.Application;

/**
 * Created with IntelliJ IDEA.
 * User: TsSchleppBox
 * Date: 10.12.12
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
public class GlobalContext extends Application {
    private int result;
    private String team;
    private int multiplier;

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }


    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    public void setResult(int result){
        this.result = result;
    }

    public int getResult(){
        return this.result;
    }
}
