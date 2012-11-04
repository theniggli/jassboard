package ch.zhaw;

/**
 * Created with IntelliJ IDEA.
 * User: nigglrog
 * Date: 10/23/12
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private Integer playerID;
    private String playerName;


    public Player(Integer id, String Name) {
        this.playerID = id;
        this.playerName = Name;

    }

    public Player() {

    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void createPlayer() {

    }

    public void savePlayer() {

    }

    public String getName() {
        return playerName;
    }

    public Integer getId() {
        return playerID;
    }

}
