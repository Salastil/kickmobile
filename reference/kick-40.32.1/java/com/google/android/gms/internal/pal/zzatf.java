package com.google.android.gms.internal.pal;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzatf extends zzatg {
    final /* synthetic */ zzatl zza;
    private int zzb;
    private final int zzc;

    zzatf(zzatl zzatlVar) {
        Objects.requireNonNull(zzatlVar);
        this.zza = zzatlVar;
        this.zzb = 0;
        this.zzc = zzatlVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzati
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zza(i);
    }
}
