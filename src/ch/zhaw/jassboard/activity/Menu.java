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
    private DataBaseHandler dbH = new DataBaseHandler(this);

    private final String LOG_TAG = getClass().getSimpleName();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //TextView tv = (TextView) findViewById(R.id.text);
       // doSampleDatabaseStuff2("onCreate", tv);
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

    private void doSampleDatabaseStuff2(String action, TextView tv) {
        // get our dao
        RuntimeExceptionDao<Player, Integer> simpleDao = getHelper().getPlayerDao();
        // query for all of the data objects in the database
        List<Player> list = simpleDao.queryForAll();
        // our string builder for building the content-view
        StringBuilder sb = new StringBuilder();
        sb.append("got ").append(list.size()).append(" entries in ").append(action).append("\n");

        int createNum;
        do {
            createNum = new Random().nextInt(3) + 1;
        } while (createNum == list.size());
        for (int i = 0; i < createNum; i++) {
            // create a new simple object
            Player simple = new Player("asdf");
            // store it in the database
            simpleDao.create(simple);
            // output it
            sb.append("------------------------------------------\n");
            sb.append("created new entry #").append(i + 1).append(":\n");
            sb.append(simple).append("\n");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // ignore
            }
        }

        tv.setText(sb.toString());
        Log.i(LOG_TAG, "Done with page at " + System.currentTimeMillis());
    }
}
