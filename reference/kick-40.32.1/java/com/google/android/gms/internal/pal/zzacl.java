package com.google.android.gms.internal.pal;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzacl implements zzacn {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    zzacl(boolean z) {
    }

    @Override // com.google.android.gms.internal.pal.zzacn
    public final boolean zza() {
        return this.zza.get();
    }
}
