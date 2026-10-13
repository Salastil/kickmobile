package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpg {
    private static zzpg zza = new zzpg();
    private final AtomicReference<zzqb> zzb = new AtomicReference<>(new zzqd().zza());

    public static zzpg zza() {
        return zza;
    }

    public final <KeyT extends zzbt, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        return (PrimitiveT) this.zzb.get().zza(keyt, cls);
    }

    public final <WrapperPrimitiveT> WrapperPrimitiveT zza(zzch zzchVar, Class<WrapperPrimitiveT> cls) throws GeneralSecurityException {
        return (WrapperPrimitiveT) this.zzb.get().zza(zzchVar, cls);
    }

    zzpg() {
    }

    public final synchronized <KeyT extends zzbt, PrimitiveT> void zza(zzpx<KeyT, PrimitiveT> zzpxVar) throws GeneralSecurityException {
        this.zzb.set(zzqb.zza(this.zzb.get()).zza(zzpxVar).zza());
    }

    public final synchronized <InputPrimitiveT, WrapperPrimitiveT> void zza(zzqi<InputPrimitiveT, WrapperPrimitiveT> zzqiVar) throws GeneralSecurityException {
        this.zzb.set(zzqb.zza(this.zzb.get()).zza(zzqiVar).zza());
    }
}
