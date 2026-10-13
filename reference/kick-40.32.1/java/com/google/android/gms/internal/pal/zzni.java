package com.google.android.gms.internal.pal;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzni extends zznf {
    public zzni() {
        super(4);
    }

    public final zzni zzd(Object obj) {
        super.zza(obj);
        return this;
    }

    public final zzni zze(Iterator it) {
        while (it.hasNext()) {
            super.zza(it.next());
        }
        return this;
    }

    public final zznm zzf() {
        this.zzc = true;
        return zznm.zzk(this.zza, this.zzb);
    }

    zzni(int i) {
        super(i);
    }
}
