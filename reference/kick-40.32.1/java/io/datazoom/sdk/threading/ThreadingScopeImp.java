package io.datazoom.sdk.threading;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: ThreadingScope.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/datazoom/sdk/threading/ThreadingScopeImp;", "Lio/datazoom/sdk/threading/ThreadingScope;", "<init>", "()V", "_errorsState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "errorsState", "Lkotlinx/coroutines/flow/SharedFlow;", "getErrorsState", "()Lkotlinx/coroutines/flow/SharedFlow;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ThreadingScopeImp implements ThreadingScope {
    private final MutableSharedFlow<Throwable> _errorsState = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    private final CoroutineScope coroutineScope;
    private final CoroutineExceptionHandler exceptionHandler;
    private final CompletableJob parentJob;

    public ThreadingScopeImp() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.parentJob = completableJobSupervisorJob$default;
        ThreadingScopeImp$special$$inlined$CoroutineExceptionHandler$1 threadingScopeImp$special$$inlined$CoroutineExceptionHandler$1 = new ThreadingScopeImp$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this);
        this.exceptionHandler = threadingScopeImp$special$$inlined$CoroutineExceptionHandler$1;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(SdkDispatcher.INSTANCE.getIo().plus(completableJobSupervisorJob$default).plus(threadingScopeImp$special$$inlined$CoroutineExceptionHandler$1));
    }

    @Override // io.datazoom.sdk.threading.ThreadingScope
    public CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // io.datazoom.sdk.threading.ThreadingScope
    public CoroutineDispatcher getDispatcher() {
        return SdkDispatcher.INSTANCE.getIo();
    }

    @Override // io.datazoom.sdk.threading.ThreadingScope
    public SharedFlow<Throwable> getErrorsState() {
        return this._errorsState;
    }
}
