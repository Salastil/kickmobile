package com.google.android.gms.internal.pal;

import java.util.Optional;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzvq {
    private static final zzpg zza = zzpg.zzf("com/google/contentads/shared/adtech/iabtcfv2/TcfCoreStringCodec");

    static Optional zza(String str) {
        if (zzmd.zzb(str)) {
            return Optional.empty();
        }
        try {
            zzur zzurVar = new zzur(zztp.zzk().zzj(str));
            zzvl zzvlVarZzj = zzvm.zzj();
            int iZza = zzurVar.zza(6);
            Integer.valueOf(iZza).getClass();
            zzvlVarZzj.zza(iZza);
            zzvlVarZzj.zzb(zzvf.zza(zzurVar));
            zzvlVarZzj.zzc(zzvf.zza(zzurVar));
            int iZza2 = zzurVar.zza(12);
            Integer.valueOf(iZza2).getClass();
            zzvlVarZzj.zzd(iZza2);
            int iZza3 = zzurVar.zza(12);
            Integer.valueOf(iZza3).getClass();
            zzvlVarZzj.zze(iZza3);
            int iZza4 = zzurVar.zza(6);
            Integer.valueOf(iZza4).getClass();
            zzvlVarZzj.zzf(iZza4);
            zzvlVarZzj.zzg(zzvf.zzb(zzurVar));
            int iZza5 = zzurVar.zza(12);
            Integer.valueOf(iZza5).getClass();
            zzvlVarZzj.zzh(iZza5);
            int iZza6 = zzurVar.zza(6);
            Integer.valueOf(iZza6).getClass();
            zzvlVarZzj.zzi(iZza6);
            zzvlVarZzj.zzj(zzvf.zzf(zzurVar).booleanValue());
            zzvlVarZzj.zzk(zzvf.zzf(zzurVar).booleanValue());
            zzvlVarZzj.zzl((Iterable) zzvf.zze(12, zzurVar).stream().map(zzvp.zza).collect(zznm.zzh()));
            zzvlVarZzj.zzm((Iterable) zzvf.zze(24, zzurVar).stream().map(zzvn.zza).collect(zznm.zzh()));
            zzvlVarZzj.zzn((Iterable) zzvf.zze(24, zzurVar).stream().map(zzvo.zza).collect(zznm.zzh()));
            zzvlVarZzj.zzo(zzvf.zzf(zzurVar).booleanValue());
            zzvlVarZzj.zzp(zzvf.zzb(zzurVar));
            zzvlVarZzj.zzq(zzvf.zzc(zzurVar));
            zzvlVarZzj.zzr(zzvf.zzc(zzurVar));
            zzni zzniVar = new zzni();
            int iZza7 = zzurVar.zza(12);
            Integer.valueOf(iZza7).getClass();
            while (iZza7 > 0) {
                int iZza8 = zzurVar.zza(6);
                Integer.valueOf(iZza8).getClass();
                zzup zzupVarZzb = zzup.zzb(iZza8);
                if (zzupVarZzb == null) {
                    throw null;
                }
                zzup zzupVar = zzupVarZzb;
                int iZza9 = zzurVar.zza(2);
                Integer.valueOf(iZza9).getClass();
                zzuw zzuwVarZzb = zzuw.zzb(iZza9);
                if (zzuwVarZzb == null) {
                    throw null;
                }
                zzuw zzuwVar = zzuwVarZzb;
                zznm zznmVarZzd = zzvf.zzd(zzurVar);
                zzuv zzuvVarZzd = zzux.zzd();
                zzuvVarZzd.zza(zzupVarZzb);
                zzuvVarZzd.zzb(zzuwVarZzb);
                zzuvVarZzd.zzc(zznmVarZzd);
                zzniVar.zzd((zzux) zzuvVarZzd.zzal());
                iZza7--;
            }
            zzvlVarZzj.zzs(zzniVar.zzf());
            zzvm zzvmVar = (zzvm) zzvlVarZzj.zzal();
            zzls.zzg(zzvf.zzg(zzurVar).booleanValue(), "TC string contains extra data at the end.");
            return Optional.of(zzvmVar);
        } catch (IllegalArgumentException e) {
            ((zzpd) ((zzpd) ((zzpd) zza.zzb()).zzo(e)).zzn("com/google/contentads/shared/adtech/iabtcfv2/TcfCoreStringCodec", "decode", 77, "TcfCoreStringCodec.java")).zzp("TC string is not a valid base64 string.");
            return Optional.empty();
        } catch (IllegalStateException e2) {
            ((zzpd) ((zzpd) ((zzpd) zza.zzb()).zzo(e2)).zzn("com/google/contentads/shared/adtech/iabtcfv2/TcfCoreStringCodec", "decode", 79, "TcfCoreStringCodec.java")).zzp("Error decoding TC string.");
            return Optional.empty();
        } catch (NullPointerException e3) {
            ((zzpd) ((zzpd) ((zzpd) zza.zzb()).zzo(e3)).zzn("com/google/contentads/shared/adtech/iabtcfv2/TcfCoreStringCodec", "decode", 81, "TcfCoreStringCodec.java")).zzp("TC string contains invalid feature/purpose.");
            return Optional.empty();
        } catch (RuntimeException e4) {
            ((zzpd) ((zzpd) ((zzpd) zza.zzb()).zzo(e4)).zzn("com/google/contentads/shared/adtech/iabtcfv2/TcfCoreStringCodec", "decode", 83, "TcfCoreStringCodec.java")).zzp("Unexpected error while decoding TC string.");
            return Optional.empty();
        }
    }
}
