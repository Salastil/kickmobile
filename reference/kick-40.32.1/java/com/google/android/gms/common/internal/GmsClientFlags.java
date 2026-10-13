package com.google.android.gms.common.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.10.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class GmsClientFlags {
    private static volatile boolean zza = true;

    private GmsClientFlags() {
    }

    public static boolean isBindServiceOptimizationEnabled(String str) {
        return zza;
    }
}
