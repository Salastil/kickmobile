package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzax implements com.google.android.gms.cast.internal.zzas {
    final /* synthetic */ RemoteMediaClient zza;
    private com.google.android.gms.cast.zzq zzb;
    private final AtomicLong zzc;

    public zzax(RemoteMediaClient remoteMediaClient) {
        Objects.requireNonNull(remoteMediaClient);
        this.zza = remoteMediaClient;
        this.zzc = new AtomicLong((CastUtils.zzb() & WebSocketProtocol.PAYLOAD_SHORT_MAX) * 10000);
    }

    public final void zza(com.google.android.gms.cast.zzq zzqVar) {
        this.zzb = zzqVar;
    }

    @Override // com.google.android.gms.cast.internal.zzas
    public final void zzb(String str, String str2, final long j, String str3) {
        com.google.android.gms.cast.zzq zzqVar = this.zzb;
        if (zzqVar == null) {
            throw new IllegalStateException("Device is not connected");
        }
        zzqVar.zzf(str, str2).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.cast.framework.media.zzaw
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final /* synthetic */ void onFailure(Exception exc) {
                this.zza.zza.zzt().zzN(j, exc instanceof ApiException ? ((ApiException) exc).getStatusCode() : 13);
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzas
    public final long zzc() {
        return this.zzc.getAndIncrement();
    }
}
