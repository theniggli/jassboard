package ch.zhaw.jassboard.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import ch.zhaw.jassboard.persist.Player;
import ch.zhaw.jassboard.persist.Team;
import ch.zhaw.jassboard.view.SchieberView;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * TODO describe class
 *
 * @author <a href=mailto:stjepton@students.zhaw.ch>toni</a>
 * @since 12/1/12 8:50 AM
 */

public class SchieberActivity extends JasstafelActivity {
    public static final int DIALOG_CUSTOM_B = 1;
    public static final int DIALOG_CUSTOM_T = 0;
    public static final int DIALOG_EXPLANATION = 4;
    public static final int DIALOG_TOTAL_B = 3;
    public static final int DIALOG_TOTAL_T = 2;
    static final String TAG = "Jasstafel";
    public SchieberView _board;
    protected CheckBox checkbox_complete_b;
    protected CheckBox checkbox_complete_t;
    protected EditText input_custom_b;
    protected EditText input_custom_t;
    protected EditText input_total_b;
    protected EditText input_total_t;
    protected NumberPicker multiplication_b;
    protected NumberPicker multiplication_t;
    private boolean rotateDialogs = true;
//  public SchieberTeam team_b = new SchieberTeam();
//  public SchieberTeam team_t = new SchieberTeam();

    public SchieberActivity() {
//    setActivityId(Dispatcher.schieberTafelId);
    }

    private void showExplanationDialog() {
//    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
//    Bundle localBundle = new Bundle();
//    localBundle.putInt("dialog_type", 4);
//    localBundle.putInt("explanation_ressource", 2130837508);
//    new ExplanationDialog(localBundle).show(localFragmentTransaction, "dialog");
    }

    private void updateRotateDialogsMenuItem(MenuItem paramMenuItem, boolean paramBoolean) {
        if (Build.VERSION.SDK_INT >= 11)
            paramMenuItem.setChecked(paramBoolean);
//    while (true)
//    {
//      return;
//      if (paramBoolean)
//        paramMenuItem.setTitle(getResources().getString(2131034134));
//      else
//        paramMenuItem.setTitle(getResources().getString(2131034131));
//    }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this._board = new SchieberView(this);
        // set the schieberview view to draw the board
        setContentView(this._board);
        Intent intent = getIntent();
//        Integer player1ID = Integer.parseInt(intent.getStringExtra("player1ID")); //if it's a string you stored.
//        Integer player2ID = Integer.parseInt(intent.getStringExtra("player2ID"));
//        Integer player3ID = Integer.parseInt(intent.getStringExtra("player3ID"));
//        Integer player4ID = Integer.parseInt(intent.getStringExtra("player4ID"));
//        Integer team1ID = Integer.parseInt(intent.getStringExtra("team1ID"));
//        Integer team2ID = Integer.parseInt(intent.getStringExtra("team2ID"));
//
//        RuntimeExceptionDao<Player, Integer> playerDAO = getHelper().getPlayerDao();
//        Player player1 = playerDAO.queryForId(player1ID);
//        Player player2 = playerDAO.queryForId(player2ID);
//        Player player3 = playerDAO.queryForId(player3ID);
//        Player player4 = playerDAO.queryForId(player4ID);
//
//        if (team1ID != -1 ){
//            RuntimeExceptionDao<Team, Integer> teamDAO = getHelper().getTeamDao();
//            Team team1 = teamDAO.queryForId(team1ID);
//            Team team2 = teamDAO.queryForId(team2ID);
//        }

//    try
//    {
//      FileInputStream localFileInputStream1 = openFileInput("team_t.data");
//      ObjectInputStream localObjectInputStream1 = new ObjectInputStream(localFileInputStream1);
//      this.team_t = ((SchieberTeam)localObjectInputStream1.readObject());
//      localObjectInputStream1.close();
//      localFileInputStream1.close();
//      FileInputStream localFileInputStream2 = openFileInput("team_b.data");
//      ObjectInputStream localObjectInputStream2 = new ObjectInputStream(localFileInputStream2);
//      this.team_b = ((SchieberTeam)localObjectInputStream2.readObject());
//      localObjectInputStream2.close();
//      localFileInputStream2.close();
//      SharedPreferences localSharedPreferences = getPreferences(0);
//      this.rotateDialogs = localSharedPreferences.getBoolean("rotate_dialogs", true);
//      if (localSharedPreferences.getBoolean("show_explanation", true))
//      {
//        showExplanationDialog();
//        Editor localEditor = localSharedPreferences.edit();
//        localEditor.putBoolean("show_explanation", false);
//        localEditor.commit();
//      }
//      return;
//    }
//    catch (OptionalDataException localOptionalDataException)
//    {
//      while (true)
//        localOptionalDataException.printStackTrace();
//    }
//    catch (ClassNotFoundException localClassNotFoundException)
//    {
//      while (true)
//        localClassNotFoundException.printStackTrace();
//    }
//    catch (IOException localIOException)
//    {
//      while (true)
//        localIOException.printStackTrace();
//    }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
//        getMenuInflater().inflate(2131165185, paramMenu);
//        updateRotateDialogsMenuItem(paramMenu.findItem(2131230759), this.rotateDialogs);
        return true;
    }

