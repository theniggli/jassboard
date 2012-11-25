package ch.zhaw.jassboard.persist;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 22.11.12
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */
public class PlayerTeam {
    @DatabaseField(generatedId = true)
    public Integer PlayerTeamID;
    @DatabaseField
    private Integer playerID;      //used in ViewPlayerList
    @DatabaseField
    private Integer teamID;      //used in ViewTeamList,ViewTeam

    public PlayerTeam() {
    }

    public PlayerTeam(Integer playerID, Integer teamID) {
        this.playerID = playerID;
        this.teamID = teamID;
    }

    public Integer getPlayerTeamID() {
        return PlayerTeamID;
    }

    public Integer getPlayerID() {
        return playerID;
    }

    public Integer getTeamID() {
        return teamID;
    }
}
