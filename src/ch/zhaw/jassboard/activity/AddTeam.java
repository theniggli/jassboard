package ch.zhaw.jassboard.activity;

import android.os.Bundle;
import android.widget.*;
import ch.zhaw.R;
import ch.zhaw.jassboard.util.DatabaseHelper;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;


/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */

public class AddTeam extends OrmLiteBaseActivity<DatabaseHelper> {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addteam);

        //populate spinners
//        ArrayList<String> playerIDnName = dbH.getplayerIDnName();

        Spinner spinnerPlayer1 = (Spinner) findViewById(R.id.player1);
        Spinner spinnerPlayer2 = (Spinner) findViewById(R.id.player2);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, playerIDnName);  //array you are populating
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        spinnerPlayer1.setAdapter(arrayAdapter);
//        spinnerPlayer2.setAdapter(arrayAdapter);
    }

    //    public void addNewTeam(View view) {
//        Spinner spinnerPlayer1 = (Spinner) findViewById(R.id.player1);
//        Spinner spinnerPlayer2 = (Spinner) findViewById(R.id.player2);
//        String player1 = spinnerPlayer1.getSelectedItem().toString();
//        String player2 = spinnerPlayer2.getSelectedItem().toString();
//        String player1_name = player1.substring(0, player1.lastIndexOf('-') -1 );
//        String player2_name = player2.substring(0, player2.lastIndexOf('-') -1 );
//        int player1_id = Integer.parseInt(player1.substring(player1.lastIndexOf('-') + 2));
//        int player2_id = Integer.parseInt(player2.substring(player2.lastIndexOf('-') + 2));
//
//        EditText edit = (EditText) findViewById(R.id.teamName);
//        String teamName = edit.getText().toString();
//
//        if (teamName != "") {
//            if (player1_id != player2_id) {
//                if (dbH.playerExists(player1_id) && dbH.playerExists(player1_id)) {
//                    if (dbH.addTeam(teamName,player1_id,player2_id)) {
//                        Toast.makeText(getApplicationContext(), "Player added", Toast.LENGTH_SHORT).show();
//                        Intent refresh = new Intent(this, ViewTeamList.class);
//                        startActivity(refresh);
//                        this.finish();
//                    }   else {
//                        Toast.makeText(getApplicationContext(), "Couldn't add Team", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(getApplicationContext(), "Player does not exist", Toast.LENGTH_SHORT).show();
//                }
//            } else {
//                Toast.makeText(getApplicationContext(), "Selectet same Player twice", Toast.LENGTH_SHORT).show();
//            }
//        }
//   }

}