package ch.zhaw.jassboard.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */

public class AddPlayer extends Activity {
//    private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addplayer);
    }

    public void addNewPlayer(View view) {
        EditText edit = (EditText) findViewById(R.id.playerName);
        String playerName = edit.getText().toString();

//        if (playerName != "") {
//            if (dbH.addPlayer(playerName) == true) {
//                Toast.makeText(getApplicationContext(), "Player added", Toast.LENGTH_SHORT).show();
//                Intent refresh = new Intent(this, ViewPlayerList.class);
//                startActivity(refresh);
//                this.finish();
//            } else {
//                Toast.makeText(getApplicationContext(), "Invalid Playername", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(getApplicationContext(), "Blank Playername", Toast.LENGTH_SHORT).show();
//        }
    }
}