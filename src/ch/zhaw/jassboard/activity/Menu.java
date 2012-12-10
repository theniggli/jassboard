package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ch.zhaw.R;
import ch.zhaw.jassboard.util.DatabaseHelper;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

/**
 * Main activity with Buttons to start sub Activities
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */
public class Menu extends OrmLiteBaseActivity<DatabaseHelper> {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    /*
    *  starts ViewTeamList.class
    */
    public void setTeam(View view) {
        Intent myIntent = new Intent(Menu.this, ViewTeamList.class);
        Menu.this.startActivity(myIntent);
    }

    /*
    *  starts GameMode.class
    */
    public void startGame(View view) {
        Intent myIntent = new Intent(Menu.this, GameMode.class);
        Menu.this.startActivity(myIntent);
    }

    /*
    *  starts ViewPlayerList.class
    */
    public void setPlayer(View view) {
        Intent myIntent = new Intent(Menu.this, ViewPlayerList.class);
        Menu.this.startActivity(myIntent);
    }

    /*
    *  starts ViewRanks.class
    */
    public void viewRanks(View view) {
        Intent myIntent = new Intent(Menu.this, ViewRanks.class);
        Menu.this.startActivity(myIntent);
    }
}
