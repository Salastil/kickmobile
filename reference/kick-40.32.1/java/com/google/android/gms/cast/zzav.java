package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.cast.zzff;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final /* synthetic */ class zzav implements RemoteCall {
    static final /* synthetic */ zzav zza = new zzav();

    private /* synthetic */ zzav() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        com.google.android.gms.cast.internal.zzy zzyVar = (com.google.android.gms.cast.internal.zzy) obj;
        int i = zzbm.zzf;
        ((com.google.android.gms.cast.internal.zzah) zzyVar.getService()).zzh(zzff.zza(zzyVar.getContext()));
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
