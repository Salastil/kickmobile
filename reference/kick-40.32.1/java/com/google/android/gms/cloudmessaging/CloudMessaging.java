package com.google.android.gms.cloudmessaging;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.4.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class CloudMessaging {
    private CloudMessaging() {
    }

    public static CloudMessagingClient getClient(Context context) {
        return new com.google.android.gms.internal.cloudmessaging.zzm(context);
    }
}
