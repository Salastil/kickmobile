package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzcf implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ zzcg zza;

    zzcf(zzcg zzcgVar) {
        Objects.requireNonNull(zzcgVar);
        this.zza = zzcgVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        zzcg zzcgVar = this.zza;
        if (z) {
            zzcgVar.zzc = true;
            this.zza.zza();
        } else {
            zzcgVar.zzc = false;
            if (this.zza.zzb()) {
                this.zza.zzb.zzc();
            }
        }
    }
}
