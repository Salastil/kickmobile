package com.google.android.gms.internal.measurement;

import android.os.SystemClock;
import com.google.common.base.Ticker;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzxf extends Ticker {
    zzxf() {
    }

    @Override // com.google.common.base.Ticker
    public final long read() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
