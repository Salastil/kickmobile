package com.google.ads.interactivemedia.pal;

import com.google.android.gms.internal.pal.zzby;
import com.google.android.gms.internal.pal.zzli;
import com.google.android.gms.internal.pal.zzlo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzab implements zzlo {
    static final /* synthetic */ zzab zza = new zzab();

    private /* synthetic */ zzab() {
    }

    @Override // com.google.android.gms.internal.pal.zzlo
    public final /* synthetic */ Object zza(Object obj) {
        zzby zzbyVar = (zzby) obj;
        int i = NonceLoader.zza;
        boolean z = false;
        if (!zzbyVar.zzc() && !zzli.zzb(zzbyVar.zza(), "00000000-0000-0000-0000-000000000000")) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
