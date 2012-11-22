package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;
import ch.zhaw.jassboard.persist.DatabaseHelper;
import ch.zhaw.jassboard.persist.Player;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

public class ViewPlayer extends OrmLiteBaseActivity<DatabaseHelper> {
    private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewplayer);

        Intent intent = getIntent();
        String playerID = intent.getStringExtra("playerID"); //if it's a string you stored.

        ListView playerList = (ListView) findViewById(R.id.playerListView);
        ArrayList<String> your_array_list = dbH.getPlayerAL(Integer.parseInt(playerID));

        //RuntimeExceptionDao<Player, Integer> simpleDao = getHelper().getPlayerDao();
        //ArrayList<Player> your_array_list = (ArrayList) simpleDao.queryForAll();


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, your_array_list);
        playerList.setAdapter(arrayAdapter);


        //  ArrayList<String> playerArrayList = dbH.getPlayerAL(Integer.parseInt(playerID));
        //  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, playerArrayList);
        //  playerList.setAdapter(arrayAdapter);

    }
}
