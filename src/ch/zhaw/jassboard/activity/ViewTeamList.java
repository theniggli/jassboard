package ch.zhaw.jassboard.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;
import ch.zhaw.jassboard.persist.DatabaseHelper;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.persist.Team;
import ch.zhaw.jassboard.view.PlayerView;
import ch.zhaw.jassboard.view.TeamListAdapter;
import ch.zhaw.jassboard.view.TeamListView;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 05.11.12
 * Time: 18:52
 * To change this template use File | Settings | File Templates.
 */
public class ViewTeamList extends OrmLiteBaseActivity<DatabaseHelper> {
    //private static final String TAG = "Menu";
    //private DataBaseHandler dbH = new DataBaseHandler(this);

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
    }

    public void addTeam(View view) {
        Intent myIntent = new Intent(ViewTeamList.this, AddTeam.class);
        ViewTeamList.this.startActivity(myIntent);
    }
}
