package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzaip {
    private final zzarq zza;
    private final Class zzb;

    /* synthetic */ zzaip(zzarq zzarqVar, Class cls, byte[] bArr) {
        this.zza = zzarqVar;
        this.zzb = cls;
    }

    public static zzaip zzd(zzaio zzaioVar, zzarq zzarqVar, Class cls) {
        return new zzain(zzarqVar, cls, zzaioVar);
    }

    public abstract zzwk zza(zzaji zzajiVar) throws GeneralSecurityException;

    public final zzarq zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