    public void onDialogClosed(int paramInt, Bundle paramBundle) {
        System.out.println("dialog closed");
//        int i = paramBundle.getInt("dialog_type");
//        SchieberTeam localSchieberTeam1;
//        SchieberTeam localSchieberTeam2;
//        int k;
//        if ((i == 1) || (i == 0)) {
//            localSchieberTeam1 = null;
//            localSchieberTeam2 = null;
//            int j = paramBundle.getInt("score");
//            k = paramBundle.getInt("multiplicator");
            boolean bool = paramBundle.getBoolean("complete_opponents_score");
//            if (i == 1) {
//                localSchieberTeam1 = this.team_b;
//                localSchieberTeam2 = this.team_t;
//                break label105;
//                label63:
//                if (paramInt != -1)
//                    break label134;
//                localSchieberTeam1.add_score(j * k);
//                if (!bool)
//                    break label125;
//                localSchieberTeam2.add_score(k * (157 - j));
//            }
//        }
//        label105:
//        label247:
//        while (true) {
//            this._board.draw();
//            return;
//            if (i != 0)
//                break label63;
//            localSchieberTeam1 = this.team_t;
//            localSchieberTeam2 = this.team_b;
//            break label63;
//            label125:
//            localSchieberTeam2.add_score(0);
//            continue;
//            if ((paramInt != -2) && (paramInt == -3)) {
//                localSchieberTeam1.add_score(k * 257);
//                localSchieberTeam2.add_score(0);
//                continue;
//                if ((i != 3) && (i != 2))
//                    break;
//                SchieberTeam localSchieberTeam3 = null;
//                SchieberTeam localSchieberTeam4 = null;
//                int m = paramBundle.getInt("score");
//                if (i == 3) {
//                    localSchieberTeam3 = this.team_b;
//                    localSchieberTeam4 = this.team_t;
//                }
//                while (true) {
//                    if (paramInt != -1)
//                        break label247;
//                    localSchieberTeam3.set_score(m);
//                    localSchieberTeam4.add_score(0);
//                    break;
//                    if (i == 2) {
//                        localSchieberTeam3 = this.team_t;
//                        localSchieberTeam4 = this.team_b;
//                    }
//                }
//            }
//        }
//        try {
//            FileInputStream localFileInputStream1 = openFileInput("team_t.data");
//            ObjectInputStream localObjectInputStream1 = new ObjectInputStream(localFileInputStream1);
//            this.team_t = ((SchieberTeam) localObjectInputStream1.readObject());
//            localObjectInputStream1.close();
//            localFileInputStream1.close();
//            FileInputStream localFileInputStream2 = openFileInput("team_b.data");
//            ObjectInputStream localObjectInputStream2 = new ObjectInputStream(localFileInputStream2);
//            this.team_b = ((SchieberTeam) localObjectInputStream2.readObject());
//            localObjectInputStream2.close();
//            localFileInputStream2.close();
//            SharedPreferences localSharedPreferences = getPreferences(0);
//            this.rotateDialogs = localSharedPreferences.getBoolean("rotate_dialogs", true);
//            if (localSharedPreferences.getBoolean("show_explanation", true)) {
//                showExplanationDialog();
//                Editor localEditor = localSharedPreferences.edit();
//                localEditor.putBoolean("show_explanation", false);
//                localEditor.commit();
//            }
//            return;
//        } catch (OptionalDataException localOptionalDataException) {
//            while (true)
//                localOptionalDataException.printStackTrace();
//        } catch (ClassNotFoundException localClassNotFoundException) {
//            while (true)
//                localClassNotFoundException.printStackTrace();
//        } catch (IOException localIOException) {
//            while (true)
//                localIOException.printStackTrace();
//        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
//        boolean bool1 = true;
//        int i = 0;
//        if (!paramMenuItem.hasSubMenu()) {
//            if (paramMenuItem.getItemId() == 2131230758) {
//                this.team_t.set_score(0);
//                this.team_b.set_score(0);
//                i = 1;
//            }
//        } else {
//            if (i == 0)
//                break label199;
//            this._board.draw();
//        }
//        while (true) {
//            return bool1;
//            if (paramMenuItem.getItemId() == 2131230756) {
//                this.team_t.undo();
//                this.team_b.undo();
//                i = 1;
//                break;
//            }
//            if (paramMenuItem.getItemId() == 2131230757) {
//                this.team_t.redo();
//                this.team_b.redo();
//                i = 1;
//                break;
//            }
//            if (paramMenuItem.getItemId() != 2131230759)
//                break;
//            if (this.rotateDialogs) ;
//            for (boolean bool2 = false; ; bool2 = bool1) {
//                this.rotateDialogs = bool2;
//                updateRotateDialogsMenuItem(paramMenuItem, this.rotateDialogs);
//                Editor localEditor = getPreferences(0).edit();
//                localEditor.putBoolean("rotate_dialogs", this.rotateDialogs);
//                localEditor.commit();
//                i = 1;
//                break;
//            }
//            label199:
//            bool1 = super.onOptionsItemSelected(paramMenuItem);
//        }
        return true;
    }

