package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwx implements AsyncCallable {
    final /* synthetic */ zzws zza;
    final /* synthetic */ AsyncCallable zzb;

    zzwx(zzws zzwsVar, AsyncCallable asyncCallable) {
        this.zza = zzwsVar;
        this.zzb = asyncCallable;
    }

    @Override // com.google.common.util.concurrent.AsyncCallable
    public final ListenableFuture call() {
        zzws zzwsVar = this.zza;
        Intrinsics.checkNotNull(zzwsVar);
        zzwq zzwqVarZzd = zzvy.zzd();
        zzws zzwsVarZzc = zzvy.zzc(zzwqVarZzd, zzwsVar);
        try {
            ListenableFuture listenableFutureCall = this.zzb.call();
            zzvy.zzc(zzwqVarZzd, zzwsVarZzc);
            Intrinsics.checkNotNullExpressionValue(listenableFutureCall, "wrapInTrace(...)");
            return listenableFutureCall;
        } catch (Throwable th) {
            try {
                zzvu.zza(th);
                throw th;
            } catch (Throwable th2) {
                zzvy.zzc(zzwqVarZzd, zzwsVarZzc);
                throw th2;
            }
        }
    }

    public final String toString() {
        AsyncCallable asyncCallable = this.zzb;
        StringBuilder sb = new StringBuilder(asyncCallable.toString().length() + 14);
        sb.append("propagating=[");
        sb.append(asyncCallable);
        sb.append("]");
        return sb.toString();
    }
}
