package com.example.authapp.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.authapp.R;
import com.example.authapp.databinding.ActivityUsersBinding;
import com.example.authapp.handler.UserHandler;
import com.example.authapp.view.adapter.UsersAdapter;
import com.example.authapp.viewmodel.UsersViewModel;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity implements UserHandler {

    UsersViewModel usersViewModel;
    List<String> userList = new ArrayList<>();
    ActivityUsersBinding activityUsersBinding;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBinding();
    }

    private void setupBinding(){
        activityUsersBinding = DataBindingUtil.setContentView(this, R.layout.activity_users);
        usersViewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        activityUsersBinding.setViewModel(usersViewModel);
        activityUsersBinding.setHandler(this);
        setAdapter();
        setupObserver();
    }

    private void setupObserver(){
        usersViewModel.prepareAndReturnUserList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                usersAdapter.addAllUsers(strings);
            }
        });

    }

    private void setAdapter(){
        usersAdapter = new UsersAdapter(this,userList);
        activityUsersBinding.rvUsers.setLayoutManager(new LinearLayoutManager(this));
        activityUsersBinding.rvUsers.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        activityUsersBinding.rvUsers.setAdapter(usersAdapter);
    }

    @Override
    public void onFabClicked() {
        usersAdapter.addOneUser();
    }
}
