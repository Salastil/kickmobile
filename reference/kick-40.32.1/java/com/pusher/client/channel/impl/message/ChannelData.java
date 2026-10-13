package com.pusher.client.channel.impl.message;

import com.datadog.trace.core.propagation.HttpCodec;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class ChannelData {

    @SerializedName(HttpCodec.RUM_KEY_USER_ID)
    private String userId;

    public String getUserId() {
        return this.userId;
    }
}
