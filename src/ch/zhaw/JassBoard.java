package ch.zhaw;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class JassBoard extends Activity {
    private static final String TAG = "JassBoard";
    private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(TAG,"TEST");
    }




    public void setTeam(View view) {
        setContentView(R.layout.setteam);

    }

    public void startGame(View view) {
        //setContentView(R.layout.startGame);
    }

    public void setPlayer(View view) {
        setContentView(R.layout.setplayer);

        ListView playerList = (ListView) findViewById(R.id.playerList);
        // Instanciating an array list (you don't need to do this, you already have yours)
        ArrayList<String> your_array_list = new ArrayList<String>();
        your_array_list.add("foo");
        your_array_list.add("bar1");
        your_array_list.add("bar2");
        your_array_list.add("bar3");
        your_array_list.add("bar4");
        your_array_list.add("bar5");
        your_array_list.add("bar6");
        your_array_list.add("bar7");
        your_array_list.add("bar8");
        your_array_list.add("bar9");
        your_array_list.add("bar10");
        your_array_list.add("bar11");
        your_array_list.add("bar12");
        your_array_list.add("bar13");
        your_array_list.add("bar14");
        your_array_list.add("bar15");
        // This is the array adapter, it takes the context of the activity as a first // parameter, the type of list view as a second parameter and your array as a third parameter
   //     ArrayAdapter<String> arrayAdapter =
   //             new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, your_array_list);
   //     playerList.setAdapter(arrayAdapter);


        ArrayList<Player> playerArrayList = dbH.getPlayerList();
        ArrayAdapter<Player> arrayAdapter =
                new ArrayAdapter<Player>(this, android.R.layout.simple_list_item_1, playerArrayList);
        playerList.setAdapter(arrayAdapter);


    }

    //layout setplayer
    public void addPlayer(View view) {
        //ListViewPlayers();


    }

}
