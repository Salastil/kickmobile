package com.google.android.gms.internal.pal;

import java.util.Optional;
import kotlin.UByte$$ExternalSyntheticBackport0;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzvi {
    public static Optional zza(String str) {
        if (zzmd.zzb(str)) {
            return Optional.empty();
        }
        zznm zznmVarZzj = zznm.zzj(zzmb.zza(FilenameUtils.EXTENSION_SEPARATOR).zzc(str));
        if (zznmVarZzj.isEmpty() || zznmVarZzj.size() > 4) {
            return Optional.empty();
        }
        Optional optionalZza = zzvq.zza((String) zznmVarZzj.get(0));
        if (UByte$$ExternalSyntheticBackport0.m(optionalZza)) {
            return Optional.empty();
        }
        zzvg zzvgVarZzd = zzvh.zzd();
        zzvgVarZzd.zza((zzvm) optionalZza.get());
        for (int i = 1; i < zznmVarZzj.size(); i++) {
            int iZza = new zzur(zztp.zzk().zzj((String) zznmVarZzj.get(i))).zza(3);
            if (iZza == 1) {
                Optional optionalZza2 = zzuu.zza((String) zznmVarZzj.get(i));
                if (UByte$$ExternalSyntheticBackport0.m(optionalZza2)) {
                    return Optional.empty();
                }
                zzvgVarZzd.zzb((zzut) optionalZza2.get());
            } else if (iZza == 2) {
                continue;
            } else {
                if (iZza != 3) {
                    return Optional.empty();
                }
                Optional optionalZza3 = zzvc.zza((String) zznmVarZzj.get(i));
                if (UByte$$ExternalSyntheticBackport0.m(optionalZza3)) {
                    return Optional.empty();
                }
                zzvgVarZzd.zzc((zzuz) optionalZza3.get());
            }
        }
        return Optional.of((zzvh) zzvgVarZzd.zzal());
    }
}
