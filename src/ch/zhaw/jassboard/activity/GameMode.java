package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.persist.PlayerTeam;
import ch.zhaw.jassboard.persist.Team;
import ch.zhaw.jassboard.util.DatabaseHelper;
import ch.zhaw.jassboard.view.PlayerListAdapter;
import ch.zhaw.jassboard.view.TeamListAdapter;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;


/**
 * Activity in which the gamemode can be selected and the game will be started
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */

public class GameMode extends OrmLiteBaseActivity<DatabaseHelper> {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamemode);

        final Button startGameButton = (Button) findViewById(R.id.start_game);
        final LinearLayout gameModewFourPlayers = (LinearLayout) findViewById(R.id.fourplayerselection);
        final LinearLayout gameModewTwoTeams = (LinearLayout) findViewById(R.id.twoteamselection);
        final Spinner gameModeSpinner = (Spinner) findViewById(R.id.gamemodespinner);

        //get spinners
        Spinner team1Spinner = (Spinner) findViewById(R.id.team1);
        Spinner team2Spinner = (Spinner) findViewById(R.id.team2);
        Spinner player1Spinner = (Spinner) findViewById(R.id.player1);
        Spinner player2Spinner = (Spinner) findViewById(R.id.player2);
        Spinner player3Spinner = (Spinner) findViewById(R.id.player3);
        Spinner player4Spinner = (Spinner) findViewById(R.id.player4);

        //Get Players
        RuntimeExceptionDao<Player, Integer> playerDAO = getHelper().getPlayerDao();
        ArrayList<Player> playerArrayList = (ArrayList) playerDAO.queryForAll();
        PlayerListAdapter<Player> playerArrayAdapter = new PlayerListAdapter<Player>(this, playerArrayList);
        player1Spinner.setAdapter(playerArrayAdapter);
        player2Spinner.setAdapter(playerArrayAdapter);
        player3Spinner.setAdapter(playerArrayAdapter);
        player4Spinner.setAdapter(playerArrayAdapter);

        //Get Team
        RuntimeExceptionDao<Team, Integer> teamDAO = getHelper().getTeamDao();
        ArrayList<Team> teamArrayList = (ArrayList) teamDAO.queryForAll();
        TeamListAdapter<Team> teamArrayAdapter = new TeamListAdapter<Team>(this, teamArrayList);
        team1Spinner.setAdapter(teamArrayAdapter);
        team2Spinner.setAdapter(teamArrayAdapter);


        gameModeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int gamemode = gameModeSpinner.getSelectedItemPosition();
                LinearLayout gameModeSchieber = (LinearLayout) findViewById(R.id.gamemodeschieber);

                if (gamemode == 0) {
//                    Schieber
                    gameModeSchieber.setVisibility(LinearLayout.VISIBLE);
                    onRadioButtonClicked(findViewById(R.id.radio_teams));
                    startGameButton.setVisibility(LinearLayout.VISIBLE);
                } else if (gamemode == 1) {
//                    Coiffeur
                    gameModeSchieber.setVisibility(LinearLayout.GONE);
                    gameModewFourPlayers.setVisibility(LinearLayout.VISIBLE);
                    gameModewTwoTeams.setVisibility(LinearLayout.GONE);
                    startGameButton.setVisibility(LinearLayout.VISIBLE);
                } else if (gamemode == 2) {
//                    Differenzler
                    gameModeSchieber.setVisibility(LinearLayout.GONE);
                    gameModewFourPlayers.setVisibility(LinearLayout.VISIBLE);
                    gameModewTwoTeams.setVisibility(LinearLayout.GONE);
                    startGameButton.setVisibility(LinearLayout.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    /*
    *  changes visibility of the LinearLayout team/player
    */
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        Button startGameButton = (Button) findViewById(R.id.start_game);
        LinearLayout gameModewFourPlayers = (LinearLayout) findViewById(R.id.fourplayerselection);
        LinearLayout gameModewTwoTeams = (LinearLayout) findViewById(R.id.twoteamselection);

        switch (view.getId()) {
            case R.id.radio_players:
                if (checked) {
                    gameModewTwoTeams.setVisibility(LinearLayout.GONE);
                    gameModewFourPlayers.setVisibility(LinearLayout.VISIBLE);
                    startGameButton.setVisibility(LinearLayout.VISIBLE);
                }
                break;
            case R.id.radio_teams:
                if (checked) {
                    gameModewTwoTeams.setVisibility(LinearLayout.VISIBLE);
                    gameModewFourPlayers.setVisibility(LinearLayout.GONE);
                    startGameButton.setVisibility(LinearLayout.VISIBLE);
                }
                break;
        }
    }

    /*
    *  Starts the selected game if possible
    */
    public void startGame(View view) {
        //goto game here ^^
        Spinner gameModeSpinner = (Spinner) findViewById(R.id.gamemodespinner);
        //get spinners
        Spinner team1Spinner = (Spinner) findViewById(R.id.team1);
        Spinner team2Spinner = (Spinner) findViewById(R.id.team2);
        Spinner player1Spinner = (Spinner) findViewById(R.id.player1);
        Spinner player2Spinner = (Spinner) findViewById(R.id.player2);
        Spinner player3Spinner = (Spinner) findViewById(R.id.player3);
        Spinner player4Spinner = (Spinner) findViewById(R.id.player4);

        Team team1 = null;
        Team team2 = null;
        Player player1 = null;
        Player player2 = null;
        Player player3 = null;
        Player player4 = null;

        int gamemode = gameModeSpinner.getSelectedItemPosition();

        RadioButton radioButton = (RadioButton) findViewById(R.id.radio_players);
        if (radioButton.isChecked()) {
            player1 = (Player) player1Spinner.getSelectedItem();
            player2 = (Player) player2Spinner.getSelectedItem();
            player3 = (Player) player3Spinner.getSelectedItem();
            player4 = (Player) player4Spinner.getSelectedItem();
        } else {
            team1 = (Team) team1Spinner.getSelectedItem();
            team2 = (Team) team2Spinner.getSelectedItem();

            RuntimeExceptionDao<PlayerTeam, Integer> playerTeamDAO = getHelper().getPlayerTeamDao();
            List<PlayerTeam> playerTeamList1 = playerTeamDAO.queryForEq("teamID", team1.getTeamID());
            List<PlayerTeam> playerTeamList2 = playerTeamDAO.queryForEq("teamID", team2.getTeamID());

            RuntimeExceptionDao<Player, Integer> playerDAO = getHelper().getPlayerDao();
            Player player = new Player();
            ArrayList<Player> playerArrayList = new ArrayList<Player>();

            int l = 0;
            for (PlayerTeam i : playerTeamList1) {
                l++;
                if (l == 1) {
                    player1 = playerDAO.queryForId(i.getPlayerID());
                } else if (l == 2) {
                    player2 = playerDAO.queryForId(i.getPlayerID());
                }
                playerArrayList.add(player);
            }
            l = 0;
            for (PlayerTeam i : playerTeamList2) {
                l++;
                if (l == 1) {
                    player3 = playerDAO.queryForId(i.getPlayerID());
                } else if (l == 2) {
                    player4 = playerDAO.queryForId(i.getPlayerID());
                }
            }
        }


        if (gamemode == 0) {
            //Schieber
            Intent myIntent = new Intent(this, SchieberActivity.class);
            if (radioButton.isChecked()) {
                if (((player1.getPlayerID() != player2.getPlayerID()) && (player1.getPlayerID() != player3.getPlayerID()) && (player1.getPlayerID() != player4.getPlayerID()) && (player2.getPlayerID() != player3.getPlayerID()) && (player3.getPlayerID() != player4.getPlayerID()))) {
                    myIntent.putExtra("player1ID", "" + player1.getPlayerID());
                    myIntent.putExtra("player2ID", "" + player2.getPlayerID());
                    myIntent.putExtra("player3ID", "" + player3.getPlayerID());
                    myIntent.putExtra("player4ID", "" + player4.getPlayerID());

                    myIntent.putExtra("team1ID", "-1");
                    myIntent.putExtra("team2ID", "-1");
                    this.startActivity(myIntent);
                } else {
                    Toast.makeText(getApplicationContext(), this.getString(R.string.playersusedtwice), Toast.LENGTH_SHORT).show();
                }
            } else {
                if ((team1.getTeamID() != team2.getTeamID()) && (player1.getPlayerID() != player2.getPlayerID()) && (player1.getPlayerID() != player3.getPlayerID()) && (player1.getPlayerID() != player4.getPlayerID()) && (player2.getPlayerID() != player3.getPlayerID()) && (player3.getPlayerID() != player4.getPlayerID())) {
                    myIntent.putExtra("player1ID", "" + player1.getPlayerID());
                    myIntent.putExtra("player2ID", "" + player2.getPlayerID());
                    myIntent.putExtra("player3ID", "" + player3.getPlayerID());
                    myIntent.putExtra("player4ID", "" + player4.getPlayerID());

                    myIntent.putExtra("team1ID", "" + team1.getTeamID());
                    myIntent.putExtra("team2ID", "" + team2.getTeamID());
                    this.startActivity(myIntent);
                } else {
                    Toast.makeText(getApplicationContext(), this.getString(R.string.playersusedtwice), Toast.LENGTH_SHORT).show();
                }
            }
        } else if (gamemode == 1)

        {
            //Coiffeur

        } else if (gamemode == 2)

        {
            //Differenzler

        }
    }
}
