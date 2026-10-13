package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzek extends zzeo {
    final /* synthetic */ Intent zza;
    final /* synthetic */ zzez zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzek(zzez zzezVar, Intent intent) {
        super(zzezVar, true);
        this.zza = intent;
        Objects.requireNonNull(zzezVar);
        this.zzb = zzezVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeo
    final void zza() throws RemoteException {
        ((zzcp) Preconditions.checkNotNull(this.zzb.zzS())).setSgtmDebugInfo(this.zza);
    }
}
