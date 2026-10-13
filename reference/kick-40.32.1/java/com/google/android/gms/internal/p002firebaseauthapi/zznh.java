package com.google.android.gms.internal.p002firebaseauthapi;

import android.crypto.hpke.Hpke;
import com.facebook.react.ReactRootView$$ExternalSyntheticApiModelOutline0;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zznh implements zzbs {
    private static final byte[] zza = new byte[0];
    private static final byte[] zzb = "Workload".getBytes(StandardCharsets.UTF_8);
    private static final byte[] zzc = "ContextInfo".getBytes(StandardCharsets.UTF_8);
    private final PrivateKey zzd;
    private final String zze;
    private final int zzf;
    private final byte[] zzg;

    public static zzbs zza(zzks zzksVar) throws GeneralSecurityException {
        String str;
        if (!zznj.zza()) {
            throw new GeneralSecurityException("Can't use X-Wing, as we might be in FIPS mode, Conscrypt is not available, or platform does not support X-Wing.");
        }
        Provider providerZza = zznt.zza();
        if (providerZza == null) {
            throw new GeneralSecurityException("Can't use X-Wing as Conscrypt is not available");
        }
        zzkq zzkqVar = (zzkq) ((zzln) zzksVar.zza());
        if (zzkqVar.zze() != zzkq.zzf.zze) {
            throw new GeneralSecurityException("Currently unsupported KEM: " + String.valueOf(zzkqVar.zze()));
        }
        if (zzkqVar.zzd() != zzkq.zzc.zza) {
            throw new GeneralSecurityException("Currently unsupported KDF: " + String.valueOf(zzkqVar.zzd()));
        }
        if (zzkqVar.zzb() == zzkq.zzb.zza) {
            str = "XWING/HKDF_SHA256/AES_128_GCM";
        } else if (zzkqVar.zzb() == zzkq.zzb.zzb) {
            str = "XWING/HKDF_SHA256/AES_256_GCM";
        } else {
            if (zzkqVar.zzb() != zzkq.zzb.zzc) {
                throw new GeneralSecurityException("Unknown AEAD ID: " + String.valueOf(zzkqVar.zzb()));
            }
            str = "XWING/HKDF_SHA256/CHACHA20POLY1305";
        }
        zznh zznhVar = new zznh(KeyFactory.getInstance("XWING", providerZza).generatePrivate(new zznk(zzksVar.zzf().zza(zzbu.zza()))), str, zzms.zza(zzkqVar.zze()), zzksVar.zzh().zzb());
        zzbr zzbrVarZza = zznj.zza((zzla) ((zzlp) zzksVar.zzc()));
        byte[] bArr = zzb;
        byte[] bArr2 = zzc;
        if (Arrays.equals(zznhVar.zza(zzbrVarZza.zza(bArr, bArr2), bArr2), bArr)) {
            return zznhVar;
        }
        throw new GeneralSecurityException("Public key and private key do not match, cannot create HybridDecrypt instance");
    }

    private zznh(PrivateKey privateKey, String str, int i, byte[] bArr) {
        this.zzd = privateKey;
        this.zze = str;
        this.zzf = i;
        this.zzg = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbs
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzg;
        int length = bArr3.length + this.zzf;
        if (bArr.length < length) {
            throw new GeneralSecurityException("Ciphertext is too short");
        }
        if (!zzqu.zza(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, this.zzg.length, length);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, length, bArr.length);
        return Hpke.getInstance(this.zze).open(this.zzd, bArr2, ReactRootView$$ExternalSyntheticApiModelOutline0.m(bArrCopyOfRange, bArrCopyOfRange2), zza);
    }
}
