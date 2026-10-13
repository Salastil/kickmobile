package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzfh extends zzfi {
    final /* synthetic */ zzfp zza;
    private int zzb;
    private final int zzc;

    zzfh(zzfp zzfpVar) {
        Objects.requireNonNull(zzfpVar);
        this.zza = zzfpVar;
        this.zzb = 0;
        this.zzc = zzfpVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfk
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zza(i);
    }
}
