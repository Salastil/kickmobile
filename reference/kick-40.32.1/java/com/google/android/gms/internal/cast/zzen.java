package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzen extends zzer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzen(zzet zzetVar, GoogleApiClient googleApiClient) {
        super(zzetVar, googleApiClient);
        Objects.requireNonNull(zzetVar);
    }

    @Override // com.google.android.gms.internal.cast.zzer, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        doExecute((zzew) anyClient);
    }

    @Override // com.google.android.gms.internal.cast.zzer
    /* JADX INFO: renamed from: zza */
    public final void doExecute(zzew zzewVar) throws RemoteException {
        zzewVar.zzq(new zzeq(this));
    }
}
