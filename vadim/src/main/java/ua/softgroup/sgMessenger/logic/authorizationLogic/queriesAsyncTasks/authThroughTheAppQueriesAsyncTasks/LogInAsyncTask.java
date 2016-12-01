package ua.softgroup.sgMessenger.logic.authorizationLogic.queriesAsyncTasks.authThroughTheAppQueriesAsyncTasks;

import android.content.Context;
import android.os.AsyncTask;

import java.util.TreeMap;

import ua.softgroup.sgMessenger.dataBase.retrofit.RetrofitProvider;
import ua.softgroup.sgMessenger.logic.authorizationLogic.callbacks.loginInAppCallbacks.TokenReceiveCallback;

/**
 * Created by Admin on 16.11.2016.
 */

public class LogInAsyncTask extends AsyncTask<String, Void, Void> {

    private Context context;

    public LogInAsyncTask(Context context) {
        this.context = context;
    }


    @Override
    protected Void doInBackground(String... strings) {
        TreeMap<String, String> loginAndPassTreeMap = new TreeMap<>();
        loginAndPassTreeMap.put("login", strings[0]);
        loginAndPassTreeMap.put("password", strings[1]);
        RetrofitProvider.getRetrofit().logIn(loginAndPassTreeMap).enqueue(new TokenReceiveCallback(context));
        return null;
    }
}
