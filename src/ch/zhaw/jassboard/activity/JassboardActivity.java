package ch.zhaw.jassboard.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import ch.zhaw.jassboard.util.DatabaseHelper;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import junit.framework.Assert;

/**
 * TODO describe class
 *
 * @author <a href=mailto:stjepton@students.zhaw.ch>toni</a>
 * @since 12/1/12 8:50 AM
 */

public class JassboardActivity extends OrmLiteBaseActivity<DatabaseHelper> {
    private int activityId = -1;
//  JasstafelActivityNavigation jasstafelActivityNavigation;

    public JassboardActivity() {
        if (Build.VERSION.SDK_INT >= 11) ;
//    for (this.jasstafelActivityNavigation = new JasstafelActionBar(this); ; this.jasstafelActivityNavigation = new JasstafelMenuActivityNavigation(this))
//      return;
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (this.activityId != -1) ;
        for (boolean bool = true; ; bool = false) {
            Assert.assertTrue(bool);
//      this.jasstafelActivityNavigation.setup(this.activityId);
            return;
        }
    }

    public void onDialogClosed(int paramInt, Bundle paramBundle) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
//    if (paramMenuItem.getItemId() == 2131230760)
//      this.jasstafelActivityNavigation.onItemSelected(Dispatcher.coiffeurTafelId);
//    while (true)
//    {
//      return super.onOptionsItemSelected(paramMenuItem);
//      if (paramMenuItem.getItemId() == 2131230755)
//        this.jasstafelActivityNavigation.onItemSelected(Dispatcher.schieberTafelId);
//    }
        return true;
    }

    protected void onPause() {
        super.onPause();
//    this.jasstafelActivityNavigation.onPause();
    }

    protected void onResume() {
        super.onResume();
//    this.jasstafelActivityNavigation.onResume();
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
        System.out.println("App destoryed");

        super.onDestroy();
    }
}