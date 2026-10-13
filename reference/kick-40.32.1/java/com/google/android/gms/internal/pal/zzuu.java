package com.google.android.gms.internal.pal;

import java.util.Optional;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzuu {
    private static final zzpg zza = zzpg.zzf("com/google/contentads/shared/adtech/iabtcfv2/DisclosedVendorsCodec");

    static Optional zza(String str) {
        try {
            zzur zzurVar = new zzur(zztp.zzk().zzj(str));
            int iZza = zzurVar.zza(3);
            Integer.valueOf(iZza).getClass();
            boolean z = true;
            if (iZza != 1) {
                z = false;
            }
            zzls.zzg(z, "Incorrect segment type");
            zzus zzusVarZzb = zzut.zzb();
            zzusVarZzb.zza(zzvf.zzc(zzurVar));
            zzut zzutVar = (zzut) zzusVarZzb.zzal();
            zzls.zzg(zzvf.zzg(zzurVar).booleanValue(), "DisclosedVendors segment contains extra data at the end.");
            return Optional.of(zzutVar);
        } catch (IllegalArgumentException e) {
            ((zzpd) ((zzpd) ((zzpd) zza.zzb()).zzo(e)).zzn("com/google/contentads/shared/adtech/iabtcfv2/DisclosedVendorsCodec", "decode", 41, "DisclosedVendorsCodec.java")).zzp("DisclosedVendors segment is not a valid base64 string.");
            return Optional.empty();
        } catch (IllegalStateException e2) {
            ((zzpd) ((zzpd) ((zzpd) zza.zzb()).zzo(e2)).zzn("com/google/contentads/shared/adtech/iabtcfv2/DisclosedVendorsCodec", "decode", 43, "DisclosedVendorsCodec.java")).zzq("Error decoding DisclosedVendors segment: %s", e2.getMessage());
            return Optional.empty();
        }
    }
}
