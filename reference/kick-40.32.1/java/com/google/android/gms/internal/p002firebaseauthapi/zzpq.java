package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzcs;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzpq<ParametersT extends zzcs> {
    private final Class<ParametersT> zza;

    public static <ParametersT extends zzcs> zzpq<ParametersT> zza(zzps<ParametersT> zzpsVar, Class<ParametersT> cls) {
        return new zzpp(cls, zzcx.class, zzpsVar);
    }

    public abstract zzcx zza(ParametersT parameterst) throws GeneralSecurityException;

    public final Class<ParametersT> zza() {
        return this.zza;
    }

    private zzpq(Class<ParametersT> cls, Class<zzcx> cls2) {
        this.zza = cls;
    }
}
