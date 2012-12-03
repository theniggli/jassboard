package ch.zhaw.jassboard.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import ch.zhaw.R;
import ch.zhaw.jassboard.util.DatabaseHelper;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;


/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 11/5/12
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class ViewRanks extends OrmLiteBaseActivity<DatabaseHelper> {
    LinearLayout rankingListLayout;
    RadioButton radioPlayers, radioTeams, radioGameswon, radioRoundswon, radioPointsmade;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewranks);
        rankingListLayout = (LinearLayout) findViewById(R.id.rankinglist);
        radioPlayers = (RadioButton) findViewById(R.id.radio_players);
        radioTeams = (RadioButton) findViewById(R.id.radio_teams);
        radioGameswon = (RadioButton) findViewById(R.id.radio_gameswon);
        radioRoundswon = (RadioButton) findViewById(R.id.radio_roundswon);
        radioPointsmade = (RadioButton) findViewById(R.id.radio_pointsmade);
    }

    public void onRadioButtonClicked(View view) {
        if ((radioPlayers.isChecked() || radioTeams.isChecked()) && (radioGameswon.isChecked() || radioRoundswon.isChecked() || radioPointsmade.isChecked())) {
            //one off the radiobuttons player or team and one off the radiobuttons gameswon,roundswon or pointsmade is selected
            //http://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property
        }
    }
}
