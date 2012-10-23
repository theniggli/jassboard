package ch.zhaw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class JassBoard extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }



    public void setTeam(View view) {
        setContentView(R.layout.setteam);

    }
    public void startGame(View view) {
        //setContentView(R.layout.startGame);
    }
    public void setPlayer(View view) {
        setContentView(R.layout.setplayer);

        ListView playerList= (ListView) findViewById(R.id.playerList);
        // Instanciating an array list (you don't need to do this, you already have yours)
        ArrayList<String> your_array_list = new ArrayList<String>();
        your_array_list.add("foo");
        your_array_list.add("bar");
        // This is the array adapter, it takes the context of the activity as a first // parameter, the type of list view as a second parameter and your array as a third parameter
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, your_array_list);
        playerList.setAdapter(arrayAdapter);
    }

    //layout setplayer
    public void addPlayer(View view) {
        //ListViewPlayers();


    }

}
