package com.google.android.gms.internal.pal;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzawj extends zzatg {
    final zzawl zza;
    zzati zzb;
    final /* synthetic */ zzawm zzc;

    zzawj(zzawm zzawmVar) {
        Objects.requireNonNull(zzawmVar);
        this.zzc = zzawmVar;
        this.zza = new zzawl(zzawmVar, null);
        this.zzb = zzb();
    }

    private final zzati zzb() {
        zzawl zzawlVar = this.zza;
        if (zzawlVar.hasNext()) {
            return zzawlVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.android.gms.internal.pal.zzati
    public final byte zza() {
        zzati zzatiVar = this.zzb;
        if (zzatiVar == null) {
            throw new NoSuchElementException();
        }
        byte bZza = zzatiVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return bZza;
    }
}
