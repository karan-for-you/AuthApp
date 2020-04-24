package com.example.authapp.viewmodel;

import android.app.Application;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    public String userName = "";
    public String password = "";
    private Application application;

    private MutableLiveData<String> loginMessage = new MutableLiveData<String>();

    public LiveData<String> getLoginMessage(){
        return loginMessage;
    }
    public void validateCredentials(){
        if(userName.length() == 0){
            loginMessage.setValue("Invalid Username");
            return;
        }
        if(password.length() == 0){
            loginMessage.setValue("Invalid Password");
            return;
        }

        loginMessage.setValue("Validated");
    }



}
