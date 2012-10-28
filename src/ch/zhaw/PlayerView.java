package ch.zhaw;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 28.10.12
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
public class PlayerView extends LinearLayout {


    private TextView mName, mId;

    public PlayerView(Context context, Player contact) {
        super(context);
        this.setOrientation(VERTICAL);
        mName = new TextView(context);
        mId = new TextView(context);

        String name = contact.getName();
        mName.setText("Name: " + name);
        mName.setTextSize(19);
        mName.setTextColor(Color.GREEN);
        mName.setTypeface(Typeface.SANS_SERIF);

        Integer id = contact.getId();
        mId.setText("Id: " + contact.getId());
        mId.setTextSize(14);
        mId.setTypeface(Typeface.SANS_SERIF);

        addView(mName, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(mId, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }

    public String getNameText() {
        return mName.getText().toString();
    }

    public String getIdText() {
        return mId.getText().toString();
    }

    public void setNameText(String name) {
        mName.setText("Name: " + name);
    }

    public void setIdText(String id) {
        mId.setText("Id: " + id);
    }


}
