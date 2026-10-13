package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.MediaStatus;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzs {
    private final int zza;

    public zzs(MediaStatus mediaStatus) {
        this.zza = mediaStatus.getPlayerState();
    }

    final /* synthetic */ int zza() {
        return this.zza;
    }
}
