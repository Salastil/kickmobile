package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzlx {
    private static final zzpq<zzkl> zza = zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlw
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
        public final zzcx zza(zzcs zzcsVar) {
            zzkl zzklVar = (zzkl) zzcsVar;
            return zzcx.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzlx.zza(zzklVar.zzg()), ((zzvm) ((zzalt) zzvm.zza().zza(zzlx.zzb(zzklVar)).zze())).a_());
        }
    }, zzkl.class);
    private static final zzpm zzb = zzpm.zza(new zzpo() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlz
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpo
        public final zzcs zza(zzcx zzcxVar) {
            return zzlx.zzb(zzcxVar);
        }
    }, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
    private static final zzoh<zzkr> zzc = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzly
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            zzkr zzkrVar = (zzkr) zzbtVar;
            return zzct.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzlx.zza(zzkrVar).a_(), zzcw.zzd, zzlx.zza(((zzkl) ((zzln) zzkrVar.zza())).zzg()), zzkrVar.zzb());
        }
    }, zzkr.class);
    private static final zzod zzd = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmb
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzlx.zzd(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
    private static final zzoh<zzko> zze = zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzma
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
        public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
            return zzlx.zza((zzko) zzbtVar, zzddVar);
        }
    }, zzko.class);
    private static final zzod zzf = zzod.zza(new zzof() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmd
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzof
        public final zzbt zza(zzct zzctVar, zzdd zzddVar) {
            return zzlx.zzc(zzctVar, zzddVar);
        }
    }, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
    private static final zznx<zzwh, zzkl.zzb> zzg = zznx.zza().zza(zzwh.SHA1, zzkl.zzb.zza).zza(zzwh.SHA224, zzkl.zzb.zzb).zza(zzwh.SHA256, zzkl.zzb.zzc).zza(zzwh.SHA384, zzkl.zzb.zzd).zza(zzwh.SHA512, zzkl.zzb.zze).zza();
    private static final zznx<zzwb, zzkl.zzc> zzh = zznx.zza().zza(zzwb.NIST_P256, zzkl.zzc.zza).zza(zzwb.NIST_P384, zzkl.zzc.zzb).zza(zzwb.NIST_P521, zzkl.zzc.zzc).zza(zzwb.CURVE25519, zzkl.zzc.zzd).zza();
    private static final zznx<zzvk, zzkl.zze> zzi = zznx.zza().zza(zzvk.UNCOMPRESSED, zzkl.zze.zzb).zza(zzvk.COMPRESSED, zzkl.zze.zza).zza(zzvk.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzkl.zze.zzc).zza();

    private static int zza(zzkl.zzc zzcVar) throws GeneralSecurityException {
        if (zzkl.zzc.zza.equals(zzcVar)) {
            return 33;
        }
        if (zzkl.zzc.zzb.equals(zzcVar)) {
            return 49;
        }
        if (zzkl.zzc.zzc.equals(zzcVar)) {
            return 67;
        }
        throw new GeneralSecurityException("Unable to serialize CurveType " + String.valueOf(zzcVar));
    }

    private static zzcv zza(zzkl.zzd zzdVar) throws GeneralSecurityException {
        if (zzdVar.equals(zzkl.zzd.zzc)) {
            return zzcv.zzd;
        }
        if (zzdVar.equals(zzkl.zzd.zza)) {
            return zzcv.zzb;
        }
        if (zzdVar.equals(zzkl.zzd.zzb)) {
            return zzcv.zze;
        }
        throw new GeneralSecurityException("unknown variant: " + String.valueOf(zzdVar));
    }

    public static /* synthetic */ zzct zza(zzko zzkoVar, zzdd zzddVar) throws GeneralSecurityException {
        zzvs.zza zzaVarZza = zzvs.zzb().zza(0).zza(zza((zzkr) ((zzlp) zzkoVar.zzc())));
        if (((zzkl) ((zzln) zzkoVar.zza())).zzd().equals(zzkl.zzc.zzd)) {
            zzaVarZza.zza(zzakb.zza(zzkoVar.zzg().zza(zzdd.zza(zzddVar))));
        } else {
            zzaVarZza.zza(zzakb.zza(zznu.zza(zzkoVar.zzf().zza(zzdd.zza(zzddVar)), zza(((zzkl) ((zzln) zzkoVar.zza())).zzd()))));
        }
        return zzct.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", ((zzvs) ((zzalt) zzaVarZza.zze())).a_(), zzcw.zzc, zza(((zzkl) ((zzln) zzkoVar.zza())).zzg()), zzkoVar.zzb());
    }

    private static zzkl zza(zzcv zzcvVar, zzvp zzvpVar) throws GeneralSecurityException {
        zzkl.zzd zzdVar;
        zzxk zzxkVar = (zzxk) ((zzalt) zzxk.zza().zza(zzvpVar.zzb().zzd().zzf()).zza(zzyi.RAW).zza(zzvpVar.zzb().zzd().zze()).zze());
        zzkl.zza zzaVarZzc = zzkl.zzc();
        if (zzcvVar.equals(zzcv.zzd)) {
            zzdVar = zzkl.zzd.zzc;
        } else if (zzcvVar.equals(zzcv.zzb)) {
            zzdVar = zzkl.zzd.zza;
        } else if (zzcvVar.equals(zzcv.zze) || zzcvVar.equals(zzcv.zzc)) {
            zzdVar = zzkl.zzd.zzb;
        } else {
            throw new GeneralSecurityException("unknown variant: " + String.valueOf(zzcvVar));
        }
        zzkl.zza zzaVarZza = zzaVarZzc.zza(zzdVar).zza(zzh.zza(zzvpVar.zzf().zzd())).zza(zzg.zza(zzvpVar.zzf().zze())).zza(zzdg.zza(zzxkVar.zzk())).zza(zzaau.zza(zzvpVar.zzf().zzf().zzc()));
        if (!zzvpVar.zzf().zzd().equals(zzwb.CURVE25519)) {
            zzaVarZza.zza(zzi.zza(zzvpVar.zza()));
        } else if (!zzvpVar.zza().equals(zzvk.COMPRESSED)) {
            throw new GeneralSecurityException("For CURVE25519 EcPointFormat must be compressed");
        }
        return zzaVarZza.zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzkl zzb(zzcx zzcxVar) throws GeneralSecurityException {
        if (!zzcxVar.zzc().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parseParameters: " + zzcxVar.zzc());
        }
        try {
            return zza(zzcxVar.zza(), zzvm.zza(zzcxVar.zzb(), zzalf.zza()).zzc());
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzko zzc(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePrivateKey: " + zzctVar.zze());
        }
        try {
            zzvs zzvsVarZza = zzvs.zza(zzctVar.zzc(), zzalf.zza());
            if (zzvsVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzvv zzvvVarZzd = zzvsVarZza.zzd();
            if (zzvvVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzkl zzklVarZza = zza(zzctVar.zzb(), zzvvVarZzd.zzb());
            if (zzklVarZza.zzd().equals(zzkl.zzc.zzd)) {
                return zzko.zza(zzkr.zza(zzklVarZza, zzaau.zza(zzvvVarZzd.zzf().zzc()), zzctVar.zzd()), zzaav.zza(zzvsVarZza.zze().zzc(), zzdd.zza(zzddVar)));
            }
            return zzko.zza(zzkr.zza(zzklVarZza, new ECPoint(zznu.zza(zzvvVarZzd.zzf().zzc()), zznu.zza(zzvvVarZzd.b_().zzc())), zzctVar.zzd()), zzaat.zza(zznu.zza(zzvsVarZza.zze().zzc()), zzdd.zza(zzddVar)));
        } catch (zzamd | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzkr zzd(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!zzctVar.zze().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePublicKey: " + zzctVar.zze());
        }
        try {
            zzvv zzvvVarZza = zzvv.zza(zzctVar.zzc(), zzalf.zza());
            if (zzvvVarZza.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzkl zzklVarZza = zza(zzctVar.zzb(), zzvvVarZza.zzb());
            if (zzklVarZza.zzd().equals(zzkl.zzc.zzd)) {
                if (zzvvVarZza.b_().zza() != 0) {
                    throw new GeneralSecurityException("Y must be empty for X25519 points");
                }
                return zzkr.zza(zzklVarZza, zzaau.zza(zzvvVarZza.zzf().zzc()), zzctVar.zzd());
            }
            return zzkr.zza(zzklVarZza, new ECPoint(zznu.zza(zzvvVarZza.zzf().zzc()), zznu.zza(zzvvVarZza.b_().zzc())), zzctVar.zzd());
        } catch (zzamd | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
        }
    }

    private static zzvp zzb(zzkl zzklVar) throws GeneralSecurityException {
        zzvy.zza zzaVarZza = zzvy.zza().zza((zzwb) zzh.zza(zzklVar.zzd())).zza((zzwh) zzg.zza(zzklVar.zze()));
        if (zzklVar.zzh() != null && zzklVar.zzh().zza() > 0) {
            zzaVarZza.zza(zzakb.zza(zzklVar.zzh().zzb()));
        }
        zzvy zzvyVar = (zzvy) ((zzalt) zzaVarZza.zze());
        try {
            zzxk zzxkVarZza = zzxk.zza(zzdg.zza(zzklVar.zzb()), zzalf.zza());
            zzvj zzvjVar = (zzvj) ((zzalt) zzvj.zza().zza((zzxk) ((zzalt) zzxk.zza().zza(zzxkVarZza.zzf()).zza(zzyi.TINK).zza(zzxkVarZza.zze()).zze())).zze());
            zzkl.zze zzeVarZzf = zzklVar.zzf();
            if (zzeVarZzf == null) {
                zzeVarZzf = zzkl.zze.zza;
            }
            return (zzvp) ((zzalt) zzvp.zzc().zza(zzvyVar).zza(zzvjVar).zza((zzvk) zzi.zza(zzeVarZzf)).zze());
        } catch (zzamd e) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
        }
    }

    private static zzvv zza(zzkr zzkrVar) throws GeneralSecurityException {
        if (((zzkl) ((zzln) zzkrVar.zza())).zzd().equals(zzkl.zzc.zzd)) {
            return (zzvv) ((zzalt) zzvv.zzc().zza(0).zza(zzb((zzkl) ((zzln) zzkrVar.zza()))).zza(zzakb.zza(zzkrVar.zze().zzb())).zzb(zzakb.zza).zze());
        }
        int iZza = zza(((zzkl) ((zzln) zzkrVar.zza())).zzd());
        ECPoint eCPointZzf = zzkrVar.zzf();
        if (eCPointZzf == null) {
            throw new GeneralSecurityException("NistCurvePoint was null for NIST curve");
        }
        return (zzvv) ((zzalt) zzvv.zzc().zza(0).zza(zzb((zzkl) ((zzln) zzkrVar.zza()))).zza(zzakb.zza(zznu.zza(eCPointZzf.getAffineX(), iZza))).zzb(zzakb.zza(zznu.zza(eCPointZzf.getAffineY(), iZza))).zze());
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
