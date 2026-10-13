package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
abstract class zzdc extends com.google.android.gms.cast.internal.zzc {
    private com.google.android.gms.cast.internal.zzat zza;
    protected final WeakReference zzg;
    final /* synthetic */ RemoteMediaPlayer zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdc(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        Objects.requireNonNull(remoteMediaPlayer);
        this.zzh = remoteMediaPlayer;
        this.zzg = new WeakReference(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzdb(this, status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        com.google.android.gms.cast.internal.zzx zzxVar = (com.google.android.gms.cast.internal.zzx) anyClient;
        RemoteMediaPlayer remoteMediaPlayer = this.zzh;
        synchronized (remoteMediaPlayer.zzf()) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zzg.get();
            if (googleApiClient == null) {
                setResult(new zzdb(this, new Status(2100)));
                return;
            }
            remoteMediaPlayer.zzh().zza(googleApiClient);
            try {
                try {
                    zza(zzxVar);
                } catch (IllegalArgumentException e) {
                    throw e;
                }
            } catch (Throwable unused) {
                setResult(new zzdb(this, new Status(2100)));
            }
            this.zzh.zzh().zza(null);
        }
    }

    abstract void zza(com.google.android.gms.cast.internal.zzx zzxVar) throws com.google.android.gms.cast.internal.zzap;

    protected final com.google.android.gms.cast.internal.zzat zzb() {
        if (this.zza == null) {
            this.zza = new zzda(this);
        }
        return this.zza;
    }
}
