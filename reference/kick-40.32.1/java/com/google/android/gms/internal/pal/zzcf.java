package com.google.android.gms.internal.pal;

import android.os.Handler;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcf extends zzci {
    public zzcf(Handler handler, ExecutorService executorService) {
        super(handler, executorService, zzck.zza(86400000L));
    }

    @Override // com.google.android.gms.internal.pal.zzci
    final zzlq zza() {
        return zzlq.zze();
    }
}
