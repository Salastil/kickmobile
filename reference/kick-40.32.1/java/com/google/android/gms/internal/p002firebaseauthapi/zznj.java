package com.google.android.gms.internal.p002firebaseauthapi;

import android.crypto.hpke.Hpke;
import android.crypto.hpke.Message;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.PublicKey;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zznj implements zzbr {
    private static final zzjd.zza zza = zzjd.zza.zza;
    private static final byte[] zzb = new byte[0];
    private final PublicKey zzc;
    private final String zzd;
    private final int zze;
    private final byte[] zzf;

    public static zzbr zza(zzla zzlaVar) throws GeneralSecurityException {
        String str;
        if (!zza()) {
            throw new GeneralSecurityException("Can't use X-Wing, as we might be in FIPS mode, Conscrypt is not available, or platform does not support X-Wing.");
        }
        Provider providerZza = zznt.zza();
        if (providerZza == null) {
            throw new GeneralSecurityException("Can't use X-Wing as Conscrypt is not available");
        }
        zzkq zzkqVar = (zzkq) ((zzln) zzlaVar.zza());
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
        return new zznj(KeyFactory.getInstance("XWING", providerZza).generatePublic(new zznm(zzlaVar.zze().zzb())), str, zzms.zza(zzkqVar.zze()), zzlaVar.zzd().zzb());
    }

    private zznj(PublicKey publicKey, String str, int i, byte[] bArr) {
        this.zzc = publicKey;
        this.zzd = str;
        this.zze = i;
        this.zzf = bArr;
    }

    public static boolean zza() {
        Provider providerZza;
        if (!zza.zza() || zzqu.zzb() == null || zzqu.zzb().intValue() < 37 || (providerZza = zznt.zza()) == null) {
            return false;
        }
        try {
            KeyFactory.getInstance("XWING", providerZza);
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbr
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        PublicKey publicKey = this.zzc;
        String str = this.zzd;
        int i = this.zze;
        byte[] bArr3 = this.zzf;
        Message messageSeal = Hpke.getInstance(str).seal(publicKey, bArr2, bArr, zzb);
        byte[] encapsulated = messageSeal.getEncapsulated();
        if (encapsulated.length != i) {
            throw new IllegalStateException("Encapsulated key has wrong length");
        }
        return zzzi.zza(bArr3, encapsulated, messageSeal.getCiphertext());
    }
}
