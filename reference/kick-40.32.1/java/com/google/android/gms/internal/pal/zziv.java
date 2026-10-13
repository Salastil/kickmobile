package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zziv extends GoogleApi implements zziq {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzis zzisVar = new zzis();
        zzb = zzisVar;
        zzc = new Api("SignalSdk.API", zzisVar, clientKey);
    }

    public zziv(Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.internal.pal.zziq
    public final Task zza(final Bundle bundle) {
        return doRead(TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(zzlf.zza).run(new RemoteCall() { // from class: com.google.android.gms.internal.pal.zziu
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzip) ((zziw) obj).getService()).zze(bundle, new zzit(this.zza, (TaskCompletionSource) obj2));
            }
        }).build());
    }
}
