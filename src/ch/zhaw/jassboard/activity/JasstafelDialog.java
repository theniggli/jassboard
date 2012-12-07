package ch.zhaw.jassboard.activity;

import android.app.DialogFragment;
import android.os.Bundle;

public class JasstafelDialog extends DialogFragment
{
  private Bundle constructorBundle = null;
  private boolean dataLoaded = false;

  public JasstafelDialog()
  {
  }

  public JasstafelDialog(Bundle paramBundle)
  {
    onLoadData(paramBundle);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((!this.dataLoaded) && (paramBundle != null))
      onLoadData(paramBundle.getBundle("contructor_bundle"));
  }

  public void onLoadData(Bundle paramBundle)
  {
    this.constructorBundle = paramBundle;
    this.dataLoaded = true;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBundle("contructor_bundle", this.constructorBundle);
  }

  public void onStop()
  {
    super.onStop();
  }
}