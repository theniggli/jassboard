package ch.zhaw.jassboard.view;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
import ch.zhaw.jassboard.persist.Player;

import java.util.jar.Attributes;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 28.10.12
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
public class PlayerView extends LinearLayout {
    private int playerID;
    private String playerName;

    public PlayerView(Context context, Player player) {
        super(context);
        this.setOrientation(VERTICAL);

        TextView nameTextView = new TextView(context);
        playerName = player.getPlayerName();
        nameTextView.setText(ch.zhaw.R.string.blankplayername + ": " + playerName);
        nameTextView.setTextSize(19);
        nameTextView.setTextColor(Color.GRAY);
        nameTextView.setTypeface(Typeface.SANS_SERIF);
        addView(nameTextView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView idTextView = new TextView(context);
        playerID = player.getPlayerID();
        idTextView.setText(ch.zhaw.R.string.id + ": " + playerID);
        idTextView.setTextSize(14);
        idTextView.setTextColor(Color.GRAY);
        idTextView.setTypeface(Typeface.SANS_SERIF);
        addView(idTextView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //some Player Statistics
        TextView gamesWonPercent = new TextView(context);
        gamesWonPercent.setText(ch.zhaw.R.string.gameswon + ": " + player.getGamesWonPercent() + "(" + player.getGamesWon() + ch.zhaw.R.string.off + player.getGamesPlayed() + ")");
        gamesWonPercent.setTextSize(14);
        gamesWonPercent.setTextColor(Color.GRAY);
        gamesWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(gamesWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView roundsWonPercent = new TextView(context);
        roundsWonPercent.setText(ch.zhaw.R.string.roundswon + ": " + player.getRoundsWonPercent() + "(" + player.getRoundsWon() + ch.zhaw.R.string.off + player.getRoundsPlayed() + ")");
        roundsWonPercent.setTextSize(14);
        roundsWonPercent.setTextColor(Color.GRAY);
        roundsWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(roundsWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView pointsMadePercent = new TextView(context);
        pointsMadePercent.setText(ch.zhaw.R.string.pointsmade + ": " + player.getPointsMadePercent() + "(" + player.getPointsMax() + ch.zhaw.R.string.off + player.getPointsMax() + ")");
        pointsMadePercent.setTextSize(14);
        pointsMadePercent.setTextColor(Color.GRAY);
        pointsMadePercent.setTypeface(Typeface.SANS_SERIF);
        addView(pointsMadePercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //Schieber
        TextView schieber = new TextView(context);
        schieber.setText(ch.zhaw.R.string.schieber);
        schieber.setTextSize(14);
        schieber.setTextColor(Color.BLUE);
        schieber.setTypeface(Typeface.SANS_SERIF);
        addView(schieber, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView gamesSchieberWonPercent = new TextView(context);
        gamesSchieberWonPercent.setText(ch.zhaw.R.string.gameswon + ": " + player.getSchieberGamesWonPercent() + "(" + player.getGamesWonSchieber() + ch.zhaw.R.string.off + player.getGamesPlayedSchieber() + ")");
        gamesSchieberWonPercent.setTextSize(14);
        gamesSchieberWonPercent.setTextColor(Color.GRAY);
        gamesSchieberWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(gamesSchieberWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView roundsSchieberWonPercent = new TextView(context);
        roundsSchieberWonPercent.setText(ch.zhaw.R.string.roundswon + ": " + player.getSchieberRoundsWonPercent() + "(" + player.getRoundsWonSchieber() + ch.zhaw.R.string.off + player.getRoundsPlayedSchieber() + ")");
        roundsSchieberWonPercent.setTextSize(14);
        roundsSchieberWonPercent.setTextColor(Color.GRAY);
        roundsSchieberWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(roundsSchieberWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView pointsSchieberMadePercent = new TextView(context);
        pointsSchieberMadePercent.setText(ch.zhaw.R.string.pointsmade + ": " + player.getSchieberPointsMadePercent() + "(" + player.getPointsMadeSchieber() + ch.zhaw.R.string.off + player.getPointsMaxSchieber() + ")");
        pointsSchieberMadePercent.setTextSize(14);
        pointsSchieberMadePercent.setTextColor(Color.GRAY);
        pointsSchieberMadePercent.setTypeface(Typeface.SANS_SERIF);
        addView(pointsSchieberMadePercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //Coiffeur
        TextView coiffeur = new TextView(context);
        coiffeur.setText(ch.zhaw.R.string.coiffeur);
        coiffeur.setTextSize(14);
        coiffeur.setTextColor(Color.BLUE);
        coiffeur.setTypeface(Typeface.SANS_SERIF);
        addView(coiffeur, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView gamesCoiffeurWonPercent = new TextView(context);
        gamesCoiffeurWonPercent.setText(ch.zhaw.R.string.gameswon + ": " + player.getCoiffeurGamesWonPercent() + "(" + player.getGamesWonCoiffeur() + ch.zhaw.R.string.off + player.getGamesPlayedCoiffeur() + ")");
        gamesCoiffeurWonPercent.setTextSize(14);
        gamesCoiffeurWonPercent.setTextColor(Color.GRAY);
        gamesCoiffeurWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(gamesCoiffeurWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView roundsCoiffeurWonPercent = new TextView(context);
        roundsCoiffeurWonPercent.setText(ch.zhaw.R.string.roundswon + ": " + player.getCoiffeurRoundsWonPercent() + "(" + player.getRoundsWonCoiffeur() + ch.zhaw.R.string.off + player.getRoundsPlayedCoiffeur() + ")");
        roundsCoiffeurWonPercent.setTextSize(14);
        roundsCoiffeurWonPercent.setTextColor(Color.GRAY);
        roundsCoiffeurWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(roundsCoiffeurWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView pointsCoiffeurMadePercent = new TextView(context);
        pointsCoiffeurMadePercent.setText(ch.zhaw.R.string.pointsmade + ": " + player.getCoiffeurPointsMadePercent() + "(" + player.getPointsMadeCoiffeur() + ch.zhaw.R.string.off + player.getPointsMaxCoiffeur() + ")");
        pointsCoiffeurMadePercent.setTextSize(14);
        pointsCoiffeurMadePercent.setTextColor(Color.GRAY);
        pointsCoiffeurMadePercent.setTypeface(Typeface.SANS_SERIF);
        addView(pointsCoiffeurMadePercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //Differenzler
        TextView differenzler = new TextView(context);
        differenzler.setText(ch.zhaw.R.string.differenzler);
        differenzler.setTextSize(14);
        differenzler.setTextColor(Color.BLUE);
        differenzler.setTypeface(Typeface.SANS_SERIF);
        addView(differenzler, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView gamesDifferenzlerWonPercent = new TextView(context);
        gamesDifferenzlerWonPercent.setText(ch.zhaw.R.string.gameswon + ": " + player.getDifferenzlerGamesWonPercent() + "(" + player.getGamesWonDifferenzler() + ch.zhaw.R.string.off + player.getGamesPlayedDifferenzler() + ")");
        gamesDifferenzlerWonPercent.setTextSize(14);
        gamesDifferenzlerWonPercent.setTextColor(Color.GRAY);
        gamesDifferenzlerWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(gamesDifferenzlerWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView roundsDifferenzlerWonPercent = new TextView(context);
        roundsDifferenzlerWonPercent.setText(ch.zhaw.R.string.roundswon + ": " + player.getDifferenzlerRoundsWonPercent() + "(" + player.getRoundsWonDifferenzler() + ch.zhaw.R.string.off + player.getRoundsPlayedDifferenzler() + ")");
        roundsDifferenzlerWonPercent.setTextSize(14);
        roundsDifferenzlerWonPercent.setTextColor(Color.GRAY);
        roundsDifferenzlerWonPercent.setTypeface(Typeface.SANS_SERIF);
        addView(roundsDifferenzlerWonPercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView pointsDifferenzlerMadePercent = new TextView(context);
        pointsDifferenzlerMadePercent.setText(ch.zhaw.R.string.pointsmade + ": " + player.getDifferenzlerPointsMadePercent() + "(" + player.getPointsMadeDifferenzler() + ch.zhaw.R.string.off + player.getPointsMaxDifferenzler() + ")");
        pointsDifferenzlerMadePercent.setTextSize(14);
        pointsDifferenzlerMadePercent.setTextColor(Color.GRAY);
        pointsDifferenzlerMadePercent.setTypeface(Typeface.SANS_SERIF);
        addView(pointsDifferenzlerMadePercent, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

//        player.getRoundsWonPercent();
//        player.getPointsMadePercent();
//        player.getSchieberGamesWonPercent();
//        player.getSchieberRoundsWonPercent();
//        player.getSchieberPointsMadePercent();


    }
}
