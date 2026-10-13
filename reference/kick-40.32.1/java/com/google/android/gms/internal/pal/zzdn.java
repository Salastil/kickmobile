package com.google.android.gms.internal.pal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdn implements Runnable {
    final /* synthetic */ zzdo zza;

    zzdn(zzdo zzdoVar) {
        Objects.requireNonNull(zzdoVar);
        this.zza = zzdoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        zzdo zzdoVar = this.zza;
        if (zzdoVar.zzb != null) {
            return;
        }
        synchronized (zzdo.zzd) {
            if (zzdoVar.zzb != null) {
                return;
            }
            boolean z = false;
            try {
                zBooleanValue = ((Boolean) zzia.zzi.zzc()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzdo.zza = zzko.zzb(this.zza.zzb().zza, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z = zBooleanValue;
            this.zza.zzb = Boolean.valueOf(z);
            zzdo.zzd.open();
        }
    }
}
