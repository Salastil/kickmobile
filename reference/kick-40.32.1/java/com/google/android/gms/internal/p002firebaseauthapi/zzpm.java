package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzpm {
    private final String zza;

    public static zzpm zza(zzpo zzpoVar, String str) {
        return new zzpl(str, zzpoVar);
    }

    public abstract zzcs zza(zzcx zzcxVar) throws GeneralSecurityException;

    public final String zza() {
        return this.zza;
    }

    private zzpm(String str) {
        this.zza = str;
    }
}
