package ch.zhaw.jassboard.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import ch.zhaw.R;


/**
 * Dialog to add the score after each round
 *
 * @author <a href=mailto:stjepton@students.zhaw.ch>toni</a>
 * @since 12/1/12 8:50 AM
 */

public class ScoreDialog extends Activity
{
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
            }
        });
        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                DisplayToast("You have clicked the Save button");
            }
        });
    }

    private void DisplayToast(String msg)
    {
        Toast.makeText(getBaseContext(), msg,
                Toast.LENGTH_SHORT).show();
    }
}