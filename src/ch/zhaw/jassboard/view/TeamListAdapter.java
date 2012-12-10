package ch.zhaw.jassboard.view;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Adapterclass for TeamListView
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */
public class TeamListAdapter<Team> extends BaseAdapter {
    private Context mContext;

    private List<Team> mItems = new ArrayList<Team>();

    public TeamListAdapter(Context context, ArrayList<Team> items) {
        mContext = context;
        mItems = items;
    }

    /*
    * return size
    */
    public int getCount() {
        return mItems.size();
    }

    /*
    * return object
    */
    public Object getItem(int position) {
        return mItems.get(position);
    }

    /*
    * return id
    */
    public long getItemId(int position) {
        return position;
    }

    /*
    * return view
    */
    public View getView(int position, View convertView, ViewGroup parent) {
        TeamListView btv = new TeamListView(mContext, (ch.zhaw.jassboard.persist.Team) mItems.get(position));
        return btv;
    }
}
