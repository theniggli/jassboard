package ch.zhaw.jassboard.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;
import ch.zhaw.jassboard.persist.Team;

import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

public class JassBoard extends Activity {
    private static final String TAG = "JassBoard";
    private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(TAG, "TEST");
    }


    public void setTeam(View view) {
        setContentView(R.layout.setteam);
        ListView playerList = (ListView) findViewById(R.id.playerList);
        ArrayList<Team> teamArrayList = dbH.getTeamList();
        ArrayAdapter<Team> arrayAdapter =
                new ArrayAdapter<Team>(this, android.R.layout.simple_list_item_1, teamArrayList);
        playerList.setAdapter(arrayAdapter);
    }

    public void startGame(View view) {
        //setContentView(R.layout.startGame);
    }

    public void setPlayer(View view) {
        Intent myIntent = new Intent(JassBoard.this, ViewPlayerList.class);
        JassBoard.this.startActivity(myIntent);
    }

}
