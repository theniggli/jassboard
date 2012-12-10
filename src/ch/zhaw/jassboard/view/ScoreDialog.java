package ch.zhaw.jassboard.view;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.RadioGroup.OnCheckedChangeListener;
import ch.zhaw.R;
import ch.zhaw.jassboard.persist.GlobalContext;

/**
 * Dialog to add the score after each round
 *
 * @author <a href=mailto:stjepton@students.zhaw.ch>toni</a>
 * @since 12/1/12 8:50 AM
 */

public class ScoreDialog extends Activity
{
    int multi = 0;
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
                if (((CheckBox)v).isChecked())
                    DisplayToast("Gegner wird berechnet.");
                else
                    DisplayToast("Gegner wird nicht berechnet.");
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
                DisplayToast("You have clicked the Save button");
                //277457
                EditText inText   = (EditText) findViewById(R.id.txtName);
               /* GlobalContext gc = (GlobalContext) getApplication();
                gc.setResult(Integer.valueOf(inText.getText().toString()));
                gc.setMultiplier(multi);
                */
                Intent resInt = new Intent();
                resInt.putExtra("multi",multi);
                resInt.putExtra("result",Integer.valueOf(inText.getText().toString()));
                resInt.putExtra("team",getIntent().getStringExtra("team"));
                setResult(0,resInt);



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