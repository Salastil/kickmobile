package com.google.android.gms.cast;

import java.util.Collection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzs {
    private String zza = "com.google.android.gms.cast.CATEGORY_CAST";
    private String zzb;
    private Collection zzc;

    private zzs() {
    }

    /* synthetic */ zzs(byte[] bArr) {
    }

    final /* synthetic */ zzs zza(String str) {
        this.zza = "com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK";
        return this;
    }

    final /* synthetic */ zzs zzb(String str) {
        this.zzb = str;
        return this;
    }

    final /* synthetic */ zzs zzc(Collection collection) {
        this.zzc = collection;
        return this;
    }

    final /* synthetic */ zzt zzd() {
        return new zzt(this.zza, this.zzb, this.zzc, false, true, null);
    }
}
