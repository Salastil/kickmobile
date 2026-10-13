package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.app.Application;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzem implements zzep {
    final /* synthetic */ Activity zza;

    zzem(zzeq zzeqVar, Activity activity) {
        this.zza = activity;
        Objects.requireNonNull(zzeqVar);
    }

    @Override // com.google.android.gms.internal.pal.zzep
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.zza);
    }
}
