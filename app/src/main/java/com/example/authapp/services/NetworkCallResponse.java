package com.example.authapp.services;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by daljeet on 7/2/18.
 */

public interface NetworkCallResponse {

    void networkCallResponse(Boolean result, String apiTag, Response<ResponseBody> responseBody);

    void networkFailureResponse(Boolean response,String apiTag, Throwable throwable);
}
