package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwn {
    public static byte[] zza(zzwk zzwkVar) throws GeneralSecurityException {
        return zzwkVar instanceof zzahu ? ((zzahu) zzwkVar).zzb().zzc().zzaq() : ((zzajf) zzail.zza().zzk(zzwkVar, zzajf.class)).zzc().zzaq();
    }

    public static zzwk zzb(byte[] bArr) throws GeneralSecurityException {
        try {
            zzaot zzaotVarZzd = zzaot.zzd(bArr, zzaty.zza());
            zzail zzailVarZza = zzail.zza();
            zzajf zzajfVarZzb = zzajf.zzb(zzaotVarZzd);
            return !zzailVarZza.zzi(zzajfVarZzb) ? new zzahu(zzajfVarZzb) : zzailVarZza.zzj(zzajfVarZzb);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }
}
