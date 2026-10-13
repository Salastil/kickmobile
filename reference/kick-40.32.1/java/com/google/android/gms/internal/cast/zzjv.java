package com.google.android.gms.internal.cast;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzjv extends zzjz {
    private static final zzjv zza = new zzjv(zzjz.zze());
    private final AtomicReference zzb;

    zzjv(zzjz zzjzVar) {
        this.zzb = new AtomicReference(zzjzVar);
    }

    public static final zzjv zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.cast.zzjz
    public final boolean zzb(String str, Level level, boolean z) {
        ((zzjz) this.zzb.get()).zzb(str, level, z);
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzjz
    public final zzkk zzc() {
        return ((zzjz) this.zzb.get()).zzc();
    }

    @Override // com.google.android.gms.internal.cast.zzjz
    public final zziz zzd() {
        return ((zzjz) this.zzb.get()).zzd();
    }
}