    protected void onPause() {
//        try {
//            this.team_b.shortenList(100);
//            this.team_t.shortenList(100);
//            FileOutputStream localFileOutputStream1 = openFileOutput("team_t.data", 0);
//            ObjectOutputStream localObjectOutputStream1 = new ObjectOutputStream(localFileOutputStream1);
//            localObjectOutputStream1.writeObject(this.team_t);
//            localObjectOutputStream1.close();
//            localFileOutputStream1.close();
//            FileOutputStream localFileOutputStream2 = openFileOutput("team_b.data", 0);
//            ObjectOutputStream localObjectOutputStream2 = new ObjectOutputStream(localFileOutputStream2);
//            localObjectOutputStream2.writeObject(this.team_b);
//            localObjectOutputStream2.close();
//            localFileOutputStream2.close();
            super.onPause();
//            return;
//        } catch (FileNotFoundException localFileNotFoundException) {
//            while (true)
//                localFileNotFoundException.printStackTrace();
//        } catch (IOException localIOException) {
//            while (true)
//                localIOException.printStackTrace();
//        }
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
//    this.jasstafelActivityNavigation.onResume();
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data){
        super.onActivityResult(reqCode, resCode, data);
    }

    public void showCustomDialog(int paramInt) {
        FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
        Bundle localBundle = new Bundle();
        localBundle.putInt("dialog_type", paramInt);
        localBundle.putBoolean("rotate_dialogs", this.rotateDialogs);
        if ((paramInt == 1) || (paramInt == 0)) {
//            new <SchieberAddScoreDialog(getApplicationContext(), localBundle).show(localFragmentTransaction, "dialog");
        }
//        SchieberTeam localSchieberTeam;
//        if ((paramInt == 3) || (paramInt == 2)) {
//            localSchieberTeam = null;
//            if (paramInt != 3)
//                break label112;
//            localSchieberTeam = this.team_b;
//        }
//        while (true) {
//            localBundle.putInt("initial_score", localSchieberTeam.get_total());
//            new SchieberChangeScoreDialog(localBundle).show(localFragmentTransaction, "dialog");
//            break;
//            break;
//            label112:
//            if (paramInt == 2)
//                localSchieberTeam = this.team_t;
//        }
//    }
}}

