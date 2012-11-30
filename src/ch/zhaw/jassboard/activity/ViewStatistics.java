package ch.zhaw.jassboard.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
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
public class ViewStatistics extends OrmLiteBaseActivity<DatabaseHelper> {

    LinearLayout teamStatistics = (LinearLayout) findViewById(R.id.teamstatistics);
    LinearLayout playerStatistics = (LinearLayout) findViewById(R.id.playertatistics);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewstatistics);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_players:
                if (checked) {
                    teamStatistics.setVisibility(LinearLayout.GONE);
                    playerStatistics.setVisibility(LinearLayout.VISIBLE);

                }
                break;
            case R.id.radio_teams:
                if (checked) {
                    teamStatistics.setVisibility(LinearLayout.VISIBLE);
                    playerStatistics.setVisibility(LinearLayout.GONE);
                }
                break;
        }
    }

}
