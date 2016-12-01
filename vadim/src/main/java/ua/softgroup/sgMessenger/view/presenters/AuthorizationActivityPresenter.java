package ua.softgroup.sgMessenger.view.presenters;

import ua.softgroup.sgMessenger.logic.authorizationLogic.queriesAsyncTasks.authThroughTheAppQueriesAsyncTasks.LogInAsyncTask;
import ua.softgroup.sgMessenger.view.activities.AuthorizationActivity;

/**
 * Created by Vadim on 15.11.2016.
 */

public class AuthorizationActivityPresenter {

    private AuthorizationActivity authorizationActivity;

    public AuthorizationActivityPresenter(AuthorizationActivity authorizationActivity) {
        this.authorizationActivity = authorizationActivity;
    }

    public void logIn() {
        new LogInAsyncTask(authorizationActivity)
                .execute(authorizationActivity.getEmailOrNumberEditText().getText().toString(), authorizationActivity.getPasswordEditText().getText().toString());
    }



}
