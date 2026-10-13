package com.google.android.gms.cast.framework.media;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzbc extends BasePendingResult {
    private com.google.android.gms.cast.internal.zzat zza;
    private final boolean zzb;
    final /* synthetic */ RemoteMediaClient zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbc(RemoteMediaClient remoteMediaClient, boolean z) {
        super((GoogleApiClient) null);
        Objects.requireNonNull(remoteMediaClient);
        this.zzg = remoteMediaClient;
        this.zzb = z;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzbb(this, status);
    }

    abstract void zza() throws com.google.android.gms.cast.internal.zzap;

    final com.google.android.gms.cast.internal.zzat zzb() {
        if (this.zza == null) {
            this.zza = new zzba(this);
        }
        return this.zza;
    }

    public final void zzc() {
        if (!this.zzb) {
            RemoteMediaClient remoteMediaClient = this.zzg;
            Iterator it = remoteMediaClient.zzu().iterator();
            while (it.hasNext()) {
                ((RemoteMediaClient.Listener) it.next()).onSendingRemoteMediaRequest();
            }
            Iterator it2 = remoteMediaClient.zzv().iterator();
            while (it2.hasNext()) {
                ((RemoteMediaClient.Callback) it2.next()).onSendingRemoteMediaRequest();
            }
        }
        try {
            synchronized (this.zzg.zzr()) {
                zza();
            }
        } catch (com.google.android.gms.cast.internal.zzap unused) {
            setResult(new zzbb(this, new Status(2100)));
        }
    }
}
