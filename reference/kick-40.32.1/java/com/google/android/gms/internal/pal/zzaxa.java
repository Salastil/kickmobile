package com.google.android.gms.internal.pal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzaxa {
    private static volatile int zza = 100;

    zzaxa() {
    }

    abstract void zza(Object obj, int i, long j);

    abstract void zzb(Object obj, int i, int i2);

    abstract void zzc(Object obj, int i, long j);

    abstract void zzd(Object obj, int i, zzatl zzatlVar);

    abstract void zze(Object obj, int i, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract Object zzh(Object obj);

    abstract void zzi(Object obj, Object obj2);

    abstract void zzj(Object obj);

    final boolean zzk(Object obj, zzawi zzawiVar, int i) throws IOException {
        int iZzc = zzawiVar.zzc();
        int i2 = iZzc >>> 3;
        int i3 = iZzc & 7;
        if (i3 == 0) {
            zza(obj, i2, zzawiVar.zzg());
            return true;
        }
        if (i3 == 1) {
            zzc(obj, i2, zzawiVar.zzi());
            return true;
        }
        if (i3 == 2) {
            zzd(obj, i2, zzawiVar.zzp());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                throw new zzavb("Protocol message end-group tag did not match expected tag.");
            }
            if (i3 != 5) {
                throw new zzava("Protocol message tag had invalid wire type.");
            }
            zzb(obj, i2, zzawiVar.zzj());
            return true;
        }
        Object objZzf = zzf();
        int i4 = i2 << 3;
        int i5 = i + 1;
        if (i5 >= zza) {
            throw new zzavb("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzawiVar.zzb() != Integer.MAX_VALUE && zzk(objZzf, zzawiVar, i5)) {
        }
        if ((i4 | 4) != zzawiVar.zzc()) {
            throw new zzavb("Protocol message end-group tag did not match expected tag.");
        }
        zze(obj, i2, zzg(objZzf));
        return true;
    }
}
