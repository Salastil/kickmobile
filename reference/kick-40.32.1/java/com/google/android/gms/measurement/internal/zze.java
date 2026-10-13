package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zze {
    private final zzji zza;

    zze(zzji zzjiVar) {
        this.zza = zzjiVar;
    }

    static zze zzc(String str) {
        return new zze((TextUtils.isEmpty(str) || str.length() > 1) ? zzji.UNINITIALIZED : zzjl.zzj(str.charAt(0)));
    }

    final zzji zza() {
        return this.zza;
    }

    final String zzb() {
        return String.valueOf(zzjl.zzm(this.zza));
    }
}
