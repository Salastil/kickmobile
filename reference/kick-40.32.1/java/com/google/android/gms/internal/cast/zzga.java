package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzga {

    @Deprecated
    public static final Api zza;
    private static final Api.ClientKey zzb;
    private static final Api.AbstractClientBuilder zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzb = clientKey;
        zzfy zzfyVar = new zzfy();
        zzc = zzfyVar;
        zza = new Api("UsageReporting.API", zzfyVar, clientKey);
    }
}
