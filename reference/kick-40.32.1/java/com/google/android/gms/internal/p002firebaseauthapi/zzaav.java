package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaav {
    private final zzaau zza;

    public final int zza() {
        return this.zza.zza();
    }

    public static zzaav zza(byte[] bArr, zzdd zzddVar) {
        if (zzddVar == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return new zzaav(zzaau.zza(bArr));
    }

    public static zzaav zza(int i) {
        return new zzaav(zzaau.zza(zzqm.zza(i)));
    }

    private zzaav(zzaau zzaauVar) {
        this.zza = zzaauVar;
    }

    public final byte[] zza(zzdd zzddVar) {
        if (zzddVar == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return this.zza.zzb();
    }
}
