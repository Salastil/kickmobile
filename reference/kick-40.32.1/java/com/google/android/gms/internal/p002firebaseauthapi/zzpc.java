package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpc {
    private static final zzpc zza = new zzpc();
    private static final zzpb zzb = new zzpb();
    private final AtomicReference<zzou> zzc = new AtomicReference<>();

    public final zzou zza() {
        zzou zzouVar = this.zzc.get();
        return zzouVar == null ? zzb : zzouVar;
    }

    public static zzpc zzb() {
        return zza;
    }
}
