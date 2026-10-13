package com.google.android.gms.internal.pal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzafx {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzarq zzc;
    private static final zzais zzd;
    private static final zzaip zze;
    private static final zzahp zzf;
    private static final zzahm zzg;
    private static final zzahp zzh;
    private static final zzahm zzi;
    private static final zzahb zzj;
    private static final zzahb zzk;
    private static final zzahb zzl;
    private static final zzahb zzm;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zzb = zzarqVarZza;
        zzarq zzarqVarZza2 = zzajp.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
        zzc = zzarqVarZza2;
        zzd = zzais.zzd(zzafw.zza, zzaea.class, zzajf.class);
        zze = zzaip.zzd(zzafr.zza, zzarqVarZza, zzajf.class);
        zzf = zzahp.zzd(zzafs.zza, zzaec.class, zzaje.class);
        zzg = zzahm.zzd(zzaft.zza, zzarqVarZza2, zzaje.class);
        zzh = zzahp.zzd(zzafu.zza, zzaeb.class, zzaje.class);
        zzi = zzahm.zzd(zzafv.zza, zzarqVarZza, zzaje.class);
        zzaha zzahaVarZza = zzahb.zza();
        zzahaVarZza.zza(zzapm.RAW, zzadz.zzc);
        zzahaVarZza.zza(zzapm.TINK, zzadz.zza);
        zzahaVarZza.zza(zzapm.LEGACY, zzadz.zzb);
        zzahaVarZza.zza(zzapm.CRUNCHY, zzadz.zzb);
        zzj = zzahaVarZza.zzb();
        zzaha zzahaVarZza2 = zzahb.zza();
        zzahaVarZza2.zza(zzanx.SHA1, zzadx.zza);
        zzahaVarZza2.zza(zzanx.SHA224, zzadx.zzb);
        zzahaVarZza2.zza(zzanx.SHA256, zzadx.zzc);
        zzahaVarZza2.zza(zzanx.SHA384, zzadx.zzd);
        zzahaVarZza2.zza(zzanx.SHA512, zzadx.zze);
        zzk = zzahaVarZza2.zzb();
        zzaha zzahaVarZza3 = zzahb.zza();
        zzahaVarZza3.zza(zzanw.NIST_P256, zzadv.zza);
        zzahaVarZza3.zza(zzanw.NIST_P384, zzadv.zzb);
        zzahaVarZza3.zza(zzanw.NIST_P521, zzadv.zzc);
        zzahaVarZza3.zza(zzanw.CURVE25519, zzadv.zzd);
        zzl = zzahaVarZza3.zzb();
        zzaha zzahaVarZza4 = zzahb.zza();
        zzahaVarZza4.zza(zzanj.UNCOMPRESSED, zzady.zzb);
        zzahaVarZza4.zza(zzanj.COMPRESSED, zzady.zza);
        zzahaVarZza4.zza(zzanj.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzady.zzc);
        zzm = zzahaVarZza4.zzb();
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzd);
        zzailVar.zze(zze);
        zzailVar.zzb(zzf);
        zzailVar.zzc(zzg);
        zzailVar.zzb(zzh);
        zzailVar.zzc(zzi);
    }

    static /* synthetic */ zzajf zzb(zzaea zzaeaVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zzanm zzanmVarZzc = zzann.zzc();
        zzanmVarZzc.zza(zzh(zzaeaVar));
        zzaosVarZze.zzb(((zzann) zzanmVarZzc.zzal()).zzaQ());
        zzaosVarZze.zzc((zzapm) zzj.zzb(zzaeaVar.zzg()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzaea zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            return zzi(zzajfVar.zzc().zzc(), zzann.zzb(zzajfVar.zzc().zzb(), zzaty.zza()).zza());
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
        }
    }

    static /* synthetic */ zzaec zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
            String strZze = zzajeVar.zze();
            String.valueOf(strZze);
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePublicKey: ".concat(String.valueOf(strZze)));
        }
        try {
            zzant zzantVarZze = zzant.zze(zzajeVar.zza(), zzaty.zza());
            if (zzantVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzaea zzaeaVarZzi = zzi(zzajeVar.zzb(), zzantVarZze.zzb());
            if (!zzaeaVarZzi.zzc().equals(zzadv.zzd)) {
                return zzaec.zzd(zzaeaVarZzi, new ECPoint(new BigInteger(1, zzantVarZze.zzc().zzx()), new BigInteger(1, zzantVarZze.zzd().zzx())), zzajeVar.zzc());
            }
            if (zzantVarZze.zzd().zzq()) {
                return zzaec.zzc(zzaeaVarZzi, zzarq.zza(zzantVarZze.zzc().zzx()), zzajeVar.zzc());
            }
            throw new GeneralSecurityException("Y must be empty for X25519 points");
        } catch (zzavb | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
        }
    }

    static /* synthetic */ zzaje zzf(zzaeb zzaebVar, zzwm zzwmVar) throws GeneralSecurityException {
        zzanq zzanqVarZze = zzanr.zze();
        zzanqVarZze.zza(0);
        zzanqVarZze.zzb(zzk(zzaebVar.zzh()));
        if (zzaebVar.zzg().zzc().equals(zzadv.zzd)) {
            byte[] bArrZzb = zzaebVar.zze().zzb(zzwmVar);
            zzanqVarZze.zzc(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        } else {
            byte[] bArrZzb2 = zzagv.zzb(zzaebVar.zzf().zzb(zzwmVar), zzj(zzaebVar.zzg().zzc()));
            zzatl zzatlVar = zzatl.zza;
            zzanqVarZze.zzc(zzatl.zzr(bArrZzb2, 0, bArrZzb2.length));
        }
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", ((zzanr) zzanqVarZze.zzal()).zzaQ(), 4, (zzapm) zzj.zzb(zzaebVar.zzg().zzg()), zzaebVar.zzh().zzb());
    }

    static /* synthetic */ zzaeb zzg(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            String strZze = zzajeVar.zze();
            String.valueOf(strZze);
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePrivateKey: ".concat(String.valueOf(strZze)));
        }
        try {
            zzanr zzanrVarZzd = zzanr.zzd(zzajeVar.zza(), zzaty.zza());
            if (zzanrVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzant zzantVarZzb = zzanrVarZzd.zzb();
            if (zzantVarZzb.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzaea zzaeaVarZzi = zzi(zzajeVar.zzb(), zzantVarZzb.zzb());
            return zzaeaVarZzi.zzc().equals(zzadv.zzd) ? zzaeb.zzc(zzaec.zzc(zzaeaVarZzi, zzarq.zza(zzantVarZzb.zzc().zzx()), zzajeVar.zzc()), zzars.zza(zzanrVarZzd.zzc().zzx(), zzwmVar)) : zzaeb.zzd(zzaec.zzd(zzaeaVarZzi, new ECPoint(new BigInteger(1, zzantVarZzb.zzc().zzx()), new BigInteger(1, zzantVarZzb.zzd().zzx())), zzajeVar.zzc()), zzarr.zza(new BigInteger(1, zzanrVarZzd.zzc().zzx()), zzwmVar));
        } catch (zzavb | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
        }
    }

    private static zzanp zzh(zzaea zzaeaVar) throws GeneralSecurityException {
        zzanu zzanuVarZzd = zzanv.zzd();
        zzanuVarZzd.zza((zzanw) zzl.zzb(zzaeaVar.zzc()));
        zzanuVarZzd.zzb((zzanx) zzk.zzb(zzaeaVar.zzd()));
        if (zzaeaVar.zzh() != null && zzaeaVar.zzh().zzc() > 0) {
            byte[] bArrZzb = zzaeaVar.zzh().zzb();
            zzanuVarZzd.zzc(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        }
        zzanv zzanvVar = (zzanv) zzanuVarZzd.zzal();
        try {
            zzaot zzaotVarZzd = zzaot.zzd(zzwn.zza(zzaeaVar.zzf()), zzaty.zza());
            zzank zzankVarZzb = zzanl.zzb();
            zzaos zzaosVarZze = zzaot.zze();
            zzaosVarZze.zza(zzaotVarZzd.zza());
            zzaosVarZze.zzc(zzapm.TINK);
            zzaosVarZze.zzb(zzaotVarZzd.zzb());
            zzankVarZzb.zza((zzaot) zzaosVarZze.zzal());
            zzanl zzanlVar = (zzanl) zzankVarZzb.zzal();
            zzady zzadyVarZze = zzaeaVar.zze();
            if (zzadyVarZze == null) {
                zzadyVarZze = zzady.zza;
            }
            zzano zzanoVarZzd = zzanp.zzd();
            zzanoVarZzd.zza(zzanvVar);
            zzanoVarZzd.zzb(zzanlVar);
            zzanoVarZzd.zzc((zzanj) zzm.zzb(zzadyVarZze));
            return (zzanp) zzanoVarZzd.zzal();
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
        }
    }

    private static zzaea zzi(zzapm zzapmVar, zzanp zzanpVar) throws GeneralSecurityException {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza(zzanpVar.zzb().zza().zza());
        zzaosVarZze.zzc(zzapm.RAW);
        zzaosVarZze.zzb(zzanpVar.zzb().zza().zzb());
        zzaot zzaotVar = (zzaot) zzaosVarZze.zzal();
        zzadu zzaduVarZzb = zzaea.zzb();
        zzaduVarZzb.zze((zzadz) zzj.zzc(zzapmVar));
        zzaduVarZzb.zza((zzadv) zzl.zzc(zzanpVar.zza().zza()));
        zzaduVarZzb.zzb((zzadx) zzk.zzc(zzanpVar.zza().zzb()));
        zzaduVarZzb.zzd(zzwn.zzb(zzaotVar.zzaq()));
        zzaduVarZzb.zzf(zzarq.zza(zzanpVar.zza().zzc().zzx()));
        if (!zzanpVar.zza().zza().equals(zzanw.CURVE25519)) {
            zzaduVarZzb.zzc((zzady) zzm.zzc(zzanpVar.zzc()));
        } else if (!zzanpVar.zzc().equals(zzanj.COMPRESSED)) {
            throw new GeneralSecurityException("For CURVE25519 EcPointFormat must be compressed");
        }
        return zzaduVarZzb.zzg();
    }

    private static int zzj(zzadv zzadvVar) throws GeneralSecurityException {
        if (zzadv.zza.equals(zzadvVar)) {
            return 33;
        }
        if (zzadv.zzb.equals(zzadvVar)) {
            return 49;
        }
        if (zzadv.zzc.equals(zzadvVar)) {
            return 67;
        }
        String strValueOf = String.valueOf(zzadvVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize CurveType ".concat(String.valueOf(strValueOf)));
    }

    private static zzant zzk(zzaec zzaecVar) throws GeneralSecurityException {
        if (zzaecVar.zzh().zzc().equals(zzadv.zzd)) {
            zzans zzansVarZzf = zzant.zzf();
            zzansVarZzf.zza(0);
            zzansVarZzf.zzb(zzh(zzaecVar.zzh()));
            byte[] bArrZzb = zzaecVar.zzf().zzb();
            zzansVarZzf.zzc(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
            zzansVarZzf.zzd(zzatl.zza);
            return (zzant) zzansVarZzf.zzal();
        }
        int iZzj = zzj(zzaecVar.zzh().zzc());
        ECPoint eCPointZze = zzaecVar.zze();
        if (eCPointZze == null) {
            throw new GeneralSecurityException("NistCurvePoint was null for NIST curve");
        }
        zzans zzansVarZzf2 = zzant.zzf();
        zzansVarZzf2.zza(0);
        zzansVarZzf2.zzb(zzh(zzaecVar.zzh()));
        byte[] bArrZzb2 = zzagv.zzb(eCPointZze.getAffineX(), iZzj);
        zzatl zzatlVar = zzatl.zza;
        zzansVarZzf2.zzc(zzatl.zzr(bArrZzb2, 0, bArrZzb2.length));
        byte[] bArrZzb3 = zzagv.zzb(eCPointZze.getAffineY(), iZzj);
        zzansVarZzf2.zzd(zzatl.zzr(bArrZzb3, 0, bArrZzb3.length));
        return (zzant) zzansVarZzf2.zzal();
    }
}
