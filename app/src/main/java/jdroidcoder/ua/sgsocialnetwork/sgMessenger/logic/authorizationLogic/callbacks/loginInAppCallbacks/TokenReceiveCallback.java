package jdroidcoder.ua.sgsocialnetwork.sgMessenger.logic.authorizationLogic.callbacks.loginInAppCallbacks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import jdroidcoder.ua.sgsocialnetwork.jdroidcoder.activitys.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import jdroidcoder.ua.sgsocialnetwork.sgMessenger.dataBase.CurrentSessionInfo;
import jdroidcoder.ua.sgsocialnetwork.sgMessenger.dataBase.models.TokenModel;

/**
 * Created by Vadim on 15.11.2016.
 */

public class TokenReceiveCallback implements Callback<TokenModel> {

    private Context context;
    private Response<TokenModel> response;

    public TokenReceiveCallback(Context context){
        this.context = context;
    }

    @Override
    public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
        System.out.println(response.raw().toString());
        this.response = response;
        checkToken();
    }

    private void checkToken(){
        if (response.body() != null) {
            System.out.println(response.body().getToken());
            if("not found".equals(response.body().getToken())){
                Toast.makeText(context, "User not registered", Toast.LENGTH_SHORT)
                        .show();
            } else if ("completed".equals(response.body().getToken())){
                Toast.makeText(context, "You've already registered", Toast.LENGTH_SHORT)
                        .show();
            } else {
                validTokenAction();
            }
        } else {
            Toast.makeText(context, "NULL TOKEN", Toast.LENGTH_SHORT)
                    .show();
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
            ((Activity)context).finish();
        }
    }

    private void validTokenAction(){
        setCurrentSessionInfo();
        setLoginState();
    }

    private void setCurrentSessionInfo(){
        CurrentSessionInfo.setTokenModel(response.body());
    }

    private void setLoginState() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LOGIN_STATE", 0);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putBoolean("isLogin", true);
        sharedPreferencesEditor.apply();
    }

    @Override
    public void onFailure(Call<TokenModel> call, Throwable t) {
        Toast.makeText(context, "Oops! Something went wrong.", Toast.LENGTH_SHORT)
                .show();

        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        ((Activity)context).finish();
    }


}
