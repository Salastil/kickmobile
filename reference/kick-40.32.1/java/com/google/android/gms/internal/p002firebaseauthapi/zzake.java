package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzake extends zzakg {
    private int zza;
    private final int zzb;
    private final /* synthetic */ zzakb zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakh
    public final byte zza() {
        int i = this.zza;
        if (i >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i + 1;
        return this.zzc.zza(i);
    }

    zzake(zzakb zzakbVar) {
        Objects.requireNonNull(zzakbVar);
        this.zzc = zzakbVar;
        this.zza = 0;
        this.zzb = zzakbVar.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }
}
