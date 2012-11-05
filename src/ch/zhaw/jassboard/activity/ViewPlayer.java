package ch.zhaw.jassboard.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.view.PlayerAdapter;
import ch.zhaw.jassboard.view.PlayerView;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class ViewPlayer  extends Activity {
    private static final String TAG = "JassBoard";
    private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewplayer);
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
}
