package ch.zhaw.jassboard.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
import ch.zhaw.jassboard.persist.Team;

/**
 * Viewclass TeamList
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */
public class TeamListView extends LinearLayout {
    private TextView nameTextView;
//    private TextView idTextView;

    private int teamID;
    private String teamName;

    public TeamListView(Context context, Team team) {
        super(context);
        this.setOrientation(VERTICAL);
        nameTextView = new TextView(context);
//        idTextView = new TextView(context);

        teamName = team.getTeamName();
        nameTextView.setText(teamName);
        nameTextView.setTextSize(19);
        nameTextView.setTextColor(Color.GRAY);
        nameTextView.setTypeface(Typeface.SANS_SERIF);

        teamID = team.getTeamID();
//        idTextView.setText("" + teamID);
//        idTextView.setTextSize(14);
//        idTextView.setTextColor(Color.YELLOW);
//        idTextView.setTypeface(Typeface.SANS_SERIF);

        addView(nameTextView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//        addView(idTextView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }

    /*
    * return playerID
    */
    public Integer getTeamId() {
        return teamID;
    }
}
