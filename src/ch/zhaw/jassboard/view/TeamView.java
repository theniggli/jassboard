package ch.zhaw.jassboard.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
import ch.zhaw.jassboard.persist.Team;

/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 28.10.12
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
public class TeamView extends LinearLayout {
    private TextView nameTextView, idTextView;

    private int teamID;
    private String teamName;

    public TeamView(Context context, Team team) {
        super(context);
        this.setOrientation(VERTICAL);
        nameTextView = new TextView(context);
        idTextView = new TextView(context);

        teamName = team.getTeamName();
        nameTextView.setText(teamName);
        nameTextView.setTextSize(19);
        nameTextView.setTextColor(Color.CYAN);
        nameTextView.setTypeface(Typeface.SANS_SERIF);

        teamID = team.getTeamID();
        idTextView.setText("" + teamID);
        idTextView.setTextSize(14);
        idTextView.setTextColor(Color.RED);
        idTextView.setTypeface(Typeface.SANS_SERIF);

        addView(nameTextView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(idTextView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }
}
