package com.google.android.gms.internal.cast;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhs extends zzhp {
    public zzhs() {
        super(4);
    }

    public final zzhv zzc() {
        this.zzc = true;
        return zzhv.zzk(this.zza, this.zzb);
    }

    public final zzhs zzb(Object obj) {
        obj.getClass();
        int length = this.zza.length;
        int iZza = zzhp.zza(length, this.zzb + 1);
        if (iZza > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, iZza);
            this.zzc = false;
        }
        Object[] objArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr[i] = obj;
        return this;
    }
}
