package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzahp {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzahp(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzahp zzd(zzaho zzahoVar, Class cls, Class cls2) {
        return new zzahn(cls, cls2, zzahoVar);
    }

    public abstract zzaji zza(zzvz zzvzVar, @Nullable zzwm zzwmVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
