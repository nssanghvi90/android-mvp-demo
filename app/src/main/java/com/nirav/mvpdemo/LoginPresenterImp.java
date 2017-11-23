package com.nirav.mvpdemo;

/**
 * Created by nirav on 23/11/17.
 */

public class LoginPresenterImp implements LoginPresenter, LoginService.LoginServiceListener {

    LoginView mLoginView;
    LoginService mLoginService;

    LoginPresenterImp(LoginView loginView){
        this.mLoginView = loginView;
        this.mLoginService = new LoginServiceImp();
    }

    @Override
    public void loginBtnClick(String userName, String pwd) {
        if(this.mLoginView==null){
            return;
        }
        //validate the inputs
        if(userName.isEmpty()){
            this.mLoginView.showMessage("Invalid username");
            return;
        }
        if(pwd.isEmpty()){
            this.mLoginView.showMessage("Invalid password");
            return;
        }
        this.mLoginService.login(userName,pwd,this);
    }

    @Override
    public void onResume() {
        if(this.mLoginView!=null){
            this.mLoginView.showProgress(true);
        }
    }

    @Override
    public void onDestroy() {
    }


    @Override
    public void onSuccess() {
        this.mLoginView.showLoginResult(true);
    }

    @Override
    public void onFailure() {
        this.mLoginView.showLoginResult(false);
    }
}
