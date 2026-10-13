package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzuz {
    public static Uri zza(Uri uri, String str) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        String path = uri.getPath();
        String.valueOf(path);
        return builderBuildUpon.path(String.valueOf(path).concat(str)).build();
    }
}
