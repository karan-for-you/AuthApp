package com.example.authapp.services;

import androidx.annotation.NonNull;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by karanjeet on 5/8/19
 *
 * To get rid of duplicated blocks, this validation util class will serve as
 * a common functionality to supply with a callback to the respective class
 * where the API was called. Thus, resulting not only in fewer lines but also
 * prevailing the efficiency.
 */
public class CommonEnqueueValidator {

    private Call<ResponseBody> call;
    private NetworkCallResponse networkCallResponse;
    private String apiTag;

    public CommonEnqueueValidator(Call<ResponseBody> call, NetworkCallResponse networkCallResponse, String apiTag){
        this.call = call;
        this.networkCallResponse = networkCallResponse;
        this.apiTag = apiTag;
    }

    public void enqueue(){
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    networkCallResponse.networkCallResponse(true, apiTag, response);
                } else {
                    networkCallResponse.networkCallResponse(false, apiTag, response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                networkCallResponse.networkFailureResponse(false, apiTag,t);
            }
        });
    }

}
