package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzadn {
    public static final /* synthetic */ int zza = 0;
    private static final zzarq zzb;
    private static final zzais zzc;
    private static final zzaip zzd;
    private static final zzahp zze;
    private static final zzahm zzf;
    private static final Map zzg;
    private static final Map zzh;

    static {
        zzarq zzarqVarZza = zzajp.zza("type.googleapis.com/google.crypto.tink.AesSivKey");
        zzb = zzarqVarZza;
        zzc = zzais.zzd(zzadm.zza, zzacz.class, zzajf.class);
        zzd = zzaip.zzd(zzadj.zza, zzarqVarZza, zzajf.class);
        zze = zzahp.zzd(zzadk.zza, zzacs.class, zzaje.class);
        zzf = zzahm.zzd(zzadl.zza, zzarqVarZza, zzaje.class);
        HashMap map = new HashMap();
        map.put(zzacy.zzc, zzapm.RAW);
        map.put(zzacy.zza, zzapm.TINK);
        map.put(zzacy.zzb, zzapm.CRUNCHY);
        zzg = Collections.unmodifiableMap(map);
        EnumMap enumMap = new EnumMap(zzapm.class);
        enumMap.put(zzapm.RAW, zzacy.zzc);
        enumMap.put(zzapm.TINK, zzacy.zza);
        enumMap.put(zzapm.CRUNCHY, zzacy.zzb);
        enumMap.put(zzapm.LEGACY, zzacy.zzb);
        zzh = Collections.unmodifiableMap(enumMap);
    }

    public static void zza(zzail zzailVar) throws GeneralSecurityException {
        zzailVar.zzd(zzc);
        zzailVar.zze(zzd);
        zzailVar.zzb(zze);
        zzailVar.zzc(zzf);
    }

    static /* synthetic */ zzajf zzb(zzacz zzaczVar) {
        zzaos zzaosVarZze = zzaot.zze();
        zzaosVarZze.zza("type.googleapis.com/google.crypto.tink.AesSivKey");
        zzand zzandVarZzd = zzane.zzd();
        zzandVarZzd.zza(zzaczVar.zzc());
        zzaosVarZze.zzb(((zzane) zzandVarZzd.zzal()).zzaQ());
        zzaosVarZze.zzc(zzf(zzaczVar.zzd()));
        return zzajf.zza((zzaot) zzaosVarZze.zzal());
    }

    static /* synthetic */ zzacz zzc(zzajf zzajfVar) throws GeneralSecurityException {
        if (!zzajfVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            String strZza = zzajfVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzane zzaneVarZzc = zzane.zzc(zzajfVar.zzc().zzb(), zzaty.zza());
            if (zzaneVarZzc.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzacx zzacxVarZzb = zzacz.zzb();
            zzacxVarZzb.zza(zzaneVarZzc.zza());
            zzacxVarZzb.zzb(zzg(zzajfVar.zzc().zzc()));
            return zzacxVarZzb.zzc();
        } catch (zzavb e) {
            throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e);
        }
    }

    static /* synthetic */ zzaje zzd(zzacs zzacsVar, zzwm zzwmVar) {
        zzanb zzanbVarZzd = zzanc.zzd();
        byte[] bArrZzb = zzacsVar.zzd().zzb(zzwmVar);
        zzanbVarZzd.zza(zzatl.zzr(bArrZzb, 0, bArrZzb.length));
        return zzaje.zzf("type.googleapis.com/google.crypto.tink.AesSivKey", ((zzanc) zzanbVarZzd.zzal()).zzaQ(), 3, zzf(zzacsVar.zzf().zzd()), zzacsVar.zzb());
    }

    static /* synthetic */ zzacs zze(zzaje zzajeVar, zzwm zzwmVar) throws GeneralSecurityException {
        if (!zzajeVar.zze().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
        }
        try {
            zzanc zzancVarZzc = zzanc.zzc(zzajeVar.zza(), zzaty.zza());
            if (zzancVarZzc.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzacx zzacxVarZzb = zzacz.zzb();
            zzacxVarZzb.zza(zzancVarZzc.zzb().zzb());
            zzacxVarZzb.zzb(zzg(zzajeVar.zzb()));
            zzacz zzaczVarZzc = zzacxVarZzb.zzc();
            zzacr zzacrVarZzc = zzacs.zzc();
            zzacrVarZzc.zza(zzaczVarZzc);
            zzacrVarZzc.zzb(zzars.zza(zzancVarZzc.zzb().zzx(), zzwmVar));
            zzacrVarZzc.zzc(zzajeVar.zzc());
            return zzacrVarZzc.zzd();
        } catch (zzavb unused) {
            throw new GeneralSecurityException("Parsing AesSivKey failed");
        }
    }

    private static zzapm zzf(zzacy zzacyVar) throws GeneralSecurityException {
        Map map = zzg;
        if (map.containsKey(zzacyVar)) {
            return (zzapm) map.get(zzacyVar);
        }
        String strValueOf = String.valueOf(zzacyVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzacy zzg(zzapm zzapmVar) throws GeneralSecurityException {
        Map map = zzh;
        if (map.containsKey(zzapmVar)) {
            return (zzacy) map.get(zzapmVar);
        }
        int iZza = zzapmVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
        sb.append("Unable to parse OutputPrefixType: ");
        sb.append(iZza);
        throw new GeneralSecurityException(sb.toString());
    }
}
