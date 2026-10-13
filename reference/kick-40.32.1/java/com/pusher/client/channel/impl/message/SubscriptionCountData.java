package com.pusher.client.channel.impl.message;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class SubscriptionCountData {

    @SerializedName("subscription_count")
    public Integer count;

    public int getCount() {
        return this.count.intValue();
    }
}
