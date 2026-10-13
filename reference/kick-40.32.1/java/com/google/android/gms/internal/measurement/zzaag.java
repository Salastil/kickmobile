package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzaag extends zzzf {
    private final String zza;

    protected zzaag(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public void zzd(RuntimeException runtimeException, zzzd zzzdVar) {
        Log.e("AbstractAndroidBackend", "Internal logging error", runtimeException);
    }
}
