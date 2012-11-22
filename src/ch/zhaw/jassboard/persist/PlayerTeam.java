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
    public Integer playerID;
    @DatabaseField
    private Integer teamID;

    public PlayerTeam() {
    }

    public PlayerTeam(Integer playerID,Integer teamID) {
        this.playerID = playerID;
        this.teamID = teamID;
    }

}