package com.nirav.mvpdemo;

/**
 * Created by nirav on 23/11/17.
 */

public class LoginPresenterImp implements LoginPresenter {

    LoginView mLoginView;

    LoginPresenterImp(LoginView loginView){
        this.mLoginView = loginView;
    }

    @Override
    public void loginBtnClick(String userName, String pwd) {
        //validate the inputs
        if(userName.isEmpty()){
            this.mLoginView.showMessage("Invalid username");
            return;
        }
        if(pwd.isEmpty()){
            this.mLoginView.showMessage("Invalid password");
            return;
        }
        this.doLogin(userName,pwd);
    }

    @Override
    public void onResume() {
        this.mLoginView.showProgress(true);
    }

    @Override
    public void onDestroy() {

    }

    private void doLogin(String userName, String pwd){
        this.mLoginView.showProgress(false);
        this.mLoginView.showLoginResult(true);
    }

}
