package com.google.android.gms.internal.measurement;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzcl extends Handler {
    public zzcl() {
        Looper.getMainLooper();
    }

    public zzcl(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }
}
