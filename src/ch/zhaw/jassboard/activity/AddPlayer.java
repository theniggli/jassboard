package ch.zhaw.jassboard.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.util.DatabaseHelper;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 *  Activity to add a new player into the Database
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */

public class AddPlayer extends OrmLiteBaseActivity<DatabaseHelper> {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addplayer);
    }

    /*
    *  this function ist called on click on the button addNewPlayer. It checks the player and if everything is ok it adds the player into the DB
    */
    public void addNewPlayer(View view) {
        EditText edit = (EditText) findViewById(R.id.playerName);
        String playerName = edit.getText().toString();

        if (playerName != "") {
            RuntimeExceptionDao<Player, Integer> playerDao = getHelper().getPlayerDao();
            Player player = new Player(playerName);
            playerDao.create(player);
            Toast.makeText(getApplicationContext(), " " + this.getString(R.string.player) + " " + playerName + " " + this.getString(R.string.created) + ".", Toast.LENGTH_SHORT).show();
            this.finish();

        } else {
            Toast.makeText(getApplicationContext(), " " + this.getString(R.string.blankplayername), Toast.LENGTH_SHORT).show();
        }
    }
}