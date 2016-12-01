package jdroidcoder.ua.sgsocialnetwork.sgMessenger.view.fragments.registrationFragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import jdroidcoder.ua.sgsocialnetwork.sgMessenger.R;

public class RegistrationPersonalInfoFragment extends Fragment implements DatePickerDialog.OnDateSetListener, View.OnClickListener {


    private View registrationPersonalInfoFragment;
    private EditText userFirstNameEditText, userLastNameEditText, userDateOfBirthEditText, userPositionEditText;
    private Bundle savedInstanceState = null;

    public RegistrationPersonalInfoFragment() {
        super();
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
        registrationPersonalInfoFragment = inflater.inflate(R.layout.fragment_registration_personal_info, container, false);
        setUpEditTexts();
        return registrationPersonalInfoFragment;
    }

    private void checkSavedInstance() {
        if (savedInstanceState != null) {
            if (savedInstanceState.getString("userFirstName") != null) {
                userFirstNameEditText.setText(savedInstanceState.getString("userFirstName"));
            }
            if (savedInstanceState.getString("userLastName") != null) {
                userLastNameEditText.setText(savedInstanceState.getString("userLastName"));
            }
            if (savedInstanceState.getString("userDateOfBirth") != null) {
                userDateOfBirthEditText.setText(savedInstanceState.getString("userDateOfBirth"));
            }
            if (savedInstanceState.get("userPosition") != null) {
                userPositionEditText.setText(savedInstanceState.getString("userPosition"));
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("userFirstName", String.valueOf(userFirstNameEditText.getText()));
        outState.putString("userLastName", String.valueOf(userLastNameEditText.getText()));
        outState.putString("userDateOfBirth", String.valueOf(userDateOfBirthEditText.getText()));
        outState.putString("userPosition", String.valueOf(userPositionEditText.getText()));
        super.onSaveInstanceState(outState);
    }

    private void setUpEditTexts() {
        userFirstNameEditText = (EditText) registrationPersonalInfoFragment.findViewById(R.id.userFirstNameEditText);
        userLastNameEditText = (EditText) registrationPersonalInfoFragment.findViewById(R.id.userLastNameEditText);
        userDateOfBirthEditText = (EditText) registrationPersonalInfoFragment.findViewById(R.id.userDateOfBirthEditText);
        userPositionEditText = (EditText) registrationPersonalInfoFragment.findViewById(R.id.userPositionEditText);
        userDateOfBirthEditText.setOnClickListener(this);
        userDateOfBirthEditText.setFocusable(false);
        checkSavedInstance();

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == userDateOfBirthEditText.getId()){
            showCalendar();
        }
    }

    public void showCalendar() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), this, 2016, 01, 01);
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        userDateOfBirthEditText.setText(year + "." + month + "." + day);
    }

    public EditText getUserFirstNameEditText() {
        return userFirstNameEditText;
    }

    public EditText getUserLastNameEditText() {
        return userLastNameEditText;
    }

    public EditText getUserDateOfBirthEditText() {
        return userDateOfBirthEditText;
    }

    public EditText getUserPositionEditText() {
        return userPositionEditText;
    }
}
