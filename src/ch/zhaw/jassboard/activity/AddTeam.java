package ch.zhaw.jassboard.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.persist.PlayerTeam;
import ch.zhaw.jassboard.persist.Team;
import ch.zhaw.jassboard.util.DatabaseHelper;
import ch.zhaw.jassboard.view.PlayerListAdapter;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;


/**
 * Activity to add a new Team into the Database
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */

public class AddTeam extends OrmLiteBaseActivity<DatabaseHelper> {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addteam);

        Spinner spinnerPlayer1 = (Spinner) findViewById(R.id.player1);
        Spinner spinnerPlayer2 = (Spinner) findViewById(R.id.player2);

        //populate spinners
        RuntimeExceptionDao<Player, Integer> dao = getHelper().getPlayerDao();
        ArrayList<Player> playerArrayList = (ArrayList) dao.queryForAll();
        PlayerListAdapter<Player> arrayAdapter = new PlayerListAdapter<Player>(this, playerArrayList);

        spinnerPlayer1.setAdapter(arrayAdapter);
        spinnerPlayer2.setAdapter(arrayAdapter);
    }

    /*
    *  this function ist called on click on the button addNewTeam. It checks the team and if everything is ok it adds the team into the DB
    */
    public void addNewTeam(View view) {
        Spinner spinnerPlayer1 = (Spinner) findViewById(R.id.player1);
        Spinner spinnerPlayer2 = (Spinner) findViewById(R.id.player2);
        Player player1 = (Player) spinnerPlayer1.getSelectedItem();
        Player player2 = (Player) spinnerPlayer2.getSelectedItem();

        EditText edit = (EditText) findViewById(R.id.teamName);
        String teamName = edit.getText().toString();

        if (!teamName.equals("")) {
            if (player1.getPlayerID() != player2.getPlayerID()) {
                //create team
                RuntimeExceptionDao<Team, Integer> teamDAO = getHelper().getTeamDao();
                Team team = new Team(teamName);
                teamDAO.create(team);
                //create PlayerTeam
                RuntimeExceptionDao<PlayerTeam, Integer> playerTeamDAO = getHelper().getPlayerTeamDao();
                //player1
                PlayerTeam playerteam = new PlayerTeam(player1.getPlayerID(), team.getTeamID());
                playerTeamDAO.create(playerteam);
                //player2
                playerteam = new PlayerTeam(player2.getPlayerID(), team.getTeamID());
                playerTeamDAO.create(playerteam);
                Toast.makeText(getApplicationContext(), this.getString(R.string.team) + " " + team.getTeamName() + " " + this.getString(R.string.created) + ".", Toast.LENGTH_SHORT).show();

                this.finish();

            } else {
                Toast.makeText(getApplicationContext(), this.getString(R.string.sameplayerselectedtwice), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), this.getString(R.string.blankteamname), Toast.LENGTH_SHORT).show();
        }
    }

}