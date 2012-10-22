package ch.zhaw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

     //   Button buttonSetTeam = (Button) findViewById(R.id.button_set_team);
     //   buttonSetTeam.setOnClickListener(new View.OnClickListener() {
     //       public void onClick(View v) {
                // Perform action on click
     //       }
     //   });
     //   Button buttonSetPlayer = (Button) findViewById(R.id.button_set_player);
     //   buttonSetPlayer.setOnClickListener(new View.OnClickListener() {
     //       public void onClick(View v) {
      //          // Perform action on click
      //      }
     //   });
        //Button buttonStartGame = (Button) findViewById(R.id.button_start_game);
        //buttonStartGame.setOnClickListener(new View.OnClickListener() {
         //   public void onClick(View v) {
                // Perform action on click
        //    }
      //  });

    }
    public void setTeam(View view) {
          //asdf
        setContentView(R.layout.setteam);

    }
}
