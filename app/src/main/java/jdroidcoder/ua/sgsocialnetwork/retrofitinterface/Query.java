package jdroidcoder.ua.sgsocialnetwork.retrofitinterface;

import java.util.Map;

import jdroidcoder.ua.sgsocialnetwork.models.UserModel;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Admin on 30.11.2016.
 */

public interface Query {
    @FormUrlEncoded
    @POST("/")
    Call<UserModel> sendQuery(@QueryMap Map map);
}
