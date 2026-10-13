package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzaix {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzaix(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzaix zzd(zzaiw zzaiwVar, Class cls, Class cls2) {
        return new zzaiv(cls, cls2, zzaiwVar);
    }

    public abstract Object zza(zzvz zzvzVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
