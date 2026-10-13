package com.google.android.gms.internal.pal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zznk extends zznm {
    private final transient zznm zza;

    zznk(zznm zznmVar) {
        this.zza = zznmVar;
    }

    private final int zzm(int i) {
        return (this.zza.size() - 1) - i;
    }

    @Override // com.google.android.gms.internal.pal.zznm, com.google.android.gms.internal.pal.zznh, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i) {
        zznm zznmVar = this.zza;
        zzls.zzh(i, zznmVar.size(), FirebaseAnalytics.Param.INDEX);
        return zznmVar.get(zzm(i));
    }

    @Override // com.google.android.gms.internal.pal.zznm, java.util.List
    public final int indexOf(Object obj) {
        int iLastIndexOf = this.zza.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return zzm(iLastIndexOf);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.pal.zznm, java.util.List
    public final int lastIndexOf(Object obj) {
        int iIndexOf = this.zza.indexOf(obj);
        if (iIndexOf >= 0) {
            return zzm(iIndexOf);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.pal.zznm, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.pal.zznm
    public final zznm zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zznm
    /* JADX INFO: renamed from: zzg */
    public final zznm subList(int i, int i2) {
        zznm zznmVar = this.zza;
        zzls.zzj(i, i2, zznmVar.size());
        return zznmVar.subList(zznmVar.size() - i2, zznmVar.size() - i).zzf();
    }
}
