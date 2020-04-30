package com.example.authapp.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.authapp.model.User;

public class ObservableViewModel extends ViewModel {

    private ObservableField<User> observableField = new ObservableField<>();

    public int getAge() {
        return observableField.get().getAge();
    }
    public void setAge(int newAge) {
        observableField.get().setAge(newAge);
    }

}
