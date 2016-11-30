package jdroidcoder.ua.sgsocialnetwork.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import jdroidcoder.ua.sgsocialnetwork.R;
import jdroidcoder.ua.sgsocialnetwork.models.UserModel;

/**
 * Created by Admin on 29.11.2016.
 */
public class AdapterForDialogListView extends BaseAdapter {
    private ArrayList<UserModel> userModels;
    private LayoutInflater layoutInflater;

    public AdapterForDialogListView(Context context, ArrayList<UserModel> userModels) {
        this.userModels = userModels;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return userModels.size();
    }

    @Override
    public Object getItem(int position) {
        return userModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.dialog_listview_style, parent, false);
        ((TextView) convertView.findViewById(R.id.userNameTextView)).setText(userModels.get(position).getName());
        ((TextView) convertView.findViewById(R.id.userLastNameTextView)).setText(userModels.get(position).getLastName());
        return convertView;
    }
}
