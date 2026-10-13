package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.Cast;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzk extends Cast.Listener {
    final /* synthetic */ ExpandedControllerActivity zza;

    zzk(ExpandedControllerActivity expandedControllerActivity) {
        Objects.requireNonNull(expandedControllerActivity);
        this.zza = expandedControllerActivity;
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onDeviceNameChanged() {
        this.zza.zzc();
    }
}
