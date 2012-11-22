package ch.zhaw.jassboard.persist;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 28.10.12
 * Time: 19:56
 * To change this template use File | Settings | File Templates.
 */
public class Team {
    @DatabaseField(generatedId = true)
    private Integer teamID;
    @DatabaseField(index = true)
    private String teamName;

    //Statistics
    @DatabaseField
    private Integer gamesPlayedSchieber;
    @DatabaseField
    private Integer gamesPlayedCoiffeur;
    @DatabaseField
    private Integer gamesPlayedDifferenzler;
    @DatabaseField
    private Integer gamesWonSchieber;
    @DatabaseField
    private Integer gamesWonCoiffeur;
    @DatabaseField
    private Integer gamesWonDifferenzler;
    @DatabaseField
    private Integer roundsPlayedSchieber;
    @DatabaseField
    private Integer roundsPlayedCoiffeur;
    @DatabaseField
    private Integer roundsPlayedDifferenzler;
    @DatabaseField
    private Integer roundsWonSchieber;
    @DatabaseField
    private Integer roundsWonCoiffeur;
    @DatabaseField
    private Integer roundsWonDifferenzler;
    @DatabaseField
    private Integer pointsMadeSchieber;
    @DatabaseField
    private Integer pointsMadeCoiffeur;
    @DatabaseField
    private Integer pointsMadeDifferenzler;
    @DatabaseField
    private Integer pointsMaxSchieber;
    @DatabaseField
    private Integer pointsMaxCoiffeur;
    @DatabaseField
    private Integer pointsMaxDifferenzler;

    public Team() {
    }

    public Team(String Name) {
        this.teamName = Name;
    }

    public Team(Integer id, String Name) {
        this.teamID = id;
        this.teamName = Name;
    }

    public Team(Integer id, String Name, Integer GPS, Integer GWS) {
        this.teamID = id;
        this.teamName = Name;

        this.gamesPlayedSchieber = GPS;
        //  this.gamesPlayedCoiffeur = GPC;
        //  this.gamesPlayedDifferenzler = GPD;
        this.gamesWonSchieber = GWS;
        //  this.gamesWonCoiffeur = GWC;
        //  this.gamesWonDifferenzler = GWD;
    }

    public Integer getGamesWonCoiffeur() {
        return gamesWonCoiffeur;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public String getTeamName() {
        return teamName;
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

    public Integer getGamesWonDifferenzler() {
        return gamesWonDifferenzler;
    }

    public Integer getRoundsPlayedSchieber() {
        return roundsPlayedSchieber;
    }

    public Integer getRoundsPlayedCoiffeur() {
        return roundsPlayedCoiffeur;
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

    public Integer getPointsMaxDifferenzler() {
        return pointsMaxDifferenzler;
    }
}
