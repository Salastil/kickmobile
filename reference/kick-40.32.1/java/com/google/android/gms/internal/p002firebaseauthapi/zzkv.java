package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzkv {
    private static final zzpq<zzkq> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzku
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            zzkq zzkqVar = (zzkq) zzcsVar;
            return zzcx.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", zzkv.zza(zzkqVar.zzf()), ((zzwu) ((zzalt) zzwu.zza().zza(zzkv.zzb(zzkqVar)).zze())).a_());
        }
    }, zzkq.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkx
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzkv.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.HpkePrivateKey");
    private static final zzoh<zzla> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkw
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzla zzlaVar = (zzla) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey", zzkv.zza(zzlaVar).a_(), zzcw.zzd, zzkv.zza(((zzkq) ((zzln) zzlaVar.zza())).zzf()), zzlaVar.zzb());
        }
    }, zzla.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkz
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzkv.zzd(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.HpkePublicKey");
    private static final zzoh<zzks> zze = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzky
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzks zzksVar = (zzks) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", ((zzxa) ((zzalt) zzxa.zzb().zza(0).zza(zzkv.zza((zzla) ((zzlp) zzksVar.zzc()))).zza(zzakb.zza(zzksVar.zzf().zza(zzdd.zza(zzddVar)))).zze())).a_(), zzcw.zzc, zzkv.zza(((zzkq) ((zzln) zzksVar.zza())).zzf()), zzksVar.zzb());
        }
    }, zzks.class);
    private static final zzod zzf = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlb
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzkv.zzc(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.HpkePrivateKey");
    private static final zznx<zzwr, zzkq.zzf> zzg = zznx.zza().zza(zzwr.DHKEM_P256_HKDF_SHA256, zzkq.zzf.zza).zza(zzwr.DHKEM_P384_HKDF_SHA384, zzkq.zzf.zzb).zza(zzwr.DHKEM_P521_HKDF_SHA512, zzkq.zzf.zzc).zza(zzwr.DHKEM_X25519_HKDF_SHA256, zzkq.zzf.zzd).zza(zzwr.X_WING, zzkq.zzf.zze).zza();
    private static final zznx<zzws, zzkq.zzc> zzh = zznx.zza().zza(zzws.HKDF_SHA256, zzkq.zzc.zza).zza(zzws.HKDF_SHA384, zzkq.zzc.zzb).zza(zzws.HKDF_SHA512, zzkq.zzc.zzc).zza();
    private static final zznx<zzwp, zzkq.zzb> zzi = zznx.zza().zza(zzwp.AES_128_GCM, zzkq.zzb.zza).zza(zzwp.AES_256_GCM, zzkq.zzb.zzb).zza(zzwp.CHACHA20_POLY1305, zzkq.zzb.zzc).zza();

    private static zzcv zza(zzkq.zze zzeVar) throws GeneralSecurityException {
        if (zzeVar.equals(zzkq.zze.zzc)) {
            return zzcv.zzd;
        }
        if (zzeVar.equals(zzkq.zze.zza)) {
            return zzcv.zzb;
        }
        if (zzeVar.equals(zzkq.zze.zzb)) {
            return zzcv.zze;
        }
        throw new GeneralSecurityException("unknown variant: " + String.valueOf(zzeVar));
    }

    private static zzkq zza(zzcv zzcvVar, zzwx zzwxVar) throws GeneralSecurityException {
        zzkq.zze zzeVar;
        zzkq.zzd zzdVarZzc = zzkq.zzc();
        if (zzcvVar.equals(zzcv.zzd)) {
            zzeVar = zzkq.zze.zzc;
        } else if (zzcvVar.equals(zzcv.zzb)) {
            zzeVar = zzkq.zze.zza;
        } else if (zzcvVar.equals(zzcv.zze) || zzcvVar.equals(zzcv.zzc)) {
            zzeVar = zzkq.zze.zzb;
        } else {
            throw new GeneralSecurityException("unknown variant: " + String.valueOf(zzcvVar));
        }
        return zzdVarZzc.zza(zzeVar).zza(zzg.zza(zzwxVar.zzc())).zza(zzh.zza(zzwxVar.zzb())).zza(zzi.zza(zzwxVar.zza())).zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzkq zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            return zza(zzcxVar.zza(), zzwu.zza(zzcxVar.zzb(), zzalf.zza()).zzc());
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing HpkeParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzks zzc(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePrivateKey: " + zzctVar.zze());
        }
        try {
            zzxa zzxaVarZza = zzxa.zza(zzctVar.zzc(), zzalf.zza());
            if (zzxaVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzxd zzxdVarZzd = zzxaVarZza.zzd();
            if (zzxdVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzkq zzkqVarZza = zza(zzctVar.zzb(), zzxdVarZzd.zzb());
            return zzks.zza(zzla.zza(zzkqVarZza, zza(zzkqVarZza.zze(), zzxdVarZzd.zzf().zzc()), zzctVar.zzd()), zzaav.zza(zznu.zza(zznu.zza(zzxaVarZza.zze().zzc()), zzms.zzb(zzkqVarZza.zze())), zzdd.zza(zzddVar)));
        } catch (zzamd unused) {
            throw new GeneralSecurityException("Parsing HpkePrivateKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzla zzd(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.HpkePublicKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePublicKey: " + zzctVar.zze());
        }
        try {
            zzxd zzxdVarZza = zzxd.zza(zzctVar.zzc(), zzalf.zza());
            if (zzxdVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzkq zzkqVarZza = zza(zzctVar.zzb(), zzxdVarZza.zzb());
            return zzla.zza(zzkqVarZza, zza(zzkqVarZza.zze(), zzxdVarZza.zzf().zzc()), zzctVar.zzd());
        } catch (zzamd unused) {
            throw new GeneralSecurityException("Parsing HpkePublicKey failed");
        }
    }

    private static zzwx zzb(zzkq zzkqVar) throws GeneralSecurityException {
        return (zzwx) ((zzalt) zzwx.zzd().zza((zzwr) zzg.zza(zzkqVar.zze())).zza((zzws) zzh.zza(zzkqVar.zzd())).zza((zzwp) zzi.zza(zzkqVar.zzb())).zze());
    }

    private static zzxd zza(zzla zzlaVar) throws GeneralSecurityException {
        return (zzxd) ((zzalt) zzxd.zzc().zza(0).zza(zzb((zzkq) ((zzln) zzlaVar.zza()))).zza(zzakb.zza(zzlaVar.zze().zzb())).zze());
    }

    private static zzaau zza(zzkq.zzf zzfVar, byte[] bArr) throws GeneralSecurityException {
        return zzaau.zza(zznu.zza(zznu.zza(bArr), zzms.zzc(zzfVar)));
    }

    public static void zza() throws GeneralSecurityException {
        zzpf zzpfVarZza = zzpf.zza();
        zzpfVarZza.zza(zza);
        zzpfVarZza.zza(zzb);
        zzpfVarZza.zza(zzc);
        zzpfVarZza.zza(zzd);
        zzpfVarZza.zza(zze);
        zzpfVarZza.zza(zzf);
    }
}
