package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zztr {
    zztr() {
    }

    public static zztq zzh() {
        zztd zztdVar = new zztd();
        zztdVar.zzd(zztw.zza());
        zztdVar.zzf(false);
        zztdVar.zze(true);
        return zztdVar;
    }

    public abstract Uri zza();

    public abstract zzafc zzb();

    public abstract Optional zzc();

    public abstract ImmutableList zzd();

    public abstract zzuj zze();

    public abstract boolean zzf();

    abstract boolean zzg();
}
