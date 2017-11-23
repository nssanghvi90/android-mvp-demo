package com.nirav.mvpdemo;

import android.os.AsyncTask;

/**
 * Created by nirav on 23/11/17.
 */

public class LoginServiceImp implements LoginService {

    @Override
    public void login(String username, String password, final LoginServiceListener listener) {

        if(listener==null)
            return;

        new AsyncTask<String,Void,Boolean>(){
            @Override
            protected Boolean doInBackground(String... strings) {
                String username = strings[0];
                String password = strings[1];
                return true;
            }

            @Override
            protected void onPostExecute(Boolean result) {
                super.onPostExecute(result);
                if(result){
                    listener.onSuccess();
                }
                else {
                    listener.onFailure();
                }
            }
        }.execute(username,password);

    }

}
