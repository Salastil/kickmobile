package com.google.android.gms.cast.framework.media;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzak extends zzbc {
    final /* synthetic */ RemoteMediaClient zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzak(RemoteMediaClient remoteMediaClient, boolean z) {
        super(remoteMediaClient, true);
        Objects.requireNonNull(remoteMediaClient);
        this.zza = remoteMediaClient;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbc
    protected final void zza() throws com.google.android.gms.cast.internal.zzap {
        this.zza.zzt().zzH(zzb());
    }
}
