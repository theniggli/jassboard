package ch.zhaw.jassboard.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollView;

public class SchieberAddScoreDialog extends JasstafelDialog
        implements OnClickListener, OnTouchListener {
    private ScrollView dialogScrollview;
    private SchieberActivity parent = null;
    private boolean rotateDialogs;
    private Context context;
    private int type;
    private View view = null;

    public SchieberAddScoreDialog() {
    }

    public SchieberAddScoreDialog(Bundle paramBundle) {
//        super(paramBundle);
    }

    public SchieberAddScoreDialog(Context applicationContext, Bundle localBundle) {
        context = applicationContext;
    }

    private int StringToInt(String paramString) {
        try {
            return Integer.parseInt(paramString);
        } catch (NumberFormatException localNumberFormatException) {
            System.out.println(localNumberFormatException);
            return 0;
        }
    }

    @SuppressLint({"NewApi"})
    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        Bundle localBundle = new Bundle();
//    int i = StringToInt(((TextView)this.view.findViewById(2131230722)).getText().toString());
//    if (Build.VERSION.SDK_INT >= 11);
//    for (int j = ((android.widget.NumberPicker)this.view.findViewById(2131230724)).getValue(); ; j = ((NumberPicker)this.view.findViewById(2131230724)).getCurrent())
//    {
//      Boolean localBoolean = Boolean.valueOf(((CheckBox)this.view.findViewById(2131230725)).isChecked());
//      localBundle.putInt("dialog_type", this.type);
//      localBundle.putInt("score", i);
//      localBundle.putInt("multiplicator", j);
//      localBundle.putBoolean("complete_opponents_score", localBoolean.booleanValue());
//      this.parent.onDialogClosed(paramInt, localBundle);
//      return;
//    }
    }



    //    @SuppressLint({"NewApi"})
    public Dialog onCreateDialog(Bundle paramBundle) {
        this.parent = ((SchieberActivity) getActivity());
//        return viewCategory();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this.parent);
        return alertDialogBuilder.show();
//
//        // set title
////        alertDialogBuilder.setTitle("Your Title");
//        int checked = 0;
//        final String[] trump = {"Rose", "Eichle", "Schälä", "Schilte", "Obenabe", "Uneufe"};
//        Dialog mDialog = new Dialog(this.getActivity());
//        ScrollView sv = new ScrollView(this.getActivity());
//        mDialog.setTitle("Dialog Title.!!!!!!!..");
//        LinearLayout la = new LinearLayout(this.getActivity());
//        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.FILL_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//        );
//        la.setOrientation(LinearLayout.VERTICAL);
//        la.setLayoutParams(new
//                LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT));
//        sv.setLayoutParams(p);
//        sv.setVerticalScrollBarEnabled(true);
//        TextView tView = new TextView(this.getActivity());
//        tView.setText("testing" );
//        tView.setLayoutParams(p);
//        la.addView(tView);
//        Button bt = new Button(this.getActivity());
//        bt.setLayoutParams(p);
//        bt.setText("button");
//        la.addView(bt);
//        sv.addView(la);
//        mDialog.setContentView(sv);
//        return mDialog;
//        alertDialogBuilder
//                .setTitle("Bitte Trumpf wählen!")
//                .setCancelable(false)
//                .setView(this.view)
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // no need to write anything here just implement this interface into this button
//                    }
//                })
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // no need to write anything here just implement this interface into this button
//                    }
//                })
//                .setSingleChoiceItems(trump, checked, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // The 'which' argument contains the index position
//                        // of the selected item
////                        Toast.makeText(getActivity(), trump[1], Toast.LENGTH_SHORT).show();
//                    }
//                });
//        return alertDialogBuilder.show();
//    this.view = getActivity().getLayoutInflater().inflate(2130903040, null);
//    if (Build.VERSION.SDK_INT >= 11)
//    {
//      android.widget.NumberPicker localNumberPicker = (android.widget.NumberPicker)this.view.findViewById(2131230724);
//      localNumberPicker.setMaxValue(10);
//      localNumberPicker.setMinValue(1);
//    }
//    while (true)
//    {
//      AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
//      localBuilder.setTitle(2131034124);
//      localBuilder.setView(this.view);
//      localBuilder.setPositiveButton(2131034121, this);
//      localBuilder.setNeutralButton(2131034123, this);
//      localBuilder.setNegativeButton(2131034122, this);
//      this.dialogScrollview = ((ScrollView)this.view.findViewById(2131230720));
//      this.dialogScrollview.setOnTouchListener(this);
//      if ((this.type == 0) && (this.rotateDialogs))
//        getActivity().setRequestedOrientation(9);
//      return localBuilder.show();
////      ((NumberPicker)this.view.findViewById(2131230724)).setRange(1, 10);
//    }
    }

    public void onLoadData(Bundle paramBundle) {
        super.onLoadData(paramBundle);
        this.type = paramBundle.getInt("dialog_type");
        this.rotateDialogs = paramBundle.getBoolean("rotate_dialogs");
    }

    public void onPause() {
        super.onPause();
        if (this.rotateDialogs)
            getActivity().setRequestedOrientation(1);
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        if (paramView.getId() == 2131230720)
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.dialogScrollview.getWindowToken(), 0);
        return true;
    }
}