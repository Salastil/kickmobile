package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpf {
    private static final zzpf zza = (zzpf) zzqs.zza(new zzqr() { // from class: com.google.android.gms.internal.firebase-auth-api.zzpi
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqr
        public final Object zza() throws GeneralSecurityException {
            zzpf zzpfVar = new zzpf();
            zzpfVar.zza(zzoh.zza(new zzoj() { // from class: com.google.android.gms.internal.firebase-auth-api.zzph
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoj
                public final zzct zza(zzbt zzbtVar, zzdd zzddVar) {
                    return ((zzon) zzbtVar).zza(zzddVar);
                }
            }, zzon.class));
            zzpfVar.zza(zzpq.zza(new zzps() { // from class: com.google.android.gms.internal.firebase-auth-api.zzpk
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzps
                public final zzcx zza(zzcs zzcsVar) {
                    return ((zzor) zzcsVar).zzb();
                }
            }, zzor.class));
            return zzpfVar;
        }
    });
    private final AtomicReference<zzqo> zzb = new AtomicReference<>(new zzqn().zza());

    public final zzbt zza(zzct zzctVar, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        return this.zzb.get().zza(zzctVar, zzddVar);
    }

    public final zzcs zza(zzcx zzcxVar) throws GeneralSecurityException {
        return this.zzb.get().zza(zzcxVar);
    }

    public final <KeyT extends zzbt> zzct zza(KeyT keyt, @Nullable zzdd zzddVar) throws GeneralSecurityException {
        return this.zzb.get().zza(keyt, zzddVar);
    }

    public final <ParametersT extends zzcs> zzcx zza(ParametersT parameterst) throws GeneralSecurityException {
        return this.zzb.get().zza(parameterst);
    }

    public static zzpf zza() {
        return zza;
    }

    public final synchronized void zza(zzod zzodVar) throws GeneralSecurityException {
        this.zzb.set(new zzqn(this.zzb.get()).zza(zzodVar).zza());
    }

    public final synchronized <KeyT extends zzbt> void zza(zzoh<KeyT> zzohVar) throws GeneralSecurityException {
        this.zzb.set(new zzqn(this.zzb.get()).zza(zzohVar).zza());
    }

    public final synchronized void zza(zzpm zzpmVar) throws GeneralSecurityException {
        this.zzb.set(new zzqn(this.zzb.get()).zza(zzpmVar).zza());
    }

    public final synchronized <ParametersT extends zzcs> void zza(zzpq<ParametersT> zzpqVar) throws GeneralSecurityException {
        this.zzb.set(new zzqn(this.zzb.get()).zza(zzpqVar).zza());
    }

    public final boolean zza(zzct zzctVar) {
        return this.zzb.get().zza(zzctVar);
    }

    public final boolean zzb(zzcx zzcxVar) {
        return this.zzb.get().zzb(zzcxVar);
    }
}
