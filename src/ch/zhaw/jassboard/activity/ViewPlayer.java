package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.widget.LinearLayout;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DatabaseHelper;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.view.PlayerView;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

public class ViewPlayer extends OrmLiteBaseActivity<DatabaseHelper> {
    //private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewplayer);

        Intent intent = getIntent();
        Integer playerID = Integer.parseInt(intent.getStringExtra("playerID")); //if it's a string you stored.

        RuntimeExceptionDao<Player, Integer> dao = getHelper().getPlayerDao();
        Player player = dao.queryForId(playerID);
        PlayerView pv = new PlayerView(this, player);
        LinearLayout layout = (LinearLayout) findViewById(R.id.viewplayerLinearLayout);
        layout.addView(pv);

    }
}
