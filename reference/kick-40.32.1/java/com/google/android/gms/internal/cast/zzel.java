package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.ApiMetadata;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzel extends zzfa {
    final /* synthetic */ zzet zza;

    zzel(zzet zzetVar) {
        Objects.requireNonNull(zzetVar);
        this.zza = zzetVar;
    }

    @Override // com.google.android.gms.internal.cast.zzfb
    public final void zzb(int i, ApiMetadata apiMetadata) {
        zzet.zzb.d("onRemoteDisplayEnded", new Object[0]);
        this.zza.zza();
    }
}
