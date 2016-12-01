package jdroidcoder.ua.sgsocialnetwork.sgMessenger.logic.authorizationLogic.callbacks.loginInSocialNetworkCallbacks;

import android.content.Context;
import android.os.Bundle;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.LoginResult;

import jdroidcoder.ua.sgsocialnetwork.sgMessenger.logic.authorizationLogic.callbacks.userSocialNetworkInformationCallbacks.FacebookUserCallback;

/**
 * Created by Vadim on 16.11.2016.
 */

public class FacebookLoginCallback implements FacebookCallback<LoginResult> {

    private final String FIELDS = "id,email,name,location, birthday,gender";
    private Context context;


    public FacebookLoginCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),
                new FacebookUserCallback(context));
        Bundle parameters = new Bundle();
        parameters.putString("fields", FIELDS);
        request.setParameters(parameters);
        request.executeAsync();
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError(FacebookException error) {

    }

}
