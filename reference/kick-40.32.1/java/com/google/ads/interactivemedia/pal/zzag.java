package com.google.ads.interactivemedia.pal;

import com.google.android.gms.internal.pal.zzlo;
import com.google.android.gms.internal.pal.zznp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzag implements zzlo {
    static final /* synthetic */ zzag zza = new zzag();

    private /* synthetic */ zzag() {
    }

    @Override // com.google.android.gms.internal.pal.zzlo
    public final /* synthetic */ Object zza(Object obj) {
        int i = NonceLoader.zza;
        return zznp.zzb(zzx.ADS_IDENTITY_TOKEN.zza(), (String) obj);
    }
}
