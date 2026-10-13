package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzoy {
    private static final zzob<zzor> zza = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzox
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzoy.zza((zzor) zzcsVar, num);
        }
    };
    private static final zzoy zzb = zzb();
    private final Map<Class<? extends zzcs>, zzob<? extends zzcs>> zzc = new HashMap();

    public final zzbt zza(zzcs zzcsVar, @Nullable Integer num) throws GeneralSecurityException {
        return zzb(zzcsVar, num);
    }

    private final synchronized <ParametersT extends zzcs> zzbt zzb(ParametersT parameterst, @Nullable Integer num) throws GeneralSecurityException {
        zzob<? extends zzcs> zzobVar;
        zzobVar = this.zzc.get(parameterst.getClass());
        if (zzobVar == null) {
            throw new GeneralSecurityException("Cannot create a new key for parameters " + String.valueOf(parameterst) + ": no key creator for this class was registered.");
        }
        return zzobVar.zza(parameterst, num);
    }

    public static /* synthetic */ zzon zza(zzor zzorVar, Integer num) throws GeneralSecurityException {
        zzcx zzcxVarZzb = zzorVar.zzb();
        zzbw<?> zzbwVarZza = zzoe.zza().zza(zzcxVarZzb.zzc());
        if (!zzoe.zza().zzb(zzcxVarZzb.zzc())) {
            throw new GeneralSecurityException("Creating new keys is not allowed.");
        }
        zzxg zzxgVarZza = zzbwVarZza.zza(zzcxVarZzb.zzb());
        return new zzon(zzct.zza(zzxgVarZza.zzf(), zzxgVarZza.zze(), zzqk.zza(zzxgVarZza.zzb()), zzcxVarZzb.zza(), num), zzbu.zza());
    }

    public static zzoy zza() {
        return zzb;
    }

    private static zzoy zzb() {
        zzoy zzoyVar = new zzoy();
        try {
            zzoyVar.zza(zza, zzor.class);
            return zzoyVar;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    public final synchronized <ParametersT extends zzcs> void zza(zzob<ParametersT> zzobVar, Class<ParametersT> cls) throws GeneralSecurityException {
        zzob<? extends zzcs> zzobVar2 = this.zzc.get(cls);
        if (zzobVar2 != null && !zzobVar2.equals(zzobVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class " + String.valueOf(cls) + " already inserted");
        }
        this.zzc.put(cls, zzobVar);
    }
}
