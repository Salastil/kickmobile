package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzwy implements AsyncFunction {
    final /* synthetic */ zzws zza;
    final /* synthetic */ AsyncFunction zzb;

    zzwy(zzws zzwsVar, AsyncFunction asyncFunction) {
        this.zza = zzwsVar;
        this.zzb = asyncFunction;
    }

    @Override // com.google.common.util.concurrent.AsyncFunction
    public final ListenableFuture apply(Object obj) {
        zzws zzwsVar = this.zza;
        Intrinsics.checkNotNull(zzwsVar);
        zzwq zzwqVarZzd = zzvy.zzd();
        zzws zzwsVarZzc = zzvy.zzc(zzwqVarZzd, zzwsVar);
        try {
            ListenableFuture listenableFutureApply = this.zzb.apply(obj);
            if (listenableFutureApply == null) {
                throw new IllegalStateException("AsyncFunction should return a ListenableFuture instead of null.");
            }
            zzvy.zzc(zzwqVarZzd, zzwsVarZzc);
            return listenableFutureApply;
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
        AsyncFunction asyncFunction = this.zzb;
        StringBuilder sb = new StringBuilder(asyncFunction.toString().length() + 14);
        sb.append("propagating=[");
        sb.append(asyncFunction);
        sb.append("]");
        return sb.toString();
    }
}
