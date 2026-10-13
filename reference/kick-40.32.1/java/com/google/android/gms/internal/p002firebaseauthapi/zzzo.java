package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzo {
    private final zzaau zza;
    private final zzaau zzb;

    public zzzo(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("KemBytes must be non-null");
        }
        if (bArr2 == null) {
            throw new NullPointerException("symmetricKey must be non-null");
        }
        this.zza = zzaau.zza(bArr);
        this.zzb = zzaau.zza(bArr2);
    }

    public final byte[] zza() {
        return this.zza.zzb();
    }

    public final byte[] zzb() {
        return this.zzb.zzb();
    }
}
