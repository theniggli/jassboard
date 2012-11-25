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
import ch.zhaw.jassboard.persist.Team;
import ch.zhaw.jassboard.view.PlayerListView;
import ch.zhaw.jassboard.view.TeamListAdapter;
import ch.zhaw.jassboard.view.TeamListView;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 05.11.12
 * Time: 18:52
 * To change this template use File | Settings | File Templates.
 */
public class ViewTeamList extends OrmLiteBaseActivity<DatabaseHelper> {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewteamlist);
        ListView teamList = (ListView) findViewById(R.id.teamList);

        //ArrayList<Team> teamArrayList = dbH.getTeamList();
        RuntimeExceptionDao<Team, Integer> dao = getHelper().getTeamDao();
        ArrayList<Team> teamArrayList = (ArrayList) dao.queryForAll();
        TeamListAdapter<Team> arrayAdapter = new TeamListAdapter<Team>(this, teamArrayList);
        teamList.setAdapter(arrayAdapter);
        teamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String teamID = "" + ((TeamListView) view).getTeamId();

                Intent myIntent = new Intent(ViewTeamList.this, ViewTeam.class);
                myIntent.putExtra("teamID", teamID);
                ViewTeamList.this.startActivity(myIntent);

            }
        });
        teamList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Integer teamID = ((TeamListView) view).getTeamId();

                AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(view.getContext());
                myAlertDialog.setTitle(R.string.deletetm);
                myAlertDialog.setMessage(R.string.deleteteam);

                myAlertDialog.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        // do something when the OK button is clicked
                        RuntimeExceptionDao<Team, Integer> teamDao = getHelper().getTeamDao();
                        teamDao.deleteById(teamID);
                        //delete from teamplayer
                        RuntimeExceptionDao<PlayerTeam, Integer> teamplayerDao = getHelper().getPlayerTeamDao();
                        List<PlayerTeam> playerteamArrayList = teamplayerDao.queryForEq("teamID", teamID);
                        teamplayerDao.delete(playerteamArrayList);

                        //TODO
                        //readable Toast message
                        String message = new String("-" + R.string.team + ": " + teamID + " " + R.string.deleted + ".");
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        //reload Activity
                        refresh();
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

    public void addTeam(View view) {
        Intent myIntent = new Intent(ViewTeamList.this, AddTeam.class);
        ViewTeamList.this.startActivity(myIntent);
    }

    public void refresh() {
        //uncool but working
        Intent refresh = new Intent(this, ViewTeamList.class);
        startActivity(refresh);
        this.finish();
    }

    public void onResume(Bundle savedInstanceState) {
        onCreate(savedInstanceState);
    }
}
