package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzail {
    private static final zzail zza = (zzail) zzajo.zza(zzaik.zza);
    private final AtomicReference zzb = new AtomicReference(new zzajm(new zzajj(), null));

    public static zzail zza() {
        return zza;
    }

    public final synchronized void zzb(zzahp zzahpVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzajj zzajjVar = new zzajj((zzajm) atomicReference.get());
        zzajjVar.zza(zzahpVar);
        atomicReference.set(new zzajm(zzajjVar, null));
    }

    public final synchronized void zzc(zzahm zzahmVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzajj zzajjVar = new zzajj((zzajm) atomicReference.get());
        zzajjVar.zzb(zzahmVar);
        atomicReference.set(new zzajm(zzajjVar, null));
    }

    public final synchronized void zzd(zzais zzaisVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzajj zzajjVar = new zzajj((zzajm) atomicReference.get());
        zzajjVar.zzc(zzaisVar);
        atomicReference.set(new zzajm(zzajjVar, null));
    }

    public final synchronized void zze(zzaip zzaipVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzajj zzajjVar = new zzajj((zzajm) atomicReference.get());
        zzajjVar.zzd(zzaipVar);
        atomicReference.set(new zzajm(zzajjVar, null));
    }

    public final boolean zzf(zzaji zzajiVar) {
        return ((zzajm) this.zzb.get()).zza(zzajiVar);
    }

    public final zzvz zzg(zzaji zzajiVar, @Nullable zzwm zzwmVar) throws GeneralSecurityException {
        return ((zzajm) this.zzb.get()).zzb(zzajiVar, zzwmVar);
    }

    public final zzaji zzh(zzvz zzvzVar, Class cls, @Nullable zzwm zzwmVar) throws GeneralSecurityException {
        return ((zzajm) this.zzb.get()).zzc(zzvzVar, cls, zzwmVar);
    }

    public final boolean zzi(zzaji zzajiVar) {
        return ((zzajm) this.zzb.get()).zzd(zzajiVar);
    }

    public final zzwk zzj(zzaji zzajiVar) throws GeneralSecurityException {
        return ((zzajm) this.zzb.get()).zze(zzajiVar);
    }

    public final zzaji zzk(zzwk zzwkVar, Class cls) throws GeneralSecurityException {
        return ((zzajm) this.zzb.get()).zzf(zzwkVar, cls);
    }
}
