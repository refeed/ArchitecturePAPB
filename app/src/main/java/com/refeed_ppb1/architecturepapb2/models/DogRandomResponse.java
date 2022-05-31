package com.refeed_ppb1.architecturepapb2.models;

import com.google.gson.annotations.SerializedName;

public class DogRandomResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
