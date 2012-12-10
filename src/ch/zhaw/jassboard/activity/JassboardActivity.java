package ch.zhaw.jassboard.activity;

import android.os.Bundle;
import android.view.MenuItem;
import ch.zhaw.jassboard.util.DatabaseHelper;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

/**
 * Generic Jassboard that implements the basic Activity and Orm functions
 *
 * @author <a href=mailto:stjepton@students.zhaw.ch>toni</a>
 * @since 12/1/12 8:50 AM
 */

public class JassboardActivity extends OrmLiteBaseActivity<DatabaseHelper> {
    private int activityId = -1;

    public JassboardActivity() {
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    public void onDialogClosed(int paramInt, Bundle paramBundle) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        return true;
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void setActivityId(int paramInt) {
        this.activityId = paramInt;
    }

    @Override
    protected void onStop() {
        System.out.println("App stopped");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("App destroyed");
        super.onDestroy();
    }
}