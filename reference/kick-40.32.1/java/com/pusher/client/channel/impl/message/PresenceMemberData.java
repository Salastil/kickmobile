package com.pusher.client.channel.impl.message;

import com.datadog.trace.core.propagation.HttpCodec;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class PresenceMemberData {

    @SerializedName(HttpCodec.RUM_KEY_USER_ID)
    private String id;

    @SerializedName("user_info")
    private Object info;

    public String getId() {
        return this.id;
    }

    public Object getInfo() {
        return this.info;
    }
}
