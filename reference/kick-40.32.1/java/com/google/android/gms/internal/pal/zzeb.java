package com.google.android.gms.internal.pal;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeb {
    private final zzuh zza;

    public zzeb(final Context context, Executor executor) {
        this.zza = zztz.zzb(new Callable(this) { // from class: com.google.android.gms.internal.pal.zzea
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                Context context2 = context;
                try {
                    return zzjj.zza(context2, context2.getPackageName(), Integer.toString(context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode));
                } catch (Throwable unused) {
                    return null;
                }
            }
        }, executor);
    }

    public final zzuh zza() {
        return this.zza;
    }
}
