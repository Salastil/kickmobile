package com.google.android.gms.internal.measurement;

import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwg extends zzvt {
    public static final zzwg zza = new zzwg(UUID.randomUUID());

    private zzwg(UUID uuid) {
        super("<skip trace>", uuid, zzvn.zzcL(uuid), zzwk.zza, zzvy.zzd());
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final zzws zzj(String str, String str2, String str3, int i, zzwl zzwlVar, zzwq zzwqVar) {
        throw new IllegalStateException("Can't create child trace for no trace!");
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final long zzk() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final zzwl zzl() {
        return zzwk.zza;
    }
}
