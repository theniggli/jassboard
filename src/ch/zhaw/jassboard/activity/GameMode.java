package ch.zhaw.jassboard.activity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import ch.zhaw.R;
import android.os.Bundle;
import ch.zhaw.jassboard.util.DatabaseHelper;
import ch.zhaw.jassboard.view.PlayerListView;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;


/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:24 AM
 * To change this template use File | Settings | File Templates.
 */

public class GameMode extends OrmLiteBaseActivity<DatabaseHelper> {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamemode);

        final Spinner spinnerPlayer1 = (Spinner) findViewById(R.id.gamemodespinner);
        spinnerPlayer1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int gamemode = spinnerPlayer1.getSelectedItemPosition();
                LinearLayout gameModeSchieber = (LinearLayout) findViewById(R.id.gamemodeschieber);
                LinearLayout gameModewFourPlayers = (LinearLayout) findViewById(R.id.fourplayerselection);
                LinearLayout gameModewTwoTeams = (LinearLayout) findViewById(R.id.twoteamselection);

                if (gamemode == 0) {
//                    Schieber
                    gameModeSchieber.setVisibility(LinearLayout.VISIBLE);
                    onRadioButtonClicked(findViewById(R.id.radio_teams));
                } else if (gamemode == 1) {
//                    Coiffeur
                    gameModeSchieber.setVisibility(LinearLayout.GONE);
                    gameModewFourPlayers.setVisibility(LinearLayout.VISIBLE);
                    gameModewTwoTeams.setVisibility(LinearLayout.GONE);
                } else if (gamemode == 2) {
//                    Differenzler
                    gameModeSchieber.setVisibility(LinearLayout.GONE);
                    gameModewFourPlayers.setVisibility(LinearLayout.VISIBLE);
                    gameModewTwoTeams.setVisibility(LinearLayout.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        LinearLayout gameModewFourPlayers = (LinearLayout) findViewById(R.id.fourplayerselection);
        LinearLayout gameModewTwoTeams = (LinearLayout) findViewById(R.id.twoteamselection);

        switch (view.getId()) {
            case R.id.radio_players:
                if (checked) {
                    gameModewTwoTeams.setVisibility(LinearLayout.GONE);
                    gameModewFourPlayers.setVisibility(LinearLayout.VISIBLE);
                }
                break;
            case R.id.radio_teams:
                if (checked) {
                    gameModewTwoTeams.setVisibility(LinearLayout.VISIBLE);
                    gameModewFourPlayers.setVisibility(LinearLayout.GONE);
                }
                break;
        }
    }
}
