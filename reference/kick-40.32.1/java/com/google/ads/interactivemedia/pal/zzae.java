package com.google.ads.interactivemedia.pal;

import com.google.android.gms.internal.pal.zzby;
import com.google.android.gms.internal.pal.zzlo;
import com.google.android.gms.internal.pal.zznp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzae implements zzlo {
    static final /* synthetic */ zzae zza = new zzae();

    private /* synthetic */ zzae() {
    }

    @Override // com.google.android.gms.internal.pal.zzlo
    public final /* synthetic */ Object zza(Object obj) {
        zzby zzbyVar = (zzby) obj;
        int i = NonceLoader.zza;
        return zznp.zzd(zzx.ADVERTISING_ID.zza(), zzbyVar.zza(), zzx.ID_TYPE.zza(), zzbyVar.zzb(), zzx.LIMIT_AD_TRACKING.zza(), true != zzbyVar.zzc() ? "0" : "1");
    }
}
