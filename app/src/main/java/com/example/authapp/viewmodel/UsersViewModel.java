package com.example.authapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UsersViewModel extends ViewModel {

    private MutableLiveData<List<String>> userList = new MutableLiveData<>();

    public LiveData<List<String>> prepareAndReturnUserList() {
        List<String> users = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
            users.add("User " + i);
        userList.setValue(users);
        return userList;
    }

}
