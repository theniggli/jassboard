package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.util.DatabaseHelper;
import ch.zhaw.jassboard.view.PlayerView;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * View Player which was selected in ViewPlayerList
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */

public class ViewPlayer extends OrmLiteBaseActivity<DatabaseHelper> {

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
