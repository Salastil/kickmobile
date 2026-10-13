package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbu {
    private static volatile zzbu zza;
    private final List zzb = new CopyOnWriteArrayList();

    private zzbu() {
    }

    public static zzbu zza() {
        if (zza == null) {
            synchronized (zzbu.class) {
                if (zza == null) {
                    zza = new zzbu();
                }
            }
        }
        return zza;
    }

    public final void zzb(zzbt zzbtVar) {
        this.zzb.add(0, zzbtVar);
    }
}
