package com.example.authapp.services.calls;

import com.example.authapp.services.CommonEnqueueValidator;
import com.example.authapp.services.NetworkCallResponse;
import com.example.authapp.services.ServiceBuilder;
import com.example.authapp.services.WebServiceInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class LoginCallApi {

    private static final String APITAG =LoginCallApi.class.getSimpleName();

    public void callLoginApi(String email, String password, NetworkCallResponse mCallback){
        WebServiceInterface webServiceInterface= ServiceBuilder.buildClient(WebServiceInterface.class, "https://stage.smashi.tv/api/");
        Call<ResponseBody> loginCall=webServiceInterface.postLogin(email,password);
        CommonEnqueueValidator commonEnqueueValidator = new CommonEnqueueValidator(loginCall,mCallback, APITAG);
        commonEnqueueValidator.enqueue();
    }


}
