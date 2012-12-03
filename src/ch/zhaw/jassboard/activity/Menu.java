package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ch.zhaw.R;
import ch.zhaw.jassboard.util.DatabaseHelper;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

public class Menu extends OrmLiteBaseActivity<DatabaseHelper> {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void setTeam(View view) {
        Intent myIntent = new Intent(Menu.this, ViewTeamList.class);
        Menu.this.startActivity(myIntent);
    }

    public void startGame(View view) {
        Intent myIntent = new Intent(Menu.this, GameMode.class);
        Menu.this.startActivity(myIntent);
    }

    public void setPlayer(View view) {
        Intent myIntent = new Intent(Menu.this, ViewPlayerList.class);
        Menu.this.startActivity(myIntent);
    }

    public void viewStatistics(View view)    {
        Intent myIntent = new Intent(Menu.this, ViewStatistics.class);
        Menu.this.startActivity(myIntent);
    }
}
