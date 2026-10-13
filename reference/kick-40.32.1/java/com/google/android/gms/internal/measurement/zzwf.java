package com.google.android.gms.internal.measurement;

import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzwf extends zzvt implements zzvs {
    private final Exception zza;
    private final boolean zzb;

    zzwf(String str, zzvs zzvsVar, zzwl zzwlVar, boolean z, zzwq zzwqVar) {
        super("<missing root>:".concat(str), zzvsVar, zzwl.zza(zzwlVar, zzwk.zzb), zzwqVar);
        this.zza = zzvsVar.zzf();
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzvs
    public final Exception zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzvs
    public final zzws zzg(String str, zzwl zzwlVar, boolean z, zzwq zzwqVar) {
        if (z && !this.zzb) {
            int i = zzvy.zzb;
        }
        boolean z2 = true;
        if ((!z || this.zzb) && !this.zzb) {
            z2 = false;
        }
        return new zzwf(str, this, zzwlVar, z2, zzwqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final zzws zzj(String str, String str2, String str3, int i, zzwl zzwlVar, zzwq zzwqVar) {
        int i2 = zzvy.zzb;
        return zzg(str, zzwlVar, true, zzwqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final long zzk() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final zzwl zzl() {
        return zzwk.zza;
    }

    zzwf(UUID uuid, String str, String str2, zzwl zzwlVar, Exception exc, boolean z, boolean z2, zzwq zzwqVar) {
        super("<missing root>:".concat(str2), uuid, str, zzwl.zza(zzwlVar, zzwk.zzb), zzwqVar);
        this.zza = exc;
        this.zzb = false;
    }
}
