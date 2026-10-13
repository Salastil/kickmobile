package com.google.android.gms.internal.pal;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzlq implements Serializable {
    zzlq() {
    }

    public static zzlq zze() {
        return zzlg.zza;
    }

    public static zzlq zzf(Object obj) {
        obj.getClass();
        return new zzlt(obj);
    }

    public static zzlq zzg(Object obj) {
        return obj == null ? zzlg.zza : new zzlt(obj);
    }

    public abstract boolean zza();

    public abstract Object zzb();

    public abstract Object zzc(Object obj);

    public abstract zzlq zzd(zzlo zzloVar);
}
