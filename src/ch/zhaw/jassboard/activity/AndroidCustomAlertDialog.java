//package ch.zhaw.jassboard.activity;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.text.InputFilter;
//import android.text.method.DigitsKeyListener;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.*;
//import ch.zhaw.R;
//
///**
// * TODO describe class
// *
// * @author <a href=mailto:stjepton@students.zhaw.ch>toni</a>
// * @since 12/7/12 8:34 AM
// */
//
//public class AndroidCustomAlertDialog extends Activity {
//    Context paramContext;
//
//    public AndroidCustomAlertDialog(Context paramContext) {
//        this.paramContext = paramContext;
//    }
//
//    /**
//     * Called when the activity is first created.
//     */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//    }
//
//    public void displayDialog() {
////        final CharSequence[] calcEnemy = {"Gegner berechnen"};
////        final boolean[] states = {true};
//        AlertDialog.Builder builder = new AlertDialog.Builder(this.paramContext);
//        builder.setTitle("Punkte eingeben");
//
//        TextView textView = new TextView(this.paramContext);
//        textView.setText("Erspielte Punkte");
//        LayoutParams textViewLayoutParams
//                = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        textView.setLayoutParams(textViewLayoutParams);
//
//        ListView modeList = new ListView(this.paramContext);
//        String[] stringArray = new String[] {"Rose", "Eichle", "Schälä", "Schilte", "Obenabe", "Uneufe"};
//        ArrayAdapter<String> modeAdapter = new ArrayAdapter<String>(this.paramContext, android.R.layout.simple_list_item_1, android.R.id.text1, stringArray);
//        modeList.setAdapter(modeAdapter);
//
//        EditText editText = new EditText(this.paramContext);
//        editText.setFilters(new InputFilter[]{
//                // Maximum 4 characters.
//                new InputFilter.LengthFilter(4),
//                // Digits only.
//                DigitsKeyListener.getInstance(),  // Not strictly needed, IMHO.
//        });
//
//        // Digits only & use numeric soft-keyboard.
//        editText.setKeyListener(DigitsKeyListener.getInstance());
//        LayoutParams editTextLayoutParams
//                = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
//        editText.setLayoutParams(editTextLayoutParams);
//
//        LinearLayout layout = new LinearLayout(this.paramContext);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        layout.addView(textView);
//        layout.addView(editText);
//        layout.addView(modeList);
//
//        builder.setView(layout);
//
//
//
////        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
////            // do something when the button is clicked
////            public void onClick(DialogInterface arg0, int arg1) {
////
////            }
////        });
////
////        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
////            // do something when the button is clicked
////            public void onClick(DialogInterface arg0, int arg1) {
////
////            }
////        });
//        builder.show();
//    }
//}
