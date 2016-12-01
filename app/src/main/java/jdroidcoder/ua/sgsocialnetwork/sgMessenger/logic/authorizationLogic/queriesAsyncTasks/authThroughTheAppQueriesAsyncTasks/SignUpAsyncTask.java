package jdroidcoder.ua.sgsocialnetwork.sgMessenger.logic.authorizationLogic.queriesAsyncTasks.authThroughTheAppQueriesAsyncTasks;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import jdroidcoder.ua.sgsocialnetwork.models.UserModel;
import jdroidcoder.ua.sgsocialnetwork.sgMessenger.dataBase.retrofit.RetrofitProvider;
import jdroidcoder.ua.sgsocialnetwork.sgMessenger.logic.authorizationLogic.callbacks.loginInAppCallbacks.TokenReceiveCallback;

/**
 * Created by Admin on 16.11.2016.
 */

public class SignUpAsyncTask extends AsyncTask<UserModel, Void, Void> {

    private Context context;

    public SignUpAsyncTask(Context context){
        this.context = context;
    }

    @Override
    protected Void doInBackground(UserModel... userModel) {
        String userModelJson = new Gson().toJson(userModel[0]);
        System.out.println(userModelJson);
        RetrofitProvider.getRetrofit().signUp(userModelJson).enqueue(new TokenReceiveCallback(context));
        return null;
    }
}
