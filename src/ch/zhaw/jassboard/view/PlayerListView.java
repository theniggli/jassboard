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
public class PlayerListView extends LinearLayout {
    private TextView nameTextView, idTextView;
    private int playerID;
    private String playerName;

    public PlayerListView(Context context, Player player) {
        super(context);
        this.setOrientation(VERTICAL);
        nameTextView = new TextView(context);
        idTextView = new TextView(context);

        playerName = player.getPlayerName();
        nameTextView.setText(playerName);
        nameTextView.setTextSize(19);
        nameTextView.setTextColor(Color.BLUE);
        nameTextView.setTypeface(Typeface.SANS_SERIF);

        playerID = player.getPlayerID();
        idTextView.setText("" + playerID);
        idTextView.setTextSize(14);
        idTextView.setTextColor(Color.RED);
        idTextView.setTypeface(Typeface.SANS_SERIF);

        addView(nameTextView, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(idTextView, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }

    public Integer getPlayerId() {
        return playerID;
    }

}
