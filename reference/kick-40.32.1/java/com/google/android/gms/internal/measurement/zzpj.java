package com.google.android.gms.internal.measurement;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpj {
    private final Function zza;
    private final ImmutableSet zzb = ImmutableSet.of();
    private boolean zzc = false;

    public zzpj(Function function) {
        this.zza = function;
    }

    public final zzpj zza() {
        this.zzc = true;
        return this;
    }

    public final zzph zzb() {
        return new zzpi(new zzon(this.zza, false, false, this.zzc, false, this.zzb), null);
    }
}
