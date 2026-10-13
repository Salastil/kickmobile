package io.datazoom.sdk.data.memory;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.PendingFlag;
import io.datazoom.sdk.threading.SdkDispatcher;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: FlagsPersistence.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lio/datazoom/sdk/data/memory/FlagsPersistenceImp;", "Lio/datazoom/sdk/data/memory/FlagsPersistence;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "timeoutJob", "Lkotlinx/coroutines/Job;", "flagsApplied", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lio/datazoom/sdk/model/PendingFlag;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "supervisorScope", "Lkotlinx/coroutines/CoroutineScope;", "addFlag", "", "flag", "(Lio/datazoom/sdk/model/PendingFlag;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFlag", "clearAllFlags", "getFlags", "", "isFlagApplied", "", "flagApplied", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FlagsPersistenceImp implements FlagsPersistence {
    private final CoroutineExceptionHandler exceptionHandler;
    private final MutableStateFlow<Set<PendingFlag>> flagsApplied;
    private final CoroutineScope supervisorScope;
    private volatile Job timeoutJob;

    /* JADX WARN: Multi-variable type inference failed */
    public FlagsPersistenceImp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public FlagsPersistenceImp(CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.flagsApplied = StateFlowKt.MutableStateFlow(SetsKt.setOf(PendingFlag.CONFIG.INSTANCE));
        FlagsPersistenceImp$special$$inlined$CoroutineExceptionHandler$1 flagsPersistenceImp$special$$inlined$CoroutineExceptionHandler$1 = new FlagsPersistenceImp$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
        this.exceptionHandler = flagsPersistenceImp$special$$inlined$CoroutineExceptionHandler$1;
        this.supervisorScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(dispatcher).plus(flagsPersistenceImp$special$$inlined$CoroutineExceptionHandler$1));
    }

    public /* synthetic */ FlagsPersistenceImp(CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SdkDispatcher.INSTANCE.getIo() : coroutineDispatcher);
    }

    @Override // io.datazoom.sdk.data.memory.FlagsPersistence
    public Object addFlag(PendingFlag pendingFlag, Continuation<? super Unit> continuation) {
        Set<PendingFlag> value;
        MutableStateFlow<Set<PendingFlag>> mutableStateFlow = this.flagsApplied;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SetsKt.plus(value, pendingFlag)));
        if (pendingFlag.isSoftFlag()) {
            this.timeoutJob = BuildersKt__Builders_commonKt.launch$default(this.supervisorScope, null, null, new AnonymousClass3(pendingFlag, this, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.data.memory.FlagsPersistenceImp$addFlag$3, reason: invalid class name */
    /* JADX INFO: compiled from: FlagsPersistence.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.datazoom.sdk.data.memory.FlagsPersistenceImp$addFlag$3", f = "FlagsPersistence.kt", i = {0}, l = {52}, m = "invokeSuspend", n = {"$this$launch"}, nl = {53}, s = {"L$0"}, v = 2)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PendingFlag $flag;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FlagsPersistenceImp this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PendingFlag pendingFlag, FlagsPersistenceImp flagsPersistenceImp, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$flag = pendingFlag;
            this.this$0 = flagsPersistenceImp;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$flag, this.this$0, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.label = 1;
                if (DelayKt.delay(this.$flag.getSoftFlagTimeout(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.removeFlag(this.$flag);
            return Unit.INSTANCE;
        }
    }

    @Override // io.datazoom.sdk.data.memory.FlagsPersistence
    public void removeFlag(PendingFlag flag) {
        Set<PendingFlag> value;
        Intrinsics.checkNotNullParameter(flag, "flag");
        MutableStateFlow<Set<PendingFlag>> mutableStateFlow = this.flagsApplied;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SetsKt.minus(value, flag)));
    }

    @Override // io.datazoom.sdk.data.memory.FlagsPersistence
    public void clearAllFlags() {
        Job job = this.timeoutJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        MutableStateFlow<Set<PendingFlag>> mutableStateFlow = this.flagsApplied;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), SetsKt.emptySet())) {
        }
    }

    @Override // io.datazoom.sdk.data.memory.FlagsPersistence
    public List<PendingFlag> getFlags() {
        return CollectionsKt.toList(this.flagsApplied.getValue());
    }

    @Override // io.datazoom.sdk.data.memory.FlagsPersistence
    public boolean isFlagApplied(PendingFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        return this.flagsApplied.getValue().contains(flag);
    }

    @Override // io.datazoom.sdk.data.memory.FlagsPersistence
    public boolean flagApplied() {
        return !this.flagsApplied.getValue().isEmpty();
    }
}
