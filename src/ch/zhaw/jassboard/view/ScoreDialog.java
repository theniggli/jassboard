package ch.zhaw.jassboard.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.RadioGroup.OnCheckedChangeListener;
import ch.zhaw.R;

/**
 * Dialog to add the score after each round
 *
 * @author <a href=mailto:stjepton@students.zhaw.ch>toni</a>
 * @since 12/1/12 8:50 AM
 */

public class ScoreDialog extends Activity
{
    int multi = 0;
    boolean calcOpp = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //set xml-layout
        setContentView(R.layout.scoredialog);
        super.onCreate(savedInstanceState);

        // Checkbox wheter to autocomplete enemy score
        CheckBox checkBox = (CheckBox) findViewById(R.id.chkAutosave);

        checkBox.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                if (((CheckBox)v).isChecked()){
                    DisplayToast("Gegner wird berechnet.");
                    calcOpp = true;
                }
                else{
                    DisplayToast("Gegner wird nicht berechnet.");
                    calcOpp = false;
                }
            }
        });

        // Single select Radio button to choose trump
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rdbGp1);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                ---displays the ID of the RadioButton that is checked---
//                DisplayToast(Integer.toString(checkedId));
                switch (checkedId){
                    case 2131165209:
                        multi = 1;
                        break;
                    case 2131165210:
                        multi = 2;
                        break;
                    case 2131165211:
                        multi = 3;
                        break;
                    case 2131165212:
                        multi = 4;
                        break;
                    case 2131165213:
                        multi = 5;
                        break;
                    case 2131165214:
                        multi = 6;
                        break;
                    default:
                        multi = 0;
                        break;

                }
            }
        });
        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                //get the entered value from the text field
                EditText inText   = (EditText) findViewById(R.id.txtName);
                calcOpp = true;
                int resultat = Integer.valueOf(inText.getText().toString());
                Intent resInt = new Intent();
                resInt.putExtra("multi",multi);
                if (resultat > 257 && calcOpp){
                    resultat = 0;
                    calcOpp = false;
                } else {
                    resInt.putExtra("resultEntered", resultat);
                }
                // check if the points of the opposing team should be calculated
                if (calcOpp){
                    resInt.putExtra("resultCalculated",257 - resultat);
                }else{
                    resInt.putExtra("resultCalculated",0);
                }
                resInt.putExtra("team",getIntent().getStringExtra("team"));
                setResult(Activity.RESULT_OK,resInt);
                finish();
            }
        });
    }

    private void DisplayToast(String msg)
    {
        Toast.makeText(getBaseContext(), msg,
                Toast.LENGTH_SHORT).show();
    }
}