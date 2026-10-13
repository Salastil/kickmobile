package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzbg extends zzbd implements Serializable {
    private final byte[] zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final int zza() {
        byte[] bArr = this.zza;
        boolean z = bArr.length >= 4;
        int length = bArr.length;
        if (z) {
            return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
        }
        throw new IllegalStateException(zzac.zza("HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", Integer.valueOf(length)));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final int zzb() {
        return this.zza.length << 3;
    }

    zzbg(byte[] bArr) {
        this.zza = (byte[]) zzu.zza(bArr);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    final boolean zza(zzbd zzbdVar) {
        if (this.zza.length != zzbdVar.zzd().length) {
            return false;
        }
        boolean z = true;
        int i = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i >= bArr.length) {
                return z;
            }
            z &= bArr[i] == zzbdVar.zzd()[i];
            i++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zzc() {
        return (byte[]) this.zza.clone();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    final byte[] zzd() {
        return this.zza;
    }
}
