package com.google.android.gms.cast.framework.devicesuggestions;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.cast.zzav;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class DeviceSuggestions {
    private DeviceSuggestions() {
    }

    public static DeviceSuggestionsClient getClient(Activity activity) {
        return new zzav(activity);
    }

    public static DeviceSuggestionsClient getClient(Context context) {
        return new zzav(context);
    }
}
