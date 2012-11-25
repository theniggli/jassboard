package ch.zhaw.jassboard.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import ch.zhaw.R;
import ch.zhaw.jassboard.util.DatabaseHelper;
import ch.zhaw.jassboard.persist.Player;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */

public class AddPlayer extends OrmLiteBaseActivity<DatabaseHelper> {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addplayer);
    }

    public void addNewPlayer(View view) {
        EditText edit = (EditText) findViewById(R.id.playerName);
        String playerName = edit.getText().toString();

        if (playerName != "") {
            RuntimeExceptionDao<Player, Integer> playerDao = getHelper().getPlayerDao();
            Player player = new Player(playerName);
            playerDao.create(player);
//            Intent refresh = new Intent(this, ViewTeamList.class);
//            startActivity(refresh);
            this.finish();
        } else {
            Toast.makeText(getApplicationContext(), "Blank Playername", Toast.LENGTH_SHORT).show();
        }
    }
}