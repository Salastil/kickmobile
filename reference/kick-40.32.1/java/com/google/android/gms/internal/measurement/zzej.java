package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzej extends zzeo {
    final /* synthetic */ zzep zza;
    final /* synthetic */ zzez zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzej(zzez zzezVar, zzep zzepVar) {
        super(zzezVar, true);
        this.zza = zzepVar;
        Objects.requireNonNull(zzezVar);
        this.zzb = zzezVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeo
    final void zza() throws RemoteException {
        ((zzcp) Preconditions.checkNotNull(this.zzb.zzS())).setEventInterceptor(this.zza);
    }
}
