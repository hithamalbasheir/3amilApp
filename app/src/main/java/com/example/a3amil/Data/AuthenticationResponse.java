package com.example.a3amil.Data;

import com.google.gson.annotations.SerializedName;

public class AuthenticationResponse {
    @SerializedName("access")
    private String access;
    @SerializedName("refresh")
    private String refresh;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String access) {
        this.access = access;
    }

    public String getAccess() {
        return access;
    }

    public String getRefresh() {
        return refresh;
    }
}
