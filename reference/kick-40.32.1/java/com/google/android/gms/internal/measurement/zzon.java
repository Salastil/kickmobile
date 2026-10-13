package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzon {
    private final Function zza;
    private final boolean zzb;
    private final ImmutableSet zzc;
    private volatile String zzd = null;

    zzon(Function function, boolean z, boolean z2, boolean z3, boolean z4, ImmutableSet immutableSet) {
        this.zza = function;
        this.zzb = z3;
        this.zzc = immutableSet;
    }

    final String zza(Context context) {
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        String str2 = (String) this.zza.apply(context);
        this.zzd = str2;
        return str2;
    }

    final boolean zzb() {
        return this.zzb;
    }

    final ImmutableSet zzc() {
        return this.zzc;
    }
}
