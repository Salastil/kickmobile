package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzbe extends zzbq {
    zzbe() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final long zza() {
        return SystemClock.elapsedRealtime() * 1000000;
    }
}
