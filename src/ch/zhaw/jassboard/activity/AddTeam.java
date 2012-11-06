package ch.zhaw.jassboard.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 11/5/12
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */

public class AddTeam extends Activity {
    private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addteam);
    }

    public void addNewTeam(View view) {

    }
}