package com.google.android.gms.cast.framework.media;

import java.util.Objects;
import java.util.TimerTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzbf extends TimerTask {
    final /* synthetic */ zzbg zza;

    zzbf(zzbg zzbgVar) {
        Objects.requireNonNull(zzbgVar);
        this.zza = zzbgVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        zzbg zzbgVar = this.zza;
        RemoteMediaClient remoteMediaClient = zzbgVar.zza;
        remoteMediaClient.zzo(zzbgVar.zzh());
        remoteMediaClient.zzs().postDelayed(this, zzbgVar.zzi());
    }
}
