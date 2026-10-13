package com.google.android.gms.internal.cast;

import android.util.Log;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzgk extends zzgj {
    private zzgk() {
        throw null;
    }

    /* synthetic */ zzgk(byte[] bArr) {
    }

    @Override // com.google.android.gms.internal.cast.zzgj, com.google.android.gms.internal.cast.zzgf
    public final void zze(Status status) {
        if (status.isSuccess()) {
            return;
        }
        String strValueOf = String.valueOf(status);
        String.valueOf(strValueOf);
        Log.e("UsageReportingClientImp", "disconnect(): Could not unregister listener: status=".concat(String.valueOf(strValueOf)));
    }
}
