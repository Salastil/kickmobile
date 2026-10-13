package com.google.android.gms.internal.pal;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzru extends zzqt {
    private final String zza;

    protected zzru(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.pal.zzqt
    public String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzqt
    public void zzd(RuntimeException runtimeException, zzqr zzqrVar) {
        Log.e("AbstractAndroidBackend", "Internal logging error", runtimeException);
    }
}
