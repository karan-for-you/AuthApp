package com.example.authapp.model;

public class LoginResponse extends BaseResponseBody {
    private LoginDetails responseObject;

    public LoginDetails getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(LoginDetails responseObject) {
        this.responseObject = responseObject;
    }
}
