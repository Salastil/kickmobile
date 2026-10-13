package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzalf {
    static final zzalf zza = new zzalf(true);
    private static volatile boolean zzb = false;
    private static volatile int zzc = 1;
    private final Map<zzali, zzalt.zzd<?, ?>> zzd;

    public static zzalf zza() {
        return zza;
    }

    public final <ContainingType extends zzamv> zzalt.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzalt.zzd) this.zzd.get(new zzali(containingtype, i));
    }

    zzalf() {
        this.zzd = new HashMap();
    }

    private zzalf(boolean z) {
        this.zzd = Collections.EMPTY_MAP;
    }

    static boolean zzb() {
        return zzc == 2;
    }
}
