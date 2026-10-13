package com.google.android.gms.internal.pal;

import java.io.Serializable;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zznr extends zzmi implements Serializable {
    public static final /* synthetic */ int zza = 0;
    private static final zznr zzb;
    private static final zznr zzc;
    private final transient zznm zzd;

    static {
        int i = zznm.zzd;
        zzb = new zznr(zzoi.zza, null);
        zzc = new zznr(zznm.zzi(zzog.zza()), null);
    }

    zznr(zznm zznmVar) {
        this.zzd = zznmVar;
    }

    private zznr(zznm zznmVar, zznr zznrVar) {
        this.zzd = zznmVar;
    }

    public static zznr zza() {
        return zzb;
    }

    static zznr zzb() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzoh
    public final /* bridge */ /* synthetic */ Set zzc() {
        zznm zznmVar = this.zzd;
        if (zznmVar.isEmpty()) {
            return zzoo.zza;
        }
        int i = zzog.zzc;
        return new zzop(zznmVar, zzof.zza);
    }
}
