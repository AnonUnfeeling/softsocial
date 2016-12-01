package jdroidcoder.ua.sgsocialnetwork.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


import jdroidcoder.ua.sgsocialnetwork.adapters.AdapterForDialogListView;
import jdroidcoder.ua.sgsocialnetwork.models.ContactModel;
import jdroidcoder.ua.sgsocialnetwork.models.UserModel;
import jdroidcoder.ua.sgsocialnetwork.sgMessenger.R;

/**
 * Created by Admin on 29.11.2016.
 */

public class ListViewFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_listview_fragment, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        ArrayList<UserModel> userModels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
//            userModels.add(new UserModel("Name " + i, "LastName " + i, i, new ContactModel[]{new ContactModel("(096) 7231234", "work")}, new ContactModel[]{new ContactModel("email@gmail.com", "work")}));
        }
        listView.setAdapter(new AdapterForDialogListView(getActivity().getApplicationContext(), userModels));
        return view;
    }
}
