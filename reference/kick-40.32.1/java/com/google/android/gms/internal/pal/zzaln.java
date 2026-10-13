package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaln {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzahb zzc;
    private static final zzahb zzd;
    private static final zzais zze;
    private static final zzaip zzf;
    private static final zzahp zzg;
    private static final zzahm zzh;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzarqVarZza;
        zzaha zzahaVarZza = zzahb.zza();
        zzahaVarZza.zza(zzapm.RAW, zzakl.zzd);
        zzahaVarZza.zza(zzapm.TINK, zzakl.zza);
        zzahaVarZza.zza(zzapm.LEGACY, zzakl.zzc);
        zzahaVarZza.zza(zzapm.CRUNCHY, zzakl.zzb);
        zzc = zzahaVarZza.zzb();
        zzaha zzahaVarZza2 = zzahb.zza();
        zzahaVarZza2.zza(zzanx.SHA1, zzakk.zza);
        zzahaVarZza2.zza(zzanx.SHA224, zzakk.zzb);
        zzahaVarZza2.zza(zzanx.SHA256, zzakk.zzc);
        zzahaVarZza2.zza(zzanx.SHA384, zzakk.zzd);
        zzahaVarZza2.zza(zzanx.SHA512, zzakk.zze);
        zzd = zzahaVarZza2.zzb();
        zze = zzais.zzd(zzalm.zza, zzakm.class, zzajf.class);
        zzf = zzaip.zzd(zzalj.zza, zzarqVarZza, zzajf.class);
        zzg = zzahp.zzd(zzalk.zza, zzakd.class, zzaje.class);
        zzh = zzahm.zzd(zzall.zza, zzarqVarZza, zzaje.class);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zze);
        zzailVar.zze(zzf);
        zzailVar.zzb(zzg);
        zzailVar.zzc(zzh);
    }

    static /* synthetic */ zzajf zzb(zzakm zzakmVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.HmacKey");
        zzaoa zzaoaVarZze = zzaob.zze();
        zzaoaVarZze.zza(zzf(zzakmVar));
        zzaoaVarZze.zzb(zzakmVar.zzc());
        zzaosVarZze.zzb(((zzaob) zzaoaVarZze.zzal()).zzaQ());
        zzaosVarZze.zzc((zzapm) zzc.zzb(zzakmVar.zzf()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzakm zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzaob zzaobVarZzd = zzaob.zzd(zzajfVar.zzc().zzb(), zzaty.zza());
            if (zzaobVarZzd.zzc() != 0) {
                int iZzc = zzaobVarZzd.zzc();
                StringBuilder sb = new StringBuilder(String.valueOf(iZzc).length() + 47);
                sb.append("Parsing HmacParameters failed: unknown Version ");
                sb.append(iZzc);
                throw new GeneralSecurityException(sb.toString());
            }
            zzakj zzakjVarZzb = zzakm.zzb();
            zzakjVarZzb.zza(zzaobVarZzd.zzb());
            zzakjVarZzb.zzb(zzaobVarZzd.zza().zzb());
            zzakjVarZzb.zzd((zzakk) zzd.zzc(zzaobVarZzd.zza().zza()));
            zzakjVarZzb.zzc((zzakl) zzc.zzc(zzajfVar.zzc().zzc()));
            return zzakjVarZzb.zze();
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    static /* synthetic */ zzaje zzd(zzakd zzakdVar, zzwm zzwmVar) {
        zzany zzanyVarZze = zzanz.zze();
        zzanyVarZze.zza(zzf(zzakdVar.zzf()));
        byte[] bArrZzb = zzakdVar.zzd().zzb(zzwmVar);
        zzanyVarZze.zzb(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.HmacKey", ((zzanz) zzanyVarZze.zzal()).zzaQ(), 3, (zzapm) zzc.zzb(zzakdVar.zzf().zzf()), zzakdVar.zzb());
    }

    static /* synthetic */ zzakd zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzanz zzanzVarZzd = zzanz.zzd(zzajeVar.zza(), zzaty.zza());
            if (zzanzVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzakj zzakjVarZzb = zzakm.zzb();
            zzakjVarZzb.zza(zzanzVarZzd.zzc().zzb());
            zzakjVarZzb.zzb(zzanzVarZzd.zzb().zzb());
            zzakjVarZzb.zzd((zzakk) zzd.zzc(zzanzVarZzd.zzb().zza()));
            zzakjVarZzb.zzc((zzakl) zzc.zzc(zzajeVar.zzb()));
            zzakm zzakmVarZze = zzakjVarZzb.zze();
            zzakc zzakcVarZzc = zzakd.zzc();
            zzakcVarZzc.zza(zzakmVarZze);
            zzakcVarZzc.zzb(zzars.zza(zzanzVarZzd.zzc().zzx(), zzwmVar));
            zzakcVarZzc.zzc(zzajeVar.zzc());
            return zzakcVarZzc.zzd();
        } catch (zzavb | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    private static zzaod zzf(zzakm zzakmVar) throws GeneralSecurityException {
        zzaoc zzaocVarZzc = zzaod.zzc();
        zzaocVarZzc.zzb(zzakmVar.zzd());
        zzaocVarZzc.zza((zzanx) zzd.zzb(zzakmVar.zzg()));
        return (zzaod) zzaocVarZzc.zzal();
    }
}
