package jdroidcoder.ua.sgsocialnetwork.sgMessenger.view.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import jdroidcoder.ua.sgsocialnetwork.sgMessenger.R;
import jdroidcoder.ua.sgsocialnetwork.sgMessenger.view.fragments.registrationFragments.RegistrationContactInfoFragment;
import jdroidcoder.ua.sgsocialnetwork.sgMessenger.view.fragments.registrationFragments.RegistrationPersonalInfoFragment;
import jdroidcoder.ua.sgsocialnetwork.sgMessenger.view.presenters.RegistrationActivityPresenter;

public class RegistrationActivity extends AppCompatActivity {
    private Menu registrationMenu;
    private RegistrationActivityPresenter registrationActivityPresenter;
    private RegistrationPersonalInfoFragment registrationPersonalInfoFragment;
    private RegistrationContactInfoFragment registrationContactInfoFragment;
    private FloatingActionButton floatingActionButton;
    private boolean isMoveNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setUpViews();
        registrationActivityPresenter = new RegistrationActivityPresenter(this);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void setUpViews() {
        openRegistrationPersonalInfoFragment();
        setUpToolbar();
    }

    private void openRegistrationPersonalInfoFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        registrationPersonalInfoFragment = new RegistrationPersonalInfoFragment();
        fragmentTransaction.replace(R.id.registrationFragmentsContainer, registrationPersonalInfoFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.registrationToolbar);
        toolbar.setTitle("Registration");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onSupportNavigateUp() {
        startActivity(new Intent(this, AuthorizationActivity.class));
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        registrationMenu = menu;
        getMenuInflater().inflate(R.menu.menu_registration, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.nextMenuButton == item.getItemId()) {
            nextMenuButtonAction();
        } else if (R.id.okMenuButton == item.getItemId()) {
            okMenuButtonAction();
        }
        return super.onOptionsItemSelected(item);
    }

    private void nextMenuButtonAction() {
        moveNext();
    }

    private void openRegistrationContactInfoFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        registrationContactInfoFragment = new RegistrationContactInfoFragment();
        fragmentTransaction.replace(R.id.registrationFragmentsContainer, registrationContactInfoFragment);
        fragmentTransaction.commit();
    }

    private boolean checkPersonalFieldsOnEmptiness() {
        return (!"".equals(registrationPersonalInfoFragment.getUserFirstNameEditText().getText().toString()) &&
                !"".equals(registrationPersonalInfoFragment.getUserLastNameEditText().getText().toString()) &&
                !"".equals(registrationPersonalInfoFragment.getUserDateOfBirthEditText().getText().toString()) &&
                !"".equals(registrationPersonalInfoFragment.getUserPositionEditText().getText().toString()));
    }

    private void okMenuButtonAction() {
        if (checkContactFieldsOnEmptiness()) {
            if (checkPassword()) {
                registrationActivityPresenter.signUp();
            } else {
                Toast.makeText(this, "Wrong confirmation password", Toast.LENGTH_SHORT)
                        .show();
            }
        } else {
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private boolean checkContactFieldsOnEmptiness() {
        return (!"".equals(registrationContactInfoFragment.getUserEmailEditText().getText().toString()) ||
                !"".equals(registrationContactInfoFragment.getUserPasswordEditText().getText().toString()));
    }

    private boolean checkPassword() {
        return registrationContactInfoFragment.getUserConfirmPasswordEditText().getText().toString()
                .equals(registrationContactInfoFragment.getUserPasswordEditText().getText().toString());
    }

    @Override
    public void onBackPressed() {
        if (isMoveNext) {
            getSupportFragmentManager().popBackStack();
            registrationMenu.findItem(R.id.nextMenuButton).setVisible(true);
            registrationMenu.findItem(R.id.okMenuButton).setVisible(false);
            openRegistrationPersonalInfoFragment();
            isMoveNext = false;
        } else {
            super.onBackPressed();
        }
    }

    public RegistrationPersonalInfoFragment getRegistrationPersonalInfoFragment() {
        return registrationPersonalInfoFragment;
    }

    public RegistrationContactInfoFragment getRegistrationContactInfoFragment() {
        return registrationContactInfoFragment;
    }

    public void nextFloatingButton(View view) {
        if (!isMoveNext) {
            moveNext();
        } else {
            okMenuButtonAction();
        }
    }

    private void moveNext() {
        if (checkPersonalFieldsOnEmptiness()) {
            isMoveNext = true;
            registrationActivityPresenter.savePersonalInfoIntoUserModel();
            openRegistrationContactInfoFragment();
            registrationMenu.findItem(R.id.nextMenuButton).setVisible(false);
            registrationMenu.findItem(R.id.okMenuButton).setVisible(true);
        } else {
            Toast.makeText(this, "Please, fill all fields", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
