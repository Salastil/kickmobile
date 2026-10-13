package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzqo implements zzcy {
    private final Map<Class<?>, zzoh<?>> zza;
    private final Map<String, zzod> zzb;
    private final Map<Class<?>, zzpq<?>> zzc;
    private final Map<String, zzpm> zzd;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcy
    public final zzbt zza(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        String strZze = zzctVar.zze();
        if (this.zzb.containsKey(strZze)) {
            return this.zzb.get(strZze).zza(zzctVar, zzddVar);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + strZze + " available");
    }

    public final zzcs zza(zzcx zzcxVar) throws GeneralSecurityException {
        String strZzc = zzcxVar.zzc();
        if (!this.zzd.containsKey(strZzc)) {
            throw new GeneralSecurityException("No Parameters Parser for requested key type " + strZzc + " available");
        }
        return this.zzd.get(strZzc).zza(zzcxVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcy
    public final zzct zza(zzbt zzbtVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        if (!this.zza.containsKey(zzbtVar.getClass())) {
            throw new GeneralSecurityException("No Key serializer for " + String.valueOf(zzbtVar.getClass()) + " available");
        }
        return this.zza.get(zzbtVar.getClass()).zza(zzbtVar, zzddVar);
    }

    public final zzcx zza(zzcs zzcsVar) throws GeneralSecurityException {
        if (!this.zzc.containsKey(zzcsVar.getClass())) {
            throw new GeneralSecurityException("No Key Format serializer for " + String.valueOf(zzcsVar.getClass()) + " available");
        }
        return this.zzc.get(zzcsVar.getClass()).zza(zzcsVar);
    }

    private zzqo(zzqn zzqnVar) {
        this.zza = new HashMap(zzqnVar.zza);
        this.zzb = new HashMap(zzqnVar.zzb);
        this.zzc = new HashMap(zzqnVar.zzc);
        this.zzd = new HashMap(zzqnVar.zzd);
    }

    public final boolean zza(zzct zzctVar) {
        return this.zzb.containsKey(zzctVar.zze());
    }

    public final boolean zzb(zzcx zzcxVar) {
        return this.zzd.containsKey(zzcxVar.zzc());
    }
}
