package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.persist.SchieberScore;
import ch.zhaw.jassboard.persist.Team;
import ch.zhaw.jassboard.view.SchieberView;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Base Activity for the Board
 * - Extends generic JassboardActivity
 * - Starts the View for the Board
 *
 * @author <a href=mailto:stjepton@students.zhaw.ch>toni</a>
 * @since 12/1/12 8:50 AM
 */

public class SchieberActivity extends JassboardActivity {
    public SchieberView _board;

    public SchieberActivity() {
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this._board = new SchieberView(this);
        // set the schieberview view to draw the board
        setContentView(this._board);
        Intent intent = getIntent();
        Integer player1ID = Integer.parseInt(intent.getStringExtra("player1ID")); //if it's a string you stored.
        Integer player2ID = Integer.parseInt(intent.getStringExtra("player2ID"));
        Integer player3ID = Integer.parseInt(intent.getStringExtra("player3ID"));
        Integer player4ID = Integer.parseInt(intent.getStringExtra("player4ID"));
        Integer team1ID = Integer.parseInt(intent.getStringExtra("team1ID"));
        Integer team2ID = Integer.parseInt(intent.getStringExtra("team2ID"));

        RuntimeExceptionDao<Player, Integer> playerDAO = getHelper().getPlayerDao();
        Player player1 = playerDAO.queryForId(player1ID);
        Player player2 = playerDAO.queryForId(player2ID);
        Player player3 = playerDAO.queryForId(player3ID);
        Player player4 = playerDAO.queryForId(player4ID);

        if (team1ID != -1 ){
            RuntimeExceptionDao<Team, Integer> teamDAO = getHelper().getTeamDao();
            Team team1 = teamDAO.queryForId(team1ID);
            Team team2 = teamDAO.queryForId(team2ID);
        }
    }

    public void onDialogClosed(int paramInt, Bundle paramBundle) {
        System.out.println("dialog closed");
            boolean bool = paramBundle.getBoolean("complete_opponents_score");
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        return true;
    }

    protected void onPause() {
            super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("App stopped");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("App destoryed");

        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    /**
     * Is launched when ScoreDialog finishes
     * @param reqCode
     * @param resCode
     * @param data the intent
     */
    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data){
        //super.onActivityResult(reqCode, resCode, data);
        SchieberScore score_t = new SchieberScore(0,0,0,0);
        SchieberScore score_b = new SchieberScore(0,0,0,0);
        int multi = data.getIntExtra("multi",0);
//        if(data.getStringExtra("team").equals("t")){
        if(reqCode == 1){
            score_t.setPoints(data.getIntExtra("resultEntered",0), multi);
            _board.setTeam_t(score_t);
            score_b.setPoints(data.getIntExtra("resultCalculated",0), multi);
            _board.setTeam_b(score_b);
        }else{
            score_t.setPoints(data.getIntExtra("resultCalculated",0), multi);
            _board.setTeam_t(score_t);
            score_b.setPoints(data.getIntExtra("resultEntered",0), multi);
            _board.setTeam_b(score_b);
        }
        _board.draw();
    }
}

