package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzdg {
    public static zzcs zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzxk zzxkVarZza = zzxk.zza(bArr, zzalf.zza());
            zzpf zzpfVarZza = zzpf.zza();
            zzcx zzcxVarZza = zzcx.zza(zzxkVarZza.zzf(), zzqk.zza(zzxkVarZza.zzd()), zzxkVarZza.zze());
            return !zzpfVarZza.zzb(zzcxVarZza) ? new zzor(zzcxVarZza) : zzpfVarZza.zza(zzcxVarZza);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zza(zzcs zzcsVar) throws GeneralSecurityException {
        zzcx zzcxVarZza;
        if (zzcsVar instanceof zzor) {
            zzcxVarZza = ((zzor) zzcsVar).zzb();
        } else {
            zzcxVarZza = zzpf.zza().zza(zzcsVar);
        }
        return ((zzxk) ((zzalt) zzxk.zza().zza(zzcxVarZza.zzc()).zza(zzcxVarZza.zzb()).zza(zzqk.zza(zzcxVarZza.zza())).zze())).zzk();
    }
}
