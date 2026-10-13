package com.google.android.gms.cloudmessaging;

import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.4.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzi {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature[] zzc;

    static {
        Feature feature = new Feature("register", 1L, true);
        zza = feature;
        Feature feature2 = new Feature("unregister", 1L, true);
        zzb = feature2;
        zzc = new Feature[]{feature, feature2};
    }
}
