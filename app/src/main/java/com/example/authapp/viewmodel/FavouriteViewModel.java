package com.example.authapp.viewmodel;

import android.view.View;
import android.widget.AdapterView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavouriteViewModel extends ViewModel {

    public String name = "";
    public String age = "";
    private String gender = "";
    private String country = "";

    private MutableLiveData<String> userLiveData = new MutableLiveData<>();

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LiveData<String> getFormStatus() {
        return userLiveData;
    }

    public void selectCountry(AdapterView<?> parent, View view, int pos, long id) {
        country = (String) parent.getAdapter().getItem(pos);
    }

    public void validateForm() {
        if (name.length() <= 0) {
            userLiveData.setValue("Invalid Name");
            return;
        }
        if (age.length() <= 0) {
            userLiveData.setValue("Invalid Age");
            return;
        }
        if (gender.length() <= 0) {
            userLiveData.setValue("No Gender Selected");
            return;
        }
        if (country.equals("Select Country")) {
            userLiveData.setValue("Select a country");
            return;
        }
        userLiveData.setValue("Validated Form");
    }


}
