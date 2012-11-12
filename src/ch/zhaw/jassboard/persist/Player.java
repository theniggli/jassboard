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
    private Integer roundsPlayedSchieber;
    private Integer roundsPlayedCoiffeur;
    private Integer roundsPlayedDifferenzler;
    private Integer roundsWonSchieber;
    private Integer roundsWonCoiffeur;
    private Integer roundsWonDifferenzler;
    private Integer pointsMadeSchieber;
    private Integer pointsMadeCoiffeur;
    private Integer pointsMadeDifferenzler;
    private Integer pointsMaxSchieber;
    private Integer pointsMaxCoiffeur;
    private Integer pointsMaxDifferenzler;

    public Player(Integer id, String Name) {
        this.playerID = id;
        this.playerName = Name;
        this.gamesPlayedSchieber = 0;
        this.gamesPlayedCoiffeur = 0;
        this.gamesPlayedDifferenzler = 0;
        this.gamesWonSchieber = 0;
        this.gamesWonCoiffeur = 0;
        this.gamesWonDifferenzler = 0;
        this.roundsPlayedSchieber = 0;
        this.roundsPlayedCoiffeur = 0;
        this.roundsPlayedDifferenzler = 0;
        this.roundsWonSchieber = 0;
        this.roundsWonCoiffeur = 0;
        this.roundsWonDifferenzler = 0;
        this.pointsMadeSchieber = 0;
        this.pointsMadeCoiffeur = 0;
        this.pointsMadeDifferenzler = 0;
        this.pointsMaxSchieber = 0;
        this.pointsMaxCoiffeur = 0;
        this.pointsMaxDifferenzler = 0;
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

    public Player(Integer id, String Name, Integer GPS, Integer GPC, Integer GPD, Integer GWS, Integer GWC, Integer GWD, Integer RPS, Integer RPC, Integer RPD, Integer RWS, Integer RWC, Integer RWD,Integer PMS, Integer PMC, Integer PMD, Integer PMaxS, Integer PMaxC, Integer PMaxD) {
        this.playerID = id;
        this.playerName = Name;
        this.gamesPlayedSchieber = GPS;
        this.gamesPlayedCoiffeur = GPC;
        this.gamesPlayedDifferenzler = GPD;
        this.gamesWonSchieber = GWS;
        this.gamesWonCoiffeur = GWC;
        this.gamesWonDifferenzler = GWD;
        this.roundsPlayedSchieber = RPS;
        this.roundsPlayedCoiffeur = RPC;
        this.roundsPlayedDifferenzler = RPD;
        this.roundsWonSchieber = RWS;
        this.roundsWonCoiffeur = RWC;
        this.roundsWonDifferenzler = RWD;
        this.pointsMadeSchieber = PMS;
        this.pointsMadeCoiffeur = PMC;
        this.pointsMadeDifferenzler = PMD;
        this.pointsMaxSchieber = PMaxS;
        this.pointsMaxCoiffeur = PMaxC;
        this.pointsMaxDifferenzler = PMaxD;
    }

    public Integer getRoundsPlayedSchieber() {
        return roundsPlayedSchieber;
    }

    public Integer getRoundsPlayedCoiffeur() {
        return roundsPlayedCoiffeur;
    }

    public Integer getPointsMaxDifferenzler() {
        return pointsMaxDifferenzler;
    }

    public Integer getPointsMadeSchieber() {
        return pointsMadeSchieber;
    }

    public Integer getPointsMadeCoiffeur() {
        return pointsMadeCoiffeur;
    }

    public Integer getPointsMadeDifferenzler() {
        return pointsMadeDifferenzler;
    }

    public Integer getPointsMaxSchieber() {
        return pointsMaxSchieber;
    }

    public Integer getPointsMaxCoiffeur() {
        return pointsMaxCoiffeur;
    }

    public Integer getRoundsPlayedDifferenzler() {
        return roundsPlayedDifferenzler;

    }

    public Integer getRoundsWonSchieber() {
        return roundsWonSchieber;
    }

    public Integer getRoundsWonCoiffeur() {
        return roundsWonCoiffeur;
    }

    public Integer getRoundsWonDifferenzler() {
        return roundsWonDifferenzler;
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

    public String getName() {
        return playerName;
    }

    public Integer getId() {
        return playerID;
    }
}
