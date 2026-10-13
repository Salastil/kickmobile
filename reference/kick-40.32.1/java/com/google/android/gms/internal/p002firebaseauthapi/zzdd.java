package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdd {
    private static final zzdd zza = new zzdd();

    static zzdd zza() {
        return zza;
    }

    public static zzdd zza(@Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (zzddVar != null) {
            return zzddVar;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }

    private zzdd() {
    }
}
