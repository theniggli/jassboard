package ch.zhaw.jassboard.persist;

import com.j256.ormlite.field.DatabaseField;

/**
 * Teamclass
 * Won't explain getters and setters
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
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

    public Team(Integer id, String Name) {
        this.teamID = id;
        this.teamName = Name;
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

    public Integer getGamesWonCoiffeur() {
        return gamesWonCoiffeur;
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
        if ((gamesPlayedSchieber + gamesPlayedCoiffeur + gamesPlayedDifferenzler) != 0) {
            return (100 * (gamesWonSchieber + gamesWonCoiffeur + gamesWonDifferenzler) / (gamesPlayedSchieber + gamesPlayedCoiffeur + gamesPlayedDifferenzler));
        } else {
            return 0;
        }
    }

    public int getRoundsWonPercent() {
        if ((roundsPlayedSchieber + roundsPlayedCoiffeur + roundsPlayedDifferenzler) != 0) {
            return (100 * (roundsWonSchieber + roundsWonCoiffeur + roundsWonDifferenzler) / (roundsPlayedSchieber + roundsPlayedCoiffeur + roundsPlayedDifferenzler));
        } else {
            return 0;
        }
    }

    public int getPointsMadePercent() {
        if ((pointsMaxSchieber + pointsMaxCoiffeur + pointsMaxDifferenzler) != 0) {
            return (100 * (pointsMadeSchieber + pointsMadeCoiffeur + pointsMadeDifferenzler) / (pointsMaxSchieber + pointsMaxCoiffeur + pointsMaxDifferenzler));
        } else {
            return 0;
        }
    }

    public int getSchieberGamesWonPercent() {
        if (gamesPlayedSchieber != 0) {
            return (100 * gamesWonSchieber / gamesPlayedSchieber);
        } else {
            return 0;
        }
    }

    public int getSchieberRoundsWonPercent() {
        if (roundsPlayedSchieber != 0) {
            return (100 * roundsWonSchieber / roundsPlayedSchieber);
        } else {
            return 0;
        }
    }

    public int getSchieberPointsMadePercent() {
        if (pointsMaxSchieber != 0) {
            return (100 * pointsMadeSchieber / pointsMaxSchieber);
        } else {
            return 0;
        }
    }

    public int getCoiffeurGamesWonPercent() {
        if (gamesPlayedCoiffeur != 0) {
            return (100 * gamesWonCoiffeur / gamesPlayedCoiffeur);
        } else {
            return 0;
        }
    }

    public int getCoiffeurRoundsWonPercent() {
        if (roundsPlayedCoiffeur != 0) {
            return (100 * roundsWonCoiffeur / roundsPlayedCoiffeur);
        } else {
            return 0;
        }
    }

    public int getCoiffeurPointsMadePercent() {
        if (pointsMaxCoiffeur != 0) {
            return (100 * pointsMadeCoiffeur / pointsMaxCoiffeur);
        } else {
            return 0;
        }
    }

    public int getDifferenzlerGamesWonPercent() {
        if (gamesPlayedDifferenzler != 0) {
            return (100 * gamesWonDifferenzler / gamesPlayedDifferenzler);
        } else {
            return 0;
        }
    }

    public int getDifferenzlerRoundsWonPercent() {
        if (roundsPlayedDifferenzler != 0) {
            return (100 * roundsWonDifferenzler / roundsPlayedDifferenzler);
        } else {
            return 0;
        }
    }

    public int getDifferenzlerPointsMadePercent() {
        if (pointsMaxDifferenzler != 0) {
            return (100 * pointsMadeDifferenzler / pointsMaxDifferenzler);
        } else {
            return 0;
        }
    }

    public void setGamesPlayedSchieber(Integer gamesPlayedSchieber) {
        this.gamesPlayedSchieber = gamesPlayedSchieber;
    }

    public void setGamesWonSchieber(Integer gamesWonSchieber) {
        this.gamesWonSchieber = gamesWonSchieber;
    }

    public void setRoundsPlayedSchieber(Integer roundsPlayedSchieber) {
        this.roundsPlayedSchieber = roundsPlayedSchieber;
    }

    public void setRoundsWonSchieber(Integer roundsWonSchieber) {
        this.roundsWonSchieber = roundsWonSchieber;
    }

    public void setPointsMadeSchieber(Integer pointsMadeSchieber) {
        this.pointsMadeSchieber = pointsMadeSchieber;
    }

    public void setPointsMaxSchieber(Integer pointsMaxSchieber) {
        this.pointsMaxSchieber = pointsMaxSchieber;
    }
}
