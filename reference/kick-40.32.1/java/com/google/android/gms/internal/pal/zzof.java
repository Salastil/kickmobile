package com.google.android.gms.internal.pal;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzof extends zzod implements Serializable {
    static final zzod zza = new zzof();

    private zzof() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzog zzogVar = (zzog) obj;
        zzog zzogVar2 = (zzog) obj2;
        return zzmz.zzc().zza(zzogVar.zza, zzogVar2.zza).zza(zzogVar.zzb, zzogVar2.zzb).zzb();
    }
}
