package com.google.ads.interactivemedia.pal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.pal.zzaxs;
import com.google.android.gms.internal.pal.zzle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzw implements zzaxs {
    zzw() {
    }

    public static final Handler zza() {
        return new zzle(Looper.getMainLooper());
    }
}
