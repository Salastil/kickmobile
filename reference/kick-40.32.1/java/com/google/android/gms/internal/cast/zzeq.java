package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.Status;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeq extends zzeo {
    final /* synthetic */ zzer zza;

    protected zzeq(zzer zzerVar) {
        Objects.requireNonNull(zzerVar);
        this.zza = zzerVar;
    }

    @Override // com.google.android.gms.internal.cast.zzeo, com.google.android.gms.internal.cast.zzey
    public final void zzd(int i, ApiMetadata apiMetadata) throws RemoteException {
        int i2 = zzet.zza;
        zzet.zzb.d("onError: %d", Integer.valueOf(i));
        zzer zzerVar = this.zza;
        zzerVar.zzc.zza();
        zzerVar.setResult(new zzes(Status.RESULT_INTERNAL_ERROR));
    }

    @Override // com.google.android.gms.internal.cast.zzeo, com.google.android.gms.internal.cast.zzey
    public final void zzf(ApiMetadata apiMetadata) throws RemoteException {
        zzet.zzb.d("onDisconnected", new Object[0]);
        zzer zzerVar = this.zza;
        zzerVar.zzc.zza();
        zzerVar.setResult(new zzes(Status.RESULT_SUCCESS));
    }
}
