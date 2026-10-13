package com.google.android.gms.cast.framework;

import android.content.Context;
import android.preference.PreferenceManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbd {
    public static void zza(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("googlecast-introOverlayShown", true).apply();
    }
}
