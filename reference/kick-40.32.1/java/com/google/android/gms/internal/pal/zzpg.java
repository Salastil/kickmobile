package com.google.android.gms.internal.pal;

import java.util.logging.Level;
import javax.annotation.Nonnull;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpg extends zzow {
    private static final zzpf zza = new zzpf(null);

    zzpg(zzqt zzqtVar) {
        super(zzqtVar);
    }

    @Nonnull
    @Deprecated
    public static zzpg zzf(String str) {
        return new zzpg(zzrr.zzd(str.replace('/', FilenameUtils.EXTENSION_SEPARATOR)));
    }

    @Override // com.google.android.gms.internal.pal.zzow
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzpd zza(Level level) {
        boolean zZzd = zzd(level);
        zzrr.zzh(zzc(), level, zZzd);
        return !zZzd ? zza : new zzpe(this, level, false);
    }
}
