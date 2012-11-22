package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;
import ch.zhaw.jassboard.persist.DatabaseHelper;
import ch.zhaw.jassboard.persist.Player;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;
import java.util.Random;


/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

public class Menu extends OrmLiteBaseActivity<DatabaseHelper> {
   // private DataBaseHandler dbH = new DataBaseHandler(this);

    private final String LOG_TAG = getClass().getSimpleName();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void setTeam(View view) {
        Intent myIntent = new Intent(Menu.this, ViewTeamList.class);
        Menu.this.startActivity(myIntent);
    }

    public void startGame(View view) {
        //setContentView(R.layout.startGame);

    }

    public void setPlayer(View view) {
        Intent myIntent = new Intent(Menu.this, ViewPlayerList.class);
        Menu.this.startActivity(myIntent);
    }
}
