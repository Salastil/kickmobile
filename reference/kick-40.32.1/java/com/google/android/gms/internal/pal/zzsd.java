package com.google.android.gms.internal.pal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzsd extends zzsh {
    private static final zzsd zza = new zzsd(zzsh.zze());
    private final AtomicReference zzb;

    zzsd(zzsh zzshVar) {
        this.zzb = new AtomicReference(zzshVar);
    }

    public static final zzsd zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.pal.zzsh
    public final boolean zzb(String str, Level level, boolean z) {
        ((zzsh) this.zzb.get()).zzb(str, level, z);
        return false;
    }

    @Override // com.google.android.gms.internal.pal.zzsh
    public final zzss zzc() {
        return ((zzsh) this.zzb.get()).zzc();
    }

    @Override // com.google.android.gms.internal.pal.zzsh
    public final zzqx zzd() {
        return ((zzsh) this.zzb.get()).zzd();
    }
}
