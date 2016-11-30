package jdroidcoder.ua.sgsocialnetwork.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import jdroidcoder.ua.sgsocialnetwork.R;
import jdroidcoder.ua.sgsocialnetwork.models.ContactModel;

/**
 * Created by Admin on 29.11.2016.
 */

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle(getResources().getString(R.string.profile));
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        ((TextView) view.findViewById(R.id.userNameTextView)).setText("Ivam");
        ((TextView) view.findViewById(R.id.userLastNameTextView)).setText("Pavlovich");
        ((TextView) view.findViewById(R.id.userAgeTextView)).setText("20 years old");
        ((TextView) view.findViewById(R.id.userPositionTextView)).setText("developer");
        ArrayList<ContactModel> emails = new ArrayList<>();
        ArrayList<ContactModel> phones = new ArrayList<>();
        phones.add(new ContactModel("(096) 7231234", "work"));
        phones.add(new ContactModel("(096) 7231234", "mobile"));
        emails.add(new ContactModel("email@gmail.com", "work"));
        emails.add(new ContactModel("email1@gmail.com", "personal"));
        if (phones.isEmpty()) {
            (view.findViewById(R.id.contactPhones)).setVisibility(View.GONE);
        }else {
            LinearLayout rl = (LinearLayout) view.findViewById(R.id.phonesListView);
            for (int i = 0; i < phones.size(); i++) {
                View view1 = inflater.inflate(R.layout.contactinfo_listview_style, null, false);
                TextView contact = (TextView) view1.findViewById(R.id.numberPhone);
                TextView indent = (TextView) view1.findViewById(R.id.identificateNumberPhone);
                contact.setText(phones.get(i).getContact());
                indent.setText(phones.get(i).getIdentificate());
                rl.addView(view1);
            }
        }

        if(emails.isEmpty()){
            (view.findViewById(R.id.contactEmails)).setVisibility(View.GONE);
        }else {
            LinearLayout rl1 = (LinearLayout) view.findViewById(R.id.emailsListView);
            for (int i = 0; i < emails.size(); i++) {
                View view1 = inflater.inflate(R.layout.contactinfo_listview_style, null, false);
                TextView contact = (TextView) view1.findViewById(R.id.numberPhone);
                TextView indent = (TextView) view1.findViewById(R.id.identificateNumberPhone);
                contact.setText(emails.get(i).getContact());
                indent.setText(emails.get(i).getIdentificate());
                rl1.addView(view1);
            }
        }
        return view;
    }
}
