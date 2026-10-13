package com.google.android.gms.internal.pal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzoj extends zznm {
    final /* synthetic */ zzok zza;

    zzoj(zzok zzokVar) {
        Objects.requireNonNull(zzokVar);
        this.zza = zzokVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzok zzokVar = this.zza;
        zzls.zzh(i, zzokVar.zzl(), FirebaseAnalytics.Param.INDEX);
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(zzokVar.zzk()[i2]), Objects.requireNonNull(zzokVar.zzk()[i2 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzl();
    }
}
