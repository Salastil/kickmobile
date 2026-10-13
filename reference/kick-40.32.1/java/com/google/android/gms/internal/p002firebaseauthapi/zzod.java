package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzod {
    private final String zza;

    public static zzod zza(zzof zzofVar, String str) {
        return new zzog(str, zzofVar);
    }

    public abstract zzbt zza(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException;

    public final String zza() {
        return this.zza;
    }

    private zzod(String str) {
        this.zza = str;
    }
}
