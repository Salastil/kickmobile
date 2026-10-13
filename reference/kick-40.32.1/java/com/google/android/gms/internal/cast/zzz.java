package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final /* synthetic */ class zzz implements zzhg {
    static final /* synthetic */ zzz zza = new zzz();

    private /* synthetic */ zzz() {
    }

    @Override // com.google.android.gms.internal.cast.zzhg
    public final /* synthetic */ Object zza() {
        int i = zzaa.zzc;
        return ((CastContext) Preconditions.checkNotNull(CastContext.getSharedInstance())).getCastOptions().getReceiverApplicationId();
    }
}
