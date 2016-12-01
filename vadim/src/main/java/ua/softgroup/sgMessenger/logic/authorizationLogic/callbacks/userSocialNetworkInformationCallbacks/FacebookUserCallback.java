package ua.softgroup.sgMessenger.logic.authorizationLogic.callbacks.userSocialNetworkInformationCallbacks;

import android.content.Context;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONException;
import org.json.JSONObject;

import ua.softgroup.sgMessenger.logic.authorizationLogic.queriesAsyncTasks.authWithSocialNetworksQueriesAsyncTasks.FacebookAuthAsyncTask;

/**
 * Created by Admin on 17.11.2016.
 */

public class FacebookUserCallback implements GraphRequest.GraphJSONObjectCallback {

    private Context context;

    public FacebookUserCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onCompleted(JSONObject object, GraphResponse response) {
        new FacebookAuthAsyncTask(context).execute(response);
        try {
            System.out.println(response.getJSONObject().getString("id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
