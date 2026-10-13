package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.internal.ListenerHolder;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzka extends zzkn {
    final /* synthetic */ ListenerHolder zza;

    zzka(zzkk zzkkVar, ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
        Objects.requireNonNull(zzkkVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzko
    public final void zzb(byte[] bArr) {
        this.zza.notifyListener(new zzjz(this, bArr));
    }
}
