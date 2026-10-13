package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzack extends zzacl {
    final /* synthetic */ zzacr zza;
    private int zzb;
    private final int zzc;

    zzack(zzacr zzacrVar) {
        Objects.requireNonNull(zzacrVar);
        this.zza = zzacrVar;
        this.zzb = 0;
        this.zzc = zzacrVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzacn
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zza(i);
    }
}
