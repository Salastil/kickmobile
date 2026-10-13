package com.google.android.gms.internal.pal;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzle extends Handler {
    public zzle() {
        Looper.getMainLooper();
    }

    public zzle(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }
}
