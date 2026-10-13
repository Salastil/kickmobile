package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzq extends RemoteMediaClient.Callback {
    final /* synthetic */ CastSession zza;

    zzq(CastSession castSession) {
        Objects.requireNonNull(castSession);
        this.zza = castSession;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void onStatusUpdated() {
        CastSession castSession = this.zza;
        MediaStatus mediaStatus = castSession.zzk() != null ? castSession.zzk().getMediaStatus() : null;
        if (castSession.zzl() != null) {
            castSession.zzl().zzc(mediaStatus);
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zza(String str, long j, int i, long j2, long j3) {
        CastSession castSession = this.zza;
        if (castSession.zzl() != null) {
            castSession.zzl().zzb(str, j, i, j2, j3);
        }
    }
}
