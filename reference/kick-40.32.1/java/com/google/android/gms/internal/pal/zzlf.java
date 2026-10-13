package com.google.android.gms.internal.pal;

import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzlf {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature[] zzc;

    static {
        Feature feature = new Feature("ADS_ID", 2L, true);
        zza = feature;
        Feature feature2 = new Feature("MAKE_REQUEST_WITH_SIGNALS", 1L, true);
        zzb = feature2;
        zzc = new Feature[]{feature, feature2};
    }
}
