package com.amazon.mediatailorsdk.threading;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: ThreadingScope.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/amazon/mediatailorsdk/threading/ThreadingScopeImp;", "Lcom/amazon/mediatailorsdk/threading/ThreadingScope;", "<init>", "()V", "_errorsState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "errorsState", "Lkotlinx/coroutines/flow/SharedFlow;", "getErrorsState", "()Lkotlinx/coroutines/flow/SharedFlow;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ThreadingScopeImp implements ThreadingScope {
    private final MutableSharedFlow<Throwable> _errorsState = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    private final CompletableJob parentJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    private final CoroutineExceptionHandler exceptionHandler = new ThreadingScopeImp$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this);
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(getCoroutineContext());

    private final CoroutineContext getCoroutineContext() {
        return this.parentJob.plus(this.exceptionHandler);
    }

    @Override // com.amazon.mediatailorsdk.threading.ThreadingScope
    public CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // com.amazon.mediatailorsdk.threading.ThreadingScope
    public SharedFlow<Throwable> getErrorsState() {
        return this._errorsState;
    }
}
