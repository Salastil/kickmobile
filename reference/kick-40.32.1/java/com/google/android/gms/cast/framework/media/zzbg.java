package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzbg {
    final /* synthetic */ RemoteMediaClient zza;
    private final Set zzb;
    private final long zzc;
    private final Runnable zzd;
    private boolean zze;

    public zzbg(RemoteMediaClient remoteMediaClient, long j) {
        Objects.requireNonNull(remoteMediaClient);
        this.zza = remoteMediaClient;
        this.zzb = new HashSet();
        this.zzc = j;
        this.zzd = new zzbf(this);
    }

    public final long zza() {
        return this.zzc;
    }

    public final void zzb(RemoteMediaClient.ProgressListener progressListener) {
        this.zzb.add(progressListener);
    }

    public final void zzc(RemoteMediaClient.ProgressListener progressListener) {
        this.zzb.remove(progressListener);
    }

    public final boolean zzd() {
        return !this.zzb.isEmpty();
    }

    public final void zze() {
        RemoteMediaClient remoteMediaClient = this.zza;
        Handler handlerZzs = remoteMediaClient.zzs();
        Runnable runnable = this.zzd;
        handlerZzs.removeCallbacks(runnable);
        this.zze = true;
        remoteMediaClient.zzs().postDelayed(runnable, this.zzc);
    }

    public final void zzf() {
        this.zza.zzs().removeCallbacks(this.zzd);
        this.zze = false;
    }

    public final boolean zzg() {
        return this.zze;
    }

    final /* synthetic */ Set zzh() {
        return this.zzb;
    }

    final /* synthetic */ long zzi() {
        return this.zzc;
    }
}
