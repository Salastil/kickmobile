package com.google.android.gms.internal.cloudmessaging;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.4.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzv extends Handler {
    public zzv() {
        Looper.getMainLooper();
    }

    public zzv(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }

    public zzv(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        Looper.getMainLooper();
    }
}
