package ua.softgroup.sgMessenger.view.fragments.registrationFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import ua.softgroup.sgMessenger.R;


public class RegistrationContactInfoFragment extends Fragment {

    private View registrationContactInfoFragment;
    private EditText userEmailEditText, userPasswordEditText, userConfirmPasswordEditText;
    private Bundle savedInstanceState;

    public RegistrationContactInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        registrationContactInfoFragment = inflater.inflate(R.layout.fragment_registration_contact_info, container, false);
        setUpEditTexts();
        return registrationContactInfoFragment;
    }

    private void checkSavedInstance() {
        if (savedInstanceState != null) {
            if (savedInstanceState.getString("email") != null) {
                userEmailEditText.setText(savedInstanceState.getString("email"));
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("email", String.valueOf(userEmailEditText.getText()));
        super.onSaveInstanceState(outState);
    }

    private void setUpEditTexts() {
        userEmailEditText = (EditText) registrationContactInfoFragment.findViewById(R.id.userEmailEditText);
        userPasswordEditText = (EditText) registrationContactInfoFragment.findViewById(R.id.userPasswordEditText);
        userConfirmPasswordEditText = (EditText) registrationContactInfoFragment.findViewById(R.id.userComfirmPasswordEditText);
        checkSavedInstance();
    }

    public EditText getUserEmailEditText() {
        return userEmailEditText;
    }

    public EditText getUserPasswordEditText() {
        return userPasswordEditText;
    }

    public EditText getUserConfirmPasswordEditText() {
        return userConfirmPasswordEditText;
    }
}
