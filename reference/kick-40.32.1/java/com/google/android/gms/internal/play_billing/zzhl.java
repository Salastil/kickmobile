package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhl {
    private final zzhk zza;

    private zzhl(zzjg zzjgVar, Object obj, zzjg zzjgVar2, Object obj2) {
        this.zza = new zzhk(zzjgVar, "", zzjgVar2, obj2);
    }

    static int zzb(zzhk zzhkVar, Object obj, Object obj2) {
        return zzgh.zza(zzhkVar.zza, 1, obj) + zzgh.zza(zzhkVar.zzc, 2, obj2);
    }

    public static zzhl zzd(zzjg zzjgVar, Object obj, zzjg zzjgVar2, Object obj2) {
        return new zzhl(zzjgVar, "", zzjgVar2, obj2);
    }

    static void zze(zzfx zzfxVar, zzhk zzhkVar, Object obj, Object obj2) throws IOException {
        zzgh.zzi(zzfxVar, zzhkVar.zza, 1, obj);
        zzgh.zzi(zzfxVar, zzhkVar.zzc, 2, obj2);
    }

    public final int zza(int i, Object obj, Object obj2) {
        zzhk zzhkVar = this.zza;
        int iZzy = zzfx.zzy(i << 3);
        int iZzb = zzb(zzhkVar, obj, obj2);
        return iZzy + zzfx.zzy(iZzb) + iZzb;
    }

    final zzhk zzc() {
        return this.zza;
    }
}
