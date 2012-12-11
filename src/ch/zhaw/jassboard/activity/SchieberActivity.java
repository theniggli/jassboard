package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
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
    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Team team1;
    Team team2;
    SchieberScore score_t = new SchieberScore(0, 0, 0, 0);
    SchieberScore score_b = new SchieberScore(0, 0, 0, 0);

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
        player1 = playerDAO.queryForId(player1ID);
        player2 = playerDAO.queryForId(player2ID);
        player3 = playerDAO.queryForId(player3ID);
        player4 = playerDAO.queryForId(player4ID);

        if (team1ID != -1) {
            RuntimeExceptionDao<Team, Integer> teamDAO = getHelper().getTeamDao();
            team1 = teamDAO.queryForId(team1ID);
            team2 = teamDAO.queryForId(team2ID);
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
     *
     * @param reqCode
     * @param resCode
     * @param data    the intent
     */
    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        //super.onActivityResult(reqCode, resCode, data);
        if (data != null) {
            int multi = data.getIntExtra("multi", 0);
//        if(data.getStringExtra("team").equals("t")){
            if (reqCode == 1) {
                score_t.setPoints(data.getIntExtra("resultEntered", 0), multi);
                _board.setTeam_t(score_t);
                score_b.setPoints(data.getIntExtra("resultCalculated", 0), multi);
                _board.setTeam_b(score_b);
            } else {
                score_t.setPoints(data.getIntExtra("resultCalculated", 0), multi);
                _board.setTeam_t(score_t);
                score_b.setPoints(data.getIntExtra("resultEntered", 0), multi);
                _board.setTeam_b(score_b);
            }
            _board.draw();

            int roundDone = data.getIntExtra("roundDone", 0);
            //fill out statistics if round is done
            if (roundDone == 1) {
                //round done
                if (reqCode == 1) {
                    if (data.getIntExtra("resultEntered", 0) * multi > data.getIntExtra("resultCalculated", 0) * multi) {
                        //team 1 won round
                        player1.setRoundsWonSchieber(player1.getRoundsWon() + 1);
                        player2.setRoundsWonSchieber(player2.getRoundsWon() + 1);
                    } else {
                        player3.setRoundsWonSchieber(player3.getRoundsWon() + 1);
                        player4.setRoundsWonSchieber(player4.getRoundsWon() + 1);
                    }
                    player1.setRoundsPlayedSchieber(player1.getRoundsPlayedSchieber() + 1);
                    player2.setRoundsPlayedSchieber(player2.getRoundsPlayedSchieber() + 1);
                    player3.setRoundsPlayedSchieber(player3.getRoundsPlayedSchieber() + 1);
                    player4.setRoundsPlayedSchieber(player4.getRoundsPlayedSchieber() + 1);
                    player1.setPointsMadeSchieber(player1.getPointsMadeSchieber() + data.getIntExtra("resultEntered", 0) * multi);
                    player2.setPointsMadeSchieber(player2.getPointsMadeSchieber() + data.getIntExtra("resultEntered", 0) * multi);
                    player3.setPointsMadeSchieber(player3.getPointsMadeSchieber() + data.getIntExtra("resultCalculated", 0) * multi);
                    player4.setPointsMadeSchieber(player4.getPointsMadeSchieber() + data.getIntExtra("resultCalculated", 0) * multi);
                    player1.setPointsMaxSchieber(player1.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                    player2.setPointsMaxSchieber(player2.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                    player3.setPointsMaxSchieber(player3.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                    player4.setPointsMaxSchieber(player4.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                    RuntimeExceptionDao<Player, Integer> playerDAO = getHelper().getPlayerDao();
                    playerDAO.update(player1);
                    playerDAO.update(player2);
                    playerDAO.update(player3);
                    playerDAO.update(player4);
                    if ((team1 != null) && (team2 != null)) {
                        if (data.getIntExtra("resultEntered", 0) * multi > data.getIntExtra("resultCalculated", 0) * multi) {
                            team1.setRoundsWonSchieber(team1.getRoundsWon() + 1);
                        } else {
                            team2.setRoundsWonSchieber(team2.getRoundsWon() + 1);
                        }
                        team1.setPointsMadeSchieber(team1.getPointsMadeSchieber() + data.getIntExtra("resultEntered", 0) * multi);
                        team2.setPointsMadeSchieber(team2.getPointsMadeSchieber() + data.getIntExtra("resultCalculated", 0) * multi);
                        team1.setRoundsPlayedSchieber(team1.getRoundsPlayedSchieber() + 1);
                        team2.setRoundsPlayedSchieber(team2.getRoundsPlayedSchieber() + 1);
                        team1.setPointsMaxSchieber(team1.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                        team2.setPointsMaxSchieber(team2.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                        RuntimeExceptionDao<Team, Integer> teamDAO = getHelper().getTeamDao();
                        teamDAO.update(team1);
                        teamDAO.update(team2);
                    }

                } else {
                    if (data.getIntExtra("resultEntered", 0) * multi > data.getIntExtra("resultCalculated", 0) * multi) {
                        //team 2 won round
                        player3.setRoundsWonSchieber(player3.getRoundsWon() + 1);
                        player4.setRoundsWonSchieber(player4.getRoundsWon() + 1);
                    } else {
                        player1.setRoundsWonSchieber(player1.getRoundsWon() + 1);
                        player2.setRoundsWonSchieber(player2.getRoundsWon() + 1);
                    }
                    player1.setRoundsPlayedSchieber(player1.getRoundsPlayedSchieber() + 1);
                    player2.setRoundsPlayedSchieber(player2.getRoundsPlayedSchieber() + 1);
                    player3.setRoundsPlayedSchieber(player3.getRoundsPlayedSchieber() + 1);
                    player4.setRoundsPlayedSchieber(player4.getRoundsPlayedSchieber() + 1);
                    player1.setPointsMadeSchieber(player1.getPointsMadeSchieber() + data.getIntExtra("resultCalculated", 0) * multi);
                    player2.setPointsMadeSchieber(player2.getPointsMadeSchieber() + data.getIntExtra("resultCalculated", 0) * multi);
                    player3.setPointsMadeSchieber(player3.getPointsMadeSchieber() + data.getIntExtra("resultEntered", 0) * multi);
                    player4.setPointsMadeSchieber(player4.getPointsMadeSchieber() + data.getIntExtra("resultEntered", 0) * multi);
                    player1.setPointsMaxSchieber(player1.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                    player2.setPointsMaxSchieber(player2.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                    player3.setPointsMaxSchieber(player3.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                    player4.setPointsMaxSchieber(player4.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                    RuntimeExceptionDao<Player, Integer> playerDAO = getHelper().getPlayerDao();
                    playerDAO.update(player1);
                    playerDAO.update(player2);
                    playerDAO.update(player3);
                    playerDAO.update(player4);
                    if ((team1 != null) && (team2 != null)) {
                        if (data.getIntExtra("resultEntered", 0) * multi > data.getIntExtra("resultCalculated", 0) * multi) {
                            team2.setRoundsWonSchieber(team2.getRoundsWon() + 1);
                        } else {
                            team1.setRoundsWonSchieber(team1.getRoundsWon() + 1);
                        }
                        team1.setPointsMadeSchieber(team1.getPointsMadeSchieber() + data.getIntExtra("resultEntered", 0) * multi);
                        team2.setPointsMadeSchieber(team2.getPointsMadeSchieber() + data.getIntExtra("resultCalculated", 0) * multi);
                        team1.setRoundsPlayedSchieber(team1.getRoundsPlayedSchieber() + 1);
                        team2.setRoundsPlayedSchieber(team2.getRoundsPlayedSchieber() + 1);
                        team1.setPointsMaxSchieber(team1.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                        team2.setPointsMaxSchieber(team2.getPointsMaxSchieber() + data.getIntExtra("resultEntered", 0) * multi + data.getIntExtra("resultCalculated", 0) * multi);
                        RuntimeExceptionDao<Team, Integer> teamDAO = getHelper().getTeamDao();
                        teamDAO.update(team1);
                        teamDAO.update(team2);
                    }
                }
            }

            //if maxpoints reached fill games won/played statistics
            if (score_t.getScore() >= 2500) {
                //top team has won :-)
                if ((team1 != null) && (team2 != null)) {
                    team1.setGamesPlayedSchieber(team1.getGamesPlayedSchieber() + 1);
                    team2.setGamesPlayedSchieber(team2.getGamesPlayedSchieber() + 1);
                    team1.setGamesWonSchieber(team1.getGamesWonSchieber() + 1);
                    RuntimeExceptionDao<Team, Integer> teamDAO = getHelper().getTeamDao();
                    teamDAO.update(team1);
                    teamDAO.update(team2);
                }
                player1.setGamesPlayedSchieber(player1.getGamesPlayedSchieber() + 1);
                player2.setGamesPlayedSchieber(player2.getGamesPlayedSchieber() + 1);
                player3.setGamesPlayedSchieber(player3.getGamesPlayedSchieber() + 1);
                player4.setGamesPlayedSchieber(player4.getGamesPlayedSchieber() + 1);
                player1.setGamesWonSchieber(player1.getGamesWonSchieber() + 1);
                player2.setGamesWonSchieber(player2.getGamesWonSchieber() + 1);
                RuntimeExceptionDao<Player, Integer> playerDAO = getHelper().getPlayerDao();
                playerDAO.update(player1);
                playerDAO.update(player2);
                playerDAO.update(player3);
                playerDAO.update(player4);
                Toast.makeText(getApplicationContext(), "Team 1 hat das Spiel gewonnen.", Toast.LENGTH_SHORT).show();
                finish();
            } else if (score_b.getScore() >= 2500) {
                if ((team1 != null) && (team2 != null)) {
                    team1.setGamesPlayedSchieber(team1.getGamesPlayedSchieber() + 1);
                    team2.setGamesPlayedSchieber(team2.getGamesPlayedSchieber() + 1);
                    team2.setGamesWonSchieber(team2.getGamesWonSchieber() + 1);
                    RuntimeExceptionDao<Team, Integer> teamDAO = getHelper().getTeamDao();
                    teamDAO.update(team1);
                    teamDAO.update(team2);
                }
                player1.setGamesPlayedSchieber(player1.getGamesPlayedSchieber() + 1);
                player2.setGamesPlayedSchieber(player2.getGamesPlayedSchieber() + 1);
                player3.setGamesPlayedSchieber(player3.getGamesPlayedSchieber() + 1);
                player4.setGamesPlayedSchieber(player4.getGamesPlayedSchieber() + 1);
                player3.setGamesWonSchieber(player3.getGamesWonSchieber() + 1);
                player4.setGamesWonSchieber(player4.getGamesWonSchieber() + 1);
                RuntimeExceptionDao<Player, Integer> playerDAO = getHelper().getPlayerDao();
                playerDAO.update(player1);
                playerDAO.update(player2);
                playerDAO.update(player3);
                playerDAO.update(player4);
                Toast.makeText(getApplicationContext(), "Team 2 hat das Spiel gewonnen.", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}

