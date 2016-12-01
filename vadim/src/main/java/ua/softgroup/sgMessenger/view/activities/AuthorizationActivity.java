package ua.softgroup.sgMessenger.view.activities;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.widget.LoginButton;

import com.vk.sdk.VKSdk;

import java.util.Arrays;

import ua.softgroup.sgMessenger.R;
import ua.softgroup.sgMessenger.logic.authorizationLogic.callbacks.loginInSocialNetworkCallbacks.VKLoginCallback;
import ua.softgroup.sgMessenger.logic.authorizationLogic.callbacks.loginInSocialNetworkCallbacks.FacebookLoginCallback;
import ua.softgroup.sgMessenger.view.presenters.AuthorizationActivityPresenter;

import static ua.softgroup.sgMessenger.Consts.AUTH_PREF;
import static ua.softgroup.sgMessenger.Consts.AUTH_PREF_TOKEN;

public class AuthorizationActivity extends AppCompatActivity  {

    private AuthorizationActivityPresenter authorizationActivityPresenter;
    private EditText emailOrNumberEditText, passwordEditText;
    private LoginButton facebookLoginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestAppPermissions();
        setUpSocialNetworks();
        checkAuthorizationStatus();
        setContentView(R.layout.activity_authorization);
        setUpViews();
        authorizationActivityPresenter = new AuthorizationActivityPresenter(this);

    }

    private void requestAppPermissions(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }

    private void setUpSocialNetworks(){
        setUpFacebook();
    }

    private void setUpFacebook(){
        callbackManager = CallbackManager.Factory.create();
        AppEventsLogger.activateApp(this);
    }


    private void checkAuthorizationStatus(){
        SharedPreferences authPreferences = getSharedPreferences(AUTH_PREF, 0);
        if (!"".equals(authPreferences.getString(AUTH_PREF_TOKEN, ""))){
            //TODO User already registred. Need to get Tokens of App and social networks
        }
    }

    private void setUpViews(){
        setUpEditTexts();
        setUpSocialNetworksButtons();
    }

    private void setUpEditTexts(){
        emailOrNumberEditText = (EditText) findViewById(R.id.emailOrNumberEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
    }

    private void setUpSocialNetworksButtons(){
        setUpFacebookLoginButton();
    }

    private void setUpFacebookLoginButton(){
        facebookLoginButton = (LoginButton) findViewById(R.id.facebookLoginButton);
        facebookLoginButton.setReadPermissions(Arrays.asList("public_profile",
                "email", "user_friends", "user_birthday"));

        facebookLoginButton.registerCallback(callbackManager, new FacebookLoginCallback(this));
    }

    public void logInButtonAction(View view) {
        if (checkFieldsOnEmptiness()){
            authorizationActivityPresenter.logIn();
        } else {
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void loginWithVkOnClickAction(View view) {
        String[] scope = new String[]{"notify,friends,messages,email"};
        VKSdk.login(this, scope);
    }



    private boolean checkFieldsOnEmptiness(){
        return !("".equals(emailOrNumberEditText.getText().toString()) || "".equals(passwordEditText.getText().toString()));
    }

    public void startRegistrationActivity(View view){
        startActivity(new Intent(this, RegistrationActivity.class));
        this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        VKSdk.onActivityResult(requestCode, resultCode, data, new VKLoginCallback(this));
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public EditText getEmailOrNumberEditText() {
        return emailOrNumberEditText;
    }

    public EditText getPasswordEditText() {
        return passwordEditText;
    }



}
