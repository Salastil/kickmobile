package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzev extends zzeo {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzey zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzev(zzey zzeyVar, Activity activity) {
        super(zzeyVar.zza, true);
        this.zza = activity;
        Objects.requireNonNull(zzeyVar);
        this.zzb = zzeyVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeo
    final void zza() throws RemoteException {
        ((zzcp) Preconditions.checkNotNull(this.zzb.zza.zzS())).onActivityStoppedByScionActivityInfo(zzdd.zza(this.zza), this.zzj);
    }
}
