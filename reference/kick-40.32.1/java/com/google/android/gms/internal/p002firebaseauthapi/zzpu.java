package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzpu<P> {
    private static final zzaau zza = zzaau.zza(new byte[0]);
    private final Map<zzaau, List<P>> zzb;

    public final Iterable<P> zza(byte[] bArr) {
        List<P> list = this.zzb.get(zza);
        List<P> list2 = bArr.length >= 5 ? this.zzb.get(zzaau.zza(bArr, 0, 5)) : null;
        if (list == null && list2 == null) {
            return new ArrayList();
        }
        if (list == null) {
            return list2;
        }
        return list2 == null ? list : new zzpt(this, list2, list);
    }

    private zzpu(Map<zzaau, List<P>> map) {
        this.zzb = map;
    }
}
