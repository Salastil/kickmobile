package com.google.android.gms.internal.pal;

import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeh extends zzcm {
    public long zza;
    public long zzb;

    public zzeh() {
        this.zza = -1L;
        this.zzb = -1L;
    }

    public zzeh(String str) {
        this.zza = -1L;
        this.zzb = -1L;
        HashMap mapZzb = zzb(str);
        if (mapZzb != null) {
            this.zza = ((Long) mapZzb.get(0)).longValue();
            this.zzb = ((Long) mapZzb.get(1)).longValue();
        }
    }

    @Override // com.google.android.gms.internal.pal.zzcm
    protected final HashMap zza() {
        HashMap map = new HashMap();
        map.put(0, Long.valueOf(this.zza));
        map.put(1, Long.valueOf(this.zzb));
        return map;
    }
}
