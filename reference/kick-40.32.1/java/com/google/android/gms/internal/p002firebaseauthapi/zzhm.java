package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhm {
    private static final zzpq<zzes> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhl
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            zzes zzesVar = (zzes) zzcsVar;
            return zzcx.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzhm.zza(zzesVar.zzd()), ((zzuv) ((zzalt) zzuv.zzc().zza(zzesVar.zzb()).zze())).a_());
        }
    }, zzes.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzho
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzhm.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesGcmSivKey");
    private static final zzoh<zzen> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhn
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzen zzenVar = (zzen) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzus) ((zzalt) zzus.zzb().zza(zzakb.zza(zzenVar.zzf().zza(zzdd.zza(zzddVar)))).zze())).a_(), zzcw.zzb, zzhm.zza(((zzes) ((zzdo) zzenVar.zza())).zzd()), zzenVar.zzb());
        }
    }, zzen.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhq
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzhm.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesGcmSivKey");

    private static zzcv zza(zzes.zza zzaVar) throws GeneralSecurityException {
        if (zzaVar.equals(zzes.zza.zza)) {
            return zzcv.zzb;
        }
        if (zzaVar.equals(zzes.zza.zzb)) {
            return zzcv.zze;
        }
        if (zzaVar.equals(zzes.zza.zzc)) {
            return zzcv.zzd;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzaVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzen zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            zzus zzusVarZza = zzus.zza(zzctVar.zzc(), zzalf.zza());
            if (zzusVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzen.zze().zza(zzes.zzc().zza(zzusVarZza.zzd().zza()).zza(zza(zzctVar.zzb())).zza()).zza(zzaav.zza(zzusVarZza.zzd().zzc(), zzdd.zza(zzddVar))).zza(zzctVar.zzd()).zza();
        } catch (zzamd unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    private static zzes.zza zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzb) {
            return zzes.zza.zza;
        }
        if (zzcvVar == zzcv.zze) {
            return zzes.zza.zzb;
        }
        if (zzcvVar == zzcv.zzc) {
            return zzes.zza.zzb;
        }
        if (zzcvVar == zzcv.zzd) {
            return zzes.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzes zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            zzuv zzuvVarZza = zzuv.zza(zzcxVar.zzb(), zzalf.zza());
            if (zzuvVarZza.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            return zzes.zzc().zza(zzuvVarZza.zza()).zza(zza(zzcxVar.zza())).zza();
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzpf zzpfVarZza = zzpf.zza();
        zzpfVarZza.zza(zza);
        zzpfVarZza.zza(zzb);
        zzpfVarZza.zza(zzc);
        zzpfVarZza.zza(zzd);
    }
}
