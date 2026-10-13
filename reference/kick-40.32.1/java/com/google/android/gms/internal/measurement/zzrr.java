package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzrr {
    private zzsx zza;
    private List zzb;
    private List zzc;
    private Uri zzd;
    private Uri zze;

    private zzrr() {
        throw null;
    }

    /* synthetic */ zzrr(byte[] bArr) {
    }

    final zzrr zza(zzsx zzsxVar) {
        this.zza = zzsxVar;
        return this;
    }

    final zzrr zzb(List list) {
        this.zzb = list;
        return this;
    }

    final zzrr zzc(List list) {
        this.zzc = list;
        return this;
    }

    final zzrr zzd(Uri uri) {
        this.zze = uri;
        return this;
    }

    final zzrr zze(Uri uri) {
        this.zzd = uri;
        return this;
    }

    final /* synthetic */ zzsx zzf() {
        return this.zza;
    }

    final /* synthetic */ List zzg() {
        return this.zzb;
    }

    final /* synthetic */ List zzh() {
        return this.zzc;
    }

    final /* synthetic */ Uri zzi() {
        return this.zzd;
    }

    final /* synthetic */ Uri zzj() {
        return this.zze;
    }
}
