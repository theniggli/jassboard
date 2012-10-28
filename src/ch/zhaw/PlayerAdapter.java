package ch.zhaw;


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
public class PlayerAdapter<Player extends ch.zhaw.Player> extends BaseAdapter {
    private Context mContext;

    private List<Player> mItems = new ArrayList<Player>();

    public PlayerAdapter(Context context, ArrayList<Player> items) {
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
        PlayerView btv;
        if (convertView == null) {
            btv = new PlayerView(mContext, (Player) mItems.get(position));
        } else {
            btv = (PlayerView) convertView;
            btv.setNameText(mItems.get(position).getName());
            btv.setIdText(mItems.get(position).getId().toString());
        }
        return btv;
    }
}
