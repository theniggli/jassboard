package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DatabaseHelper;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.persist.Team;
import ch.zhaw.jassboard.view.PlayerListAdapter;
import ch.zhaw.jassboard.view.TeamView;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

public class ViewTeam extends OrmLiteBaseActivity<DatabaseHelper> {
    //private static final String TAG = "Menu";
    //private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewteam);

        Intent intent = getIntent();
        Integer teamID = Integer.parseInt(intent.getStringExtra("teamID")); //if it's a string you stored.


        try {
            Dao<Team, Integer> dao = getHelper().getTeamDao();
            Team team = dao.queryForId(teamID);
            TeamView tv = new TeamView(this, team);
            LinearLayout layout = (LinearLayout) findViewById(R.id.viewteamLinearLayout);
            layout.addView(tv);
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }

      //  ListView teamPlayerList = (ListView) findViewById(R.id.teamPlayerList);
      //  ArrayList<Player> teamPlayer = dbH.getTeamPlayers(Integer.parseInt(teamID));
      //  PlayerListAdapter<Player> arrayAdapter2 = new PlayerListAdapter<Player>(this, teamPlayer);
      //  teamPlayerList.setAdapter(arrayAdapter2);
    }
}
