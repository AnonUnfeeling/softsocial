package ua.softgroup.sgMessenger.dataBase.retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import ua.softgroup.sgMessenger.dataBase.models.TokenModel;

/**
 * Created by Vadim on 15.11.2016.
 */

public interface RetrofitQueries {

    @POST("/login")
    Call<TokenModel> logIn(@QueryMap Map<String, String> loginAndPassMap);

    @FormUrlEncoded
    @POST("/registration")
    Call<TokenModel> signUp(@Field("userData") String userModelInfo);

    @POST("/checkNetwork")
    Call<TokenModel> loginFromNetwork(@QueryMap Map<String, String> userNetworkInfo);

}
