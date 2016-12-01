package ua.softgroup.sgMessenger.logic.authorizationLogic.queriesAsyncTasks.authWithSocialNetworksQueriesAsyncTasks;

import android.content.Context;
import android.os.AsyncTask;

import com.facebook.GraphResponse;

import org.json.JSONException;

import java.util.TreeMap;

import ua.softgroup.sgMessenger.dataBase.retrofit.RetrofitProvider;
import ua.softgroup.sgMessenger.logic.authorizationLogic.callbacks.socialNetworkAuthCallbacks.FacebookAuthCallback;

/**
 * Created by Admin on 17.11.2016.
 */

public class FacebookAuthAsyncTask extends AsyncTask<GraphResponse, Void, Void> {

    private Context context;

    public FacebookAuthAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(GraphResponse... response) {
        System.out.println(response[0].getRawResponse());
        TreeMap<String, String> treeMap = new TreeMap<>();
        try {
            treeMap.put("userNetworkID", response[0].getJSONObject().getString("id"));
            treeMap.put("network", "FB");
            RetrofitProvider.getRetrofit().loginFromNetwork(treeMap).enqueue(new FacebookAuthCallback(context, response[0]));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
