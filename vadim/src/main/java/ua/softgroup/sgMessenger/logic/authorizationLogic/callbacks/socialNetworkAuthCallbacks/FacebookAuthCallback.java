package ua.softgroup.sgMessenger.logic.authorizationLogic.callbacks.socialNetworkAuthCallbacks;

import android.content.Context;
import android.widget.Toast;

import com.facebook.GraphResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.softgroup.sgMessenger.dataBase.CurrentSessionInfo;
import ua.softgroup.sgMessenger.dataBase.models.TokenModel;

/**
 * Created by Admin on 17.11.2016.
 */

public class FacebookAuthCallback implements Callback<TokenModel> {

    private Context context;
    private GraphResponse graphResponse;
    private Response<TokenModel> response;

    public FacebookAuthCallback(Context context, GraphResponse graphResponse) {
        this.context = context;
        this.graphResponse = graphResponse;
    }

    @Override
    public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
        this.response = response;
        System.out.println(response.body().getToken());
        if (response.body() != null) {
            if ("not registration".equals(response.body().getToken())) {
                signUpNewUser();
            } else {
                validTokenAction();
            }
        } else {
            Toast.makeText(context, "Oops! Something went wrong.", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private void signUpNewUser() {
//        UserModel userModel = null;
//        try {
//            userModel = new UserModel();
//            userModel.setUsername((String) graphResponse.getJSONObject().get("name"));
//            userModel.setEmail((String) graphResponse.getJSONObject().get("email"));
//            userModel.setPhoneNumber("none");
////    //        userModel.setPersonalPhoto;
//            userModel.setGender((String) graphResponse.getJSONObject().get("gender"));
//            userModel.setDateOfBirth((String) graphResponse.getJSONObject().get("birthday"));
//            userModel.setLocation("none"/*(String)graphResponse.getJSONObject().get("location")*/);
//            userModel.setBan(false);
//            userModel.setPassword("none");
//            userModel.setSocialNetwork("FB");
//            userModel.setSocialNetworkID((String) graphResponse.getJSONObject().get("id"));
//            System.out.println(userModel.toString());
//        } catch (JSONException e) {
//            e.printStackTrace();
//            userModel = null;
//        }
//        if (userModel != null) {
//            new SignUpAsyncTask(context).execute(userModel);
//        }
    }

    private void validTokenAction(){
        CurrentSessionInfo.setTokenModel(response.body());
//        CurrentSessionInfo.setSocialNetwork("FB");
//        Intent intent = new Intent(context, MainActivity.class);
//        context.startActivity(intent);
//        ((Activity)context).finish();
    }

    @Override
    public void onFailure(Call<TokenModel> call, Throwable t) {
        System.out.println("OUR SERVER FAIL");
    }
}
