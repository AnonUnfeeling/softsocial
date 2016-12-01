package ua.softgroup.sgMessenger.dataBase;

import ua.softgroup.sgMessenger.dataBase.models.TokenModel;

/**
 * Created by Vadim on 15.11.2016.
 */

public class CurrentSessionInfo {


    private static TokenModel tokenModel;

    public static TokenModel getTokenModel() {
        return tokenModel;
    }

    public static void setTokenModel(TokenModel tokenModel) {
        CurrentSessionInfo.tokenModel = tokenModel;
    }

}
