package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzdb implements RemoteMediaPlayer.MediaChannelResult {
    final /* synthetic */ Status zza;

    zzdb(zzdc zzdcVar, Status status) {
        this.zza = status;
        Objects.requireNonNull(zzdcVar);
    }

    @Override // com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult
    public final JSONObject getCustomData() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
