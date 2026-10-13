package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzais {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzais(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzais zzd(zzair zzairVar, Class cls, Class cls2) {
        return new zzaiq(cls, cls2, zzairVar);
    }

    public abstract zzaji zza(zzwk zzwkVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
