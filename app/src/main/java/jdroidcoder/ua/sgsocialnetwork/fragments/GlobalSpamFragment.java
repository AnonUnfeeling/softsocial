package jdroidcoder.ua.sgsocialnetwork.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jdroidcoder.ua.sgsocialnetwork.sgMessenger.R;


/**
 * Created by Admin on 28.11.2016.
 */

public class GlobalSpamFragment extends Fragment{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle(getResources().getString(R.string.globalSpamWindow));
        return inflater.inflate(R.layout.message_fragment,container,false);
    }
}
