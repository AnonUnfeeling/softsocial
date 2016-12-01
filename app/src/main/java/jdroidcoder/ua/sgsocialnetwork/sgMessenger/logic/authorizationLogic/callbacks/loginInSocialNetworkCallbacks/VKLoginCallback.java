package jdroidcoder.ua.sgsocialnetwork.sgMessenger.logic.authorizationLogic.callbacks.loginInSocialNetworkCallbacks;

import android.content.Context;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.api.VKError;

/**
 * Created by Admin on 28.11.2016.
 */

public class VKLoginCallback implements VKCallback<VKAccessToken> {

    private Context context;

    public VKLoginCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onResult(VKAccessToken res) {
        System.out.println("VK success");
    }

    @Override
    public void onError(VKError error) {
        System.out.println("VK error");
    }
}
