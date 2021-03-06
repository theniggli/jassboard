package ch.zhaw.jassboard.util;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.persist.PlayerTeam;
import ch.zhaw.jassboard.persist.Team;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Utilityclass
 * This class provides the connection to the Database
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "JassBoard";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 3;

    private RuntimeExceptionDao<Player, Integer> playerRuntimeDao = null;
    private RuntimeExceptionDao<Team, Integer> teamRuntimeDao = null;
    private RuntimeExceptionDao<PlayerTeam, Integer> playerTeamRuntimeDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Player.class);
            TableUtils.createTable(connectionSource, Team.class);
            TableUtils.createTable(connectionSource, PlayerTeam.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //--------------------------------------------------------------------------------------
        //insert dummy Values
        //--------------------------------------------------------------------------------------
        RuntimeExceptionDao<Team, Integer> teamDao = getTeamDao();
        Team team = new Team("TeamJongIl");
        teamDao.create(team);
        team = new Team("TeamMao");
        teamDao.create(team);

        RuntimeExceptionDao<Player, Integer> playerDao = getPlayerDao();
        Player player = new Player("Roger");
        playerDao.create(player);
        player = new Player("Toni");
        playerDao.create(player);
        player = new Player("Tobi");
        playerDao.create(player);
        player = new Player("Michi");
        playerDao.create(player);

        RuntimeExceptionDao<PlayerTeam, Integer> teamPlayerDao = getPlayerTeamDao();
        PlayerTeam teamPlayer = new PlayerTeam(1, 1);
        teamPlayerDao.create(teamPlayer);
        teamPlayer = new PlayerTeam(2, 1);
        teamPlayerDao.create(teamPlayer);
        teamPlayer = new PlayerTeam(3, 2);
        teamPlayerDao.create(teamPlayer);
        teamPlayer = new PlayerTeam(4, 2);
        teamPlayerDao.create(teamPlayer);
        //--------------------------------------------------------------------------------------
        //insert dummy Values END
        //--------------------------------------------------------------------------------------
    }

    /*
    *  Called on Upgrade
    */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Player.class, true);
            TableUtils.dropTable(connectionSource, Team.class, true);
            TableUtils.dropTable(connectionSource, PlayerTeam.class, true);

            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    *  RuntimeExceptionDao for Player
    */
    public RuntimeExceptionDao<Player, Integer> getPlayerDao() {
        if (playerRuntimeDao == null) {
            playerRuntimeDao = getRuntimeExceptionDao(Player.class);
        }
        return playerRuntimeDao;
    }

    /*
    *  RuntimeExceptionDao for Team
    */
    public RuntimeExceptionDao<Team, Integer> getTeamDao() {
        if (teamRuntimeDao == null) {
            teamRuntimeDao = getRuntimeExceptionDao(Team.class);
        }
        return teamRuntimeDao;
    }

    /*
    *  RuntimeExceptionDao for PlayerTeam
    */
    public RuntimeExceptionDao<PlayerTeam, Integer> getPlayerTeamDao() {
        if (playerTeamRuntimeDao == null) {
            playerTeamRuntimeDao = getRuntimeExceptionDao(PlayerTeam.class);
        }
        return playerTeamRuntimeDao;
    }

    /*
    *  close everything
    */
    @Override
    public void close() {
        super.close();
        playerRuntimeDao = null;
        teamRuntimeDao = null;
        playerTeamRuntimeDao = null;
    }
}