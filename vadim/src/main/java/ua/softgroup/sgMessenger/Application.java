package ua.softgroup.sgMessenger;

import com.facebook.FacebookSdk;
import com.vk.sdk.VKSdk;

/**
 * Created by Admin on 28.11.2016.
 */

public class Application extends android.app.Application {
//
//    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
//        @Override
//        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
//            if (newToken == null) {
//                // VKAccessToken is invalid
//            }
//        }
//    };


    @Override
    public void onCreate() {
        super.onCreate();
        //vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);
        FacebookSdk.sdkInitialize(this);

    }
}
