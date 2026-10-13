package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzns extends zznf {
    public zzns() {
        super(4);
    }

    zzns zze(zzns zznsVar) {
        zzb(zznsVar.zza, zznsVar.zzb);
        return this;
    }

    public zzns zzd(Object obj) {
        obj.getClass();
        super.zza(obj);
        return this;
    }

    public zznt zzf() {
        int i = this.zzb;
        if (i == 0) {
            return zzoo.zza;
        }
        if (i == 1) {
            return new zzor(Objects.requireNonNull(this.zza[0]));
        }
        zznt zzntVarZzk = zznt.zzk(i, this.zza);
        this.zzb = zzntVarZzk.size();
        this.zzc = true;
        return zzntVarZzk;
    }
}
