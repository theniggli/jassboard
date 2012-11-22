package ch.zhaw.jassboard.persist;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import ch.zhaw.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/13/12
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */


/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAODatabaseHelpers used by the other classes.  DatabaseHelper2
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "JassBoard5";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    // the DAO object we use to access the Player table
    private Dao simpleDao = null;
    private RuntimeExceptionDao<Player, Integer> simpleRuntimeDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Player.class);
            TableUtils.createTable(connectionSource, Team.class);
            TableUtils.createTable(connectionSource, PlayerTeam.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Dao<Team, Integer> teamDao = getTeamDao();
            Team team = new Team("TeamJongIl");
            teamDao.create(team);
            team = new Team("TeamMao");
            teamDao.create(team);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Dao<Player, Integer> playerDao = getPlayerDao();
            Player player = new Player("Roger");
            playerDao.create(player);
            player = new Player("Toni");
            playerDao.create(player);
            player = new Player("Tobi");
            playerDao.create(player);
            player = new Player("Michi");
            playerDao.create(player);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Dao<PlayerTeam, Integer> teamPlayerDao = getPlayerTeamDao();
            PlayerTeam teamPlayer = new PlayerTeam(1,1);
            teamPlayerDao.create(teamPlayer);
            teamPlayer = new PlayerTeam(2,1);
            teamPlayerDao.create(teamPlayer);
            teamPlayer = new PlayerTeam(3,2);
            teamPlayerDao.create(teamPlayer);
            teamPlayer = new PlayerTeam(4,2);
            teamPlayerDao.create(teamPlayer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Player.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the Database Access Object (DAO) for our Player class. It will create it or just give the cached
     * value.
     */
    public Dao<Player, Integer> getPlayerDao() throws SQLException {
        if (simpleDao == null) {
            simpleDao = getDao(Player.class);
        }
        return simpleDao;
    }

    public Dao<Team, Integer> getTeamDao() throws SQLException {

        if (simpleDao == null) {
            simpleDao = getDao(Team.class);
        }
        return simpleDao;
    }

    public Dao<PlayerTeam, Integer> getPlayerTeamDao() throws SQLException {

        if (simpleDao == null) {
            simpleDao = getDao(PlayerTeam.class);
        }
        return simpleDao;
    }
    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our Player class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        simpleRuntimeDao = null;
    }
}