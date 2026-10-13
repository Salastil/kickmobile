package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzahm {
    private final zzarq zza;
    private final Class zzb;

    /* synthetic */ zzahm(zzarq zzarqVar, Class cls, byte[] bArr) {
        this.zza = zzarqVar;
        this.zzb = cls;
    }

    public static zzahm zzd(zzahl zzahlVar, zzarq zzarqVar, Class cls) {
        return new zzahk(zzarqVar, cls, zzahlVar);
    }

    public abstract zzvz zza(zzaji zzajiVar, @Nullable zzwm zzwmVar) throws GeneralSecurityException;

    public final zzarq zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
