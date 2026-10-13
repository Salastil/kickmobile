package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzil {
    private static final zzpq<zzgj> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzio
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            zzgj zzgjVar = (zzgj) zzcsVar;
            return zzcx.zza("type.googleapis.com/google.crypto.tink.XAesGcmKey", zzil.zza(zzgjVar.zzc()), ((zzyn) ((zzalt) zzyn.zzb().zza((zzyq) ((zzalt) zzyq.zzb().zza(zzgjVar.zzb()).zze())).zze())).a_());
        }
    }, zzgj.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzin
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzil.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.XAesGcmKey");
    private static final zzoh<zzgf> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zziq
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzgf zzgfVar = (zzgf) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.XAesGcmKey", ((zzyk) ((zzalt) zzyk.zzb().zza(zzakb.zza(zzgfVar.zze().zza(zzdd.zza(zzddVar)))).zza((zzyq) ((zzalt) zzyq.zzb().zza(((zzgj) ((zzdo) zzgfVar.zza())).zzb()).zze())).zze())).a_(), zzcw.zzb, zzil.zza(((zzgj) ((zzdo) zzgfVar.zza())).zzc()), zzgfVar.zzb());
        }
    }, zzgf.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzip
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzil.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.XAesGcmKey");

    private static zzcv zza(zzgj.zza zzaVar) throws GeneralSecurityException {
        if (Objects.equals(zzaVar, zzgj.zza.zza)) {
            return zzcv.zzb;
        }
        if (Objects.equals(zzaVar, zzgj.zza.zzb)) {
            return zzcv.zzd;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzaVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgf zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseKey");
        }
        try {
            zzyk zzykVarZza = zzyk.zza(zzctVar.zzc(), zzalf.zza());
            if (zzykVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzykVarZza.zze().zza() != 32) {
                throw new GeneralSecurityException("Only 32 byte key size is accepted");
            }
            return zzgf.zza(zzgj.zza(zza(zzctVar.zzb()), zzykVarZza.zzd().zza()), zzaav.zza(zzykVarZza.zze().zzc(), zzdd.zza(zzddVar)), zzctVar.zzd());
        } catch (zzamd unused) {
            throw new GeneralSecurityException("Parsing XAesGcmKey failed");
        }
    }

    private static zzgj.zza zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzb) {
            return zzgj.zza.zza;
        }
        if (zzcvVar == zzcv.zzd) {
            return zzgj.zza.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgj zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            zzyn zzynVarZza = zzyn.zza(zzcxVar.zzb(), zzalf.zza());
            if (zzynVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            return zzgj.zza(zza(zzcxVar.zza()), zzynVarZza.zzd().zza());
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing XAesGcmParameters failed: ", e);
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
