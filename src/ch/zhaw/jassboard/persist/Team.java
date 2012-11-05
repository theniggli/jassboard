package ch.zhaw.jassboard.persist;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 28.10.12
 * Time: 19:56
 * To change this template use File | Settings | File Templates.
 */
public class Team {
    private Integer teamID;
    private String teamName;

    //Statistics
    private Integer gamesPlayedSchieber;
    private Integer gamesPlayedCoiffeur;
    private Integer gamesPlayedDifferenzler;
    private Integer gamesWonSchieber;
    private Integer gamesWonCoiffeur;
    private Integer gamesWonDifferenzler;

    public Team(Integer id, String Name) {
        this.teamID = id;
        this.teamName = Name;
    }

    public Team(Integer id, String Name, Integer GPS, Integer GPC, Integer GPD, Integer GWS, Integer GWC, Integer GWD) {
        this.teamID = id;
        this.teamName = Name;
        this.gamesPlayedSchieber = GPS;
        this.gamesPlayedCoiffeur = GPC;
        this.gamesPlayedDifferenzler = GPD;
        this.gamesWonSchieber = GWS;
        this.gamesWonCoiffeur = GWC;
        this.gamesWonDifferenzler = GWD;
    }

    public void createPlayer() {

    }

    public void savePlayer() {

    }

    public String getName() {
        return teamName;
    }

    public Integer getId() {
        return teamID;
    }

}
