package jdroidcoder.ua.sgsocialnetwork.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.realm.Realm;
import jdroidcoder.ua.sgsocialnetwork.R;
import jdroidcoder.ua.sgsocialnetwork.activitys.MainActivity;
import jdroidcoder.ua.sgsocialnetwork.models.UserModel;

/**
 * Created by Admin on 29.11.2016.
 */
public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle(getResources().getString(R.string.profile));
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        UserModel userModel = MainActivity.realm.where(UserModel.class).findFirst();

        ((TextView) view.findViewById(R.id.userNameTextView)).setText(userModel.getName());
        ((TextView) view.findViewById(R.id.userLastNameTextView)).setText(userModel.getLastName());
        ((TextView) view.findViewById(R.id.userAgeTextView)).setText(userModel.getAge()+" years old");
        ((TextView) view.findViewById(R.id.userPositionTextView)).setText(userModel.getPosition());
        if (userModel.getPhones().isEmpty()) {
            (view.findViewById(R.id.contactPhones)).setVisibility(View.GONE);
        } else {
            LinearLayout rl = (LinearLayout) view.findViewById(R.id.phonesListView);
            for (int i = 0; i < userModel.getPhones().size(); i++) {
                View view1 = inflater.inflate(R.layout.contactinfo_listview_style, null, false);
                TextView contact = (TextView) view1.findViewById(R.id.numberPhone);
                TextView indent = (TextView) view1.findViewById(R.id.identificateNumberPhone);
                contact.setText(userModel.getPhones().get(i).getContact());
                indent.setText(userModel.getPhones().get(i).getIdentificate());
                rl.addView(view1);
            }
        }

        if (userModel.getEmails().isEmpty()) {
            (view.findViewById(R.id.contactEmails)).setVisibility(View.GONE);
        } else {
            LinearLayout rl1 = (LinearLayout) view.findViewById(R.id.emailsListView);
            for (int i = 0; i < userModel.getEmails().size(); i++) {
                View view1 = inflater.inflate(R.layout.contactinfo_listview_style, null, false);
                TextView contact = (TextView) view1.findViewById(R.id.numberPhone);
                TextView indent = (TextView) view1.findViewById(R.id.identificateNumberPhone);
                contact.setText(userModel.getEmails().get(i).getContact());
                indent.setText(userModel.getEmails().get(i).getIdentificate());
                rl1.addView(view1);
            }
        }
        return view;
    }
}
