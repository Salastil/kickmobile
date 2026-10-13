package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzi implements Runnable {
    final /* synthetic */ RemoteMediaClient zza;
    final /* synthetic */ zzj zzb;

    zzi(zzj zzjVar, RemoteMediaClient remoteMediaClient) {
        this.zza = remoteMediaClient;
        Objects.requireNonNull(zzjVar);
        this.zzb = zzjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zze(this.zza);
    }
}
