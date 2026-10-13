package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpa {
    private static final zzpa zza = new zzpa();
    private final ConcurrentMap<Class<? extends zzcs>, zzoz<? extends zzcs>> zzb = new ConcurrentHashMap();

    public static zzpa zza() {
        return zza;
    }

    public final <ParametersT extends zzcs> void zza(zzoz<ParametersT> zzozVar, Class<ParametersT> cls) throws GeneralSecurityException {
        zzoz<? extends zzcs> zzozVarPutIfAbsent = this.zzb.putIfAbsent(cls, zzozVar);
        if (zzozVarPutIfAbsent != null && !zzozVarPutIfAbsent.equals(zzozVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class already inserted");
        }
    }
}
