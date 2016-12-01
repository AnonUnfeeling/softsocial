package jdroidcoder.ua.sgsocialnetwork.sgMessenger.dataBase.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vadim on 15.11.2016.
 */

public class RetrofitProvider {

    private static RetrofitQueries retrofitQueries;
    private final static String baseUrl = "http://192.168.11.150:8443";

    private RetrofitProvider(){
    }

    public static RetrofitQueries getRetrofit(){
        if(retrofitQueries == null) {
            setUpRetrofit();
        }
        return retrofitQueries;
    }

    private static void setUpRetrofit(){
        retrofitQueries = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
                .create(RetrofitQueries.class);
    }

}
