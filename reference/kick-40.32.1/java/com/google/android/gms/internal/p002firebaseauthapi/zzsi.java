package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzsi {
    private static final zznx<zzwh, zzrl.zzc> zza = zznx.zza().zza(zzwh.SHA1, zzrl.zzc.zza).zza(zzwh.SHA224, zzrl.zzc.zzb).zza(zzwh.SHA256, zzrl.zzc.zzc).zza(zzwh.SHA384, zzrl.zzc.zzd).zza(zzwh.SHA512, zzrl.zzc.zze).zza();
    private static final zzpq<zzrl> zzb = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsl
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            zzrl zzrlVar = (zzrl) zzcsVar;
            return zzcx.zza("type.googleapis.com/google.crypto.tink.HmacKey", zzsi.zza(zzrlVar.zzf()), ((zzwj) ((zzalt) zzwj.zzc().zza(zzsi.zzb(zzrlVar)).zza(zzrlVar.zzc()).zze())).a_());
        }
    }, zzrl.class);
    private static final zzpm zzc = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsk
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzsi.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.HmacKey");
    private static final zzoh<zzre> zzd = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsn
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzre zzreVar = (zzre) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzwg) ((zzalt) zzwg.zzb().zza(zzsi.zzb((zzrl) ((zzro) zzreVar.zza()))).zza(zzakb.zza(zzreVar.zzf().zza(zzdd.zza(zzddVar)))).zze())).a_(), zzcw.zzb, zzsi.zza(((zzrl) ((zzro) zzreVar.zza())).zzf()), zzreVar.zzb());
        }
    }, zzre.class);
    private static final zzod zze = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzsm
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzsi.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.HmacKey");

    private static zzcv zza(zzrl.zzb zzbVar) throws GeneralSecurityException {
        if (zzbVar == zzrl.zzb.zzd) {
            return zzcv.zzd;
        }
        if (zzbVar == zzrl.zzb.zza) {
            return zzcv.zzb;
        }
        if (zzbVar == zzrl.zzb.zzc) {
            return zzcv.zzc;
        }
        if (zzbVar == zzrl.zzb.zzb) {
            return zzcv.zze;
        }
        throw new GeneralSecurityException("unknown variant: " + String.valueOf(zzbVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzre zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzwg zzwgVarZza = zzwg.zza(zzctVar.zzc(), zzalf.zza());
            if (zzwgVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return zzre.zzc().zza(zzrl.zzd().zza(zzwgVarZza.zzf().zza()).zzb(zzwgVarZza.zze().zza()).zza(zza.zza(zzwgVarZza.zze().zzb())).zza(zza(zzctVar.zzb())).zza()).zza(zzaav.zza(zzwgVarZza.zzf().zzc(), zzdd.zza(zzddVar))).zza(zzctVar.zzd()).zza();
        } catch (zzamd | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    private static zzrl.zzb zza(zzcv zzcvVar) throws GeneralSecurityException {
        if (zzcvVar == zzcv.zzd) {
            return zzrl.zzb.zzd;
        }
        if (zzcvVar == zzcv.zzb) {
            return zzrl.zzb.zza;
        }
        if (zzcvVar == zzcv.zzc) {
            return zzrl.zzb.zzc;
        }
        if (zzcvVar == zzcv.zze) {
            return zzrl.zzb.zzb;
        }
        throw new GeneralSecurityException("unknown OutputPrefixType: " + String.valueOf(zzcvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzrl zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            zzwj zzwjVarZza = zzwj.zza(zzcxVar.zzb(), zzalf.zza());
            if (zzwjVarZza.zzb() != 0) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzwjVarZza.zzb());
            }
            return zzrl.zzd().zza(zzwjVarZza.zza()).zzb(zzwjVarZza.zzf().zza()).zza(zza.zza(zzwjVarZza.zzf().zzb())).zza(zza(zzcxVar.zza())).zza();
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    private static zzwm zzb(zzrl zzrlVar) throws GeneralSecurityException {
        return (zzwm) ((zzalt) zzwm.zzc().zza(zzrlVar.zzb()).zza((zzwh) zza.zza(zzrlVar.zze())).zze());
    }

    public static void zza() throws GeneralSecurityException {
        zzpf zzpfVarZza = zzpf.zza();
        zzpfVarZza.zza(zzb);
        zzpfVarZza.zza(zzc);
        zzpfVarZza.zza(zzd);
        zzpfVarZza.zza(zze);
    }
}
