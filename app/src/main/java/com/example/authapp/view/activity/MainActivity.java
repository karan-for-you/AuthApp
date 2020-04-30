package com.example.authapp.view.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.authapp.R;
import com.example.authapp.databinding.ActivityMainBinding;
import com.example.authapp.handler.LoginHandler;
import com.example.authapp.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity implements LoginHandler {

    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBinding();
        //setupObserver();
        setupLoginDataObserver();
    }

    private void setupBinding(){
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupViewModelAndHandler(activityMainBinding);
    }

    private void setupViewModelAndHandler(ActivityMainBinding activityMainBinding){
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        activityMainBinding.setViewModel(loginViewModel);
        activityMainBinding.setHandler(this);
    }

    private void setupObserver(){
        loginViewModel.getLoginMessage().observe(this, s -> {
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            if(s.startsWith("V")){

            }
        });
    }

    private void setupLoginDataObserver(){
        loginViewModel.getLoginDataResponse().observe(this, loginResponse -> {
            if(loginResponse!=null && loginResponse.getResponseObject()!=null){
                Toast.makeText(MainActivity.this,loginResponse.getResponseObject().getName()+" "+
                        loginResponse.getResponseObject().getToken(),Toast.LENGTH_LONG).show();
            }else Toast.makeText(MainActivity.this,loginResponse.getMessage(),Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onLoginClicked() {
        loginViewModel.callLoginApi();
    }
}
