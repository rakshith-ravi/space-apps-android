package com.example.dishant.spaceappsui;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dishant on 30/4/17.
 */

public class LoginPost {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("accesstoken")
    @Expose
    private String accesstoken;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    @Override
    public String toString() {
        return "LoginPost{" +
                "success='" + getSuccess() + '\'' +
                ", accesstoken='" + getAccesstoken() +
                '}';
    }

}
