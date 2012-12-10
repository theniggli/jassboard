package ch.zhaw.jassboard.view;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Adapterclass for PlayerListView
 *
 * @author <a href=mailto:nigglrog@students.zhaw.ch>roger</a>
 */
public class PlayerListAdapter<Player> extends BaseAdapter {
    private Context mContext;

    private List<Player> mItems = new ArrayList<Player>();

    public PlayerListAdapter(Context context, ArrayList<Player> items) {
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
        PlayerListView btv = new PlayerListView(mContext, (ch.zhaw.jassboard.persist.Player) mItems.get(position));
        return btv;
    }
}
