package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaii {
    private static final zzaii zza = new zzaii();
    private final AtomicReference zzb = new AtomicReference(new zzajb(new zzaiy(null), null));

    zzaii() {
    }

    public static zzaii zza() {
        return zza;
    }

    public final synchronized void zzb(zzaix zzaixVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzaiy zzaiyVar = new zzaiy((zzajb) atomicReference.get(), null);
        zzaiyVar.zza(zzaixVar);
        atomicReference.set(new zzajb(zzaiyVar, null));
    }

    public final synchronized void zzc(zzajd zzajdVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzaiy zzaiyVar = new zzaiy((zzajb) atomicReference.get(), null);
        zzaiyVar.zzb(zzajdVar);
        atomicReference.set(new zzajb(zzaiyVar, null));
    }

    public final Object zzd(zzvz zzvzVar, Class cls) throws GeneralSecurityException {
        return ((zzajb) this.zzb.get()).zzb(zzvzVar, cls);
    }
}
