package com.pusher.client.user.impl.message;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class AuthenticationResponse {
    private String auth;

    @SerializedName("user_data")
    private String userData;

    public String getAuth() {
        return this.auth;
    }

    public String getUserData() {
        return this.userData;
    }
}
