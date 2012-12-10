package ch.zhaw.jassboard.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
import ch.zhaw.jassboard.persist.Team;

/**
 * Viewclass TeamView
 * Shows infos about the Team
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */
public class TeamView extends LinearLayout {
    private TextView nameTextView, idTextView;

    private int teamID;
    private String teamName;

    public TeamView(Context context, Team team) {
        super(context);
        this.setOrientation(VERTICAL);
        nameTextView = new TextView(context);
        idTextView = new TextView(context);

        teamName = team.getTeamName();
        nameTextView.setText(context.getString(ch.zhaw.R.string.teamname) + ": " + teamName);
        nameTextView.setTextSize(19);
        nameTextView.setTextColor(Color.GRAY);
        nameTextView.setTypeface(Typeface.SANS_SERIF);

        teamID = team.getTeamID();
        idTextView.setText(context.getString(ch.zhaw.R.string.id) + ": " + teamID);
        idTextView.setTextSize(14);
        idTextView.setTextColor(Color.GRAY);
        idTextView.setTypeface(Typeface.SANS_SERIF);

        addView(nameTextView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(idTextView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        // Not Tested
        TextView gamesWonPercent = new TextView(context);
        gamesWonPercent.setText(context.getString(ch.zhaw.R.string.gameswon) + ": " + team.getGamesWonPercent() + " ( " + team.getGamesWon() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getGamesPlayed() + " )");
        gamesWonPercent.setTextSize(14);
        gamesWonPercent.setTextColor(Color.GRAY);
        gamesWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(gamesWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView roundsWonPercent = new TextView(context);
        roundsWonPercent.setText(context.getString(ch.zhaw.R.string.roundswon) + ": " + team.getRoundsWonPercent() + " ( " + team.getRoundsWon() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getRoundsPlayed() + " )");
        roundsWonPercent.setTextSize(14);
        roundsWonPercent.setTextColor(Color.GRAY);
        roundsWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(roundsWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView pointsMadePercent = new TextView(context);
        pointsMadePercent.setText(context.getString(ch.zhaw.R.string.pointsmade) + ": " + team.getPointsMadePercent() + " ( " + team.getPointsMax() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getPointsMax() + " )");
        pointsMadePercent.setTextSize(14);
        pointsMadePercent.setTextColor(Color.GRAY);
        pointsMadePercent.setTypeface(Typeface.SANS_SERIF);
        addView(pointsMadePercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //Schieber
        TextView schieber = new TextView(context);
        schieber.setText(context.getString(ch.zhaw.R.string.schieber));
        schieber.setTextSize(14);
        schieber.setTextColor(Color.GREEN);
        schieber.setTypeface(Typeface.SANS_SERIF);
        addView(schieber, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView gamesSchieberWonPercent = new TextView(context);
        gamesSchieberWonPercent.setText(context.getString(ch.zhaw.R.string.gameswon) + ": " + team.getSchieberGamesWonPercent() + " ( " + team.getGamesWonSchieber() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getGamesPlayedSchieber() + " )");
        gamesSchieberWonPercent.setTextSize(14);
        gamesSchieberWonPercent.setTextColor(Color.GRAY);
        gamesSchieberWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(gamesSchieberWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView roundsSchieberWonPercent = new TextView(context);
        roundsSchieberWonPercent.setText(context.getString(ch.zhaw.R.string.roundswon) + ": " + team.getSchieberRoundsWonPercent() + " ( " + team.getRoundsWonSchieber() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getRoundsPlayedSchieber() + " )");
        roundsSchieberWonPercent.setTextSize(14);
        roundsSchieberWonPercent.setTextColor(Color.GRAY);
        roundsSchieberWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(roundsSchieberWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView pointsSchieberMadePercent = new TextView(context);
        pointsSchieberMadePercent.setText(context.getString(ch.zhaw.R.string.pointsmade) + ": " + team.getSchieberPointsMadePercent() + " ( " + team.getPointsMadeSchieber() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getPointsMaxSchieber() + " )");
        pointsSchieberMadePercent.setTextSize(14);
        pointsSchieberMadePercent.setTextColor(Color.GRAY);
        pointsSchieberMadePercent.setTypeface(Typeface.SANS_SERIF);
        addView(pointsSchieberMadePercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //Coiffeur
        TextView coiffeur = new TextView(context);
        coiffeur.setText(context.getString(ch.zhaw.R.string.coiffeur));
        coiffeur.setTextSize(14);
        coiffeur.setTextColor(Color.GREEN);
        coiffeur.setTypeface(Typeface.SANS_SERIF);
        addView(coiffeur, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView gamesCoiffeurWonPercent = new TextView(context);
        gamesCoiffeurWonPercent.setText(context.getString(ch.zhaw.R.string.gameswon) + ": " + team.getCoiffeurGamesWonPercent() + " ( " + team.getGamesWonCoiffeur() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getGamesPlayedCoiffeur() + " )");
        gamesCoiffeurWonPercent.setTextSize(14);
        gamesCoiffeurWonPercent.setTextColor(Color.GRAY);
        gamesCoiffeurWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(gamesCoiffeurWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView roundsCoiffeurWonPercent = new TextView(context);
        roundsCoiffeurWonPercent.setText(context.getString(ch.zhaw.R.string.roundswon) + ": " + team.getCoiffeurRoundsWonPercent() + " ( " + team.getRoundsWonCoiffeur() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getRoundsPlayedCoiffeur() + " )");
        roundsCoiffeurWonPercent.setTextSize(14);
        roundsCoiffeurWonPercent.setTextColor(Color.GRAY);
        roundsCoiffeurWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(roundsCoiffeurWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView pointsCoiffeurMadePercent = new TextView(context);
        pointsCoiffeurMadePercent.setText(context.getString(ch.zhaw.R.string.pointsmade) + ": " + team.getCoiffeurPointsMadePercent() + " ( " + team.getPointsMadeCoiffeur() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getPointsMaxCoiffeur() + " )");
        pointsCoiffeurMadePercent.setTextSize(14);
        pointsCoiffeurMadePercent.setTextColor(Color.GRAY);
        pointsCoiffeurMadePercent.setTypeface(Typeface.SANS_SERIF);
        addView(pointsCoiffeurMadePercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //Differenzler
        TextView differenzler = new TextView(context);
        differenzler.setText(context.getString(ch.zhaw.R.string.differenzler));
        differenzler.setTextSize(14);
        differenzler.setTextColor(Color.GREEN);
        differenzler.setTypeface(Typeface.SANS_SERIF);
        addView(differenzler, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView gamesDifferenzlerWonPercent = new TextView(context);
        gamesDifferenzlerWonPercent.setText(context.getString(ch.zhaw.R.string.gameswon) + ": " + team.getDifferenzlerGamesWonPercent() + " ( " + team.getGamesWonDifferenzler() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getGamesPlayedDifferenzler() + " )");
        gamesDifferenzlerWonPercent.setTextSize(14);
        gamesDifferenzlerWonPercent.setTextColor(Color.GRAY);
        gamesDifferenzlerWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(gamesDifferenzlerWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView roundsDifferenzlerWonPercent = new TextView(context);
        roundsDifferenzlerWonPercent.setText(context.getString(ch.zhaw.R.string.roundswon) + ": " + team.getDifferenzlerRoundsWonPercent() + " ( " + team.getRoundsWonDifferenzler() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getRoundsPlayedDifferenzler() + " )");
        roundsDifferenzlerWonPercent.setTextSize(14);
        roundsDifferenzlerWonPercent.setTextColor(Color.GRAY);
        roundsDifferenzlerWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(roundsDifferenzlerWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView pointsDifferenzlerMadePercent = new TextView(context);
        pointsDifferenzlerMadePercent.setText(context.getString(ch.zhaw.R.string.pointsmade) + ": " + team.getDifferenzlerPointsMadePercent() + " ( " + team.getPointsMadeDifferenzler() + " " + context.getString(ch.zhaw.R.string.off) + " " + team.getPointsMaxDifferenzler() + " )");
        pointsDifferenzlerMadePercent.setTextSize(14);
        pointsDifferenzlerMadePercent.setTextColor(Color.GRAY);
        pointsDifferenzlerMadePercent.setTypeface(Typeface.SANS_SERIF);
        addView(pointsDifferenzlerMadePercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }
}
