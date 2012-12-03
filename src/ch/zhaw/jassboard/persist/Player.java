package ch.zhaw.jassboard.persist;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created with IntelliJ IDEA.
 * User: nigglrog
 * Date: 10/23/12
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    @DatabaseField(generatedId = true)
    public Integer playerID;
    @DatabaseField
    private String playerName;

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

    public Player() {

    }

    public Player(String Name) {
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

    public Integer getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
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

    public Player(int playerID, String playerName) {
        this.playerID = playerID;
        this.playerName = playerName;
    }

    //Getters for statistics
    public int getGamesPlayed() {
        return gamesPlayedSchieber + gamesPlayedCoiffeur + gamesPlayedDifferenzler;
    }

    public int getGamesWon() {
        return gamesWonSchieber + gamesWonCoiffeur + gamesWonDifferenzler;
    }

    public int getRoundsPlayed() {
        return roundsPlayedSchieber + roundsPlayedCoiffeur + roundsPlayedDifferenzler;
    }

    public int getRoundsWon() {
        return roundsWonSchieber + roundsWonCoiffeur + roundsWonDifferenzler;
    }

    public int getPointsMax() {
        return pointsMaxSchieber + pointsMaxCoiffeur + pointsMaxDifferenzler;
    }

    public int getPointsMade() {
        return pointsMadeSchieber + pointsMadeCoiffeur + pointsMadeDifferenzler;
    }

    public int getGamesWonPercent() {
        return (100 * (gamesWonSchieber + gamesWonCoiffeur + gamesWonDifferenzler) / (gamesPlayedSchieber + gamesPlayedCoiffeur + gamesPlayedDifferenzler));
    }

    public int getRoundsWonPercent() {
        return (100 * (roundsWonSchieber + roundsWonCoiffeur + roundsWonDifferenzler) / (roundsPlayedSchieber + roundsPlayedCoiffeur + roundsPlayedDifferenzler));
    }

    public int getPointsMadePercent() {
        return (100 * (pointsMadeSchieber + pointsMadeCoiffeur + pointsMadeDifferenzler) / (pointsMaxSchieber + pointsMaxCoiffeur + pointsMaxDifferenzler));
    }

    public int getSchieberGamesWonPercent() {
        return (100 * gamesWonSchieber / gamesPlayedSchieber);
    }

    public int getSchieberRoundsWonPercent() {
        return (100 * roundsWonSchieber / roundsPlayedSchieber);
    }

    public int getSchieberPointsMadePercent() {
        return (100 * pointsMadeSchieber / pointsMaxSchieber);
    }

    public int getCoiffeurGamesWonPercent() {
        return (100 * gamesWonCoiffeur / gamesPlayedCoiffeur);
    }

    public int getCoiffeurRoundsWonPercent() {
        return (100 * roundsWonCoiffeur / roundsPlayedCoiffeur);
    }

    public int getCoiffeurPointsMadePercent() {
        return (100 * pointsMadeCoiffeur / pointsMaxCoiffeur);
    }

    public int getDifferenzlerGamesWonPercent() {
        return (100 * gamesWonDifferenzler / gamesPlayedDifferenzler);
    }

    public int getDifferenzlerRoundsWonPercent() {
        return (100 * roundsWonDifferenzler / roundsPlayedDifferenzler);
    }

    public int getDifferenzlerPointsMadePercent() {
        return (100 * pointsMadeDifferenzler / pointsMaxDifferenzler);
    }
}
