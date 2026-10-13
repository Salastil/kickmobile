package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzfs {
    private static final zzpq<zzfo> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfr
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            zzfo zzfoVar = (zzfo) zzcsVar;
            return zzcx.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzfs.zza(zzfoVar.zzc()), zzfs.zzb(zzfoVar).a_());
        }
    }, zzfo.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfu
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzfs.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
    private static final zzoh<zzfp> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzft
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzfp zzfpVar = (zzfp) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzyc) ((zzalt) zzyc.zzb().zza(zzfs.zzb((zzfo) ((zzdo) zzfpVar.zza()))).zze())).a_(), zzcw.zze, zzfs.zza(((zzfo) ((zzdo) zzfpVar.zza())).zzc()), zzfpVar.zzb());
        }
    }, zzfp.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfw
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzfs.zzb(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");

    private static zzcv zza(zzfo.zzc zzcVar) throws GeneralSecurityException {
        if (zzfo.zzc.zza.equals(zzcVar)) {
            return zzcv.zzb;
        }
        if (zzfo.zzc.zzb.equals(zzcVar)) {
            return zzcv.zzd;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzcVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfp zzb(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        zzcv zzcvVar;
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzyc zzycVarZza = zzyc.zza(zzctVar.zzc(), zzalf.zza());
            if (zzycVarZza.zza() != 0) {
                throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + String.valueOf(zzycVarZza));
            }
            zzyf zzyfVarZzd = zzycVarZza.zzd();
            zzcv zzcvVarZzb = zzctVar.zzb();
            if (zzcvVarZzb == zzcv.zzb) {
                zzcvVar = zzcv.zzb;
            } else if (zzcvVarZzb == zzcv.zzd) {
                zzcvVar = zzcv.zzd;
            } else {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVarZzb));
            }
            return zzfp.zza(zza(zzyfVarZzd, zzcvVar), zzctVar.zzd());
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfo zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            return zza(zzyf.zza(zzcxVar.zzb(), zzalf.zza()), zzcxVar.zza());
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzfo zza(zzyf zzyfVar, zzcv zzcvVar) throws GeneralSecurityException {
        zzfo.zza zzaVar;
        zzfo.zzc zzcVar;
        zzcs zzcsVarZza = zzdg.zza(((zzxk) ((zzalt) zzxk.zza().zza(zzyfVar.zza().zzf()).zza(zzyfVar.zza().zze()).zza(zzyi.RAW).zze())).zzk());
        if (zzcsVarZza instanceof zzel) {
            zzaVar = zzfo.zza.zza;
        } else if (zzcsVarZza instanceof zzey) {
            zzaVar = zzfo.zza.zzc;
        } else if (zzcsVarZza instanceof zzgq) {
            zzaVar = zzfo.zza.zzb;
        } else if (zzcsVarZza instanceof zzdw) {
            zzaVar = zzfo.zza.zzd;
        } else if (zzcsVarZza instanceof zzec) {
            zzaVar = zzfo.zza.zze;
        } else if (zzcsVarZza instanceof zzes) {
            zzaVar = zzfo.zza.zzf;
        } else {
            throw new GeneralSecurityException("Unsupported DEK parameters when parsing " + String.valueOf(zzcsVarZza));
        }
        zzfo.zzb zzbVar = new zzfo.zzb();
        if (zzcvVar.equals(zzcv.zzb)) {
            zzcVar = zzfo.zzc.zza;
        } else if (zzcvVar.equals(zzcv.zzd)) {
            zzcVar = zzfo.zzc.zzb;
        } else {
            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + String.valueOf(zzcvVar));
        }
        return zzbVar.zza(zzcVar).zza(zzyfVar.zze()).zza((zzdo) zzcsVarZza).zza(zzaVar).zza();
    }

    private static zzyf zzb(zzfo zzfoVar) throws GeneralSecurityException {
        try {
            return (zzyf) ((zzalt) zzyf.zzb().zza(zzfoVar.zzd()).zza(zzxk.zza(zzdg.zza(zzfoVar.zzb()), zzalf.zza())).zze());
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
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
