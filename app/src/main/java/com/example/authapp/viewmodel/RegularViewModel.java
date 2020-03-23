package com.example.authapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class RegularViewModel extends ViewModel {

    private MutableLiveData<List<String>> listLiveData = new MutableLiveData<>();

    public LiveData<List<String>> getMeLiveData(String prefix){
        List<String> userList = new ArrayList<>();
        for(int i = 0 ; i < 20 ; i++){
            userList.add(prefix+" "+i);
        }
        listLiveData.setValue(userList);
        return listLiveData;
    }

}
