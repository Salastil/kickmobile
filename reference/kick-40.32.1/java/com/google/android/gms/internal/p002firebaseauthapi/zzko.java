package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzko extends zzlm {
    private final zzkr zza;

    @Nullable
    private final zzaat zzb;

    @Nullable
    private final zzaav zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlm, com.google.android.gms.internal.p002firebaseauthapi.zzcr
    public final /* synthetic */ zzbt zzc() {
        return (zzkr) zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlm, com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final /* synthetic */ zzcs zza() {
        return (zzkl) zza();
    }

    public static zzko zza(zzkr zzkrVar, zzaav zzaavVar) throws GeneralSecurityException {
        if (zzkrVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        }
        if (zzkrVar.zze() == null) {
            throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
        }
        if (zzaavVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        byte[] bArrZza = zzaavVar.zza(zzbu.zza());
        byte[] bArrZzb = zzkrVar.zze().zzb();
        if (bArrZza.length != 32) {
            throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
        }
        if (!Arrays.equals(zzaas.zza(bArrZza), bArrZzb)) {
            throw new GeneralSecurityException("Invalid private key for public key.");
        }
        return new zzko(zzkrVar, null, zzaavVar);
    }

    public static zzko zza(zzkr zzkrVar, zzaat zzaatVar) throws GeneralSecurityException {
        if (zzkrVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        }
        if (zzkrVar.zzf() == null) {
            throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
        }
        if (zzaatVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        BigInteger bigIntegerZza = zzaatVar.zza(zzbu.zza());
        ECPoint eCPointZzf = zzkrVar.zzf();
        zzkl.zzc zzcVarZzd = ((zzkl) ((zzln) zzkrVar.zza())).zzd();
        BigInteger order = zza(zzcVarZzd).getOrder();
        if (bigIntegerZza.signum() <= 0 || bigIntegerZza.compareTo(order) >= 0) {
            throw new GeneralSecurityException("Invalid private value");
        }
        if (!zznv.zza(bigIntegerZza, zza(zzcVarZzd)).equals(eCPointZzf)) {
            throw new GeneralSecurityException("Invalid private value");
        }
        return new zzko(zzkrVar, zzaatVar, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlm
    /* JADX INFO: renamed from: zzd */
    public final /* synthetic */ zzln zza() {
        return (zzkl) ((zzln) this.zza.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlm
    /* JADX INFO: renamed from: zze */
    public final /* synthetic */ zzlp zzc() {
        return this.zza;
    }

    @Nullable
    public final zzaat zzf() {
        return this.zzb;
    }

    @Nullable
    public final zzaav zzg() {
        return this.zzc;
    }

    private static ECParameterSpec zza(zzkl.zzc zzcVar) {
        if (zzcVar == zzkl.zzc.zza) {
            return zznv.zza;
        }
        if (zzcVar == zzkl.zzc.zzb) {
            return zznv.zzb;
        }
        if (zzcVar == zzkl.zzc.zzc) {
            return zznv.zzc;
        }
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzcVar));
    }

    private zzko(zzkr zzkrVar, @Nullable zzaat zzaatVar, @Nullable zzaav zzaavVar) {
        this.zza = zzkrVar;
        this.zzb = zzaatVar;
        this.zzc = zzaavVar;
    }
}
