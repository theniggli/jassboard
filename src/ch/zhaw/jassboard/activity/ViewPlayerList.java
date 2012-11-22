package ch.zhaw.jassboard.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;
import ch.zhaw.jassboard.persist.DatabaseHelper;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.view.PlayerListAdapter;
import ch.zhaw.jassboard.view.PlayerListView;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class ViewPlayerList extends OrmLiteBaseActivity<DatabaseHelper> {
    //private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewplayerlist);
        ListView playerList = (ListView) findViewById(R.id.playerList);

        try {
            Dao<Player, Integer> dao = getHelper().getPlayerDao();
            ArrayList<Player> playerArrayList = (ArrayList) dao.queryForAll();
            PlayerListAdapter<Player> arrayAdapter = new PlayerListAdapter<Player>(this, playerArrayList);

            playerList.setAdapter(arrayAdapter);
            playerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String playerID = "" + ((PlayerListView) view).getPlayerId();
                    Intent myIntent = new Intent(ViewPlayerList.this, ViewPlayer.class);
                    myIntent.putExtra("playerID", playerID);
                    ViewPlayerList.this.startActivity(myIntent);
                }
            });
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);

        }
    }

    //layout setplayer
    public void addPlayer(View view) {
        Intent myIntent = new Intent(ViewPlayerList.this, AddPlayer.class);
        ViewPlayerList.this.startActivity(myIntent);
    }
}
