package com.example.authapp.model;

public class BaseResponseBody {
    private String message;
    private String message_en;
    private boolean isError;
    private int length_token;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public int getLength_token() {
        return length_token;
    }

    public void setLength_token(int length_token) {
        this.length_token = length_token;
    }

    public String getMessage_en() {
        return message_en;
    }

    public void setMessage_en(String message_en) {
        this.message_en = message_en;
    }
}
