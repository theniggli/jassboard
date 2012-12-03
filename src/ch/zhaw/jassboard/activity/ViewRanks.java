package ch.zhaw.jassboard.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.persist.Team;
import ch.zhaw.jassboard.util.DatabaseHelper;
import ch.zhaw.jassboard.view.PlayerListAdapter;
import ch.zhaw.jassboard.view.TeamListAdapter;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class ViewRanks extends OrmLiteBaseActivity<DatabaseHelper> {
    LinearLayout rankingListLayout;
    RadioButton radioPlayers, radioTeams, radioGameswon, radioRoundswon, radioPointsmade;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewranks);
        radioPlayers = (RadioButton) findViewById(R.id.radio_players);
        radioTeams = (RadioButton) findViewById(R.id.radio_teams);
        radioGameswon = (RadioButton) findViewById(R.id.radio_gameswon);
        radioRoundswon = (RadioButton) findViewById(R.id.radio_roundswon);
        radioPointsmade = (RadioButton) findViewById(R.id.radio_pointsmade);
    }

    public void onRadioButtonClicked(View view) {
        if ((radioPlayers.isChecked() || radioTeams.isChecked()) && (radioGameswon.isChecked() || radioRoundswon.isChecked() || radioPointsmade.isChecked())) {
            //one off the radiobuttons player or team and one off the radiobuttons gameswon,roundswon or pointsmade is selected
            if (radioPlayers.isChecked()) {
                //player
                ListView playerList = (ListView) findViewById(R.id.rankinglist);
                RuntimeExceptionDao<Player, Integer> dao = getHelper().getPlayerDao();
                ArrayList<Player> playerArrayList = (ArrayList) dao.queryForAll();

                //order data by
                if (radioGameswon.isChecked()) {
                    //gameswon
                    Collections.sort(playerArrayList, new Comparator<Player>() {
                        public int compare(Player player1, Player player2) {
                            return player1.getGamesWon() - player2.getGamesWon();
                        }
                    });
                } else if (radioRoundswon.isChecked()) {
                    //roundswon
                    Collections.sort(playerArrayList, new Comparator<Player>() {
                        public int compare(Player player1, Player player2) {
                            return player1.getRoundsWon() - player2.getRoundsWon();
                        }
                    });
                } else {
                    //pointsmade
                    Collections.sort(playerArrayList, new Comparator<Player>() {
                        public int compare(Player player1, Player player2) {
                            return player1.getPointsMade() - player2.getPointsMade();
                        }
                    });
                }

                PlayerListAdapter<Player> arrayAdapter = new PlayerListAdapter<Player>(this, playerArrayList);
                playerList.setAdapter(arrayAdapter);

            } else {
                //team
                ListView teamList = (ListView) findViewById(R.id.rankinglist);
                RuntimeExceptionDao<Team, Integer> dao = getHelper().getTeamDao();
                ArrayList<Team> teamArrayList = (ArrayList) dao.queryForAll();

                //order data by
                if (radioGameswon.isChecked()) {
                    //gameswon
                    Collections.sort(teamArrayList, new Comparator<Team>() {
                        public int compare(Team team1, Team team2) {
                            return team1.getGamesWon() - team2.getGamesWon();
                        }
                    });
                } else if (radioRoundswon.isChecked()) {
                    //roundswon
                    Collections.sort(teamArrayList, new Comparator<Team>() {
                        public int compare(Team team1, Team team2) {
                            return team1.getRoundsWon() - team2.getRoundsWon();
                        }
                    });
                } else {
                    //pointsmade
                    Collections.sort(teamArrayList, new Comparator<Team>() {
                        public int compare(Team team1, Team team2) {
                            return team1.getPointsMade() - team2.getPointsMade();
                        }
                    });
                }

                TeamListAdapter<Team> arrayAdapter = new TeamListAdapter<Team>(this, teamArrayList);
                teamList.setAdapter(arrayAdapter);
            }
        }
    }
}
