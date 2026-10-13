package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzdr extends UIController {
    private boolean zza = true;

    public abstract void zza(long j);

    public void zzb(boolean z) {
        this.zza = z;
    }

    public final boolean zzc() {
        return this.zza;
    }
}
