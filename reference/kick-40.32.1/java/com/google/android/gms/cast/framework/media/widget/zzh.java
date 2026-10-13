package com.google.android.gms.cast.framework.media.widget;

import android.view.View;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzh implements View.OnClickListener {
    final /* synthetic */ ExpandedControllerActivity zza;

    zzh(ExpandedControllerActivity expandedControllerActivity) {
        Objects.requireNonNull(expandedControllerActivity);
        this.zza = expandedControllerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RemoteMediaClient remoteMediaClientZza;
        ExpandedControllerActivity expandedControllerActivity = this.zza;
        if (!expandedControllerActivity.zzi().isClickable() || (remoteMediaClientZza = expandedControllerActivity.zza()) == null) {
            return;
        }
        remoteMediaClientZza.skipAd();
    }
}
