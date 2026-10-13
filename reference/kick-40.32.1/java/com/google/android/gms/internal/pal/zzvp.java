package com.google.android.gms.internal.pal;

import java.util.function.Function;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final /* synthetic */ class zzvp implements Function {
    static final /* synthetic */ zzvp zza = new zzvp();

    private /* synthetic */ zzvp() {
    }

    @Override // java.util.function.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzuq zzuqVar;
        int iIntValue = ((Integer) obj).intValue();
        if (iIntValue == 0) {
            zzuqVar = zzuq.IAB_TCF_SPECIAL_FEATURE_UNKNOWN;
        } else if (iIntValue != 1) {
            zzuqVar = iIntValue != 2 ? null : zzuq.IAB_TCF_SPECIAL_FEATURE_ACTIVELY_SCAN_DEVICE_CHARACTERISTICS_FOR_IDENTIFICATION;
        } else {
            zzuqVar = zzuq.IAB_TCF_SPECIAL_FEATURE_USE_PRECISE_GEOLOCATION_DATA;
        }
        zzuqVar.getClass();
        return zzuqVar;
    }
}
