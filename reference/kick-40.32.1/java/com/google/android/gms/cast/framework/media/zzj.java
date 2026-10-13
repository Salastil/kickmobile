package com.google.android.gms.cast.framework.media;

import java.util.Objects;
import java.util.TimerTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzj extends TimerTask {
    final /* synthetic */ MediaQueue zza;

    zzj(MediaQueue mediaQueue) {
        Objects.requireNonNull(mediaQueue);
        this.zza = mediaQueue;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.zza.zzf();
    }
}
