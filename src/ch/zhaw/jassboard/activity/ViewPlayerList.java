package ch.zhaw.jassboard.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.persist.PlayerTeam;
import ch.zhaw.jassboard.util.DatabaseHelper;
import ch.zhaw.jassboard.view.PlayerListAdapter;
import ch.zhaw.jassboard.view.PlayerListView;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;

/**
 *  Activity ViewPlayerList shows list of all players
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */
public class ViewPlayerList extends OrmLiteBaseActivity<DatabaseHelper> {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewplayerlist);

        ListView playerList = (ListView) findViewById(R.id.playerList);
        RuntimeExceptionDao<Player, Integer> dao = getHelper().getPlayerDao();
        ArrayList<Player> playerArrayList = (ArrayList) dao.queryForAll();
        PlayerListAdapter<Player> arrayAdapter = new PlayerListAdapter<Player>(this, playerArrayList);
        playerList.setAdapter(arrayAdapter);

        playerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String playerID = "" + ((PlayerListView) view).getPlayerId();
                Intent myIntent = new Intent(ViewPlayerList.this, ViewPlayer.class);
                myIntent.putExtra("playerID", playerID);
                ViewPlayerList.this.startActivity(myIntent);
            }
        });
        playerList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Integer playerID = ((PlayerListView) view).getPlayerId();
                AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(view.getContext());
                myAlertDialog.setTitle(R.string.deletepl);
                myAlertDialog.setMessage(R.string.deleteplayer);

                myAlertDialog.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        // do something when the OK button is clicked
                        RuntimeExceptionDao<Player, Integer> playerDao = getHelper().getPlayerDao();
                        playerDao.deleteById(playerID);
                        //delete from teamplayer
                        RuntimeExceptionDao<PlayerTeam, Integer> teamplayerDao = getHelper().getPlayerTeamDao();
                        List<PlayerTeam> playerteamArrayList = teamplayerDao.queryForEq("playerID", playerID);
                        teamplayerDao.delete(playerteamArrayList);
                        //readable Toast message
                        Toast.makeText(getApplicationContext(), getString(R.string.player) + ": " + playerID + " " + getString(R.string.deleted) + ".", Toast.LENGTH_SHORT).show();
                        //reload Activity
                        reloadData();
                    }
                });
                myAlertDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        // do something when the Cancel button is clicked
                    }
                });
                myAlertDialog.show();
                return true;
            }
        });
    }

    /*
    *  Start activity AddPlayer.class
    */
    public void addPlayer(View view) {
        Intent myIntent = new Intent(ViewPlayerList.this, AddPlayer.class);
        ViewPlayerList.this.startActivity(myIntent);
    }

    /*
    *  when coming back to activity
    */
    @Override
    protected void onResume() {
        super.onResume();
        reloadData();
    }

    /*
    *  reload Data
    */
    public void reloadData() {
        ListView playerList = (ListView) findViewById(R.id.playerList);
        RuntimeExceptionDao<Player, Integer> dao = getHelper().getPlayerDao();
        ArrayList<Player> playerArrayList = (ArrayList) dao.queryForAll();
        PlayerListAdapter<Player> arrayAdapter = new PlayerListAdapter<Player>(this, playerArrayList);
        playerList.setAdapter(arrayAdapter);
    }
}
