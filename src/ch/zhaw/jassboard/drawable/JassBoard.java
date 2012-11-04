package ch.zhaw;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;


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
        setContentView(R.layout.setplayer);
        ListView playerList = (ListView) findViewById(R.id.playerList);
        ArrayList<Player> playerArrayList = dbH.getPlayerList();
        PlayerAdapter<Player> arrayAdapter =
                new PlayerAdapter<Player>(this, playerArrayList);
        playerList.setAdapter(arrayAdapter);
        playerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String playerID = "" + ((PlayerView) view).getPlayerId();
                Toast.makeText(getApplicationContext(),
                        playerID, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "something");
            }
        });
    }

    //layout setplayer
    public void addPlayer(View view) {
        //ListViewPlayers();


    }

}
