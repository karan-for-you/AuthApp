package com.example.authapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public String userName = "";
    public String password = "";

    private MutableLiveData<String> loginData = new MutableLiveData<String>();

    public LiveData<String> getLoginData(){
        return loginData;
    }

    public void validateCredentials(){
        if(userName.length() == 0){
            loginData.setValue("Invalid Username");
            return;
        }
        if(password.length() == 0){
            loginData.setValue("Invalid Password");
            return;
        }

        loginData.setValue("Validated");
    }



}
