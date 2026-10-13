package com.google.android.gms.internal.pal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzavj {
    zzavj() {
    }

    public static final List zza(Object obj, long j) {
        zzauy zzauyVar = (zzauy) zzaxh.zzn(obj, j);
        if (zzauyVar.zza()) {
            return zzauyVar;
        }
        int size = zzauyVar.size();
        zzauy zzauyVarZzg = zzauyVar.zzg(size == 0 ? 10 : size + size);
        zzaxh.zzo(obj, j, zzauyVarZzg);
        return zzauyVarZzg;
    }
}
