package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final /* synthetic */ class zzlp implements Supplier {
    static final /* synthetic */ zzlp zza = new zzlp();

    private /* synthetic */ zzlp() {
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ Object get() {
        int i = zzlk.zza;
        return MoreExecutors.listeningDecorator(Executors.newSingleThreadScheduledExecutor(zzlo.zza));
    }
}
