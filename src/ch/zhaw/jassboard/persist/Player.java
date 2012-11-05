package ch.zhaw.jassboard.persist;

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

    //Statistics
    private Integer gamesPlayedSchieber;
    private Integer gamesPlayedCoiffeur;
    private Integer gamesPlayedDifferenzler;
    private Integer gamesWonSchieber;
    private Integer gamesWonCoiffeur;
    private Integer gamesWonDifferenzler;


    public Player(Integer id, String Name) {
        this.playerID = id;
        this.playerName = Name;
    }

    public Integer getGamesPlayedSchieber() {
        return gamesPlayedSchieber;
    }

    public Integer getGamesPlayedCoiffeur() {
        return gamesPlayedCoiffeur;
    }

    public Integer getGamesPlayedDifferenzler() {
        return gamesPlayedDifferenzler;
    }

    public Integer getGamesWonSchieber() {
        return gamesWonSchieber;
    }

    public Integer getGamesWonCoiffeur() {
        return gamesWonCoiffeur;
    }

    public Integer getGamesWonDifferenzler() {
        return gamesWonDifferenzler;
    }

    public Player(Integer id, String Name, Integer GPS, Integer GPC, Integer GPD, Integer GWS, Integer GWC, Integer GWD) {
        this.playerID = id;
        this.playerName = Name;
        this.gamesPlayedSchieber = GPS;
        this.gamesPlayedCoiffeur = GPC;
        this.gamesPlayedDifferenzler = GPD;
        this.gamesWonSchieber = GWS;
        this.gamesWonCoiffeur = GWC;
        this.gamesWonDifferenzler = GWD;
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
