package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzzs implements zzbm {
    private final zzaah zza;
    private final zzcp zzb;
    private final int zzc;
    private final byte[] zzd;

    public static zzbm zza(zzdp zzdpVar) throws GeneralSecurityException {
        return new zzzs(new zzyz(zzdpVar.zzf().zza(zzbu.zza()), ((zzdw) ((zzdo) zzdpVar.zza())).zzd()), new zzaan(new zzaal("HMAC" + String.valueOf(((zzdw) ((zzdo) zzdpVar.zza())).zzg()), new SecretKeySpec(zzdpVar.zzg().zza(zzbu.zza()), "HMAC")), ((zzdw) ((zzdo) zzdpVar.zza())).zze()), ((zzdw) ((zzdo) zzdpVar.zza())).zze(), zzdpVar.zzd().zzb());
    }

    private zzzs(zzaah zzaahVar, zzcp zzcpVar, int i, byte[] bArr) {
        this.zza = zzaahVar;
        this.zzb = zzcpVar;
        this.zzc = i;
        this.zzd = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzc;
        byte[] bArr3 = this.zzd;
        if (length < i + bArr3.length) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        }
        if (!zzqu.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, this.zzd.length, bArr.length - this.zzc);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.zzc, bArr.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this.zzb.zza(bArrCopyOfRange2, zzzi.zza(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8)));
        return this.zza.zza(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrZzb = this.zza.zzb(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzzi.zza(this.zzd, bArrZzb, this.zzb.zza(zzzi.zza(bArr2, bArrZzb, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))));
    }
}
