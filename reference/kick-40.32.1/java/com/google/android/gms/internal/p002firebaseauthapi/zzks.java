package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzks extends zzlm {
    private final zzla zza;
    private final zzaav zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlm, com.google.android.gms.internal.p002firebaseauthapi.zzcr
    public final /* synthetic */ zzbt zzc() {
        return (zzla) zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlm, com.google.android.gms.internal.p002firebaseauthapi.zzbt
    public final /* synthetic */ zzcs zza() {
        return (zzkq) zza();
    }

    public static zzks zza(zzla zzlaVar, zzaav zzaavVar) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpec;
        if (zzlaVar == null) {
            throw new GeneralSecurityException("HPKE private key cannot be constructed without an HPKE public key");
        }
        if (zzaavVar == null) {
            throw new GeneralSecurityException("HPKE private key cannot be constructed without secret");
        }
        zzkq.zzf zzfVarZze = ((zzkq) ((zzln) zzlaVar.zza())).zze();
        int iZza = zzaavVar.zza();
        String str = "Encoded private key byte length for " + String.valueOf(zzfVarZze) + " must be %d, not " + iZza;
        if (zzfVarZze == zzkq.zzf.zza) {
            if (iZza != 32) {
                throw new GeneralSecurityException(String.format(str, 32));
            }
        } else if (zzfVarZze == zzkq.zzf.zzb) {
            if (iZza != 48) {
                throw new GeneralSecurityException(String.format(str, 48));
            }
        } else if (zzfVarZze == zzkq.zzf.zzc) {
            if (iZza != 66) {
                throw new GeneralSecurityException(String.format(str, 66));
            }
        } else if (zzfVarZze == zzkq.zzf.zzd) {
            if (iZza != 32) {
                throw new GeneralSecurityException(String.format(str, 32));
            }
        } else {
            if (zzfVarZze != zzkq.zzf.zze) {
                throw new GeneralSecurityException("Unable to validate private key length for " + String.valueOf(zzfVarZze));
            }
            if (iZza != 32) {
                throw new GeneralSecurityException(String.format(str, 32));
            }
        }
        zzkq.zzf zzfVarZze2 = ((zzkq) ((zzln) zzlaVar.zza())).zze();
        byte[] bArrZzb = zzlaVar.zze().zzb();
        byte[] bArrZza = zzaavVar.zza(zzbu.zza());
        if (zzfVarZze2 == zzkq.zzf.zza || zzfVarZze2 == zzkq.zzf.zzb || zzfVarZze2 == zzkq.zzf.zzc) {
            if (zzfVarZze2 == zzkq.zzf.zza) {
                eCParameterSpec = zznv.zza;
            } else if (zzfVarZze2 == zzkq.zzf.zzb) {
                eCParameterSpec = zznv.zzb;
            } else if (zzfVarZze2 == zzkq.zzf.zzc) {
                eCParameterSpec = zznv.zzc;
            } else {
                throw new IllegalArgumentException("Unable to determine NIST curve params for " + String.valueOf(zzfVarZze2));
            }
            BigInteger order = eCParameterSpec.getOrder();
            BigInteger bigIntegerZza = zznu.zza(bArrZza);
            if (bigIntegerZza.signum() <= 0 || bigIntegerZza.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private key.");
            }
            if (!zznv.zza(bigIntegerZza, eCParameterSpec).equals(zzzn.zza(eCParameterSpec.getCurve(), zzzp.UNCOMPRESSED, bArrZzb))) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        } else if (zzfVarZze2 == zzkq.zzf.zzd) {
            if (!Arrays.equals(zzaas.zza(bArrZza), bArrZzb)) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        } else if (zzfVarZze2 != zzkq.zzf.zze) {
            throw new IllegalArgumentException("Unable to validate key pair for " + String.valueOf(zzfVarZze2));
        }
        return new zzks(zzlaVar, zzaavVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlm
    /* JADX INFO: renamed from: zzd */
    public final /* synthetic */ zzln zza() {
        return (zzkq) ((zzln) this.zza.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlm
    /* JADX INFO: renamed from: zze */
    public final /* synthetic */ zzlp zzc() {
        return this.zza;
    }

    public final zzaav zzf() {
        return this.zzb;
    }

    private zzks(zzla zzlaVar, zzaav zzaavVar) {
        this.zza = zzlaVar;
        this.zzb = zzaavVar;
    }
}
