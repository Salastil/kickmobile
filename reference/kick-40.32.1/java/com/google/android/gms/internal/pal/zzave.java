package com.google.android.gms.internal.pal;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzave implements Map.Entry {
    private final Map.Entry zza;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        zzavg zzavgVar = (zzavg) this.zza.getValue();
        if (zzavgVar == null) {
            return null;
        }
        zzavgVar.zzd(null);
        return zzavgVar.zza;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzavw) {
            return ((zzavg) this.zza.getValue()).zza((zzavw) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzavg zza() {
        return (zzavg) this.zza.getValue();
    }
}
