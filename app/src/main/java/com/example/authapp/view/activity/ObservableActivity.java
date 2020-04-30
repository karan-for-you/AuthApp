package com.example.authapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.authapp.R;
import com.example.authapp.databinding.ActivityMainBinding;
import com.example.authapp.databinding.ActivityObserservableBinding;
import com.example.authapp.handler.ObservableHandler;
import com.example.authapp.viewmodel.LoginViewModel;
import com.example.authapp.viewmodel.ObservableViewModel;

public class ObservableActivity extends AppCompatActivity implements ObservableHandler {

    ObservableViewModel observableViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViewBinding();
    }

    private void setupViewBinding(){
        ActivityObserservableBinding activityObserservableBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_obserservable);
        setupViewModelAndHandler(activityObserservableBinding);
    }

    private void setupViewModelAndHandler(ActivityObserservableBinding activityObservableBinding){
        observableViewModel = new ViewModelProvider(this).get(ObservableViewModel.class);
        activityObservableBinding.setViewModel(observableViewModel);
        activityObservableBinding.setHandler(this);
    }

    @Override
    public void onChanged() {

    }
}
