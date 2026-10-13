package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzce extends zzbv {
    public zzce() {
        super(4);
    }

    public final zzce zzb(Object obj) {
        obj.getClass();
        int length = this.zza.length;
        int iZza = zzbv.zza(length, this.zzb + 1);
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

    public final zzcf zzc() {
        int i = this.zzb;
        if (i == 0) {
            return zzcp.zza;
        }
        if (i == 1) {
            return new zzcr(Objects.requireNonNull(this.zza[0]));
        }
        zzcf zzcfVarZzm = zzcf.zzm(i, this.zza);
        this.zzb = zzcfVarZzm.size();
        this.zzc = true;
        return zzcfVarZzm;
    }
}
