package ch.zhaw.jassboard.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.view.PlayerListAdapter;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

public class ViewTeam extends Activity {
    private static final String TAG = "JassBoard";
    private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewteam);

        Intent intent = getIntent();
        String teamID = intent.getStringExtra("teamID"); //if it's a string you stored.

        ListView teamListView = (ListView) findViewById(R.id.teamListView);
        ArrayList<String> teamListArray = dbH.getTeamAL(Integer.parseInt(teamID));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamListArray);
        teamListView.setAdapter(arrayAdapter);

        ListView teamPlayerList = (ListView) findViewById(R.id.teamPlayerList);
        ArrayList<Player> teamPlayer = dbH.getTeamPlayers(Integer.parseInt(teamID));
        PlayerListAdapter<Player> arrayAdapter2 = new PlayerListAdapter<Player>(this, teamPlayer);
        teamPlayerList.setAdapter(arrayAdapter2);
    }
}
