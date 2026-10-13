package com.google.ads.interactivemedia.pal;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.internal.pal.zzlo;
import com.google.android.gms.internal.pal.zznp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzac implements zzlo {
    static final /* synthetic */ zzac zza = new zzac();

    private /* synthetic */ zzac() {
    }

    @Override // com.google.android.gms.internal.pal.zzlo
    public final /* synthetic */ Object zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        int i = NonceLoader.zza;
        return zznp.zzc(zzx.PER_VENDOR_ID.zza(), appSetIdInfo.getId(), zzx.PER_VENDOR_ID_SCOPE.zza(), String.valueOf(appSetIdInfo.getScope()));
    }
}
