package jdroidcoder.ua.sgsocialnetwork.sgMessenger.view.presenters;

import io.realm.RealmList;
import jdroidcoder.ua.sgsocialnetwork.jdroidcoder.models.ContactModel;
import jdroidcoder.ua.sgsocialnetwork.jdroidcoder.models.UserModel;
import jdroidcoder.ua.sgsocialnetwork.sgMessenger.logic.authorizationLogic.queriesAsyncTasks.authThroughTheAppQueriesAsyncTasks.SignUpAsyncTask;
import jdroidcoder.ua.sgsocialnetwork.sgMessenger.view.activities.RegistrationActivity;

/**
 * Created by Vadim on 15.11.2016.
 */

public class RegistrationActivityPresenter {

    private RegistrationActivity registrationActivity;
    private UserModel userModel;

    public RegistrationActivityPresenter(RegistrationActivity registrationActivity) {
        this.registrationActivity = registrationActivity;
    }

    public void signUp(){
        saveContactInfo();
        makeSingUpQuery();
        System.out.println(userModel.toString());
    }


    public void savePersonalInfoIntoUserModel(){
        userModel = new UserModel();
        userModel.setName(registrationActivity.getRegistrationPersonalInfoFragment()
                .getUserFirstNameEditText().getText().toString());
        userModel.setLastName(registrationActivity.getRegistrationPersonalInfoFragment()
                .getUserLastNameEditText().getText().toString());
        userModel.setDateOfBirth(registrationActivity.getRegistrationPersonalInfoFragment()
                .getUserDateOfBirthEditText().getText().toString());
        userModel.setPosition(registrationActivity.getRegistrationPersonalInfoFragment()
                .getUserPositionEditText().getText().toString());
    }

    private void saveContactInfo(){
        userModel.setPhones(null);
        RealmList<ContactModel> emails = new RealmList<>();
        ContactModel email = new ContactModel();
        email.setIdentificate("Main email");
        email.setContact(registrationActivity.getRegistrationContactInfoFragment().getUserEmailEditText().getText().toString());
        emails.add(email);
        userModel.setEmails(emails);
        userModel.setPassword(registrationActivity.getRegistrationContactInfoFragment().getUserPasswordEditText().getText().toString());
    }

    private void makeSingUpQuery(){
        new SignUpAsyncTask(registrationActivity).execute(userModel);
    }

}
