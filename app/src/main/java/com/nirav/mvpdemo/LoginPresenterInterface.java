package com.nirav.mvpdemo;

/**
 * Created by nirav on 23/11/17.
 */

public interface LoginPresenterInterface extends PresenterInterface {

    void loginBtnClick(String userName, String pwd);
    void onResume();
    void onDestroy();

}
