package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaie {
    private final String zza;
    private final zzajp zzb;

    public final zzajp zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public zzaie(String str, zzajp zzajpVar) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = (zzajp) Preconditions.checkNotNull(zzajpVar);
    }
}
