package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsb {
    private static final zzpq<zzra> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsa
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            zzra zzraVar = (zzra) zzcsVar;
            return zzcx.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", zzsb.zza(zzraVar.zze()), ((zzti) ((zzalt) zzti.zzb().zza(zzsb.zzb(zzraVar)).zza(zzraVar.zzc()).zze())).a_());
        }
    }, zzra.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsd
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzsb.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesCmacKey");
    private static final zzoh<zzqt> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsc
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzqt zzqtVar = (zzqt) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zztf) ((zzalt) zztf.zzb().zza(zzsb.zzb((zzra) ((zzro) zzqtVar.zza()))).zza(zzakb.zza(zzqtVar.zzf().zza(zzdd.zza(zzddVar)))).zze())).a_(), zzcw.zzb, zzsb.zza(((zzra) ((zzro) zzqtVar.zza())).zze()), zzqtVar.zzb());
        }
    }, zzqt.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsf
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzsb.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesCmacKey");

    private static zzcv zza(zzra.zzb zzbVar) throws GeneralSecurityException {
        if (zzbVar.equals(zzra.zzb.zza)) {
            return zzcv.zzb;
        }
        if (zzbVar.equals(zzra.zzb.zzb)) {
            return zzcv.zze;
        }
        if (zzbVar.equals(zzra.zzb.zzd)) {
            return zzcv.zzd;
        }
        if (zzbVar.equals(zzra.zzb.zzc)) {
            return zzcv.zzc;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzbVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzqt zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            zztf zztfVarZza = zztf.zza(zzctVar.zzc(), zzalf.zza());
            if (zztfVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzqt.zzc().zza(zzra.zzd().zza(zztfVarZza.zze().zza()).zzb(zztfVarZza.zzd().zza()).zza(zza(zzctVar.zzb())).zza()).zza(zzaav.zza(zztfVarZza.zze().zzc(), zzdd.zza(zzddVar))).zza(zzctVar.zzd()).zza();
        } catch (zzamd | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    private static zzra.zzb zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzb) {
            return zzra.zzb.zza;
        }
        if (zzcvVar == zzcv.zze) {
            return zzra.zzb.zzb;
        }
        if (zzcvVar == zzcv.zzc) {
            return zzra.zzb.zzc;
        }
        if (zzcvVar == zzcv.zzd) {
            return zzra.zzb.zzd;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzra zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            zzti zztiVarZza = zzti.zza(zzcxVar.zzb(), zzalf.zza());
            return zzra.zzd().zza(zztiVarZza.zza()).zzb(zztiVarZza.zzd().zza()).zza(zza(zzcxVar.zza())).zza();
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
        }
    }

    private static zztl zzb(zzra zzraVar) {
        return (zztl) ((zzalt) zztl.zzb().zza(zzraVar.zzb()).zze());
    }

    public static void zza() throws GeneralSecurityException {
        zzpf zzpfVarZza = zzpf.zza();
        zzpfVarZza.zza(zza);
        zzpfVarZza.zza(zzb);
        zzpfVarZza.zza(zzc);
        zzpfVarZza.zza(zzd);
    }
}
