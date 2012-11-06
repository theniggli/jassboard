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
    private static final int DATABASE_VERSION = 6;

    //table Players
    private static final String TABLE_PLAYERS = "players";
    private static final String PLAYER_ID = "players";
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
    //  private static final String TEAM_GAMES_PLAYED_COIFFEUR = "TPC";
    //  private static final String TEAM_GAMES_PLAYED_DIFFERENZER = "TPD";
    private static final String TEAM_GAMES_WON_SCHIEBER = "TWS";
    //  private static final String TEAM_GAMES_WON_COIFFEUR = "TWC";
    //  private static final String TEAM_GAMES_WON_DIFFERENZER = "TWD";

    //table player_teams
    private static final String TABLE_PLAYERTEAMS = "player_teams";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create Player
        String CREATE_PLAYER_TABLE = "CREATE TABLE " + TABLE_PLAYERS + "(" + PLAYER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + PLAYER_NAME + " TEXT," + PLAYER_GAMES_PLAYED_SCHIEBER + " INTEGER," + PLAYER_GAMES_PLAYED_COIFFEUR + " INTEGER," + PLAYER_GAMES_PLAYED_DIFFERENZER + " INTEGER," + PLAYER_GAMES_WON_SCHIEBER + " INTEGER," + PLAYER_GAMES_WON_COIFFEUR + " INTEGER," + PLAYER_GAMES_WON_DIFFERENZER + " INTEGER)";
        db.execSQL(CREATE_PLAYER_TABLE);
        String CREATE_TEAM_TABLE = "CREATE TABLE " + TABLE_TEAMS + "(" + TEAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TEAM_NAME + " TEXT," + TEAM_GAMES_PLAYED_SCHIEBER + " INTEGER," + TEAM_GAMES_WON_SCHIEBER + " INTEGER)";
        db.execSQL(CREATE_TEAM_TABLE);
        String CREATE_TEAMPLAYER_TABLE = "CREATE TABLE " + TABLE_PLAYERTEAMS + "(" + TABLE_PLAYERS + "_" + PLAYER_ID + " INTEGER ," + TABLE_TEAMS + "_" + TEAM_ID + " INTEGER)";
        db.execSQL(CREATE_TEAMPLAYER_TABLE);
        createDummyEntries(db);
    }

    public void createDummyEntries(SQLiteDatabase db) {
        String CREATE_DUMMY_ENTRY;
        CREATE_DUMMY_ENTRY = "insert into " + TABLE_PLAYERS + "(" + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + ") values ('Roger',10,10,10,10,10,10)";
        db.execSQL(CREATE_DUMMY_ENTRY);
        CREATE_DUMMY_ENTRY = "insert into " + TABLE_PLAYERS + "(" + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + ") values ('Toni',10,10,10,0,0,0)";
        db.execSQL(CREATE_DUMMY_ENTRY);
        CREATE_DUMMY_ENTRY = "insert into " + TABLE_PLAYERS + "(" + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + ") values ('Tobi',10,10,10,0,0,0)";
        db.execSQL(CREATE_DUMMY_ENTRY);
        CREATE_DUMMY_ENTRY = "insert into " + TABLE_PLAYERS + "(" + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + ") values ('Michi',10,10,10,0,0,0)";
        db.execSQL(CREATE_DUMMY_ENTRY);
        CREATE_DUMMY_ENTRY = "insert into " + TABLE_TEAMS + "(" + TEAM_NAME + "," + TEAM_GAMES_PLAYED_SCHIEBER + "," + TEAM_GAMES_WON_SCHIEBER + ") values ('TeamAlpha',0,0)";
        db.execSQL(CREATE_DUMMY_ENTRY);
        CREATE_DUMMY_ENTRY = "insert into " + TABLE_PLAYERTEAMS + "(" + TABLE_PLAYERS + "_" + PLAYER_ID + "," + TABLE_TEAMS + "_" + TEAM_ID + ") values (1,1)";
        db.execSQL(CREATE_DUMMY_ENTRY);
        CREATE_DUMMY_ENTRY = "insert into " + TABLE_PLAYERTEAMS + "(" + TABLE_PLAYERS + "_" + PLAYER_ID + "," + TABLE_TEAMS + "_" + TEAM_ID + ") values (2,1)";
        db.execSQL(CREATE_DUMMY_ENTRY);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEAMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERTEAMS);
        // Create tables again
        onCreate(db);
    }

    public ArrayList<Player> getPlayerListFull() {
        ArrayList<Player> playerArrayList = new ArrayList<Player>();
        String selectQuery = "SELECT " + PLAYER_ID + "," + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + " FROM " + TABLE_PLAYERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Player player = new Player(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)));
                playerArrayList.add(player);
            } while (cursor.moveToNext());
        }
        return playerArrayList;
    }

    public ArrayList<Player> getPlayerList() {
        ArrayList<Player> playerArrayList = new ArrayList<Player>();
        String selectQuery = "SELECT " + PLAYER_ID + "," + PLAYER_NAME + " FROM " + TABLE_PLAYERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Player player = new Player(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
                playerArrayList.add(player);
            } while (cursor.moveToNext());
        }
        return playerArrayList;
    }

    public Player getPlayer(int playerID) {
        String selectQuery = "SELECT " + PLAYER_ID + "," + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + " FROM " + TABLE_PLAYERS + " WHERE " + PLAYER_ID + "=" + playerID;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Player player = new Player(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)));
        return player;
    }

    public ArrayList<String> getPlayerAL(int playerID) {
        String selectQuery = "SELECT " + PLAYER_ID + "," + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + " FROM " + TABLE_PLAYERS + " WHERE " + PLAYER_ID + "=" + playerID;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<String> playerAL = new ArrayList<String>();

        if (cursor.moveToFirst()) {
            do {
                playerAL.add("PlayerID: " + cursor.getString(0));
                playerAL.add("PlayerName: " + cursor.getString(1));
                playerAL.add("GPS: " + cursor.getString(2));
                playerAL.add("GPC: " + cursor.getString(3));
                playerAL.add("GPD: " + cursor.getString(4));
                playerAL.add("GWS: " + cursor.getString(5));
                playerAL.add("GWC: " + cursor.getString(6));
                playerAL.add("GWD: " + cursor.getString(7));

            } while (cursor.moveToNext());
        }
        return playerAL;
    }

    public ArrayList<String> getTeamAL(int teamID) {
        String selectQuery = "SELECT " + TEAM_ID + "," + TEAM_NAME + "," + TEAM_GAMES_PLAYED_SCHIEBER + "," + TEAM_GAMES_WON_SCHIEBER + " FROM " + TABLE_TEAMS + " WHERE " + TEAM_ID + "=" + teamID;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<String> teamAL = new ArrayList<String>();

        if (cursor.moveToFirst()) {
            do {
                teamAL.add("TeamID: " + cursor.getString(0));
                teamAL.add("TeamName: " + cursor.getString(1));
                teamAL.add("GPS: " + cursor.getString(2));
                teamAL.add("GWS: " + cursor.getString(3));

            } while (cursor.moveToNext());
        }
        return teamAL;
    }

    public ArrayList<Team> getTeamList() {
        ArrayList<Team> teamArrayList = new ArrayList<Team>();
        String selectQuery = "SELECT " + TEAM_ID + "," + TEAM_NAME + "," + TEAM_GAMES_PLAYED_SCHIEBER + "," + TEAM_GAMES_WON_SCHIEBER + " FROM " + TABLE_TEAMS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Team team;
        if (cursor.moveToFirst()) {
            do {
                team = new Team(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)));
                teamArrayList.add(team);
            } while (cursor.moveToNext());
        }
        return teamArrayList;
    }

    public boolean addPlayer(String playerName) {
        //check if playername exists
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlQuery = "SELECT 1 FROM " + TABLE_PLAYERS + " WHERE " + PLAYER_NAME + "='" + playerName + "'";
        Cursor cursor = db.rawQuery(sqlQuery, null);
        if (cursor.getCount() == 0) {
            sqlQuery = "insert into " + TABLE_PLAYERS + "(" + PLAYER_NAME + "," + PLAYER_GAMES_PLAYED_SCHIEBER + "," + PLAYER_GAMES_PLAYED_COIFFEUR + "," + PLAYER_GAMES_PLAYED_DIFFERENZER + "," + PLAYER_GAMES_WON_SCHIEBER + "," + PLAYER_GAMES_WON_COIFFEUR + "," + PLAYER_GAMES_WON_DIFFERENZER + ") values ('" + playerName + "',0,0,0,0,0,0)";
            db.execSQL(sqlQuery);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Player> getTeamPlayers(Integer teamID) {
        //ony PlayerName and PlayerID
        ArrayList<Player> playerArrayList = new ArrayList<Player>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlQuery = "SELECT " + PLAYER_ID + "," + PLAYER_NAME + " FROM " + TABLE_PLAYERTEAMS + "," + TABLE_PLAYERS + " WHERE " + TABLE_TEAMS + "_" + TEAM_ID + "=" + teamID + " AND " + TABLE_PLAYERS + "_" + PLAYER_ID + "=" + PLAYER_ID;

        Cursor cursor = db.rawQuery(sqlQuery, null);
        Player player;
        if (cursor.moveToFirst()) {
            do {
                player = new Player(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
                playerArrayList.add(player);
            } while (cursor.moveToNext());
        }
        return playerArrayList;
    }

    public ArrayList<String> getplayerIDnName() {
        //ony PlayerName and PlayerID
        ArrayList<String> playerArrayList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlQuery = "SELECT " + PLAYER_ID + "," + PLAYER_NAME + " FROM " + TABLE_PLAYERS;

        Cursor cursor = db.rawQuery(sqlQuery, null);
        if (cursor.moveToFirst()) {
            do {
                playerArrayList.add(cursor.getString(1) + " - " + Integer.parseInt(cursor.getString(0)) + "");
            } while (cursor.moveToNext());
        }
        return playerArrayList;
    }

    public boolean playerExists(Integer playerID) {
        ArrayList<Player> playerArrayList = new ArrayList<Player>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlQuery = "SELECT 1 FROM " + TABLE_PLAYERS + " WHERE " + PLAYER_ID + "=" + playerID;
        Cursor cursor = db.rawQuery(sqlQuery, null);
        if (cursor.getCount() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addTeam(String teamName, int player1_id, int player2_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlQuery = "SELECT 1 FROM " + TABLE_TEAMS + " WHERE " + TEAM_NAME + "='" + teamName + "'";
        Cursor cursor = db.rawQuery(sqlQuery, null);
        if (cursor.getCount() == 0) {
            sqlQuery = "insert into " + TABLE_TEAMS + "(" + TEAM_NAME + "," + TEAM_GAMES_PLAYED_SCHIEBER + "," + TEAM_GAMES_WON_SCHIEBER + ") values ('" + teamName + "',0,0)";
            db.execSQL(sqlQuery);
            sqlQuery = "SELECT " + TEAM_ID + " FROM " + TABLE_TEAMS + " WHERE " + TEAM_NAME + "='" + teamName + "'";
            cursor = db.rawQuery(sqlQuery, null);
            cursor.moveToFirst();
            Integer teamID = Integer.parseInt(cursor.getString(0));
            sqlQuery = "insert into " + TABLE_PLAYERTEAMS + "(" + TABLE_PLAYERS + "_" + PLAYER_ID + "," + TABLE_TEAMS + "_" + TEAM_ID + ") values (" + player1_id + "," + teamID + ")";
            db.execSQL(sqlQuery);
            sqlQuery = "insert into " + TABLE_PLAYERTEAMS + "(" + TABLE_PLAYERS + "_" + PLAYER_ID + "," + TABLE_TEAMS + "_" + TEAM_ID + ") values (" + player2_id + "," + teamID + ")";
            db.execSQL(sqlQuery);
            return true;
        } else {
            return false;
        }
    }
}