package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzaob<T, B> {
    private static volatile int zza = 100;

    abstract int zza(T t);

    abstract B zza();

    abstract T zza(T t, T t2);

    abstract void zza(B b, int i, int i2);

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzakb zzakbVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzale zzaleVar) throws IOException;

    abstract boolean zza(zzakw zzakwVar);

    abstract int zzb(T t);

    abstract void zzb(B b, int i, long j);

    abstract void zzb(T t, zzale zzaleVar) throws IOException;

    abstract void zzb(Object obj, B b);

    abstract B zzc(Object obj);

    abstract void zzc(Object obj, T t);

    abstract T zzd(Object obj);

    abstract T zze(B b);

    abstract void zzf(Object obj);

    zzaob() {
    }

    final boolean zza(B b, zzakw zzakwVar, int i) throws IOException {
        int iZzd = zzakwVar.zzd();
        int i2 = iZzd >>> 3;
        int i3 = iZzd & 7;
        if (i3 == 0) {
            zzb(b, i2, zzakwVar.zzl());
            return true;
        }
        if (i3 == 1) {
            zza(b, i2, zzakwVar.zzk());
            return true;
        }
        if (i3 == 2) {
            zza((Object) b, i2, zzakwVar.zzp());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                throw zzamd.zzb();
            }
            if (i3 == 5) {
                zza((Object) b, i2, zzakwVar.zzf());
                return true;
            }
            throw zzamd.zza();
        }
        B bZza = zza();
        int i4 = 4 | (i2 << 3);
        int i5 = i + 1;
        if (i5 >= zza) {
            throw zzamd.zzh();
        }
        while (zzakwVar.zzc() != Integer.MAX_VALUE && zza(bZza, zzakwVar, i5)) {
        }
        if (i4 != zzakwVar.zzd()) {
            throw zzamd.zzb();
        }
        zza(b, i2, zze(bZza));
        return true;
    }
}
