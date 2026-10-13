package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzfj {
    private static final zzpq<zzfh> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfl
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            zzfh zzfhVar = (zzfh) zzcsVar;
            return zzcx.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzfj.zza(zzfhVar.zzb()), ((zzxz) ((zzalt) zzxz.zza().zza(zzfhVar.zzc()).zze())).a_());
        }
    }, zzfh.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfk
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzfj.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.KmsAeadKey");
    private static final zzoh<zzfi> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfn
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzfi zzfiVar = (zzfi) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzxw) ((zzalt) zzxw.zzb().zza((zzxz) ((zzalt) zzxz.zza().zza(((zzfh) ((zzdo) zzfiVar.zza())).zzc()).zze())).zze())).a_(), zzcw.zze, zzfj.zza(((zzfh) ((zzdo) zzfiVar.zza())).zzb()), zzfiVar.zzb());
        }
    }, zzfi.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfm
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzfj.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.KmsAeadKey");

    private static zzcv zza(zzfh.zza zzaVar) throws GeneralSecurityException {
        if (zzaVar.equals(zzfh.zza.zza)) {
            return zzcv.zzb;
        }
        if (zzaVar.equals(zzfh.zza.zzb)) {
            return zzcv.zzd;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzaVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfi zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
        try {
            zzxw zzxwVarZza = zzxw.zza(zzctVar.zzc(), zzalf.zza());
            if (zzxwVarZza.zza() != 0) {
                throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + String.valueOf(zzxwVarZza));
            }
            return zzfi.zza(zzfh.zza(zzxwVarZza.zzd().zzd(), zza(zzctVar.zzb())), zzctVar.zzd());
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
        }
    }

    private static zzfh.zza zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzb) {
            return zzfh.zza.zza;
        }
        if (zzcvVar == zzcv.zzd) {
            return zzfh.zza.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfh zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            return zzfh.zza(zzxz.zza(zzcxVar.zzb(), zzalf.zza()).zzd(), zza(zzcxVar.zza()));
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
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
