package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzagh {
    public static zzage zza(zzaeh zzaehVar) throws GeneralSecurityException {
        if (zzaehVar == zzaeh.zzf) {
            return new zzagu(new zzafy("HmacSha256"));
        }
        if (zzaehVar == zzaeh.zza) {
            return zzagp.zzc(zzaqp.NIST_P256);
        }
        if (zzaehVar == zzaeh.zzb) {
            return zzagp.zzc(zzaqp.NIST_P384);
        }
        if (zzaehVar == zzaeh.zzc) {
            return zzagp.zzc(zzaqp.NIST_P521);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }

    public static zzagd zzb(zzaeg zzaegVar) {
        if (zzaegVar == zzaeg.zza) {
            return new zzafy("HmacSha256");
        }
        if (zzaegVar == zzaeg.zzb) {
            return new zzafy("HmacSha384");
        }
        if (zzaegVar == zzaeg.zzc) {
            return new zzafy("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }

    public static zzafz zzc(zzaed zzaedVar) throws GeneralSecurityException {
        if (zzaedVar == zzaed.zza) {
            return new zzafk(16);
        }
        if (zzaedVar == zzaed.zzb) {
            return new zzafk(32);
        }
        if (zzaedVar == zzaed.zzc) {
            return new zzafl();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }
}
