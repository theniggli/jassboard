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
import ch.zhaw.jassboard.persist.PlayerTeam;
import ch.zhaw.jassboard.persist.Team;
import ch.zhaw.jassboard.util.DatabaseHelper;
import ch.zhaw.jassboard.view.TeamListAdapter;
import ch.zhaw.jassboard.view.TeamListView;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity who view The TeamList and add new Teams
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
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

                        Toast.makeText(getApplicationContext(), "-" + getString(R.string.team) + ": " + teamID + " " + getString(R.string.deleted) + ".", Toast.LENGTH_SHORT).show();
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
    *  Start activity AddTeam.class
    */
    public void addTeam(View view) {
        Intent myIntent = new Intent(ViewTeamList.this, AddTeam.class);
        ViewTeamList.this.startActivity(myIntent);
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
        ListView teamList = (ListView) findViewById(R.id.teamList);
        RuntimeExceptionDao<Team, Integer> dao = getHelper().getTeamDao();
        ArrayList<Team> teamArrayList = (ArrayList) dao.queryForAll();
        TeamListAdapter<Team> arrayAdapter = new TeamListAdapter<Team>(this, teamArrayList);
        teamList.setAdapter(arrayAdapter);
    }
}
