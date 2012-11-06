package ch.zhaw.jassboard.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */

public class AddTeam extends Activity {
    private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addteam);

        //populate spinners
        ArrayList<String> playerIDnName = dbH.getplayerIDnName();

        Spinner spinnerPlayer1 = (Spinner) findViewById(R.id.player1);
        Spinner spinnerPlayer2 = (Spinner) findViewById(R.id.player2);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, playerIDnName);  //array you are populating
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerPlayer1.setAdapter(arrayAdapter);
        spinnerPlayer2.setAdapter(arrayAdapter);
    }

    public void addNewTeam(View view) {
        Spinner spinnerPlayer1 = (Spinner) findViewById(R.id.player1);
        Spinner spinnerPlayer2 = (Spinner) findViewById(R.id.player2);
        String player1 = spinnerPlayer1.getSelectedItem().toString();
        String player2 = spinnerPlayer2.getSelectedItem().toString();
        String player1_name = player1.substring(0, player1.lastIndexOf('-') ) ;
        String player2_name = player2.substring(0, player2.lastIndexOf('-') ) ;
        String player1_id = player1.substring( player1.lastIndexOf('-') +1 ) ;
        String player2_id = player2.substring( player2.lastIndexOf('-') +1 ) ;

    }

}