package ch.zhaw.jassboard.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
import ch.zhaw.jassboard.persist.Player;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 28.10.12
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
public class PlayerView extends LinearLayout {
    private TextView mName, mId;
    private Player player;  //I know the player in here may is stupid.. but it works this way...

    public PlayerView(Context context, Player player) {
        super(context);
        this.player = player;  //I want this in here for easy return to JassBoard
        this.setOrientation(VERTICAL);
        mName = new TextView(context);
        mId = new TextView(context);

        String name = player.getName();
        mName.setText(name);
        mName.setTextSize(19);
        mName.setTextColor(Color.GREEN);
        mName.setTypeface(Typeface.SANS_SERIF);

        Number id = player.getId();
        mId.setText(id.toString());
        mId.setTextSize(14);
        mId.setTextColor(Color.RED);
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

    public Number getPlayerId() {
        return player.getId();
    }

    public void setNameText(String name) {
        mName.setText(name);
    }

    public void setIdText(String id) {
        mId.setText(id);
    }
}
