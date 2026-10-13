package com.google.android.gms.internal.measurement;

import com.google.common.base.Function;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ExecutionSequencer;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
class zzut {
    private final String zza;
    private final ListenableFuture zzb;
    private final zzuv zzc;
    private final zzvm zze;
    private final zzvm zzf = new zzvm(new zzul(this, null), MoreExecutors.directExecutor());
    private final Object zzg = new Object();
    private List zzi = new ArrayList();
    private final ExecutionSequencer zzd = ExecutionSequencer.create();
    private final zzwb zzh = zzwb.zzb();

    zzut(zzuv zzuvVar, zzvc zzvcVar, ListenableFuture listenableFuture, boolean z, String str) {
        this.zzc = zzuvVar;
        this.zzb = listenableFuture;
        this.zza = zzuvVar.zzc();
        final zzui zzuiVar = (zzui) zzuvVar;
        this.zze = new zzvm(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzuh
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final /* synthetic */ ListenableFuture call() {
                return zzuiVar.zzd();
            }
        }, MoreExecutors.directExecutor());
        zza(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzuq
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.zza.zzc((zzth) obj);
            }
        });
    }

    public final void zza(AsyncFunction asyncFunction) {
        synchronized (this.zzg) {
            this.zzi.add(asyncFunction);
        }
    }

    public final ListenableFuture zzb(final Function function, final Executor executor) {
        final AsyncFunction asyncFunctionZzc = zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzuo
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return Futures.immediateFuture(function.apply(obj));
            }
        });
        Stopwatch.createStarted(zzxh.zza());
        String str = this.zza;
        String.valueOf(str);
        zzwi zzwiVarZza = this.zzh.zza("Update ".concat(String.valueOf(str)), zzxd.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        try {
            final ListenableFuture listenableFutureZza = this.zzf.zza();
            ExecutionSequencer executionSequencer = this.zzd;
            executionSequencer.submitAsync(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzum
                @Override // com.google.common.util.concurrent.AsyncCallable
                public final /* synthetic */ ListenableFuture call() {
                    return listenableFutureZza;
                }
            }, MoreExecutors.directExecutor());
            ListenableFuture listenableFutureSubmitAsync = executionSequencer.submitAsync(zzxa.zzb(new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzun
                @Override // com.google.common.util.concurrent.AsyncCallable
                public final /* synthetic */ ListenableFuture call() {
                    final zzut zzutVar = this.zza;
                    final AsyncFunction asyncFunction = asyncFunctionZzc;
                    final Executor executor2 = executor;
                    return Futures.transformAsync(listenableFutureZza, zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzup
                        @Override // com.google.common.util.concurrent.AsyncFunction
                        public final /* synthetic */ ListenableFuture apply(Object obj) {
                            return zzutVar.zzd(asyncFunction, executor2, obj);
                        }
                    }), MoreExecutors.directExecutor());
                }
            }), MoreExecutors.directExecutor());
            Futures.propagateCancellation(listenableFutureSubmitAsync, listenableFutureZza);
            Futures.nonCancellationPropagating(this.zzb);
            ListenableFuture listenableFutureZza2 = zzuy.zza(listenableFutureSubmitAsync);
            zzwiVarZza.zza(listenableFutureZza2);
            zzwiVarZza.close();
            return listenableFutureZza2;
        } catch (Throwable th) {
            try {
                zzwiVarZza.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    final /* synthetic */ ListenableFuture zzc(zzth zzthVar) {
        return this.zze.zza();
    }

    final /* synthetic */ ListenableFuture zzd(AsyncFunction asyncFunction, Executor executor, Object obj) {
        return this.zzc.zzb(asyncFunction, executor, null);
    }

    final /* synthetic */ String zze() {
        return this.zza;
    }

    final /* synthetic */ zzuv zzf() {
        return this.zzc;
    }

    final /* synthetic */ zzvm zzg() {
        return this.zze;
    }

    final /* synthetic */ Object zzh() {
        return this.zzg;
    }

    final /* synthetic */ zzwb zzi() {
        return this.zzh;
    }

    final /* synthetic */ List zzj() {
        return this.zzi;
    }

    final /* synthetic */ void zzk(List list) {
        this.zzi = list;
    }
}
