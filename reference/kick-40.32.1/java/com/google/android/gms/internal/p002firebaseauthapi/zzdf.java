package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdf {
    public static zzxt zza(zzxq zzxqVar) {
        zzxt.zzb zzbVarZza = zzxt.zza().zza(zzxqVar.zzb());
        for (zzxq.zza zzaVar : zzxqVar.zze()) {
            zzbVarZza.zza((zzxt.zza) ((zzalt) zzxt.zza.zza().zza(zzaVar.zzb().zzf()).zza(zzaVar.zzc()).zza(zzaVar.zzf()).zza(zzaVar.zza()).zze()));
        }
        return (zzxt) ((zzalt) zzbVarZza.zze());
    }

    static {
        Charset.forName("UTF-8");
    }

    public static void zzb(zzxq zzxqVar) throws GeneralSecurityException {
        int iZzb = zzxqVar.zzb();
        int i = 0;
        boolean z = false;
        for (zzxq.zza zzaVar : zzxqVar.zze()) {
            if (zzaVar.zzc() == zzxh.ENABLED) {
                if (!zzaVar.e_()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzaVar.zza())));
                }
                if (zzaVar.zzf() == zzyi.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzaVar.zza())));
                }
                if (zzaVar.zzc() == zzxh.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzaVar.zza())));
                }
                if (zzaVar.zza() == iZzb) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
    }
}
