package com.google.android.gms.internal.pal;

import java.util.Optional;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzvc {
    private static final zzpg zza = zzpg.zzf("com/google/contentads/shared/adtech/iabtcfv2/PublisherTcCodec");

    static Optional zza(String str) {
        try {
            zzur zzurVar = new zzur(zztp.zzk().zzj(str));
            int iZza = zzurVar.zza(3);
            Integer.valueOf(iZza).getClass();
            zzls.zzf(iZza == 3);
            zzuy zzuyVarZza = zzuz.zza();
            zzuyVarZza.zza((Iterable) zzvf.zze(24, zzurVar).stream().map(zzvb.zza).collect(zznm.zzh()));
            zzuyVarZza.zzb((Iterable) zzvf.zze(24, zzurVar).stream().map(zzva.zza).collect(zznm.zzh()));
            int iZza2 = zzurVar.zza(6);
            Integer.valueOf(iZza2).getClass();
            if (iZza2 != 0) {
                zzuyVarZza.zzc(zzvf.zze(iZza2, zzurVar));
                zzuyVarZza.zzd(zzvf.zze(iZza2, zzurVar));
            }
            zzls.zzg(zzvf.zzg(zzurVar).booleanValue(), "PublisherTc segment contains extra data at the end.");
            return Optional.of((zzuz) zzuyVarZza.zzal());
        } catch (IllegalArgumentException e) {
            ((zzpd) ((zzpd) ((zzpd) zza.zzb()).zzo(e)).zzn("com/google/contentads/shared/adtech/iabtcfv2/PublisherTcCodec", "decode", 57, "PublisherTcCodec.java")).zzp("PublisherTc segment is not a valid base64 string.");
            return Optional.empty();
        } catch (IllegalStateException e2) {
            ((zzpd) ((zzpd) ((zzpd) zza.zzb()).zzo(e2)).zzn("com/google/contentads/shared/adtech/iabtcfv2/PublisherTcCodec", "decode", 59, "PublisherTcCodec.java")).zzp("Error decoding PublisherTc segment.");
            return Optional.empty();
        } catch (NullPointerException e3) {
            ((zzpd) ((zzpd) ((zzpd) zza.zzb()).zzo(e3)).zzn("com/google/contentads/shared/adtech/iabtcfv2/PublisherTcCodec", "decode", 61, "PublisherTcCodec.java")).zzp("PublisherTc segment contains invalid purposes.");
            return Optional.empty();
        }
    }
}
