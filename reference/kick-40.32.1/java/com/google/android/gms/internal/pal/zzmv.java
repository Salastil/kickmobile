package com.google.android.gms.internal.pal;

import java.util.stream.Collector;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzmv {
    private static final Collector zza = Collector.of(zzmm.zza, zzml.zza, zzmj.zza, zzmk.zza, new Collector.Characteristics[0]);

    static {
        Collector.of(zzmu.zza, zzmt.zza, zzmr.zza, zzms.zza, new Collector.Characteristics[0]);
        Collector.of(zzmq.zza, zzmp.zza, zzmn.zza, zzmo.zza, new Collector.Characteristics[0]);
    }

    static Collector zza() {
        return zza;
    }
}
