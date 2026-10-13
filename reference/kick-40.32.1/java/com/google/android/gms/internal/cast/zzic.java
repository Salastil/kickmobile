package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzic extends zzhv {
    static final zzhv zza = new zzic(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzic(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzhd.zzb(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzhr
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.cast.zzhr
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzhr
    final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzhr
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzhv, com.google.android.gms.internal.cast.zzhr
    final int zzg(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzc;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }
}
