package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.persist.PlayerTeam;
import ch.zhaw.jassboard.util.DatabaseHelper;
import ch.zhaw.jassboard.persist.Team;
import ch.zhaw.jassboard.view.PlayerListAdapter;
import ch.zhaw.jassboard.view.TeamView;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

public class ViewTeam extends OrmLiteBaseActivity<DatabaseHelper> {
    //private static final String TAG = "Menu";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewteam);

        Intent intent = getIntent();
        Integer teamID = Integer.parseInt(intent.getStringExtra("teamID")); //if it's a string you stored.


        RuntimeExceptionDao<Team, Integer> dao = getHelper().getTeamDao();
        Team team = dao.queryForId(teamID);
        TeamView tv = new TeamView(this, team);
        LinearLayout layout = (LinearLayout) findViewById(R.id.viewteamLinearLayout);
        layout.addView(tv);


        RuntimeExceptionDao<PlayerTeam, Integer> playerTeamDAO = getHelper().getPlayerTeamDao();
        List<PlayerTeam> playerTeamList = playerTeamDAO.queryForEq("teamID", team.getTeamID());

        //for each item in list
        RuntimeExceptionDao<Player, Integer> playerDAO = getHelper().getPlayerDao();
        Player player = new Player();
        ArrayList<Player> playerArrayList = new ArrayList<Player>();

        for (PlayerTeam i : playerTeamList) {
            player = playerDAO.queryForId(i.getPlayerID());
            playerArrayList.add(player);
        }

        //insert dummytext before the world ends
        TextView dummy = new TextView(this);
        dummy.setText(R.string.players_of_team);
        layout.addView(dummy);

        ListView playerList = new ListView(this);
        PlayerListAdapter<Player> arrayAdapter = new PlayerListAdapter<Player>(this, playerArrayList);
        playerList.setAdapter(arrayAdapter);
        layout.addView(playerList);
    }
}
