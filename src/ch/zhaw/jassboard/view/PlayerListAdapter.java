package ch.zhaw.jassboard.view;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: niggli
 * Date: 28.10.12
 * Time: 20:32
 * To change this template use File | Settings | File Templates.
 */
public class PlayerListAdapter<Player> extends BaseAdapter {
    private Context mContext;

    private List<Player> mItems = new ArrayList<Player>();

    public PlayerListAdapter(Context context, ArrayList<Player> items) {
        mContext = context;
        mItems = items;
    }

    public int getCount() {
        return mItems.size();
    }

    public Object getItem(int position) {
        return mItems.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        PlayerListView btv = new PlayerListView(mContext, (ch.zhaw.jassboard.persist.Player) mItems.get(position));
        return btv;
    }
}
