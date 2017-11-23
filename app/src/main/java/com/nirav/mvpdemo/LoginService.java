package com.nirav.mvpdemo;

/**
 * Created by nirav on 23/11/17.
 */

public interface LoginService {

    interface LoginServiceListener{
        void onSuccess();
        void onFailure();
    }

    void login(String username, String password, LoginServiceListener listener);

}
