package ch.zhaw.jassboard.activity;

import android.app.Activity;
import android.os.Bundle;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.DataBaseHandler;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 11/5/12
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */

public class AddPlayer  extends Activity {
    private DataBaseHandler dbH = new DataBaseHandler(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addplayer);
    }
}