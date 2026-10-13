package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaat {
    private final BigInteger zza;

    public static zzaat zza(BigInteger bigInteger, zzdd zzddVar) {
        if (zzddVar != null) {
            return new zzaat(bigInteger);
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public final BigInteger zza(zzdd zzddVar) {
        if (zzddVar == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return this.zza;
    }

    private zzaat(BigInteger bigInteger) {
        this.zza = bigInteger;
    }
}
