package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzafz {
    private static volatile int zza = 100;

    zzafz() {
    }

    abstract void zza(Object obj, int i, long j);

    abstract void zzb(Object obj, int i, int i2);

    abstract void zzc(Object obj, int i, long j);

    abstract void zzd(Object obj, int i, zzacr zzacrVar);

    abstract void zze(Object obj, int i, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract Object zzh(Object obj);

    abstract void zzi(Object obj, Object obj2);

    abstract void zzj(Object obj);

    final boolean zzk(Object obj, zzafo zzafoVar, int i) throws IOException {
        int iZzc = zzafoVar.zzc();
        int i2 = iZzc >>> 3;
        int i3 = iZzc & 7;
        if (i3 == 0) {
            zza(obj, i2, zzafoVar.zzh());
            return true;
        }
        if (i3 == 1) {
            zzc(obj, i2, zzafoVar.zzj());
            return true;
        }
        if (i3 == 2) {
            zzd(obj, i2, zzafoVar.zzq());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                throw new zzaeh("Protocol message end-group tag did not match expected tag.");
            }
            if (i3 != 5) {
                throw new zzaeg("Protocol message tag had invalid wire type.");
            }
            zzb(obj, i2, zzafoVar.zzk());
            return true;
        }
        Object objZzf = zzf();
        int i4 = i2 << 3;
        int i5 = i + 1;
        if (i5 >= zza) {
            throw new zzaeh("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzafoVar.zzb() != Integer.MAX_VALUE && zzk(objZzf, zzafoVar, i5)) {
        }
        if ((i4 | 4) != zzafoVar.zzc()) {
            throw new zzaeh("Protocol message end-group tag did not match expected tag.");
        }
        zze(obj, i2, zzg(objZzf));
        return true;
    }
}
