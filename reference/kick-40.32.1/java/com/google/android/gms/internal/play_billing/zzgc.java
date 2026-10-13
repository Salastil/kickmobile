package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgc {
    static final zzgc zza = new zzgc(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile int zze = 1;
    private final Map zzd;

    zzgc() {
        this.zzd = new HashMap();
    }

    static boolean zzb() {
        return false;
    }

    public final zzgo zza(zzhr zzhrVar, int i) {
        return (zzgo) this.zzd.get(new zzgb(zzhrVar, i));
    }

    zzgc(boolean z) {
        this.zzd = Collections.EMPTY_MAP;
    }
}
