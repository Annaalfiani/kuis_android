package com.annaalfianim.annaalfianim.kuis_atk.networks;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {
    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private int status;

    @SerializedName("data")
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(String message, int status, T data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
