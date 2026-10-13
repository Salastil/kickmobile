package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzxs extends zzxi {
    private static final zzxr zza = new zzxr(null);

    zzxs(zzzf zzzfVar) {
        super(zzzfVar);
    }

    @Nonnull
    @Deprecated
    public static zzxs zzd(String str) {
        return new zzxs(zzaad.zzd("Phlogger"));
    }

    public final zzxp zze(Level level) {
        boolean zZzb = zzb(level);
        zzaad.zzh(zza(), level, zZzb);
        return !zZzb ? zza : new zzxq(this, level, false);
    }
}
