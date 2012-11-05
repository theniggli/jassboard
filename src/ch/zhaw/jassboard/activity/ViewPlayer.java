package ch.zhaw.jassboard.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

public class ViewPlayer extends Activity {
    private static final String TAG = "JassBoard";
    private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewplayer);

        Intent intent = getIntent();
        String playerID = intent.getStringExtra("playerID"); //if it's a string you stored.

        ListView playerList = (ListView) findViewById(R.id.playerListView);
        ArrayList<String> your_array_list = dbH.getPlayerAL(Integer.parseInt(playerID));
        String test1 = your_array_list.get(0);
        String test2 = your_array_list.get(1);
        String test3 = your_array_list.get(2);
        String test4 = your_array_list.get(3);
        String test5 = your_array_list.get(4);
        String test6 = your_array_list.get(5);
        String test7 = your_array_list.get(6);


        your_array_list.add("bar");
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, your_array_list);
        playerList.setAdapter(arrayAdapter);


        //  ArrayList<String> playerArrayList = dbH.getPlayerAL(Integer.parseInt(playerID));
        //  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, playerArrayList);
        //  playerList.setAdapter(arrayAdapter);

    }
}
