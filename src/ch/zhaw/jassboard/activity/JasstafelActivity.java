package ch.zhaw.jassboard.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import junit.framework.Assert;

/**
 * TODO describe class
 *
 * @author <a href=mailto:stjepton@students.zhaw.ch>toni</a>
 * @since 12/1/12 8:50 AM
 */

public class JasstafelActivity extends Activity
{
  private int activityId = -1;
//  JasstafelActivityNavigation jasstafelActivityNavigation;

  public JasstafelActivity()
  {
    if (Build.VERSION.SDK_INT >= 11);
//    for (this.jasstafelActivityNavigation = new JasstafelActionBar(this); ; this.jasstafelActivityNavigation = new JasstafelMenuActivityNavigation(this))
//      return;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.activityId != -1);
    for (boolean bool = true; ; bool = false)
    {
      Assert.assertTrue(bool);
//      this.jasstafelActivityNavigation.setup(this.activityId);
      return;
    }
  }

  public void onDialogClosed(int paramInt, Bundle paramBundle)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
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

  protected void onPause()
  {
    super.onPause();
//    this.jasstafelActivityNavigation.onPause();
  }

  protected void onResume()
  {
    super.onResume();
//    this.jasstafelActivityNavigation.onResume();
  }

  protected void setActivityId(int paramInt)
  {
    this.activityId = paramInt;
  }
}

/* Location:           test.jasstafel_2.0.1_dex2jar.jar
 * Qualified Name:     test.jasstafel.JasstafelActivity
 * JD-Core Version:    0.6.1
 */