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
                LinearLayout gameModeCoiffeur = (LinearLayout) findViewById(R.id.gamemodecoiffeur);
                LinearLayout gameModeDifferenzler = (LinearLayout) findViewById(R.id.gamemodedifferenzler);

                if (gamemode == 0) {
//                    Schieber
                    gameModeSchieber.setVisibility(0);
                    gameModeCoiffeur.setVisibility(1);
                    gameModeDifferenzler.setVisibility(1);
                } else if (gamemode == 1) {
//                    Coiffeur
                    gameModeSchieber.setVisibility(1);
                    gameModeCoiffeur.setVisibility(0);
                    gameModeDifferenzler.setVisibility(1);
                } else if (gamemode == 2) {
//                    Differenzler
                    gameModeSchieber.setVisibility(1);
                    gameModeCoiffeur.setVisibility(1);
                    gameModeDifferenzler.setVisibility(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


    }
}
