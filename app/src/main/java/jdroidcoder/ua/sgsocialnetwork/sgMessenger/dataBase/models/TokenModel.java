package jdroidcoder.ua.sgsocialnetwork.sgMessenger.dataBase.models;

/**
 * Created by Vadim on 15.11.2016.
 */

public class TokenModel {

    private static final long SerialVersionUID = 741369852456845L;
    private String token;

    public TokenModel(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
