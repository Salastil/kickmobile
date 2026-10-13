package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.Status;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzev extends zzfa {
    final /* synthetic */ zzfb zza;
    final /* synthetic */ zzew zzb;

    zzev(zzew zzewVar, zzfb zzfbVar) {
        this.zza = zzfbVar;
        Objects.requireNonNull(zzewVar);
        this.zzb = zzewVar;
    }

    @Override // com.google.android.gms.internal.cast.zzfb
    public final void zzb(int i, ApiMetadata apiMetadata) throws RemoteException {
        zzew.zze.d("onRemoteDisplayEnded", new Object[0]);
        zzfb zzfbVar = this.zza;
        if (zzfbVar != null) {
            zzfbVar.zzb(i, apiMetadata);
        }
        zzew zzewVar = this.zzb;
        if (zzewVar.zzs() != null) {
            zzewVar.zzs().onRemoteDisplayEnded(new Status(i));
        }
    }
}
