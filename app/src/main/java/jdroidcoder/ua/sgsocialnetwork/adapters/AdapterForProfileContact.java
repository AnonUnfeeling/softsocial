package jdroidcoder.ua.sgsocialnetwork.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import jdroidcoder.ua.sgsocialnetwork.R;
import jdroidcoder.ua.sgsocialnetwork.models.ContactModel;

/**
 * Created by Admin on 29.11.2016.
 */
public class AdapterForProfileContact extends BaseAdapter{
    private ArrayList<ContactModel> userModels;
    private LayoutInflater layoutInflater;
    public AdapterForProfileContact(Context context, ArrayList<ContactModel> contactModels) {
        this.userModels = contactModels;
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
        convertView = layoutInflater.inflate(R.layout.contactinfo_listview_style, parent, false);
        ((TextView) convertView.findViewById(R.id.numberPhone)).setText(userModels.get(position).getContact());
        ((TextView) convertView.findViewById(R.id.identificateNumberPhone)).setText(userModels.get(position).getIdentificate());
        return convertView;
    }
}
