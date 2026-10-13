package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgs {
    private static final zzpq<zzdw> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgr
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            zzdw zzdwVar = (zzdw) zzcsVar;
            return zzcx.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzgs.zza(zzdwVar.zzh()), ((zztr) ((zzalt) zztr.zza().zza((zztx) ((zzalt) zztx.zzb().zza((zzua) ((zzalt) zzua.zzb().zza(zzdwVar.zzd()).zze())).zza(zzdwVar.zzb()).zze())).zza((zzwj) ((zzalt) zzwj.zzc().zza(zzgs.zzb(zzdwVar)).zza(zzdwVar.zzc()).zze())).zze())).a_());
        }
    }, zzdw.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgu
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzgs.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
    private static final zzoh<zzdp> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgt
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzdp zzdpVar = (zzdp) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzto) ((zzalt) zzto.zzb().zza((zztu) ((zzalt) zztu.zzb().zza((zzua) ((zzalt) zzua.zzb().zza(((zzdw) ((zzdo) zzdpVar.zza())).zzd()).zze())).zza(zzakb.zza(zzdpVar.zzf().zza(zzdd.zza(zzddVar)))).zze())).zza((zzwg) ((zzalt) zzwg.zzb().zza(zzgs.zzb((zzdw) ((zzdo) zzdpVar.zza()))).zza(zzakb.zza(zzdpVar.zzg().zza(zzdd.zza(zzddVar)))).zze())).zze())).a_(), zzcw.zzb, zzgs.zza(((zzdw) ((zzdo) zzdpVar.zza())).zzh()), zzdpVar.zzb());
        }
    }, zzdp.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzgw
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzgs.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");

    private static zzcv zza(zzdw.zzb zzbVar) throws GeneralSecurityException {
        if (zzbVar.equals(zzdw.zzb.zza)) {
            return zzcv.zzb;
        }
        if (zzbVar.equals(zzdw.zzb.zzb)) {
            return zzcv.zze;
        }
        if (zzbVar.equals(zzdw.zzb.zzc)) {
            return zzcv.zzd;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzbVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdp zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            zzto zztoVarZza = zzto.zza(zzctVar.zzc(), zzalf.zza());
            if (zztoVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zztoVarZza.zzd().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (zztoVarZza.zze().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
            }
            return zzdp.zze().zza(zzdw.zzf().zza(zztoVarZza.zzd().zzf().zza()).zzb(zztoVarZza.zze().zzf().zza()).zzc(zztoVarZza.zzd().zze().zza()).zzd(zztoVarZza.zze().zze().zza()).zza(zza(zztoVarZza.zze().zze().zzb())).zza(zza(zzctVar.zzb())).zza()).zza(zzaav.zza(zztoVarZza.zzd().zzf().zzc(), zzdd.zza(zzddVar))).zzb(zzaav.zza(zztoVarZza.zze().zzf().zzc(), zzdd.zza(zzddVar))).zza(zzctVar.zzd()).zza();
        } catch (zzamd unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }

    private static zzdw.zzc zza(zzwh zzwhVar) throws GeneralSecurityException {
        int i = zzgv.zza[zzwhVar.ordinal()];
        if (i == 1) {
            return zzdw.zzc.zza;
        }
        if (i == 2) {
            return zzdw.zzc.zzb;
        }
        if (i == 3) {
            return zzdw.zzc.zzc;
        }
        if (i == 4) {
            return zzdw.zzc.zzd;
        }
        if (i == 5) {
            return zzdw.zzc.zze;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + zzwhVar.zza());
    }

    private static zzdw.zzb zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzb) {
            return zzdw.zzb.zza;
        }
        if (zzcvVar == zzcv.zze) {
            return zzdw.zzb.zzb;
        }
        if (zzcvVar == zzcv.zzc) {
            return zzdw.zzb.zzb;
        }
        if (zzcvVar == zzcv.zzd) {
            return zzdw.zzb.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdw zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            zztr zztrVarZza = zztr.zza(zzcxVar.zzb(), zzalf.zza());
            if (zztrVarZza.zzd().zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzdw.zzf().zza(zztrVarZza.zzc().zza()).zzb(zztrVarZza.zzd().zza()).zzc(zztrVarZza.zzc().zze().zza()).zzd(zztrVarZza.zzd().zzf().zza()).zza(zza(zztrVarZza.zzd().zzf().zzb())).zza(zza(zzcxVar.zza())).zza();
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
        }
    }

    private static zzwm zzb(zzdw zzdwVar) throws GeneralSecurityException {
        zzwh zzwhVar;
        zzwm.zza zzaVarZza = zzwm.zzc().zza(zzdwVar.zze());
        zzdw.zzc zzcVarZzg = zzdwVar.zzg();
        if (zzcVarZzg.equals(zzdw.zzc.zza)) {
            zzwhVar = zzwh.SHA1;
        } else if (zzcVarZzg.equals(zzdw.zzc.zzb)) {
            zzwhVar = zzwh.SHA224;
        } else if (zzcVarZzg.equals(zzdw.zzc.zzc)) {
            zzwhVar = zzwh.SHA256;
        } else if (zzcVarZzg.equals(zzdw.zzc.zzd)) {
            zzwhVar = zzwh.SHA384;
        } else if (zzcVarZzg.equals(zzdw.zzc.zze)) {
            zzwhVar = zzwh.SHA512;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType " + String.valueOf(zzcVarZzg));
        }
        return (zzwm) ((zzalt) zzaVarZza.zza(zzwhVar).zze());
    }

    public static void zza() throws GeneralSecurityException {
        zzpf zzpfVarZza = zzpf.zza();
        zzpfVarZza.zza(zza);
        zzpfVarZza.zza(zzb);
        zzpfVarZza.zza(zzc);
        zzpfVarZza.zza(zzd);
    }
}
