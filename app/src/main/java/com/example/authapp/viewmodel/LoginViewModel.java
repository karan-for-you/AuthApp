package com.example.authapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.authapp.model.LoginResponse;
import com.example.authapp.services.NetworkCallResponse;
import com.example.authapp.services.calls.LoginCallApi;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class LoginViewModel extends ViewModel implements NetworkCallResponse {
    public String userName = "";
    public String password = "";
    public boolean rememberMeFlag = true;

    private MutableLiveData<String> loginMessage = new MutableLiveData<String>();

    private MutableLiveData<LoginResponse> loginResponse = new MutableLiveData<>();

    public LiveData<String> getLoginMessage() {
        return loginMessage;
    }

    public LiveData<LoginResponse> getLoginDataResponse() {
        return loginResponse;
    }

    public void validateCredentials() {
        if (userName.length() == 0) {
            loginMessage.setValue("Invalid Username");
            return;
        }
        if (password.length() == 0) {
            loginMessage.setValue("Invalid Password");
            return;
        }

        loginMessage.setValue("Validated");
    }

    public void callLoginApi() {
        LoginResponse temp = new LoginResponse();
        if (userName.isEmpty()) {
            temp.setMessage("Empty Email");
            loginResponse.setValue(temp);
            return;
        }
        if (password.isEmpty()) {
            temp.setMessage("Empty Password");
            loginResponse.setValue(temp);
            return;
        }
        LoginCallApi loginCall = new LoginCallApi();
        loginCall.callLoginApi(userName, password, this);
    }


    @Override
    public void networkCallResponse(Boolean result, String apiTag, Response<ResponseBody> responseBody) {
        try {
            if (apiTag.equals(LoginCallApi.class.getSimpleName())) {
                if (result) {
                    LoginResponse loginResponseApi = new Gson().fromJson(responseBody.body().string(), LoginResponse.class);
                    if (loginResponseApi != null && loginResponseApi.getResponseObject() != null)
                        loginResponse.setValue(loginResponseApi);
                } else {
                    String resultString = responseBody.errorBody().string();
                    JSONObject jsonObject = new JSONObject(resultString);
                    String message = jsonObject.getString("message_en");
                    LoginResponse temp = new LoginResponse();
                    temp.setMessage(message);
                    loginResponse.setValue(temp);
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void networkFailureResponse(Boolean response, String apiTag, Throwable throwable) {
        LoginResponse loginResponseApi = new LoginResponse();
        loginResponseApi.setMessage("Problem Calling API");
        loginResponse.setValue(loginResponseApi);
    }

    public void checkValue(boolean val){
        Log.d("Switch Value",""+val);
    }

    public void checkboxValue(boolean val){
        Log.d("Check Box",""+val);
    }

}
