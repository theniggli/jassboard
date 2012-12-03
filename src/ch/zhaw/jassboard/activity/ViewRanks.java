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
    LinearLayout rankingListLayout = (LinearLayout) findViewById(R.id.rankinglist);
    RadioButton radioPlayers = (RadioButton) findViewById(R.id.radio_players);
    RadioButton radioTeams = (RadioButton) findViewById(R.id.radio_teams);
    RadioButton radioGameswon = (RadioButton) findViewById(R.id.radio_gameswon);
    RadioButton radioRoundswon = (RadioButton) findViewById(R.id.radio_roundswon);
    RadioButton radioPointsmade = (RadioButton) findViewById(R.id.radio_pointsmade);


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewranks);
    }

    public void onRadioButtonClicked(View view) {
        if ((radioPlayers.isChecked() || radioTeams.isChecked()) && (radioGameswon.isChecked() || radioRoundswon.isChecked() || radioPointsmade.isChecked())) {
            //one off the radiobuttons player or team and one off the radiobuttons gameswon,roundswon or pointsmade is selected
            //http://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property
        }
    }
}
