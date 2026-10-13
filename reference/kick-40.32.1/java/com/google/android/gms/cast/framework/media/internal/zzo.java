package com.google.android.gms.cast.framework.media.internal;

import android.graphics.Bitmap;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzo implements zza {
    final /* synthetic */ zzs zza;

    zzo(zzs zzsVar) {
        Objects.requireNonNull(zzsVar);
        this.zza = zzsVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        this.zza.zze(bitmap, 3);
    }
}
