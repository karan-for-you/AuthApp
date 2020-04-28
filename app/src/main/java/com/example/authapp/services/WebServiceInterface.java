package com.example.authapp.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by daljeet and Karan
 * <p>
 * Collection of all the EZBitex Android APP Network Calls referenced by respective separate Network Call classes
 * </p>
 */

public interface WebServiceInterface {
    @POST("api/v2/login")
    Call<ResponseBody> postLogin(
            @Query("email") String  email,
            @Query("password")  String password
    );
}
