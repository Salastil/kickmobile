package com.google.android.gms.internal.pal;

import java.util.Objects;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzpe extends zzpc implements zzpd {
    final /* synthetic */ zzpg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzpe(zzpg zzpgVar, Level level, boolean z) {
        super(level, false);
        Objects.requireNonNull(zzpgVar);
        this.zza = zzpgVar;
    }

    @Override // com.google.android.gms.internal.pal.zzpn
    protected final /* synthetic */ zzow zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.pal.zzpn
    protected final /* bridge */ /* synthetic */ zzpw zzd() {
        return this;
    }
}
