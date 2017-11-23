package com.nirav.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity implements LoginView {

    LoginPresenter mLoginPresenter;
    EditText mUserName_edt;
    EditText mPassword_edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserName_edt = (EditText)findViewById(R.id.username);
        mPassword_edt = (EditText)findViewById(R.id.password);
        this.mLoginPresenter = new LoginPresenterImp(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.mLoginPresenter.onResume();
    }

    public void loginBtnClick(View view){
        String username = this.mUserName_edt.getText()!=null ? this.mUserName_edt.getText().toString() : "";
        String passwrd = this.mPassword_edt.getText()!=null ? this.mPassword_edt.getText().toString() : "";
        this.mLoginPresenter.loginBtnClick(username,passwrd);
    }

    @Override
    public void showLoginResult(boolean isSuccess) {
        if(isSuccess)
            this.showMessage("Login successful");
        else
            this.showMessage("Login failed !");
    }

    @Override
    public void showProgress(boolean show) {
        //show progress bar
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mLoginPresenter.onDestroy();
    }
}
