package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzby {

    @Nullable
    private final zzcs zza;

    public static zzby zza(zzcs zzcsVar) throws GeneralSecurityException {
        return new zzby(zzcsVar);
    }

    public final zzcs zza() throws GeneralSecurityException {
        zzcs zzcsVar = this.zza;
        return zzcsVar != null ? zzcsVar : zzdg.zza(zzb().zzk());
    }

    private final zzxk zzb() {
        zzcx zzcxVarZza;
        try {
            zzcs zzcsVar = this.zza;
            if (zzcsVar instanceof zzor) {
                zzcxVarZza = ((zzor) zzcsVar).zzb();
            } else {
                zzcxVarZza = zzpf.zza().zza(this.zza);
            }
            return (zzxk) ((zzalt) zzxk.zza().zza(zzcxVarZza.zzc()).zza(zzcxVarZza.zzb()).zza(zzqk.zza(zzcxVarZza.zza())).zze());
        } catch (GeneralSecurityException e) {
            throw new zzqs("Parsing parameters failed in getProto(). You probably want to call some Tink register function for " + String.valueOf(this.zza), e);
        }
    }

    private zzby(zzcs zzcsVar) {
        this.zza = zzcsVar;
    }
}
