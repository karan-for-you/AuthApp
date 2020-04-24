package com.example.authapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

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
        setupObserver();
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
        loginViewModel.getLoginMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                if(s.startsWith("V")){
                    startActivity(new Intent(getApplicationContext(),UsersActivity.class));
                }
            }
        });
    }

    @Override
    public void onLoginClicked() {
        loginViewModel.validateCredentials();
    }
}
