package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzhd {
    private static final zzpq<zzel> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhg
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            return zzhd.zza((zzel) zzcsVar);
        }
    }, zzel.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhf
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzhd.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesGcmKey");
    private static final zzoh<zzee> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhi
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            return zzhd.zza((zzee) zzbtVar, zzddVar);
        }
    }, zzee.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhh
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzhd.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesGcmKey");

    private static zzcv zza(zzel.zzb zzbVar) throws GeneralSecurityException {
        if (zzbVar.equals(zzel.zzb.zza)) {
            return zzcv.zzb;
        }
        if (zzbVar.equals(zzel.zzb.zzb)) {
            return zzcv.zze;
        }
        if (zzbVar.equals(zzel.zzb.zzc)) {
            return zzcv.zzd;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzbVar));
    }

    public static /* synthetic */ zzct zza(zzee zzeeVar, zzdd zzddVar) throws GeneralSecurityException {
        zzb((zzel) ((zzdo) zzeeVar.zza()));
        return zzct.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzum) ((zzalt) zzum.zzb().zza(zzakb.zza(zzeeVar.zzf().zza(zzdd.zza(zzddVar)))).zze())).a_(), zzcw.zzb, zza(((zzel) ((zzdo) zzeeVar.zza())).zzf()), zzeeVar.zzb());
    }

    public static /* synthetic */ zzcx zza(zzel zzelVar) throws GeneralSecurityException {
        zzb(zzelVar);
        return zzcx.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", zza(zzelVar.zzf()), ((zzup) ((zzalt) zzup.zzc().zza(zzelVar.zzc()).zze())).a_());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzee zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            zzum zzumVarZza = zzum.zza(zzctVar.zzc(), zzalf.zza());
            if (zzumVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzee.zze().zza(zzel.zze().zzb(zzumVarZza.zzd().zza()).zza(12).zzc(16).zza(zza(zzctVar.zzb())).zza()).zza(zzaav.zza(zzumVarZza.zzd().zzc(), zzdd.zza(zzddVar))).zza(zzctVar.zzd()).zza();
        } catch (zzamd unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    private static zzel.zzb zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzb) {
            return zzel.zzb.zza;
        }
        if (zzcvVar == zzcv.zze) {
            return zzel.zzb.zzb;
        }
        if (zzcvVar == zzcv.zzc) {
            return zzel.zzb.zzb;
        }
        if (zzcvVar == zzcv.zzd) {
            return zzel.zzb.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzel zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            zzup zzupVarZza = zzup.zza(zzcxVar.zzb(), zzalf.zza());
            if (zzupVarZza.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            return zzel.zze().zzb(zzupVarZza.zza()).zza(12).zzc(16).zza(zza(zzcxVar.zza())).zza();
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzpf zzpfVarZza = zzpf.zza();
        zzpfVarZza.zza(zza);
        zzpfVarZza.zza(zzb);
        zzpfVarZza.zza(zzc);
        zzpfVarZza.zza(zzd);
    }

    private static void zzb(zzel zzelVar) throws GeneralSecurityException {
        if (zzelVar.zzd() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports serialization of AES GCM keys with tag size equal to 16 bytes.", Integer.valueOf(zzelVar.zzd())));
        }
        if (zzelVar.zzb() != 12) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d. Currently Tink only supports serialization of AES GCM keys with IV size equal to 12 bytes.", Integer.valueOf(zzelVar.zzb())));
        }
    }
}
