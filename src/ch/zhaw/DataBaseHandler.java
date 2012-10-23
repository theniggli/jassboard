package ch.zhaw;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nigglrog
 * Date: 10/22/12
 * Time: 9:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataBaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "jassboard";

    // Contacts table name
    private static final String TABLE_PLAYERS = "players";
    private static final String TABLE_TEAMS = "teams";
    private static final String TABLE_PLAYERTEAMS = "player_teams";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Player
        String CREATE_PLAYER_TABLE = "CREATE TABLE " + TABLE_PLAYERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT)";
        db.execSQL(CREATE_PLAYER_TABLE);

        String CREATE_TEAM_TABLE = "CREATE TABLE " + TABLE_TEAMS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT)";
        db.execSQL(CREATE_TEAM_TABLE);

        String CREATE_TEAMPLAYER_TABLE = "CREATE TABLE " + TABLE_PLAYERTEAMS + "("
                + TABLE_PLAYERS + KEY_ID + "INTEGER ," + TABLE_TEAMS + KEY_ID + "INTEGER)";
        db.execSQL(CREATE_TEAMPLAYER_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        //onCreate(db);
    }

    public ArrayList<Player> getPlayerList() {
        ArrayList<Player> playerArrayList = new ArrayList<Player>();
        Player player1 = new Player(1, "hallo");
        Player player2 = new Player(2, "welt");
        playerArrayList.add(player1)  ;
        playerArrayList.add(player2)  ;
        return playerArrayList;
    }
}