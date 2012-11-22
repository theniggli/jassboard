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
    private static final String DATABASE_NAME = "JassBoard2";
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // here we try inserting data in the on-create as a test
        RuntimeExceptionDao<Player, Integer> dao = getPlayerDao();
        // create some entries in the onCreate
        Player simple = new Player("Roger2");
        dao.create(simple);
        simple = new Player("Toni2");
        dao.create(simple);
        simple = new Player("Tobi2");
        dao.create(simple);
        simple = new Player("Michi2");
        dao.create(simple);
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
    public Dao<Player, Integer> getDao() throws SQLException {
        if (simpleDao == null) {
            simpleDao = getDao(Player.class);
        }
        return simpleDao;
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our Player class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Player, Integer> getPlayerDao() {
        if (simpleRuntimeDao == null) {
            simpleRuntimeDao = getRuntimeExceptionDao(Player.class);
        }
        return simpleRuntimeDao;
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        simpleRuntimeDao = null;
    }
}