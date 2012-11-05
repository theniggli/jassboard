package ch.zhaw.jassboard.persist;

import android.content.Context;
import android.database.Cursor;
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
    //Database Name
    private static final String DATABASE_NAME = "jassboard";
    private static final int DATABASE_VERSION = 1;

    //table Players
    private static final String TABLE_PLAYERS = "players";
    private static final String PLAYER_ID = "id";
    private static final String PLAYER_NAME = "name";
    private static final String PLAYER_GAMES_PLAYED_SCHIEBER = "GPS";
    private static final String PLAYER_GAMES_PLAYED_COIFFEUR = "GPC";
    private static final String PLAYER_GAMES_PLAYED_DIFFERENZER = "GPD";
    private static final String PLAYER_GAMES_WON_SCHIEBER = "GWS";
    private static final String PLAYER_GAMES_WON_COIFFEUR = "GWC";
    private static final String PLAYER_GAMES_WON_DIFFERENZER = "GWD";

    //table Teams
    private static final String TABLE_TEAMS = "teams";
    private static final String TEAM_ID = "id";
    private static final String TEAM_NAME = "name";
    private static final String TEAM_GAMES_PLAYED_SCHIEBER = "TPS";
    private static final String TEAM_GAMES_PLAYED_COIFFEUR = "TPC";
    private static final String TEAM_GAMES_PLAYED_DIFFERENZER = "TPD";
    private static final String TEAM_GAMES_WON_SCHIEBER = "TWS";
    private static final String TEAM_GAMES_WON_COIFFEUR = "TWC";
    private static final String TEAM_GAMES_WON_DIFFERENZER = "TWD";

    //table player_teams
    private static final String TABLE_PLAYERTEAMS = "player_teams";


    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Player
        String CREATE_PLAYER_TABLE = "CREATE TABLE " + TABLE_PLAYERS + "("
                + PLAYER_ID + " INTEGER PRIMARY KEY," + PLAYER_NAME + " TEXT," + PLAYER_GAMES_PLAYED_SCHIEBER + " INTEGER," + PLAYER_GAMES_PLAYED_COIFFEUR + " INTEGER," + PLAYER_GAMES_PLAYED_DIFFERENZER + " INTEGER," + PLAYER_GAMES_WON_SCHIEBER + " INTEGER," + PLAYER_GAMES_WON_COIFFEUR + " INTEGER," + PLAYER_GAMES_WON_DIFFERENZER + " INTEGER)";
        db.execSQL(CREATE_PLAYER_TABLE);

        String CREATE_TEAM_TABLE = "CREATE TABLE " + TABLE_TEAMS + "("
                + TEAM_ID + " INTEGER PRIMARY KEY," + TEAM_NAME + " TEXT," + TEAM_GAMES_PLAYED_SCHIEBER + " INTEGER," + TEAM_GAMES_PLAYED_COIFFEUR + " INTEGER," + TEAM_GAMES_PLAYED_DIFFERENZER + " INTEGER," + TEAM_GAMES_WON_SCHIEBER + " INTEGER," + TEAM_GAMES_WON_COIFFEUR + " INTEGER," + TEAM_GAMES_WON_DIFFERENZER + " INTEGER)";
        db.execSQL(CREATE_TEAM_TABLE);

        String CREATE_TEAMPLAYER_TABLE = "CREATE TABLE " + TABLE_PLAYERTEAMS + "("
                + TABLE_PLAYERS + PLAYER_ID + "INTEGER ," + TABLE_TEAMS + TEAM_ID + "INTEGER)";
        db.execSQL(CREATE_TEAMPLAYER_TABLE);
        createDummyEntries(db);
    }

    public void createDummyEntries(SQLiteDatabase db) {
        String CREATE_DUMMY_PLAYER;
        CREATE_DUMMY_PLAYER = "insert into " + TABLE_PLAYERS + "(" + PLAYER_ID + "," + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + ") values (1, 'Roger',10,10,10,10,10,10)";
        db.execSQL(CREATE_DUMMY_PLAYER);
        CREATE_DUMMY_PLAYER = "insert into " + TABLE_PLAYERS + "(" + PLAYER_ID + "," + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + ") values (2, 'Toni',10,10,10,0,0,0)";
        db.execSQL(CREATE_DUMMY_PLAYER);
        CREATE_DUMMY_PLAYER = "insert into " + TABLE_PLAYERS + "(" + PLAYER_ID + "," + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + ") values (3, 'Tobi',10,10,10,0,0,0)";
        db.execSQL(CREATE_DUMMY_PLAYER);
        CREATE_DUMMY_PLAYER = "insert into " + TABLE_PLAYERS + "(" + PLAYER_ID + "," + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + ") values (4, 'Michi',10,10,10,0,0,0)";
        db.execSQL(CREATE_DUMMY_PLAYER);

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
        String selectQuery = "SELECT " + PLAYER_ID + "," + PLAYER_NAME + " FROM " + TABLE_PLAYERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Player player = new Player();
                player.setPlayerID(Integer.parseInt(cursor.getString(0)));
                player.setPlayerName(cursor.getString(1));
                playerArrayList.add(player);
            } while (cursor.moveToNext());
        }
        return playerArrayList;
    }

    public ArrayList<Team> getTeamList() {
        ArrayList<Team> teamListArray = new ArrayList<Team>();

        return teamListArray;
    }
}